package com.wara.contoroller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wara.member.AuthInfo;
import com.wara.member.AuthService;
import com.wara.member.WrongIdPasswordException;

@Controller
@RequestMapping("/login")
public class LoginController {
	private AuthService authService;
	
	@Autowired
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@GetMapping
	public String form(LoginCommand loginCommand,
			@CookieValue(value = "REMEMBER", required = false) Cookie rCookie) {
		if (rCookie != null) {
			loginCommand.setId(rCookie.getValue());
			loginCommand.setRememberId(true);
		}
		
		return "login/loginform";
	}
	
    @PostMapping
    public String submit( LoginCommand loginCommand, Errors errors,
    		HttpSession session, HttpServletResponse response) {
    	new LoginCommandValidator().validate(loginCommand, errors);
    	if (errors.hasErrors()) {
    		return "login/loginform";
    	}
    	try {
    		AuthInfo authInfo = authService.authenticate
    				( loginCommand.getId(), loginCommand.getPassword());
    		session.setAttribute("authInfo", authInfo);
    		Cookie rememberCookie = new Cookie ("REMEMBER",loginCommand.getId());
    		rememberCookie.setPath("/");
    		if(loginCommand.isRememberId()) {
    			rememberCookie.setMaxAge(60*60*24*30);
    		} else {
    			rememberCookie.setMaxAge(0);
    		}
    		response.addCookie(rememberCookie);
    		return "main";
    	} catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "login/loginform";
        }
    	
    }
}
