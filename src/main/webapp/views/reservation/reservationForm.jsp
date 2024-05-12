<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<c:import url="/header" />
<body>
	<h1>예약 내용 확인</h1>

	<div>
		<h2>차량 정보</h2>
		<div class="car-img">
			<img
				src="https://flexible.img.hani.co.kr/flexible/normal/640/377/imgdb/resize/2016/0721/146900789689_20160721.JPG">
		</div>
		<p>브랜드 : ${car.brand}</p>
		<p>차량명 : ${car.name}</p>
		<p>가격 : ${car.price} 원/시간</p>
	</div>

	<div>
	<form onsubmit="redirectToCheckReservation(); return false;">
    <!-- 폼 내용 -->
		<h2>대여 정보</h2>
		<p>
			대여일자:
			<fmt:formatDate value="${reservation.borrowDate}"
				pattern="yyyy-MM-dd HH:mm" />
		</p>

		<p>
			반납일자:
			<fmt:formatDate value="${reservation.returnDate}"
				pattern="yyyy-MM-dd HH:mm" />
		</p>
	</form>
		<p>총 대여시간: ${reservation.carPrice / car.price} 시간</p>
		<p>총 금액: ${reservation.carPrice} 원</p>
	</div>

	<div>
		<h2>사용자 정보</h2>
		<p>사용자 이름: ${user.userName}</p>
	</div>
	<button onclick="location.href = '/myReservation'">예약</button>
	<button onclick="location.href = '/'">취소</button>

	<script src="/resources/script/vaildation-reservation.js"></script>
	<jsp:include page="/footer"></jsp:include>
</body>
</html>