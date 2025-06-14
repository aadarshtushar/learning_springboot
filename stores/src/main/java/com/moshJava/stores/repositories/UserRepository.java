package com.moshJava.stores.repositories;

import com.moshJava.stores.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface UserRepository extends CrudRepository<User, Long> {
}
