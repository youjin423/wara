package com.wara.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public AuthInfo authenticate (String id, String password) {
		Member member = memberDao.selectById(id);
		if(member == null) {
			throw new WrongIdPasswordException();
		}
		
		if (!member.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}
		
		return new AuthInfo(member.getMem_id(), member.getId(), member.getName());
	}
}
