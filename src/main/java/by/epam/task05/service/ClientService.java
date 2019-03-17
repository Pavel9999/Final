package by.epam.task05.service;


import by.epam.task05.dao.DaoException;
import by.epam.task05.entity.User;
import by.epam.task05.entity.UserData;

import java.util.List;

public interface ClientService {
	
	User authorization(String login, String password) throws ServiceException;
	boolean registration(UserData userData) throws ServiceException, DaoException;
	User getUser(String email) throws ServiceException, DaoException;

	boolean setUserPassword(int idUser, String oldPassword, String newPassword) throws DaoException;
}
