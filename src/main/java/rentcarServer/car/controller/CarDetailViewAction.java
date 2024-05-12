package rentcarServer.car.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcarServer.car.model.CarDao;
import rentcarServer.car.model.CarResponseDto;

public class CarDetailViewAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarDao carDao = CarDao.getInstance();
		
		String startDate = request.getParameter("start-datetime");
		String endDate = request.getParameter("end-datetime");
		String carCode = request.getParameter("car_code");
		int carId = Integer.parseInt(carCode);
		
		System.out.println(startDate);
		System.out.println(endDate);

		CarResponseDto car = carDao.findCarsByCarCode(carId);
		
		request.setAttribute("car", car);
		
		request.getRequestDispatcher("/carDetail?car_code="+carCode).forward(request, response);
	}
}
