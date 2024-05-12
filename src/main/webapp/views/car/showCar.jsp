<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<a href="/viewCar?car_code=${car.code}"> <c:choose>
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
							<c:when test="${car.name eq 'K5'}">
								<img src="https://i.namu.wiki/i/oJ0gqvAVWoqtjWlJqDoCOj-EZuCY9588XQZPMuwnhZ2M8S17_mQCUpPUA3y6__dDkOUjSTjW5hQhVhKRXH23Fw.webp">
							</c:when>
							<c:when test="${car.name eq '메르세데스 E-Class'}">
								<img src="https://file.carisyou.com/upload/2020/03/04/FILE_202003040247195880.png">
							</c:when>
							<c:when test="${car.name eq 'QM6'}">
								<img src="https://autoimg.danawa.com/photo/3732/model_360.png">
							</c:when>
							<c:when test="${car.name eq '스포티지'}">
								<img src="https://autoimg.danawa.com/photo/4069/model_360.png">
							</c:when>
							<c:when test="${car.name eq '재규어 F-Type'}">
								<img src="https://i.namu.wiki/i/rmjXuIifnUs3eMfStmF1U4qx_M1bTRX3zD1Kf8jn_FC7FrorrffCKij_54oKRLI8VhFk38Oe26MoS9xW_Ti1fg.webp">
							</c:when>
							<c:when test="${car.name eq '포르쉐 카이엔'}">
								<img src="https://autoimg.danawa.com/photo/4506/model_360.png">
							</c:when>
							<c:when test="${car.name eq '티볼리'}">
								<img src="https://i.namu.wiki/i/plFDnGSBIUvElFdsSWed6X4iGdqqJq1flTNhfJAY31lZIiegMCiCdSDTItViAnB6iMyip-oiCRc3LczC6LagpA.webp">
							</c:when>
							<c:when test="${car.name eq 'K3'}">
								<img src="https://autoimg.danawa.com/photo/3551/model_360.png">
							</c:when>
							<c:when test="${car.name eq '람보르기니 우르스'}">
								<img src="https://t1.daumcdn.net/news/202001/17/Autodiary/20200117151618813tpdl.png">
							</c:when>
							<c:when test="${car.name eq '페라리 488 GTB'}">
								<img src="https://file.carisyou.com/newcar/color/4990_ferrari_488gtb2015_100.png">
							</c:when>
							<c:when test="${car.name eq '렉서스 RX'}">
								<img src="https://mblogthumb-phinf.pstatic.net/MjAyMjA2MDZfNzUg/MDAxNjU0NTI0OTYwODQ1.ysElPuQ7RYlpvAIu_YVzy9Q54wcb7wt-1NnHSwRfYysg.OTxkTGSYN4Mvw8Ur5sqx7kgsq0n3dBLrNwQHb1HFDokg.JPEG.whdgus9640/2023-Lexus-RX-Premium-Front-Quarter.jpg?type=w800">
							</c:when>
							<c:when test="${car.name eq '롤스로이스 고스트'}">
								<img src="https://autoimg.danawa.com/photo/3994/model_360.png">
							</c:when>
							<c:when test="${car.name eq 'K7'}">
								<img src="https://autoimg.danawa.com/photo/3722/model_360.png">
							</c:when>
							<c:when test="${car.name eq '벤틀리 벤테이가'}">
								<img src="https://img1.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202006/24/autodaily/20200624181754650wuzq.jpg">
							</c:when>
							<c:when test="${car.name eq '무쏘'}">
								<img src="https://wimg.mk.co.kr/meet/neds/2021/08/image_readbot_2021_808046_16294668994758216.jpg">
							</c:when>
							<c:when test="${car.name eq '마세라티 그란투리스모'}">
								<img src="https://img.kbchachacha.com/IMG/article/MAGAZINE/202303/2005814313392605.jpg">
							</c:when>
							<c:when test="${car.name eq '모닝'}">
								<img src="https://i.namu.wiki/i/zFW357XOcxSjWAcLmMm22jR7SWRqPzwtrY8MtsvwjgVXbsfMItD0rNoa_TkRghMVZJ-8dRLTDZaA7hmpWztggQ.webp">
							</c:when>
							<c:when test="${car.name eq '부가티 베이론'}">
								<img src="https://p.turbosquid.com/ts-thumb/73/W3OsYf/NAQ2sISD/1/jpg/1370094512/600x600/fit_q87/737aadf9b14a5f25ee990f02ec2f77abbf2a397e/1.jpg">
							</c:when>
							<c:when test="${car.name eq '페라리 812 슈퍼패스트'}">
								<img src="https://i.namu.wiki/i/J_ahEW3mAMkyFfg2R-eqSCHK7fLDkhcwU3od8VW4rpHdLPnBxubjrqPEU_lanug3OFKDb3rL8EMzawQoDedFfQ.webp">
							</c:when>
							<c:when test="${car.name eq '그랜저'}">
								<img src="https://autoimg.danawa.com/photo/4188/model_360.png">
							</c:when>
							<c:when test="${car.name eq '맥라렌 720S'}">
								<img src="https://autoimg.danawa.com/photo/3461/model_360.png">
							</c:when>
							<c:when test="${car.name eq '코란도'}">
								<img src="https://i.namu.wiki/i/ww9SLe6ICHqnqMk6lzDACNvFljvKNnVSBb2tNVhTrq3b1mDA7U9zBS8H7RSVHRJi4WRPOjio3OpFij1O0Ap3pA.webp">
							</c:when>
							<c:when test="${car.name eq '람보르기니 우라칸'}">
								<img src="https://i.namu.wiki/i/-Z61Q7e0sELq5kFaSfnuIU_VU22DWG6dN8Z9brFRW32USxP9Wn3qnjVeooN9Ygv60nrVOcImjGRThVAGQKDAzQ.webp">
							</c:when>
							<c:otherwise>
								<img
									src="https://www.carwiki.co.kr/images/noImageL.png">
							</c:otherwise>
						</c:choose>
					</a>

					<h4>${car.brand}${car.name }</h4>
					<h3 id='price'>
						시간당
						<fmt:formatNumber value="${car.price}" pattern="#,###" />
						원
					</h3>
					<p>${car.year}년식|${car.oil}</p>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>