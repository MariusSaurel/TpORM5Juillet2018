/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp.entities;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author van christian
 */
@Entity
@Table(name= "CONTACT_GESTION")
public class GestionContact {
    
    protected static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContact")
    private int idContact;
    private Client client;
       
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CONTACT_GESTION",
            joinColumns = @JoinColumn(name = "idClient"),
            inverseJoinColumns = @JoinColumn(name = "idContact"))
    ArrayList<Client>  contact; 
    
    
   
    
    public GestionContact(){
        
    }
    
    public void ajouterContact(){
        
    }
}
