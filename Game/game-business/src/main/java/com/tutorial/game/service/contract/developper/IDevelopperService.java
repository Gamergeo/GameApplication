package com.tutorial.game.service.contract.developper;

import com.tutorial.game.bean.dto.developper.Developper;
import com.tutorial.game.exception.GameException;

public interface IDevelopperService {

	/**
	 *  Ajoute un nouveau developpeur dans la base
	 *  Renvoie une erreur si le pays n'est pas bien défini 
	 */
	void addNewDevelopper(Developper developper) throws GameException;

	/**
	 * Renvoie le developper associé au nom donné
	 */
	Developper getDevelopperByName(String name) throws GameException;

}
