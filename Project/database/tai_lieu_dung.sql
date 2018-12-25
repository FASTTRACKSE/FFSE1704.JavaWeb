-- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 25, 2018 at 07:01 AM
-- Server version: 5.6.30
-- PHP Version: 5.5.35

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
-- Table structure for table `tai_lieu_dung`
--

CREATE TABLE IF NOT EXISTS `tai_lieu_dung` (
  `id` int(11) NOT NULL,
  `ten_tai_lieu` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_danh_muc` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `link_file` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name_file` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_trang_thai` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mo_ta` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ghi_chu` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_phong_ban` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_icon` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tai_lieu_dung`
--

INSERT INTO `tai_lieu_dung` (`id`, `ten_tai_lieu`, `ma_danh_muc`, `link_file`, `name_file`, `ma_trang_thai`, `mo_ta`, `ghi_chu`, `ma_phong_ban`, `ma_icon`) VALUES
(106, 'Nguyễn Mạnh Dũng', 'EL', NULL, '', 'da_phe_duyet', 'English', '', 'PDA1', NULL),
(107, 'Tài liệu Tiếng Anh cơ bản', 'EL', '\\upload\\45628910_563223354173631_2030519606786916352_n.jpg', '45628910_563223354173631_2030519606786916352_n.jpg', 'tu_choi', 'English', NULL, 'PDA3', 'jpg'),
(127, 'Tài liệu training Nhân Viên mới', 'IT', '\\upload\\31704224_1141763469314929_1979064927918227456_n.jpg', '31704224_1141763469314929_1979064927918227456_n.jpg', 'da_phe_duyet', 'Tài liệu training Nhân Viên mới : cho các thành viên mới vào ', NULL, 'PDA1', 'jpg'),
(128, 'Tài liệu Tiếng Anh', 'IT', '\\upload\\31704224_1141763469314929_1979064927918227456_n.jpg', '31704224_1141763469314929_1979064927918227456_n.jpg', 'cho_phe_duyet', 'Tài liệu Tiếng Anh: Cho người mới bắt đầu 1', NULL, 'PDA1', 'jpg'),
(129, 'đạt', 'IT', NULL, '', 'tu_choi', 'đạt', 'Cần bỏ sung thêm chi tiết', 'PDA1', NULL),
(130, 'Tài Liệu IT', 'IT', '\\upload\\31301842_444188466016062_6080453128756933879_n.jpg', '31301842_444188466016062_6080453128756933879_n.jpg', 'cho_phe_duyet', 'Tài Liệu training ', NULL, 'PDA1', 'jpg'),
(131, 'Tài liệu Tiếng Anh', 'IT', '\\upload\\29598267_10209043052672843_6711340936042064120_n.jpg', '29598267_10209043052672843_6711340936042064120_n.jpg', 'cho_phe_duyet', 'Hình Ảnh', NULL, 'PDT', 'jpg'),
(132, 'Tài Liệu bổ sung', 'IT', '\\upload\\Chương trình quản lý thông tin sinh viên Trường FastTrackSE.docx', 'Chương trình quản lý thông tin sinh viên Trường FastTrackSE.docx', 'cho_phe_duyet', 'Bản word', NULL, 'PDA1', 'docx'),
(133, 'q', 'IT', '\\upload\\31301842_444188466016062_6080453128756933879_n.jpg', '31301842_444188466016062_6080453128756933879_n.jpg', 'cho_phe_duyet', 'a', NULL, 'PDA1', 'jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tai_lieu_dung`
--
ALTER TABLE `tai_lieu_dung`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tai_lieu_dung`
--
ALTER TABLE `tai_lieu_dung`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=134;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
