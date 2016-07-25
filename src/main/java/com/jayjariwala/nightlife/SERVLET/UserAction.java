package com.jayjariwala.nightlife.SERVLET;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import com.jayjariwala.nightlife.BO.BarBO;
import com.jayjariwala.nightlife.MODEL.NightlifeModel;

/**
 * Servlet implementation class UserAction
 */
@WebServlet("/UserAction")
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis=request.getRequestDispatcher("index.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NightlifeModel model=new NightlifeModel();
		BarBO bo=new BarBO();
		String barId=request.getParameter("barId");
		String keyword=request.getParameter("searchkeyword");
		Twitter twitter=(Twitter) request.getSession(false).getAttribute("twitter");
		System.out.println("barId:"+barId);
		try {
			System.out.println("twitterID:"+twitter.getId());
			model.setClubid(barId);
			model.setUserid(""+twitter.getId());
			bo.goingtoclub(model);
			RequestDispatcher dis=request.getRequestDispatcher("Search");
			request.setAttribute("keyword", keyword);
			dis.forward(request, response);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
