package com.jayjariwala.nightlife.BO;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jayjariwala.nightlife.MODEL.BarModel;

public class BarBO {

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
			
		/*	System.out.println("Comment"+comments);
			System.out.println("Rating URL:"+rating);
			System.out.println("Address:"+display_address);
			System.out.println("barID"+BarID);
			System.out.println("Bar Image:"+BarImage);  */
			
			
			
		}
		return null;
	}
}
