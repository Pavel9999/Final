package by.epam.task05.service.impl;

import by.epam.task05.dao.DAOProvider;
import by.epam.task05.dao.UserDAO;
import by.epam.task05.entity.User;
import by.epam.task05.entity.UserRole;
import by.epam.task05.logger.MyLogger;
import by.epam.task05.service.AdminService;


import java.util.List;

public class AdminServiceImpl  implements AdminService {

    @Override
    public List<User> getAllUsers() {

        List<User> users = null;

        DAOProvider daoProvider = DAOProvider.getInstance();
        UserDAO userDAO = daoProvider.getUserDAO();

        try{
            users = userDAO.getUsers();
        }catch (Exception e) {
            System.out.println(e);
            MyLogger.getInstance().error(e);
        }

        return users;
    }

    @Override
    public List<User> getManagers() {

        List<User> users = null;

        DAOProvider daoProvider = DAOProvider.getInstance();
        UserDAO userDAO = daoProvider.getUserDAO();

        try{
            users = userDAO.getUsers(UserRole.MANAGER);
        }catch (Exception e) {
            System.out.println(e);
            MyLogger.getInstance().error(e);
        }

        return users;
    }

    @Override
    public List<User> getClients() {

        List<User> users = null;

        DAOProvider daoProvider = DAOProvider.getInstance();
        UserDAO userDAO = daoProvider.getUserDAO();

        try{
            users = userDAO.getUsers(UserRole.CLIENT);
        }catch (Exception e) {
            System.out.println(e);
            MyLogger.getInstance().error(e);
        }

        return users;
    }
}
