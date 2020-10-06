/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.controller;

import com.maven.dao.CandidatesDao;
import com.maven.model.Candidates;
import com.maven.service.CandidatesService;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "candidates")
public class CandidatesController {

    @Autowired
    CandidatesService candidatesService;

    @Autowired
    CandidatesDao candidatesDao;

    @RequestMapping(value = "/save")
    public String savecandidate() {
        System.out.println("Add Candidate plz...");
        return "admin/addcandidate";
    }

//    @RequestMapping(value = "/addpcandidatesave", method = RequestMethod.POST)
//    public ModelAndView save(HttpServletRequest request) {
//        cdService.save(request);
//        return new ModelAndView("admin/addcandidate");
//    }
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ModelAndView save(HttpServletRequest request) {
//        cdService.save(request);
//        return new ModelAndView("redirect:/candidates/getAll");
//    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload1,@RequestParam CommonsMultipartFile[] fileUpload2) throws Exception {
        
                candidatesService.save(request, fileUpload1, fileUpload2);
           
        return new ModelAndView("redirect:/candidates/getAll");
    }
    
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ModelAndView save(HttpServletRequest request,
//            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
//        if (fileUpload != null && fileUpload.length > 0) {
//            for (CommonsMultipartFile aFile : fileUpload) {
//                System.out.println("Saving file: " + aFile.getOriginalFilename());
//                cdService.save(request, fileUpload);
//            }
//        }
//        return new ModelAndView("redirect:/candidates/getAll");
//    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Candidates> candidatesList = candidatesDao.getAll();
        map.put("candidatesList", candidatesList);
        System.out.println("get All Candidates");
        System.out.println("Admin Add Candidates page");
        return new ModelAndView("admin/addcandidate", "map", map);
    }

    @RequestMapping(value = "/imageDisplayCandidate", method = RequestMethod.GET)//candidate image display mathod 
    public void showImageCandidate(@RequestParam("id") Integer Id, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {
        Candidates candidates = candidatesDao.getById(Id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(candidates.getCandidateimage());
        response.getOutputStream().close();
    }
    
    @RequestMapping(value = "/imageDisplayLogo", method = RequestMethod.GET)//logo image display mathod 
    public void showImageLogo(@RequestParam("id") Integer Id, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {
        Candidates candidates = candidatesDao.getById(Id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(candidates.getLogoimage());
        response.getOutputStream().close();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        candidatesDao.delete(id);
        return "redirect:/candidates/getAll";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(ModelMap model, @PathVariable("id") int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Candidates> candidatesList = candidatesDao.getAll();
        map.put("candidatesList", candidatesList);
        Candidates candidates = candidatesDao.getById(id);
        model.addAttribute("candidates", candidates);
        return new ModelAndView("admin/addcandidate", "map", map);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ModelMap map, @ModelAttribute("candidates") Candidates candidates) {
        //map.addAttribute("emp", employee);
        Candidates e = candidatesDao.update(candidates);
        return "redirect:/candidates/getAll";
    }
}
