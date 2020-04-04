package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.model.userDetailsModel;
import com.model.userLogin;

public class userDaoImpl implements userDao {
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void register(userDetailsModel user) {
		String sql = "insert into users values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {user.getUserName(), user.getPassword(), user.getFirstName(),
				user.getLastName(), user.getEmail(), user.getAddress(), user.getPhone()});
	}

	public userDetailsModel validateUser(userLogin login) {
		String sql = "select * from users where username='"+ login.getUserName()+"' and password ='"+login.getPassword()+"'";
		List<userDetailsModel> userList = jdbcTemplate.query(sql, new UserMapper());
	    return userList.size() > 0 ? userList.get(0) : null;
	}
	class UserMapper implements RowMapper<userDetailsModel> {
		  public userDetailsModel mapRow(ResultSet rs, int arg1) throws SQLException {
		    userDetailsModel user = new userDetailsModel();
		    user.setUserName(rs.getString("username"));
		    user.setPassword(rs.getString("password"));
		    user.setFirstName(rs.getString("firstname"));
		    user.setLastName(rs.getString("lastname"));
		    user.setEmail(rs.getString("email"));
		    user.setAddress(rs.getString("address"));
		    user.setPhone(rs.getInt("phone"));
		    return user;
		  }
	}
}
