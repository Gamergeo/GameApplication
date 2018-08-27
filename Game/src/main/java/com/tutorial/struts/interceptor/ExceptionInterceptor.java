package com.tutorial.struts.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tutorial.struts.action.AbstractAction;
import com.tutorial.struts.exception.GameException;

public class ExceptionInterceptor implements Interceptor {

	private static final long serialVersionUID = -2359432534149972463L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		String result;
		
		try {
			result = invocation.invoke();
		
		} catch (GameException exception) {

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
