-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 02, 2019 lúc 09:25 AM
-- Phiên bản máy phục vụ: 10.1.30-MariaDB
-- Phiên bản PHP: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ffse1704`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `minhtq_don_nghi_phep`
--

CREATE TABLE `minhtq_don_nghi_phep` (
  `id` int(15) NOT NULL,
  `ma_nhan_vien` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `loai_ngay_nghi` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `so_luong` int(15) NOT NULL,
  `thoi_gian_bat_dau` date NOT NULL,
  `thoi_gian_ket_thuc` date NOT NULL,
  `ghi_chu` text COLLATE utf8_unicode_ci,
  `trang_thai` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `minhtq_don_nghi_phep`
--

INSERT INTO `minhtq_don_nghi_phep` (`id`, `ma_nhan_vien`, `loai_ngay_nghi`, `so_luong`, `thoi_gian_bat_dau`, `thoi_gian_ket_thuc`, `ghi_chu`, `trang_thai`) VALUES
(1, '1001996', 'LNN1', 1, '2018-12-28', '2018-12-29', 'được nghỉ nhé', 'TT3'),
(7, 'bdfgar', 'LNN1', 4, '2018-12-04', '2018-12-08', '', 'TT3'),
(8, 'bdfgar', 'LNN1', 14, '2018-12-04', '2018-12-23', '', 'TT4'),
(9, '5', 'LNN2', 13, '2018-12-17', '2018-12-22', '', 'TT1'),
(10, '5545', 'LNN1', 4, '2018-12-11', '2018-12-15', '', 'TT1'),
(11, '5545', 'LNN1', 3, '2018-12-11', '2018-12-13', '', 'TT1'),
(12, '56', 'LNN1', 5, '2018-12-17', '2018-12-22', '', 'TT1'),
(13, 'áef', 'LNN1', 2, '2018-12-15', '2018-12-17', '', 'TT2'),
(14, 'ewqe', 'LNN4', 10, '2018-12-17', '2018-12-28', '', 'TT2'),
(16, 'ggg', 'LNN1', 8, '2018-12-17', '2018-12-26', '', 'TT1'),
(17, 'ggg', 'LNN1', 8, '2018-12-24', '2018-12-26', '', 'TT2'),
(18, '1', 'LNN1', 10, '2018-12-17', '2018-12-28', '', 'TT3'),
(19, '6', 'LNN1', 10, '2018-12-17', '2018-12-28', '', 'TT2'),
(20, 'sssss', 'LNN1', 10, '2018-12-23', '2018-12-28', '', 'TT2'),
(21, 'dsfber', 'LNN1', 1, '2018-12-28', '2018-12-29', '', 'TT2'),
(22, 'nv3', 'LNN1', 2, '2018-12-28', '2018-12-31', '', 'TT2'),
(23, '6rty', 'LNN1', 11, '2019-01-02', '2019-01-16', NULL, 'TT1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `minhtq_don_nghi_phep`
--
ALTER TABLE `minhtq_don_nghi_phep`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `minhtq_don_nghi_phep`
--
ALTER TABLE `minhtq_don_nghi_phep`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
