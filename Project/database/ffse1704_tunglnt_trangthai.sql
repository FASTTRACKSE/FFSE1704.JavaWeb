-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 04, 2018 at 11:09 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ffse1704`
--

-- --------------------------------------------------------

--
-- Table structure for table `ffse1704_tunglnt_trangthai`
--

CREATE TABLE `ffse1704_tunglnt_trangthai` (
  `matrangthai` int(11) NOT NULL,
  `tentrangthai` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ffse1704_tunglnt_trangthai`
--

INSERT INTO `ffse1704_tunglnt_trangthai` (`matrangthai`, `tentrangthai`) VALUES
(1, 'mới'),
(2, 'Đang Làm'),
(3, 'Đã Xong'),
(4, 'Hủy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ffse1704_tunglnt_trangthai`
--
ALTER TABLE `ffse1704_tunglnt_trangthai`
  ADD PRIMARY KEY (`matrangthai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ffse1704_tunglnt_trangthai`
--
ALTER TABLE `ffse1704_tunglnt_trangthai`
  MODIFY `matrangthai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
