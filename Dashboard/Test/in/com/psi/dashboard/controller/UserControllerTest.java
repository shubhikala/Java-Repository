package in.com.psi.dashboard.controller;

import static org.junit.Assert.*;
import in.com.psi.dashboard.entity.VO.AuthenticationVO;
import in.com.psi.dashboard.exception.DashboardException;

import org.junit.Test;

public class UserControllerTest {

	@Test
	public void testlogin() throws DashboardException {
		UserController userController = new UserController();
		AuthenticationVO authenticationVO = new AuthenticationVO();
		authenticationVO.setUserName("saksham.gupta");
		authenticationVO.setHostUsername("aayushi");
		authenticationVO.setHostPassword("jain");
		assertNotNull(userController.login(authenticationVO));
	}

}
