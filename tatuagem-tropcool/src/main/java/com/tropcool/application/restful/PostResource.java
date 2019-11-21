package com.tropcool.application.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tropcool.model.entity.Post;
import com.tropcool.model.service.PostService;

@Component
@RestController
@RequestMapping("/api/post")
public class PostResource {

	@Autowired
	private PostService postService;
	
	@GetMapping("/list")
	public List<Post> listar(){
		return this.postService.listarPosts();
	}
	
	@PostMapping("/insert")
	public Post cadastrar(@RequestBody Post post) {
		return this.postService.cadastrarPost(post);
	}
	
	@GetMapping("/update")
	public Post atualizar(@RequestBody Post post) {
		return this.postService.atualizarPost(post);
	}
	
	@GetMapping("/find")
	public Post detalhar(@RequestParam("id") Long id) {
		return this.postService.detalharPost(id);
	}
	
	@GetMapping("/remove")
	public void remover(@RequestParam("id") Long id) {
		this.postService.removerPost(id);
	}
}
