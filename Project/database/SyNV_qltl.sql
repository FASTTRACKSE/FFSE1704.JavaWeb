-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 27, 2018 at 20:00 AM
-- Server version: 5.6.37
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Table structure for table `danh_muc`
--

CREATE TABLE IF NOT EXISTS `danh_muc` (
  `id` int(10) NOT NULL,
  `ma_danh_muc` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ten_danh_muc` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `danh_muc`
--

INSERT INTO `danh_muc` (`id`, `ma_danh_muc`, `ten_danh_muc`, `image`) VALUES
(1, 'IT', 'Tài liệu IT', ''),
(2, 'EL', 'Tài liệu English', '');







-- --------------------------------------------------------

--
-- Table structure for table `tai_lieu`
--

CREATE TABLE IF NOT EXISTS `tai_lieu` (
  `id` int(11) NOT NULL,
  `ten_tai_lieu` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_danh_muc` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `file` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_trang_thai` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mo_ta` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ghi_chu` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_phong_ban` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tai_lieu`
--

INSERT INTO `tai_lieu` (`id`, `ten_tai_lieu`, `ma_danh_muc`, `file`, `ma_trang_thai`, `mo_ta`, `ghi_chu`, `ma_phong_ban`) VALUES
(1, 'SyNV', 'IT', 'a', 'a', 'Đã phê duyệt', 'a', 'a'),
(2, 'SyNV', 'b', 'a', 'a', 'a', 'a', 'a'),
(3, 'SyNV', 'b', 'a', 'a', 'a', 'a', 'a'),
(4, 'SyNV', 'IT', 'a', 'da_phe_duyet', 'Đã phê duyệt', 'Phòng dự án', 'PDA'),
(5, 'SyNV', 'aa', 'a', 'a', 'Đã phê duyệt', 'Phòng dự án', 'PDA'),
(6, 'abc', 'IT', 'a', 'da_phe_duyet', 'Đã phê duyệt', 'Phòng dự án', 'PDA'),
(7, 'SyNV', 'IT', 'a', 'da_phe_duyet', 'Đã phê duyệt', 'Phòng dự án', 'PDA'),
(8, 'abc', 'IT', 'a', 'da_phe_duyet', 'Đã phê duyệt', 'Phòng dự án', 'PDA'),
(9, 'SyNV', 'EL', 'a', 'cho_phe_duyet', 'a', 'a', 'PDA'),
(10, 'Tài Liệu Ôn Tập', 'EL', 'a8.jpg', 'nhap', 'nháp', 'Phòng đào tạo', 'PDT'),
(11, 'Tài Liệu Ôn Tập', 'IT', 'diemEnglish.png', 'da_phe_duyet', 'Đã phê duyệt', 'Phòng đào tạo', 'PDT'),
(17, 'Tài Liệu Ôn Tập', 'IT', 'Doc1.docx', 'da_phe_duyet', 'Đã phê duyệt', 'Phòng đào tạo', 'PDT'),
(18, 'SyNV', 'IT', 'The Health Community.pptx', 'da_phe_duyet', 'Đã phê duyệt', 'Phòng đào tạo', 'PDT'),
(19, 'Tài Liệu Ôn Tập', 'EL', 'The Health Community.pptx', 'da_phe_duyet', 'Đã phê duyệt', 'Phòng đào tạo', 'PDT'),
(20, 'Tài Liệu Ôn Tập', 'EL', 'The Health Community.pptx', 'nhap', 'nháp', 'Phòng đào tạo', 'PDT'),
(21, 'SyNV', 'EL', 'The Health Community.pptx', 'cho_phe_duyet', 'Đã phê duyệt', 'Phòng đào tạo', 'PNS'),
(22, 'Tài Liệu FFSE1703dd', 'EL', 'bài tập SOL.txt', 'da_phe_duyet', 'chờ phê duyệt', 'Phòng đào tạo', 'PIT'),
(25, 'Bài Tập English', 'EL', 'Doc1.docx', 'da_phe_duyet', 'Đã phê duyệt', 'Phòng đào tạo', 'PDT');

-- --------------------------------------------------------

--
-- Table structure for table `trang_thai`
--

CREATE TABLE IF NOT EXISTS `trang_thai` (
  `id` int(11) NOT NULL,
  `ma_trang_thai` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ten_trang_thai` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `trang_thai`
--

INSERT INTO `trang_thai` (`id`, `ma_trang_thai`, `ten_trang_thai`) VALUES
(1, 'nhap', 'nháp'),
(2, 'cho_phe_duyet', 'chờ phê duyệt'),
(3, 'da_phe_duyet', 'đã phê duyệt'),
(4, 'tu_choi', 'Từ chối ');





--
-- Indexes for dumped tables
--


--
-- Indexes for table `danh_muc`
--
ALTER TABLE `danh_muc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tai_lieu`
--
ALTER TABLE `tai_lieu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `trang_thai`
--
ALTER TABLE `trang_thai`
  ADD PRIMARY KEY (`id`);



--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danh_muc`
--
ALTER TABLE `danh_muc`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tai_lieu`
--
ALTER TABLE `tai_lieu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `trang_thai`
--
ALTER TABLE `trang_thai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
