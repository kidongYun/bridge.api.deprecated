package com.kidongyun.bridge.api.controller;

import com.google.gson.Gson;
import com.kidongyun.bridge.api.service.ObjectiveService;
import com.kidongyun.bridge.api.vo.Objective;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequiredArgsConstructor
@Slf4j
public class ObjectiveController {
    List<Objective> objectiveList = init();

    private final ObjectiveService objectiveService;

    @ResponseBody
    @PostMapping(value = "/objective", produces = "application/json;charset=UTF-8")
    public String postObjective() {
        List<Objective> objectiveList = objectiveService.selectObjective();
        return new Gson().toJson(objectiveList);
    }

    @ResponseBody
    @PostMapping(value = "/postObj", produces = "application/json;charset=UTF-8")
    public String tempObj() {
        return new Gson().toJson(objectiveList);
    }

    @ResponseBody
    @PostMapping(value = "/putObj", produces = "application/json;charset=UTF-8")
    public String putObj(@RequestBody Map<String, String> param) {

        log.info(param.toString());

        return "Success";
    }

    private List<Objective> init() {
        List<Objective> objectiveList = new ArrayList<>();

        for(int i=0; i < 50; i++) {
            Objective obj = new Objective();
            obj.setId(i);
            obj.setTitle("title" + i);
            obj.setDescription("description" + i);
            obj.setDeadline("2020-04-1" + i);
            obj.setPriority(i);
            objectiveList.add(obj);
        }

        return objectiveList;
    }
}
