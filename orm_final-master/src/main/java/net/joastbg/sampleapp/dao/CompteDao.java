package net.joastbg.sampleapp.dao;

import java.util.ArrayList;
import java.util.List;
import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.exceptions.DaoException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompteDao {

    @Autowired
    SessionFactory sessionFactory;

    public String persist(CompteBancaire compteBancaire) {
        Session session = sessionFactory.getCurrentSession();
        String returnID = (String) session.save(compteBancaire);
        return returnID;
    }

    public CompteBancaire find(String iban) {
        Session session = sessionFactory.getCurrentSession();
        return (CompteBancaire) session.load(CompteBancaire.class, iban);
    }

    public void delete(CompteBancaire compteBancaire) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(compteBancaire);
    }

    public void persist(String rr, String christian, String aa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public int[] findByName(String name) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Client WHERE nom = :name");
		q.setString("name", name);
		List l = q.list();
                int[] tab = new int[4];
                
		if ( l.size() >= 1 && l.isEmpty()==false ) {
                    for(int i=0;i<l.size();i++){
			tab[i]=((Client) l.get(i)).getIdClient();
                    }
		} else {
                       
                      if(l.isEmpty()==false) {
			tab[0]=((Client) l.get(0)).getIdClient();
                      }
		}
                return tab;
	}
   
    public int ComptePrincipal(int[] id,int choix) throws DaoException {
       Session session = sessionFactory.getCurrentSession();
       String hql="";
       Query q;
       List l=new ArrayList();
       
       for(int i=0;i<id.length;i++){
           
        q = session.createQuery("FROM Client WHERE idClient = :id[i]");
        l = q.list();
         
        if (choix ==id[i] && id.length >= 1) {
		
        hql = "UPDATE COMPTE_CLIENT set ComptePrincipal =:compte "  + 
       "WHERE id = :((Client)l.get(0)).getIdClient()";
	}
        else{
            
	hql = "UPDATE COMPTE_CLIENT set ComptePrincipal =:compte "  + 
       "WHERE id = :((Client)l.get(0)).getIdClient()";	  
		}
                
       }
       Query query = session.createQuery(hql);
       query.setParameter("compte", true);
       int result = query.executeUpdate();
               
       return result;
       
	}
    
}

    public int[] findByName(String name) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("FROM Client WHERE nom = :name");
        q.setString("name", name);
        List l = q.list();
        int[] tab = new int[4];

        if (l.size() >= 1 && l.isEmpty() == false) {
            for (int i = 0; i < l.size(); i++) {
                tab[i] = ((Client) l.get(i)).getIdClient();
            }
        } else {

            if (l.isEmpty() == false) {
                tab[0] = ((Client) l.get(0)).getIdClient();
            }
        }
        return tab;
    }

    public int ComptePrincipal(int[] id, int choix) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        String hql = "";
        Query q;
        List l = new ArrayList();

        for (int i = 0; i < id.length; i++) {

            q = session.createQuery("FROM Client WHERE idClient = :id[i]");
            l = q.list();

            if (choix == id[i] && id.length >= 1) {

                hql = "UPDATE COMPTE_CLIENT set ComptePrincipal =:compte "
                        + "WHERE id = :((Client)l.get(0)).getIdClient()";
            } else {

                hql = "UPDATE COMPTE_CLIENT set ComptePrincipal =:compte "
                        + "WHERE id = :((Client)l.get(0)).getIdClient()";
            }

        }
        Query query = session.createQuery(hql);
        query.setParameter("compte", true);
        int result = query.executeUpdate();

        return result;

    }

}
