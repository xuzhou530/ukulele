package com.xiaojiaoshi.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("logout")
@Scope("prototype")
public class UserInvalidateAction extends ActionSupport
{
	private static String REDIRECT = "redirect";

	public String userLogout(){
		
		ActionContext.getContext().getSession().clear();
		ActionContext.getContext().put("url", "userLoginInput");
		return REDIRECT;
	}
	
}
