package com.codingwithArif.onetomanymapping.Repo;

import com.codingwithArif.onetomanymapping.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
