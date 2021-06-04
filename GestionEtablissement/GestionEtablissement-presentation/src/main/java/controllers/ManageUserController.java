package controllers;

import com.google.protobuf.TextFormat;
import eu.ensup.gestionetablissement.service.ConnectionService;
import eu.ensup.gestionetablissement.service.ExceptionService;
import eu.ensup.gestionetablissement.service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.parseInt;

@WebServlet("/ManageUserController")
public class ManageUserController extends HttpServlet {

    public ManageUserController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher dispatcher;


        switch(req.getParameter("action")) {
            case "add":
                if (req.getParameter("name") == "" || req.getParameter("firstname") == "" || req.getParameter("birthday") == "" || req.getParameter("mail") == "" || req.getParameter("address") == "" || req.getParameter("phone") == "" || req.getParameter("password") == "") {
                    req.setAttribute("error", "Un des champs est vide");
                } else {
                    //If nb hours is not numeric return msgbox
                    try {
                        //Create course with parameters
                        PersonService sp = new PersonService();
                        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                        Date auj = sdf.parse(req.getParameter("birthday").toString());
                        sp.create(req.getParameter("name"), req.getParameter("mail"), req.getParameter("address"), req.getParameter("phone"), req.getParameter("firstname"), req.getParameter("password"), 4, auj ,"");
                        req.setAttribute("success", "L'étudiant à bien été crée");
                    } catch (NumberFormatException | ParseException nfe) {
                        req.setAttribute("error", "Un des paramètres à pas a été renseigné");
                    } catch (ExceptionService es) {
                        req.setAttribute("error", es.getMessage());
                    }
                }
                dispatcher= req.getRequestDispatcher("createStudent.jsp");
                dispatcher.forward(req, resp);
                break;
            case "update":
                if (req.getParameter("name") == "" || req.getParameter("firstname") == "" || req.getParameter("birthday") == "" || req.getParameter("mail") == "" || req.getParameter("address") == "" || req.getParameter("phone") == "" || req.getParameter("password") == "" || req.getParameter("average") == "") {
                    req.setAttribute("error", "Un des champs est vide");
                } else {
                    try {
                        //Create course with parameters
                        PersonService sp = new PersonService();
                        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                        Date auj = sdf.parse(req.getParameter("birthday"));
                        sp.update(req.getParameter("name"), req.getParameter("mail"), req.getParameter("address"), req.getParameter("phone"), req.getParameter("firstname"), req.getParameter("password"), 4, auj ,"", Double.parseDouble(req.getParameter("average")));
                        req.setAttribute("success", "Les informations de l'étudiant ont bien été modifié");
                    } catch (NumberFormatException | ParseException nfe) {
                        req.setAttribute("error", "Un des paramètres n'a pas été renseigné");
                    } catch (ExceptionService es) {
                        req.setAttribute("error", es.getMessage());
                    }

                }
                dispatcher= req.getRequestDispatcher("listStudents.jsp");
                dispatcher.forward(req, resp);
                break;
            case "delete":
                PersonService ps = new PersonService();
                try {
                    ps.delete(parseInt(req.getParameter("id")));
                    req.setAttribute("success", "L'étudiant à bien été supprimer");
                } catch (ExceptionService es) {
                    req.setAttribute("error", es.getMessage());
                }
                dispatcher= req.getRequestDispatcher("listStudents.jsp");
                dispatcher.forward(req, resp);
                break;
            default:
                // code block
        }

        //Récupération des info du formulaire
        /*String login = req.getParameter("login");
        String pwd = req.getParameter("pwd");

        System.out.println(login);
        System.out.println(pwd);

        //Traitement des infos
        RequestDispatcher dispatcher;
        ConnectionService cs = new ConnectionService();
        try {
            int test = cs.checkConnection(login, pwd);
            System.out.println(test);
            dispatcher= req.getRequestDispatcher("accueil.jspjsp");
        } catch (ExceptionService exceptionService) {
            exceptionService.printStackTrace();
            dispatcher= req.getRequestDispatcher("index.jsp");
        }
        //Redirection
        dispatcher.forward(req, resp);*/
    }
}
