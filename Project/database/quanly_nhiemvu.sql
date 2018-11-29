-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 26, 2018 lúc 11:17 AM
-- Phiên bản máy phục vụ: 10.1.33-MariaDB
-- Phiên bản PHP: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanly_nhiemvu`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `duan`
--

CREATE TABLE `duan` (
  `id` int(11) NOT NULL,
  `ma_duan` int(11) NOT NULL,
  `ten_duan` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `duan`
--

INSERT INTO `duan` (`id`, `ma_duan`, `ten_duan`) VALUES
(1, 1, 'Quản lý nhiệm vụ'),
(2, 2, 'Quản lý vắng nghỉ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaicongviec`
--

CREATE TABLE `loaicongviec` (
  `id` int(11) NOT NULL,
  `ma_loai_congviec` int(11) NOT NULL,
  `loai_congviec` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loaicongviec`
--

INSERT INTO `loaicongviec` (`id`, `ma_loai_congviec`, `loai_congviec`) VALUES
(1, 1, 'Code'),
(2, 2, 'Fix bug'),
(3, 3, 'Test'),
(4, 4, 'UT');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tencongviec`
--

CREATE TABLE `tencongviec` (
  `id` int(11) NOT NULL,
  `ma_duan` int(11) NOT NULL,
  `ma_loai_congviec` int(11) NOT NULL,
  `ten_congviec` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mota` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `thoigian_batdau` datetime NOT NULL,
  `thoigian_ketthuc` datetime NOT NULL,
  `nguoi_duoc_phan_cong` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `thoigian_dukien_hoanthanh` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tencongviec`
--

INSERT INTO `tencongviec` (`id`, `ma_duan`, `ma_loai_congviec`, `ten_congviec`, `mota`, `thoigian_batdau`, `thoigian_ketthuc`, `nguoi_duoc_phan_cong`, `thoigian_dukien_hoanthanh`) VALUES
(1, 1, 1, 'Tạo Database', 'Mô ta', '2018-11-22 00:00:00', '2018-11-23 00:00:00', 'NV001', '00:00:00'),
(2, 2, 2, 'Tạo Entity', 'Mô tả', '2018-11-26 00:00:00', '2018-11-27 00:00:00', 'NV002', '00:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trangthai`
--

CREATE TABLE `trangthai` (
  `id` int(11) NOT NULL,
  `ma_trangthai` int(11) NOT NULL,
  `ten_trangthai` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `trangthai`
--

INSERT INTO `trangthai` (`id`, `ma_trangthai`, `ten_trangthai`) VALUES
(1, 1, 'Mới'),
(2, 2, 'Đang làm'),
(3, 3, 'Đã xong '),
(4, 4, 'Hủy');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `duan`
--
ALTER TABLE `duan`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loaicongviec`
--
ALTER TABLE `loaicongviec`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tencongviec`
--
ALTER TABLE `tencongviec`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `trangthai`
--
ALTER TABLE `trangthai`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `duan`
--
ALTER TABLE `duan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `loaicongviec`
--
ALTER TABLE `loaicongviec`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `tencongviec`
--
ALTER TABLE `tencongviec`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `trangthai`
--
ALTER TABLE `trangthai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
