package com.stellants.usrmgmt.controller;

import com.stellants.usrmgmt.dto.InputDeliverableDTO;
import com.stellants.usrmgmt.response.ApiResponse;
import com.stellants.usrmgmt.service.InputDeliverableService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/input-deliverables")
@Tag(name = "Input Deliverables", description = "CRUD operations for Input Deliverables")
public class InputDeliverableController {

    @Autowired
    private InputDeliverableService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<InputDeliverableDTO>>> getAll() {
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Input Deliverables Listing", service.getAll()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<InputDeliverableDTO>> create(@RequestBody InputDeliverableDTO dto) {
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Input Deliverable added suceessfully", service.create(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<InputDeliverableDTO>> update(@PathVariable Long id, @RequestBody InputDeliverableDTO dto) {
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Input Deliverable updated suceessfully", service.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<List<Object>>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Input Deliverable deleted suceessfully", List.of()));
    }
}
