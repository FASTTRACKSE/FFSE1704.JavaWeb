-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 26, 2018 lúc 10:37 AM
-- Phiên bản máy phục vụ: 10.1.35-MariaDB
-- Phiên bản PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlvangnghi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donnghi`
--

CREATE TABLE `donnghi` (
  `id don` int(11) NOT NULL,
  `id nv` int(11) NOT NULL,
  `phong ban` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `ten nv` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ly do` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `tg bat dau` date NOT NULL,
  `tg ket thuc` date NOT NULL,
  `ghi chu` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tinh trang` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `donnghi`
--

INSERT INTO `donnghi` (`id don`, `id nv`, `phong ban`, `ten nv`, `ly do`, `tg bat dau`, `tg ket thuc`, `ghi chu`, `tinh trang`) VALUES
(1, 1701, 'nhân sự', 'ngô gia vỹ', 'em xin nghỉ có việc gia đình', '2018-11-26', '2018-11-29', 'mong sếp phê duyệt', 1),
(2, 1702, 'nhân sự', 'lê khả hồng nhật', 'đau ốm', '2018-11-27', '2018-11-28', 'sếp xem qua ạ', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loainghiphep`
--

CREATE TABLE `loainghiphep` (
  `id nghi` int(11) NOT NULL,
  `ten loai nghi` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loainghiphep`
--

INSERT INTO `loainghiphep` (`id nghi`, `ten loai nghi`) VALUES
(1, 'đau ốm');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tinhtrangnghi`
--

CREATE TABLE `tinhtrangnghi` (
  `id tinh trang` int(10) NOT NULL,
  `id nv` int(10) NOT NULL,
  `ngay da nghi` int(10) NOT NULL,
  `ngay con lai` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tinhtrangnghi`
--

INSERT INTO `tinhtrangnghi` (`id tinh trang`, `id nv`, `ngay da nghi`, `ngay con lai`) VALUES
(1, 1701, 11, 5);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `donnghi`
--
ALTER TABLE `donnghi`
  ADD PRIMARY KEY (`id don`);

--
-- Chỉ mục cho bảng `loainghiphep`
--
ALTER TABLE `loainghiphep`
  ADD PRIMARY KEY (`id nghi`);

--
-- Chỉ mục cho bảng `tinhtrangnghi`
--
ALTER TABLE `tinhtrangnghi`
  ADD PRIMARY KEY (`id tinh trang`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `donnghi`
--
ALTER TABLE `donnghi`
  MODIFY `id don` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `loainghiphep`
--
ALTER TABLE `loainghiphep`
  MODIFY `id nghi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `tinhtrangnghi`
--
ALTER TABLE `tinhtrangnghi`
  MODIFY `id tinh trang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
