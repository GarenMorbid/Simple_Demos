package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Author;
import service.AuthorService;

@Controller
@RequestMapping(value="/author")
public class AuthorController {
	@Resource
	AuthorService authorService;
	
	public AuthorService getAuthorService() {
		return authorService;
	}

	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	@RequestMapping(value="/getAllAuthors.action")
	public String getAllAuthors(HttpServletRequest request) {
		List<Author> authors = authorService.getAllAuthors();
		request.setAttribute("authors", authors);
		
		return "forward:../result.jsp";
	}
	
	@RequestMapping(value="/delAuthor.action")
	public String delAuthor(int id) {
		authorService.delAuthor(id);
		
		return "redirect:getAllAuthors.action";
	}
	
	@RequestMapping(value="/addAuthor.action")
	public String addAuthor(Author author) {
		authorService.addAuthor(author);
		
		return "redirect:getAllAuthors.action";
	}
	
	@RequestMapping(value="/updateAuthor.action")
	public String updateAuthor(Author author) {
		authorService.editAuthor(author);
		
		return "redirect:getAllAuthors.action";
	}
	
	@RequestMapping(value="/findAuthorByID.action")
	public String findAuthorByID(HttpServletRequest request) {
		Author author =  authorService.getAuthorByID(Integer.parseInt(request.getParameter("select_id")));
		System.out.println(author);
		List<Author> authors = new ArrayList<Author>();
		authors.add(author);
		System.out.println(authors);
		request.setAttribute("authors", authors);
		
		return "forward:../result.jsp";
	}
}
