package Neon.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Neon.DAO.CategoryDAO;
import Neon.DAO.ProductDAO;
import Neon.DAO.SlidesDAO;
import Neon.DTO.ProductDTO;
import Neon.Entity.Category;
import Neon.Entity.Slides;
@Service
public class HomeImpl implements iHome{
	@Autowired
	private SlidesDAO slidesDao;
	@Autowired
	private CategoryDAO categoryDao;
	@Autowired
	private ProductDAO productDao;
	public List<Slides> GetDataSlide() {
		return slidesDao.GetDataSlide();
	}

	public List<Category> GetDataCategory() {
		return categoryDao.GetDataCategory();
	}
	public List<ProductDTO> GetDataProduct(boolean newProduct,boolean highlight) {
		List<ProductDTO> listProduct = productDao.GetDataProducts(newProduct,highlight);
		return listProduct;
	}

}
