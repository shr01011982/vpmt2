package com.stellants.usrmgmt.service;

import com.stellants.usrmgmt.dto.RuleDTO;

import java.util.List;

public interface RuleService {
    RuleDTO createRule(RuleDTO dto);
    RuleDTO updateRule(Long id, RuleDTO dto);
    void deleteRule(Long id);
    List<RuleDTO> getAllRules();
}
