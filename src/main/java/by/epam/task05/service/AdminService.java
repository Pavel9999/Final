package by.epam.task05.service;

import by.epam.task05.dao.DaoException;
import by.epam.task05.entity.Car;
import by.epam.task05.entity.User;

import java.util.List;

public interface AdminService {

    List<User> getAllUsers() throws ServiceException, DaoException;
    List<User> getClients() throws ServiceException, DaoException;
    List<User> getManagers() throws ServiceException, DaoException;
}
