/**  
 * @Title:  User.java   
 * @Package club.hdqyf.entity   
 * @author: Garen     
 * @date:   2018年8月15日 下午1:43:58   
 * @Copyright: 2018 www.hdqyf.club All rights reserved.
 */
package club.hdqyf.entity;

/**
 * @ClassName: User
 * @Description:TODO(测试SSH的一个实体类)
 * @author: Garen
 * @date: 2018年8月15日 下午1:43:58
 * @Copyright: 2018 www.hdqyf.club All rights reserved.
 */
public class User {
	private Integer id;
    private String userName;
    private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(Integer id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
}
