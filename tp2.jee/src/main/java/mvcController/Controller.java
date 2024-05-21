package mvcController;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcModel.SubjectService;

import java.io.IOException;
import java.util.List;

import entities.Subject;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @EJB
    private SubjectService subjectService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Subject> subjects = subjectService.getAllSujects();
            for (Subject subject : subjects) {
                String subjectInfo = "Matière: " + subject.getSubjectTitle() + ", Enseignant: " + subject.getTeacher();
                response.getWriter().println(subjectInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Erreur lors de la récupération des matières: " + e.getMessage());
        }
    }
}
