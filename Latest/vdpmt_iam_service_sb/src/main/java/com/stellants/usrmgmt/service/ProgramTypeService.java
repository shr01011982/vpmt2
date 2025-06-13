package com.stellants.usrmgmt.service;



import com.stellants.usrmgmt.dto.ProgramTypeDTO;

import java.util.List;

public interface ProgramTypeService {
    ProgramTypeDTO create(ProgramTypeDTO dto);
    ProgramTypeDTO update(Long id, ProgramTypeDTO dto);
    void delete(Long id);
    List<ProgramTypeDTO> getAll();
}
