package com.tropcool.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tropcool.model.entity.Post;
import com.tropcool.model.repository.PostRepository;

@Service
@Transactional
public class PostService {
	
	@Autowired
	private PostRepository PostRepository;
	
	public Post cadastrarPost(Post Post) {
		return this.PostRepository.save(Post);
	}
	
	public Post detalharPost(Long id) {
		Post Post = this.PostRepository.findById(id).orElse(null);
		Assert.notNull(Post,"Post de id "+ id + "não encontrado.");
		return Post;
	}
	
	public List<Post> listarPosts(){
		return this.PostRepository.findAll();
	}
	
	public Post atualizarPost(Post Post) {
		return this.PostRepository.save(Post);
	}
	
	public void removerPost(Long id) {
		this.PostRepository.deleteById(id);
	}
}
