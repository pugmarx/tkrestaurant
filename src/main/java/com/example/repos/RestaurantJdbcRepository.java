package com.example.repos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.entity.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class RestaurantRowMapper implements RowMapper<Restaurant> {
		@Override
		public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
			Restaurant restaurant = new Restaurant();
			restaurant.setId(rs.getLong("id"));
			restaurant.setName(rs.getString("name"));
			restaurant.setCuisine(rs.getString("cuisine"));
			return restaurant;
		}

	}

	public List<Restaurant> findAll() {
		return jdbcTemplate.query("select * from restaurant", new RestaurantRowMapper());
	}

	public Restaurant findById(long id) {
		return jdbcTemplate.queryForObject("select * from restaurant where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Restaurant>(Restaurant.class));
	}

	public int deleteById(long id) {
		return jdbcTemplate.update("delete from restaurant where id=?", new Object[] { id });
	}

	public int insert(Restaurant restaurant) {
		return jdbcTemplate.update("insert into restaurant (id, name, cuisine) " + "values(?,  ?, ?)",
				new Object[] { restaurant.getId(), restaurant.getName(), restaurant.getCuisine() });
	}

	public int update(Restaurant restaurant) {
		return jdbcTemplate.update("update restaurant " + " set name = ?, cuisine = ? " + " where id = ?",
				new Object[] { restaurant.getName(), restaurant.getCuisine(), restaurant.getId() });
	}

	public List<Restaurant> executeGenericQueryForRestaurant(String sqlForRestaurants) {
		return jdbcTemplate.query(sqlForRestaurants, new RestaurantRowMapper());
	}

}
