package com.tutorial.game.service.contract.country;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.impl.AbstractService;
import com.tutorial.game.service.impl.country.ICountryService;

@Service
public class CountryService extends AbstractService implements ICountryService {
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.ICountryService#addNewCountry(com.tutorial.game.bean.dto.country.ICountry)
	 */
	@Override
	public void addNewCountry(Country country) throws GameException {
		
		// Country is null or name is not setted
		if (country == null || StringUtils.isEmpty(country.getName())) {
			throw new GameException("Country cannot be inserted : he is not correctky set");
		}
		
		country.setId(getCountryByName(country.getName()).getId());
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.impl.country.ICountryService#getCountryByName(java.lang.String)
	 */
	@Override
	public Country getCountryById(Integer id) throws GameException {
		return daoFactory.getCountryDAO().getCountryById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.impl.country.ICountryService#getCountryByName(java.lang.String)
	 */
	@Override
	public Country getCountryByName(String name) throws GameException {
		return daoFactory.getCountryDAO().getCountryByName(name);
	}

}
