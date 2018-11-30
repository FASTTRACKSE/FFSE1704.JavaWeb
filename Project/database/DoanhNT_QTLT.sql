-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 26, 2018 at 02:49 PM
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
  `Ma_Danh_Muc` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Ten_Danh_Muc` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `isDelete` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `danh_muc`
--

INSERT INTO `danh_muc` (`Ma_Danh_Muc`, `Ten_Danh_Muc`, `isDelete`) VALUES
('EN', 'English', 0),
('IT', 'Information Technology', 0);

-- --------------------------------------------------------

--
-- Table structure for table `icon`
--

CREATE TABLE IF NOT EXISTS `icon` (
  `ma_icon` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `link_File` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `ten_icon` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `isDelete` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `icon`
--

INSERT INTO `icon` (`ma_icon`, `link_File`, `ten_icon`, `isDelete`) VALUES
('docx', '', 'DOCX.png', 0),
('exe', '', 'EXE.png', 0),
('html', '', 'HTML.png', 0),
('img', '', 'IMG.png', 0),
('jpg', '', 'JPG.png', 0),
('mp3', '', 'MP3.png', 0),
('mp4', '', 'MP4.png', 0),
('pdf', '', 'PDF.png', 0),
('png', '', 'PNG.png', 0),
('txt', '', 'TXT.png', 0),
('xls', '', 'XLS.png', 0),
('xlsx', '', 'XLSX.png', 0),
('xml', '', 'Xml.png', 0),
('zip', '', 'ZIP.png', 0);


-- --------------------------------------------------------

--
-- Table structure for table `tai_lieu`
--

CREATE TABLE IF NOT EXISTS `tai_lieu` (
  `id_tai_lieu` int(11) NOT NULL,
  `ma_tai_lieu` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ma_danh_muc` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ma_icon` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ten_tai_lieu` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `ma_phong_ban` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `mo_taTL` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `Link` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `ma_trang_Thai` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `isDelete` tinyint(2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tai_lieu`
--

INSERT INTO `tai_lieu` (`id_tai_lieu`, `ma_tai_lieu`, `ma_danh_muc`, `ma_icon`, `ten_tai_lieu`, `ma_phong_ban`, `mo_taTL`, `Link`, `ma_trang_Thai`, `isDelete`) VALUES
(69, 'DayLaTaiLieu', 'IT', 'jpg', '12132534_1510034795984189_9032794836854226309_o (1).jpg', 'PDT', 'DayCungLaTailieu', '\\upload\\12132534_1510034795984189_9032794836854226309_o (1).jpg', 'Wait', 0),
(70, '12341234', 'EN', 'docx', 'BÀI-TẬP-TRẮC-NGHIỆM-VỀ-CÁC-THÌ-TRONG-TIẾNG-ANH.docx', 'PDT', 'Tai Lieu', '\\upload\\BÀI-TẬP-TRẮC-NGHIỆM-VỀ-CÁC-THÌ-TRONG-TIẾNG-ANH.docx', 'Wait', 0),
(71, 'qwerqwer', 'IT', 'docx', 'BÀI-TẬP-TRẮC-NGHIỆM-VỀ-CÁC-THÌ-TRONG-TIẾNG-ANH.docx', 'PDT', '123123', '\\upload\\BÀI-TẬP-TRẮC-NGHIỆM-VỀ-CÁC-THÌ-TRONG-TIẾNG-ANH.docx', 'Wait', 0),
(72, 'qwerqwer', 'IT', 'docx', 'BÀI-TẬP-TRẮC-NGHIỆM-VỀ-CÁC-THÌ-TRONG-TIẾNG-ANH.docx', 'PDT', '123123', '\\upload\\BÀI-TẬP-TRẮC-NGHIỆM-VỀ-CÁC-THÌ-TRONG-TIẾNG-ANH.docx', 'Wait', 0),
(74, 'Tài Liệu Phòng IT', 'IT', 'docx', 'BÀI-TẬP-TRẮC-NGHIỆM-VỀ-CÁC-THÌ-TRONG-TIẾNG-ANH.docx', 'PIT', '123123', '\\upload\\BÀI-TẬP-TRẮC-NGHIỆM-VỀ-CÁC-THÌ-TRONG-TIẾNG-ANH.docx', 'Wait', 0),
(75, 'Mã Tài Liệu', 'EN', 'pdf', 'Spring Hibernate.pdf', 'PDA', 'Đây là tài liệu', '\\upload\\Spring Hibernate.pdf', 'Wait', 0),
(76, 'Mã Tài Liệu Nữa', 'EN', 'xlsx', 'database.xlsx', 'PNS', 'Đây là tài liệu của phòng nhân sự', '\\upload\\database.xlsx', 'Wait', 0),
(77, '12341234', 'IT', 'xlsx', 'database.xlsx', 'PGD', '123123', '\\upload\\database.xlsx', 'Wait', 0),
(78, '12341234', 'EN', 'xlsx', 'Product Backlog sample.xlsx', 'PGD', '123123', '\\upload\\Product Backlog sample.xlsx', 'Wait', 0),
(79, '12341234', 'EN', 'xlsx', 'Product Backlog sample.xlsx', 'PGD', '123123', '\\upload\\Product Backlog sample.xlsx', 'Wait', 0),
(80, '12341234', 'EN', 'xlsx', 'Product Backlog sample.xlsx', 'PGD', '123123', '\\upload\\Product Backlog sample.xlsx', 'Wait', 0),
(81, '12341234', 'EN', 'xlsx', 'Product Backlog sample.xlsx', 'PGD', '123123', '\\upload\\Product Backlog sample.xlsx', 'Wait', 0);

-- --------------------------------------------------------

--
-- Table structure for table `trang_thai`
--

CREATE TABLE IF NOT EXISTS `trang_thai` (
  `Ma_Trang_Thai` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Ten_Trang_Thai` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `isDelete` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `trang_thai`
--

INSERT INTO `trang_thai` (`Ma_Trang_Thai`, `Ten_Trang_Thai`, `isDelete`) VALUES
('123123', '123123', 1),
('Approved', 'Approved', 0),
('Denied', 'Denied', 0),
('Draft', 'Draft', 0),
('qerqwreqwer', 'qerqwer', 1),
('unknow', 'unknow', 1),
('Wait', 'Waiting Approve', 0);

-- --------------------------------------------------------

--
-- Indexes for table `danh_muc`
--
ALTER TABLE `danh_muc`
  ADD PRIMARY KEY (`Ma_Danh_Muc`);

--
-- Indexes for table `icon`
--
ALTER TABLE `icon`
  ADD PRIMARY KEY (`ma_icon`);

--
-- Indexes for table `tai_lieu`
--
ALTER TABLE `tai_lieu`
  ADD PRIMARY KEY (`id_tai_lieu`);

--
-- Indexes for table `trang_thai`
--
ALTER TABLE `trang_thai`
  ADD PRIMARY KEY (`Ma_Trang_Thai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tai_lieu`
--
ALTER TABLE `tai_lieu`
  MODIFY `id_tai_lieu` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=82;
