package by.epam.task05.dao;


import by.epam.task05.entity.User;
import by.epam.task05.entity.UserData;
import by.epam.task05.entity.UserRole;

import java.util.List;

public interface UserDAO {

	User authentification(String login, String password) throws DaoException;
	boolean validation(String userLogin, String userPassword);
	
	boolean registration(UserData userData)  throws DaoException;

	boolean checkEmailAvailability(String email) throws DaoException;

	User getUser(String email) throws DaoException;
	User getUser(int id) throws DaoException;

	List<User> getUsers() throws DaoException;
	List<User> getUsers(UserRole role) throws DaoException;
	boolean setRole(int idUser, UserRole role) throws DaoException;
	boolean setPassword(int idUser, String oldPassword, String newPassword) throws DaoException;
}
