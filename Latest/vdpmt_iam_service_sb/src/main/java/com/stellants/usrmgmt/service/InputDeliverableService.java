package com.stellants.usrmgmt.service;

import com.stellants.usrmgmt.dto.InputDeliverableDTO;
import java.util.List;

public interface InputDeliverableService {
    InputDeliverableDTO create(InputDeliverableDTO dto);
    InputDeliverableDTO update(Long id, InputDeliverableDTO dto);
    void delete(Long id);
    List<InputDeliverableDTO> getAll();
}
