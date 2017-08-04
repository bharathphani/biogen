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
		} else if (args[0].equals("insert")) {
			return userDAO.createUser((User) args[1]);
		} else if (args[0].equals("getAll")) {
			return userDAO.getUsers();
		}
		// Check for multiple inserts.
		if (args.length > 1) {
			for (int i = 0; i < args.length; i++) {
				if (args[i].equals("insertmultiple")) {
					// Always pass the second parameter which is User Object
					return userDAO.createUser((User) args[1]);
				}
			}
		}

		return null;
	}
}