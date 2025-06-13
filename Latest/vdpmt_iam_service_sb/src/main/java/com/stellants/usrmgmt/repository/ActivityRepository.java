package com.stellants.usrmgmt.repository;



import com.stellants.usrmgmt.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}

