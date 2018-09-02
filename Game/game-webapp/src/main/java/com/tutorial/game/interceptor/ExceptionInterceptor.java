package com.tutorial.game.interceptor;

import java.util.logging.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.exception.GameException;

//@InterceptorRef(value = "gameException")
public class ExceptionInterceptor implements Interceptor {
	
	private static Logger LOG = Logger.getLogger(ExceptionInterceptor.class.toString());

	private static final long serialVersionUID = -2359432534149972463L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		String result = null;
		
		try {
			result = invocation.invoke();
		
		} catch (GameException exception) {
			
			LOG.warning("GameException ! Is this normal ?");
			exception.printStackTrace();

			AbstractAction action = (AbstractAction) invocation.getAction();
			action.setErrorMessage(exception.getErrorMessage());
			return "error";
		}
		
		return result;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
}
