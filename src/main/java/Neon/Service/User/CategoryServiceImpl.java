package Neon.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Neon.DAO.ProductDAO;
import Neon.DTO.ProductDTO;
@Service
public class CategoryServiceImpl implements iCategoryService{

	@Autowired
	private ProductDAO productsDao;
	
	public List<ProductDTO> GetAllDataProductsByID(int id) {
		return productsDao.GetAllDataProductsByID(id);
	}
	
	public List<ProductDTO> GetAllDataProductsByPaginate(int start, int end) {
		return productsDao.GetAllDataProductsByPaginate(start, end);
	}

}