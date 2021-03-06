package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="PersonnePhysique")
public class PersonnePhysique extends Client implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * @return the dateNaissance
     */
    public String getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    
    @Column(name= "dateNaissance")
    private String dateNaissance;
    
    public PersonnePhysique(){
        super();
    }
}
