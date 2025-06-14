package com.moshJava.stores.repositories;

import com.moshJava.stores.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
