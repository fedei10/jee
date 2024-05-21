package mvcController;

import jakarta.ejb.EJB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import entities.Newsletter;
import mvcServices.CreateurServices;

@WebServlet("/GererN")
public class GererN extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private CreateurServices createurServices;

    public GererN() {
        super();
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doPost(request,response);

    	
    	
    
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if the user is logged in

    	

        // Retrieve form parameters
        String titre = request.getParameter("titre");
        String categorie = request.getParameter("categorie");
        String contenu = request.getParameter("contenu");
        String image = request.getParameter("image");

        // Create a new Newsletter object
        Newsletter newsletter = new Newsletter();
        newsletter.setTitre(titre);
        newsletter.setCategorie(categorie);
        newsletter.setContenu(contenu);
        newsletter.setImage(image);
        newsletter.setDateEnvoi(new Date()); // Set current date
       
        

        try {
            // Use the entity manager to persist the newsletter
            entityManager.persist(newsletter);
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle database error
            response.sendRedirect("error.jsp");
        }
    }
}
