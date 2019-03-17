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
import java.util.List;

public class ClientContractsCommand implements Command
{
    public static final String COMMAND = "client_contracts";

    private static final String CLIENT_CONTRACTS_PAGE = "/WEB-INF/views/client_contracts.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException, DaoException {

        HttpSession session;
        String email;
        UserRole role;
        String url;
        String page;
        List<ContractData> contracts;
        List<Car> cars;


        session = request.getSession(true);
        email = (String)session.getAttribute("email");
        role = UserRole.createRole((String)session.getAttribute("role")) ;
        url = CreatorFullURL.create(request);
        session.setAttribute("prev_request", url);

        request.setAttribute("prev_command", COMMAND);
        if (request.getParameterMap().containsKey("local")) {
            String newLocale = request.getParameter("local");
            session = request.getSession(true);
            session.setAttribute("local", newLocale);
        }



        ServiceProvider provider = ServiceProvider.getInstance();
        ClientService serviceClient = provider.getClientService();
        int id_client = serviceClient.getUser(email).getId();

        ContractService contractService = provider.getContractService();
        contracts = contractService.selectClientContracts(id_client);
        CarService carService = provider.getCarService();
        cars = carService.selectCarsFromContractData(contracts);

        request.setAttribute("contracts", contracts);
        request.setAttribute("cars", cars);
        request.setAttribute("full_name", session.getAttribute("full_name"));

        page = CLIENT_CONTRACTS_PAGE;

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
