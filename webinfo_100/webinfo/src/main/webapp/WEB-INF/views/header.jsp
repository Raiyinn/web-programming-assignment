<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="header">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">WebInfo</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/webstore">Home <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link "
					href="/webstore/news"> News </a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<a class="nav-link btn btn-primary" href="/webstore/login"><i
					class="fas fa-sign-in-alt"></i> Login</a>
			</form>
		</div>
	</nav>
</div>
