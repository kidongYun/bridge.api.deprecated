package com.kidongyun.bridge.api.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ObjCell extends Cell {
    private String title;
    private String description;
    private String deadline;
    private int priority;
}
