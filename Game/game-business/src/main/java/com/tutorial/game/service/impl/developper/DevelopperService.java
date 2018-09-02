package com.tutorial.game.service.impl.developper;

import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tutorial.game.bean.dto.developper.Developper;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.contract.developper.IDevelopperService;
import com.tutorial.game.service.impl.AbstractService;

@Service
public class DevelopperService extends AbstractService implements IDevelopperService {
	
	final private static Logger LOG = Logger.getLogger(DevelopperService.class.getName());

	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IDevelopperService#addNewDevelopper(com.tutorial.game.bean.dto.developper.impl.Developper)
	 */
	@Override
	public void addNewDevelopper(Developper developper) throws GameException {
		
		// Country is null or name is not setted
		if (developper == null || StringUtils.isEmpty(developper.getName())) {
			LOG.severe("Developper cannot be inserted : he is not correctky set");
			
			throw new GameException("Developper cannot be inserted : he is not correctky set");
		}
		
		// On insert en base
		daoFactory.getDevelopperDAO().insertDevelopper(developper);
		
		// On met à jour l'id
		developper.setId(getDevelopperByName(developper.getName()).getId());
		
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IDevelopperService#getDevelopperByName(java.lang.String)
	 */
	@Override
	public Developper getDevelopperByName(String name) throws GameException {
		Developper developper = daoFactory.getDevelopperDAO().getDevelopperByName(name);
		
		// Le developper a un pays associé, on va le chercher aussi
		if (developper != null && developper.getCountry() != null && developper.getCountry().getId() != 0) {
			developper.setCountry(serviceFactory.getCountryService().getCountryById(developper.getCountry().getId()));
		}
		
		return developper;
	}
	
}
