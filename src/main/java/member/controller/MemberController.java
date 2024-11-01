package member.controller;

import org.springframework.beans.factory.annotation.Autowired; //자동주입
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin; //CORS이슈 해결
import org.springframework.web.bind.annotation.GetMapping; //GET
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; //요청 파라미터 매핑
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import member.service.MemberService;

//CORS설정: React와 Spring 간의 통신을 위해 로컬호스트:3000에 대해 허용
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
@Controller //Spring MVC의 컨트롤러 선언
@RequestMapping(value="member") //'member' URL로 요청이 들어오면 이 컨트롤러에서 처리
public class MemberController {
	@Autowired
	private MemberService memberService; //MemberService 자동 주입
	
	//@RequestMapping(value="login", method = RequestMethod.GET)
	@GetMapping(value="login")
	@ResponseBody
	   public String login(@RequestParam String id, @RequestParam String pwd) {
	      //서비스에서 로그인 결과를 받아 리턴 
		  return memberService.login(id, pwd);
	  }
	
}

//자동주입 : 필요한 객체를 Spring에서 자동으로 만들어서 주입해주는 것
//CORS이슈 해결 : 로컬 주소가 다를때 둘이 연결해도 괜찮다는걸 알려주는 것
//요청 파라미터 매핑 : 클라이언트(사용자)에서 입력한 값을 서버가 받아서 변수에 저장하는 것입니다.
//트랜잭션 관리 활성화 : 데이터 작업을 할 때 모든 작업이 성공해야 저장하고, 하나라도 실패하면 모두 취소하는 것을 의미합니다.
//HttpSession 객체 자동 주입(세션 관리): 페이지를 이동해도 세션값을 저장하게끔 하는것