/**
 * 
 */
package com.src.magnushealth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.src.magnushealth.dao.UserDAO;
import com.src.magnushealth.model.User;

/**
 * @author Rakesh Rai
 *
 */
@Service("userService")
public class UserService implements ServiceFacade {

	private static final String GET_ALL = "getAll";
	private static final String INSERT = "insert";
	private static final String INSERT_MULTIPLE = "insertmultiple";

	@Autowired
	private UserDAO userDAO;

	/**
	 * doService takes object
	 */
	public Object doService(Object... args) throws Exception {
		Assert.notNull(args[0]);
		if (args[0].equals("insertBatch")) {
			userDAO.insertBatch();
			return true;
		} else if (args[0].equals(INSERT)) {
			return userDAO.createUser((User) args[1]);
		} else if (args[0].equals(INSERT_MULTIPLE)) {
			return userDAO.createUser((User) args[1]);
		} else if (args[0].equals(GET_ALL)) {
			return userDAO.getUsers();
		}
		return null;
	}
}