package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.NewsDAO;
import com.myshop.entity.News;

@Service
@Transactional(rollbackFor = Exception.class)
public class NewsService {

	@Autowired
	private NewsDAO newsDAO;
	
	public boolean create(News obj) {
		return newsDAO.create(obj);
	}
    
    public boolean update(News obj) {
    	return newsDAO.update(obj);
    }
    
    public boolean delete(News obj) {
    	return newsDAO.delete(obj);
    }
    
    public News findById(Integer newsId) {
    	return newsDAO.findById(newsId);
    }
    
    public List<News> getAll(){
    	return newsDAO.getAll();
    }
    
}
