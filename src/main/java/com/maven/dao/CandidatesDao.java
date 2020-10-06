/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.dao;

import com.maven.model.Candidates;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CandidatesDao {
    
    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(Candidates candidates) {
        sessionFactory.getCurrentSession().saveOrUpdate(candidates);
        sessionFactory.getCurrentSession().flush();
    }
    
    @Transactional
    public List<Candidates> getAll() {
        List<Candidates> CandidatesList = sessionFactory.getCurrentSession().createCriteria(Candidates.class).list();
        sessionFactory.getCurrentSession().flush();
        //System.out.println("From CandidatesDao(getAll) called");
        return CandidatesList;
    }
    
    @Transactional
    public Candidates delete(int id) { 
        Candidates candidates = (Candidates) sessionFactory.getCurrentSession().load(Candidates.class, id);
        sessionFactory.getCurrentSession().delete(candidates);
        sessionFactory.getCurrentSession().flush();
        return candidates;
    }
    
    @Transactional
    public Candidates update(Candidates candidates) {
        sessionFactory.getCurrentSession().saveOrUpdate(candidates);
        sessionFactory.getCurrentSession().flush();
        return candidates;
    }
    
    @Transactional
    public Candidates getById(int id) {
        Candidates candidates = (Candidates) sessionFactory.getCurrentSession().get(Candidates.class, id);
        sessionFactory.getCurrentSession().flush();
        return candidates;
    }
    
    
}
