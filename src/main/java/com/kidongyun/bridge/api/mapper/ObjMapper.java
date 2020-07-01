package com.kidongyun.bridge.api.mapper;

import com.kidongyun.bridge.api.vo.ObjCell;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ObjMapper {
    List<ObjCell> selectObjective();
}
