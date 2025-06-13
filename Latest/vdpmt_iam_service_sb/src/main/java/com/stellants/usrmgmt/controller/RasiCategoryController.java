package com.stellants.usrmgmt.controller;



import com.stellants.usrmgmt.dto.RasiCategoryDTO;
import com.stellants.usrmgmt.response.ApiResponse;
import com.stellants.usrmgmt.service.RasiCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rasi-categories")
public class RasiCategoryController {

    @Autowired
    private RasiCategoryService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<RasiCategoryDTO>>> getAll() {
        List<RasiCategoryDTO> result = service.getAll();
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "RASI Categories Listing", result));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<RasiCategoryDTO>> create(@RequestBody RasiCategoryDTO dto) {
        RasiCategoryDTO result = service.create(dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "RASI Category added suceessfully", result));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<RasiCategoryDTO>> update(@PathVariable Long id, @RequestBody RasiCategoryDTO dto) {
        RasiCategoryDTO result = service.update(id, dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "RASI Category updated suceessfully", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<List<Object>>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "RASI Category deleted suceessfully", List.of()));
    }
}
