<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>내 예약 정보</title>
</head>
<body>
	<h1>내 예약 정보</h1>

	<table border="1">
		<tr>
			<th>예약 번호</th>
			<th>차량 이름</th>
			<th>대여일시</th>
			<th>반납일시</th>
			<th>상태</th>
		</tr>
		<c:forEach var="reservation" items="${sessionScope.myReservationList}">
			<tr>
				<td>${reservation.rezNum}</td>
				<td><a
					href="/reservationDetailAction?reservationNum=${reservation.rezNum}">${reservation.carName}</a></td>
				<td><fmt:formatDate value="${reservation.borrowDate}"
						pattern="yyyy-MM-dd HH:mm" /></td>
				<td><fmt:formatDate value="${reservation.returnDate}"
						pattern="yyyy-MM-dd HH:mm" /></td>
				<td>${reservation.status}</td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="/footer"></jsp:include>
</body>
</html>