package com.kidongyun.bridge.api.controller;

import com.google.gson.Gson;
import com.kidongyun.bridge.api.service.ObjService;
import com.kidongyun.bridge.api.vo.Cell;
import com.kidongyun.bridge.api.vo.DateCell;
import com.kidongyun.bridge.api.vo.ObjCell;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class ObjController {
    List<Cell> objList = init();

    private final ObjService objService;

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

        return new Gson().toJson(objList);
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/getObj", produces = "application/json;chatset=UTF-8")
    public String getObj() {
        return new Gson().toJson(objList);
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping(value = "/putObj", produces = "application/json;charset=UTF-8")
    public String putObj(@RequestBody ObjCell obj) {

        System.out.println("KIDONG : " + obj.toString());
        objList.add(obj);

        return new Gson().toJson(objList);
    }

    @CrossOrigin
    @ResponseBody
    @DeleteMapping(value = "/deleteObj", produces = "application/json;charset=UTF-8")
    public String deleteObj(@RequestBody Map<String, Integer> param) {
        int id = param.get("id");

        objList = objList.stream()
                .filter(obj -> obj.getId() != id)
                .collect(Collectors.toList());

        return new Gson().toJson(objList);
    }

    private List<Cell> init() {
        List<Cell> objCellList = new ArrayList<>();

        for(int i=0; i < 50; i++) {

            if(i%5 == 0) {
                DateCell date = new DateCell();
                date.setId(i);
                date.setDate("2020-04-1" + i);

                objCellList.add(date);

            } else {

                ObjCell obj = new ObjCell();
                obj.setId(i);
                obj.setTitle("title" + i);
                obj.setDescription("description" + i);
                obj.setDeadline("2020-04-1" + i);
                obj.setPriority(i);

                objCellList.add(obj);
            }
        }

        return objCellList;
    }
}
