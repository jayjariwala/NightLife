package com.jayjariwala.nightlife.MODEL;

public class BarModel {
	
	private String image,name,comment,id,street,city,state,rating,url;
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BarModel()
	{
	}

	public BarModel(String image, String name, String comment, String id, String rating,String url,int count) {
		super();
		this.image = image;
		this.name = name;
		this.comment = comment;
		this.id = id;
		this.url=url;
		this.rating = rating;
		this.count=count;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}