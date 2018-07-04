package net.joastbg.sampleapp.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="PersonneMorale")
public class PersonneMorale extends Client  {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name="Siren")
    private String Siren;
    
    public PersonneMorale(){
        super();
    }
    
}
