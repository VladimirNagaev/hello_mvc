package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Hello world!
 *
 */
@Controller
public class App 
{
    @RequestMapping("/hello")
    public String display(HttpServletRequest req, Model m)
    {
        //read the provided form data
        String name=req.getParameter("name");
        String pass=req.getParameter("pass");
        if (name == null || pass == null) {
            return "index";
        }
        if(pass.equals("admin"))
        {
            String msg="Hello "+ name;
            //add a message to the model
            m.addAttribute("message", msg);
            return "viewpage";
        }
        else
        {
            String msg="Sorry "+ name+". You entered an incorrect password";
            m.addAttribute("message", msg);
            return "errorpage";
        }
    }
    @RequestMapping("/calc")
    public String calc(HttpServletRequest req, Model m) {
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        int res = Integer.parseInt(a) + Integer.parseInt(b);
        m.addAttribute("result", Integer.valueOf(res).toString());
        return "calc";
    }
}
