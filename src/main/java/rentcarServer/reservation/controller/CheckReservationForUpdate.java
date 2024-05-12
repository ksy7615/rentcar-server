package rentcarServer.reservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcarServer.reservation.model.ReservationDao;

@WebServlet("/CheckReservationForUpdate")
public class CheckReservationForUpdate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startDateTime = request.getParameter("startDateTime");
        String endDateTime = request.getParameter("endDateTime");
        String carCode = request.getParameter("carCode");
        int rezNum = Integer.parseInt(request.getParameter("rezNum"));

        ReservationDao reservationDao = ReservationDao.getInstance();
        boolean isAvailable = reservationDao.checkAvailabilityForUpdate(startDateTime, endDateTime, carCode, rezNum);

        if (isAvailable) {
            response.getWriter().write("available");
        } else {
            response.getWriter().write("not available");
        }
    }
}
