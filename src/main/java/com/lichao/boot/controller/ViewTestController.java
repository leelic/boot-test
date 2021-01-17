package com.lichao.boot.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ViewTestController {


    @GetMapping("/testSuccess")
    public String getSuccess(Model model){
        log.info("hhhhh,ok");

        // model 中的数据会被放在请求域中， request.setAttribute("a",aa);
        model.addAttribute("msg", "你好，HelloWorld！");
        model.addAttribute("link", "http://www.baidu.com");
        return "success";

    }

}
