package com.lmpjt.pilotpjt.controller;
import javax.servlet.http.HttpServletRequest;

//registerOK.jsp 역할(정보가 제대로 들어왔는지 주고받고 역할을 한다.)
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Book;
import model.BookDAOImpl;
import model.UserDAOImpl;

@Controller
public class BookController {
   
   BookDAOImpl manager = BookDAOImpl.getInstance();
   
   
   @RequestMapping("/main")
   public String getMainBookInfo() {
      UserDAOImpl manager = UserDAOImpl.getInstance();
      manager.test();
      return "main";
   }
   
   @RequestMapping("/insert_book")
   public String insertBook(Book book) {
      
      return "insert_book";
   }
   
   @RequestMapping(method=RequestMethod.POST,value = "/insert_book")
   
   public ModelAndView insertBook(Book book, HttpServletRequest request) 
   {
      ModelAndView mv = new ModelAndView();
      int re = manager.insertBook(book, 1);
      if(re == 1 )
      {
         mv.setViewName("redirect:/main");
      }
      return mv;
   }
   
   @RequestMapping("/update_book")
   public String updateBook(Book book) {
      return "book_update";
   }
   
   @RequestMapping("/search_book")
   public String searchBook(String title) {
      return "book_search";
   }
}
