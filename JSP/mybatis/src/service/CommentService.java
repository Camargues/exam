package mybatis.guest.service;

import java.util.HashMap;
import java.util.List;

import mybatis.guest.model.Comment;
import mybatis.guest.session.CommentRepository;

public class CommentService {
	
	private static CommentService service;
	
	private CommentService() {}
	public static CommentService getInstance(){
		if( service == null) service = new CommentService();
		return service;
	}
	
	CommentRepository repo = new CommentRepository();
	
	public Integer insertComment(Comment c) {
		
		return repo.insertComment(c);
	}

	public List<Comment> selectComment(HashMap map){
		return repo.selectComment(map);
		
	}
	
	public Comment selectByPK(long commentNo) {
		return repo.selectByPK(commentNo);
	}
	
	public Integer deleteComment(long commentNo) {
		return repo.deleteComment(commentNo);
	}
	
	public Integer modifyComment(Comment c) {
		return repo.modifyComment(c);
	}
}