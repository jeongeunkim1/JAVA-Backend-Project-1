/**userinfo insert**/
/*INSERT INTO userinfo VALUES(USERINFO_USER_NO_SEQ.nextval,user_name,user_id,user_password,user_email);*/
/*ALTER TABLE userinfo MODIFY  user_no NUMBER(30);*/
INSERT INTO userinfo VALUES(USERINFO_USER_NO_SEQ.nextval,'테스트이름','테스트아이디','0000','테스트이메일');


/**product insert**/
/*INSERT INTO product VALUES (PRODUCT_PRODUCT_NO_SEQ.nextval,product_name,product_desc,product_price,product_seller,product_date,product_category,product_image);*/
/*ALTER TABLE product MODIFY PRODUCT_PRICE INT;*/
INSERT INTO product VALUES (PRODUCT_PRODUCT_NO_SEQ.nextval,'테스트상품','테스트상품내용',999999,'테스트상품판매자',sysdate,'남성아우터','3.png');


/**cart insert**/
/*INSERT INTO cart VALUES (CART_CART_NO_SEQ.nextval,user_no,product_no,cart_quantity);*/
/*SELECT c.cart_quantity, p.* FROM cart c JOIN product p on c.product_no=c.product_no where c.user_no=3;*/
INSERT INTO cart VALUES (CART_CART_NO_SEQ.nextval,10,130,10,null);
/*for (Cart cart : c) {
	System.out.println(cart.getProduct_no()+"####"+jumun.getJ_no()+"####"+cart.getCart_quantity());
}*/


/**jumun**/
/*INSERT INTO jumun VALUES (JUMUN_J_NO_SEQ.nextval,j_date,user_no);*/
/*ALTER TABLE jumun add j_price INT default 0;*/
/*ALTER TABLE jumun add j_desc VARCHAR2(1000);*/
insert into jumun VALUES(JUMUN_J_NO_SEQ.nextval,sysdate,10,90000,'테스트');


/**jumun_detail insert**/
/*INSERT INTO jumun_detail VALUES (JUMUN_DETAIL_JD_NO_SEQ.nextval,product_no,j_no,jd_quantity);*/
insert into jumun_detail VALUES(JUMUN_DETAIL_JD_NO_SEQ.nextval,10,JUMUN_J_NO_SEQ.currval,100,null);


insert into jumun VALUES(JUMUN_J_NO_SEQ.nextval,sysdate,10,90000,'테스트');
insert into jumun_detail VALUES(JUMUN_DETAIL_JD_NO_SEQ.nextval,10,JUMUN_J_NO_SEQ.currval,100);














