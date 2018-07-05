package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static javassist.CtMethod.ConstParameter.string;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.Contact;
import net.joastbg.sampleapp.entities.Echeances;
import net.joastbg.sampleapp.entities.GestionContact;
import net.joastbg.sampleapp.exceptions.DaoException;
import org.hibernate.Query;

@Service
@Transactional
public class ClientDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Long persist(Client client) {
        Session session = getSessionFactory().getCurrentSession();
        Long returnID = (Long) session.save(client);
        return returnID;
    }

    public List<Client> findAll() {
        Session session = getSessionFactory().getCurrentSession();
        return session.createQuery("from Client").list();
    }
    public int AjoutListCompte(Client client){ // ajoute au client une liste de compte lui appartenant
        Session session = getSessionFactory().getCurrentSession();
        int returnID = (Integer) session.save(client);
        return returnID;
    }
    
     public int ajouterContact(GestionContact gestion){ // ajouter un contact � un client (Gestion de contacts)
        Session session = getSessionFactory().getCurrentSession();
        int returnID = (int) session.save(gestion);
        return returnID;
    }
     
     public int ajouterEcheance(Echeances echeance){ // ajouter un contact � un client (Gestion de contacts)
        Session session = getSessionFactory().getCurrentSession();
        int returnID = (int) session.save(echeance);
        return returnID;
    }  
     
     
     
     public Client findByName(String name) throws DaoException { // renvoi un client 
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.createQuery("FROM Client WHERE nom = :name");
		q.setString("name", name);
                Client client=new Client();
		List l = q.list();
           
		if ( l.size() >= 1 ) {
    
			System.out.println("Multiple errors");                
		  } 
                else{
		client=((Client) l.get(0));
                }
                return client;
     }

    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
 
    
    
    
   
}
