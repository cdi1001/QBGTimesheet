INSERT INTO `USER` (`USER_ID`, `CREATED_AT`, `EMAIL`, `ENABLE`, `EXPIRED`, `FIRST_NAME`, `LAST_NAME`, `ORGANIZATION`, `PASSWORD`, `ROLE`, `USERNAME`) VALUES ('1', '2015-01-01', 'manager@gmail.com', 'Y', 'N', 'MM', 'AA', 'CollegeBoard', 'manager', 'ROLE_MANAGER', 'manager');
INSERT INTO `USER` (`USER_ID`, `CREATED_AT`, `EMAIL`, `ENABLE`, `EXPIRED`, `FIRST_NAME`, `LAST_NAME`, `ORGANIZATION`, `PASSWORD`, `ROLE`, `USERNAME`) VALUES ('2', '2015-10-01', 'emp1@gmail.com', 'Y', 'N', 'Mike', 'Young', 'CollegeBoard', 'emp1', 'ROLE_EMPLOYEE', 'emp1');
INSERT INTO `USER` (`USER_ID`, `CREATED_AT`, `EMAIL`, `ENABLE`, `EXPIRED`, `FIRST_NAME`, `LAST_NAME`, `ORGANIZATION`, `PASSWORD`, `ROLE`, `USERNAME`) VALUES ('3', '2015-11-01', 'emp2@gmail.com', 'Y', 'N', 'Sonic', 'King', 'CollegeBoard', 'emp2', 'ROLE_EMPLOYEE', 'emp2');

INSERT INTO `MANAGER` (`MANAGER_ID`, `USER_ID`) VALUES ('1', '1');

INSERT INTO `EMPLOYEE` (`EMPLOYEE_ID`, `MANAGER_ID`, `USER_ID`) VALUES ('1', '1', '2');
INSERT INTO `EMPLOYEE` (`EMPLOYEE_ID`, `MANAGER_ID`, `USER_ID`) VALUES ('2', '1', '3');

INSERT INTO `PROJECT` (`PROJECT_ID`, `END_DATE`, `PROJECT_NAME`, `START_DATE`, `MANAGER_ID`) VALUES ('1', '2016-05-30', 'bsscores', '2015-05-01', '1');
INSERT INTO `PROJECT` (`PROJECT_ID`, `END_DATE`, `PROJECT_NAME`, `START_DATE`, `MANAGER_ID`) VALUES ('2', '2016-06-01', 'bsholds', '2015-03-01', '1');

INSERT INTO `EMPLOYEE_PROJECT` (`PROJECT_ID`, `EMPLOYEE_ID`) VALUES ('1', '1');
INSERT INTO `EMPLOYEE_PROJECT` (`PROJECT_ID`, `EMPLOYEE_ID`) VALUES ('1', '2');
INSERT INTO `EMPLOYEE_PROJECT` (`PROJECT_ID`, `EMPLOYEE_ID`) VALUES ('2', '1');

INSERT INTO `WEEK_SHEET` (`WEEK_SHEET_ID`, `APPROVED_IND`, `START_DATE`, `SUBMITTED_IND`, `TOTAL_HOUR`, `EMPLOYEE_ID`, `PROJECT_ID`) VALUES ('1', 'N', '2016-01-03', 'N', '40', '1', '1');

INSERT INTO `DAY_SHEET` (`DAY_SHEET_ID`, `DATE`, `HOUR`, `WEEK_SHEET_ID`) VALUES ('1', '2016-01-03', '0', '1');
INSERT INTO `DAY_SHEET` (`DAY_SHEET_ID`, `DATE`, `HOUR`, `WEEK_SHEET_ID`) VALUES ('2', '2016-01-04', '8', '1');
INSERT INTO `DAY_SHEET` (`DAY_SHEET_ID`, `DATE`, `HOUR`, `WEEK_SHEET_ID`) VALUES ('3', '2016-01-05', '8', '1');
INSERT INTO `DAY_SHEET` (`DAY_SHEET_ID`, `DATE`, `HOUR`, `WEEK_SHEET_ID`) VALUES ('4', '2016-01-06', '8', '1');
INSERT INTO `DAY_SHEET` (`DAY_SHEET_ID`, `DATE`, `HOUR`, `WEEK_SHEET_ID`) VALUES ('6', '2016-01-07', '8', '1');
INSERT INTO `DAY_SHEET` (`DAY_SHEET_ID`, `DATE`, `HOUR`, `WEEK_SHEET_ID`) VALUES ('5', '2016-01-08', '8', '1');
INSERT INTO `DAY_SHEET` (`DAY_SHEET_ID`, `DATE`, `HOUR`, `WEEK_SHEET_ID`) VALUES ('7', '2016-01-09', '0', '1');