-- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 28, 2018 at 11:26 AM
-- Server version: 5.6.30
-- PHP Version: 5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Table structure for table `trang_thai_tai_lieu`
--

CREATE TABLE IF NOT EXISTS `trang_thai_tai_lieu` (
  `id` int(11) NOT NULL,
  `ma_trang_thai` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ten_trang_thai` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `trang_thai_tai_lieu`
--

INSERT INTO `trang_thai_tai_lieu` (`id`, `ma_trang_thai`, `ten_trang_thai`) VALUES
(1, 'nhap', 'nháp'),
(2, 'cho_phe_duyet', 'chờ phê duyệt'),
(3, 'da_phe_duyet', 'đã phê duyệt'),
(4, 'tu_choi', 'Từ chối ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `trang_thai_tai_lieu`
--
ALTER TABLE `trang_thai_tai_lieu`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `trang_thai_tai_lieu`
--
ALTER TABLE `trang_thai_tai_lieu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
