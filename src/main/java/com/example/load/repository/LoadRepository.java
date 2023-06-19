package com.example.load.repository;
import com.example.load.model.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoadRepository extends JpaRepository<Load, Long> {
    List<Load> findAllLoad();

    Optional<Load> findById(Long id);
}
