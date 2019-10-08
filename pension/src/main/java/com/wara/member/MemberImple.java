package com.wara.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberImple implements MemberDao{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberImple(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<Member> memRowMapper = 
			new RowMapper<Member>() {
				@Override
				public Member mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Member member = new Member(
							rs.getString("name"),
							rs.getString("id"),
							rs.getString("password"),
							rs.getString("email"),
							rs.getString("phone"));
					member.setMem_id(rs.getLong("mem_id"));
					return member;
				}
			};
			
	@Override
	public Member selectById(String id) {
		List<Member> results = jdbcTemplate.query(
				"select * from members where id = ?",
				memRowMapper,id);
		return results.isEmpty() ? null : results.get(0);
	}

}
