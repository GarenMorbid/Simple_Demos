/**  
 * @Title:  UserDao.java   
 * @Package club.hdqyf.mapper   
 * @author: Garen     
 * @date:   2018年8月15日 下午1:47:57   
 * @Copyright: 2018 www.hdqyf.club All rights reserved.
 */
package club.hdqyf.mapper;

import club.hdqyf.entity.User;

/**
 * @ClassName: UserDao
 * @Description:TODO(User对象的数据操作接口)
 * @author: Garen
 * @date: 2018年8月15日 下午1:47:57
 * @Copyright: 2018 www.hdqyf.club All rights reserved.
 */
public interface UserMapper {
	public User findUserByIdAndName(String userName, String password);
}