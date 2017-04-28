package com.epam.ws1.bean;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Book implements Serializable {
    private static final long serialVersionUID = 1L; 
    private int id;
    private String author;
    
    public Book() {
		super();
	}
    
	public Book(int id, String author) {
		super();
		this.id = id;
		this.author = author;
	}
	
	public int getId() {
		return id;
	}
	@XmlElement//(name = "id")
	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}
	@XmlElement//(name = "author")
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + "]";
	}

}
