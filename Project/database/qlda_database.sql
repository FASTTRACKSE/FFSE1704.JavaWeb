-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2018 at 05:25 PM
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
-- Table structure for table `database`
--

CREATE TABLE `database` (
  `id` int(11) NOT NULL,
  `ma_database` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ten_database` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ghi_chu` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `database`
--

INSERT INTO `database` (`id`, `ma_database`, `ten_database`, `ghi_chu`) VALUES
(1, '1', 'Oracle', 'Oracle'),
(2, '2', 'Mysql', 'Mysql'),
(3, '3', 'SQL ', 'SQL ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `database`
--
ALTER TABLE `database`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `database`
--
ALTER TABLE `database`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
