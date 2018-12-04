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
-- Table structure for table `ffse1704_tunglnt_loaicongviec`
--

CREATE TABLE `ffse1704_tunglnt_loaicongviec` (
  `id_congviec` int(11) NOT NULL,
  `loaicongviec` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ffse1704_tunglnt_loaicongviec`
--

INSERT INTO `ffse1704_tunglnt_loaicongviec` (`id_congviec`, `loaicongviec`) VALUES
(1, 'Code'),
(2, 'UT'),
(3, 'Fix Bug'),
(4, 'Text');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ffse1704_tunglnt_loaicongviec`
--
ALTER TABLE `ffse1704_tunglnt_loaicongviec`
  ADD PRIMARY KEY (`id_congviec`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ffse1704_tunglnt_loaicongviec`
--
ALTER TABLE `ffse1704_tunglnt_loaicongviec`
  MODIFY `id_congviec` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
