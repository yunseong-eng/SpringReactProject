package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import board.bean.BoardDTO;
import board.service.BoardService;

@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")

//@Controller
@RestController //브라우저로 바로감 @ResponseBody를 안써도됨

@RequestMapping(value="board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//글 작성 처리
	//@RequestMapping(value="boardWrite", method=RequestMethod.POST)
	@PostMapping(value="boardWrite")
	//@ResponseBody
	public void boardWrite(@RequestParam String subject, @RequestParam String content) {
		//서비스에 제목과 내용을 전달하여 글 작성 처리
		boardService.boardWrite(subject, content);
	}
	
	//글 목록 조회 처리
	@GetMapping(value="boardList")
	//@ResponseBody
	public List<BoardDTO> boardList(){ //List<BoardDTO> 객체를 자동으로 JSON 배열로 변환하여 보낸다.
		List<BoardDTO> list = boardService.boardList(); //글 목록 가져오기
		System.out.println(list); //[ BoardDTO(~~~), BoardDTO(~~~), BoardDTO(~~~), ... ]
		return boardService.boardList(); //글 목록 반환	
	}

}
