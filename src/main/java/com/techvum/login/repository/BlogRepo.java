package com.techvum.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techvum.login.model.Blogs;

@Repository
public interface BlogRepo extends JpaRepository<Blogs, Long>{
	Blogs findById(long id);
	List<Blogs> findAll();
}