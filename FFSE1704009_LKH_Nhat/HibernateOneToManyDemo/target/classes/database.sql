CREATE SCHEMA `hibernate-demo` ;

CREATE TABLE `hibernate-demo`.`company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

  
CREATE TABLE `hibernate-demo`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_id` INT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `emp-company`
    FOREIGN KEY (`company_id`)
    REFERENCES `hibernate-demo`.`company` (`id`));