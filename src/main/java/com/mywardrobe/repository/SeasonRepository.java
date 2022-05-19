package com.mywardrobe.repository;

import com.mywardrobe.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Integer> {

        Season findByName(String name);
}
