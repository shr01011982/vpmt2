package com.stellants.usrmgmt.controller;

import com.stellants.usrmgmt.dto.SourceDTO;
import com.stellants.usrmgmt.response.ApiResponse;
import com.stellants.usrmgmt.service.SourceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sources")
@Tag(name="Source Management")
public class SourceController {

    @Autowired
    private SourceService service;

    @GetMapping
    @Operation(summary = "List off Source")
    public ResponseEntity<ApiResponse<List<SourceDTO>>> getAll() {
        List<SourceDTO> list = service.getAll();
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Sources Listing", list));
    }

    @PostMapping
    @Operation(summary = "Create a Source")
    public ResponseEntity<ApiResponse<SourceDTO>> create(@RequestBody SourceDTO dto) {
        SourceDTO result = service.create(dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Source added suceessfully", result));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Source")
    public ResponseEntity<ApiResponse<SourceDTO>> update(@PathVariable Long id, @RequestBody SourceDTO dto) {
        SourceDTO result = service.update(id, dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Source updated suceessfully", result));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Source")
    public ResponseEntity<ApiResponse<List<Object>>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Source deleted suceessfully", List.of()));
    }
}
