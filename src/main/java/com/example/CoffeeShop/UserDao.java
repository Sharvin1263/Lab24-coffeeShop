package com.example.CoffeeShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbc;

	public List<User> findAll() {
		// BeanPropertyRowMapper uses the rows from the SQL result create
		// new Room objects and fill in the values by calling the setters.
		// Use .query for SQL SELECT statements.
		String sql = "SELECT * FROM users";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(User.class));
	}

	public User findById(Long id) {
		// The last parameters of .query let us specify values for the (?) parameters in
		// our SQL statement.
		// While .query returns a list, .queryForObject assumes only one result.
		// If nothing matched, match will be null.

		String sql = "SELECT * FROM users WHERE id = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
	}

	public void update(User users) {
		// Use .update for SQL INSERT, UPDATE, and DELETE
		// All the parameters after the first specify values to fill in the ?s in the
		// SQL.

		String sql = "UPDATE users SET username=?, password=?, firstname=?, lastname=? WHERE id=?";
		jdbc.update(sql, users.getUsername(), users.getPassword(), users.getFirstname(), users.getLastname(),
				users.getId());

	}

	public void create(User users) {

		String sql = "INSERT INTO  users( username, password, firstname, lastname) VALUES (?, ?, ?, ?)";
		jdbc.update(sql, users.getUsername(), users.getPassword(), users.getFirstname(), users.getLastname());

	}

	public void delete(Long id) {

		String sql = "DELETE FROM users WHERE id = ?";
		jdbc.update(sql, id);

	}

}
