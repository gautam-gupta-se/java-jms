package com.springjms.javajms.repository;

import com.springjms.javajms.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity,Long> {
    List<CustomerEntity> findByEmail(String email);
}
