package by.epam.task05.controller.command.impl;

import by.epam.task05.controller.command.Command;
import by.epam.task05.controller.command.util.CreatorFullURL;
import by.epam.task05.dao.DaoException;
import by.epam.task05.entity.Car;
import by.epam.task05.entity.ContractData;
import by.epam.task05.entity.User;
import by.epam.task05.entity.UserRole;
import by.epam.task05.logger.MyLogger;
import by.epam.task05.service.*;
import com.sun.org.apache.bcel.internal.generic.SWITCH;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AllClientsCommand implements Command
{
    public static final String COMMAND = "all_clients";

    private static final String ADMIN_CLIENTS_PAGE = "/WEB-INF/views/admin_users.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = null;
        String email = null;
        UserRole role = null;
        String url = null;
        String page = null;
        List<User> users = new LinkedList<>();

        request.setAttribute("prev_command", COMMAND);
        if (request.getParameterMap().containsKey("local")) {
            String newLocale = request.getParameter("local");
            request.getSession(true).setAttribute("local", newLocale);
        }


        session = request.getSession(true);
        email = (String)session.getAttribute("email");
        role = UserRole.createRole((String)session.getAttribute("role")) ;
        url = CreatorFullURL.create(request);
        session.setAttribute("prev_request", url);

        ServiceProvider provider = ServiceProvider.getInstance();
        AdminService adminService = provider.getAdminService();
        try{
            users = adminService.getClients();
        }
        catch (Exception e)
        {
            System.out.println(e);
            MyLogger.getInstance().error(e);
        }


        request.setAttribute("users", users);

        if (role == UserRole.ADMIN) {
            page = ADMIN_CLIENTS_PAGE;
        }
        else
        {
            page = ADMIN_CLIENTS_PAGE;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);

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
