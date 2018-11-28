-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2018 at 10:43 AM
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
-- Database: `quanlythoigian`
--

-- --------------------------------------------------------

--
-- Table structure for table `logwork`
--

CREATE TABLE `logwork` (
  `id` int(11) NOT NULL,
  `ma_du_an` int(11) NOT NULL,
  `ma_nhan_vien` int(11) NOT NULL,
  `ma_vai_tro` int(11) NOT NULL,
  `ma_phong_ban` int(11) NOT NULL,
  `ten_cong_viec` varchar(155) COLLATE utf8_unicode_ci NOT NULL,
  `mo_ta` text COLLATE utf8_unicode_ci,
  `trang_thai` int(1) NOT NULL,
  `thoi_gian_bat_dau` date NOT NULL,
  `thoi_gian_ket_thuc` date NOT NULL,
  `nhan_xet_PM` text COLLATE utf8_unicode_ci NOT NULL,
  `nhan_xet_tpp` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `logwork`
--

INSERT INTO `logwork` (`id`, `ma_du_an`, `ma_nhan_vien`, `ma_vai_tro`, `ma_phong_ban`, `ten_cong_viec`, `mo_ta`, `trang_thai`, `thoi_gian_bat_dau`, `thoi_gian_ket_thuc`, `nhan_xet_PM`, `nhan_xet_tpp`) VALUES
(1, 1, 1, 0, 0, 'LP5', 'Chưa có mô tả', 1, '2018-11-07', '2018-11-30', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logwork`
--
ALTER TABLE `logwork`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logwork`
--
ALTER TABLE `logwork`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
