package by.epam.task05.controller.command.impl;

import by.epam.task05.controller.command.Command;
import by.epam.task05.controller.command.util.CreatorFullURL;
import by.epam.task05.dao.DaoException;
import by.epam.task05.entity.Car;
import by.epam.task05.entity.ContractData;
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

public class UnconfirmedContractsCommand implements Command
{
    public static final String COMMAND = "unconfirmed_contracts";

    private static final String CLIENT_CONTRACTS_PAGE = "/WEB-INF/views/manager_contracts.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = null;
        String email = null;
        UserRole role = null;
        String url = null;
        String page = null;
        List<ContractData> contracts = new LinkedList<>();
        List<Car> cars = new LinkedList<>();

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
        ContractService contractService = provider.getContractService();
        CarService carService = provider.getCarService();
        try{
            contracts = contractService.selectUnconfirmedContracts();
            cars = carService.selectCarsFromContractData(contracts);
        }
        catch (Exception e)
        {
            System.out.println(e);
            MyLogger.getInstance().error(e);
        }


        request.setAttribute("contracts", contracts);
        request.setAttribute("cars", cars);

        if (role == UserRole.CLIENT) {
            page = CLIENT_CONTRACTS_PAGE;
        }
        else
        {
            page = CLIENT_CONTRACTS_PAGE;
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
