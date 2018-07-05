package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import static java.sql.Types.DATE;
import static java.util.Calendar.DATE;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ASSURANCE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Assurance {

    protected static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAssurance")
    protected int idAssurance;
    @Column(name = "Numero")
    protected int Numero;
    @Column(name = "DateSouscription")
    protected String DateSouscription;
    @Column(name = "DateAnniversaire")
    protected String DateAnniversaire;
    @Column(name = "DatePrelevement")
    protected String DatePrelevement;

    @OneToOne
    @JoinColumn(
            name = "AssuranceEcheanceID",
            referencedColumnName = "idEcheance")
    protected Echeances echeance;

    /**
     * @return the idAssurance
     */
    public int getIdAssurance() {
        return idAssurance;
    }

    /**
     * @param idAssurance the idAssurance to set
     */
    public void setIdAssurance(int idAssurance) {
        this.idAssurance = idAssurance;
    }

    /**
     * @return the Numero
     */
    public int getNumero() {
        return Numero;
    }

    /**
     * @param Numero the Numero to set
     */
    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    /**
     * @return the DateSouscription
     */
    public String getDateSouscription() {
        return DateSouscription;
    }

    /**
     * @param DateSouscription the DateSouscription to set
     */
    public void setDateSouscription(String DateSouscription) {
        this.DateSouscription = DateSouscription;
    }

    /**
     * @return the DateAnniversaire
     */
    public String getDateAnniversaire() {
        return DateAnniversaire;
    }

    /**
     * @param DateAnniversaire the DateAnniversaire to set
     */
    public void setDateAnniversaire(String DateAnniversaire) {
        this.DateAnniversaire = DateAnniversaire;
    }

    /**
     * @return the DatePrelevement
     */
    public String getDatePrelevement() {
        return DatePrelevement;
    }

    /**
     * @param DatePrelevement the DatePrelevement to set
     */
    public void setDatePrelevement(String DatePrelevement) {
        this.DatePrelevement = DatePrelevement;
    }

    /**
     * @return the typeAssurance
     */
}
