package com.example.CoffeeShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbc;

	public List<Product> findAll() {
		// BeanPropertyRowMapper uses the rows from the SQL result create
		// new Room objects and fill in the values by calling the setters.
		// Use .query for SQL SELECT statements.
		String sql = "SELECT * FROM products";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class));
	}

	public Product findById(Long id) {
		// The last parameters of .query let us specify values for the (?) parameters in
		// our SQL statement.
		// While .query returns a list, .queryForObject assumes only one result.
		// If nothing matched, match will be null.

		String sql = "SELECT * FROM products WHERE id = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
	}

	public void update(Product products) {
		// Use .update for SQL INSERT, UPDATE, and DELETE
		// All the parameters after the first specify values to fill in the ?s in the
		// SQL.

		String sql = "UPDATE products SET name=?, description=?, price=? WHERE id=?";
		jdbc.update(sql, products.getName(), products.getDescription(), products.getPrice(), products.getId());

	}

	public void create(Product products) {

		String sql = "INSERT INTO  products( name, description, price) VALUES (?, ?, ?)";
		jdbc.update(sql, products.getName(), products.getDescription(), products.getPrice());

	}

	public void delete(Long id) {

		String sql = "DELETE FROM products WHERE id = ?";
		jdbc.update(sql, id);

	}

}
