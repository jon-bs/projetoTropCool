package com.tropcool.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tropcool.model.entity.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

}
