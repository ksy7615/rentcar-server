package rentcarServer.car.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcarServer.car.model.CarDao;
import rentcarServer.car.model.CarResponseDto;

public class CarListAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarDao carDao = CarDao.getInstance();
		String startDate = request.getParameter("start-datetime");
		String endDate = request.getParameter("end-datetime");
		List<CarResponseDto> carList = carDao.findValidCars(startDate, endDate);
		
		request.setAttribute("start-datetime", startDate);
		request.setAttribute("end-datetime", endDate);
		request.setAttribute("carList", carList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/car/list");
		dispatcher.forward(request, response);
	}
}
