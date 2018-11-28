-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2018 at 10:18 AM
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
-- Database: `ffse1704`
--

-- --------------------------------------------------------

--
-- Table structure for table `quan_ly_thong_tin_du_an`
--

CREATE TABLE `quan_ly_thong_tin_du_an` (
  `id` int(11) NOT NULL,
  `ma_du_an` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ten_du_an` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ma_khach_hang` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `mo_ta` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phong_du_an` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `PM` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `domain` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `framework` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `database` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `programming_language` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `trang_thai` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `quan_ly_thong_tin_du_an`
--

INSERT INTO `quan_ly_thong_tin_du_an` (`id`, `ma_du_an`, `ten_du_an`, `ma_khach_hang`, `mo_ta`, `phong_du_an`, `PM`, `start_date`, `end_date`, `domain`, `framework`, `database`, `programming_language`, `trang_thai`) VALUES
(1, '1', 'website bán hàng', 'KH001', '', '', '', '0000-00-00', '0000-00-00', '', '', '', '', '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `quan_ly_thong_tin_du_an`
--
ALTER TABLE `quan_ly_thong_tin_du_an`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `quan_ly_thong_tin_du_an`
--
ALTER TABLE `quan_ly_thong_tin_du_an`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
