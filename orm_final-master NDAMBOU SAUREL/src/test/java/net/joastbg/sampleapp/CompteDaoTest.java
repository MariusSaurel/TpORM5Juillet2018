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
    private CompteDao compteDao;

    private CompteBancaire compte;

    @Before
    public void setUp() {
        setCompte(new CompteBancaire());
        getCompte().setIban("FR7612548029980000000150086");
        getCompte().setProprietaire("Cathy Catou");
    }

    @Test
    public void testPersist(){
        String id = getCompteDao().persist(getCompte());
        Assert.assertTrue(id != null);
        getCompteDao().delete(getCompte());
    }

    @Test
    public void testFind(){
        String id = getCompteDao().persist(getCompte());
        CompteBancaire compteFound = getCompteDao().find(id);
        Assert.assertNotNull(compteFound);
        Assert.assertEquals(getCompte(),compteFound);
        getCompteDao().delete(getCompte());
    }
    
     @Test
    public void ComptePrincipal(){ // Permet de selectionner un compte prinpal
        int tab[];
        int ChoixComptePrincipale = 1;
        try {
           tab=getCompteDao().findByName("van");
            getCompteDao().ComptePrincipal(tab, ChoixComptePrincipale);
        } catch (DaoException ex) {
            Logger.getLogger(CompteDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @return the compteDao
     */
    public CompteDao getCompteDao() {
        return compteDao;
    }

    /**
     * @param compteDao the compteDao to set
     */
    public void setCompteDao(CompteDao compteDao) {
        this.compteDao = compteDao;
    }

    /**
     * @return the compte
     */
    public CompteBancaire getCompte() {
        return compte;
    }

    /**
     * @param compte the compte to set
     */
    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

}
