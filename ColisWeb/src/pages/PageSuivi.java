package pages;

import main.colis.Colis;
import main.ColisEJB;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/suivi")
public class PageSuivi extends HttpServlet {

    @EJB
    private ColisEJB colisEJB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long colisId = Long.parseLong(req.getParameter("colisId"));
        Colis colis = colisEJB.findColis(colisId);

        req.setAttribute("colis", colis);
        req.getRequestDispatcher("/suivi/suivi.jsp").forward(req, resp);
    }
}
