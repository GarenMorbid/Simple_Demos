/**  
 * @Title:  UserServiceImpl.java   
 * @Package club.hdqyf.service.impl   
 * @author: Garen     
 * @date:   2018年8月15日 下午1:50:43   
 * @Copyright: 2018 www.hdqyf.club All rights reserved.
 */
package club.hdqyf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.hdqyf.mapper.UserMapper;
import club.hdqyf.service.UserService;

/**
 * @ClassName: UserServiceImpl
 * @Description:TODO(User的服务接口实现类)
 * @author: Garen
 * @date: 2018年8月15日 下午1:50:43
 * @Copyright: 2018 www.hdqyf.club All rights reserved.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean findUserByIdAndName(String userName, String password) {
		boolean status = false;
		if (userMapper.findUserByIdAndName(userName, password) != null) {
			status = true;
		}

		return status;
	}
}
