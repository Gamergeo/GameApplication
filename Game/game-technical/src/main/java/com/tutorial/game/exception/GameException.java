package com.tutorial.game.exception;

public class GameException extends Exception {

	private static final long serialVersionUID = 1551735279390520223L;
	
	private String errorMessage;
	
	/**
	 * Manage the exception in the application game
	 */
	public GameException(Exception exception, String message) {
		exception.printStackTrace();
		
		errorMessage = message;
	}
	
	public GameException(String message) {
		errorMessage = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
