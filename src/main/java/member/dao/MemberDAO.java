package member.dao;

import java.util.Map; //여러값을 담기위한 Map

import org.apache.ibatis.annotations.Mapper; //MyBatis와의 연동을 위한 Mapper어노테이션
import org.apache.ibatis.annotations.Param;
import member.bean.MemberDTO;

@Mapper //MemberDAO인터페이스를 MyBatis Mapper로 등록
public interface MemberDAO {
	//회원정보를 Map형태로 전달받아 로그인 처리
	MemberDTO login(Map<String, String> map);
}
