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
-- Table structure for table `ffse1704_tunglnt_congviec`
--

CREATE TABLE `ffse1704_tunglnt_congviec` (
  `id` int(11) NOT NULL,
  `maduan` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tencongviec` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `motacongviec` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id_congviec` int(11) NOT NULL,
  `tgianbdau` date NOT NULL,
  `tgiankthuc` date NOT NULL,
  `ma_nhan_vien` int(11) NOT NULL,
  `dukienhoanthanh` varchar(3) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `matrangthai` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ffse1704_tunglnt_congviec`
--

INSERT INTO `ffse1704_tunglnt_congviec` (`id`, `maduan`, `tencongviec`, `motacongviec`, `id_congviec`, `tgianbdau`, `tgiankthuc`, `ma_nhan_vien`, `dukienhoanthanh`, `matrangthai`) VALUES
(1, '1', 'làm create', 'Module 8 dự án LP5', 1, '2018-12-04', '2018-12-04', 1, '4', 1),
(2, '1', 'làm delete', 'xóa', 1, '2018-12-04', '2018-12-04', 2, '4', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ffse1704_tunglnt_congviec`
--
ALTER TABLE `ffse1704_tunglnt_congviec`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ffse1704_tunglnt_congviec`
--
ALTER TABLE `ffse1704_tunglnt_congviec`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
