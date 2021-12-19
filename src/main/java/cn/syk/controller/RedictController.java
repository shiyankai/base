package cn.syk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RedictController {
    @RequestMapping("/mode")
    public ModelAndView index(String name){
        //目标文件载templates文件夹里面
        return new ModelAndView("mode");
    }
    @RequestMapping("/index")
    public String redirect2(HttpServletRequest request){
        //目标文件载static文件夹里面
        return "redirect:index.html";
    }
}
