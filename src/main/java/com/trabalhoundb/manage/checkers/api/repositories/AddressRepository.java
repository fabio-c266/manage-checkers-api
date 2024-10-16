package com.trabalhoundb.manage.checkers.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhoundb.manage.checkers.api.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
