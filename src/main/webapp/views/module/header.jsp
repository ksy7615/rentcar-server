<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/grid.css?after">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>렌트카 서비스</title>
</head>
<body>
	<header>
		<div id="logo">
			<h1>
				&nbsp;&nbsp;&nbsp;The<br>RentKing
			</h1>
		</div>
		<form id="form">
			<select id="select">
				<option disabled selected>국산/수입</option>
				<option value="domestic">국산</option>
				<option value="income">수입</option>
			</select> <input type="text" id="query"> <input type="submit"
				value="🔍">
		</form>
		<div id="mypage-button"></div>
		<nav id="nav-main">
			<div id="float-list"></div>
			<ul>
				<li><a href="/selectDate"><span>렌트카 예약</span></a></li>
				<li><a href="/board"><span>고객지원</span></a></li>
			</ul>
		</nav>
		<button type="button">
			<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSytK7HdzDpUn5hdf3eaO4MxohL3CLpNB0QN5K9mXtrBw&s" width=50px; alt="👤" onclick="location.href='/mypage'">
		</button>
	</header>
	<script src="/resources/script/validation-main.js"></script>
</body>
</html>