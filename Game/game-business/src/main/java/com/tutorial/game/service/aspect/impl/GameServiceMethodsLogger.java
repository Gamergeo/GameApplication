package com.tutorial.game.service.aspect.impl;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.tutorial.game.service.aspect.contract.IGameServiceMethodLogger;

@Component
public class GameServiceMethodsLogger implements IGameServiceMethodLogger {
	
	private static Logger LOG = Logger.getLogger(GameServiceMethodsLogger.class.getName());
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.aspect.IGameServiceMethodLogger#logMethod(org.aspectj.lang.JoinPoint)
	 */
	@Override
	public Object logMethod(final JoinPoint joinpoint) {
		LOG.info("Method called : " + joinpoint.getSignature());
		
		return joinpoint;
	}

}
