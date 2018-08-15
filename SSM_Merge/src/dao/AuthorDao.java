package dao;

import java.util.List;

import entity.Author;

public interface AuthorDao {
	public List<Author> findAll();
	
	public void delete(int id);
	
	public void update(Author author);
	
	public void insert(Author author);
	
	public Author findById(int id);
}
