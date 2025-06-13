package com.stellants.usrmgmt.service;

import com.stellants.usrmgmt.dto.ActivityDTO;

import java.util.List;

public interface ActivityService {
    ActivityDTO create(ActivityDTO dto);
    ActivityDTO update(Long id, ActivityDTO dto);
    void delete(Long id);
    List<ActivityDTO> getAll();
}

