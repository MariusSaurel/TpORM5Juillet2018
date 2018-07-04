package net.joastbg.sampleapp.entities;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Echeances")
public class Echeances {
    
    protected static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEcheance")
    private int idEcheance;
    @Column(name="prix")
    private float prix;
    @Column(name="DateEmission")
    private String DateEmission;
    @Column(name="DatePaiement")
    private String DatePaiement;
    @Column(name="DateEmissionFacture")
    private String DateEmissionFacture;
}
