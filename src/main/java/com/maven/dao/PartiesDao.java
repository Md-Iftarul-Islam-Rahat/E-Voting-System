
package com.maven.dao;

import com.maven.model.Parties;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PartiesDao {
    
    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

   
    
    @Transactional
    public void save(Parties parties) {
        sessionFactory.getCurrentSession().saveOrUpdate(parties);
        sessionFactory.getCurrentSession().flush();
    }
    

    
    @Transactional
    public List<Parties> getAll() {
        
        List<Parties> partiesList = sessionFactory.getCurrentSession().createCriteria(Parties.class).list();
        sessionFactory.getCurrentSession().flush();
        System.out.println("From partiesDao(getAll) called");
        return partiesList;
    }
    
     @Transactional
    public Parties delete(int id) {
        
        Parties parties = (Parties) sessionFactory.getCurrentSession().load(Parties.class, id);
        sessionFactory.getCurrentSession().delete(parties);
        sessionFactory.getCurrentSession().flush();
        return parties;
    }
    
    @Transactional
    public Parties update(Parties parties) {
        sessionFactory.getCurrentSession().saveOrUpdate(parties);
        sessionFactory.getCurrentSession().flush();
        return parties;
    }
    
    @Transactional
    public Parties getById(int id) {
        
        
        Parties voters = (Parties) sessionFactory.getCurrentSession().get(Parties.class, id);
        sessionFactory.getCurrentSession().flush();
        return voters;
    }
    
}
