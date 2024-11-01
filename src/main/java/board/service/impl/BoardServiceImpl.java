package board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import board.service.BoardService;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO; //BoardDAO 자동 주입
	@Autowired
    private HttpSession session;
	
	//글 작성
	@Override
	public void boardWrite(String subject, String content) {
		//세션에서 가져오기
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");
		String email = (String) session.getAttribute("memEmail");
		
		//작성 정보를 Map에 저장하여 전달
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		
		boardDAO.boardWrite(map); //DAO를 통해 글 작성
		boardDAO.refUpdate(); //그룹번호
	}
	
	//글 목록 조회
	@Override
	public List<BoardDTO> boardList() {
		return boardDAO.boardList(); //DAO를 통해 글 목록 조회
	}

}
