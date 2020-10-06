/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.service;

import com.maven.dao.CandidatesDao;
import com.maven.model.Candidates;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class CandidatesService {

    @Autowired
    CandidatesDao candidatesDao;

    public void save(HttpServletRequest request,
        @RequestParam CommonsMultipartFile[] fileUpload1,@RequestParam CommonsMultipartFile[] fileUpload2) {
        Map<String, String[]> map = request.getParameterMap();
        Date dateObject = new Date();
        String fronEndDateString = map.get("dob")[0];
        String fullname = map.get("fullname")[0];
        String fathername = map.get("fathername")[0];
        String mothername = map.get("mothername")[0];
        String nid = map.get("nid")[0];
        String email = map.get("email")[0];
        String religion = map.get("religion")[0];
        String blood = map.get("blood")[0];
        String sex = map.get("sex")[0];
        String partytype = map.get("partytype")[0];
        String area = map.get("area")[0];
        String wordno = map.get("wordno")[0];
        String citycorporation = map.get("citycorporation")[0];

////id, fullname, fathername, mothername, nid, dob, email, religion, blood, sex, partyname, candidateimage, logoimage, area, wordno, citycorporation
        Candidates c = new Candidates();

        c.setFullname(fullname);
        c.setFathername(fathername);
        c.setMothername(mothername);
        c.setNid(nid);
        c.setDob(dateObject);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateObject = simpleDate.parse(fronEndDateString);
        } catch (ParseException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

        c.setEmail(email);
        c.setReligion(religion);
        c.setBlood(blood);
        c.setSex(sex);
        c.setPartytype(partytype);
        c.setArea(area);
        c.setWordno(wordno);
        c.setCitycorporation(citycorporation);

        for (CommonsMultipartFile aFile : fileUpload1) {
            c.setCandidateimage(aFile.getBytes());
        }

        for (CommonsMultipartFile aFile : fileUpload2) {
            c.setLogoimage(aFile.getBytes());
        }

        candidatesDao.save(c);

    }
    
    public List<Candidates> getAll(){
        return candidatesDao.getAll();
    }


}
