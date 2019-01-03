-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 27, 2018 at 20:00 PM
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
-- Table structure for table `danh_muc_`
--

CREATE TABLE IF NOT EXISTS `danh_muc_` (
  `id` int(10) NOT NULL,
  `ma_danh_muc` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ten_danh_muc` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `danh_muc_`
--

INSERT INTO `danh_muc_` (`id`, `ma_danh_muc`, `ten_danh_muc`) VALUES
(1, 'IT', 'Tài liệu IT'),
(2, 'EL', 'Tài liệu English');








-- --------------------------------------------------------

--
-- Table structure for table `tai_lieu_`
--

CREATE TABLE IF NOT EXISTS `tai_lieu_` (
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
-- Dumping data for table `tai_lieu_`
--

INSERT INTO `tai_lieu_` (`id`, `ten_tai_lieu`, `ma_danh_muc`, `link_file`, `name_file`, `ma_trang_thai`, `mo_ta`, `ghi_chu`, `ma_phong_ban`, `ma_icon`) VALUES
(106, 'Synv', 'EL', NULL, '', 'da_phe_duyet', 'English', '', 'PDA1', NULL),
(107, 'Tài liệu Tiếng Anh cơ bản', 'EL', '\\upload\\45628910_563223354173631_2030519606786916352_n.jpg', '45628910_563223354173631_2030519606786916352_n.jpg', 'tu_choi', 'English', NULL, 'PDA3', 'jpg'),
(127, 'Tài liệu training Nhân Viên mới', 'IT', '\\upload\\31704224_1141763469314929_1979064927918227456_n.jpg', '31704224_1141763469314929_1979064927918227456_n.jpg', 'da_phe_duyet', 'Tài liệu training Nhân Viên mới : cho các thành viên mới vào ', NULL, 'PDA1', 'jpg'),
(128, 'Tài liệu Tiếng Anh', 'IT', '\\upload\\31704224_1141763469314929_1979064927918227456_n.jpg', '31704224_1141763469314929_1979064927918227456_n.jpg', 'cho_phe_duyet', 'Tài liệu Tiếng Anh: Cho người mới bắt đầu 1', NULL, 'PDA1', 'jpg'),
(129, 'alo', 'IT', NULL, '', 'tu_choi', 'đạt', 'Cần bỏ sung thêm chi tiết', 'PDA1', NULL),
(130, 'Tài Liệu IT', 'IT', '\\upload\\31301842_444188466016062_6080453128756933879_n.jpg', '31301842_444188466016062_6080453128756933879_n.jpg', 'cho_phe_duyet', 'Tài Liệu training ', NULL, 'PDA1', 'jpg'),
(131, 'Tài liệu Tiếng Anh', 'IT', '\\upload\\29598267_10209043052672843_6711340936042064120_n.jpg', '29598267_10209043052672843_6711340936042064120_n.jpg', 'cho_phe_duyet', 'Hình Ảnh', NULL, 'PDT', 'jpg'),
(132, 'Tài Liệu bổ sung', 'IT', '\\upload\\Chương trình quản lý thông tin sinh viên Trường FastTrackSE.docx', 'Chương trình quản lý thông tin sinh viên Trường FastTrackSE.docx', 'cho_phe_duyet', 'Bản word', NULL, 'PDA1', 'docx'),
(133, 'alooo', 'IT', '\\upload\\31301842_444188466016062_6080453128756933879_n.jpg', '31301842_444188466016062_6080453128756933879_n.jpg', 'cho_phe_duyet', 'a', NULL, 'PDA1', 'jpg');

-- --------------------------------------------------------

--
-- Table structure for table `trang_thai_`
--

CREATE TABLE IF NOT EXISTS `trang_thai` (
  `id` int(11) NOT NULL,
  `ma_trang_thai` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ten_trang_thai` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `trang_thai_`
--

INSERT INTO `trang_thai` (`id`, `ma_trang_thai`, `ten_trang_thai`) VALUES
(1, 'nhap', 'nháp'),
(2, 'cho_phe_duyet', 'chờ phê duyệt'),
(3, 'da_phe_duyet', 'đã phê duyệt'),
(4, 'tu_choi', 'Từ chối ');

-- --------------------------------------------------------

--
-- Table structure for table `icon_`
--

CREATE TABLE IF NOT EXISTS `icon_` (
  `id` int(11) NOT NULL,
  `ma_icon` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `hinh_anh` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `icon_`
--

INSERT INTO `icon` (`id`, `ma_icon`, `hinh_anh`) VALUES
(1, 'jpg', '/resources/icon/img.jpg'),
(2, 'pdf', '/resources/icon/pdf.png'),
(3, 'xlsx', '/resources/icon/xls.png'),
(4, 'doc', '/resources/icon/word.png'),
(5, 'docx', '/resources/icon/word.png'),
(6, 'png', '/resources/icon/img.jpg');



--
-- Indexes for dumped tables
--


--
-- Indexes for table `danh_muc`
--
ALTER TABLE `danh_muc_`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tai_lieu`
--
ALTER TABLE `tai_lieu_`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `trang_thai`
--
ALTER TABLE `trang_thai_`
  ADD PRIMARY KEY (`id`);
  --
-- Indexes for table `icon`
--
ALTER TABLE `icon_`
  ADD PRIMARY KEY (`id`);



--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danh_muc`
--
ALTER TABLE `danh_muc_`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tai_lieu`
--
ALTER TABLE `tai_lieu_`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `trang_thai`
--
ALTER TABLE `trang_thai_`

  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
  --
-- AUTO_INCREMENT for table `icon`
--
ALTER TABLE `icon_`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
