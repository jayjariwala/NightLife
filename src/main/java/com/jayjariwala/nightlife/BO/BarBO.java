package com.jayjariwala.nightlife.BO;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jayjariwala.nightlife.DAO.nightlifeDAO;
import com.jayjariwala.nightlife.MODEL.BarModel;
import com.jayjariwala.nightlife.MODEL.NightlifeModel;

public class BarBO {
	
	BarModel model;
	ArrayList<BarModel> list=new ArrayList<BarModel>();
	nightlifeDAO dao=new nightlifeDAO();
	public ArrayList<BarModel> getBarList(JSONArray Businesses)
	{
		BarBO bo=new BarBO();
		for(int i=0;i< Businesses.size();i++)
		{
			JSONObject BarObject=(JSONObject) Businesses.get(i);
			String comments=(String) BarObject.get("snippet_text");
			String rating=(String) BarObject.get("rating_img_url");
			JSONObject address= (JSONObject) BarObject.get("location");
			String BarID=(String) BarObject.get("id");
			String BarImage=(String) BarObject.get("image_url");
			String name=(String)BarObject.get("name");
			String url=(String)BarObject.get("url");
			String random=bo.randomString();
			int count=dao.getbarcount(BarID);
			System.out.println(BarObject);
			model=new BarModel( BarImage, name, comments, BarID, rating,url,count,random);
			list.add(model);
		}
		return list;
	}
	public String randomString()
	{
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		return output;
	}
	public int goingtoclub(NightlifeModel model)
	{
		nightlifeDAO dao=new nightlifeDAO();
		int i=dao.goingclub(model);
		return dao.getbarcount(model.getClubid());
		
	}
}
