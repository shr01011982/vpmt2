package com.stellants.usrmgmt.service;


import com.stellants.usrmgmt.dto.SourceDTO;
import java.util.List;

public interface SourceService {
    SourceDTO create(SourceDTO dto);
    SourceDTO update(Long id, SourceDTO dto);
    void delete(Long id);
    List<SourceDTO> getAll();
}
