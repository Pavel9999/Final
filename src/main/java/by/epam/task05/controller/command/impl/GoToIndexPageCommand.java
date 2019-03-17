package by.epam.task05.controller.command.impl;



import by.epam.task05.controller.command.Command;
import by.epam.task05.controller.command.util.CreatorFullURL;
import by.epam.task05.entity.Car;
import by.epam.task05.entity.UserRole;
import by.epam.task05.logger.MyLogger;
import by.epam.task05.service.CarService;
import by.epam.task05.service.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GoToIndexPageCommand implements Command {

	public static final String COMMAND = "go_to_index";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		List<Car> cars;
		HttpSession session = request.getSession(true);

		request.setAttribute("prev_command", "go_to_index");
		if (request.getParameterMap().containsKey("local")) {
			String newLocale = request.getParameter("local");
			session = request.getSession(true);
			session.setAttribute("local", newLocale);
		}
		else
		{
			String newLocale = "ru";
			session.setAttribute("local", newLocale);
		}

		String url = CreatorFullURL.create(request);
		session.setAttribute("role", UserRole.GUEST.toString());
		session.setAttribute("email", "");
		session.setAttribute("prev_request", url);

		ServiceProvider provider = ServiceProvider.getInstance();
		CarService service = provider.getCarService();
		cars = service.selectAllCars();
		request.setAttribute("cars", cars);
		List<List<Car>> carRows = getCarRows(cars);
		request.setAttribute("car_rows", carRows);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/default.jsp");

		try {
			dispatcher.forward(request, response);
		}
		catch (Exception e)
		{
			System.out.println(e);
			MyLogger.getInstance().error(e);
		}
		
	}

	private List<List<Car>> getCarRows(List<Car> cars)
	{
		List<List<Car>> result = new LinkedList<>();

		for(int i=0; i < cars.size(); i++)
		{
			if (i%3 == 0) result.add(new LinkedList<Car>());

			result.get(result.size()-1).add(cars.get(i));
		}

		return result;
	}

}
