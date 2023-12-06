package Neon.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Neon.DTO.ProductDTO;
import Neon.Entity.Category;
import Neon.Entity.Slides;
@Service
public interface iHome {
	@Autowired
	public List<Slides> GetDataSlide();
	public List<Category> GetDataCategory();
	public List<ProductDTO> GetDataProduct(boolean newProduct,boolean highlight);
}
