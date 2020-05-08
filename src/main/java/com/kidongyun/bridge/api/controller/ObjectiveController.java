package com.kidongyun.bridge.api.controller;

import com.google.gson.Gson;
import com.kidongyun.bridge.api.service.ObjectiveService;
import com.kidongyun.bridge.api.vo.Objective;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequiredArgsConstructor
public class ObjectiveController {

    private final ObjectiveService objectiveService;

    @ResponseBody
    @PostMapping(value = "/objective", produces="text/json;charset=UTF-8")
    public String postObjective() {
        List<Objective> objectiveList = objectiveService.selectObjective();
        return new Gson().toJson(objectiveList);
    }
}
