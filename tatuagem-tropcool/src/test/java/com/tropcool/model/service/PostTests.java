package com.tropcool.model.service;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.tropcool.model.entity.Post;
import com.tropcool.model.entity.Tatuador;
import com.tropcool.model.repository.PostRepository;
import com.tropcool.model.repository.TatuadorRepository;

public class PostTests extends AbstractIntegrationTests{
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private TatuadorRepository tatuadorRepository;
	
	/**
	 * ====================================== CADASTRAR ===========================================
	 */
	
	/* CADASTRAR POST - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/tatuadores.sql"
	})
	public void cadastrarPostMustPass() {
		Tatuador tatuador = tatuadorRepository.findById(1001L).orElse(null);
		
		Post post = new Post();
		post.setBloqueado(false);
		post.setImagem(null);
		post.setTatuador(tatuador);
		postService.cadastrarPost(post);
		
		Assert.assertNotNull(post.getId());
	}
}
