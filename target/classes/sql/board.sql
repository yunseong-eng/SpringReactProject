-- [테이블] MySQL
CREATE TABLE board(
     seq INTEGER primary key auto_increment, -- 글번호 (시퀀스 객체 이용)
     id VARCHAR(20) NOT NULL,          		-- 아이디
     name VARCHAR(40) NOT NULL,        		-- 이름
     email VARCHAR(40),                		-- 이메일
     subject VARCHAR(255) NOT NULL,    		-- 제목
     content VARCHAR(4000) NOT NULL,   		-- 내용 
     ref INTEGER,               			-- 그룹번호
     lev INTEGER DEFAULT 0 NOT NULL,     	-- 단계
     step INTEGER DEFAULT 0 NOT NULL,    	-- 글순서
     pseq INTEGER DEFAULT 0 NOT NULL,    	-- 원글번호
     reply INTEGER DEFAULT 0 NOT NULL,   	-- 답변수
     hit INTEGER DEFAULT 0,              	-- 조회수
     logtime DATETIME DEFAULT now()         -- 날짜와 시간, current_timestap로 해도됨
 );
