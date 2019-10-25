package pages;

import main.colis.Colis;
import main.ColisEJB;
import main.localisation.Localisation;
import main.suivi.Suivi;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/enregistrement")
public class PageEnregistrement extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private ColisEJB colisEJB;

    public PageEnregistrement() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/enregistrement/formEnregistrement.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float prix = Float.parseFloat(req.getParameter("prix"));
        float poids = Float.parseFloat(req.getParameter("poids"));

        float lattitudeO = Float.parseFloat(req.getParameter("lattitudeO"));
        float longitudeO = Float.parseFloat(req.getParameter("longitudeO"));
        String emplacementO = req.getParameter("emplacementO");

        float lattitudeD = Float.parseFloat(req.getParameter("lattitudeD"));
        float longitudeD = Float.parseFloat(req.getParameter("longitudeD"));
        String emplacementD = req.getParameter("emplacementD");

        Localisation origine = colisEJB.addLocalisation(longitudeO, lattitudeO, emplacementO);
        Localisation destination = colisEJB.addLocalisation(longitudeD, lattitudeD, emplacementD);
        Suivi suivi = colisEJB.addSuivi(origine);
        Colis colis = colisEJB.addColis(poids, prix, origine, destination, suivi);

        req.setAttribute("colis", colis);
        req.getRequestDispatcher("/enregistrement/confirmationEnregistrement.jsp").forward(req, resp);

        resp.getWriter().append("Colis enregistré").append(String.valueOf(colis.getId()));
    }
}
