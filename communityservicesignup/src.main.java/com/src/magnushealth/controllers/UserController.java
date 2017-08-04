/**
 * 
 */
package com.src.magnushealth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.src.magnushealth.model.ResponseObject;
import com.src.magnushealth.model.User;
import com.src.magnushealth.service.ServiceFacade;

/**
 * @author Rakesh Rai
 *
 */
@RestController
public class UserController {

	@Autowired
	private ServiceFacade userService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> userInfo() throws Exception {
		return (List<User>) userService.doService("getAll");
	}

	@RequestMapping(value = "/addusers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject createUser(@RequestBody User user) throws Exception {
		return getResponseObject((Integer) userService.doService("insert", user));
	}

	private ResponseObject getResponseObject(Integer output) {
		return new ResponseObject(output == 1 ? true : false, output == 1 ? "successful" : "failed");
	}
}
