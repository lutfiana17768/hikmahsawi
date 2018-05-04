
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="rss" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
	
	<!-- CSS -->
	<link href="<rss:url value="/resources/css/app.css "/>" rel="stylesheet" type="text/css"/>
	<link href="<rss:url value="/resources/css/vendor.css "/>" rel="stylesheet" type="text/css"/>
	<link href="<rss:url value="/resources/css/bootstrap.min.css "/>" rel="stylesheet" type="text/css"/>
	<link href="<rss:url value="/resources/css/select2.css "/>" rel="stylesheet" type="text/css"/>
	<link href="<rss:url value="/resources/css/gh-pages.css "/>" rel="stylesheet" type="text/css"/>
	<link href="<rss:url value="/resources/css/select2.min.css "/>" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="//select2.github.io/select2/select2-3.5.2/select2.css">
	<link href="<rss:url value="/resources/bootstrap-daterangepicker/daterangepicker.min.css" />" rel="stylesheet" type="text/css">
	<link href="<rss:url value="/resources/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" />" rel="stylesheet" type="text/css">
	<link href="<rss:url value="/resources/bootstrap-timepicker/css/bootstrap-timepicker.min.css" />" rel="stylesheet" type="text/css">
	
	<!-- JS -->
	<script src="<rss:url value="/resources/js/app.js "/>" /></script>
	<script src="<rss:url value="/resources/js/vendor.js "/>" /></script>
	<script src="<rss:url value="/resources/js/bootstrap.min.js "/>" /></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.full.js"></script>
	<script src="<rss:url value="/resources/bootstrap-datepicker/js/bootstrap-datepicker.min.js" />" type="text/javascript"></script>
	<script src="<rss:url value="/resources/scripts/components-date-time-pickers.min.js" />" type="text/javascript"></script>
	<script>
	 $(function(){
	     var d = new Date(2017, 05, 19);
	     $(".date").datepicker({
	     	todayHighlight: true,
	         autoclose: true,
	         format: "yyyy-mm-dd"
	     });
	 });
 </script>
	
</head>