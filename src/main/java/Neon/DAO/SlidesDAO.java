package Neon.DAO;
import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import Neon.Entity.*;

@Repository
public class SlidesDAO {
	@Autowired
	JdbcTemplate _jdbcTemplete;
	
	public List<Slides> GetDataSlide(){
		List<Slides> list = new ArrayList<Slides>();
		String sql = "select * from slides";
		list = _jdbcTemplete.query(sql, new MapperSlides());
		return list;
	}
}
