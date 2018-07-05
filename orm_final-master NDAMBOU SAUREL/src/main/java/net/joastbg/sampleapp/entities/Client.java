package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name= "CLIENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Client {
    
    protected static final long serialVersionUID = 1L;

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient")
    private int idClient;
    
    @Column(name="nom")
    private String nom;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "COMPTE_CLIENT",
            joinColumns = @JoinColumn(name = "idClient"),
            inverseJoinColumns = @JoinColumn(name = "iban")
    )
    protected List<CompteBancaire> Compte;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CONTACT_GESTION",
            joinColumns = @JoinColumn(name = "idClient"),
            inverseJoinColumns = @JoinColumn(name = "idContact")
    )
    private List<Contact> contact;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CLIENT_ASSURANCE",
            joinColumns = @JoinColumn(name = "idClient"),
            inverseJoinColumns = @JoinColumn(name = "idAssurance")
    )
    protected List<Assurance> assurance;

    /**
     * @return the idClient
     */
    public Client(){
       
    }
    
    public int getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the Compte
     */

    /**
     * @return the contact
     */
   

    /**
     * @return the Compte
     */
   
    public List<CompteBancaire> getCompte() {
        return Collections.unmodifiableList(Compte);
    }

    /**
     * @param Compte the Compte to set
     */
    public void setCompte(List<CompteBancaire> Compte) {
        this.Compte = Compte;
    }

    /**
     * @return the assurance
     */
    public List<Assurance> getAssurance() {
        return Collections.unmodifiableList(assurance);
    }

    /**
     * @param assurance the assurance to set
     */
    public void setAssurance(List<Assurance> assurance) {
        this.assurance = assurance;
    }

    /**
     * @return the contact
     */
    public List<Contact> getContact() {
        return Collections.unmodifiableList(contact);
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    /**
     * @return the assurance
     */
 
  
}



