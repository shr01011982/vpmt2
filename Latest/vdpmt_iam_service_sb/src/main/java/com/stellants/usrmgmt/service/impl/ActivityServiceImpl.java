package com.stellants.usrmgmt.service.impl;



import com.stellants.usrmgmt.dto.ActivityDTO;
import com.stellants.usrmgmt.entity.Activity;
import com.stellants.usrmgmt.entity.RasiCategory;
import com.stellants.usrmgmt.repository.ActivityRepository;
import com.stellants.usrmgmt.repository.RasiCategoryRepository;
import com.stellants.usrmgmt.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepo;

    @Autowired
    private RasiCategoryRepository rasiRepo;

    @Override
    public ActivityDTO create(ActivityDTO dto) {
        RasiCategory cat = rasiRepo.findById(dto.getRasiCatId()).orElseThrow();
        Activity activity = new Activity();
        activity.setName(dto.getName());
        activity.setRasiCategory(cat);
        activity = activityRepo.save(activity);

        return new ActivityDTO(
                activity.getId(),
                activity.getName(),
                cat.getId(),
                cat.getName() + " (" + activity.getName() + ")"
        );
    }

    @Override
    public ActivityDTO update(Long id, ActivityDTO dto) {
        Activity activity = activityRepo.findById(id).orElseThrow();
        RasiCategory cat = rasiRepo.findById(dto.getRasiCatId()).orElseThrow();
        activity.setName(dto.getName());
        activity.setRasiCategory(cat);
        activity = activityRepo.save(activity);

        return new ActivityDTO(
                activity.getId(),
                activity.getName(),
                cat.getId(),
                cat.getName() + " (" + activity.getName() + ")"
        );
    }

    @Override
    public void delete(Long id) {
        activityRepo.deleteById(id);
    }

    @Override
    public List<ActivityDTO> getAll() {
        return activityRepo.findAll().stream()
                .map(act -> new ActivityDTO(
                        act.getId(),
                        act.getName(),
                        act.getRasiCategory().getId(),
                        act.getRasiCategory().getName() + " (" + act.getName() + ")"
                ))
                .collect(Collectors.toList());
    }
}
