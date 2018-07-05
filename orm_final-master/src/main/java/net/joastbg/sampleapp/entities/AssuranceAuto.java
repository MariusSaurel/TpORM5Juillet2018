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
@Table(name = "AssuranceAuto")
@PrimaryKeyJoinColumn(name = "idAssurance")
public class AssuranceAuto extends Assurance {
    
    private static final long serialVersionUID = 1L;

    @Column(name = "Immatriculation")
    private String Immatriculation;
    @Column(name = "Bonus")
    private int Bonus;
    
    public AssuranceAuto(){
        super();
    }

    /**
     * @return the Immatriculation
     */
    public String getImmatriculation() {
        return Immatriculation;
    }

    /**
     * @param Immatriculation the Immatriculation to set
     */
    public void setImmatriculation(String Immatriculation) {
        this.Immatriculation = Immatriculation;
    }

    /**
     * @return the Bonus
     */
    public int getBonus() {
        return Bonus;
    }

    /**
     * @param Bonus the Bonus to set
     */
    public void setBonus(int Bonus) {
        this.Bonus = Bonus;
    }
    
}
