package com.tropcool.model.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	 * @throws IOException 
	 */
	
	/* CADASTRAR POST - MUSTPASS*/
	
//	@Test
//	@Sql({ 
//		"/dataset/truncate.sql",
//		"/dataset/usuarios.sql",
//		"/dataset/tatuadores.sql"
//	})
//	public void cadastrarPostMustPass() throws IOException {
//		Tatuador tatuador = tatuadorRepository.findById(1001L).orElse(null);
//		
//		Post post = new Post();
//		post.setBloqueado(false);
//		//byte[] b = post.openImg("C:\\Users\\Ulisses\\Downloads\\a.jpg");
//		byte[] b = post.openImg("C:/Users/Ulisses/Downloads/a.jpg");
//		System.out.println(b);
//		post.setImage(b);
//		post.setTatuador(tatuador);
//		postService.cadastrarPost(post);
//		
//		Assert.assertNotNull(post.getId());
//		System.out.println(post.getId());
//	}
	
	/**
	 * ====================================== DETALAHAR ===========================================
	 * @throws IOException 
	 */
	
	/* DETALHAR POST - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/tatuadores.sql",
		"/dataset/posts.sql"
	})
	public void detalahrPostMustPass(){
		Post post = postService.detalharPost(1001L);
		post.writeImg(post.getImage());
		Assert.assertNotNull(post);
	}
	
	/**
	 * ====================================== LISTAR ===========================================
	 * @throws IOException 
	 */
	
	/* LISTAR POST - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/tatuadores.sql",
		"/dataset/posts.sql"
	})
	public void listarPostMustPass(){
		List<Post> posts = postService.listarPosts();
		Assert.assertEquals(3, posts.size());
	}
	
	/**
	 * ====================================== ATUALIZAR ===========================================
	 * @throws IOException 
	 */
	
	/* BLOQUEAR POST - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/tatuadores.sql",
		"/dataset/posts.sql"
	})
	public void bloquearPostMustPass(){
		Post post = postService.detalharPost(1001L);
		Assert.assertNotNull(post);
		Assert.assertTrue(post.getBloqueado() == false);
		
		post.setBloqueado(true);
		postService.atualizarPost(post);
	}
	
	/* DESBLOQUEAR POST - MUSTPASS*/
	
	@Test
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/tatuadores.sql",
		"/dataset/posts.sql"
	})
	public void desbloquearPostMustPass(){
		Post post = postService.detalharPost(1002L);
		Assert.assertNotNull(post);
		Assert.assertTrue(post.getBloqueado() == true);
		
		post.setBloqueado(false);
		postService.atualizarPost(post);
	}
	
	/* ATUALIZAR POST - REMOVER TATUADOR - MUSTFAIL*/
	
	@Test(expected = Exception.class)
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/tatuadores.sql",
		"/dataset/posts.sql"
	})
	public void removerTatuadorPostMustFail(){
		Post post = postService.detalharPost(1001L);
		Assert.assertNotNull(post);
		Assert.assertNotNull(post.getTatuador());
		post.setTatuador(null);
		postService.atualizarPost(post);
	}
	/**
	 * ====================================== REMOVER ===========================================
	 * @throws IOException 
	 */
	
	/* REMOVER POST - MUSTPASS*/
	
	@Test(expected = IllegalArgumentException.class)
	@Sql({ 
		"/dataset/truncate.sql",
		"/dataset/usuarios.sql",
		"/dataset/tatuadores.sql",
		"/dataset/posts.sql"
	})
	public void removerPostMustPass(){
		postService.removerPost(1001L);
		Post post = postService.detalharPost(1001L);
		Assert.assertNull(post);
	}
}
