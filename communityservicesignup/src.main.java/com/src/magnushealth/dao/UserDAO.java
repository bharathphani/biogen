/**
 * 
 */
package com.src.magnushealth.dao;

import java.util.List;

import com.src.magnushealth.model.User;

/**
 * @author Rakesh Rai
 *
 */
public interface UserDAO {
	public List<User> getUsers();

	public Integer createUser(User user);

	public void insertBatch();

	Integer createUsers(List<User> users);

}