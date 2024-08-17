package com.techvum.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techvum.login.model.Blogs;
import com.techvum.login.model.Input;
import com.techvum.login.service.BlogsService;

@RestController
@RequestMapping("v1/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class BlogsController {
	
	@Autowired
	BlogsService blogsService;

	@GetMapping("/getallblogs")
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public List<Blogs> getAllblogs() {
		return blogsService.getAllblogs();
	}

	@GetMapping("/getbyid/{blogid}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public Blogs getBlogs(@PathVariable long blogid) {
		return blogsService.getBlogById(blogid);
	}

	@DeleteMapping("/deletebyid/{blogid}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public void deleteBlog(@PathVariable long blogid) {
		blogsService.delById(blogid);
	}

	@PostMapping("/createblog")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public Blogs saveBlog(@RequestBody Input blogs) {
		return blogsService.saveblog(blogs);
	}

	@PutMapping("/updateblog/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public Blogs updateBlog(@RequestBody Input blogs, @PathVariable long id) {
		return blogsService.updateblog(blogs, id);
	}
}