package com.dh.Integrador.Repository;

import com.dh.Integrador.Models.Entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {
}
