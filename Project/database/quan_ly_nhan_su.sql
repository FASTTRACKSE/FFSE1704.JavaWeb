-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 29, 2018 lúc 11:15 AM
-- Phiên bản máy phục vụ: 10.1.32-MariaDB
-- Phiên bản PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quantrinhansu`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `che_do_huong`
--

CREATE TABLE `che_do_huong` (
  `id` int(11) NOT NULL,
  `luong` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `che_do_huong`
--

INSERT INTO `che_do_huong` (`id`, `luong`) VALUES
(1, 'không có'),
(2, 'một nữa'),
(3, 'đầy đủ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chung_chi`
--

CREATE TABLE `chung_chi` (
  `id` int(11) NOT NULL,
  `ma_nhan_vien` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ten_chung_chi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_cap` date NOT NULL,
  `don_vi_cap` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chung_chi`
--

INSERT INTO `chung_chi` (`id`, `ma_nhan_vien`, `ten_chung_chi`, `ngay_cap`, `don_vi_cap`) VALUES
(1, 'NV01', 'PHP', '2018-11-14', 'FPT');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danh_sach_ngay_nghi`
--

CREATE TABLE `danh_sach_ngay_nghi` (
  `id` int(11) NOT NULL,
  `ten_ngay_nghi` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `danh_sach_ngay_nghi`
--

INSERT INTO `danh_sach_ngay_nghi` (`id`, `ten_ngay_nghi`) VALUES
(1, 'Nghỉ đau ốm'),
(2, 'Nghỉ tang gia'),
(3, 'Nghỉ ngày thường'),
(4, 'Nghỉ sinh đẻ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hop_dong`
--

CREATE TABLE `hop_dong` (
  `id` int(11) NOT NULL,
  `ma_hop_dong` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ten_hop_dong` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hop_dong`
--

INSERT INTO `hop_dong` (`id`, `ma_hop_dong`, `ten_hop_dong`) VALUES
(1, 'HD1', 'thử việc'),
(2, 'HD2', 'ngắn hạn'),
(3, 'HD3', 'dài hạn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ho_so_nhan_su`
--

CREATE TABLE `ho_so_nhan_su` (
  `id` int(5) NOT NULL,
  `ma_nhan_vien` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ma_phong_ban` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ma_chuc_danh` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ho_dem` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ten` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `anh_dai_dien` varchar(250) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `nam_sinh` date NOT NULL,
  `gioi_tinh` int(10) NOT NULL,
  `que_quan` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `dan_toc` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ma_quoc_tich` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `noi_tam_tru` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `so_dien_thoai` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `so_cmnd` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `noi_cap_cmnd` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ngay_cap_cmnd` date NOT NULL,
  `trang_thai` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `ho_so_nhan_su`
--

INSERT INTO `ho_so_nhan_su` (`id`, `ma_nhan_vien`, `ma_phong_ban`, `ma_chuc_danh`, `ho_dem`, `ten`, `anh_dai_dien`, `nam_sinh`, `gioi_tinh`, `que_quan`, `dan_toc`, `ma_quoc_tich`, `noi_tam_tru`, `so_dien_thoai`, `email`, `so_cmnd`, `noi_cap_cmnd`, `ngay_cap_cmnd`, `trang_thai`) VALUES
(1, 'NV01', 'PGD', 'GD', 'Nguyễn', 'A', 'dsdsdsd.png', '2018-11-14', 1, 'đà nẵng', 'kinh', '02', 'nơi ấy', '0905320121', 'dsdsd@gmail.com', '123456789', 'nơi bí mật', '2018-11-20', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quoc_tich`
--

CREATE TABLE `quoc_tich` (
  `ma_quoc_tich` int(11) NOT NULL,
  `ten_quoc_tich` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `quoc_tich`
--

INSERT INTO `quoc_tich` (`ma_quoc_tich`, `ten_quoc_tich`) VALUES
(84, 'Việt Nam');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `so_ngay_nghi`
--

CREATE TABLE `so_ngay_nghi` (
  `id` int(11) NOT NULL,
  `ma_nhan_vien` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `so_ngay_da_nghi` int(11) NOT NULL,
  `ngay_nghi_con_lai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `so_ngay_nghi`
--

INSERT INTO `so_ngay_nghi` (`id`, `ma_nhan_vien`, `so_ngay_da_nghi`, `ngay_nghi_con_lai`) VALUES
(1, 'NV01', 2, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thanh_pho`
--

CREATE TABLE `thanh_pho` (
  `provinceid` varchar(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `thanh_pho`
--

INSERT INTO `thanh_pho` (`provinceid`, `name`, `type`) VALUES
('01', 'Hà Nội', 'Thành Phố'),
('02', 'Hà Giang', 'Tỉnh'),
('04', 'Cao Bằng', 'Tỉnh'),
('06', 'Bắc Kạn', 'Tỉnh'),
('08', 'Tuyên Quang', 'Tỉnh'),
('10', 'Lào Cai', 'Tỉnh'),
('11', 'Điện Biên', 'Tỉnh'),
('12', 'Lai Châu', 'Tỉnh'),
('14', 'Sơn La', 'Tỉnh'),
('15', 'Yên Bái', 'Tỉnh'),
('17', 'Hòa Bình', 'Tỉnh'),
('19', 'Thái Nguyên', 'Tỉnh'),
('20', 'Lạng Sơn', 'Tỉnh'),
('22', 'Quảng Ninh', 'Tỉnh'),
('24', 'Bắc Giang', 'Tỉnh'),
('25', 'Phú Thọ', 'Tỉnh'),
('26', 'Vĩnh Phúc', 'Tỉnh'),
('27', 'Bắc Ninh', 'Tỉnh'),
('30', 'Hải Dương', 'Tỉnh'),
('31', 'Hải Phòng', 'Thành Phố'),
('33', 'Hưng Yên', 'Tỉnh'),
('34', 'Thái Bình', 'Tỉnh'),
('35', 'Hà Nam', 'Tỉnh'),
('36', 'Nam Định', 'Tỉnh'),
('37', 'Ninh Bình', 'Tỉnh'),
('38', 'Thanh Hóa', 'Tỉnh'),
('40', 'Nghệ An', 'Tỉnh'),
('42', 'Hà Tĩnh', 'Tỉnh'),
('44', 'Quảng Bình', 'Tỉnh'),
('45', 'Quảng Trị', 'Tỉnh'),
('46', 'Thừa Thiên Huế', 'Tỉnh'),
('48', 'Đà Nẵng', 'Thành Phố'),
('49', 'Quảng Nam', 'Tỉnh'),
('51', 'Quảng Ngãi', 'Tỉnh'),
('52', 'Bình Định', 'Tỉnh'),
('54', 'Phú Yên', 'Tỉnh'),
('56', 'Khánh Hòa', 'Tỉnh'),
('58', 'Ninh Thuận', 'Tỉnh'),
('60', 'Bình Thuận', 'Tỉnh'),
('62', 'Kon Tum', 'Tỉnh'),
('64', 'Gia Lai', 'Tỉnh'),
('66', 'Đắk Lắk', 'Tỉnh'),
('67', 'Đắk Nông', 'Tỉnh'),
('68', 'Lâm Đồng', 'Tỉnh'),
('70', 'Bình Phước', 'Tỉnh'),
('72', 'Tây Ninh', 'Tỉnh'),
('74', 'Bình Dương', 'Tỉnh'),
('75', 'Đồng Nai', 'Tỉnh'),
('77', 'Bà Rịa - Vũng Tàu', 'Tỉnh'),
('79', 'Hồ Chí Minh', 'Thành Phố'),
('80', 'Long An', 'Tỉnh'),
('82', 'Tiền Giang', 'Tỉnh'),
('83', 'Bến Tre', 'Tỉnh'),
('84', 'Trà Vinh', 'Tỉnh'),
('86', 'Vĩnh Long', 'Tỉnh'),
('87', 'Đồng Tháp', 'Tỉnh'),
('89', 'An Giang', 'Tỉnh'),
('91', 'Kiên Giang', 'Tỉnh'),
('92', 'Cần Thơ', 'Thành Phố'),
('93', 'Hậu Giang', 'Tỉnh'),
('94', 'Sóc Trăng', 'Tỉnh'),
('95', 'Bạc Liêu', 'Tỉnh'),
('96', 'Cà Mau', 'Tỉnh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thong_tin_bang_cap`
--

CREATE TABLE `thong_tin_bang_cap` (
  `id` int(11) NOT NULL,
  `ma_nhan_vien` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_trinh_do` int(11) NOT NULL,
  `ten_nganh` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `thoi_gian` datetime NOT NULL,
  `xep_loai` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `noi_cap` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thong_tin_bang_cap`
--

INSERT INTO `thong_tin_bang_cap` (`id`, `ma_nhan_vien`, `id_trinh_do`, `ten_nganh`, `thoi_gian`, `xep_loai`, `noi_cap`) VALUES
(1, 'NV01', 1, 'công nghệ', '2018-11-22 00:00:00', 'Khá', 'Đại Học Đà Nẵng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thong_tin_gia_dinh`
--

CREATE TABLE `thong_tin_gia_dinh` (
  `id` int(11) NOT NULL,
  `ma_nhan_vien` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ho_va_ten` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `quan_he` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `nam_sinh` date NOT NULL,
  `nghe_nghiep` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dia_chi` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thong_tin_gia_dinh`
--

INSERT INTO `thong_tin_gia_dinh` (`id`, `ma_nhan_vien`, `ho_va_ten`, `quan_he`, `nam_sinh`, `nghe_nghiep`, `dia_chi`) VALUES
(1, 'NV01', 'Nguyễn Văn A', 'Cha', '2018-11-12', 'Bán Hàng', 'nơi này');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thong_tin_hop_dong`
--

CREATE TABLE `thong_tin_hop_dong` (
  `id` int(11) NOT NULL,
  `ma_nhan_vien` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ma_hop_dong` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_bat_dau` date NOT NULL,
  `ngay_ket_thuc` date NOT NULL,
  `luong_thang_13` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thong_tin_hop_dong`
--

INSERT INTO `thong_tin_hop_dong` (`id`, `ma_nhan_vien`, `ma_hop_dong`, `ngay_bat_dau`, `ngay_ket_thuc`, `luong_thang_13`) VALUES
(1, 'NV01', 'HD2', '2018-11-07', '2018-11-30', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trinh_do`
--

CREATE TABLE `trinh_do` (
  `id_trinh_do` int(11) NOT NULL,
  `ten_trinh_do` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `trinh_do`
--

INSERT INTO `trinh_do` (`id_trinh_do`, `ten_trinh_do`) VALUES
(1, 'tiểu học'),
(2, 'trung học');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `che_do_huong`
--
ALTER TABLE `che_do_huong`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `chung_chi`
--
ALTER TABLE `chung_chi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `danh_sach_ngay_nghi`
--
ALTER TABLE `danh_sach_ngay_nghi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `hop_dong`
--
ALTER TABLE `hop_dong`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `ho_so_nhan_su`
--
ALTER TABLE `ho_so_nhan_su`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `quoc_tich`
--
ALTER TABLE `quoc_tich`
  ADD PRIMARY KEY (`ma_quoc_tich`);

--
-- Chỉ mục cho bảng `so_ngay_nghi`
--
ALTER TABLE `so_ngay_nghi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `thanh_pho`
--
ALTER TABLE `thanh_pho`
  ADD PRIMARY KEY (`provinceid`);

--
-- Chỉ mục cho bảng `thong_tin_bang_cap`
--
ALTER TABLE `thong_tin_bang_cap`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `thong_tin_gia_dinh`
--
ALTER TABLE `thong_tin_gia_dinh`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `thong_tin_hop_dong`
--
ALTER TABLE `thong_tin_hop_dong`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `trinh_do`
--
ALTER TABLE `trinh_do`
  ADD PRIMARY KEY (`id_trinh_do`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `che_do_huong`
--
ALTER TABLE `che_do_huong`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `chung_chi`
--
ALTER TABLE `chung_chi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `danh_sach_ngay_nghi`
--
ALTER TABLE `danh_sach_ngay_nghi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `hop_dong`
--
ALTER TABLE `hop_dong`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `ho_so_nhan_su`
--
ALTER TABLE `ho_so_nhan_su`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `quoc_tich`
--
ALTER TABLE `quoc_tich`
  MODIFY `ma_quoc_tich` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT cho bảng `so_ngay_nghi`
--
ALTER TABLE `so_ngay_nghi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `thong_tin_bang_cap`
--
ALTER TABLE `thong_tin_bang_cap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `thong_tin_gia_dinh`
--
ALTER TABLE `thong_tin_gia_dinh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `thong_tin_hop_dong`
--
ALTER TABLE `thong_tin_hop_dong`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `trinh_do`
--
ALTER TABLE `trinh_do`
  MODIFY `id_trinh_do` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;