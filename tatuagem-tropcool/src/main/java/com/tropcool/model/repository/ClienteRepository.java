package com.tropcool.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tropcool.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository< Cliente, Long> {

}
