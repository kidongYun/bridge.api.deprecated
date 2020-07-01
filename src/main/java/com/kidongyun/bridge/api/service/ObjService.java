package com.kidongyun.bridge.api.service;

import com.kidongyun.bridge.api.mapper.ObjMapper;
import com.kidongyun.bridge.api.vo.ObjCell;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjService {

    private final ObjMapper objMapper;

    public List<ObjCell> selectObjective() {
        return objMapper.selectObjective();
    }
}
