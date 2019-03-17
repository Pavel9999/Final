package by.epam.task05.controller.command.impl;



import by.epam.task05.controller.command.Command;
import by.epam.task05.controller.command.util.CreatorFullURL;
import by.epam.task05.dao.DaoException;
import by.epam.task05.entity.Car;
import by.epam.task05.entity.ContractData;
import by.epam.task05.entity.User;
import by.epam.task05.entity.UserRole;
import by.epam.task05.logger.MyLogger;
import by.epam.task05.service.CarService;
import by.epam.task05.service.ClientService;
import by.epam.task05.service.ContractService;
import by.epam.task05.service.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToAddUserCommand implements Command {

    public static final String COMMAND = "go_to_add_user";

    private static final String ADD_CAR_PAGE = "/WEB-INF/views/add_user.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String url = CreatorFullURL.create(request);
        request.getSession(true).setAttribute("prev_request", url);

        String page = ADD_CAR_PAGE;

        request.setAttribute("prev_command", COMMAND);
        if (request.getParameterMap().containsKey("local")) {
            String newLocale = request.getParameter("local");
            request.getSession(true).setAttribute("local", newLocale);
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher(page);

        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
            MyLogger.getInstance().error(e);
        }
    }
}


