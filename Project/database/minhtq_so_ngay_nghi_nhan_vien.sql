-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 27, 2018 lúc 05:25 PM
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
-- Cấu trúc bảng cho bảng `minhtq_so_ngay_nghi_nhan_vien`
--

CREATE TABLE `minhtq_so_ngay_nghi_nhan_vien` (
  `id` int(15) NOT NULL,
  `ma_nhan_vien` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `so_ngay_phep_nam` int(15) NOT NULL,
  `so_ngay_da_nghi` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `minhtq_so_ngay_nghi_nhan_vien`
--

INSERT INTO `minhtq_so_ngay_nghi_nhan_vien` (`id`, `ma_nhan_vien`, `so_ngay_phep_nam`, `so_ngay_da_nghi`) VALUES
(1, '1001996', 12, 2),
(2, '10019967', 12, 3);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `minhtq_so_ngay_nghi_nhan_vien`
--
ALTER TABLE `minhtq_so_ngay_nghi_nhan_vien`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `minhtq_so_ngay_nghi_nhan_vien`
--
ALTER TABLE `minhtq_so_ngay_nghi_nhan_vien`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
