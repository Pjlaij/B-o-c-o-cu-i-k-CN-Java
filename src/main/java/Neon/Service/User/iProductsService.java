package Neon.Service.User;
import Neon.DTO.ProductDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface iProductsService {
	@Autowired
	public ProductDTO GetProductByID(int id);
}
