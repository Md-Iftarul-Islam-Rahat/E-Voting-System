
package com.maven.service;

import com.maven.dao.UserDao;
import com.maven.model.User;
import com.maven.model.Voters;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserDao userDao;
    
    public void save(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();

        String username = map.get("username")[0];
        String password = map.get("password")[0];

        User user = new User();
        
        user.setUsername(username);
        user.setPassword(password);
        userDao.save(user);
    }
    
    public boolean login(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();

        String username = map.get("username")[0];
        String password = map.get("password")[0];
        
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        User u = userDao.login(user);

        if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean voterlogin(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Date dateObject = new Date();
        
        String nid = map.get("nid")[0];
        String dob = map.get("dob")[0];

        Voters voters = new Voters();

        voters.setNid(nid);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd-");
        try {
            dateObject = simpleDate.parse(dob);
        } catch (ParseException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        voters.setDob(dateObject);

//        Wed Jan 12 00:00:00 BDT 1994
//        1994-12-01
        Voters u = userDao.voterlogin(voters);

        if (nid.equals(u.getNid())) {
            return true;
        } else {
            return false;
        }
    }
    
}
