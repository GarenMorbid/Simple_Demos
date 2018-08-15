package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.AuthorDao;
import entity.Author;
import service.AuthorService;

@Service(value="authorService")
public class AuthorServiceImpl implements AuthorService{
	
	@Resource
	AuthorDao authorDao;
	
	//如果用的spring配置文件进行dao注入，就得创建该dao的getter、setter方法进行注入
	public AuthorDao getAuthorDao() {
		return authorDao;
	}

	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorDao.findAll();
	}

	@Override
	public Author getAuthorByID(int id) {
		return authorDao.findById(id);
	}

	@Override
	public void delAuthor(int id) {
		authorDao.delete(id);
	}

	@Override
	public void addAuthor(Author author) {
		authorDao.insert(author);
	}

	@Override
	public void editAuthor(Author author) {
		authorDao.update(author);
	}

}
