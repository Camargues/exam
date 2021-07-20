package com.javassem.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("reviewDAO")
public class ReviewDAOImpl {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public String getDate() {
		return mybatis.selectOne("review.getDate");
	}
}
