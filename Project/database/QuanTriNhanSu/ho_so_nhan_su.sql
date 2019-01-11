-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 11, 2019 lúc 05:27 AM
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
-- Cấu trúc bảng cho bảng `ho_so_nhan_su`
--

CREATE TABLE `ho_so_nhan_su` (
  `id` int(5) NOT NULL,
  `ma_nhan_vien` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ma_phong_ban` varchar(255) NOT NULL,
  `ma_chuc_danh` varchar(255) NOT NULL,
  `ho_dem` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ten` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `anh_dai_dien` varchar(250) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `nam_sinh` date NOT NULL,
  `gioi_tinh` int(10) NOT NULL,
  `ThanhPho_TinhThanh` varchar(5) NOT NULL,
  `Quan_Huyen` varchar(5) NOT NULL,
  `Phuong_xa_thitran` varchar(5) NOT NULL,
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

INSERT INTO `ho_so_nhan_su` (`id`, `ma_nhan_vien`, `ma_phong_ban`, `ma_chuc_danh`, `ho_dem`, `ten`, `anh_dai_dien`, `nam_sinh`, `gioi_tinh`, `ThanhPho_TinhThanh`, `Quan_Huyen`, `Phuong_xa_thitran`, `que_quan`, `dan_toc`, `ma_quoc_tich`, `noi_tam_tru`, `so_dien_thoai`, `email`, `so_cmnd`, `noi_cap_cmnd`, `ngay_cap_cmnd`, `trang_thai`) VALUES
(1, 'NV01', 'PDA1', 'NV', 'Nguyễn', 'A', '44965565_191615391728636_587245324989366272_n.jpg', '2018-11-14', 1, '01', '001', '00001', 'đà nẵng', 'kinh', '84', 'nơi ấy', '09053201211', 'dsdsd@gmail.com', '123456789', 'Bí Mật Nhà nước ', '2018-11-20', 1),
(2, 'NV02', 'PDA2', 'NV', 'Lê Trọng', 'Quân', 'chipu2.jpg', '1997-04-08', 1, '01', '002', '00037', 'Đà Nẵng', 'Kinh', '84', 'Đà Nẵng', '09899898990', 'quantrongle@gmail.com', '205666777', 'Đà Nẵng', '2010-11-01', 2),
(3, 'NV03', '', '', 'Cao Lê', 'Thành', 'anh3.jpg', '1111-11-11', 1, '01', '002', '00049', 'đà nẵng', 'kinh', '84', 'Da nang', '01220202021', 'huynhdangkhoa922@gmail.com', '1010101001', 'Quảng Nam', '1111-11-21', 1),
(4, 'NV04', '', '', 'Cao Lê', 'mai', 'anh4.jpg', '2018-11-15', 2, '01', '002', '00052', 'đà nẵng', 'kinh', '84', 'Da nang', '01220202021', 'huynhdangkhoa922@gmail.com', '1010101001', 'Quảng Nam', '2018-11-08', 1),
(5, 'NV05', '', '', 'Cao Lê', 'Thành', 'anh5.jpg', '1333-12-01', 1, '01', '002', '00055', 'đà nẵng', 'kinh', '84', 'Da nang', '01220202021', 'ffse1704007@st.fasttrack.edu.vn', '1010101001', 'Quảng Nam', '2018-12-18', 1),
(6, 'NV06', '', '', 'Cao Lê', 'Thành', 'anh6.jpg', '1333-12-01', 1, '01', '003', '00106', 'đà nẵng', 'kinh', '84', 'Da nang', '01220202021', 'ffse1704007@st.fasttrack.edu.vn', '1010101001', 'Quảng Nam', '2018-12-18', 2),
(7, 'NV1808', '', '', 'Hieu', 'Ho Quang', '29356352_365826847234835_7611953112147724190_n.jpg', '2019-01-05', 1, '79', '762', '26809', 'ABC', 'Kinh', '84', 'BCA', '09888888888', 'quanltofficial@gmail.com', '222222', 'HCMC', '2019-01-19', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ho_so_nhan_su`
--
ALTER TABLE `ho_so_nhan_su`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ho_so_nhan_su`
--
ALTER TABLE `ho_so_nhan_su`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
