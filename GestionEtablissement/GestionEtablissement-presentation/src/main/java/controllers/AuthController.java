package controllers;

import eu.ensup.gestionetablissement.service.ConnectionService;
import eu.ensup.gestionetablissement.service.ExceptionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AuthController")
public class AuthController extends HttpServlet {

    public AuthController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Récupération des info du formulaire
        String login = req.getParameter("login");
        String pwd = req.getParameter("pwd");

        //Traitement des infos
        RequestDispatcher dispatcher;
        HttpSession session = req.getSession();
        ConnectionService cs = new ConnectionService();
        try {
            int test = cs.checkConnection(login, pwd);
            dispatcher= req.getRequestDispatcher("accueil.jsp");
        } catch (ExceptionService exceptionService) {
            req.setAttribute("error", "Identifiant ou mot de passe incorrect");
            dispatcher= req.getRequestDispatcher("index.jsp");
        }
        //Redirection
        dispatcher.forward(req, resp);
    }
}
