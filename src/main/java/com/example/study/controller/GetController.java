package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path ="/getMethod")// Localhost:8080/api/getMethod
    public String getRequest() {

        return "Hi getMethod";

    }

    @GetMapping("/getParameter") // Localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){
        String password = "bbbb";

        System.out.println("id :" + id + "pwd : " + pwd);

        return id+pwd;

    }
    //Localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    //검색 변수가 계속 늘어날 경우 :객체로 담아오기(model)
    @GetMapping("/getMultiParameter")
    public String getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return "OK";

    }

}
