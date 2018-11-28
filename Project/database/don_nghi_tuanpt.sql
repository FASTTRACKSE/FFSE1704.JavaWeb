-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2018 at 05:23 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

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
-- Table structure for table `don_nghi_tuanpt`
--

CREATE TABLE `don_nghi_tuanpt` (
  `id_don_nghi` int(11) NOT NULL,
  `id_nhan_vien` int(11) NOT NULL,
  `ten_nhan_vien` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `phong_ban` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `ly_do_nghi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tg_bat_dau` date NOT NULL,
  `tg_ket_thuc` date NOT NULL,
  `ghi_chu` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tinh_trang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `don_nghi_tuanpt`
--
ALTER TABLE `don_nghi_tuanpt`
  ADD PRIMARY KEY (`id_don_nghi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `don_nghi_tuanpt`
--
ALTER TABLE `don_nghi_tuanpt`
  MODIFY `id_don_nghi` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
