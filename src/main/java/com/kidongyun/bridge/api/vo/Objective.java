package com.kidongyun.bridge.api.vo;

import lombok.Data;

@Data
public class Objective {
    private int id;
    private String title;
    private String description;
    private String deadline;
    private int priority;
}
