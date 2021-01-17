package com.lichao.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {


    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){

        request.setAttribute("msg","成功了...");
        request.setAttribute("code",200);

        return "forward:/success";
    }



    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("map1","666");
        model.addAttribute("model2","777");

        request.setAttribute("request3","888");

        Cookie cookie = new Cookie("c1", "v1");
        response.addCookie(cookie);

        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "msg", required = false) String msg,
                       @RequestAttribute(value = "code", required = false) Integer code,
                       HttpServletRequest request){

        Object msg1 = request.getAttribute("msg");

        Map<String, Object> map = new HashMap<>();

        Object map1 = request.getAttribute("map1");
        Object model2 = request.getAttribute("model2");
        Object request3 = request.getAttribute("request3");

//        map.put("msg",msg);
//        map.put("msg1",msg1);
//        map.put("code",code);
        map.put("map1",map1);
        map.put("model2",model2);
        map.put("request3",request3);

        return map;

    }
}
