package entities;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.List;


/**
 * The persistent class for the createur_contenu database table.
 * 
 */

@Entity
@Table(name="createur_contenu")

@NamedQueries ({
    @NamedQuery(name="CreateurContenu.findAll", query="SELECT c FROM CreateurContenu c"),
    @NamedQuery(name="getCreatorByloginAndPassword", query="SELECT c FROM CreateurContenu c WHERE c.nomUtilisateur = :login AND c.motDePasse = :password")
})


public class CreateurContenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id ;
	
	
	@Column(name="adresse_mail")
	private String adresseMail;

	@Column(name="mot_de_passe")
	private String motDePasse;

	private String nom;

	@Column(name="nom_utilisateur")
	private String nomUtilisateur;

	private String prenom;

	//bi-directional many-to-one association to Newsletter
	@OneToMany(mappedBy="createurContenu", fetch=FetchType.EAGER)
	private List<Newsletter> newsletters;

	//bi-directional many-to-one association to MailList
	@OneToMany(mappedBy="createurContenu", fetch=FetchType.EAGER)
	private List<MailList> mailLists;

	public CreateurContenu() {
	}


	public String getAdresseMail() {
		return this.adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}


	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Newsletter> getNewsletters() {
		return this.newsletters;
	}

	public void setNewsletters(List<Newsletter> newsletters) {
		this.newsletters = newsletters;
	}

	public Newsletter addNewsletter(Newsletter newsletter) {
		getNewsletters().add(newsletter);
		newsletter.setCreateurContenu(this);

		return newsletter;
	}


	public Newsletter removeNewsletter(Newsletter newsletter) {
		getNewsletters().remove(newsletter);
		newsletter.setCreateurContenu(null);

		return newsletter;
	}

	public List<MailList> getMailLists() {
		return this.mailLists;
	}

	public void setMailLists(List<MailList> mailLists) {
		this.mailLists = mailLists;
	}

	public MailList addMailList(MailList mailList) {
		getMailLists().add(mailList);
		mailList.setCreateurContenu(this);

		return mailList;
	}

	public MailList removeMailList(MailList mailList) {
		getMailLists().remove(mailList);
		mailList.setCreateurContenu(null);

		return mailList;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}