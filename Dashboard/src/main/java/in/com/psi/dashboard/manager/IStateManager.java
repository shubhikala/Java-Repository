package in.com.psi.dashboard.manager;

import in.com.psi.dashboard.entity.Country;
import in.com.psi.dashboard.entity.State;
import in.com.psi.dashboard.entity.VO.StateVO;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface IStateManager.
 */
public interface IStateManager extends IBaseManager<State>{

	/**
	 * List by name.
	 *
	 * @param stateVO the state vo
	 * @param country the country
	 * @return the list
	 */
	List<State> listByName(StateVO stateVO, Country country);

}
