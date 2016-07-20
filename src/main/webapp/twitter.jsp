
<%@ page import="twitter4j.Twitter"%>


 
<% 
Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");
if(twitter!=null){

%>
<p>Twitter ID:<%=twitter.getId()%></p>
<p>Twitter Screen Name:<%=twitter.getScreenName()%></p>
<%
}
%>