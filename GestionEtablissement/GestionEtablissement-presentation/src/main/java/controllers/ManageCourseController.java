package controllers;

import eu.ensup.gestionetablissement.dto.CourseDTO;
import eu.ensup.gestionetablissement.service.CourseService;
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

@WebServlet("/ManageCourseController")
public class ManageCourseController extends HttpServlet {

    public ManageCourseController() {
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
                if (req.getParameter("course") == "" || req.getParameter("hour") == "") {
                    req.setAttribute("error", "Un des champs est vide");
                } else {
                    try {
                        float f = Float.parseFloat(req.getParameter("hour"));

                        //Create course with parameters
                        CourseService cs = new CourseService();
                        CourseDTO c = new CourseDTO(req.getParameter("course"), f);
                        cs.create(c);
                        req.setAttribute("success", "Le cour à bien été crée");
                    } catch (Exception e) {
                        req.setAttribute("error", "Une erreur est survenu, le cour n'a pas été crée");
                    }
                }
                dispatcher= req.getRequestDispatcher("manageCourses.jsp");
                dispatcher.forward(req, resp);
                break;
            case "associate":
                int idCourse = Integer.parseInt(req.getParameter("id_course"));
                int idStudent = Integer.parseInt(req.getParameter("id_student"));

                PersonService ps = new PersonService();
                try {
                    ps.linkToCourse(idStudent, idCourse);
                    req.setAttribute("success", "Le cour à bien été associé à l'étudiant");
                } catch (ExceptionService es) {
                    req.setAttribute("success", "Le cour à bien été associé à l'étudiant");
                }
                dispatcher= req.getRequestDispatcher("manageCourses.jsp");
                dispatcher.forward(req, resp);
                break;
            case "delete":

                break;
            default:
                // code block
        }
    }
}
