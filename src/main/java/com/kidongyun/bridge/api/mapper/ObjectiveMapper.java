package com.kidongyun.bridge.api.mapper;

import com.kidongyun.bridge.api.vo.Objective;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ObjectiveMapper {
    List<Objective> selectObjective();
}
