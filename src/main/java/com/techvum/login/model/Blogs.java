package com.techvum.login.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Blogs {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="Id")
    private long id;

    @Column(name="Blog_Title")
    private String blogTitle;

    @Column(name="Author_Name")
    private String authorName;
    
    @Column(name="content",length = 10000)
    private String content;

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="Launch_Date")
    private long launchDate; 
    
    @Column(name="About")
    private String aboutBlog;

    public String getAboutBlog() {
		return aboutBlog;
	}

	public void setAboutBlog(String aboutBlog) {
		this.aboutBlog = aboutBlog;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(long launchDate) {
        this.launchDate = launchDate;
    }


    public Blogs() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Blogs [id=" + id + ", blogTitle=" + blogTitle + ", authorName=" + authorName + ", content=" + content
				+ ", launchDate=" + launchDate + ", aboutBlog=" + aboutBlog + "]";
	}

	public Blogs(long id, String blogTitle, String authorName, String content, long launchDate, String aboutBlog) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.authorName = authorName;
		this.content = content;
		this.launchDate = launchDate;
		this.aboutBlog = aboutBlog;
	}
	
	public Blogs(String blogTitle, String authorName, String content, long launchDate, String aboutBlog) {
		super();
		this.blogTitle = blogTitle;
		this.authorName = authorName;
		this.content = content;
		this.launchDate = launchDate;
		this.aboutBlog = aboutBlog;
	}

	
}
