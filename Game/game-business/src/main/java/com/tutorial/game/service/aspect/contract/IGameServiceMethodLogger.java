package com.tutorial.game.service.aspect.contract;

import org.aspectj.lang.JoinPoint;

public interface IGameServiceMethodLogger {

	Object logMethod(JoinPoint joinpoint);

}