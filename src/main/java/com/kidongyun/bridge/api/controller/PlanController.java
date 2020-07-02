package com.kidongyun.bridge.api.controller;

import com.kidongyun.bridge.api.vo.Cell;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PlanController {
    List<Cell> planList = init();

    private List<Cell> init() {
        List<Cell> planList = new ArrayList<>();

        for(int i=0; i<50; i++) {
            log.info("hello world");
        }

        return planList;
    }

}



햣