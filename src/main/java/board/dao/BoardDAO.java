package board.dao;

import java.util.List; //목록 처리를 위한 List 클래스
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import board.bean.BoardDTO;

@Mapper
public interface BoardDAO {
	//글 작성 (Map데이터 사용)
	public void boardWrite(Map<String, String> map);
	//그룹 번호 업데이트
	public void refUpdate();
	//글 목록 조회
	public List<BoardDTO> boardList();

}
