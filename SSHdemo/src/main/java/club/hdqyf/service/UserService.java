/**  
 * @Title:  UserService.java   
 * @Package club.hdqyf.service   
 * @author: Garen     
 * @date:   2018年8月15日 下午1:50:20   
 * @Copyright: 2018 www.hdqyf.club All rights reserved.
 */
package club.hdqyf.service;

/**
 * @ClassName: UserService
 * @Description:TODO(User的服务层接口)
 * @author: Garen
 * @date: 2018年8月15日 下午1:50:20
 * @Copyright: 2018 www.hdqyf.club All rights reserved.
 */
public interface UserService {

	public boolean findUserByIdAndName(String userName, String password);

}
