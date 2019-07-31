<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rooms</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Coffee at Grand Circus</h1>
		<h2>Please Register your info</h2>
		<form action="/submit-registration" method="post">
		<table class="table">
			<tr>
				<th scope="row">User Name</th>
				<td><input type="text" name="username" autofocus/></td>
			</tr>
			<tr>
				<th scope="row">Password</th>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<th scope="row">First Name</th>
				<td><input type="text" name="firstname" /></td>
			</tr>
			<tr>
				<th scope="row">Last Name</th>
				<td><input type="text" name="lastname" /></td>
			</tr>
			
			
		</table>
		<button type="submit" class="btn btn-primary" >Register</button>
		<a class="btn link" href="/products">Cancel</a>
		</form>
	</div>
</body>
</html>>