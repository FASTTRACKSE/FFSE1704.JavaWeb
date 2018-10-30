package com.javatpoint;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;  
@Controller  
public class HelloController {  
    @RequestMapping("/hello")  
    public ModelAndView helloWorld() {  	
        String message = "HELLO WORLD";  
        return new ModelAndView("hellopage", "message", message);  
    }  
} 