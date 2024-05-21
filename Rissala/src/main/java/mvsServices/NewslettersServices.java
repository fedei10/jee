package mvsServices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Newsletter;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class NewslettersServices
 */
@Stateless
@LocalBean
public class NewslettersServices {

    @PersistenceContext(unitName = "Rissala")
    private EntityManager em;

    /**
     * Default constructor.
     */
    public NewslettersServices() {
        // Default constructor
    }

    public List<Newsletter> getNewsletterById(int id) {
        List<Newsletter> newsletters = new ArrayList<>();
        if (em != null) {
            TypedQuery<Newsletter> query = em.createQuery(
                "SELECT n FROM Newsletter n WHERE n.createurContenu.id = :id", 
                Newsletter.class
            );
            query.setParameter("id", id);
            newsletters = query.getResultList();
        } else {
            // Log or throw an exception indicating that EntityManager is null
            // You can replace this with appropriate error handling logic
            System.err.println("EntityManager is null in NewslettersServices");
        }
        return newsletters;
    }
    
    public List<Newsletter> deletenewsById(int newsId){
        List<Newsletter> newsletter = new ArrayList<Newsletter>();
        Newsletter news = em.find(Newsletter.class, newsId);
        if(news!=null)
        em.remove(news);
        TypedQuery<Newsletter> query =
        em.createNamedQuery("Newsletter.findAll",Newsletter.class);
        newsletter = query.getResultList();
        return newsletter;}
    
    
    
    public void updateNewsletter(int id,int createurid,String newTitle, String newCategory, String newContent, String newImage) {
        Newsletter newsletter = em.find(Newsletter.class, id);
        if (newsletter != null) {
            // Update the attributes
            newsletter.setTitre(newTitle);
            newsletter.setCategorie(newCategory);
            newsletter.setContenu(newContent);
            newsletter.setImage(newImage);
            newsletter.setDateEnvoi(new Date());
            
            // Persist the changes
            em.merge(newsletter);
        }
    }

    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
