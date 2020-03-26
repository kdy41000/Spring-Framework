DROP SEQUENCE MYNOSEQ;
DROP TABLE MYBOARD;

CREATE SEQUENCE MYNOSEQ;
CREATE TABLE MYBOARD(
	MYNO NUMBER PRIMARY KEY,
	MYID VARCHAR2(1000) NOT NULL,
	MYTITLE VARCHAR2(2000) NOT NULL,
	MYCONTENT VARCHAR2(4000) NOT NULL,
	MYDATE DATE NOT NULL,
	MYCNT NUMBER NOT NULL,
   CONSTRAINT FK_COLUMN FOREIGN KEY(MYID)
   REFERENCES MYMEMBER(MEMBERID) ON DELETE CASCADE
);

INSERT INTO MYBOARD
VALUES(MYNOSEQ.NEXTVAL, 'admin','제목테스트','내용테스트',SYSDATE,0);

SELECT MYNO, MYID, MYTITLE, MYCONTENT, MYDATE, MYCNT
FROM MYBOARD;
