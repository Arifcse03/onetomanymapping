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
public class OnetomanymappingApplication {

	public static void main(String[] args) {
	SpringApplication.run(OnetomanymappingApplication.class, args);
	}

}
