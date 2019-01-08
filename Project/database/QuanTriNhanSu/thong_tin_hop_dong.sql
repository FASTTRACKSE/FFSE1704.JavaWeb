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
-- Cấu trúc bảng cho bảng `thong_tin_hop_dong`
--

CREATE TABLE `thong_tin_hop_dong` (
  `id` int(11) NOT NULL,
  `ma_nhan_vien` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_hop_dong` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_ket_thuc` date DEFAULT NULL,
  `ma_cong_viec` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_dia_diem_lam_viec` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `muc_luong_ban_dau` int(11) NOT NULL,
  `luong_thang_13` int(20) DEFAULT NULL,
  `so_ngay_nghi_trong_nam` int(11) NOT NULL,
  `ngay_nghi_dac_biet` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `hinh_thuc_tra_luong` int(11) NOT NULL,
  `thoi_gian_bat_dau_lam_viec` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `thoi_gian_ket_thuc_lam_viec` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `ma_phong_ban` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ma_chuc_danh` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `trang_thai` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thong_tin_hop_dong`
--

INSERT INTO `thong_tin_hop_dong` (`id`, `ma_nhan_vien`, `ma_hop_dong`, `ngay_bat_dau`, `ngay_ket_thuc`, `ma_cong_viec`, `ma_dia_diem_lam_viec`, `muc_luong_ban_dau`, `luong_thang_13`, `so_ngay_nghi_trong_nam`, `ngay_nghi_dac_biet`, `hinh_thuc_tra_luong`, `thoi_gian_bat_dau_lam_viec`, `thoi_gian_ket_thuc_lam_viec`, `ma_phong_ban`, `ma_chuc_danh`, `trang_thai`) VALUES
(10, 'NV01', 'HD2', '2018-12-02', '2018-12-29', '6', 'FBMSDN', 110000000, 3, 15, 'FULL', 2, '7:00 AM', '5:00 PM', 'PDA1', 'NV', 'ACTIVE'),
(16, 'NV01', 'HD2', '2018-12-02', '2018-12-29', '2', 'FBMSHN', 5000000, 3, 15, 'FULL', 1, '8:00 AM', '5:00 PM', 'PDA2', 'NV', 'END'),
(17, 'NV01', 'HD2', '2018-12-19', '2018-12-05', '4', 'FBMSHN', 555, 2, 15, 'FULL', 1, '8:00 AM', '5:00 PM', 'PDA2', 'NV', 'END'),
(18, 'NV01', 'HD3', '2018-12-06', '2018-12-12', '7', 'FBMSHN', 4444, 3, 15, 'FULL', 2, '8:00 AM', '5:00 PM', 'PDA2', 'NV', 'END'),
(19, 'NV01', 'HD2', '2018-12-12', '2018-12-28', '1', 'FBMSHN', 9000000, 3, 15, 'FULL', 2, '8:00 AM', '5:00 PM', 'PDA1', 'GD', 'CANCEL');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `thong_tin_hop_dong`
--
ALTER TABLE `thong_tin_hop_dong`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `thong_tin_hop_dong`
--
ALTER TABLE `thong_tin_hop_dong`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
