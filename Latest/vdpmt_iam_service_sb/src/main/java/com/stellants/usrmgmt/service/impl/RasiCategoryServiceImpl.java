package com.stellants.usrmgmt.service.impl;



import com.stellants.usrmgmt.dto.RasiCategoryDTO;
import com.stellants.usrmgmt.entity.RasiCategory;
import com.stellants.usrmgmt.repository.RasiCategoryRepository;
import com.stellants.usrmgmt.service.RasiCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RasiCategoryServiceImpl implements RasiCategoryService {

    @Autowired
    private RasiCategoryRepository repository;

    @Override
    public RasiCategoryDTO create(RasiCategoryDTO dto) {
        RasiCategory entity = new RasiCategory();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity = repository.save(entity);
        return new RasiCategoryDTO(entity.getId(), entity.getName(), entity.getDescription());
    }

    @Override
    public RasiCategoryDTO update(Long id, RasiCategoryDTO dto) {
        RasiCategory entity = repository.findById(id).orElseThrow();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity = repository.save(entity);
        return new RasiCategoryDTO(entity.getId(), entity.getName(), entity.getDescription());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<RasiCategoryDTO> getAll() {
        return repository.findAll().stream()
                .map(r -> new RasiCategoryDTO(r.getId(), r.getName(), r.getDescription()))
                .collect(Collectors.toList());
    }
}
