package net.joastbg.sampleapp.entities;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Echeances")
public class Echeances {
    
    protected static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEcheance")
    private int idEcheance;
    @Column(name="prix")
    private float prix;
    @Column(name="DateEmission")
    private String DateEmission;
    @Column(name="DatePaiement")
    private String DatePaiement;
    @Column(name="DateEmissionFacture")
    private String DateEmissionFacture;

    /**
     * @return the idEcheance
     */
    public int getIdEcheance() {
        return idEcheance;
    }

    /**
     * @param idEcheance the idEcheance to set
     */
    public void setIdEcheance(int idEcheance) {
        this.idEcheance = idEcheance;
    }

    /**
     * @return the prix
     */
    public float getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }

    /**
     * @return the DateEmission
     */
    public String getDateEmission() {
        return DateEmission;
    }

    /**
     * @param DateEmission the DateEmission to set
     */
    public void setDateEmission(String DateEmission) {
        this.DateEmission = DateEmission;
    }

    /**
     * @return the DatePaiement
     */
    public String getDatePaiement() {
        return DatePaiement;
    }

    /**
     * @param DatePaiement the DatePaiement to set
     */
    public void setDatePaiement(String DatePaiement) {
        this.DatePaiement = DatePaiement;
    }

    /**
     * @return the DateEmissionFacture
     */
    
    public String getDateEmissionFacture() {
        return DateEmissionFacture;
    }

    /**
     * @param DateEmissionFacture the DateEmissionFacture to set
     */
    public void setDateEmissionFacture(String DateEmissionFacture) {
        this.DateEmissionFacture = DateEmissionFacture;
    }
}
