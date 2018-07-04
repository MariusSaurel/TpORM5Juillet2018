/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author van christian
 */
@Entity
@Table(name = "AssuranceHabitation")
@PrimaryKeyJoinColumn(name = "idAssurance")
public class AssuranceHabitation extends Assurance {
    
    private static final long serialVersionUID = 1L;

    @Column(name = "Adresse")
    private String Adresse;
    @Column(name = "ValeurCouverture")
    private int ValeurCouverture;
    
    public AssuranceHabitation(){
        super();
    }
}
