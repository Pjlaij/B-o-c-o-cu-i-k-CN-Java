package Neon.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUsers implements RowMapper<Users>{
	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users user = new Users();
		user.setId(rs.getInt("id"));
		user.setUser(rs.getString("User"));
		user.setDisplay_name(rs.getString("display_name"));
		user.setPassword(rs.getString("password"));
		user.setAddress("address");
		return user;
	}
}
