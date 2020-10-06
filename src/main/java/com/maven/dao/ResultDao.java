/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.dao;

import com.maven.model.Result;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author USER
 */
@Repository
public class ResultDao {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(Result result) {
        sessionFactory.getCurrentSession().saveOrUpdate(result);
        sessionFactory.getCurrentSession().flush();
    }

//    @Transactional
//    public Result viewresult(Result result) {
//        System.out.println(result.getFullname());
//        
//        String sql = "count(fullname) from Result where fullname =:fullname";
//        
////        String sql = "from Candidates where fullname = '"+c.getFullname()+"'";
//        List<Result> results = getSessionFactory().openSession().createQuery(sql).list();
//        System.out.println(results.get(0).getFullname()+ " .................");
//        return results.get(0);
//    }
    @Transactional
    public Long getResultByName(String fullname) {
        Query query = sessionFactory.getCurrentSession().createQuery("select count(fullname) from Result where fullname =:name");
        query.setString("name", fullname);
        Long count = (Long) query.uniqueResult();
        return count;
    }
    
//    Query query = sessionFactory.getCurrentSession().createQuery(
//            "select count(*) from Result where fullname =:name");
//query.setString("email", "something");
//query.setString("password", "password");
//Long count = (Long)query.uniqueResult();

    @Transactional
    public List<Result> getAll() {
        List<Result> resultList = sessionFactory.getCurrentSession().createCriteria(Result.class).list();
        sessionFactory.getCurrentSession().flush();
        System.out.println("From ResultDao(getAll) called");
        return resultList;
    }

}
