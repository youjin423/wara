package com.wara.member;

import org.springframework.stereotype.Component;

@Component
public interface MemberDao {

	Member selectById(String id);

}
