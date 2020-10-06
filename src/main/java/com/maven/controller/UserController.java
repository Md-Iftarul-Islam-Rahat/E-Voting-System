package com.maven.controller;

import com.maven.dao.CandidatesDao;
import com.maven.dao.PartiesDao;
import com.maven.dao.ResultDao;
import com.maven.dao.VotersDao;
import com.maven.model.Candidates;
import com.maven.model.Parties;
import com.maven.model.Result;
import com.maven.model.Voters;
import com.maven.service.CandidatesService;
import com.maven.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    VotersDao votersDao;

    @Autowired
    PartiesDao partiesDao;

    @Autowired
    CandidatesDao candidatesDao;

    @Autowired
    CandidatesService candidatesService;

    @Autowired
    ResultDao resultDao;

    @RequestMapping(value = "/create")
    public String create() {
        System.out.println("Hello User");
        return "user/create";
    }

    @RequestMapping(value = "/adminlogin")
    public String adminlogin() {
        System.out.println("Hello User");
        return "user/adminlogin";
    }

    @RequestMapping(value = "/voteview")
    public String voteview() {
        System.out.println("voteview page here  ....");
        return "admin/voteview";
    }

    @RequestMapping(value = "/viewresult")//vote count
    public ModelAndView viewresult() {
        System.out.println("resultview page here  ....");
        Map<String, Object> map = new HashMap<String, Object>();
        List<Result> resultList = resultDao.getAll();
        map.put("resultList", resultList);
        Long resultByNameIsraque = resultDao.getResultByName("Eng. Israque Hossain");
        map.put("resultByNameIsraque", resultByNameIsraque);
        
        Long resultByNameTapos = resultDao.getResultByName("Sheikh Fazle Noor Tapos");
        map.put("resultByNameTapos", resultByNameTapos);
        
        Long resultByNameMilton = resultDao.getResultByName("Hazi Saifuddin milton");
        map.put("resultByNameMilton", resultByNameMilton);
        
        Long resultByNameRezaul = resultDao.getResultByName("Mufti Rezaul Karim");
        map.put("resultByNameRezaul", resultByNameRezaul);
        
        return new ModelAndView("user/viewresult", "map", map);
    }

    @RequestMapping(value = "/goforvote")
    public String goforvote(ModelMap map) {
        System.out.println("Hello User");

        List<Candidates> candidates = candidatesService.getAll();
        map.addAttribute("candidates", candidates);
        for (Candidates candidate : candidates) {
            System.out.println(candidate.getFullname() + " .......");
        }
        return "user/goforvote";
    }

    @RequestMapping(value = "/voterlog")
    public String voterlog() {
        System.out.println("Project voter log Home page");
        return "user/voterlog";
    }

    @RequestMapping(value = "/addvoter")
    public ModelAndView addvoter() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Voters> voterList = votersDao.getAll();
        map.put("voterList", voterList);
        System.out.println("Admin AddVoter page");
        return new ModelAndView("redirect:/voters/getAll", "map", map);
    }

    @RequestMapping(value = "/addparty")
    public ModelAndView addparty() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Parties> partiesList = partiesDao.getAll();
        map.put("partiesList", partiesList);
        System.out.println("Admin Add party page");
        return new ModelAndView("redirect:/parties/getAll", "map", map);
    }

    @RequestMapping(value = "/addcandidate")
    public ModelAndView addcandidate() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Candidates> candidatesList = candidatesDao.getAll();
        map.put("candidatesList", candidatesList);
        System.out.println("Admin Add Candidates page");
        return new ModelAndView("redirect:/candidates/getAll", "map", map);
    }

    @RequestMapping(value = "/voterwelcomepage")
    public String voterwelcomepage() {
        System.out.println("Voter Details page");
        return "user/voterwelcomepage";
    }

    @RequestMapping(value = "/sorrypage")
    public String sorrypage() {
        System.out.println("Voter Login in failed");
        return "user/sorrypage";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        userService.save(request);
        return new ModelAndView("user/create");
    }

    @RequestMapping(value = "/adminloginaction", method = RequestMethod.POST)//adminloginaction was loginAction
    public ModelAndView adminloginaction(ModelMap map, HttpServletRequest request) {
        Map<String, String[]> model = request.getParameterMap();

        boolean action = userService.login(request);
        if (action) {
            map.addAttribute("username", model.get("username")[0]);
            map.addAttribute("password", model.get("password")[0]);

            return new ModelAndView("admin/addvoter");
        } else {
            return new ModelAndView("user/adminlogin");//problm Not solved
        }
    }

    @RequestMapping(value = "/voterloginaction", method = RequestMethod.POST)
    public ModelAndView voterloginaction(ModelMap map, HttpServletRequest request) {
        System.out.println("Step By Step////");
        Map<String, String[]> model = request.getParameterMap();
        boolean action = userService.voterlogin(request);

        if (action) {
            System.out.println(model.get("nid")[0] + "         .......");
            Voters voters = votersDao.getByNId(model.get("nid")[0]);

            List<Candidates> candidates = candidatesService.getAll();

            map.addAttribute("candidates", candidates);
            map.addAttribute("voters", voters);

            return new ModelAndView("user/goforvote");

        } else {
            return new ModelAndView("user/voterlog");//redirect:/ redirect new added
        }
    }

}

@Controller
class IndexController {

    @RequestMapping(value = "/")
    public String index() {
        return "user/voterlog";
    }

}
