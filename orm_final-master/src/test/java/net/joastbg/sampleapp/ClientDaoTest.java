package net.joastbg.sampleapp;

import java.util.ArrayList;
import junit.framework.Assert;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.entities.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.Contact;
import net.joastbg.sampleapp.entities.Echeances;
import net.joastbg.sampleapp.entities.GestionContact;
import net.joastbg.sampleapp.entities.PersonneMorale;
import net.joastbg.sampleapp.exceptions.DaoException;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class ClientDaoTest {

    @Autowired
    ClientDao clientDao;

    @Before
    public void setUp() {

    }

    @Test
    public void testPersist(){
     Assert.assertTrue(true);
    }
    @Test
    public void testAjoutListCompte(){
       List<CompteBancaire> d=new ArrayList<CompteBancaire>();
       CompteBancaire C=new CompteBancaire("FR23432343454334545","van","12345678");
       CompteBancaire l=new CompteBancaire("FR23434324342343423","van","12345DDF");
       CompteBancaire f=new CompteBancaire("FR23434398676556455","van","1234FGCV");
       d.add(C);
       d.add(l);
       d.add(f);
       PersonneMorale client=new PersonneMorale();
       client.setIdClient(1);
       client.setNom("van");
       client.setSiren("AATT");
       client.setCompte(d);
       clientDao.AjoutListCompte(client);
    }
    
    @Test
    public void testAjouterContact(){
        
      GestionContact contact=new GestionContact();
      Contact element=new Contact();
      element.setIdContact(1);
      element.setTypeContact("Mail");
      element.setValeur("Données internet");
        try {
            contact.setClient(clientDao.findByName("cathy cathou"));
            contact.setContact(element);
        } catch (DaoException ex) {
            Logger.getLogger(ClientDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testAjouterEcheance(){
        
      Echeances echeance=new Echeances();
      echeance.setPrix(23);
      echeance.setDateEmission("05-07-2018");
      echeance.setDatePaiement("05-07-2018");
      echeance.setDateEmissionFacture("05-07-2018");
      clientDao.ajouterEcheance(echeance);
      //echeance.setDateEmission("");
    }

}
