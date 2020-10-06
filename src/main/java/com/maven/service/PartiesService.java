/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.service;

import com.maven.dao.PartiesDao;
import com.maven.model.Parties;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class PartiesService {

    @Autowired
    PartiesDao partiesDao;

    
    public void save(HttpServletRequest request,
           @RequestParam CommonsMultipartFile[] fileUpload) {
        
        Map<String, String[]> map = request.getParameterMap();

        String partycode = map.get("partycode")[0];
        String partyname = map.get("partyname")[0];
        String logoname = map.get("logoname")[0];


        Parties parties = new Parties();

        parties.setPartycode(partycode);
        parties.setPartyname(partyname);
        parties.setLogoname(logoname);


        for (CommonsMultipartFile aFile : fileUpload) {
            parties.setImglogo(aFile.getBytes());
        }
        partiesDao.save(parties);
    }



}
