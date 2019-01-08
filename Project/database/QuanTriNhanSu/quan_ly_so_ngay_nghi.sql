-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 02, 2019 lúc 11:29 AM
-- Phiên bản máy phục vụ: 10.1.37-MariaDB
-- Phiên bản PHP: 7.2.12

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
-- Cấu trúc bảng cho bảng `quan_ly_so_ngay_nghi`
--

CREATE TABLE `quan_ly_so_ngay_nghi` (
  `id` int(11) NOT NULL,
  `ma_nhan_vien` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ma_ngay_nghi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tong_ngay_duoc_nghi` int(11) NOT NULL,
  `so_ngay_da_nghi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `quan_ly_so_ngay_nghi`
--

INSERT INTO `quan_ly_so_ngay_nghi` (`id`, `ma_nhan_vien`, `ma_ngay_nghi`, `tong_ngay_duoc_nghi`, `so_ngay_da_nghi`) VALUES
(1, 'NV01', 'DO', 3, 0),
(2, 'NV01', 'PN', 15, 0),
(3, 'NV01', 'TG', 3, 0),
(4, 'NV01', 'SD', 3, 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `quan_ly_so_ngay_nghi`
--
ALTER TABLE `quan_ly_so_ngay_nghi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `quan_ly_so_ngay_nghi`
--
ALTER TABLE `quan_ly_so_ngay_nghi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
