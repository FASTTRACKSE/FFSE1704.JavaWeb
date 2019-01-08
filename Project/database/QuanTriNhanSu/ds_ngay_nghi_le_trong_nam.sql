-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 02, 2019 lúc 11:27 AM
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
-- Cấu trúc bảng cho bảng `ds_ngay_nghi_le_trong_nam`
--

CREATE TABLE `ds_ngay_nghi_le_trong_nam` (
  `id` int(11) NOT NULL,
  `nam` int(11) NOT NULL,
  `ten_ngay_le` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tu_ngay` date NOT NULL,
  `den_het_ngay` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ds_ngay_nghi_le_trong_nam`
--

INSERT INTO `ds_ngay_nghi_le_trong_nam` (`id`, `nam`, `ten_ngay_le`, `tu_ngay`, `den_het_ngay`) VALUES
(1, 2019, 'Tết Dương lịch 2019', '2018-12-31', '2019-01-01'),
(2, 2019, 'Tết Nguyên Đán Kỷ Hợi', '2019-02-02', '2019-02-10'),
(3, 2019, ' Giỗ Tổ Hùng Vương 2019', '2019-04-14', '2019-04-14'),
(4, 2019, 'Ngày Chiến thắng 30/4 và Ngày quốc tế lao động 1/5/2019', '2019-04-29', '2019-05-01'),
(5, 2019, 'Ngày Quốc Khánh 2/9/2019', '2019-08-31', '2019-09-02'),
(6, 2019, 'Ngày Thành Lập Tập Đoàn FBMS', '2019-09-13', '2019-09-13');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ds_ngay_nghi_le_trong_nam`
--
ALTER TABLE `ds_ngay_nghi_le_trong_nam`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ds_ngay_nghi_le_trong_nam`
--
ALTER TABLE `ds_ngay_nghi_le_trong_nam`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
