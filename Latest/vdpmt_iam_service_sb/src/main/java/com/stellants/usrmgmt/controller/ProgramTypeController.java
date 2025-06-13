package com.stellants.usrmgmt.controller;



import com.stellants.usrmgmt.dto.ProgramTypeDTO;
import com.stellants.usrmgmt.response.ApiResponse;
import com.stellants.usrmgmt.service.ProgramTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/program-types")
public class ProgramTypeController {

    @Autowired
    private ProgramTypeService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProgramTypeDTO>>> getAll() {
        List<ProgramTypeDTO> programs = service.getAll();
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Program Listing", programs));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProgramTypeDTO>> create(@RequestBody ProgramTypeDTO dto) {
        ProgramTypeDTO result = service.create(dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Program type added suceessfully", result));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProgramTypeDTO>> update(@PathVariable Long id, @RequestBody ProgramTypeDTO dto) {
        ProgramTypeDTO result = service.update(id, dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Program type updated suceessfully", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<List<Object>>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Program type deleted suceessfully", List.of()));
    }
}
