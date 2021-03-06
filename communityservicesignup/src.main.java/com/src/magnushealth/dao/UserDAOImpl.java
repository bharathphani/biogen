/**
 * 
 */
package com.src.magnushealth.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.src.magnushealth.model.User;

/**
 * @author Rakesh Rai
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Get Users
	 */
	public List<User> getUsers() {
		return jdbcTemplate.query(
				"SELECT id, group_name, volunteer_date,  first_name, last_name, street_address, city, state, zip FROM users",
				(rs, rowNum) -> new User(rs.getInt("id"), rs.getString("group_name"), rs.getString("volunteer_date"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("street_address"),
						rs.getString("city"), rs.getString("state"), rs.getString("zip")));
	}

	/**
	 * Add User
	 */
	@Override
	public Integer createUser(User user) {
		return addUser(user);
	}

	/**
	 * Add Users
	 */
	@Override
	public Integer createUsers(List<User> users) {
		for (User user : users) {
			return addUser(user);
		}
		return null;

	}

	/**
	 * creates a newtable for H2 DB during start of Application.java
	 */
	public void insertBatch() {
		jdbcTemplate.execute("DROP TABLE users IF EXISTS");
		jdbcTemplate.execute(
				"CREATE TABLE users(id SERIAL, group_name VARCHAR(255), volunteer_date VARCHAR(30), first_name VARCHAR(255), last_name VARCHAR(255), street_address VARCHAR(255), city VARCHAR(255),  state VARCHAR(255), zip VARCHAR(20))");
		jdbcTemplate.batchUpdate(
				"INSERT INTO users(group_name, volunteer_date, first_name, last_name, street_address, city, state, zip) VALUES (?,?,?,?,?,?,?,?)",
				userData());
	}

	/**
	 * add User
	 * 
	 * @param user
	 * @return
	 */
	private Integer addUser(User user) {
		return jdbcTemplate.update(
				"INSERT INTO users(group_name, volunteer_date, first_name, last_name, street_address, city, state, zip) VALUES (?,?,?,?,?,?,?,?)",
				new PreparedStatementSetter() {
					public void setValues(PreparedStatement stmt) throws SQLException {
						stmt.setString(1, user.getGroupName());
						stmt.setString(2, user.getVolunteerDate());
						stmt.setString(3, user.getFirstName());
						stmt.setString(4, user.getLastName());
						stmt.setString(5, user.getStreetAddress());
						stmt.setString(6, user.getCity());
						stmt.setString(7, user.getState());
						stmt.setString(8, user.getZip());
					}
				});
	}

	/**
	 * Dummy User Data for getting all Volunteers information.
	 * 
	 * @return
	 */
	private List<Object[]> userData() {
		List<Object[]> users = new ArrayList<>();
		users.add("Group1 03/02/2017 John Doe someaddress Exton PA 19341".split(" "));
		users.add("Group2 03/04/2017 Jane Doe someaddress Exton PA 19341".split(" "));
		users.add("Group3 03/05/2017 Sarah Bosch someaddress Exton PA 19341".split(" "));
		users.add("Group4 03/06/2017 Michael Murray someaddress Exton PA 19341".split(" "));
		users.add("Group5 03/07/2017 Barry Coy someaddress Exton PA 19341".split(" "));
		users.add("Group6 03/08/2017 Daisy Chen someaddress Exton PA 19341".split(" "));
		users.add("Group7 03/09/2017 May Williams someaddress Exton PA 19341".split(" "));
		users.add("Group8 03/10/2017 Alex Johnson someaddress Exton PA 19341".split(" "));
		users.add("Group9 03/11/2017 Ceasar McCoy someaddress Exton PA 19341".split(" "));
		users.add("Group10 03/12/2017 Paula May someaddress Exton PA 19341".split(" "));
		return users;
	}

}