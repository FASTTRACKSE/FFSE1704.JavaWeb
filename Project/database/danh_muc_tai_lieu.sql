-- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 03, 2019 at 01:01 PM
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
-- Table structure for table `danh_muc_tai_lieu`
--

CREATE TABLE IF NOT EXISTS `danh_muc_tai_lieu` (
  `id` int(11) NOT NULL,
  `ma_danh_muc` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten_danh_muc` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_phong_ban` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `danh_muc_tai_lieu`
--

INSERT INTO `danh_muc_tai_lieu` (`id`, `ma_danh_muc`, `ten_danh_muc`, `ma_phong_ban`) VALUES
(1, 'IT', 'Tài liệu IT', 'PIT'),
(2, 'EL', 'Tài liệu English', 'PNS'),
(4, 'GĐ', 'Giám Đốc', 'PGD');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danh_muc_tai_lieu`
--
ALTER TABLE `danh_muc_tai_lieu`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danh_muc_tai_lieu`
--
ALTER TABLE `danh_muc_tai_lieu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
