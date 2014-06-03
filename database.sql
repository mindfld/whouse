DROP DATABASE whouse; 
CREATE DATABASE whouse  DEFAULT CHARACTER SET koi8u  DEFAULT COLLATE koi8u_general_ci;
USE whouse;

DROP TABLE IF EXISTS commodity;
DROP TABLE IF EXISTS storage;

CREATE TABLE commodity (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) COLLATE koi8u_general_ci  NOT NULL,
  description varchar(255) COLLATE koi8u_general_ci  DEFAULT NULL,
  measurementUnit varchar(5) COLLATE koi8u_general_ci  DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id)
);

CREATE TABLE storage (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  commodity_id bigint(20) DEFAULT NULL,
  available_quantity int(11) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id),
  CONSTRAINT FOREIGN KEY (commodity_id) REFERENCES commodity (id)
);

CREATE TABLE roles (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  role_name bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id)
);

CREATE TABLE users (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  login varchar(45) COLLATE koi8u_general_ci  DEFAULT NULL,
  password varchar(45) COLLATE koi8u_general_ci  DEFAULT NULL,
  fullname varchar(45) COLLATE koi8u_general_ci  DEFAULT NULL,
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
  comments varchar(180) COLLATE koi8u_general_ci ,  
  flow_date TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id (id), 
  CONSTRAINT FOREIGN KEY (commodity_id) REFERENCES commodity (id),
  CONSTRAINT FOREIGN KEY (user_id) REFERENCES users (id)
);
