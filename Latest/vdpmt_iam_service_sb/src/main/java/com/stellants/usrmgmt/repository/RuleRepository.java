package com.stellants.usrmgmt.repository;


import com.stellants.usrmgmt.entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, Long> {
}

