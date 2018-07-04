package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
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

public abstract class Client implements Serializable {
    
    protected static final long serialVersionUID = 1L;

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient")
    protected int idClient;
    @Column
    protected String nom;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "COMPTE_CLIENT",
            joinColumns = @JoinColumn(name = "idClient"),
            inverseJoinColumns = @JoinColumn(name = "iban")
    )
    protected List<CompteBancaire> Compte;
    
    @Embedded
    protected Contact contact;
    
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
    public Client(int idClient,String nom){
        idClient=idClient;
        nom=nom;
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
    public Contact getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * @return the Compte
     */
   
    public List<CompteBancaire> getCompte() {
        return Compte;
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
        return assurance;
    }

    /**
     * @param assurance the assurance to set
     */
    public void setAssurance(List<Assurance> assurance) {
        this.assurance = assurance;
    }

    /**
     * @return the assurance
     */
 
  
}



