<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<link rel="stylesheet" href="/resources/style/main.css">
<c:import url="/header" />
<body>
	<div id="main-container">
		<div id="loginform">
			<button>회원가입</button>
			<button onclick="location.href='/login'">로그인/로그아웃*c태그로 변환</button>
			<button>빠른 예약</button>
			<button>예약확인 바로가기</button>
		</div>
		<div id="advertisement">
			<img src="https://i.namu.wiki/i/WtEFZOxYlKtifz8WW_q21uAIzHhLOBjf3kHaNBN67WYlDG4scyNPloD42e4ZklPcchLQLP2PAxiKpD37Ue0wYA.webp">
		</div>	
		<div class="show-car">
			<img src="https://flexible.img.hani.co.kr/flexible/normal/640/377/imgdb/resize/2016/0721/146900789689_20160721.JPG">
			<img src="https://flexible.img.hani.co.kr/flexible/normal/640/377/imgdb/resize/2016/0721/146900789689_20160721.JPG">
			<img src="https://flexible.img.hani.co.kr/flexible/normal/640/377/imgdb/resize/2016/0721/146900789689_20160721.JPG">
			<img src="https://flexible.img.hani.co.kr/flexible/normal/640/377/imgdb/resize/2016/0721/146900789689_20160721.JPG">
			<img src="https://flexible.img.hani.co.kr/flexible/normal/640/377/imgdb/resize/2016/0721/146900789689_20160721.JPG">
			<img src="https://flexible.img.hani.co.kr/flexible/normal/640/377/imgdb/resize/2016/0721/146900789689_20160721.JPG">
		</div>
	</div>
<c:import url="/footer" />
</body>
</html>