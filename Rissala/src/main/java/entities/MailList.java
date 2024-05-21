package entities;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="mail_list")
@NamedQuery(name="MailList.findAll", query="SELECT m FROM MailList m")
public class MailList implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="mail_id")
    private int mailId;

    private String mail;

    // Adjusted @JoinColumn to reference the 'id' column of CreateurContenu entity
    @ManyToOne
    @JoinColumn(name="createur_contenu_id", referencedColumnName="id")
    private CreateurContenu createurContenu;

    public MailList() {
    }

    public int getMailId() {
        return this.mailId;
    }

    public void setMailId(int mailId) {
        this.mailId = mailId;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public CreateurContenu getCreateurContenu() {
        return this.createurContenu;
    }

    public void setCreateurContenu(CreateurContenu createurContenu) {
        this.createurContenu = createurContenu;
    }
}
