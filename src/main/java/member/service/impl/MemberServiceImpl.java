package member.service.impl;

import java.util.HashMap;
import java.util.Map; //데이터를 key-value형태로 관리하기 위한 Map

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import member.bean.MemberDTO;
import member.dao.MemberDAO;
import member.service.MemberService;

@Service //Spring 서비스 객체로 등록
@Transactional //트랜잭션 관리 활성화
public class MemberServiceImpl implements MemberService {
	@Autowired
    private MemberDAO memberDAO; //MemberDAO 자동주입
	@Autowired
    private HttpSession session; //HttpSession 객체 자동주입(세션관리)
   
	@Override
	public String login(String id, String pwd) {
		//id와 pwd를 Map으로 구성하여 전달
		Map<String,String>map = new HashMap<>();
        map.put("id", id);
        map.put("pwd", pwd);
        
        //DAO를 통해 로그인 정보 확인
        MemberDTO memberDTO = memberDAO.login(map);
        if(memberDTO==null)  //로그인 실패 시
            return "fail";
        else {
        	//로그인 성공 시 세션에 사용자 정보 저장
        	//HttpSession session = request.getSession();
        	session.setAttribute("memId", memberDTO.getId());
        	session.setAttribute("memName", memberDTO.getName());
        	session.setAttribute("memEmail", memberDTO.getEmail1() + "@" + memberDTO.getEmail2());
  
            return "success"; //성공메세지 리턴
        }
    }

}