package com.lichao.boot.controller;


import com.lichao.boot.bean.Person;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {



    @PostMapping("/saveuser")
    public Person saveUser(Person person){

        return  person;
    }


    @RequestMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @CookieValue("_ga") String _ga){

        Map<String, Object> map = new HashMap<>();

//        map.put("id",id);
//        map.put("name",name);
//        map.put("pv",pv);
//
//        map.put("userAgent",userAgent);
//        map.put("header",header);

        map.put("_ga",_ga);

        return map;

    }


    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){

        Map<String,Object> map = new HashMap<>();

        map.put("content",content);

        return map;

    }


    // /car/sell;low=34;brand=byd,yd,bmw
    @GetMapping("/car/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brands,
                        @PathVariable("path") String path){

        Map<String,Object> map = new HashMap<>();

        map.put("low",low);
        map.put("brands",brands);
        map.put("path",path);

        return map;
    }


    // /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge){

        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);

        return map;
    }


}
