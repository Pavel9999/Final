package by.epam.task05.controller.command.impl;



import by.epam.task05.controller.command.Command;
import by.epam.task05.controller.command.util.CreatorFullURL;
import by.epam.task05.logger.MyLogger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ResourceBundle;

public class ChangeLocale implements Command {

	private static final String DEFAULT_PAGE = "/WEB-INF/views/default.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newLocale;
		HttpSession session;


		/*
		if (request.getParameterMap().containsKey("local")) {
			newLocale = request.getParameter("local");
			session = request.getSession(true);
			session.setAttribute("local", newLocale);
		}*/

		newLocale = request.getParameter("local");
		session = request.getSession(true);
		session.setAttribute("local", newLocale);

		String url = CreatorFullURL.create(request);
		session.setAttribute("prev_request", url);


		if (request instanceof HttpServletRequest) {
			String url3 = ((HttpServletRequest)request).getRequestURL().toString();
			String com = request.getParameter("");


			String queryString3 = ((HttpServletRequest)request).getQueryString();
			System.out.println(url3 + queryString3);
		}

		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/default.jsp");
		//RequestDispatcher dispatcher = request.getRequestDispatcher(url);

		String url1 = (String)request.getSession(true).getAttribute("prev_request");
		response.sendRedirect(url1);

		try {
			//dispatcher.forward(request, response);
		}
		catch (Exception e)
		{
			System.out.println(e);
			MyLogger.getInstance().error(e);
		}
	}

}
