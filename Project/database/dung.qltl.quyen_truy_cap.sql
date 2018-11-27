-- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 26, 2018 at 10:10 AM
-- Server version: 5.6.30
-- PHP Version: 5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ffse1702a`
--

-- --------------------------------------------------------

--
-- Table structure for table `quyen_truy_cap`
--

CREATE TABLE IF NOT EXISTS `quyen_truy_cap` (
  `ID` int(11) NOT NULL,
  `ma_truy_cap` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `quyen_truy_cap` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quyen_truy_cap`
--

INSERT INTO `quyen_truy_cap` (`ID`, `ma_truy_cap`, `quyen_truy_cap`) VALUES
(1, 'PDA', 'Phòng Dự Án'),
(2, 'PDT', 'Phòng Đào Tạo'),
(3, 'PGD', 'Phòng Giám Đốc'),
(4, 'PIT', 'Phòng Kỹ Thuật'),
(5, 'PKT', 'Phòng Kế Toán'),
(6, 'PNS', 'Phòng Nhân Sự'),
(7, 'all', 'ALL');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `quyen_truy_cap`
--
ALTER TABLE `quyen_truy_cap`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `quyen_truy_cap`
--
ALTER TABLE `quyen_truy_cap`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
