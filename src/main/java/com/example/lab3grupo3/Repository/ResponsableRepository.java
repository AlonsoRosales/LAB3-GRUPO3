package com.example.lab3grupo3.Repository;

import com.example.lab3grupo3.Entity.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Integer> {
}