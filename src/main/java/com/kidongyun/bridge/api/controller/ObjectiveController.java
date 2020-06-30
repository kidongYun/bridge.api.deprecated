package com.kidongyun.bridge.api.controller;

import com.google.gson.Gson;
import com.kidongyun.bridge.api.service.ObjectiveService;
import com.kidongyun.bridge.api.vo.Objective;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ObjectiveController {
    List<Objective> objectiveList = init();

    private final ObjectiveService objectiveService;

//    @ResponseBody
//    @PostMapping(value = "/objective", produces = "application/json;charset=UTF-8")
//    public String postObjective() {
//        List<Objective> objectiveList = objectiveService.selectObjective();
//        return new Gson().toJson(objectiveList);
//    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/postObj", produces = "application/json;charset=UTF-8")
    public String postObj() {

        // Get the data from Your Storages.

        return new Gson().toJson(objectiveList);
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/getObj", produces = "application/json;chatset=UTF-8")
    public String getObj() {
        return new Gson().toJson(objectiveList);
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping(value = "/putObj", produces = "application/json;charset=UTF-8")
    public String putObj(@RequestBody Objective obj) {

        System.out.println("KIDONG : " + obj.toString());
        objectiveList.add(obj);

        return new Gson().toJson(objectiveList);
    }

    @CrossOrigin
    @ResponseBody
    @DeleteMapping(value = "/deleteObj", produces = "application/json;charset=UTF-8")
    public String deleteObj(@RequestBody Map<String, Integer> param) {
        int id = param.get("id");

        List<Objective> filtered = objectiveList.stream()
                .filter(obj -> obj.getId() != id)
                .collect(Collectors.toList());

        objectiveList = filtered;

        return new Gson().toJson(objectiveList);
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
