package in.com.psi.dashboard.dao;

import in.com.psi.dashboard.entity.Country;
import in.com.psi.dashboard.entity.State;
import in.com.psi.dashboard.entity.VO.StateVO;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface IStateDao.
 */
public interface IStateDao extends IBaseDao<State>{

	/**
	 * List by name.
	 *
	 * @param stateVO the state vo
	 * @param country the country
	 * @return the list
	 */
	List<State> listByName(StateVO stateVO, Country country);

}
