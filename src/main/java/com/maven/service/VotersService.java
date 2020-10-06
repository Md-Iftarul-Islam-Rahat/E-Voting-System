
package com.maven.service;

import com.maven.dao.VotersDao;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class VotersService {
    
    @Autowired
    VotersDao votersDao;
    
    public void save(HttpServletRequest request,
           @RequestParam CommonsMultipartFile[] fileUpload) {
        Map<String, String[]> map = request.getParameterMap();
        Date dateObject = new Date();
        String fronEndDateString = map.get("dob")[0];
        String fullname = map.get("fullname")[0];
        String fathername = map.get("fathername")[0];
        String mothername = map.get("mothername")[0];
        String nid = map.get("nid")[0];
        String email = map.get("email")[0];
        String religion = map.get("religion")[0];       
        String sex = map.get("sex")[0];
        String blood = map.get("blood")[0];
        String area = map.get("area")[0];
        String wordno = map.get("wordno")[0];
        String citycorporation = map.get("citycorporation")[0];

 //id, fullname, fathername, mothername, nid, dob, email, religion, sex, blood, area, wordno, citycorporation
        Voters v = new Voters();

        v.setFullname(fullname);
        v.setFathername(fathername);
        v.setMothername(mothername);
        v.setNid(nid);
        v.setDob(dateObject);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateObject = simpleDate.parse(fronEndDateString);
        } catch (ParseException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        v.setEmail(email);
        v.setReligion(religion);
        v.setSex(sex);
        v.setBlood(blood);
        v.setArea(area);
        v.setWordno(wordno);
        v.setCitycorporation(citycorporation);
        
        for (CommonsMultipartFile aFile : fileUpload) {
            v.setVoterimage(aFile.getBytes());
        }

        votersDao.save(v);
        
        

    }

    
    
}
