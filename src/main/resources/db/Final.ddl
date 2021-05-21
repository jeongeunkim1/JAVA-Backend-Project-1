DROP TABLE Jumun_detail CASCADE CONSTRAINTS;
DROP TABLE Comments CASCADE CONSTRAINTS;
DROP TABLE CompanyProduct CASCADE CONSTRAINTS;
DROP TABLE Card CASCADE CONSTRAINTS;
DROP TABLE Jumun CASCADE CONSTRAINTS;
DROP TABLE Cart CASCADE CONSTRAINTS;
DROP TABLE Product CASCADE CONSTRAINTS;
DROP TABLE Userinfo CASCADE CONSTRAINTS;
DROP TABLE Address CASCADE CONSTRAINTS;
/**********************************/
/* Table Name: Address */
/**********************************/

CREATE TABLE Address(
		address_no                    				NUMBER(10)			 NULL 		 PRIMARY KEY,
		address_Zcode                     			NUMBER(10)			 NOT NULL ,
		address_streetOrlot                 		VARCHAR2(100)		 NOT NULL,
		address_info                    			VARCHAR2(255)		 NOT NULL,
		user_no                       				NUMBER(10)			 NULL ,
		FOREIGN KEY (user_no) REFERENCES Userinfo (user_no) on delete cascade
);
DROP SEQUENCE Address_address_no_SEQ;

CREATE SEQUENCE Address_address_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

/**********************************/
/* Table Name: Userinfo */
/**********************************/
CREATE TABLE Userinfo(
		user_no                       		NUMBER(10)		 NULL 		 PRIMARY KEY,
		user_name                     		VARCHAR2(30)		 NOT NULL,
		user_id                       		VARCHAR2(50)		 NOT NULL,
		user_password                 		VARCHAR2(50)		 NOT NULL,
		user_email                    		VARCHAR2(255)		 NOT NULL
);

DROP SEQUENCE Userinfo_user_no_SEQ;

CREATE SEQUENCE Userinfo_user_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


/**********************************/
/* Table Name: Product */
/**********************************/
CREATE TABLE Product(
		product_no                    		NUMBER(10)		 NULL 		 PRIMARY KEY,
		product_name                  		VARCHAR2(1000)		 NOT NULL,
		product_desc                  		VARCHAR2(1000)		 NOT NULL,
		product_price                 		NUMBER(30)		 	 NOT NULL,
		product_seller                		VARCHAR2(30)		 NOT NULL,
		product_date                  		DATE		 default sysdate NOT NULL,
		product_category					VARCHAR2(100) 	 NOT NULL,
        product_image                       VARCHAR2(255)    NOT NULL
);

DROP SEQUENCE Product_product_no_SEQ;

CREATE SEQUENCE Product_product_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


/**********************************/
/* Table Name: Cart */
/**********************************/
CREATE TABLE Cart(
		Cart_no                       		NUMBER(10)		 NULL 		 PRIMARY KEY,
		user_no                       		NUMBER(10)		 NULL ,
		product_no                    		NUMBER(10)		 NULL ,
  FOREIGN KEY (user_no) REFERENCES Userinfo (user_no) on delete cascade,
  FOREIGN KEY (product_no) REFERENCES Product (product_no)
);

DROP SEQUENCE Cart_Cart_no_SEQ;

CREATE SEQUENCE Cart_Cart_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



/**********************************/
/* Table Name: Jumun */
/**********************************/
CREATE TABLE Jumun(
		j_no                          		NUMBER(10)		 NULL 		 PRIMARY KEY,
		J_date                        		DATE		 default sysdate NOT NULL,
		user_no                       		NUMBER(10)		 NULL ,
  FOREIGN KEY (user_no) REFERENCES Userinfo (user_no) on delete cascade
);

DROP SEQUENCE Jumun_j_no_SEQ;

CREATE SEQUENCE Jumun_j_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


/**********************************/
/* Table Name: Card */
/**********************************/
CREATE TABLE Card(
		card_no                       		VARCHAR2(50)		 NULL 		 PRIMARY KEY,
		card_cvc                      		NUMBER(10)		 NOT NULL,
		card_deadline                 		VARCHAR2(50)		 NOT NULL,
		card_password                 		NUMBER(10)		 NOT NULL,
		card_password2                		VARCHAR2(50)		 NOT NULL,
		user_no                       		NUMBER(10)		 NULL ,
  FOREIGN KEY (user_no) REFERENCES Userinfo (user_no) on delete cascade
);

/**********************************/
/* Table Name: CompanyProduct */
/**********************************/
CREATE TABLE CompanyProduct(
		companyProduct_no                		NUMBER(10)		 NULL 		 PRIMARY KEY,
		companyProduct_name              		VARCHAR2(100)		 NOT NULL,
		companyProduct_desc              		VARCHAR2(1000)		 NOT NULL,
		companyProduct_price             		VARCHAR2(100)		 NOT NULL,
		companyProduct_content           		VARCHAR2(4000)		 NOT NULL,
		companyProduct_date              		DATE		 default sysdate NOT NULL,
		user_no                       		NUMBER(10)		 NULL ,
  FOREIGN KEY (user_no) REFERENCES Userinfo (user_no) on delete cascade
);

/**********************************/
/* Table Name: Comments */
/**********************************/
CREATE TABLE Comments(
		comments_no                   		NUMBER(10)		 NULL 		 PRIMARY KEY,
		comments_date                 		DATE		 default sysdate NOT NULL,
		comments_content              		VARCHAR2(2000)		 NOT NULL,
		comments_star                 		NUMBER(10)		 NOT NULL,
		comments_group_no             		NUMBER(10)		 NOT NULL,
		comments_step                 		NUMBER(10)		 NOT NULL,
		comments_depth                		NUMBER(10)		 NOT NULL,
		userproduct_no                		NUMBER(10)		 NULL ,
		product_no                    		NUMBER(10)		 NULL ,
		board_no                      		NUMBER(10)		 NULL ,
		user_no							    NUMBER(10)		 NULL
  FOREIGN KEY (product_no) REFERENCES Product (product_no),
  FOREIGN KEY (board_no) REFERENCES Board (board_no) on delete cascade,
  FOREIGN KEY (userproduct_no) REFERENCES UserProduct (userproduct_no) on delete cascade,
  FOREIGN KEY (user_no) REFERENCES UserInfo (user_no) on delete cascade
);

DROP SEQUENCE Comments_comments_no_SEQ;

CREATE SEQUENCE Comments_comments_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


/**********************************/
/* Table Name: Jumun_detail */
/**********************************/
CREATE TABLE Jumun_detail(
		jd_no                         		NUMBER(10)		 NULL 		 PRIMARY KEY,
		product_no                    		NUMBER(10)		 NULL ,
		j_no                          		NUMBER(10)		 NULL ,
  FOREIGN KEY (product_no) REFERENCES Product (product_no),
  FOREIGN KEY (j_no) REFERENCES Jumun (j_no) on delete cascade
);

DROP SEQUENCE Jumun_detail_jd_no_SEQ;

CREATE SEQUENCE Jumun_detail_jd_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


