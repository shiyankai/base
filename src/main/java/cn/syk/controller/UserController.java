package cn.syk.controller;

import cn.syk.listener.MyHttpSessionListener;
import cn.syk.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Value("${application.message:Hello World}")
    private String message ;

    /*@RequestMapping("/{name}")
    public String welcome(@PathVariable String name,Map<String, Object> map) {
        map.put("time", new Date());
        map.put("message", this.message);
        return "welcome";
    }*/

    @RequestMapping("/index")
    public Object index(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("zxc", "zxc");
        return  "index";
    }

    @RequestMapping("/online")
    public Object online() {
        return  "当前在线人数：" + MyHttpSessionListener.online + "人";
    }

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id) {
        return userService.selectByPrimaryKey(id).toString();
    }
    @RequestMapping("/show")
    public Map show(@Param("name") String name){
        Map map = new HashMap();
        int i = 0;
        while (i++<10000){
            map.put(i,i);
        }
        return map;
    }
}