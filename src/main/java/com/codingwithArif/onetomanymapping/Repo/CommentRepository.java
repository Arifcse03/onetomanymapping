package com.codingwithArif.onetomanymapping.Repo;

import com.codingwithArif.onetomanymapping.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comments,Long> {
    List<Comments> findByPCFID(Long PCFID);
}
