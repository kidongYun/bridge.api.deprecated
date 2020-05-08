package com.kidongyun.bridge.api.service;

import com.kidongyun.bridge.api.mapper.ObjectiveMapper;
import com.kidongyun.bridge.api.vo.Objective;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjectiveService {

    private final ObjectiveMapper objectiveMapper;

    public List<Objective> selectObjective() {
        return objectiveMapper.selectObjective();
    }
}
