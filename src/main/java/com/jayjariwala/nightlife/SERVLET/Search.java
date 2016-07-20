package com.jayjariwala.nightlife.SERVLET;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.jayjariwala.nightlife.BO.BarBO;
import com.jayjariwala.nightlife.BO.YelpAPI;
import com.jayjariwala.nightlife.MODEL.BarModel;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String searchString=request.getParameter("searchInput");
		YelpAPI api=new YelpAPI();
		String [] search = new String[2];
		search[0]="--location";
		search[1]=searchString;
		JSONArray businesses=api.search(search);
		BarBO bo=new BarBO();
		ArrayList<BarModel> list=bo.getBarList(businesses);
		
		RequestDispatcher dispatch=request.getRequestDispatcher("index.jsp");
		request.setAttribute("list",list);
		dispatch.forward(request, response);
		
		
		
	
	}

}
