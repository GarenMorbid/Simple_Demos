package service;

import java.util.List;

import entity.Author;

public interface AuthorService {
	public List<Author> getAllAuthors();
	
	public Author getAuthorByID(int id);
	
	public void delAuthor(int id);
	
	public void addAuthor(Author author);
	
	public void editAuthor(Author author);
}
