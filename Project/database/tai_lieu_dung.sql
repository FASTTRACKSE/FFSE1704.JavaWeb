-- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 03, 2019 at 01:01 PM
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
  `ma_icon` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tai_lieu_dung`
--

INSERT INTO `tai_lieu_dung` (`id`, `ten_tai_lieu`, `ma_danh_muc`, `link_file`, `name_file`, `ma_trang_thai`, `mo_ta`, `ghi_chu`, `ma_icon`) VALUES
(107, 'Tài liệu Tiếng Anh cơ bản', 'GĐ', NULL, '42318067_148608579413675_1364535329259782144_n.jpg', 'tu_choi', 'English', NULL, 'jpg'),
(127, 'Tài liệu training Nhân Viên mới', 'IT', '\\uploads\\45066091_927214004150127_2638904271180922880_n.jpg', '45066091_927214004150127_2638904271180922880_n.jpg', 'da_phe_duyet', 'Tài liệu training Nhân Viên mới : cho các thành viên mới vào ', NULL, 'jpg'),
(130, 'Tài Liệu IT', 'IT', '\\uploads\\42318067_148608579413675_1364535329259782144_n.jpg', '42318067_148608579413675_1364535329259782144_n.jpg', 'nhap', 'Tài Liệu training ', NULL, 'jpg'),
(131, 'Tài liệu Tiếng Anh', 'IT', '\\uploads\\44954263_927214127483448_2795604130045886464_n.jpg', '44954263_927214127483448_2795604130045886464_n.jpg', 'da_phe_duyet', 'Hình Ảnh', 'êrêr', 'jpg'),
(132, 'Tài liệu Demo', 'EL', '\\uploads\\45628910_563223354173631_2030519606786916352_n.jpg', '45628910_563223354173631_2030519606786916352_n.jpg', 'da_phe_duyet', 'Phòng dự án 2', '', 'jpg'),
(133, 'Tài liệu Demo', 'IT', '\\uploads\\45011807_927214194150108_1580147918789148672_n.jpg', '45011807_927214194150108_1580147918789148672_n.jpg', 'da_phe_duyet', 'Phòng dự án 3', '', 'jpg'),
(134, 'Tài liệu Demo', 'IT', '\\uploads\\44954264_927213774150150_4044157458069848064_n.jpg', '44954264_927213774150150_4044157458069848064_n.jpg', 'da_phe_duyet', 'Phòng dự án 4', '', 'jpg'),
(135, 'Tài liệu Demo', 'IT', '\\uploads\\45069609_927214170816777_8213787609688702976_n.jpg', '45069609_927214170816777_8213787609688702976_n.jpg', 'da_phe_duyet', 'Phòng Đào Tạo', '', 'jpg'),
(136, 'Tài liệu Demo', 'IT', '\\uploads\\45066091_927214004150127_2638904271180922880_n.jpg', '45066091_927214004150127_2638904271180922880_n.jpg', 'da_phe_duyet', 'Phòng Giám đốc', '', 'jpg'),
(137, 'Tài liệu Demo', 'IT', '\\uploads\\44937173_1167514903399250_2643702591464144896_n.jpg', '44937173_1167514903399250_2643702591464144896_n.jpg', 'da_phe_duyet', 'Phòng Hành Chính', '', 'jpg'),
(138, 'Tài liệu Demo', 'IT', '\\uploads\\45066091_927214004150127_2638904271180922880_n.jpg', '45066091_927214004150127_2638904271180922880_n.jpg', 'da_phe_duyet', 'PHÒNG Kỹ Thuật', '', 'jpg'),
(139, 'Tài liệu Demo', 'IT', '\\uploads\\45820043_563223294173637_6769981834278207488_n.jpg', '45820043_563223294173637_6769981834278207488_n.jpg', 'da_phe_duyet', 'Phòng kế Toán', '', 'jpg'),
(140, 'Tài liệu Demo', 'IT', '\\uploads\\44943429_927214074150120_5295600938306764800_n.jpg', '44943429_927214074150120_5295600938306764800_n.jpg', 'da_phe_duyet', 'Phòng nhân sự', '', 'jpg'),
(141, 'Tài liệu Demo', 'IT', '\\uploads\\42318067_148608579413675_1364535329259782144_n.jpg', '42318067_148608579413675_1364535329259782144_n.jpg', 'cho_phe_duyet', 'Chưa thích phê duyệt', NULL, 'jpg'),
(142, 'Tài liệu Demo', 'IT', '\\uploads\\45011807_927214194150108_1580147918789148672_n.jpg', '45011807_927214194150108_1580147918789148672_n.jpg', 'cho_phe_duyet', 'Chưa phê duyệt', NULL, 'jpg');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=143;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
