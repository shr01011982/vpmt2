package com.stellants.usrmgmt.service.impl;



import com.stellants.usrmgmt.dto.RegionDTO;
import com.stellants.usrmgmt.entity.Region;
import com.stellants.usrmgmt.repository.RegionRepository;
import com.stellants.usrmgmt.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository repository;

    @Override
    public RegionDTO create(RegionDTO dto) {
        Region region = new Region();
        region.setName(dto.getName());
        region = repository.save(region);
        return new RegionDTO(region.getId(), region.getName());
    }

    @Override
    public RegionDTO update(Long id, RegionDTO dto) {
        Region region = repository.findById(id).orElseThrow();
        region.setName(dto.getName());
        region = repository.save(region);
        return new RegionDTO(region.getId(), region.getName());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<RegionDTO> getAll() {
        return repository.findAll().stream()
                .map(r -> new RegionDTO(r.getId(), r.getName()))
                .collect(Collectors.toList());
    }
}

