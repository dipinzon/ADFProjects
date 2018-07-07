REM  For security reasons, the summit_adf user is not given create procedure privileges
REM  To run this script, issue the following statement as system: 
REM  grant create procedure to summit_adf;

REM  To back out this change, issue the following as summit_adf:
REM  drop package invokestoredprocpkg;
REM  And run the following as system:
REM  revoke create procedure from summit_adf;

create or replace package invokestoredprocpkg as
  procedure proc_with_no_args;
  procedure proc_with_three_args(n number, d date, v varchar2);
  function  func_with_three_args(n number, d date, v varchar2)
                                 return varchar2;
  procedure proc_with_out_args(n number, d out date, v in out varchar2);
end invokestoredprocpkg;
.
/
create or replace package body invokestoredprocpkg as
  procedure proc_with_no_args is
  begin
    null;
  end proc_with_no_args;
  procedure proc_with_three_args(n number,d date, v varchar2) is
  begin
    null;
  end proc_with_three_args;
  function  func_with_three_args(n number,d date, v varchar2)
  return VARCHAR2 is 
  begin
    return to_char(n)||','||to_char(d)||','||v;
  end func_with_three_args;
  procedure proc_with_out_args(n number, d out date, v in out varchar2) is
  begin
    d := sysdate;
    v := '('||v||')';
  end proc_with_out_args;
end invokestoredprocpkg;
.
/
