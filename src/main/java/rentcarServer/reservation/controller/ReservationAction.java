package rentcarServer.reservation.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcarServer.board.model.BoardDao;
import rentcarServer.car.model.CarDao;
import rentcarServer.car.model.CarResponseDto;
import rentcarServer.reservation.model.ReservationDao;
import rentcarServer.reservation.model.ReservationRequestDto;
import rentcarServer.reservation.model.ReservationResponseDto;
import rentcarServer.user.model.User;
import rentcarServer.user.model.UserResponseDto;

public class ReservationAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ReservationDao reservationDao = ReservationDao.getInstance();
		
		String userId = (String) session.getAttribute("userId");
		
		String carCode = request.getParameter("car_code");
		int carId = Integer.parseInt(carCode);
		
		String startDate = request.getParameter("start-datetime");
		String endDate = request.getParameter("end-datetime");
		
		Timestamp startTimestamp = Timestamp.valueOf(startDate.replace("T", " "));
		Timestamp endTimestamp = Timestamp.valueOf(endDate.replace("T", " "));
		
		String carPrice = request.getParameter("carPrice");
		int price = Integer.parseInt(carPrice);
		
		String carName = request.getParameter("carName");
		
		ReservationRequestDto responseDto = new ReservationRequestDto(userId, carId, price, startTimestamp, endTimestamp, carCode, carName);
		
		ReservationResponseDto reservation = reservationDao.createReservation(responseDto);
		
		request.setAttribute("reservation", reservation);
		
		request.getRequestDispatcher("/reservation").forward(request, response);
	}

}
