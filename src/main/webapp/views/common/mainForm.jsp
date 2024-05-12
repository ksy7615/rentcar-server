<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<link rel="stylesheet" href="/resources/style/main.css?after">
<c:import url="/header" />
<body>
	<div id="main-container">
		<div id="loginform">
			<button onclick="location.href='/join'">회원가입</button>
			<c:choose>
				<c:when test="${not empty user }">
					<button onclick="location.href='/logout'">로그아웃</button>
				</c:when>
				<c:otherwise>
					<button onclick="location.href='/login'">로그인</button>
				</c:otherwise>
			</c:choose>
			<button onclick="location.href='/selectDate'">빠른 예약</button>
			<button onclick="location.href='/mypage'">예약확인 바로가기</button>
		</div>
		<div id="advertisement">
			<img
				src="https://www.automorning.com/data/photos/20190518/art_15567571606109_ea2339.jpg">
			<img
				src="https://wimg.mk.co.kr/meet/neds/2020/07/image_readtop_2020_732680_15949457784283076.jpg">
			<img
				src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbhq78K%2FbtqGuNsZlgZ%2FZOnvtuxtgKMIGrABdr14gk%2Fimg.jpg">
		</div>
	</div>
	<c:import url="/footer" />
</body>
</html>