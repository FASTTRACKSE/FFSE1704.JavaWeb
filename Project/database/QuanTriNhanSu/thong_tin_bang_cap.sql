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
-- Cấu trúc bảng cho bảng `thong_tin_bang_cap`
--

CREATE TABLE `thong_tin_bang_cap` (
  `id` int(11) NOT NULL,
  `ma_nhan_vien` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_trinh_do` int(11) NOT NULL,
  `ten_nganh` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `thoi_gian_bat_dau` datetime NOT NULL,
  `thoi_gian_ket_thuc` datetime NOT NULL,
  `xep_loai` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `noi_cap` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thong_tin_bang_cap`
--

INSERT INTO `thong_tin_bang_cap` (`id`, `ma_nhan_vien`, `id_trinh_do`, `ten_nganh`, `thoi_gian_bat_dau`, `thoi_gian_ket_thuc`, `xep_loai`, `noi_cap`) VALUES
(1, 'NV01', 1, 'công nghệ thông tin', '2018-11-22 00:00:00', '2019-01-01 00:00:00', 'Khá', 'Đại Học Đà Nẵng'),
(2, 'NV02', 4, 'Kế toán tài chính', '2018-12-19 00:00:00', '2019-01-08 00:00:00', 'Giỏi', 'Đại Học Kinh Tế '),
(3, 'NV01', 4, 'Quản trị Kinh Doanh1', '2018-12-19 00:00:00', '2019-01-08 00:00:00', 'Giỏi', 'Đại Học Kinh Tế - Đà Nẵng'),
(4, 'NV01', 2, 'Sân Khấu Điện Ảnh', '2018-12-08 00:00:00', '2019-01-16 00:00:00', 'GIỏi', 'Bí Mật QUỐC GIA'),
(5, 'NV01', 2, 'Học Viện Hàng Không', '2018-12-07 00:00:00', '2019-01-09 00:00:00', 'GIỏi', 'Bí Mật QUỐC GIA'),
(6, 'NV01', 3, 'Điện tử viễn thông', '2018-12-14 00:00:00', '2019-01-03 00:00:00', 'GIỏi', 'Bí Mật QUỐC GIA'),
(7, 'NV01', 2, 'Học Viện Hàng Không', '2018-12-06 00:00:00', '2019-01-03 00:00:00', 'Khá', 'Đại Học Bôn Ba'),
(8, 'NV01', 1, 'công nghệ thông tin', '2018-12-13 00:00:00', '2019-01-04 00:00:00', 'GIỏi', 'Quảng Nam'),
(9, 'NV01', 5, 'Sân Khấu Điện Ảnh', '2018-12-14 00:00:00', '2019-01-04 00:00:00', 'Khá', 'Đại Học Bôn Ba');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `thong_tin_bang_cap`
--
ALTER TABLE `thong_tin_bang_cap`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `thong_tin_bang_cap`
--
ALTER TABLE `thong_tin_bang_cap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
