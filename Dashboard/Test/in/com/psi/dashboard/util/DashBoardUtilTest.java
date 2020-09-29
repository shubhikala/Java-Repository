package in.com.psi.dashboard.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class DashBoardUtilTest {
	
	public String sessionId = null;
	
	@Test
	public void testgetCurrentTime() {
		assertNotNull(DashboardUtil.getCurrentTime());
	}
	
	@Test
	public void testgetUuid() {
		assertNotNull(DashboardUtil.getUuid());
	}
	
	/*@Test
	public void testcheckSession() {
		assertTrue(DashboardUtil.checkSession(""));
	}*/

}
