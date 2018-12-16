package service.proxy;

import service.UserService;
import transaction.TransactionManager;
import entity.User;
import exception.DataAccessException;
import exception.DuplicateUsernameException;
import exception.ServiceException;
import exception.UserDisabledException;
import exception.UserNotFoundException;
import factory.ObjectFactory;

public class UserServiceProxy implements UserService {

	private UserService userService;
	
	public UserServiceProxy() {
		userService=(UserService) ObjectFactory.getObject("userServiceTarget");
	}
	
	public User login(String username, String password) throws UserNotFoundException, UserDisabledException {
		User user=null;
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			user=userService.login(username, password);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		} catch (UserNotFoundException e) {
			transactionManager.rollback();
			throw e;
		} catch (UserDisabledException e) {
			transactionManager.rollback();
			throw e;
		}
		return user;
	}

	public void regist(User user) throws DuplicateUsernameException {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try{
			transactionManager.beginTransaction();
			
			userService.regist(user);
			
			transactionManager.commit();
		}catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}catch (DuplicateUsernameException e) {
			transactionManager.rollback();
			throw e;
		}
	}

}
