 package mvcController;

import jakarta.ejb.EJB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvcServices.CreateurServices;
import mvsServices.NewslettersServices;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import entities.CreateurContenu;
import entities.Newsletter;

@WebServlet("/")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    @EJB
    private CreateurServices createurServices;


    @EJB
    private NewslettersServices newslettersServices;

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(); // Initialize session here

        //login
        String btn = request.getParameter("myBtn");
        if (btn != null && btn.equals("login")) {
            String login = request.getParameter("user");
            String password = request.getParameter("pwd");

            // Assuming createurServices is properly initialized
            CreateurContenu createur = createurServices.getCreatorByloginAndPassword(login, password);
            
            if (createur != null) {

            	List<Newsletter>newsletters=newslettersServices.getNewsletterById(createur.getId());
                request.setAttribute("newsletters", newsletters);
                session.setAttribute("createur", createur);
                request.setAttribute("createur", createur);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else {
                request.setAttribute("message", "Invalid login credentials");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    

    
    }
    
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Call doGet to handle both GET and POST requests

        //sign
        String btn = request.getParameter("btn2");
        if (btn != null && btn.equals("Signup")) {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String adresse_mail = request.getParameter("adresse_mail");
            String nom_utilisateur = request.getParameter("nom_utilisateur");
            String password = request.getParameter("mot_de_passe");

            CreateurContenu createur = new CreateurContenu();
            createur.setNomUtilisateur(nom_utilisateur);
            createur.setAdresseMail(adresse_mail);
            createur.setMotDePasse(password);
            createur.setNom(nom);
            createur.setPrenom(prenom);
            createurServices.addcreateur(createur);
            response.sendRedirect("conf.jsp");
        }
        

        btn = request.getParameter("ajoutn");
        if (btn != null && btn.equals("Add Newsletter")) {
            // Handle newsletter creation logic
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

            // Get the logged-in user from session
            HttpSession session = request.getSession(false); // Pass false to prevent session creation if it doesn't exist
            if (session != null) {
                CreateurContenu createur = (CreateurContenu) session.getAttribute("createur");
                if (createur != null) {
                    newsletter.setCreateurContenu(createur);
                }
            }
            try {
                createurServices.createRissala(newsletter);
                response.sendRedirect("index.jsp");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        }
        
        
        
        if (request.getParameter("deleter") != null) {  // Check for delete button click
            int id;
            try {
                id = Integer.parseInt(request.getParameter("newsid"));  // Assuming a hidden field
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Invalid NEWS ID format.");
                return;
            }

            try {
            	newslettersServices.deletenewsById(id);
                request.setAttribute("message", "newsletter deleted successfully!");
            } catch (Exception e) {
                request.setAttribute("errorMessage", "Error deleting newsletter: " + e.getMessage());
            }
        }
        
        
        
        String btn3 = request.getParameter("editr");
        if (btn3 != null) {
            String id = request.getParameter("id");
            request.setAttribute("id", id); // Set the ID as a request attribute
            request.getRequestDispatcher("modifier.jsp").forward(request, response);
        }
        
        
        if (request.getParameter("ajouti") != null) {
        	int id = Integer.parseInt(request.getParameter("id")); 
            String modifiedTitle = request.getParameter("modifiedTitle");
            String modifiedCategory = request.getParameter("modifiedCategory");
            String modifiedContent = request.getParameter("modifiedContent");
            String modifiedImage = request.getParameter("modifiedImage");
            
           // try {
            	
             //   newslettersServices.updateNewsletter(id, creatorId,  modifiedTitle, modifiedCategory, modifiedContent, modifiedImage);
               // request.setAttribute("message", "Newsletter updated successfully!");
            //} catch (Exception e) {
              //  request.setAttribute("errorMessage", "Error updating newsletter: " + e.getMessage());
            //}
        }
    }}