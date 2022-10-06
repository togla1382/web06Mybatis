--------------------------------------------------------
--  파일이 생성됨 - 목요일-10월-06-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger TRIG_MEM2
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "NOWON"."TRIG_MEM2" 
before INSERT OR UPDATE OF PASS ON MEMBER2 
FOR EACH ROW-- 행 트리거
BEGIN
  IF inserting THEN    
    :new.updated_date := :new.created_date;
    dbms_output.put_line('회원가입시 처리');
  ELSIF updating THEN
    :new.updated_date :=systimestamp;
    dbms_output.put_line('비밀번호 변경시 처리');
  END If;
  
END;
/
ALTER TRIGGER "NOWON"."TRIG_MEM2" ENABLE;
