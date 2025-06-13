package com.stellants.usrmgmt.service;

import com.stellants.usrmgmt.dto.RasiCategoryDTO;

import java.util.List;

public interface RasiCategoryService {
    RasiCategoryDTO create(RasiCategoryDTO dto);
    RasiCategoryDTO update(Long id, RasiCategoryDTO dto);
    void delete(Long id);
    List<RasiCategoryDTO> getAll();
}
