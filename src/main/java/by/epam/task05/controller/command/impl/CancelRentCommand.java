package by.epam.task05.controller.command.impl;

import by.epam.task05.controller.command.Command;
import by.epam.task05.controller.command.util.CreatorFullURL;
import by.epam.task05.dao.DaoException;
import by.epam.task05.entity.*;
import by.epam.task05.logger.MyLogger;
import by.epam.task05.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CancelRentCommand implements Command {

    public static final String COMMAND = "cancel_rent";

    private static final String CLIENT_CONTRACTS_PAGE = "/WEB-INF/views/client_contracts.jsp";
    private static final String MANAGER_CONTRACTS_PAGE = "/WEB-INF/views/manager_contracts.jsp";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException, DaoException {
        HttpSession session;
        String email;
        UserRole role;
        String url;
        String page = CLIENT_CONTRACTS_PAGE;
        List<ContractData> contracts = new LinkedList<>();

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
        ClientService clientService = provider.getClientService();
        ContractService contractService = provider.getContractService();

        User user = clientService.getUser(email);
        int idUser = user.getId();
        int idContract = Integer.valueOf(request.getParameter("contract_id"));


        contractService.cancelRent(idContract);

        if (role == UserRole.CLIENT) {
            page = CLIENT_CONTRACTS_PAGE;
            contracts = contractService.selectClientContracts(idUser);
        }
        if (role == UserRole.MANAGER) {
            page = MANAGER_CONTRACTS_PAGE;
            contracts = contractService.selectManagerContracts(idUser);
        }


        request.setAttribute("contracts", contracts);

        CarService carService = provider.getCarService();
        List<Car> cars = carService.selectCarsFromContractData(contracts);
        request.setAttribute("cars", cars);

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
