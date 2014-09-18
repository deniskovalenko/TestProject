package com.springapp.mvc;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class UserController {

    static List<User> userList = new ArrayList<User>();
   static{
       userList.add(new User("Yura", "Uhlanov"));
       userList.add(new User("Oleg", "Yatsyshin"));
       userList.add(new User("Alex", "Malik"));
       userList.add(new User("Slavik", "Shapoval"));
   }
    static List<String> userList1 = new ArrayList<String>();
    static{
        userList1.add("Uhlanov");
        userList1.add("Oleg");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirect(ModelMap model) {
        //model.addAttribute("userList", userList);
        return "redirect: index/";

    }


	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(/*@ModelAttribute("model") */ModelMap model) {
        model.addAttribute("userList", userList);
        return "index";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("user") User user){
        if (null != user && null != user.getFirstname()
                && null != user.getLastname() && !user.getFirstname().isEmpty()
                && !user.getLastname().isEmpty()) {
            synchronized (userList) { //maybe won't work - we get only copy of list
            userList.add(user);
            }
            // maybe model attribute add?
        }
        return "redirect: index";
    }
    @RequestMapping(value="/clearList", method = RequestMethod.GET)
    public String clearList(){
        userList.clear();
        return "redirect: index";
    }

	}
