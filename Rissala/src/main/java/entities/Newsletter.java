package entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the newsletter database table.
 * 
 */
@Entity

@NamedQueries ({
@NamedQuery(name="Newsletter.findAll", query="SELECT n FROM Newsletter n"),
@NamedQuery(name="Newsletter.getnewsletterbyid", query="SELECT n FROM Newsletter n WHERE n.createurContenu.id = :id")

})
public class Newsletter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String categorie;

	@Lob
	private String contenu;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_envoi")
	private Date dateEnvoi;

	private String image;

	private String titre;

	//bi-directional many-to-one association to CreateurContenu
	@ManyToOne
	@JoinColumn(name="createur_contenu_id", referencedColumnName="id")
	private CreateurContenu createurContenu;

	public Newsletter() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateEnvoi() {
		return this.dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public CreateurContenu getCreateurContenu() {
		return this.createurContenu;
	}

	public void setCreateurContenu(CreateurContenu createurContenu) {
		this.createurContenu = createurContenu;
	}

	













}