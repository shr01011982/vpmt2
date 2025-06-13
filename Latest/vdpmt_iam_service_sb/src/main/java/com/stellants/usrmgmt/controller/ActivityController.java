package com.stellants.usrmgmt.controller;



import com.stellants.usrmgmt.dto.ActivityDTO;
import com.stellants.usrmgmt.response.ApiResponse;
import com.stellants.usrmgmt.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ActivityDTO>>> getAll() {
        List<ActivityDTO> list = service.getAll();
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Activities Listing", list));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ActivityDTO>> create(@RequestBody ActivityDTO dto) {
        ActivityDTO result = service.create(dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Activity added suceessfully", result));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ActivityDTO>> update(@PathVariable Long id, @RequestBody ActivityDTO dto) {
        ActivityDTO result = service.update(id, dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Activity updated suceessfully", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<List<Object>>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Activity deleted suceessfully", List.of()));
    }
}

