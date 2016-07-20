package com.jayjariwala.nightlife.BO;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jayjariwala.nightlife.MODEL.BarModel;

public class BarBO {
	
	BarModel model;
	ArrayList<BarModel> list=new ArrayList<BarModel>();;
	public ArrayList<BarModel> getBarList(JSONArray Businesses)
	{
		for(int i=0;i< Businesses.size();i++)
		{
			JSONObject BarObject=(JSONObject) Businesses.get(i);
			String comments=(String) BarObject.get("snippet_text");
			String rating=(String) BarObject.get("rating_img_url");
			JSONObject address= (JSONObject) BarObject.get("location");
			JSONArray display_address= (JSONArray) address.get("display_address");
			String BarID=(String) BarObject.get("id");
			String BarImage=(String) BarObject.get("image_url");
			String name=(String)BarObject.get("name");
			model=new BarModel( BarImage, name, comments, BarID, rating);
			list.add(model);
		}
		return list;
	}
}
