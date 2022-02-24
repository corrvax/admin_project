package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {
    //[Post 사용경우]
    //HTML <Form>
    //ajax 비동기 검색 시 사용함
    //http post body -> data 넣어서 받음

    //@RequestMapping(method = RequestMethod.POST,path = "/postMethod")
    //@PostMapping("/postMethod",produces = "application.json") //기본이 json
    @PostMapping("/postMethod")
    public String postMethod(@RequestBody SearchParam searchParam){
        return "OK";
    }
}
