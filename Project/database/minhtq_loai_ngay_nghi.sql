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
-- Cấu trúc bảng cho bảng `minhtq_loai_ngay_nghi`
--

CREATE TABLE `minhtq_loai_ngay_nghi` (
  `id` int(15) NOT NULL,
  `ma_loai_ngay_nghi` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `ten_loai_ngay_nghi` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `minhtq_loai_ngay_nghi`
--

INSERT INTO `minhtq_loai_ngay_nghi` (`id`, `ma_loai_ngay_nghi`, `ten_loai_ngay_nghi`) VALUES
(1, 'LNN1', 'nghỉ phép'),
(2, 'LNN2', 'nghỉ thai sản'),
(3, 'LNN3', 'nghỉ mát'),
(4, 'LNN4', 'nghỉ ốm'),
(5, '2323', 'hjggy'),
(7, '6', 'nghi đẻ ');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `minhtq_loai_ngay_nghi`
--
ALTER TABLE `minhtq_loai_ngay_nghi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `minhtq_loai_ngay_nghi`
--
ALTER TABLE `minhtq_loai_ngay_nghi`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
