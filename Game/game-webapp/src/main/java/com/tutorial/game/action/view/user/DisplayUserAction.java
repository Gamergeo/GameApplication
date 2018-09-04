package com.tutorial.game.action.view.user;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.bean.dto.user.User;
import com.tutorial.game.exception.GameException;

@Namespace(value="/user")
@Controller
public class DisplayUserAction extends AbstractAction {
	
	private static final long serialVersionUID = 5257907639559001732L;
	
	private User user;
	
	@Action(value="displayUserView", results= {
			@Result(name=SUCCESS, location="/jsp/user/userView.jsp")})
	public String displayView() throws GameException {
		
		int id = user.getId();
		
		if (id <= 0) {
			throw new GameException("Incorrect id " + id);
			
		}
		
		user = serviceFactory.getUserService().getUserById(id);
		
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
