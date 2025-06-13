package com.stellants.usrmgmt.service.impl;

import com.stellants.usrmgmt.dto.InputDeliverableDTO;
import com.stellants.usrmgmt.entity.InputDeliverable;
import com.stellants.usrmgmt.repository.InputDeliverableRepository;
import com.stellants.usrmgmt.service.InputDeliverableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InputDeliverableServiceImpl implements InputDeliverableService {

    @Autowired
    private InputDeliverableRepository repository;

    @Override
    public InputDeliverableDTO create(InputDeliverableDTO dto) {
        InputDeliverable entity = repository.save(new InputDeliverable(null, dto.getName()));
        return new InputDeliverableDTO(entity.getId(), entity.getName());
    }

    @Override
    public InputDeliverableDTO update(Long id, InputDeliverableDTO dto) {
        InputDeliverable entity = repository.findById(id).orElseThrow();
        entity.setName(dto.getName());
        InputDeliverable updated = repository.save(entity);
        return new InputDeliverableDTO(updated.getId(), updated.getName());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<InputDeliverableDTO> getAll() {
        return repository.findAll().stream()
                .map(e -> new InputDeliverableDTO(e.getId(), e.getName()))
                .collect(Collectors.toList());
    }
}
