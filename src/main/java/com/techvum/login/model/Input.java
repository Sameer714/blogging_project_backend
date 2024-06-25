package com.techvum.login.model;

import java.util.Date;

import jakarta.persistence.Column;

public class Input {

	
    public String blogTitle;
    public String authorName;
    public Date launchDate;
    public String aboutBlog;
    public String content;

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
    public String getAboutBlog() {
		return aboutBlog;
	}

	public void setAboutBlog(String aboutBlog) {
		this.aboutBlog = aboutBlog;
	}

	public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public long getLaunchDateEpoch() {
        return launchDate.getTime(); 
    }

    public Input(String blogTitle, String authorName, Date launchDate , String aboutBlog) {
        super();
        this.aboutBlog = aboutBlog;
        this.blogTitle = blogTitle;
        this.authorName = authorName;
        this.launchDate = launchDate;
    }
}
