package Neon.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import Neon.DTO.ProductDTO;
@Service
public interface iCategoryService {
	public List<ProductDTO> GetAllDataProductsByID(int id);
}