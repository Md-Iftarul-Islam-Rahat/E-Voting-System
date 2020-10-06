package com.maven.controller;

import com.maven.dao.VotersDao;
import com.maven.model.Voters;
import com.maven.service.VotersService;
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
@RequestMapping(value = "/voters")
public class VotersController {

    @Autowired
    VotersService votersService;

    @Autowired
    VotersDao votersDao;

    @RequestMapping(value = "/save")
    public String voterlog() {
        System.out.println("Project voter log Home page");
        return "admin/addvoter";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload) {
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                votersService.save(request, fileUpload);
            }
        }
        return new ModelAndView("redirect:/voters/getAll");
    }

    @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)//image display mathod candidate
    public void showImage(@RequestParam("id") Integer Id, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {
        Voters parties = votersDao.getById(Id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(parties.getVoterimage());
        response.getOutputStream().close();
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Voters> voterList = votersDao.getAll();
        map.put("voterList", voterList);
        System.out.println("get All voters");
        System.out.println("Admin AddVoter page");
        return new ModelAndView("admin/addvoter", "map", map);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) { //Using @PathVariable by URL
        votersDao.delete(id);
        return "redirect:/voters/getAll";  // Redirect to a Handler Mapping after an action
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(ModelMap model, @PathVariable("id") int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Voters> voterList = votersDao.getAll();
        map.put("voterList", voterList);
        Voters voters = votersDao.getById(id);
        model.addAttribute("voters", voters);
        return new ModelAndView("admin/addvoter", "map", map);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ModelMap map, @ModelAttribute("voters") Voters voters) {
        //map.addAttribute("emp", employee);
        Voters e = votersDao.update(voters);
        return "redirect:/voters/getAll";
    }

}
