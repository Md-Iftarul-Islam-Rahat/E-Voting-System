/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.controller;

import com.maven.dao.PartiesDao;
import com.maven.model.Parties;
import com.maven.service.PartiesService;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/parties")
public class PartiesController {
    
    @Autowired
    PartiesService partiesService;
    
    @Autowired
    PartiesDao partiesDao;
    
    @RequestMapping(value = "/save")
    public String addparty() {
        System.out.println("Add party plz...");
        return "admin/addparty";
    }
    
//    @RequestMapping(value = "/addpartysave", method = RequestMethod.POST)
//    public ModelAndView save(HttpServletRequest request) {
//        partiesService.save(request);
//        return new ModelAndView("admin/addparty");
//    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
        if(fileUpload != null && fileUpload.length > 0){
            for(CommonsMultipartFile aFile : fileUpload) {
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                partiesService.save(request, fileUpload);
            }
        }
        return new ModelAndView("redirect:/parties/getAll");
    }
    
    @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)//image display mathod candidate
    public void showImage(@RequestParam("id") Integer Id, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {
        Parties parties = partiesDao.getById(Id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(parties.getImglogo());
        response.getOutputStream().close();
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
    public ModelAndView getAll(){
    Map<String, Object> map = new HashMap<String, Object>();
        List<Parties> partiesList = partiesDao.getAll();
        map.put("partiesList", partiesList);
        System.out.println("get All voters");
        System.out.println("Admin AddVoter page");
    return new ModelAndView("admin/addparty","map",map);
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) { //Using @PathVariable by URL
        partiesDao.delete(id);
        return "redirect:/parties/getAll";  // Redirect to a Handler Mapping after an action
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(ModelMap model, @PathVariable("id") int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Parties> partiesList = partiesDao.getAll();
        map.put("partiesList", partiesList);
        Parties parties = partiesDao.getById(id);
        model.addAttribute("parties", parties);
        return new ModelAndView("admin/addparty", "map",map);
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ModelMap map, @ModelAttribute("parties") Parties parties) {
        //map.addAttribute("emp", employee);
        Parties e = partiesDao.update(parties);
        return "redirect:/parties/getAll";
    }
}
