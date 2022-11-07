package com.packt.webinfo.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webinfo.dao.NewsDao;
import com.packt.webinfo.domain.News;
import com.packt.webinfo.exception.NewsNotFoundException;
import com.packt.webinfo.exception.NoNewsFoundUnderTypeException;
import com.packt.webinfo.service.NewsService;
import com.packt.webinfo.validator.HeadlineValidator;
import com.packt.webinfo.validator.NewsValidator;

@RequestMapping("/news")
@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;

	@Autowired
	private NewsValidator newsValidator;
	
	@RequestMapping
	public String list(Model model) {
		model.addAttribute("news", newsService.getAllNews());
		return "news";
	}

	@RequestMapping("/all")
	public String allNews(Model model) {
		model.addAttribute("news", newsService.getAllNews());

		return "news";
	}

	@RequestMapping("/adminPage")
	  public String listAdmin(Model model) {
			model.addAttribute("news", newsService.getAllNews());
			return "adminPage";
		}
	
	@RequestMapping("/{type}")
	public String getNewsByType(Model model, @PathVariable("type") String type) {
		List<News> news = newsService.getNewsByType(type);
		if (news == null || news.isEmpty()) {
			throw new NoNewsFoundUnderTypeException();
		}
		model.addAttribute("news", news);
		return "news";
	}
	
	@RequestMapping("/news")
	public String getNewsById(@RequestParam("id") String newsId, Model model) {
		model.addAttribute("news", newsService.getNewsById(newsId));
		return "news";
	}
	

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewsForm(Model model) {
		News newNews = new News();
		model.addAttribute("newNews", newNews);
		return "addNews";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewNewsForm(@ModelAttribute("newNews") @Valid News newNews, BindingResult result,
			HttpServletRequest request) {
		if(result.hasErrors()) {
			 return "addNews";
			}

		MultipartFile newsImage = newNews.getNewsImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (newsImage != null && !newsImage.isEmpty()) {
			try {
				newsImage.transferTo(
						new File(rootDirectory + "resources\\images\\" + newNews.getNewsId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("News Image saving failed", e);
			}
		}
		newsService.addNews(newNews);
		return "redirect:/news/adminPage";
	}
	
	@RequestMapping(value = "/editNews", method = RequestMethod.GET)
	public String getUpdateNewNewsForm(@RequestParam("id") String newsId, Model model) {
		News newNews = newsService.getNewsById(newsId);
		model.addAttribute("newNews", newNews);
		return "editNews";
	}

	@RequestMapping(value = "/editNews", method = RequestMethod.POST)
	public String processUpdateNewNewsForm(@ModelAttribute("newNews") News newNews, BindingResult result,
			HttpServletRequest request) {
		newsService.update(newNews);
		return "redirect:/allNews/adminPage";
	}
	
	@RequestMapping(value = "/deleteNews", method = RequestMethod.GET)
	public String getDeleteNewsForm(@RequestParam("id") String newsId) {
		newsService.delete(newsId);
		return "redirect:/allNews/adminPage";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("newsId", "type", "headline", "description");
		binder.setValidator(newsValidator);
	}

	@ExceptionHandler(NewsNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, NewsNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidNewsId", exception.getNewsId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
		mav.setViewName("newsNotFound");
		return mav;
	}

}
