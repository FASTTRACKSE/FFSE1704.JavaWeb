-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 26, 2018 at 03:15 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlyvangnghi`
--

-- --------------------------------------------------------

--
-- Table structure for table `don_nghi_phep`
--

CREATE TABLE `don_nghi_phep` (
  `id` int(11) NOT NULL,
  `ma_nhanvien` int(20) NOT NULL,
  `ten_nhanvien` varchar(200) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `tg_batdau` date NOT NULL,
  `tg_ketthuc` date NOT NULL,
  `so_ngay_nghi` int(11) NOT NULL,
  `loai_nghi_phep` int(20) NOT NULL,
  `trang_thai` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `don_nghi_phep`
--

INSERT INTO `don_nghi_phep` (`id`, `ma_nhanvien`, `ten_nhanvien`, `tg_batdau`, `tg_ketthuc`, `so_ngay_nghi`, `loai_nghi_phep`, `trang_thai`) VALUES
(1, 123, 'Nguyễn Ngọc Khoa', '2018-11-26', '2018-11-28', 3, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `don_nghi_phep`
--
ALTER TABLE `don_nghi_phep`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `don_nghi_phep`
--
ALTER TABLE `don_nghi_phep`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
