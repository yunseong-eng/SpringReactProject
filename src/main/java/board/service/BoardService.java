package board.service;

import java.util.List;

import board.bean.BoardDTO;

public interface BoardService {
	//글 작성
	public void boardWrite(String subject, String content);
	//글 목록 조회
	public List<BoardDTO> boardList();

}
