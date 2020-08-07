package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.ColorDAO;
import com.myshop.entity.Color;

@Service
@Transactional
public class ColorService {

	@Autowired
	private ColorDAO colorDAO;
	
	public boolean save(final Color color) {
		return colorDAO.save(color);
	}
	
	public boolean update(final Color color) {
		return colorDAO.update(color);
	}
	
	public boolean delete(final Color color) {
		return colorDAO.delete(color);
	}
	
	public List<Color> getAll(){
		return colorDAO.getAll();
	}
	
	public Color findById(int colorId) {
		return colorDAO.findById(colorId);
	}
}
