<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<c:import url="/header" />
<body>
	<form method="GET" action="/car">
		<p>
			대여 일시 : <input type="datetime-local" id="start-datetime"
				name="start-datetime" pattern="yyyy-MM-dd'T'HH:mm" />
		</p>
		<p>
			반납 일시 : <input type="datetime-local" id="end-datetime"
				name="end-datetime" pattern="yyyy-MM-dd'T'HH:mm" />
		</p>
		<input type="submit" value="예약가능한 차량 확인하기">
	</form>
</body>
<jsp:include page="/footer"></jsp:include>
</html>