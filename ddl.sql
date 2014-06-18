DROP DATABASE whouse; 
CREATE DATABASE whouse CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE whouse;

DROP TABLE IF EXISTS commodity;
DROP TABLE IF EXISTS storage;

CREATE TABLE commodity (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  description varchar(255) DEFAULT NULL,
  measurementUnit varchar(5) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id),
  UNIQUE KEY name (name)
);

CREATE TABLE storage (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  commodity_id bigint(20) DEFAULT NULL,
  available_quantity int(11) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id),
  UNIQUE KEY commodity_id (commodity_id),
  CONSTRAINT FOREIGN KEY (commodity_id) REFERENCES commodity (id)
);

CREATE TABLE roles (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  role_name varchar(45) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id)
);

CREATE TABLE users (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  login varchar(45)  DEFAULT NULL,
  password varchar(45)  DEFAULT NULL,
  fullname varchar(45) DEFAULT NULL,
  role_id bigint(20) NOT NULL ,
  PRIMARY KEY (id),
  UNIQUE KEY id (id), 
  CONSTRAINT FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE flows (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  commodity_id bigint(20) NOT NULL,
  user_id bigint(20) NOT NULL,
  balance DECIMAL(6,2) NOT NULL,
  comments varchar(180),
  flow_date TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id), 
  CONSTRAINT FOREIGN KEY (commodity_id) REFERENCES commodity (id),
  CONSTRAINT FOREIGN KEY (user_id) REFERENCES users (id)
);
