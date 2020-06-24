package com.kidongyun.bridge.api.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Objective {
    private int id;
    private String title;
    private String description;
    private String deadline;
    private int priority;
}
