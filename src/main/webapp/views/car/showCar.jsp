<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<script src="/resources/script/validation-car.js"></script>
<link rel="stylesheet" href="car.css">
<c:import url="/header" />
<body>
	<div class='container'>
		<div class='allCar'>
			<c:forEach var="car" items="${carList}">
				<div class='carInfo'>
					<a href="/car?car_num=${car.code}">
						<c:choose>
							<c:when test="${car.name eq '더 뉴 아반떼'}">
								<img src="https://autoimg.danawa.com/photo/4455/model_360.png">
							</c:when>
							<c:when test="${car.name eq 'BMW 3 Series'}">
								<img
									src="https://cache.bmwusa.com/cosy.arox?pov=walkaround&brand=WBBM&vehicle=243T&client=byoc&paint=P0300&fabric=FKHSW&sa=S01CB,S01CE,S01R6,S02TB,S0302,S0319,S0322,S03AG,S03DZ,S0403,S0430,S0431,S0459,S0465,S0481,S0493,S04LN,S04UR,S0534,S0544,S05AC,S0676,S06AC,S06AK,S06C4,S06U2,S06WC,S0704,S0710,S0715,S0754,S0760,S0775&quality=90&bkgnd=transparent&resp=png&width=600&angle=40&w=9800&h=8000&x=100&y=1100">
							</c:when>
							<c:when test="${car.name eq '아우디 A6'}">
								<img src="https://autoimg.danawa.com/photo/3713/model_360.png">
							</c:when>
							<c:otherwise>
								<img
									src="https://flexible.img.hani.co.kr/flexible/normal/640/377/imgdb/resize/2016/0721/146900789689_20160721.JPG">
							</c:otherwise>
						</c:choose>
					</a>

					<h4>${car.brand} ${car.name }</h4>
					<h3 id='price'>
						<fmt:formatNumber value="${car.price}" pattern="#,###" />
					</h3>
					<p>${car.year}년식|${car.oil}</p>
					<input type="hidden" value="${car.code}">
				</div>
			</c:forEach>
		</div>
		<div id="pagination">
			<span class="right-button" id="prev_page">＜</span>
			
			<div class="pages"></div>
				<span class="active">1</span>
				<span>2</span>
				<span>3</span>
				<span>4</span>
				<span>5</span>
			</div>
			<span class="left-button" id="next_page">＞</span>
	</div>
</body>
</html>