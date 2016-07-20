package com.jayjariwala.nightlife.SERVLET;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;
@WebServlet("/TwitterCallback") 
public class TwitterCallBackServlet  extends HttpServlet {
 
private static final long serialVersionUID = 1L;
 
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");
RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
System.out.println( "TwitterCallbackServlet:requestToken:"+requestToken);
String verifier = request.getParameter("oauth_verifier");
try {
twitter.getOAuthAccessToken(requestToken, verifier);
request.getSession().removeAttribute("requestToken");
} catch (TwitterException e) {
throw new ServletException(e);
}
response.sendRedirect("twitter.jsp");
}
}






