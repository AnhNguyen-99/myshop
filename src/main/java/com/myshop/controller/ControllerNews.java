package com.myshop.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.entity.News;
import com.myshop.service.NewsService;

@Controller
@RequestMapping(value = "manages/news")
public class ControllerNews {

	@Autowired
	private NewsService newsService;


	@RequestMapping(value = "/list")
	public String viewListNews(Model model) {
		model.addAttribute("listNews", newsService.getAll());
		return "manages/news_list";
	}

	@RequestMapping(value = "/add")
	public String viewAdd(Model model) {
		model.addAttribute("news", new News());
		return "manages/news_form";
	}

		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String viewSaveNews(@ModelAttribute("news") News news, Model model, HttpServletRequest request) {
			String path = request.getRealPath("/resorces/page/img/news");
			System.out.println(path);
	        path = path.substring(0, path.indexOf(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps"));
	        path = path + "MyShop\\src\\main\\webapp\\resources\\page\\img\\news";
	        System.out.println(path);
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        try {
	            List<FileItem> list = upload.parseRequest(request);
	            for (FileItem item : list) {
	                if (item.isFormField()) {
	                    String name = item.getFieldName();
	                    String value = item.getString();
	                    if(name.equals("newsId")){
	                        if(value!=null && value.length()>0)
	                            news.setNewsId(Integer.parseInt(value));
	                    }else if (name.equals("title")) {                    
	                        news.setTitle(new String(value.getBytes("iso-8859-1"), "UTF-8")); 
	                    } else if (name.equals("content")) {
	                        news.setContent(new String(value.getBytes("iso-8859-1"), "UTF-8"));
	                    }
	                } else {
	                    if (item.getFieldName().equals("img")) {
	                        item.write(new File(path + "/" + item.getName()));
	                        news.setImg(item.getName());
	                    }
	                }
	            }
	        } catch (FileUploadException ex) {
	            Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (UnsupportedEncodingException ex) {
	            Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ParseException ex) {
	            Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (Exception ex) {
	            Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        boolean bl;
	        if(news.getNewsId() == null)
	            bl = newsService.create(news);
	        else{
	            bl = newsService.update(news);
	        }
	        if (bl) {
	            return "redirect:list";
	        } else {
	            return "manages/news_form";
	        }
	}

	@RequestMapping(value = "/edit/{newsId}")
	public String viewEdit(@PathVariable("newsId") Integer newsId, Model model) {
		model.addAttribute("news", newsService.findById(newsId));
		return "manages/news_form";
	}

	@RequestMapping(value = "/delete/{newsId}")
	public String viewDelete(@PathVariable("newsId") Integer newsId, Model model) {
		News news = newsService.findById(newsId);
		if (news != null)
			newsService.delete(news);
		return "redirect:list";
	}
	
	
}
