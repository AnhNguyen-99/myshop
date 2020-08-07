package com.myshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.CategoryDTO;
import com.myshop.entity.Category;
import com.myshop.service.CategoryService;

@RestController
@RequestMapping(value = "api/category")
public class CategoryAPI {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "")
	public ResponseEntity<List<CategoryDTO>> listCategory(){
		List<CategoryDTO> list = categoryService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> getCategoryId(@PathVariable int id){
		CategoryDTO categoryDTO = categoryService.getById(id);
		return ResponseEntity.ok().body(categoryDTO);
	}
	
	@PostMapping(value = "")
	public ResponseEntity<?> create(@RequestBody CategoryDTO categoryDTO){
		boolean bl = categoryService.saveDTO(categoryDTO);
		if(bl)
			return ResponseEntity.ok().body("Thành công!!!");
		else
			return ResponseEntity.ok().body("Thất bại!!!"); 
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") int id){
		Category category = categoryService.findById(id);
		boolean bl = categoryService.delete(category);
		if(bl)
			return ResponseEntity.ok().body("Xóa thành công!!!");
		else
			return ResponseEntity.ok().body("Xóa thất bại!!!");
	}
}
