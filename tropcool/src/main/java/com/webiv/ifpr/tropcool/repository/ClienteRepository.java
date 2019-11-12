package com.webiv.ifpr.tropcool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webiv.ifpr.tropcool.model.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
