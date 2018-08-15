package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.AuthorDao;
import entity.Author;
import service.AuthorService;

public class Test {

	public static void main(String[] args) {
		//测试dao
		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		AuthorDao authorDao = (AuthorDao) applicationContext.getBean("authorDao");
		
		List<Author> authors = authorDao.findAll();
		System.out.println(authors.size());*/
		
		//测试service
		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-service.xml");
		
		AuthorService authorService = (AuthorService) applicationContext.getBean("authorService");
		
		System.out.println(authorService);*/
		
		//测试dao的方法
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		AuthorDao authorDao = (AuthorDao) applicationContext.getBean("authorDao");
		
		/*Author author = authorDao.findById(3);
		System.out.println(author);*/
		
		/*authorDao.delete(3);*/
		
		/*Author author = new Author(1,"ssm","ssm","ssm@qq.com","ssm");
		authorDao.insert(author);*/
		
		Author author = new Author(401,"mybatis","mybatis","mybatis@qq.com","mybatis");
		authorDao.update(author);
	}
}
