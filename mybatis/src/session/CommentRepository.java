package mybatis.guest.session;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.guest.model.Comment;

public class CommentRepository 
{
	//	private final String namespace = "CommentMapper";

	private SqlSessionFactory getSqlSessionFactory() {
		
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		SqlSessionFactory sessFactory =  new SqlSessionFactoryBuilder().build(inputStream);
		return sessFactory;
	}
	
	public Integer insertComment(Comment c) {
		// JDBC : Connection / mybatis : SqlSession
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			String statement = "CommentMapper.insertComment";
			// 맵퍼에 해당하는 이름을 호출
			int result = sqlSess.insert(statement, c);
			if(result>0) sqlSess.commit();
			else sqlSess.rollback();
			return result;
		}finally {
			sqlSess.close();
		}
		
	}
	
	public List<Comment> selectComment(HashMap map){
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			String statement = "CommentMapper.selectComment";
			return sqlSess.selectList(statement, map);
		}finally {
			sqlSess.close();
		}
	}
	
	public Comment selectByPK(long commentNo) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			HashMap map = new HashMap();
			map.put("commentNo", commentNo);
			String statement = "CommentMapper.selectComment";
			return sqlSess.selectOne(statement, map);
		}finally {
			sqlSess.close();
		}
	}
	
	public Integer deleteComment(long commentNo) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			String statement = "CommentMapper.deleteComment";
			// 맵퍼에 해당하는 이름을 호출
			int result = sqlSess.delete(statement, commentNo);
			if(result>0) sqlSess.commit();
			else sqlSess.rollback();
			return result;
		}finally {
			sqlSess.close();
		}
	}
	
	public Integer modifyComment(Comment c) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			String statement = "CommentMapper.modifyComment";
			// 맵퍼에 해당하는 이름을 호출
			int result = sqlSess.update(statement, c);
			if(result>0) sqlSess.commit();
			else sqlSess.rollback();
			return result;
		}finally {
			sqlSess.close();
		}
	}
	
	
}
