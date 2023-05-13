package ru.neoflex.practice;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CalcRepository extends JpaRepository<Calc, Long> {
    List<Calc> findById(int id);
}
