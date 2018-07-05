package net.joastbg.sampleapp.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import net.joastbg.sampleapp.dao.CompteDao;



@Entity
@Table(name= "COMPTE_BANCAIRE")
public class CompteBancaire {

    @Id
    private String iban;
    @Column
    private String proprietaire;
    @Column
    private String swift_code;

   
    /**
     * @return the iban
     */

    public CompteBancaire() {
    }
    public CompteBancaire(String iban,String proprietaire,String swift_code){
        this.iban=iban;
        this.proprietaire=proprietaire;
        this.swift_code=swift_code;
    }
    public String getIban() {
        return iban;
    }

    /**
     * @param iban the iban to set
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * @return the proprietaire
     */
    public String getProprietaire() {
        return proprietaire;
    }

    /**
     * @param proprietaire the proprietaire to set
     */
    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    /**
     * @return the swift_code
     */
    public String getSwift_code() {
        return swift_code;
    }

    /**
     * @param swift_code the swift_code to set
     */
    public void setSwift_code(String swift_code) {
        this.swift_code = swift_code;
    }
}
