package com.stellants.usrmgmt.service.impl;


import com.stellants.usrmgmt.dto.SourceDTO;
import com.stellants.usrmgmt.entity.Source;
import com.stellants.usrmgmt.repository.SourceRepository;
import com.stellants.usrmgmt.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SourceServiceImpl implements SourceService {

    @Autowired
    private SourceRepository repository;

    @Override
    public SourceDTO create(SourceDTO dto) {
        Source entity = new Source(null, dto.getName());
        Source saved = repository.save(entity);
        return new SourceDTO(saved.getId(), saved.getName());
    }

    @Override
    public SourceDTO update(Long id, SourceDTO dto) {
        Source entity = repository.findById(id).orElseThrow();
        entity.setName(dto.getName());
        Source updated = repository.save(entity);
        return new SourceDTO(updated.getId(), updated.getName());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<SourceDTO> getAll() {
        return repository.findAll().stream()
                .map(s -> new SourceDTO(s.getId(), s.getName()))
                .collect(Collectors.toList());
    }
}
