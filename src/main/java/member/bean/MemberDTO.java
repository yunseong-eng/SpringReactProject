package member.bean;

import java.sql.Date; //SQL Date 클래스사용 (날짜관리)

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    private String name;
    private String id;
    private String pwd;
    private String gender;
    private String email1;
    private String email2;
    private String tel1;
    private String tel2;
    private String tel3;
    private String zipcode; //우편번호
    private String addr1;
    private String addr2;
    private Date logtime;
}
