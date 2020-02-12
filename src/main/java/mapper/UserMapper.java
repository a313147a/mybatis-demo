package mapper;

import po.User;

public interface UserMapper {
	
	public User findUserById(int id) throws Exception;
}
