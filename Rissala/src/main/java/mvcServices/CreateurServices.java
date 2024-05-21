package mvcServices;



import entities.CreateurContenu;
import entities.Newsletter;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;


/**
 * Session Bean implementation class CreateurServices
 */
@Stateless
@LocalBean
public class CreateurServices {

	 @PersistenceContext(unitName="Rissala")
	 	private EntityManager em ;
    /**
     * Default constructor. 
     */
    public CreateurServices() {
        // TODO Auto-generated constructor stub
    }

    public CreateurContenu getCreatorByloginAndPassword(String login, String password) {
        try {
            return em.createQuery("SELECT c FROM CreateurContenu c WHERE c.nomUtilisateur = :user AND c.motDePasse = :pwd", CreateurContenu.class)
                    .setParameter("user", login)
                    .setParameter("pwd", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    public  void addcreateur (CreateurContenu createur) {
    	em.persist(createur);
    }



    public void createRissala(Newsletter newsletter) {
    	em.persist(newsletter);
    	
    }
    public int getid(CreateurContenu createur) {
    		return createur.getId();
    }
    







}
