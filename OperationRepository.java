package com.java.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.model.Operation;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

}
