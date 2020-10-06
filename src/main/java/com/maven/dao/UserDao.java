
package com.maven.dao;

import com.maven.model.Candidates;
import com.maven.model.Result;
import com.maven.model.User;
import com.maven.model.Voters;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {
    
    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        sessionFactory.getCurrentSession().flush();
    }
    
    @Transactional
    public User login(User user) {
        String sql = "from User where username = '"+user.getUsername()+"' AND password = '"+user.getPassword()+"'";
        List<User> u = getSessionFactory().openSession().createQuery(sql).list();
        return u.get(0);
    }
    
    @Transactional
    public Voters voterlogin(Voters v) {
       // System.out.println(v.getNid());
       // System.out.println(v.getDob());
        String sql = "from Voters where nid = '"+v.getNid()+"' ";//AND dob = '"+v.getDob()+"'
        List<Voters> u = getSessionFactory().openSession().createQuery(sql).list();
      //  System.out.println(u.get(0).getNid()+ " .................");
        return u.get(0);
    }
    
    @Transactional
    public Candidates goForVote(Candidates c) {
        System.out.println(c.getFullname());
        
        String sql = "from Candidates where fullname = '"+c.getFullname()+"' AND candidateimage = '"+c.getCandidateimage()+"' AND logoimage = '"+c.getLogoimage()+"'";
        List<Candidates> candidateses = getSessionFactory().openSession().createQuery(sql).list();
        System.out.println(candidateses.get(0).getFullname()+ " .................");
        return candidateses.get(0);
    }
    
    
}
