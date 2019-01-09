-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 03, 2019 at 08:10 AM
-- Server version: 5.6.37
-- PHP Version: 5.6.31

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
-- Table structure for table `thoi_gian_cong_viec`
--

CREATE TABLE IF NOT EXISTS `thoi_gian_cong_viec` (
  `id` int(11) NOT NULL,
  `ma_du_an` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ma_nhan_vien` int(11) NOT NULL,
  `ma_vai_tro` int(11) NOT NULL,
  `ma_phong_ban` varchar(55) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten_cong_viec` varchar(155) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mo_ta` text COLLATE utf8_unicode_ci,
  `trang_thai` int(1) NOT NULL,
  `thoi_gian_bat_dau` datetime DEFAULT NULL,
  `thoi_gian_ket_thuc` datetime DEFAULT NULL,
  `nhan_xet_PM` text COLLATE utf8_unicode_ci,
  `nhan_xet_tpp` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `thoi_gian_cong_viec`
--

INSERT INTO `thoi_gian_cong_viec` (`id`, `ma_du_an`, `ma_nhan_vien`, `ma_vai_tro`, `ma_phong_ban`, `ten_cong_viec`, `mo_ta`, `trang_thai`, `thoi_gian_bat_dau`, `thoi_gian_ket_thuc`, `nhan_xet_PM`, `nhan_xet_tpp`) VALUES
(1, 'DA1', 1, 1, 'PDA2', 'Làm Dự Án', 'Chưa có mô tả', 1, '2018-11-07 00:00:00', '2018-11-07 04:00:00', NULL, NULL),
(5, 'DA2', 3, 2, 'PHC', 'test', 'bug', 2, '2018-12-26 00:00:00', '2018-12-21 00:00:00', '', ''),
(6, 'DA1', 4, 1, 'PDA2', '', 'xc', 1, '2018-12-28 00:00:00', '2018-12-12 00:00:00', NULL, NULL),
(7, 'DA2', 5, 1, 'PDA3', 'debug', 'nay test', 3, '2018-12-05 00:00:00', '2018-12-04 00:00:00', NULL, NULL),
(8, 'DA1', 6, 6, 'PDA1', 'debug', 'bug', 1, '2018-12-28 00:00:00', '2018-12-30 00:00:00', '', ''),
(9, 'DA1', 7, 1, 'PDA3', 'test', '1', 3, '2018-12-27 08:21:38', '2018-12-24 12:37:17', NULL, NULL),
(10, 'DA2', 44, 2, 'PDA3', 'test', '1', 1, '2018-12-21 00:00:00', '2018-12-25 00:00:00', NULL, NULL),
(11, 'DA1', 23, 2, 'PDA1', 'test', 'nay test', 1, '2018-12-26 08:00:00', '2018-12-26 09:00:00', NULL, NULL),
(12, 'DA1', 23, 1, 'PDA2', 'debug', '', 3, '2018-12-26 10:00:00', '2018-12-26 09:00:00', 'ko đc', NULL),
(13, 'DA1', 23, 2, 'PDA2', 'debug', 'ko có gì', 4, '2018-12-26 10:00:00', '2018-12-26 09:00:00', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `thoi_gian_cong_viec`
--
ALTER TABLE `thoi_gian_cong_viec`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `thoi_gian_cong_viec`
--
ALTER TABLE `thoi_gian_cong_viec`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
