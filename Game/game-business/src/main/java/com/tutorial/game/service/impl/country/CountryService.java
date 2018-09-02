package com.tutorial.game.service.impl.country;

import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.contract.country.ICountryService;
import com.tutorial.game.service.impl.AbstractService;

@Service
@Transactional
public class CountryService extends AbstractService implements ICountryService {

	final private static Logger LOG = Logger.getLogger(CountryService.class.getName());
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.ICountryService#addNewCountry(com.tutorial.game.bean.dto.country.ICountry)
	 */
	@Override
	@Transactional
	public void addNewCountry(Country country) throws GameException {
		
		// Country is null or name is not setted
		if (country == null || StringUtils.isEmpty(country.getName())) {
			LOG.severe("Country cannot be inserted : he is not correctky set");
			throw new GameException("Country cannot be inserted : he is not correctky set");
		}
		
		// On insert en base
		daoFactory.getCountryDAO().insertCountry(country);
		
		country.setId(getCountryByName(country.getName()).getId());
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.impl.country.ICountryService#getCountryByName(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public Country getCountryById(int id) throws GameException {
		return daoFactory.getCountryDAO().getCountryById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.impl.country.ICountryService#getCountryByName(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public Country getCountryByName(String name) throws GameException {
		return daoFactory.getCountryDAO().getCountryByName(name);
	}

}
