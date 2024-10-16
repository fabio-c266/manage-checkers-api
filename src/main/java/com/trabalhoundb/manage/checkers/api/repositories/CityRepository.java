package com.trabalhoundb.manage.checkers.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalhoundb.manage.checkers.api.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
