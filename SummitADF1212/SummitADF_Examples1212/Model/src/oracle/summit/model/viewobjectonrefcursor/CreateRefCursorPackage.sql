REM  For security reasons, the FOD user is not given create procedure privileges
REM  To run this script, issue the following statement as system: 
REM  grant create procedure to summit_adf;

REM  To back out this change, issue the following as summit_adf:
REM  drop package RefCursorExample;
REM  And run the following as system:
REM  revoke create procedure from summit_adf;

CREATE OR REPLACE PACKAGE RefCursorExample IS
  TYPE ref_cursor IS REF CURSOR;
  FUNCTION get_orders_for_customer(p_custId NUMBER) RETURN ref_cursor;
  FUNCTION count_orders_for_customer(p_custId NUMBER) RETURN NUMBER;
END RefCursorExample;
/

CREATE OR REPLACE PACKAGE BODY RefCursorExample IS
  FUNCTION get_orders_for_customer(p_custId NUMBER) RETURN ref_cursor IS
    the_cursor ref_cursor;
  BEGIN
    OPEN the_cursor FOR
      SELECT o.id, o.date_ordered, o.total
        FROM s_ord o, s_customer c
     WHERE o.customer_id = c.id
       AND c.id = p_custId;
    RETURN the_cursor;
  END get_orders_for_customer;
  
  FUNCTION count_orders_for_customer(p_custId NUMBER) RETURN NUMBER IS
    the_count NUMBER;
  BEGIN
    SELECT COUNT(*) 
      INTO the_count
      FROM s_ord o, s_customer c
     WHERE o.customer_id = c.id
       AND c.id = p_custId;
    RETURN the_count;
  END count_orders_for_customer;
END RefCursorExample;
/
