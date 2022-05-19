package com.mywardrobe.repository;

import com.mywardrobe.domain.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size, Integer> {
    Size findByName(String name);
}
