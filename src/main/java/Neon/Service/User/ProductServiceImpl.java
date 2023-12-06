package Neon.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Neon.DAO.ProductDAO;
import Neon.DTO.ProductDTO;
@Service
public class ProductServiceImpl implements iProductsService {
	@Autowired
	ProductDAO productDAO = new ProductDAO();
	
	public ProductDTO GetProductByID(int id) {
		List<ProductDTO> listProducts = productDAO.GetProductByID(id);
		return listProducts.get(0);
	}

}
