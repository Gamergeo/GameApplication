package com.tutorial.game.service;

import com.tutorial.game.service.contract.game.IGameService;
import com.tutorial.game.service.impl.game.test.GameService;

import junit.framework.TestCase;

public abstract class TestService extends TestCase {

	protected IGameService gameService = new GameService();
	
	public TestService() {		
		super();

	}
	
	public TestService(String method) {
		super(method);
	}
	
}
