CREATE DATABASE IF NOT EXISTS `InsurancePolicies`;
USE `InsurancePolicies`;

CREATE TABLE IF NOT EXISTS `InsurancePolicy` (
  `policyNumber` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10) COLLATE armscii8_bin DEFAULT NULL,
  `firstName` varchar(80) COLLATE armscii8_bin DEFAULT NULL,
  `surname` varchar(80) COLLATE armscii8_bin DEFAULT NULL,
  `sumInsured` int(11) DEFAULT NULL,
  `price` decimal(20,6) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `policyType` varchar(10) COLLATE armscii8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE armscii8_bin DEFAULT NULL,
  `yearBuilt` int(11) DEFAULT NULL,
  `make` varchar(20) COLLATE armscii8_bin DEFAULT NULL,
  `model` varchar(20) COLLATE armscii8_bin DEFAULT NULL,
  `yearOfRegistration` int(11) DEFAULT NULL,
  PRIMARY KEY (`policyNumber`)
);
