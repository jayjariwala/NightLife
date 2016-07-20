package com.jayjariwala.nightlife.SERVLET;

import java.util.Properties;

public class TwitterProperties {

	private String cunsumerkey="ziOyOtCezW5SPXgU9vHpBpWJ0";
	private String ConsumerSecret="UrOKMbhVsTPIk2OyliAYsg4k53szQItEinWBntHXbm7QnbHq3q";
	private String requesttokenURL="https://api.twitter.com/oauth/request_token";
	private String AuthotizeURL="https://api.twitter.com/oauth/authorize";
	private String tokenAccessURL="	https://api.twitter.com/oauth/access_token";

	public Properties getProperties() {
		// TODO Auto-generated method stub
		Properties prop=new Properties();
		prop.setProperty("twitterConsumerKey", cunsumerkey);
		prop.setProperty("twitterConsumerSecret", ConsumerSecret);
		prop.setProperty("twitterRequestTokenURL", requesttokenURL);
		prop.setProperty("twitterAuthorizeURL", AuthotizeURL);
		prop.setProperty("twitterAccessTokenURL", tokenAccessURL);
		return prop;
	}

}
