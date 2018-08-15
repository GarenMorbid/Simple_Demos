/**  
 * @Title:  UserController.java   
 * @Package club.hdqyf.controller   
 * @author: Garen     
 * @date:   2018年8月15日 下午1:47:01   
 * @Copyright: 2018 www.hdqyf.club All rights reserved.
 */
package club.hdqyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import club.hdqyf.entity.User;
import club.hdqyf.service.UserService;

/**
 * @ClassName: UserController
 * @Description:TODO(与User对象相关的Controller)
 * @author: Garen
 * @date: 2018年8月15日 下午1:47:01
 * @Copyright: 2018 www.hdqyf.club All rights reserved.
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/login.action")
	public String login(User user) {
		// 查询到是否存在登录的这个用户
		boolean status = userService.findUserByIdAndName(user.getUserName(), user.getPassword());

		if (status) {
			return "success";
		} else {
			return "login";
		}
	}
}
