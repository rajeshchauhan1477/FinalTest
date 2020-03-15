package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.Operation;
import com.java.repository.OperationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OperationService {

    private OperationRepository repository;

    @Autowired
    public OperationService(OperationRepository repository) {
        this.repository = repository;
    }

    public List<Operation> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Operation> findById(Long id) {
        return repository.findById(id);
    }

    public Operation save(Operation stock) {
        return repository.save(stock);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
