package net.joastbg.sampleapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contact")
public class Contact {
    
    
    private static long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContact")
    private int idContact;
    
    @Column(name="TypeContact")
    private String TypeContact;
    @Column(name="valeur")
    private String valeur;
    
    public Contact(){
        
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the idContact
     */
    public int getIdContact() {
        return idContact;
    }

    /**
     * @param idContact the idContact to set
     */
    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    /**
     * @return the TypeContact
     */
    public String getTypeContact() {
        return TypeContact;
    }

    /**
     * @param TypeContact the TypeContact to set
     */
    public void setTypeContact(String TypeContact) {
        this.TypeContact = TypeContact;
    }

    /**
     * @return the valeur
     */
    public String getValeur() {
        return valeur;
    }

    /**
     * @param valeur the valeur to set
     */
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
}
