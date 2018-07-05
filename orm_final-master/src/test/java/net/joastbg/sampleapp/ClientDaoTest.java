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
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.PersonneMorale;

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
   



}
