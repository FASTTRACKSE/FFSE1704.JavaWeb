-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2018 at 08:20 AM
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
-- Table structure for table `khoann_thoi_gian_nghi_phep`
--

CREATE TABLE `khoann_thoi_gian_nghi_phep` (
  `id` int(11) NOT NULL,
  `ma_nhanvien` int(11) NOT NULL,
  `so_ngay_da_nghi` int(11) NOT NULL,
  `so_ngay_con_lai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `khoann_thoi_gian_nghi_phep`
--

INSERT INTO `khoann_thoi_gian_nghi_phep` (`id`, `ma_nhanvien`, `so_ngay_da_nghi`, `so_ngay_con_lai`) VALUES
(1, 123, 3, 9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `khoann_thoi_gian_nghi_phep`
--
ALTER TABLE `khoann_thoi_gian_nghi_phep`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `khoann_thoi_gian_nghi_phep`
--
ALTER TABLE `khoann_thoi_gian_nghi_phep`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
