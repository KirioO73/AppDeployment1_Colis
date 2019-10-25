package pages;

import main.colis.Colis;
import main.ColisEJB;
import main.localisation.Localisation;
import main.suivi.ColisEtat;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/progression")
public class PageProgression extends HttpServlet {

    @EJB
    private ColisEJB colisEJB;

    public PageProgression() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long colisId = Long.parseLong(req.getParameter("colisId"));
        Colis colis = colisEJB.findColis(colisId);

        req.setAttribute("colis", colis);
        req.getRequestDispatcher("/progression/formProgression.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float lattitudeP = Float.parseFloat(req.getParameter("lattitudeP"));
        float longitudeP = Float.parseFloat(req.getParameter("longitudeP"));
        String emplacementP = req.getParameter("emplacementP");

        ColisEtat newState;
        switch (req.getParameter("etat")){
            case "PREPARE":
                newState = ColisEtat.PREPARE;
                break;
            case "EXPEDIER":
                newState = ColisEtat.EXPEDIE;
                break;
            case "POINT RELAI":
                newState = ColisEtat.POINT_RELAI;
                break;
            case "EN LIVRAISON":
                newState = ColisEtat.EN_LIVRAISON;
                break;
            case "LIVRE":
                newState = ColisEtat.LIVRE;
                break;
            default:
                newState= ColisEtat.ENREGISTRE;
        }

        long colisId = Long.parseLong(req.getParameter("colisId"));
        Colis colis = colisEJB.findColis(colisId);
        Localisation position = colisEJB.addLocalisation(longitudeP, lattitudeP, emplacementP);
        colisEJB.alterStateSuivi(colis.getSuivi().getId(), newState);

        req.setAttribute("colis", colis);
        req.getRequestDispatcher("/progression").forward(req, resp);
    }
}
