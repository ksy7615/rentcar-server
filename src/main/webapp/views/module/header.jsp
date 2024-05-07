<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/grid.css">
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
			</select>
			<input type="text" id="query">
			<input type="submit" value="🔍">
		</form>
		<div id="mypage-button">
		</div>
		<nav id="nav-main">
			<div id="float-list"></div>
			<ul>
				<li><a href="about:blank"><div>단기 렌터카</div></a></li>
				<li><a href="about:blank"><div>신차 장기 렌터카</div></a></li>
				<li><a href="about:blank"><div>신차 중고차 렌터카</div></a></li>
				<li><a href="about:blank"><div>법인 장기 렌터카</div></a></li>
				<li><a href="about:blank"><div>이벤트/프로모션</div></a></li>
				<li><a href="/board"><div>고객지원</div></a></li>
			</ul>
		</nav>
		<button onclick="location.href='/mypage'">👤</button>		
	</header>
</body>
</html>