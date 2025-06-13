package com.stellants.usrmgmt.controller;



import com.stellants.usrmgmt.dto.RegionDTO;
import com.stellants.usrmgmt.response.ApiResponse;
import com.stellants.usrmgmt.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    private RegionService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<RegionDTO>>> getAll() {
        List<RegionDTO> result = service.getAll();
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Regions Listing", result));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<RegionDTO>> create(@RequestBody RegionDTO dto) {
        RegionDTO result = service.create(dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Region added suceessfully", result));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<RegionDTO>> update(@PathVariable Long id, @RequestBody RegionDTO dto) {
        RegionDTO result = service.update(id, dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Region updated suceessfully", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<List<Object>>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Region deleted suceessfully", List.of()));
    }
}

