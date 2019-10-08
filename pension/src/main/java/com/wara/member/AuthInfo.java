package com.wara.member;

public class AuthInfo {
	private Long mem_id;
	private String id;
	private String name;
	
	public AuthInfo(Long mem_id, String id, String name) {
		this.mem_id = mem_id;
		this.id = id;
		this.name = name;
	}

	public Long getMem_id() {
		return mem_id;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
