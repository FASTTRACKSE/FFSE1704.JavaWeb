-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2018 at 09:04 AM
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
-- Table structure for table `phan_cong_nhiem_vu`
--

CREATE TABLE `phan_cong_nhiem_vu` (
  `id` int(11) NOT NULL,
  `ma_du_an` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ma_nhan_vien` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ma_vai_tro` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phan_cong_nhiem_vu`
--

INSERT INTO `phan_cong_nhiem_vu` (`id`, `ma_du_an`, `ma_nhan_vien`, `ma_vai_tro`) VALUES
(1, 'DA1', 'NV01', '1'),
(2, 'DA1', 'NV02', '3'),
(3, 'DA1', 'NV03', '4'),
(4, 'DA2', 'NV01', '1'),
(5, 'DA2', 'NV01', '4'),
(6, 'DA2', 'NV01', '3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `phan_cong_nhiem_vu`
--
ALTER TABLE `phan_cong_nhiem_vu`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `phan_cong_nhiem_vu`
--
ALTER TABLE `phan_cong_nhiem_vu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
