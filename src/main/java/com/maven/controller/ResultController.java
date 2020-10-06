/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.controller;

import com.maven.dao.CandidatesDao;
import com.maven.dao.ResultDao;
import com.maven.dao.VotersDao;
import com.maven.model.Result;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/result")
public class ResultController {

    @Autowired
    VotersDao votersDao;

    @Autowired
    CandidatesDao candidatesDao;

    @Autowired
    ResultDao resultDao;

    @RequestMapping(value = "/submit", method = RequestMethod.POST) ///////////vote count insert mapping method
    public ModelAndView save(HttpServletRequest request) {
        System.out.println("Count vote section");

        Map<String, String[]> model = request.getParameterMap();
        System.out.println(model.get("voter_name")[0]);
        System.out.println(model.get("candidate_fullname")[0]);

        Result result = new Result();
        // result table fields:---id, votername, nid, email, religion, sex, blood, area, wordno, citycorporation, voterimage, fullname, partytype, candidateimage, logoimage, status
        //voter info
        result.setVotername(model.get("voter_name")[0]);
        result.setNid(model.get("voter_nid")[0]);
        result.setEmail(model.get("voter_email")[0]);
        result.setReligion(model.get("voter_religion")[0]);
        result.setSex(model.get("voter_sex")[0]);
        result.setBlood(model.get("voter_blood")[0]);
        result.setArea(model.get("voter_area")[0]);
        result.setWordno(model.get("voter_wordno")[0]);
        result.setCitycorporation(model.get("voter_citycorporation")[0]);


        //candidate info
        result.setFullname(model.get("candidate_fullname")[0]);
        result.setPartytype(model.get("candidate_partytype")[0]);

        result.setStatus(1);

        resultDao.save(result);
        return new ModelAndView("redirect:/user/voterlog");
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Result> resultList = resultDao.getAll();
        map.put("resultList", resultList);
        System.out.println("get All resultList");
        return new ModelAndView("user/viewresult", "map", map);
    }
    
    @RequestMapping(value = "/getResultByName", method = RequestMethod.GET)
    public ModelAndView resultByName(ModelMap model) {
       Map<String, Object> map = new HashMap<String, Object>();
        Long resultByName = resultDao.getResultByName("Sheikh Fazle Noor Tapos");
        map.put("resultByName", resultByName);
       return new ModelAndView("user/viewresult", "map", map);
    }
    
}
