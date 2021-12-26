package cn.syk.tools.autoCreateCode.codeModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(DemoController.class);
    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/login")
    public String Login() {
        return "login";
    }
}