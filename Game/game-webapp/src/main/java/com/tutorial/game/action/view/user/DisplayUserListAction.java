package com.tutorial.game.action.view.user;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.bean.dto.user.User;
import com.tutorial.game.exception.GameException;

@Namespace(value="/user")
@Controller
public class DisplayUserListAction extends AbstractAction {

	private static final long serialVersionUID = -8898371186242307450L;
	
	private List<User> listUser;
	
	@Action(value="list", results = {
			@Result(name=SUCCESS, location="/jsp/user/userList.jsp")})
	public String execute() throws GameException {
		listUser = serviceFactory.getUserService().getAllUsers();
		
		return SUCCESS;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
}
