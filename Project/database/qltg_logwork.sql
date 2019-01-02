-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2019 at 06:38 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

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
-- Table structure for table `qltg_logwork`
--

CREATE TABLE `qltg_logwork` (
  `id` int(11) NOT NULL,
  `ma_du_an` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_nhan_vien` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_vai_tro` int(11) NOT NULL,
  `ma_phong_ban` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ten_cong_viec` varchar(155) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mo_ta` text COLLATE utf8_unicode_ci,
  `trang_thai` int(1) DEFAULT NULL,
  `thoi_gian_bat_dau` datetime DEFAULT NULL,
  `thoi_gian_ket_thuc` datetime DEFAULT NULL,
  `nhan_xet_PM` text COLLATE utf8_unicode_ci,
  `nhan_xet_tpp` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `qltg_logwork`
--

INSERT INTO `qltg_logwork` (`id`, `ma_du_an`, `ma_nhan_vien`, `ma_vai_tro`, `ma_phong_ban`, `ten_cong_viec`, `mo_ta`, `trang_thai`, `thoi_gian_bat_dau`, `thoi_gian_ket_thuc`, `nhan_xet_PM`, `nhan_xet_tpp`) VALUES
(84, 'DA1', 'NV01', 1, 'PDA1', '', '', 1, '2018-12-28 14:36:00', '2019-01-28 14:36:00', '', NULL),
(85, 'DA1', 'NV01', 1, 'PDA1', '', '', 1, '2018-12-28 14:37:00', '2018-12-28 18:37:00', '', NULL),
(86, 'DA1', 'NV01', 1, 'PDA1', '', '', 1, '2018-12-28 15:38:00', '2018-12-28 15:38:00', '', NULL),
(87, 'DA1', 'NV01', 1, 'PDA1', '', '', 1, '2018-12-28 15:44:00', '2018-12-28 15:44:00', '', NULL),
(88, 'DA1', 'NV01', 1, 'PDA1', '', '', 1, '2018-12-28 15:46:00', '2018-12-28 15:46:00', '', NULL),
(89, 'DA1', 'NV01', 1, 'PDA1', '', '', 1, '2018-12-28 15:56:00', '2018-12-28 15:56:00', '', NULL),
(90, 'DA1', 'NV01', 1, 'PDA1', '', '', 1, '2018-12-28 16:00:00', '2018-12-28 16:00:00', 'giỏi lắm e trai', NULL),
(91, 'DA1', 'NV01', 1, 'PDA1', '', '', 1, '2018-12-28 16:46:00', '2018-12-28 16:46:00', 'tao', NULL),
(92, 'DA1', 'NV01', 1, 'PDA1', '', '', 5, '2018-12-28 16:47:00', '2018-12-28 16:47:00', NULL, NULL),
(93, 'DA1', 'NV01', 1, 'PDA1', '', '', 1, '2018-12-28 17:07:00', '2018-12-28 17:07:00', '', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `qltg_logwork`
--
ALTER TABLE `qltg_logwork`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `qltg_logwork`
--
ALTER TABLE `qltg_logwork`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
