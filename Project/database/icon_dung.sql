-- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 25, 2018 at 07:01 AM
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
-- Table structure for table `icon_dung`
--

CREATE TABLE IF NOT EXISTS `icon_dung` (
  `id` int(11) NOT NULL,
  `ma_icon` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `hinh_anh` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `icon_dung`
--

INSERT INTO `icon_dung` (`id`, `ma_icon`, `hinh_anh`) VALUES
(1, 'jpg', '/resources/images/icon/img.png'),
(2, 'pdf', '/resources/images/icon/pdf.png'),
(3, 'xlsx', '/resources/images/icon/xls.png'),
(4, 'doc', '/resources/images/icon/word.png'),
(5, 'docx', '/resources/images/icon/word.png'),
(6, 'png', '/resources/images/icon/img.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `icon_dung`
--
ALTER TABLE `icon_dung`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `icon_dung`
--
ALTER TABLE `icon_dung`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
