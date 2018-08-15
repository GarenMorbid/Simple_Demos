/**  
 * @Title:  UserMapperImpl.java   
 * @Package club.hdqyf.mapper.imlp   
 * @author: Garen     
 * @date:   2018年8月15日 下午2:08:43   
 * @Copyright: 2018 www.hdqyf.club All rights reserved.
 */
package club.hdqyf.mapper.imlp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import club.hdqyf.entity.User;
import club.hdqyf.mapper.UserMapper;

/**
 * @ClassName: UserMapperImpl
 * @Description:TODO(Dao接口实现类UserMapperImpl)
 * @author: Garen
 * @date: 2018年8月15日 下午2:08:43
 * @Copyright: 2018 www.hdqyf.club All rights reserved.
 */
@Repository
public class UserMapperImpl extends HibernateDaoSupport implements UserMapper {
	// HibernateDaoSupport来操作数据库更加方便

	// 用来注入sessionFactory（不注入会报错）
	@Resource(name = "sessionFactory")
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public User findUserByIdAndName(String userName, String password) {
		// 注意：以下是HQL语句
		List<?> user = getHibernateTemplate().find("from User where userName=? and password=?", userName, password);

		return user.size() > 0 ? (User) user.get(0) : null;
	}
}
