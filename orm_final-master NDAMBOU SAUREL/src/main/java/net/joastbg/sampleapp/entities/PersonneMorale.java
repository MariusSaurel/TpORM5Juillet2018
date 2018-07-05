package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="PersonneMorale")
public class PersonneMorale extends Client implements Serializable  {

   
    
    private static final long serialVersionUID = 1L;
    
    @Column(name="Siren")
    private String Siren;
    
    public PersonneMorale(){
        super();
    }
     /**
     * @return the Siren
     */
    public String getSiren() {
        return Siren;
    }

    /**
     * @param Siren the Siren to set
     */
    public void setSiren(String Siren) {
        this.Siren = Siren;
    }
    
}
