-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2022 at 09:34 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loginuser`
--

-- --------------------------------------------------------

--
-- Table structure for table `academic_level`
--

CREATE TABLE `academic_level` (
  `Academic_Name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `academic_level`
--

INSERT INTO `academic_level` (`Academic_Name`) VALUES
('ASSOCIATE OF SCIENCE'),
('ASSOCIATE OF TECHNOL'),
('BACHELOR OF BUSINESS'),
('BACHELOR OF ENGINEER'),
('BACHELOR OF INFORMAT'),
('MASTER OF INFORMATIO');

-- --------------------------------------------------------

--
-- Table structure for table `bonus`
--

CREATE TABLE `bonus` (
  `Bonus_ID` int(11) NOT NULL,
  `BonusLevel` varchar(30) NOT NULL,
  `Bonus` int(11) NOT NULL,
  `BonusDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bonus`
--

INSERT INTO `bonus` (`Bonus_ID`, `BonusLevel`, `Bonus`, `BonusDate`) VALUES
(1, 'LEVEL 1', 500000, '2021-10-18'),
(2, 'LEVEL 2', 1000000, '2021-10-18'),
(3, 'LEVEL 3 ', 1500000, '2021-10-18'),
(4, 'LEVEL 1 (HOLIDAY)', 2000000, '2021-09-02'),
(5, 'LEVEL 2 (HOLIDAY)', 2500000, '2021-09-02'),
(6, 'LEVEL 3 (HOLIDAY)', 3000000, '2021-09-02'),
(7, 'SUPER HOLIDAY', 5000000, '2021-12-31'),
(14, 'LEVEL 10', 500000, '2021-10-18'),
(15, 'LEVEL 20', 500000, '2021-10-18');

-- --------------------------------------------------------

--
-- Table structure for table `contract`
--

CREATE TABLE `contract` (
  `ContractName` varchar(50) NOT NULL,
  `BasicSalary` int(11) NOT NULL,
  `ContractTime` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contract`
--

INSERT INTO `contract` (`ContractName`, `BasicSalary`, `ContractTime`) VALUES
('INTERN', 5000000, '2021-11-18'),
('INTERN test', 5000000, '2021-11-18'),
('INTERNSHIP', 5000000, '2021-11-18'),
('LONG TERM CONTRACT', 25000000, '2022-01-12'),
('ONE-YEAR CONTRACT', 10000000, '2021-12-01'),
('SHORT TERM CONTRACT', 3000000, '2022-01-01'),
('TEMPORORAY CONTRACT', 4000000, '2021-12-01'),
('THREE-YEAR CONTRACT', 20000000, '2021-11-03'),
('TWO-YEAR CONTRACT', 15000000, '2021-12-01');

-- --------------------------------------------------------

--
-- Table structure for table `contracttype`
--

CREATE TABLE `contracttype` (
  `ContractType_ID` int(11) NOT NULL,
  `Contract_NAME` varchar(50) NOT NULL,
  `StartDateContract` date NOT NULL,
  `EndDateContract` date NOT NULL,
  `Employee_ID` int(10) NOT NULL,
  `QuitJobDate` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contracttype`
--

INSERT INTO `contracttype` (`ContractType_ID`, `Contract_NAME`, `StartDateContract`, `EndDateContract`, `Employee_ID`, `QuitJobDate`) VALUES
(14, 'INTERNSHIP', '2022-01-08', '2022-01-08', 7, ''),
(15, 'ONE-YEAR CONTRACT', '2022-01-08', '2022-01-08', 8, '2022-01-27');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_ID` int(11) NOT NULL,
  `CustomerName` varchar(50) NOT NULL,
  `CustomerAddress` varchar(80) NOT NULL,
  `CustomerPhone` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_ID`, `CustomerName`, `CustomerAddress`, `CustomerPhone`) VALUES
(1, 'Nguy???n V??n Huy', '78 Nguy???n Tr??i - Ba ?????n - Qu???ng B??nh', '0987654321'),
(2, 'Ho??ng ????nh Kh???', '24 H??ng V????ng - L??? Thu??? - Qu???ng B??nh', '0123456789'),
(3, '????? Th??? H???ng Ng???c', '45 Nguy???n V??n Tr???i - ?????ng H???i - Qu???ng B??nh', '0987123645'),
(4, 'Tr???n Nguy???n Thu??? Duy??n', '10 Tr?????ng Chinh - L??? Thu??? - Qu???ng B??nh', '019283745'),
(5, 'L?? Qu???nh Giang', '24 Nguy???n Hu??? - D?? An - B??nh D????ng ', '0912283745'),
(6, 'V?? Anh ?????c', '35 Ph???m Ng?? L??o - D?? An - B??nh D????ng ', '0987287344'),
(7, 'Ng?? M???u Tr?????ng', '354 H??? Th??? K??? - Qu???n 10 - TP.H??? Ch?? Minh', '0981981992');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `DepartmentName` varchar(40) NOT NULL,
  `DepartmentPhonenumber` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`DepartmentName`, `DepartmentPhonenumber`) VALUES
('FINANCE DEPARTMENT', '0192837945'),
('HUMAN RESOURCES DEPARTMENT', '0965652834'),
('MARKETING DEPARTMENT', '09168548211'),
('OPERATIONS DEPARTMENT', '0192837465'),
('PRODUCT DEPARTMENT', '01652778232'),
('PURCHASE DEPARTMENT', '0122332495'),
('RESEARCH DEPARTMENT', '01692778323'),
('SALES DEPARTMENT', '0987654333');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Employee_ID` int(11) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(40) NOT NULL,
  `BirthPlace` varchar(40) NOT NULL,
  `DayOfBirth` date NOT NULL,
  `Academic_NAME` varchar(40) NOT NULL,
  `Department_NAME` varchar(40) NOT NULL,
  `Role` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Employee_ID`, `Name`, `Gender`, `Address`, `BirthPlace`, `DayOfBirth`, `Academic_NAME`, `Department_NAME`, `Role`) VALUES
(1, 'Hu???nh Minh Nh???t', 'Women', '221 Tr???n Quang Kh???i - Qu???n 1 - TP.H??? Ch??', 'Vinh Long', '2001-12-02', 'ASSOCIATE OF TECHNOL', 'FINANCE DEPARTMENT', 'SALE PRESENTATIVE'),
(2, 'Mai Anh Ngh??a', 'Women', '06 Ng?? Quy???n - L??? Thu??? - Qu???ng B??nh', 'Qu???ng B??nh', '2001-12-25', 'BACHELOR OF BUSINESS', 'FINANCE DEPARTMENT', 'BUSINESS ANALYST'),
(3, 'Tr???n Thanh Thanh', 'Women', '35 H??ng V????ng - D?? An - B??nh D????ng', '???? N???ng', '2001-12-03', 'BACHELOR OF ENGINEER', 'SALES DEPARTMENT', 'EMPLOYEE'),
(4, 'L?? Nh???t Tr??nh', 'Women', '123 Nguy???n Tr??i - ?????ng H???i - Qu???ng B??nh', 'H?? N???i', '2001-12-25', 'ASSOCIATE OF TECHNOL', 'HUMAN RESOURCES DEPARTMENT', 'CEO'),
(5, 'V?? B??ch Ng???c', 'Women', '123 B??i Th??? Xu??n - N??i Th??nh - ???? N???ng', 'Qu???ng Nam', '2001-01-04', 'ASSOCIATE OF SCIENCE', 'FINANCE DEPARTMENT', 'EMPLOYEE'),
(6, 'Ho??ng Nh???t Quang', 'Women', '212 Nguy???n ????nh Thi - Qu???n 8 - TP.H??? Ch??', 'Long An', '2002-05-11', 'MASTER OF INFORMATIO', 'FINANCE DEPARTMENT', 'BUSINESS ANALYST'),
(7, 'D????ng Kh???i Nh???t', 'Men', '221/2B Tr???n Quang Kh???i', 'H??? Ch?? Minh', '2022-01-08', 'BACHELOR OF INFORMAT', 'HUMAN RESOURCES DEPARTMENT', ' VICE PRESIDENT'),
(8, 'B??i Thi???n Nh??n', 'Men', '5A1 Nguy???n ????nh Chi???u', 'Qui Nh??n', '2022-01-12', 'BACHELOR OF ENGINEER', 'PRODUCT DEPARTMENT', 'EMPLOYEE'),
(9, 'D????ng Ho??ng Long', 'Men', '5A1 Nguy???n ????nh Chi???u', 'HCm', '2022-01-12', 'ASSOCIATE OF SCIENCE', 'FINANCE DEPARTMENT', 'MANAGER'),
(10, 'gfhgf', 'Men', 'hfghgfh', 'fghfghgf', '2022-05-01', 'BACHELOR OF BUSINESS', 'HUMAN RESOURCES DEPARTMENT', 'ASSISTANT');

-- --------------------------------------------------------

--
-- Table structure for table `id_generate`
--

CREATE TABLE `id_generate` (
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `id_generate`
--

INSERT INTO `id_generate` (`ID`) VALUES
(11);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `Item_ID` int(11) NOT NULL,
  `ItemName` varchar(50) NOT NULL,
  `ItemUnit` varchar(50) NOT NULL,
  `ItemType` varchar(70) NOT NULL,
  `Supplier` varchar(70) NOT NULL,
  `Price` int(11) NOT NULL,
  `PriceDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`Item_ID`, `ItemName`, `ItemUnit`, `ItemType`, `Supplier`, `Price`, `PriceDate`) VALUES
(1, 'IPHONE 13 PRO MAX', 'BOX', 'MOBILE DEVICE', 'APPLE', 35000000, '2022-01-07'),
(2, 'BLUETOOTH SPEAKER', 'BOX', 'ELECTRONIC DEVICE', 'SAMSUNG', 1500000, '2021-07-16'),
(3, 'BRICK', 'BAR', 'ELECTRONIC DEVICE', 'SONY', 5000, '2021-10-06'),
(4, 'TABLE', 'SET', 'FURNITURE', 'KLAIRS', 300000, '2021-12-16'),
(5, 'CERAVE CLEANSER', 'BOTTLE', 'COSMETICS', 'KLAIRS', 350000, '2021-11-22'),
(6, 'TELEVISION', 'SET', 'ELECTRONIC DEVICE', 'FACEBOOK', 13500000, '2021-12-20');

-- --------------------------------------------------------

--
-- Table structure for table `itemtype`
--

CREATE TABLE `itemtype` (
  `ItemType` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `itemtype`
--

INSERT INTO `itemtype` (`ItemType`) VALUES
('CONSTRUCTION MATERIAL'),
('COSMETICS'),
('ELECTRONIC DEVICE'),
('FURNITURE'),
('MOBILE DEVICE');

-- --------------------------------------------------------

--
-- Table structure for table `levelofskill`
--

CREATE TABLE `levelofskill` (
  `StaffID` int(11) NOT NULL,
  `StaffName` varchar(60) NOT NULL,
  `StaffSkill` varchar(50) NOT NULL,
  `Comment` varchar(40) NOT NULL,
  `LastDateComment` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `levelofskill`
--

INSERT INTO `levelofskill` (`StaffID`, `StaffName`, `StaffSkill`, `Comment`, `LastDateComment`) VALUES
(7, 'D????ng Kh???i Nh???t', 'SELF-EFFICIENT SKILL', '', ''),
(7, 'D????ng Kh???i Nh???t', 'ADOBE SKILL', '', '2022-01-08'),
(7, 'D????ng Kh???i Nh???t', 'TEAMWORK SKILL', '', ''),
(8, 'B??i Thi???n Nh??n', 'ENGINEERING SKILL', '', ''),
(8, 'B??i Thi???n Nh??n', 'FOREIGN LANGUAGE (ENGLISH)', '', '2022-01-12'),
(9, 'D????ng Ho??ng Long', 'ADOBE SKILL', '', ''),
(9, 'D????ng Ho??ng Long', 'ENGINEERING SKILL', '', ''),
(9, 'D????ng Ho??ng Long', 'FIXING SKILL', '', ''),
(10, 'gfhgf', 'ADOBE SKILL', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `Order_ID` int(11) NOT NULL,
  `OrderDate` date NOT NULL,
  `Customer_ID` int(11) NOT NULL,
  `Item_ID` int(11) NOT NULL,
  `Number` int(11) NOT NULL,
  `Order_DH` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`Order_ID`, `OrderDate`, `Customer_ID`, `Item_ID`, `Number`, `Order_DH`) VALUES
(1, '2021-12-07', 1, 1, 1, 'OD1'),
(2, '2021-12-08', 1, 2, 2, 'OD1'),
(3, '2021-12-07', 3, 3, 1, 'OD2'),
(4, '2021-12-07', 2, 2, 5, 'OD3'),
(5, '2021-12-12', 1, 1, 1, 'OD4'),
(6, '2021-12-12', 1, 1, 2, 'OD5'),
(7, '2021-10-10', 1, 2, 2, 'OD1'),
(8, '2021-11-11', 1, 1, 10, 'OD1'),
(9, '2021-11-11', 1, 1, 2, 'OD2'),
(10, '2021-11-11', 1, 2, 4, 'OD2'),
(11, '2021-12-12', 1, 5, 2, 'OD2'),
(14, '2012-12-12', 1, 3, 1, 'OD3'),
(15, '2021-12-12', 1, 2, 3, 'OD4'),
(16, '2021-12-12', 1, 1, 1, 'OD5'),
(17, '2021-12-12', 1, 2, 2, 'OD6'),
(18, '2021-12-12', 1, 1, 1, 'OD6'),
(19, '2012-12-12', 1, 4, 7, 'OD6'),
(20, '2012-12-12', 1, 4, 2, ''),
(21, '2012-12-12', 1, 3, 2, 'DH7'),
(22, '2021-10-08', 2, 2, 4, 'OD8'),
(23, '2021-12-12', 2, 1, 1, 'OD8'),
(24, '2012-12-12', 1, 5, 2, 'OD9'),
(25, '2012-12-12', 1, 1, 1, 'OD9'),
(26, '2021-12-12', 1, 1, 1, 'OD10'),
(27, '2021-12-12', 1, 2, 2, 'OD18'),
(28, '2021-12-12', 1, 3, 1, 'OD10'),
(29, '2021-12-12', 1, 1, 1, 'OD11'),
(30, '2021-12-12', 1, 3, 2, 'OD11'),
(31, '2021-12-12', 1, 6, 20, 'OD12'),
(32, '2021-12-12', 1, 4, 5, 'OD13'),
(33, '2021-12-12', 1, 1, 10, 'OD13'),
(34, '2021-12-30', 1, 2, 2, 'OD14'),
(35, '2021-12-12', 1, 1, 1, 'OD14'),
(36, '2022-01-05', 1, 1, 1, 'OD15'),
(37, '2022-01-05', 1, 3, 1, 'OD16'),
(38, '2022-01-05', 1, 1, 1, 'OD17'),
(39, '2022-01-05', 1, 3, 2, 'OD17'),
(40, '2022-01-05', 1, 1, 1, 'OD18'),
(41, '2022-01-05', 1, 2, 2, 'OD18'),
(42, '2022-01-05', 1, 2, 1, 'OD19'),
(43, '2022-01-06', 1, 1, 4, 'OD20'),
(44, '2022-01-06', 1, 1, 1, 'OD21'),
(45, '2022-01-06', 1, 2, 2, 'OD21');

-- --------------------------------------------------------

--
-- Table structure for table `overtimepay`
--

CREATE TABLE `overtimepay` (
  `OvertimePay` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `overtimepay`
--

INSERT INTO `overtimepay` (`OvertimePay`) VALUES
(100000),
(200000),
(300000),
(400000),
(500000),
(600000),
(700000),
(800000),
(900000),
(1000000);

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `Receipt_ID` int(11) NOT NULL,
  `DateReceipt` date NOT NULL,
  `DatePrintReceipt` date NOT NULL,
  `Order_ID` int(11) NOT NULL,
  `Employee_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `receipt`
--

INSERT INTO `receipt` (`Receipt_ID`, `DateReceipt`, `DatePrintReceipt`, `Order_ID`, `Employee_ID`) VALUES
(1, '2021-12-07', '2021-12-07', 1, 1),
(2, '2021-12-07', '2021-12-07', 1, 1),
(3, '2021-12-01', '2021-12-01', 3, 6),
(4, '2021-12-01', '2021-12-01', 2, 2),
(5, '2021-12-12', '2021-12-12', 4, 4);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `RoleName` varchar(50) NOT NULL,
  `Allowance` int(11) NOT NULL,
  `AllowanceTime` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`RoleName`, `Allowance`, `AllowanceTime`) VALUES
(' VICE PRESIDENT', 20000000, '2021-12-01'),
('ACCOUNTANT', 10000000, '2021-12-04'),
('ASSISTANT', 6000000, '2022-01-01'),
('BUSINESS ANALYST', 10000000, '2021-11-01'),
('CEO', 20000000, '2021-12-02'),
('CUSTOMER SERVICE', 8000000, '2022-01-05'),
('EMPLOYEE', 5000000, '2021-12-01'),
('MANAGER', 10000000, '2021-12-01'),
('PRESIDENT', 25000000, '2021-12-01'),
('SALE PRESENTATIVE', 8000000, '2022-01-18');

-- --------------------------------------------------------

--
-- Table structure for table `salarymanagement`
--

CREATE TABLE `salarymanagement` (
  `Salary_ID` int(11) NOT NULL,
  `Employee_ID` int(11) NOT NULL,
  `BonusLevel` varchar(30) NOT NULL,
  `Overtime` int(11) NOT NULL,
  `OvertimePay` int(11) NOT NULL,
  `TotalOVT` int(11) NOT NULL,
  `TotalSalary` int(11) NOT NULL,
  `SalaryTime` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `salarymanagement`
--

INSERT INTO `salarymanagement` (`Salary_ID`, `Employee_ID`, `BonusLevel`, `Overtime`, `OvertimePay`, `TotalOVT`, `TotalSalary`, `SalaryTime`) VALUES
(12, 1, 'M???c 2', 3, 100000, 300000, 36300000, '2022-01-14'),
(13, 7, 'SUPER HOLIDAY', 5, 100000, 500000, 30500000, '2022-01-08');

-- --------------------------------------------------------

--
-- Table structure for table `skill`
--

CREATE TABLE `skill` (
  `SkillName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `skill`
--

INSERT INTO `skill` (`SkillName`) VALUES
('ADOBE SKILL'),
('ENGINEERING SKILL'),
('FIXING SKILL'),
('FOREIGN LANGUAGE (CHINESE)'),
('FOREIGN LANGUAGE (ENGLISH)'),
('FOREIGN LANGUAGE (JAPANESE)'),
('FOREIGN LANGUAGE (KOREAN)'),
('IT SKILL'),
('LEADERSHIP SKILL'),
('MANAGEMENT SKILL'),
('NEGOTIATION SKILL'),
('NETWORK SKILL'),
('PRESENTATION SKILL'),
('SELF-EFFICIENT SKILL'),
('TEAMWORK SKILL');

-- --------------------------------------------------------

--
-- Table structure for table `staffrolemanagement`
--

CREATE TABLE `staffrolemanagement` (
  `ID` int(11) NOT NULL,
  `STAFFNAME` varchar(50) NOT NULL,
  `ROLE` varchar(40) NOT NULL,
  `START` date NOT NULL,
  `END` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staffrolemanagement`
--

INSERT INTO `staffrolemanagement` (`ID`, `STAFFNAME`, `ROLE`, `START`, `END`) VALUES
(6, 'Ho??ng Nh???t Quang', 'BUSINESS ANALYST', '2022-01-08', '2022-01-08'),
(7, 'D????ng Kh???i Nh???t', 'ASSISTANT', '2022-01-08', '2022-01-08'),
(7, 'D????ng Kh???i Nh???t', ' VICE PRESIDENT', '2022-01-08', '2022-01-08'),
(5, 'V?? B??ch Ng???c', 'EMPLOYEE', '2022-01-11', '2022-01-11'),
(1, 'Hu???nh Minh Nh???t', 'SALE PRESENTATIVE', '2022-01-12', '2022-01-12'),
(2, 'Mai Anh Ngh??a', 'BUSINESS ANALYST', '2022-01-12', '2022-01-12'),
(3, 'Tr???n Thanh Thanh', 'EMPLOYEE', '2022-01-12', '2022-01-12'),
(4, 'L?? Nh???t Tr??nh', 'CEO', '2022-01-12', '2022-01-12'),
(8, 'B??i Thi???n Nh??n', 'EMPLOYEE', '2022-01-12', '2022-01-12'),
(9, 'D????ng Ho??ng Long', 'BUSINESS ANALYST', '2022-01-12', '2022-01-12'),
(9, 'D????ng Ho??ng Long', 'MANAGER', '2022-01-12', '2022-01-12'),
(10, 'gfhgf', 'ASSISTANT', '2022-05-01', '2022-05-01');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `Supplier` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Supplier`) VALUES
('ADIDAS'),
('APPLE'),
('BIODERMA'),
('CANON'),
('DISNEY'),
('FACEBOOK'),
('KLAIRS'),
('OBAGI'),
('OPPO'),
('SAMSUNG'),
('SONY'),
('THE ORDINARY');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `USERNAME` char(20) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `ADMIN` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `USERNAME`, `PASSWORD`, `ADMIN`) VALUES
(1, 'test', '1,2,3,4,5', 0),
(2, 'test2', '9975d233aa5392af125d392854a93df3', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `academic_level`
--
ALTER TABLE `academic_level`
  ADD PRIMARY KEY (`Academic_Name`);

--
-- Indexes for table `bonus`
--
ALTER TABLE `bonus`
  ADD PRIMARY KEY (`Bonus_ID`);

--
-- Indexes for table `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`ContractName`);

--
-- Indexes for table `contracttype`
--
ALTER TABLE `contracttype`
  ADD PRIMARY KEY (`ContractType_ID`),
  ADD KEY `fkConrtact_cttName` (`Contract_NAME`),
  ADD KEY `fkstaffid` (`Employee_ID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_ID`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`DepartmentName`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Employee_ID`) USING BTREE,
  ADD KEY `fkemployRole_role` (`Role`),
  ADD KEY `fkemployDepartment` (`Department_NAME`),
  ADD KEY `fkemployAcademic_academiclevel` (`Academic_NAME`);

--
-- Indexes for table `id_generate`
--
ALTER TABLE `id_generate`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`Item_ID`),
  ADD KEY `fksupplier` (`Supplier`),
  ADD KEY `fkitemtype` (`ItemType`);

--
-- Indexes for table `itemtype`
--
ALTER TABLE `itemtype`
  ADD PRIMARY KEY (`ItemType`);

--
-- Indexes for table `levelofskill`
--
ALTER TABLE `levelofskill`
  ADD KEY `fkemploySkill` (`StaffSkill`),
  ADD KEY `fkemployid_skillmng` (`StaffID`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`Order_ID`),
  ADD KEY `fkemployeeID` (`Customer_ID`),
  ADD KEY `fkitemID` (`Item_ID`);

--
-- Indexes for table `overtimepay`
--
ALTER TABLE `overtimepay`
  ADD PRIMARY KEY (`OvertimePay`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`Receipt_ID`),
  ADD KEY `receipt_ibfk_1` (`Order_ID`),
  ADD KEY `receipt_employeeidfk_2` (`Employee_ID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`RoleName`) USING BTREE;

--
-- Indexes for table `salarymanagement`
--
ALTER TABLE `salarymanagement`
  ADD PRIMARY KEY (`Salary_ID`),
  ADD KEY `salarymanagement_ibfk_1` (`Employee_ID`);

--
-- Indexes for table `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`SkillName`) USING BTREE;

--
-- Indexes for table `staffrolemanagement`
--
ALTER TABLE `staffrolemanagement`
  ADD KEY `fkemployrole` (`ROLE`),
  ADD KEY `fkemployid` (`ID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`Supplier`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bonus`
--
ALTER TABLE `bonus`
  MODIFY `Bonus_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `contracttype`
--
ALTER TABLE `contracttype`
  MODIFY `ContractType_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Customer_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `Item_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `Order_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `receipt`
--
ALTER TABLE `receipt`
  MODIFY `Receipt_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `salarymanagement`
--
ALTER TABLE `salarymanagement`
  MODIFY `Salary_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contracttype`
--
ALTER TABLE `contracttype`
  ADD CONSTRAINT `fkConrtact_cttName` FOREIGN KEY (`Contract_NAME`) REFERENCES `contract` (`ContractName`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fkstaffid` FOREIGN KEY (`Employee_ID`) REFERENCES `employee` (`Employee_ID`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fkemployAcademic_academiclevel` FOREIGN KEY (`Academic_NAME`) REFERENCES `academic_level` (`Academic_Name`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fkemployDepartment` FOREIGN KEY (`Department_NAME`) REFERENCES `department` (`DepartmentName`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fkemployRole_role` FOREIGN KEY (`Role`) REFERENCES `role` (`RoleName`) ON UPDATE CASCADE;

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `fkitemtype` FOREIGN KEY (`ItemType`) REFERENCES `itemtype` (`ItemType`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fksupplier` FOREIGN KEY (`Supplier`) REFERENCES `supplier` (`Supplier`) ON UPDATE CASCADE;

--
-- Constraints for table `levelofskill`
--
ALTER TABLE `levelofskill`
  ADD CONSTRAINT `fkemploySkill` FOREIGN KEY (`StaffSkill`) REFERENCES `skill` (`SkillName`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fkemployid_skillmng` FOREIGN KEY (`StaffID`) REFERENCES `employee` (`Employee_ID`) ON UPDATE CASCADE;

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fkemployeeID` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`Customer_ID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fkitemID` FOREIGN KEY (`Item_ID`) REFERENCES `item` (`Item_ID`) ON UPDATE CASCADE;

--
-- Constraints for table `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `receipt_employeeidfk_2` FOREIGN KEY (`Employee_ID`) REFERENCES `employee` (`Employee_ID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `receipt_ibfk_1` FOREIGN KEY (`Order_ID`) REFERENCES `order` (`Order_ID`) ON UPDATE CASCADE;

--
-- Constraints for table `salarymanagement`
--
ALTER TABLE `salarymanagement`
  ADD CONSTRAINT `salarymanagement_ibfk_1` FOREIGN KEY (`Employee_ID`) REFERENCES `employee` (`Employee_ID`) ON UPDATE CASCADE;

--
-- Constraints for table `staffrolemanagement`
--
ALTER TABLE `staffrolemanagement`
  ADD CONSTRAINT `fkemployid` FOREIGN KEY (`ID`) REFERENCES `employee` (`Employee_ID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fkemployrole` FOREIGN KEY (`ROLE`) REFERENCES `role` (`RoleName`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
