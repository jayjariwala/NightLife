package com.jayjariwala.nightlife.BO;
import java.util.ArrayList;

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
			int count=dao.getbarcount(BarID);
			System.out.println(BarObject);
			model=new BarModel( BarImage, name, comments, BarID, rating,url,count);
			list.add(model);
		}
		return list;
	}
	public void goingtoclub(NightlifeModel model)
	{
		nightlifeDAO dao=new nightlifeDAO();
		int i=dao.goingclub(model);
		System.out.println("status:"+i);
		
	}
}
