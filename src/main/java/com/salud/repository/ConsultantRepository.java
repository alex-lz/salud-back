package com.salud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salud.model.Consultant;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Long>{

}
