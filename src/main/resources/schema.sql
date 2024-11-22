create table T_PRODUCT (
    ID int not null AUTO_INCREMENT,
    SKU_CODE varchar(100) not null,
    NAME varchar(200) not null,
    DESCRIPTION varchar(500) null,
    PRICE decimal not null,
    PRIMARY KEY (ID)
);