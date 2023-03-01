package com.codingwithArif.onetomanymapping;

import com.codingwithArif.onetomanymapping.Entity.Comments;
import com.codingwithArif.onetomanymapping.Entity.Post;
import com.codingwithArif.onetomanymapping.Repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.stream.events.Comment;

@SpringBootApplication
public class OnetomanymappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OnetomanymappingApplication.class, args);
	}
	@Autowired
private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

//		Post post = new Post("one to many mapping using JPA and hibernate 11", "one to many mapping using JPA and hibernate 1");
//
//		Comments comment1 = new Comments("Very useful 11");
//		Comments comment2 = new Comments("informative 11");
//		Comments comment3 = new Comments("Great post 11");
//
//		post.getComments().add(comment1);
//		post.getComments().add(comment2);
//		post.getComments().add(comment3);
//
//		this.postRepository.save(post);
	}
}
