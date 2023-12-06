package Neon.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import Neon.DTO.ProductDTO;
import Neon.DTO.ProductDTOMapper;
@Repository
public class ProductDAO extends BaseDAO {

	
	private StringBuffer SqlString() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id as id_product ");
		sql.append(", p.id_category ");
		sql.append(", p.sizes ");
		sql.append(", p.name ");
		sql.append(", p.price ");
		sql.append(", p.sale ");
		sql.append(", p.title ");
		sql.append(", p.highlight ");
		sql.append(", p.new_product ");
		sql.append(", p.details ");
		sql.append(", c.id as id_color ");
		sql.append(", c.name as name_color ");
		sql.append(", c.code as code_color ");
		sql.append(", c.img ");
		sql.append(", p.created_at ");
		sql.append(", p.updated ");
		sql.append("FROM ");
		sql.append("product AS p ");
		sql.append("INNER JOIN ");
		sql.append("color AS c ");
		sql.append("ON p.id = c.id_product ");
		return sql;
	}
	
	private String SqlProducts(boolean newProduct, boolean highLight) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		if (highLight) {
			sql.append("AND p.highlight = true ");
		}
		if (newProduct) {
			sql.append("AND p.new_product = true ");
		}
		sql.append("GROUP BY p.id, c.id_product ");
		sql.append("ORDER BY RAND() ");
		if (highLight) {
			sql.append("LIMIT 12 ");
		}
		if (newProduct) {
			sql.append("LIMIT 9 ");
		}
		return sql.toString();
	}
	private String SqlProductsByID(int id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		if (id!=11)
		sql.append("AND id_category = "+id+" ");
		System.out.println(id);
		return sql.toString();
	}
	private String SqlProductsByID_product(int id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.id = "+id+" ");
		sql.append("LIMIT 1 ");
		System.out.println(id);
		return sql.toString();
	}
	private String SqlProductsByPaginate(int start, int end) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		if (start > 0 || end > 0) {
			sql.append("LIMIT  " + start + ", " + end);
		}
		return sql.toString();
	}

	public List<ProductDTO> GetDataProducts(boolean newProduct, boolean highlight) {
		String sql = SqlProducts(newProduct,highlight);
		List<ProductDTO> listProducts = _jdbcTemplate.query(sql, new ProductDTOMapper());
		return listProducts;
	}
	
	public List<ProductDTO> GetAllDataProductsByID(int id) {
		String sql = SqlProductsByID(id);
		List<ProductDTO> listProducts = _jdbcTemplate.query(sql, new ProductDTOMapper());
		return listProducts;
	}
	
	public List<ProductDTO> GetAllDataProductsByPaginate(int start, int end) {
		String sql = SqlProductsByPaginate(start,end);
		List<ProductDTO> listProducts = _jdbcTemplate.query(sql, new ProductDTOMapper());
		return listProducts;
	}
	
	public List<ProductDTO> GetProductByID(int id){
		String sql=SqlProductsByID_product(id);
		List<ProductDTO> listProducts = _jdbcTemplate.query(sql, new ProductDTOMapper());
		return listProducts;
	}
	
	public ProductDTO FindProductByID(int id){
		String sql=SqlProductsByID_product(id);
		ProductDTO Product = _jdbcTemplate.queryForObject(sql, new ProductDTOMapper());
		return Product;
	}
	
}