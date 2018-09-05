package com.tutorial.game.action.save.user;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.bean.dto.user.User;
import com.tutorial.game.exception.GameException;

@Namespace(value="/user")
@Controller
public class SaveUserAction extends AbstractAction {

	private static final long serialVersionUID = -6816837196571984771L;

	private User user;
	
	private String method;

	@Action(value="save", results = {
			@Result(name=SUCCESS, 
					location="/user/list", 
			        type = "redirect"),
			@Result(name="successAdd",
					location="/user/edit",  
					type = "redirect")
	})
	public String execute() throws GameException {
		serviceFactory.getUserService().addOrUpdateUser(user);
		
		if (method.equals("saveAndAdd")) {
			return "successAdd";
		}
		return SUCCESS;
	}
	
	@Action(value="delete", results = {
			@Result(name="success",
					location="/user/list", 
			        type = "redirect")
	})
	public String delete() throws GameException {
		serviceFactory.getUserService().delete(user.getId());
		
		return SUCCESS;
	}
	
	public String update() throws GameException {
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
