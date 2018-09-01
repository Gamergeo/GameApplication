package com.tutorial.game.service;

import com.tutorial.game.service.game.GameService;

import junit.framework.TestCase;

public abstract class TestService extends TestCase {

	protected GameService gameService = new GameService();
	
	public TestService() {
		super();
	}
	
	public TestService(String method) {
		super(method);
	}
	
}
