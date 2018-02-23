package com.demo.pkg.repositories;

import com.demo.pkg.controllers.OffsetLimitRequest;
import com.demo.pkg.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    Page<User> findByName(String name, Pageable pageable);
}
