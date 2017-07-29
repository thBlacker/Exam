package com.bjpowernode.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjpowernode.bean.Question;

/**
 * Servlet implementation class QuestionRandomFindServlet
 */
@WebServlet("/QuestionRandomFindServlet")
public class QuestionRandomFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      String sql="select * from question order by rand() limit 2";
	      List list = new ArrayList();
	      HttpSession session=request.getSession();
	      try{
	          Class.forName("com.mysql.jdbc.Driver");
	          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examdb", "root", "123");
	          ps= con.prepareStatement(sql);
		      rs=ps.executeQuery();		   
		  //4.将得到数据通过I/O流输送到用户的浏览器			      
		      while(rs.next()){
		    	  Question q= new Question();
		    	  q.setId(rs.getInt("id"));
		    	  q.setAnswer(rs.getString("answer"));
		    	  q.setTitle(rs.getString("title"));
		    	  q.setOptionA(rs.getString("optionA"));
		    	  q.setOptionB(rs.getString("optionB"));
		    	  q.setOptionC(rs.getString("optionC"));
		    	  q.setOptionD(rs.getString("optionD"));
		    	  
		    	  list.add(q);
		      }//user牺牲了
        }catch(Exception ex){
      	  ex.printStackTrace();
        }
	      session.setAttribute("questionList", list);
	      request.getRequestDispatcher("/user/exam.jsp").forward(request, response);
	}

}
