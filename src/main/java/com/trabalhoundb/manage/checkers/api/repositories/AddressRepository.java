package com.trabalhoundb.manage.checkers.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoundb.manage.checkers.api.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
