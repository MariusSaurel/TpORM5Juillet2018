package net.joastbg.sampleapp;


import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.dao.CompteDao;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.exceptions.DaoException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class CompteDaoTest {


    @Autowired
    CompteDao compteDao;

    CompteBancaire compte;

    @Before
    public void setUp() {
        compte = new CompteBancaire();
        compte.setIban("FR7612548029980000000150086");
        compte.setProprietaire("Cathy Catou");
    }

    @Test
    public void testPersist(){
        String id = compteDao.persist(compte);
        Assert.assertTrue(id != null);
        compteDao.delete(compte);
    }

    @Test
    public void testFind(){
        String id = compteDao.persist(compte);
        CompteBancaire compteFound = compteDao.find(id);
        Assert.assertNotNull(compteFound);
        Assert.assertEquals(compte,compteFound);
        compteDao.delete(compte);
    }
    
     @Test
    public void ComptePrincipal(){ // Permet de selectionner un compte prinpal
        int tab[];
        int ChoixComptePrincipale = 1;
        try {
           tab=compteDao.findByName("van");
           compteDao.ComptePrincipal(tab, ChoixComptePrincipale);
        } catch (DaoException ex) {
            Logger.getLogger(CompteDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
