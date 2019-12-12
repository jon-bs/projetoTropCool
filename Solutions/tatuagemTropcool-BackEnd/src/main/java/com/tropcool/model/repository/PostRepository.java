package com.tropcool.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tropcool.model.entity.Post;

public interface PostRepository extends JpaRepository< Post, Long>{

}
