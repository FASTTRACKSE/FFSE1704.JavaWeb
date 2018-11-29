-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2018 at 11:16 AM
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
-- Table structure for table `vai_tro_thanh_vien`
--

CREATE TABLE `vai_tro_thanh_vien` (
  `id` int(11) NOT NULL,
  `ma_vai_tro` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ten_vai_tro` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ghi_chu` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `vai_tro_thanh_vien`
--

INSERT INTO `vai_tro_thanh_vien` (`id`, `ma_vai_tro`, `ten_vai_tro`, `ghi_chu`) VALUES
(1, '1', 'PM', 'PM'),
(2, '2', 'Technical Lead', 'Technical Lead'),
(3, '3', 'Team Lead', 'Team Lead'),
(4, '4', 'Dev', 'Dev'),
(5, '5', 'Tester', 'Tester'),
(6, '6', 'QA', 'QA'),
(7, '7', 'Reviewer', 'Reviewer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `vai_tro_thanh_vien`
--
ALTER TABLE `vai_tro_thanh_vien`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `vai_tro_thanh_vien`
--
ALTER TABLE `vai_tro_thanh_vien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
