package com.mywardrobe.repository;


import com.mywardrobe.domain.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SexRepository extends JpaRepository<Sex, Integer> {

    Sex findByName(String name);
}
