
/*
 Blog backend Test schema
 --------------------------
 schema.sql
 ----------------------------------------------------------------------------
 MariaDB/MySQL Tables and Data Objectsc for Jdbc default 
 Requires MariaDB version 10.2.1 or MySQL version 8.0.13 and aftrward. 
 (C)opyright Panos Zafeiropoulos - 2024


 ----------------------------------------------------------------------------
 Last update: 241123 - PZ
 -----------------------------------------------------------------------------
*/


USE `testblog2`;
@
--DELIMITER @

-- ------------------------------------
-- Table structure for testcategories
-- ------------------------------------
BEGIN;
@
DROP TABLE IF EXISTS `categories`;
@
CREATE TABLE `testcategories` (
  `categoryId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `categoryTitle` varchar(100) NOT NULL,
  `categoryStatusId` int(3) unsigned NOT NULL DEFAULT 1,
  `categoryUUID` varchar(36) NOT NULL DEFAULT (UUID()),              
  PRIMARY KEY (`categoryId`)
);
@
COMMIT;
@



-- ----------------------------------
-- Table structure for testarticles
-- ----------------------------------
BEGIN;
@
DROP TABLE IF EXISTS `articles`;
@
CREATE TABLE `articles` (
  `articleId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `categoryId` int(10) unsigned NOT NULL,
  `userId` int(10) unsigned NOT NULL,
  `articleTitle` varchar(100) NOT NULL,
  `articleSubTitle` varchar(200) NOT NULL,
  `articleSlug` varchar(300) UNIQUE,
  `articleDescription` varchar(250),
  `articleContent` MEDIUMTEXT,
  `articleStatusId` int(3) unsigned NOT NULL DEFAULT 1,
  `articleUUID` varchar(36) NOT NULL DEFAULT (UUID()),              
  `articleCreationTimestamp` TIMESTAMP(6) DEFAULT (CURRENT_TIMESTAMP(6)), 
  `articleLastUpdTimestamp` TIMESTAMP(6) DEFAULT (CURRENT_TIMESTAMP(6)), 
  PRIMARY KEY (`articleId`)
); 
@
COMMIT;
@

-- ----------------------------
-- Table structure for Userss
-- ----------------------------
BEGIN;
DROP TABLE IF EXISTS `users`;
--@
CREATE TABLE `users` (
  `userId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userSlugName` varchar(15) NOT NULL UNIQUE,
  `userName` varchar(40) NOT NULL,
  `userSurname` varchar(120),
  `userPassword` varchar(80) NOT NULL,
  `userEmail` varchar(40) NOT NULL UNIQUE,
  `userIsAuthor` tinyint(1) DEFAULT 1, 
  `userIsEnabled` tinyint(1) DEFAULT 1,
  `userStatusId` int(3) unsigned NOT NULL DEFAULT 1,
  `userUUID` varchar(36) NOT NULL DEFAULT (UUID()),              
  `userCreationTimestamp` TIMESTAMP(6) DEFAULT (CURRENT_TIMESTAMP(6)), 
  `userClientUUID` varchar(40),
  PRIMARY KEY (`userId`)
);
COMMIT;
@


-- ------------------------------------
-- Table structure for content_types 
-- 250612
-- ------------------------------------
BEGIN;
@
DROP TABLE IF EXISTS `content_types`;
@
CREATE TABLE `content_types` (
  `cont_type_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cont_type_identifier` varchar(10) NOT NULL,
  PRIMARY KEY (`cont_type_id`)
);
@
COMMIT;
@



-- ----------------------------------------
-- Trigger for auto-hashingn of password
-- ----------------------------------------

DROP TRIGGER IF EXISTS `INS_USER_PASSW`;
@
CREATE TRIGGER `INS_USER_PASSW`
BEFORE INSERT ON `users`
FOR EACH ROW
BEGIN
    DECLARE salt VARCHAR(16);
    -- Check if the password is 80 characters and hexadecimal
    IF CHAR_LENGTH(NEW.`userPassword`) = 80 AND 
       NEW.`userPassword` REGEXP '^[0-9a-fA-F]+$' THEN
        -- Leave the password unchanged
        SET NEW.`userPassword` = NEW.`userPassword`;
    ELSE
        -- Generate salt and hash the password
        SET salt = SUBSTRING(SHA2(RAND(), 256), 1, 16);
        SET NEW.`userPassword` = CONCAT(salt, SHA2(CONCAT(salt, NEW.`userPassword`), 256));
    END IF;
END
;
 @ 
COMMIT;
@



