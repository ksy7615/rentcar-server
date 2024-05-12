package rentcarServer.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcarServer.reservation.model.ReservationDao;

public class CheckReservationAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startDateTime = request.getParameter("startDateTime");
        String endDateTime = request.getParameter("endDateTime");
        String carCode = request.getParameter("carCode");
        
        System.out.println(startDateTime);
        System.out.println(endDateTime);
        System.out.println(carCode);

        ReservationDao reservationDao = ReservationDao.getInstance();
        boolean isAvailable = reservationDao.checkAvailability(startDateTime, endDateTime, carCode);

        if (isAvailable) {
            response.getWriter().write("available");
        } else {
            response.getWriter().write("not available");
        }
	}

}
