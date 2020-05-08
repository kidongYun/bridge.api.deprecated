package com.kidongyun.bridge.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TodoController {

    @ResponseBody
    @RequestMapping(value = "/")
    public String index() { return "It's Index."; }

    @ResponseBody
    @RequestMapping(value = "/todo")
    public String todo() {
        return "It's Todo.";
    }
}
