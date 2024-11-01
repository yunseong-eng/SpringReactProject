package board.bean;

import java.util.Date;

//JSON 데이터 포맷 설정
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BoardDTO {
    private int seq;          
    private String id;        
    private String name;      
    private String email;     
    private String subject;   
    private String content;  
    private int ref; //번호(그룹)         
    private int lev;  //답글 레벨        
    private int step;  //답글 단계        
    private int pseq;  //부모 글 번호      
    private int reply; //답글 수  
    private int hit;   //조회수   
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul") //Jackson에서 제공
    private Date logtime;     
}
