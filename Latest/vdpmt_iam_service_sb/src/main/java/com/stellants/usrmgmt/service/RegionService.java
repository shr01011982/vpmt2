package com.stellants.usrmgmt.service;



import com.stellants.usrmgmt.dto.RegionDTO;

import java.util.List;

public interface RegionService {
    RegionDTO create(RegionDTO dto);
    RegionDTO update(Long id, RegionDTO dto);
    void delete(Long id);
    List<RegionDTO> getAll();
}
