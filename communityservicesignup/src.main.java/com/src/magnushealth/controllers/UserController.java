/**
 * 
 */
package com.src.magnushealth.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.src.magnushealth.model.ResponseObject;
import com.src.magnushealth.model.User;
import com.src.magnushealth.model.UserWrapper;
import com.src.magnushealth.service.ServiceFacade;

/**
 * @author Rakesh Rai
 *
 */
@RestController
public class UserController {

	@Autowired
	private ServiceFacade userService;

	/**
	 * get all users
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> userInfo() throws Exception {
		return (List<User>) userService.doService("getAll");
	}

	/**
	 * add one User
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addusers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject createUser(@RequestBody User user) throws Exception {
		return getResponseObject((Integer) userService.doService("insert", user));
	}

	/**
	 * add multiple users
	 * 
	 * @param users
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addmultipleusers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject createMultipleUser(@RequestBody UserWrapper wrapper) throws Exception {
		List<Integer> respValues = new ArrayList<>();
		Integer respVal = new Integer(0);
		for (User user : wrapper.getUsers()) {
			respVal = (Integer) userService.doService("insertmultiple", user);
			respValues.add(respVal);
		}
		return isPersisted(respValues);

	}

	/**
	 * Get Response Object
	 * 
	 * @param output
	 * @return
	 */
	private ResponseObject getResponseObject(Integer output) {
		return new ResponseObject(output == 1 ? true : false, output == 1 ? "successful" : "failed");
	}

	/**
	 * Check if the user object got persisted or not, based on that respond success or fail.
	 * 
	 * @param respValues
	 * @return
	 */
	private ResponseObject isPersisted(List<Integer> respValues) {
		Boolean isResponse = false;
		for (Integer val : respValues) {
			if (val == 1) {
				isResponse = true;
			} else {
				isResponse = false;
			}
		}
		if (isResponse) {
			return getResponseObject(1);
		} else {
			return getResponseObject(0);
		}
	}
}
