package com.techvum.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techvum.login.model.Blogs;
import com.techvum.login.model.Input;
import com.techvum.login.repository.BlogRepo;

@Service
public class BlogsService {

    @Autowired
    private BlogRepo blogRepo;

    public List<Blogs> getAllblogs() {
        return blogRepo.findAll();
    }

    public Blogs getBlogById(long bookid) {
        return blogRepo.findById(bookid);
    }

    public void delById(long bookid) {
    	Blogs b = blogRepo.findById(bookid);
    	blogRepo.delete(b);
    }

    public Blogs saveblog(Input blogs) {
    	Blogs b = new Blogs();
        b.setBlogTitle(blogs.getBlogTitle());
        b.setAuthorName(blogs.getAuthorName());
        b.setLaunchDate(blogs.getLaunchDate().getTime()); 
        b.setAboutBlog(blogs.getAboutBlog());
        b.setContent(blogs.getContent());

        return blogRepo.save(b);
    }

    public Blogs updateblog(Input blogs, long id) {
    	Blogs b = blogRepo.findById(id);
        b.setAboutBlog(blogs.getAboutBlog());
        b.setBlogTitle(blogs.getBlogTitle());
        b.setAuthorName(blogs.getAuthorName());
        b.setLaunchDate(blogs.getLaunchDate().getTime()); 
        b.setContent(blogs.getContent());
        
        return blogRepo.save(b);
    }
}