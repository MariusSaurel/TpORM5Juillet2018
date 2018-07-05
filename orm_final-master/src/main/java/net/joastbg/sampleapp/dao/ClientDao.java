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
import net.joastbg.sampleapp.entities.GestionContact;
import net.joastbg.sampleapp.exceptions.DaoException;
import org.hibernate.Query;

@Service
@Transactional
public class ClientDao {

    @Autowired
    SessionFactory sessionFactory;

    public Long persist(Client client) {
        Session session = sessionFactory.getCurrentSession();
        Long returnID = (Long) session.save(client);
        return returnID;
    }

    public List<Client> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Client").list();
    }
    public int AjoutListCompte(Client client){ // ajoute au client une liste de compte lui appartenant
        Session session = sessionFactory.getCurrentSession();
        int returnID = (Integer) session.save(client);
        return returnID;
    }
    
     public String ajouterContact(GestionContact gestion){ // ajouter un contact � un client (Gestion de contacts)
        Session session = sessionFactory.getCurrentSession();
        String returnID = (String) session.save(gestion);
        return returnID;
    }  
     
     public Client findByName(String name) throws DaoException { // renvoi un client 
		Session session = sessionFactory.getCurrentSession();
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
    
 
    
    
    
   
}
