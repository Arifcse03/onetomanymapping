package com.codingwithArif.onetomanymapping.Repo;

import com.codingwithArif.onetomanymapping.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
