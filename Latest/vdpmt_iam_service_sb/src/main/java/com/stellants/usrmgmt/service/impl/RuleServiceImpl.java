package com.stellants.usrmgmt.service.impl;


import com.stellants.usrmgmt.dto.RuleDTO;
import com.stellants.usrmgmt.entity.Rule;
import com.stellants.usrmgmt.repository.RuleRepository;
import com.stellants.usrmgmt.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleRepository repository;

    @Override
    public RuleDTO createRule(RuleDTO dto) {
        Rule rule = new Rule(null, dto.getName(), dto.getDescription(), dto.getConditions(), dto.getWeek());
        Rule saved = repository.save(rule);
        return new RuleDTO(saved.getId(), saved.getName(), saved.getDescription(), saved.getConditions(), saved.getWeek());
    }

    @Override
    public RuleDTO updateRule(Long id, RuleDTO dto) {
        Rule rule = repository.findById(id).orElseThrow();
        rule.setName(dto.getName());
        rule.setDescription(dto.getDescription());
        rule.setConditions(dto.getConditions());
        rule.setWeek(dto.getWeek());
        Rule updated = repository.save(rule);
        return new RuleDTO(updated.getId(), updated.getName(), updated.getDescription(), updated.getConditions(), updated.getWeek());
    }

    @Override
    public void deleteRule(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<RuleDTO> getAllRules() {
        return repository.findAll().stream()
                .map(rule -> new RuleDTO(rule.getId(), rule.getName(), rule.getDescription(), rule.getConditions(), rule.getWeek()))
                .collect(Collectors.toList());
    }
}
