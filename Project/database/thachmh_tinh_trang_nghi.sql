-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 26, 2018 at 02:33 PM
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
-- Table structure for table `tinh_trang_nghi`
--

CREATE TABLE IF NOT EXISTS `tinh_trang_nghi` (
  `id_tinh_trang` int(10) NOT NULL,
  `id_nv` int(10) NOT NULL,
  `ngay_da_nghi` int(10) NOT NULL,
  `ngay_con_lai` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tinh_trang_nghi`
--

INSERT INTO `tinh_trang_nghi` (`id_tinh_trang`, `id_nv`, `ngay_da_nghi`, `ngay_con_lai`) VALUES
(4, 10, 5, 7),
(6, 25, 6, 6);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
