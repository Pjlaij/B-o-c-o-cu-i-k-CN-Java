package Neon.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Neon.Entity.Category;
import Neon.Entity.MapperCategory;
@Repository
public class CategoryDAO {
	@Autowired
	JdbcTemplate _jdbcTemplete;
	
	public List<Category> GetDataCategory(){
		List<Category> list = new ArrayList<Category>();
		String sql = "select * from category";
		list = _jdbcTemplete.query(sql, new MapperCategory());
		return list;
	}

}
