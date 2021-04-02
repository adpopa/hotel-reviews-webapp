<%-- 
    Document   : header
    Created on : 24-Nov-2018, 04:09:52
    Author     : christopher
--%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
	
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link href='<spring:url value="/css/main.css"/>' rel="stylesheet" />

<!--Bootstrap javascript and a library used to make popovers work-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<!-- Vue.js -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

<!-- Promise -->
<script
	src="https://cdn.jsdelivr.net/npm/es6-promise@4/dist/es6-promise.auto.js"></script>

<!-- Vuex -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/vuex/3.0.1/vuex.min.js"></script>
</head>
<body>
	<div id="app">
		<div class="container">
			<ul class="nav">
				<li class="nav-item"><a class="nav-link"
					href='<spring:url value="/"/>'>Home</a></li>
				<sec:authorize access="!isAuthenticated()">
					<li class="nav-item"><a class="nav-link"
						href='<spring:url value="/login"/>'>Login</a></li>
					<li class="nav-item"><a class="nav-link"
						href='<spring:url value="/register"/>'>Sign Up</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="nav-item"><a class="nav-link"
						href='<spring:url value="/logout"/>'>Logout</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN')">
					<li class="nav-item"><a class="nav-link"
						href='<spring:url value="/admin/dashboard"/>'>Dashboard</a></li>
				</sec:authorize>
				<li class="nav-item"><a class="nav-link"
					href='<spring:url value="/request"/>'>Hotel Request</a></li>
			</ul>