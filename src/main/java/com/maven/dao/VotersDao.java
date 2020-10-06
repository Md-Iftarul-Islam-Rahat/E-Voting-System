package com.maven.dao;

import com.maven.model.Voters;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class VotersDao {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(Voters v) {
        sessionFactory.getCurrentSession().saveOrUpdate(v);
        sessionFactory.getCurrentSession().flush();
    }

    @Transactional
    public List<Voters> getAll() {
        List<Voters> voterList = sessionFactory.getCurrentSession().createCriteria(Voters.class).list();
        sessionFactory.getCurrentSession().flush();
        System.out.println("From VotersDao(getAll) called");
        return voterList;
    }

    @Transactional
    public Voters delete(int id) {
        Voters voters = (Voters) sessionFactory.getCurrentSession().load(Voters.class, id);
        sessionFactory.getCurrentSession().delete(voters);
        sessionFactory.getCurrentSession().flush();
        return voters;
    }

    @Transactional
    public Voters update(Voters voters) {
        sessionFactory.getCurrentSession().saveOrUpdate(voters);
        sessionFactory.getCurrentSession().flush();
        return voters;
    }

    @Transactional
    public Voters getById(int id) {
        Voters voters = (Voters) sessionFactory.getCurrentSession().get(Voters.class, id);
        sessionFactory.getCurrentSession().flush();
        return voters;
    }

    @Transactional
    public Voters getByNId(String nid) {
//         System.out.println("dao " + nid);
//        String sql = "from Voters where nid = '"+nid+"'";
//        List<Voters> voters = getSessionFactory().openSession().createCriteria(sql).list();
//        return voters.get(0);

        Query query = sessionFactory.getCurrentSession().createQuery("from Voters where nid=:nid");
        query.setParameter("nid", nid);
        Voters user = (Voters) query.setMaxResults(1).uniqueResult();
        System.out.println(user.getFullname());
        return user;

    }

}
