-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 26, 2018 at 02:31 PM
-- Server version: 5.6.37
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlyvn`
--

-- --------------------------------------------------------

--
-- Table structure for table `don_nghi`
--

CREATE TABLE IF NOT EXISTS `don_nghi` (
  `id_don` int(11) NOT NULL,
  `id_nv` int(11) NOT NULL,
  `phong_ban` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ten_nv` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ly_do` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tg_bat_dau` date NOT NULL,
  `tg_ket_thuc` date NOT NULL,
  `ghi_chu` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tinh_trang` int(2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `don_nghi`
--

INSERT INTO `don_nghi` (`id_don`, `id_nv`, `phong_ban`, `ten_nv`, `ly_do`, `tg_bat_dau`, `tg_ket_thuc`, `ghi_chu`, `tinh_trang`) VALUES
(1, 10, 'Phòng Nhân sự', 'Phan Thanh Tuấn', 'Nghỉ mát', '2018-11-27', '2018-12-01', 'nghỉ mát', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `don_nghi`
--
ALTER TABLE `don_nghi`
  ADD PRIMARY KEY (`id_don`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `don_nghi`
--
ALTER TABLE `don_nghi`
  MODIFY `id_don` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
