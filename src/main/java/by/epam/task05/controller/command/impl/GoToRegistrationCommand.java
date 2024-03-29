package by.epam.task05.controller.command.impl;



import by.epam.task05.controller.command.Command;
import by.epam.task05.controller.command.util.CreatorFullURL;
import by.epam.task05.logger.MyLogger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToRegistrationCommand implements Command {

	public static final String COMMAND = "goToRegistrationPage";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		
		String url = CreatorFullURL.create(request);
		request.getSession(true).setAttribute("prev_request", url);

		request.setAttribute("prev_command", COMMAND);
		if (request.getParameterMap().containsKey("local")) {
			String newLocale = request.getParameter("local");
			request.getSession(true).setAttribute("local", newLocale);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/registration.jsp");

		try {
			dispatcher.forward(request, response);
		}
		catch (Exception e)
		{
			System.out.println(e);
			MyLogger.getInstance().error(e);
		}
	}

}
