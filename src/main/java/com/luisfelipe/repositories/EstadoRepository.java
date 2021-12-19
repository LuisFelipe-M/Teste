package com.luisfelipe.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luisfelipe.senai.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}