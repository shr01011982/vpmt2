package com.stellants.usrmgmt.controller;


import com.stellants.usrmgmt.dto.RuleDTO;
import com.stellants.usrmgmt.response.ApiResponse;
import com.stellants.usrmgmt.service.RuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name="Rule Management")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @GetMapping
    @Operation(summary = "list off rule")
    public ResponseEntity<ApiResponse<List<RuleDTO>>> getAllRules() {
        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Rule Managements Listing", ruleService.getAllRules()));
    }

    @PostMapping
    @Operation(summary = "Create a rule")
    public ResponseEntity<ApiResponse<RuleDTO>> createRule(@RequestBody RuleDTO dto) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Rule Management added suceessfully", ruleService.createRule(dto)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a rule")
    public ResponseEntity<ApiResponse<RuleDTO>> updateRule(@PathVariable Long id, @RequestBody RuleDTO dto) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", 200, "Rule Management updated suceessfully", ruleService.updateRule(id, dto)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a rule")
    public ResponseEntity<ApiResponse<List<Object>>> deleteRule(@PathVariable Long id) {
        ruleService.deleteRule(id);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Rule Management deleted suceessfully", List.of()));
    }
}
