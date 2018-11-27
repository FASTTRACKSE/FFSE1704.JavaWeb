-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 17, 2018 at 04:59 AM
-- Server version: 5.6.37
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ffse1704`
--

-- --------------------------------------------------------

--
-- Table structure for table `chuc_danh`
--

CREATE TABLE IF NOT EXISTS `chuc_danh` (
  `ma_chuc_danh` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ten_chuc_danh` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chuc_danh`
--

INSERT INTO `chuc_danh` (`ma_chuc_danh`, `ten_chuc_danh`) VALUES
('GD', 'Giám đốc'),
('PGD', 'Phó Giám đốc'),
('TP', 'Trưởng phòng'),
('PP', 'Phó phòng'),
('TKY', 'Thư Ký'),
('NV', 'Nhân viên');

-- --------------------------------------------------------

--
-- Table structure for table `ho_so_nhan_vien`
--

CREATE TABLE IF NOT EXISTS `ho_so_nhan_vien` (
  `ma_nhan_vien` int(5) unsigned zerofill NOT NULL,
  `ma_phong_ban` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ma_chuc_danh` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ho_dem` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ten` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `anh_dai_dien` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `nam_sinh` date NOT NULL,
  `gioi_tinh` int(1) NOT NULL,
  `ma_tinh_trang_hon_nhan` int(11) NOT NULL,
  `que_quan` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `dan_toc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ma_quoc_tich` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `noi_tam_tru` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `so_dien_thoai` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `so_cmnd` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `noi_cap` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_cap` date NOT NULL,
  `trang_thai` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ho_so_nhan_vien`
--

INSERT INTO `ho_so_nhan_vien` (`ma_nhan_vien`, `ma_phong_ban`, `ma_chuc_danh`, `ho_dem`, `ten`, `anh_dai_dien`, `nam_sinh`, `gioi_tinh`, `ma_tinh_trang_hon_nhan`, `que_quan`, `dan_toc`, `ma_quoc_tich`, `noi_tam_tru`, `so_dien_thoai`, `email`, `so_cmnd`, `noi_cap`, `ngay_cap`, `trang_thai`) VALUES
(00001, 'PGD', 'GD', 'Đặng Văn', 'Nam', '1219820798006.png', '1998-07-20', 1, 1, '121 Hoàng Diệu, Hải Châu, Đà Nẵng', 'Kinh', 'VN', '121 Hoàng Diệu, Hải Châu, Đà Nẵng', '01266676809', 'dangvannam98@gmail.com', '201756910', 'Đà Nẵng', '2013-01-12', 1),
(00002, 'PGD', 'GD', 'Thái Nguyễn Thục', 'Nhi', '1219820798017.png', '1998-01-12', 2, 1, '128 Trần Văn Hai, Phường Hoà Hải, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '128 Trần Văn Hai, Phường Hoà Hải, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '01694158988', 'doanphiphuc4081@gmail.com', '201127804', 'Đà Nẵng', '2014-10-21', 1),
(00003, 'PGD', 'NV', 'Trương Thành', 'Ngân', '1219820798019.png', '1985-09-25', 1, 2, '693A/42 Trần Cao Vân, Phường Thanh Khê Đông, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '693A/42 Trần Cao Vân, Phường Thanh Khê Đông, Quận Thanh Khê, Thành phố Đà Nẵng', '01679921408', 'truongthanhngan9451@gmail.com', '201453041', 'Nam Định', '2011-01-19', 2),
(00004, 'PGD', 'NV', 'Hoàng Phi', 'Bách', '1219820798011.png', '1926-01-02', 2, 1, '06 Nguyễn Lý, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '06 Nguyễn Lý, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0947030127', 'hoangphibach6891@gmail.com', '201397509', 'Phú Yên', '2011-02-13', 1),
(00005, 'PNS', 'NV', 'Trương Hữu', 'Quang', '1219820798016.png', '1995-09-06', 1, 3, '56 Lê Hồng Phong, Phường Phước Ninh, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '56 Lê Hồng Phong, Phường Phước Ninh, Quận Hải Châu, Thành phố Đà Nẵng', '01233215139', 'truonghuuquang7531@gmail.com', '201185456', 'Cà Mau', '2008-10-18', 2),
(00006, 'PDA', 'NV', 'Đoàn Thị', 'Phước', '1219820798003.png', '1960-12-15', 2, 3, 'K36/H8/31 Nguyễn Huy Tưởng, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K36/H8/31 Nguyễn Huy Tưởng, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', '0934657298', 'doanthiphuoc6031@gmail.com', '201850154', 'Đà Nẵng', '2008-11-21', 2),
(00007, 'PDA', 'TP', 'Đăng Hạ', 'Chí', '1219820798013.png', '1956-06-07', 1, 3, '97/33 Cách Mạng Tháng Tám, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '97/33 Cách Mạng Tháng Tám, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0995373667', 'danghachi8421@gmail.com', '201984014', 'Hậu Giang', '2012-06-14', 1),
(00008, 'PDA', 'NV', 'Vương Văn', 'Tài', '1219820798003.png', '1981-06-25', 1, 4, 'K72/32 Ngọc Hân, Phường An Hải Tây, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K72/32 Ngọc Hân, Phường An Hải Tây, Quận Sơn Trà, Thành phố Đà Nẵng', '0978177177', 'vuongvantai161@gmail.com', '201431316', 'Đà Nẵng', '2010-11-16', 2),
(00009, 'PDT', 'NV', 'Đồng Phi', 'Tiến', '1219820798015.png', '1977-05-04', 1, 2, '21/3 Yên Bái, Phường Hải Châu I, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '21/3 Yên Bái, Phường Hải Châu I, Quận Hải Châu, Thành phố Đà Nẵng', '0965388198', 'dongphitien3291@gmail.com', '201526208', 'Đà Nẵng', '2011-12-03', 1),
(00010, 'PDA', 'NV', 'Hoàng Thành', 'Tuệ', '1219820798006.png', '1995-06-03', 2, 3, 'K122/22 Trưng Nữ Vương, Phường Bình Hiên, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K122/22 Trưng Nữ Vương, Phường Bình Hiên, Quận Hải Châu, Thành phố Đà Nẵng', '0912302727', 'hoangthanhtue4171@gmail.com', '201999080', 'Đà Nẵng', '2011-07-28', 2),
(00011, 'PDT', 'NV', 'Tôn Bình', 'Quang', '1219820798016.png', '1970-01-24', 2, 2, 'Lô A2.10 đường 30/4, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô A2.10 đường 30/4, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', '01246865888', 'doanphiphuc181@gmail.com', '201400026', 'Đà Nẵng', '2012-10-19', 2),
(00012, 'PGD', 'NV', 'Tôn Tuấn', 'Phương', '1219820798015.png', '1954-04-09', 2, 2, '278-280 Xô Viết Nghệ Tĩnh, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '278-280 Xô Viết Nghệ Tĩnh, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0933906886', 'truongthanhngan7551@gmail.com', '201197272', 'Đà Nẵng', '2012-11-12', 2),
(00013, 'PNS', 'NV', 'Đào Văn', 'Thanh', '1219820798003.png', '1996-05-15', 2, 4, '11 Phạm Kiệt, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '11 Phạm Kiệt, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0907661973', 'hoangphibach2171@gmail.com', '201560149', 'Đà Nẵng', '2008-04-26', 2),
(00014, 'PIT', 'NV', 'Lê Phi', 'Tiền', '1219820798017.png', '1977-10-03', 2, 1, '356/19 Ngũ Hành Sơn, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '356/19 Ngũ Hành Sơn, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0984352870', 'truonghuuquang3951@gmail.com', '200898894', 'Đà Nẵng', '2008-05-03', 2),
(00015, 'PNS', 'NV', 'Lý Thành', 'Chí', '1219820798015.png', '1951-03-03', 2, 4, '500 Trần Cao Vân, Phường Xuân Hà, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '500 Trần Cao Vân, Phường Xuân Hà, Quận Thanh Khê, Thành phố Đà Nẵng', '01688970755', 'doanthiphuoc4391@gmail.com', '200895335', 'Đà Nẵng', '2011-08-15', 1),
(00016, 'PIT', 'TP', 'Tiến', 'Bùi Tuấn', '1219820798014.png', '1970-04-28', 2, 3, '115 Trần Văn Ơn, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '115 Trần Văn Ơn, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01233033698', 'danghachi8721@gmail.com', '201851326', 'Đồng Tháp', '2012-05-24', 1),
(00017, 'PGD', 'NV', 'Phùng Hạ', 'Châu', '1219820798002.png', '1957-06-04', 1, 2, '74/7/24 Ngô Thị Nhậm, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', '74/7/24 Ngô Thị Nhậm, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', '01679834761', 'vuongvantai3381@gmail.com', '201418951', 'Sơn La', '2008-09-08', 1),
(00018, 'PIT', 'NV', 'Lai Bình', 'Tài', '1219820798003.png', '1972-04-02', 2, 3, '33 Ngô Quyền, Phường Thọ Quang, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '33 Ngô Quyền, Phường Thọ Quang, Quận Sơn Trà, Thành phố Đà Nẵng', '0964697567', 'dongphitien1141@gmail.com', '201096002', 'Đà Nẵng', '2010-01-04', 2),
(00019, 'PIT', 'NV', 'Bùi Văn', 'Tiến', '1219820798019.png', '1986-07-13', 2, 1, 'Lô 50-B1.108 Khu Đô Thị Sinh Thái Ven Sông Hòa Xuân, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 50-B1.108 Khu Đô Thị Sinh Thái Ven Sông Hòa Xuân, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01699784960', 'hoangthanhtue6991@gmail.com', '200802324', 'Khánh Hòa', '2012-02-25', 2),
(00020, 'PGD', 'NV', 'Võ Hưng', 'Tài', '1219820798017.png', '1973-12-29', 2, 2, 'K80/47 Lê Hữu Trác, Phường An Hải Đông, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K80/47 Lê Hữu Trác, Phường An Hải Đông, Quận Sơn Trà, Thành phố Đà Nẵng', '01283813511', 'tonbinhquang3261@gmail.com', '201837301', 'Đà Nẵng', '2010-07-27', 1),
(00021, 'PKT', 'NV', 'Đinh Vô', 'Tiền', '1219820798016.png', '1947-05-18', 1, 2, '755 Ngô Quyền, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '755 Ngô Quyền, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', '01626365970', 'tontuanphuong2851@gmail.com', '201117928', 'Đà Nẵng', '2009-11-26', 2),
(00022, 'PKT', 'NV', 'Phan Hạ', 'Lâm', '1219820798010.png', '1967-07-17', 2, 3, '693A/42 Trần Cao Vân, Phường Thanh Khê Đông, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '693A/42 Trần Cao Vân, Phường Thanh Khê Đông, Quận Thanh Khê, Thành phố Đà Nẵng', '01246929299', 'daovanthanh9661@gmail.com', '201790798', 'Đà Nẵng', '2008-03-22', 2),
(00023, 'PDA', 'NV', 'Đăng Phi', 'Long', '1219820798017.png', '1968-02-26', 1, 2, '03 Trần Thanh Mại, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '03 Trần Thanh Mại, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', '01627908688', 'lephitien3051@gmail.com', '201820582', 'Vĩnh Long', '2012-02-25', 2),
(00024, 'PGD', 'NV', 'Dương Phương', 'Quá', '1219820798015.png', '1953-04-02', 1, 1, 'K5/500 Tôn Đản, Phường Hoà Phát, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K5/500 Tôn Đản, Phường Hoà Phát, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0915251298', 'lythanhchi6121@gmail.com', '201812686', 'Phú Yên', '2012-04-25', 2),
(00025, 'PDT', 'NV', 'Tôn Văn', 'Lâm', '1219820798012.png', '1970-02-28', 2, 1, 'Số 10 An Thượng 36, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Số 10 An Thượng 36, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0945659199', 'buituantien8641@gmail.com', '201261522', 'Đà Nẵng', '2009-11-17', 2),
(00026, 'PNS', 'NV', 'Dương Thị', 'Trí', '1219820798022.png', '1988-01-22', 2, 4, '74 Nguyễn Quyền, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '74 Nguyễn Quyền, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01634469344', 'phunghachau8321@gmail.com', '201933917', 'Đà Nẵng', '2008-08-16', 2),
(00027, 'PGD', 'NV', 'Hoàng Hạ', 'Nga', '1219820798006.png', '1941-06-20', 1, 1, '255 Hà Huy Tập, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '255 Hà Huy Tập, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '0965430098', 'laibinhtai4641@gmail.com', '201147892', 'Đà Nẵng', '2012-10-28', 1),
(00028, 'PIT', 'PP', 'Thanh', 'Mai Phương', '1219820798015.png', '1960-02-22', 1, 4, 'Lô 50-B1.108 Khu Đô Thị Sinh Thái Ven Sông Hòa Xuân, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 50-B1.108 Khu Đô Thị Sinh Thái Ven Sông Hòa Xuân, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01212988998', 'buivantien7241@gmail.com', '201450666', 'Đà Nẵng', '2012-06-24', 1),
(00029, 'PIT', 'NV', 'Lâm Mỹ', 'Tiền', '1219820798007.png', '1958-04-23', 1, 2, '454/4 Nguyễn Tri Phương, Phường Hoà Thuận Tây, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '454/4 Nguyễn Tri Phương, Phường Hoà Thuận Tây, Quận Hải Châu, Thành phố Đà Nẵng', '0979261480', 'vohungtai5481@gmail.com', '201013234', 'Đà Nẵng', '2008-05-18', 2),
(00030, 'PKT', 'NV', 'Dương Phi', 'Tuệ', '1219820798011.png', '1946-06-10', 2, 3, '395 Võ An Ninh, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '395 Võ An Ninh, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0974551998', 'dinhvotien7611@gmail.com', '201539317', 'Đà Nẵng', '2011-10-17', 2),
(00031, 'PKT', 'NV', 'Phan Hữu', 'Tài', '1219820798007.png', '1999-02-23', 1, 1, 'K434/23 Núi Thành, Phường Hoà Cường Nam, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K434/23 Núi Thành, Phường Hoà Cường Nam, Quận Hải Châu, Thành phố Đà Nẵng', '0947639057', 'phanhalam911@gmail.com', '201243329', 'Hoà Bình', '2012-07-28', 2),
(00032, 'PIT', 'NV', 'Trương Hưng', 'Trí', '1219820798019.png', '1996-06-13', 2, 3, '109 Mẹ Thứ, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '109 Mẹ Thứ, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01687860751', 'dangphilong3471@gmail.com', '201568082', 'Đà Nẵng', '2012-09-08', 1),
(00033, 'PIT', 'NV', 'Trương Hữu', 'Nga', '1219820798011.png', '1953-02-10', 1, 4, '13 An Thượng 31, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '13 An Thượng 31, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0912668622', 'duongphuongqua4401@gmail.com', '201869858', 'Đà Nẵng', '2008-11-04', 2),
(00034, 'PGD', 'PGD', 'Phạm Mỹ', 'Sơn', '1219820798019.png', '1996-11-04', 1, 2, '97/33 Cách Mạng Tháng Tám, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '97/33 Cách Mạng Tháng Tám, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0912237798', 'tonvanlam5991@gmail.com', '200946021', 'Đà Nẵng', '2012-04-23', 2),
(00035, 'PDT', 'PP', 'Châu', 'Triệu Hưng', '1219820798006.png', '1955-06-07', 1, 2, '1254 Xô Viết Nghệ Tĩnh, Phường Hoà Cường Nam, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '1254 Xô Viết Nghệ Tĩnh, Phường Hoà Cường Nam, Quận Hải Châu, Thành phố Đà Nẵng', '01662141998', 'duongthitri2951@gmail.com', '200941269', 'Đà Nẵng', '2010-05-02', 1),
(00036, 'PGD', 'NV', 'Lê Bình', 'Chí', '1219820798007.png', '1964-11-22', 2, 2, 'Số 10 An Thượng 36, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Số 10 An Thượng 36, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0904853941', 'hoanghanga7281@gmail.com', '201392565', 'Đà Nẵng', '2008-08-06', 2),
(00037, 'PGD', 'GD', 'Triệu Văn', 'Tiến', '1219820798005.png', '1977-05-02', 2, 1, 'K81/4 Trần Ngọc Sương, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K81/4 Trần Ngọc Sương, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0983681215', 'maiphuongthanh1811@gmail.com', '201130415', 'Long An', '2008-03-19', 2),
(00038, 'PGD', 'NV', 'Trương Phi', 'Phước', '1219820798011.png', '1993-10-29', 1, 1, '76 Nguyễn Sơn, Phường Hoà Cường Nam, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '76 Nguyễn Sơn, Phường Hoà Cường Nam, Quận Hải Châu, Thành phố Đà Nẵng', '0945014122', 'lammytien8661@gmail.com', '201826564', 'Đà Nẵng', '2010-03-01', 2),
(00039, 'PIT', 'NV', 'Bùi Phi', 'Tiền', '1219820798009.png', '1996-10-01', 1, 2, '09 Ngô Văn Sở, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', '09 Ngô Văn Sở, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', '01698550584', 'duongphitue6881@gmail.com', '201448393', 'Yên Bái', '2008-09-05', 1),
(00040, 'PNS', 'NV', 'Vương Thành', 'Sơn', '1219820798009.png', '1979-07-12', 2, 3, 'Lô 50- B2.1 Cụm dân cư phía Bắc Tu Viện Phao Lô, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 50- B2.1 Cụm dân cư phía Bắc Tu Viện Phao Lô, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0975223285', 'phanhuutai8601@gmail.com', '200838748', 'Đà Nẵng', '2012-12-07', 2),
(00041, 'PKT', 'NV', 'Đinh Tuấn', 'Tiền', '1219820798001.png', '1946-01-06', 1, 4, '31 Hà Bổng, Phường Phước Mỹ, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '31 Hà Bổng, Phường Phước Mỹ, Quận Sơn Trà, Thành phố Đà Nẵng', '0942429773', 'truonghungtri1651@gmail.com', '201991378', 'Tỉnh Lai Châu', '2010-02-04', 2),
(00042, 'PNS', 'TP', 'Lâm Tuấn', 'Trân', '1219820798010.png', '1928-12-17', 1, 4, 'Lô số 03-A3.5 Khu công viên Bắc Tượng Đài, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô số 03-A3.5 Khu công viên Bắc Tượng Đài, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', '0971413114', 'truonghuunga8531@gmail.com', '201474985', 'Đà Nẵng', '2011-11-12', 1),
(00043, 'PKT', 'NV', 'Lai Tuấn', 'Nga', '1219820798018.png', '1971-12-28', 2, 1, '73-75 Dương Đình Nghệ, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '73-75 Dương Đình Nghệ, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', '0989710068', 'phammyson1851@gmail.com', '201745755', 'Đà Nẵng', '2010-03-09', 1),
(00044, 'PIT', 'NV', 'Phùng Tuấn', 'Thảo', '1219820798022.png', '1959-04-04', 1, 1, '183 Hoàng Đức Lương, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '183 Hoàng Đức Lương, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', '0936127618', 'trieuhungchau3471@gmail.com', '201231558', 'Thừa Thiên Huế', '2008-10-15', 1),
(00045, 'PKT', 'NV', 'Đỗ Phi', 'Tuyền', '1219820798012.png', '1961-11-20', 2, 2, '288 Bế Văn Đàn, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '288 Bế Văn Đàn, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '0965938770', 'lebinhchi4011@gmail.com', '201392608', 'Đà Nẵng', '2009-01-01', 2),
(00046, 'PIT', 'NV', 'Trương Văn', 'Quá', '1219820798009.png', '1978-04-05', 1, 2, '216 Khúc Hạo, Phường Nại Hiên Đông, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '216 Khúc Hạo, Phường Nại Hiên Đông, Quận Sơn Trà, Thành phố Đà Nẵng', '01234053369', 'trieuvantien551@gmail.com', '201529531', 'Đà Nẵng', '2009-03-25', 2),
(00047, 'PIT', 'NV', 'Triệu Thị', 'Nga', '1219820798014.png', '1936-03-03', 1, 1, 'K634/73/32 Trưng Nữ Vương, Phường Hoà Thuận Tây, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K634/73/32 Trưng Nữ Vương, Phường Hoà Thuận Tây, Quận Hải Châu, Thành phố Đà Nẵng', '0917911310', 'truongphiphuoc2441@gmail.com', '200887650', 'Hà Giang', '2008-07-17', 1),
(00048, 'PKT', 'NV', 'Đỗ Văn', 'Chí', '1219820798004.png', '1944-09-16', 2, 3, '472 Ngô Quyền, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '472 Ngô Quyền, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', '0902140298', 'buiphitien4031@gmail.com', '201205466', 'Đà Nẵng', '2010-09-26', 1),
(00049, 'PGD', 'NV', 'Bùi Thành', 'Lâm', '1219820798004.png', '1950-04-17', 1, 3, '1999 Nguyễn Tất Thành, Phường Thanh Khê Tây, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '1999 Nguyễn Tất Thành, Phường Thanh Khê Tây, Quận Thanh Khê, Thành phố Đà Nẵng', '0922063883', 'vuongthanhson8921@gmail.com', '201860426', 'Quảng Ngãi', '2010-01-19', 2),
(00050, 'PIT', 'NV', 'Dương Hữu', 'Nguyệt', '1219820798012.png', '1942-10-25', 1, 4, 'Nhà số A2.7, Khu biệt thự Đảo Xanh, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Nhà số A2.7, Khu biệt thự Đảo Xanh, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', '0915109597', 'dinhtuantien6881@gmail.com', '201987229', 'Đà Nẵng', '2010-05-23', 1),
(00051, 'PDA', 'NV', 'Đoàn Thị', 'Đạt', '1219820798003.png', '1948-09-13', 1, 4, '43 Trần Quý Cáp, Phường Thạch Thang, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '43 Trần Quý Cáp, Phường Thạch Thang, Quận Hải Châu, Thành phố Đà Nẵng', '0968882266', 'lamtuantran3441@gmail.com', '200880132', 'Vĩnh Long', '2010-10-10', 2),
(00052, 'PDA', 'NV', 'Lê Phương', 'Trí', '1219820798001.png', '1961-08-04', 2, 2, 'K233/27 Trưng Nữ Vương, Phường Hoà Thuận Đông, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K233/27 Trưng Nữ Vương, Phường Hoà Thuận Đông, Quận Hải Châu, Thành phố Đà Nẵng', '0904770000', 'laituannga2941@gmail.com', '201134414', 'Đà Nẵng', '2009-09-15', 2),
(00053, 'PNS', 'NV', 'Trần Thành', 'Linh', '1219820798019.png', '1926-08-21', 1, 4, '112 Hải Hồ, Phường Thanh Bình, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '112 Hải Hồ, Phường Thanh Bình, Quận Hải Châu, Thành phố Đà Nẵng', '0986451062', 'phungtuanthao7001@gmail.com', '200928000', 'Tỉnh Phú Thọ', '2010-05-07', 1),
(00054, 'PGD', 'PGD', 'Hoàng Phục', 'Nguyệt', '1219820798012.png', '1994-01-24', 2, 2, '190 Phạm Cự Lượng, Phường An Hải Đông, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '190 Phạm Cự Lượng, Phường An Hải Đông, Quận Sơn Trà, Thành phố Đà Nẵng', '01676013809', 'dophituyen3011@gmail.com', '201413502', 'Lạng Sơn', '2008-12-09', 2),
(00055, 'PDT', 'NV', 'Đinh Phi', 'Quang', '1219820798001.png', '1957-05-07', 2, 1, '21/3 Yên Bái, Phường Hải Châu I, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '21/3 Yên Bái, Phường Hải Châu I, Quận Hải Châu, Thành phố Đà Nẵng', '01668603473', 'truongvanqua2081@gmail.com', '201900150', 'Quảng Bình', '2010-08-25', 2),
(00056, 'PDT', 'TP', 'Thành', 'Đăng Bình', '1219820798010.png', '1974-09-29', 2, 2, '21 Phan Tốn, Phường Hoà Quý, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '21 Phan Tốn, Phường Hoà Quý, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0977039598', 'trieuthinga8971@gmail.com', '200990430', 'Bắc Ninh', '2010-08-03', 1),
(00057, 'PKT', 'TP', 'Quá', 'Triệu Thành', '1219820798002.png', '1951-05-03', 2, 1, 'Lô 12 Phước Trường 16, Phường Phước Mỹ, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 12 Phước Trường 16, Phường Phước Mỹ, Quận Sơn Trà, Thành phố Đà Nẵng', '01685388927', 'dovanchi4531@gmail.com', '201183364', 'Đà Nẵng', '2011-05-01', 1),
(00058, 'PIT', 'NV', 'Đoàn Thị', 'Long', '1219820798006.png', '1959-05-21', 2, 1, 'K408/17/21 Tôn Đản, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K408/17/21 Tôn Đản, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0989633435', 'buithanhlam6911@gmail.com', '200839404', 'Hà Nam', '2010-10-12', 1),
(00059, 'PKT', 'NV', 'Phạm Thành', 'Bách', '1219820798003.png', '1995-07-02', 2, 2, '36 Sơn Thủy 3, Phường Hoà Hải, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '36 Sơn Thủy 3, Phường Hoà Hải, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '01242598906', 'duonghuunguyet6031@gmail.com', '201626856', 'Tỉnh Lai Châu', '2011-06-08', 1),
(00060, 'PGD', 'PGD', 'Trần Vô', 'Phúc', '1219820798014.png', '1956-06-28', 1, 1, '472 Ngô Quyền, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '472 Ngô Quyền, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', '01632689968', 'doanthidat1431@gmail.com', '201072027', 'Đà Nẵng', '2009-09-21', 1),
(00061, 'PIT', 'NV', 'Trần Tuấn', 'Chí', '1219820798005.png', '1983-12-14', 2, 2, '109 Mẹ Thứ, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '109 Mẹ Thứ, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01278971998', 'lephuongtri171@gmail.com', '201728701', 'Đà Nẵng', '2010-03-06', 1),
(00062, 'PIT', 'NV', 'Triệu Hạ', 'Trân', '1219820798005.png', '1982-03-12', 2, 2, '375/31 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '375/31 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '0906200838', 'tranthanhlinh6911@gmail.com', '201905722', 'Đà Nẵng', '2010-06-02', 1),
(00063, 'PNS', 'NV', 'Lý Hạ', 'Long', '1219820798012.png', '1962-08-08', 2, 3, 'Kiệt A379/6 Tôn Đản, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Kiệt A379/6 Tôn Đản, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0915165989', 'hoangphucnguyet7731@gmail.com', '201338393', 'Đà Nẵng', '2008-02-15', 2),
(00064, 'PIT', 'NV', 'Trương Vô', 'Nguyệt', '1219820798008.png', '1938-03-02', 2, 2, '23 Trịnh Lỗi, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '23 Trịnh Lỗi, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0982343267', 'dinhphiquang5661@gmail.com', '201398932', 'Đà Nẵng', '2012-03-02', 1),
(00065, 'PIT', 'NV', 'Đỗ Hưng', 'Lâm', '1219820798022.png', '1959-02-04', 2, 3, '37 Hà Huy Tập, Phường Xuân Hà, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '37 Hà Huy Tập, Phường Xuân Hà, Quận Thanh Khê, Thành phố Đà Nẵng', '01669954165', 'dangbinhthanh2551@gmail.com', '201057001', 'Tỉnh Bắc Kạn', '2008-02-16', 1),
(00066, 'PDA', 'NV', 'Trần Phục', 'Phục', '1219820798008.png', '1966-10-18', 1, 4, '111 Thế Lữ, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '111 Thế Lữ, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', '0966593219', 'trieuthanhqua4311@gmail.com', '201932448', 'Đà Nẵng', '2008-10-20', 1),
(00067, 'PNS', 'NV', 'Dương Mỹ', 'Quân', '1219820798010.png', '1960-05-18', 2, 4, '375/31 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '375/31 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '0904188855', 'doanthilong5361@gmail.com', '201869729', 'Bình Dương', '2011-10-25', 2),
(00068, 'PDA', 'NV', 'Trương Phi', 'Chí', '1219820798015.png', '1930-08-09', 1, 3, 'Lô A11-1, đường số 4, Khu công nghệ cao Đà Nẵng, Xã Hoà Liên, Huyện Hoà Vang, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô A11-1, đường số 4, Khu công nghệ cao Đà Nẵng, Xã Hoà Liên, Huyện Hoà Vang, Thành phố Đà Nẵng', '0948700098', 'phamthanhbach671@gmail.com', '201254054', 'Tỉnh Bắc Kạn', '2012-12-15', 1),
(00069, 'PDT', 'NV', 'Đăng Mỹ', 'Phúc', '1219820798015.png', '1951-06-21', 2, 4, '34 Lỗ Giáng 16, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '34 Lỗ Giáng 16, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0911400831', 'tranvophuc6021@gmail.com', '201526246', 'Đà Nẵng', '2010-09-18', 1),
(00070, 'PDA', 'NV', 'Lai Vô', 'Trân', '1219820798015.png', '1992-08-10', 1, 3, 'K03/09 Dũng Sĩ Thanh Khê, Phường Thanh Khê Tây, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K03/09 Dũng Sĩ Thanh Khê, Phường Thanh Khê Tây, Quận Thanh Khê, Thành phố Đà Nẵng', '01643014832', 'trantuanchi6491@gmail.com', '201008530', 'Đà Nẵng', '2010-12-14', 1),
(00071, 'PKT', 'NV', 'Đăng Phương', 'Đạt', '1219820798011.png', '1925-01-29', 1, 4, 'Lô 39 Đường Sơn Thủy 12, Phường Hoà Hải, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 39 Đường Sơn Thủy 12, Phường Hoà Hải, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '01674876709', 'trieuhatran5111@gmail.com', '201610794', 'Tỉnh Phú Thọ', '2011-09-12', 2),
(00072, 'PIT', 'NV', 'Phan Vô', 'Phúc', '1219820798004.png', '1978-07-22', 1, 1, '09 Ngô Văn Sở, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', '09 Ngô Văn Sở, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', '01249919515', 'lyhalong6511@gmail.com', '201119410', 'Bắc Giang', '2012-12-19', 1),
(00073, 'PDT', 'NV', 'Phùng Thành', 'Nga', '1219820798016.png', '1929-12-05', 2, 4, '89 Hà Mục, Tổ 55, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '89 Hà Mục, Tổ 55, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0912933156', 'truongvonguyet9761@gmail.com', '201953901', 'Đà Nẵng', '2008-07-21', 2),
(00074, 'PKT', 'NV', 'Phan Hữu', 'Đạt', '1219820798016.png', '1959-06-16', 1, 3, '1999 Nguyễn Tất Thành, Phường Thanh Khê Tây, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '1999 Nguyễn Tất Thành, Phường Thanh Khê Tây, Quận Thanh Khê, Thành phố Đà Nẵng', '0946859486', 'dohunglam7281@gmail.com', '201514365', 'Đà Nẵng', '2008-03-03', 1),
(00075, 'PNS', 'NV', 'Lê Tuấn', 'Thanh', '1219820798007.png', '1938-03-08', 2, 2, '152/6 Lý Tự Trọng, Phường Thuận Phước, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '152/6 Lý Tự Trọng, Phường Thuận Phước, Quận Hải Châu, Thành phố Đà Nẵng', '0969352395', 'tranphucphuc8091@gmail.com', '200824865', 'Lạng Sơn', '2012-01-29', 2),
(00076, 'PDA', 'NV', 'Bùi Phương', 'Thành', '1219820798002.png', '1986-12-22', 2, 1, '108 Trần Huy Liệu, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '108 Trần Huy Liệu, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01278913923', 'duongmyquan9621@gmail.com', '201061140', 'Kon Tum', '2010-05-01', 2),
(00077, 'PIT', 'NV', 'Phan Thành', 'Tiền', '1219820798009.png', '1958-02-18', 2, 3, '12 Nam Thọ 2, Phường Thọ Quang, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '12 Nam Thọ 2, Phường Thọ Quang, Quận Sơn Trà, Thành phố Đà Nẵng', '0941076889', 'truongphichi3051@gmail.com', '201660295', 'Đà Nẵng', '2011-08-23', 1),
(00078, 'PNS', 'NV', 'Lâm Hạ', 'Sơn', '1219820798001.png', '1950-01-06', 1, 4, '31 Trần Phú, Phường Hải Châu I, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '31 Trần Phú, Phường Hải Châu I, Quận Hải Châu, Thành phố Đà Nẵng', '01234641998', 'dangmyphuc8341@gmail.com', '201968726', 'Đà Nẵng', '2010-10-21', 1),
(00079, 'PDA', 'NV', 'Võ Văn', 'Linh', '1219820798010.png', '1958-04-04', 2, 3, 'K340/9 Nguyễn Tri Phương, Phường Hoà Thuận Tây, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K340/9 Nguyễn Tri Phương, Phường Hoà Thuận Tây, Quận Hải Châu, Thành phố Đà Nẵng', '0946204772', 'laivotran2961@gmail.com', '201867586', 'Cao Bằng', '2009-03-22', 2),
(00080, 'PNS', 'NV', 'Võ Thị', 'Ngân', '1219820798019.png', '1927-06-14', 2, 4, 'Số 35 Thái Phiên, Phường Phước Ninh, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Số 35 Thái Phiên, Phường Phước Ninh, Quận Hải Châu, Thành phố Đà Nẵng', '01234952498', 'dangphuongdat6431@gmail.com', '201263979', 'Sơn La', '2010-09-21', 2),
(00081, 'PDT', 'NV', 'Phan Phi', 'Quá', '1219820798012.png', '1997-12-16', 1, 2, '40A Nguyễn Thiện Kế, Phường An Hải Đông, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '40A Nguyễn Thiện Kế, Phường An Hải Đông, Quận Sơn Trà, Thành phố Đà Nẵng', '01213057124', 'phanvophuc81@gmail.com', '201679205', 'Quảng Nam', '2012-10-20', 1),
(00082, 'PDA', 'NV', 'Lê Bình', 'Sơn', '1219820798009.png', '1961-10-09', 1, 2, '91 Ngô Nhân Tịnh, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '91 Ngô Nhân Tịnh, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0995476010', 'phungthanhnga2211@gmail.com', '201880516', 'Đồng Tháp', '2010-09-09', 2),
(00083, 'PIT', 'NV', 'Lý Văn', 'Linh', '1219820798003.png', '1942-01-13', 1, 3, 'K434/23 Núi Thành, Phường Hoà Cường Nam, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K434/23 Núi Thành, Phường Hoà Cường Nam, Quận Hải Châu, Thành phố Đà Nẵng', '0985426898', 'phanhuudat5211@gmail.com', '201746656', 'Ninh Thuận', '2011-06-08', 1),
(00084, 'PNS', 'NV', 'Trần Phi', 'Phục', '1219820798007.png', '1956-06-23', 1, 4, 'Lô D8-108 Khu dân cư đô thị mới nam cầu Cẩm Lệ, Xã Hoà Phước, Huyện Hoà Vang, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô D8-108 Khu dân cư đô thị mới nam cầu Cẩm Lệ, Xã Hoà Phước, Huyện Hoà Vang, Thành phố Đà Nẵng', '01239173861', 'letuanthanh1941@gmail.com', '201977463', 'Đà Nẵng', '2012-10-18', 2),
(00085, 'PDA', 'NV', 'Đào Thành', 'Tăng', '1219820798009.png', '1954-10-21', 1, 1, '152/40B Phan Thanh, Phường Thạc Gián, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '152/40B Phan Thanh, Phường Thạc Gián, Quận Thanh Khê, Thành phố Đà Nẵng', '01682567595', 'buiphuongthanh6451@gmail.com', '201585397', 'Đà Nẵng', '2012-03-20', 2),
(00086, 'PKT', 'PP', 'Tài', 'Lâm Thị', '1219820798005.png', '1945-04-07', 1, 1, '281 Đoàn Khuê, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '281 Đoàn Khuê, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0982214775', 'phanthanhtien851@gmail.com', '201121396', 'Đà Nẵng', '2012-05-08', 1),
(00087, 'PDT', 'NV', 'Dương Phục', 'Bách', '1219820798003.png', '1933-12-13', 1, 4, 'K634/73/32 Trưng Nữ Vương, Phường Hoà Thuận Tây, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K634/73/32 Trưng Nữ Vương, Phường Hoà Thuận Tây, Quận Hải Châu, Thành phố Đà Nẵng', '0942705296', 'lamhason391@gmail.com', '201742447', 'Thừa Thiên Huế', '2010-09-23', 1),
(00088, 'PDT', 'NV', 'Trương Bình', 'Mạnh', '1219820798011.png', '1968-04-16', 1, 3, '93 Phạm Nhữ Tăng, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '93 Phạm Nhữ Tăng, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '0962880082', 'vovanlinh5851@gmail.com', '201511143', 'Bà Rịa - Vũng Tàu', '2009-08-18', 2),
(00089, 'PIT', 'NV', 'Lê Hưng', 'Trân', '1219820798021.png', '1955-11-27', 2, 2, 'Số 54 Nguyễn Thiếp, Phường An Hải Tây, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Số 54 Nguyễn Thiếp, Phường An Hải Tây, Quận Sơn Trà, Thành phố Đà Nẵng', '0976698784', 'vothingan5501@gmail.com', '201646309', 'Trà Vinh', '2012-08-07', 2),
(00090, 'PDA', 'NV', 'Lâm Vô', 'Thảo', '1219820798003.png', '1960-08-17', 2, 2, 'Lô B2-13-30 Khu đô thị Phước Lý, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô B2-13-30 Khu đô thị Phước Lý, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', '0975981998', 'phanphiqua5511@gmail.com', '201180378', 'Long An', '2012-10-13', 1),
(00091, 'PNS', 'NV', 'Phùng Phục', 'Tuyền', '1219820798005.png', '1985-12-12', 2, 2, '27 Nguyễn Minh Không, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', '27 Nguyễn Minh Không, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', '0964663020', 'lebinhson7181@gmail.com', '200893675', 'Cần Thơ', '2008-01-01', 1),
(00092, 'PKT', 'NV', 'Nguyễn Văn', 'Tăng', '1219820798008.png', '1934-10-29', 2, 4, '375/31 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '375/31 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '01665595959', 'lyvanlinh1381@gmail.com', '201183153', 'Thanh Hóa', '2010-05-29', 1),
(00093, 'PDT', 'NV', 'Đào Thị', 'Thanh', '1219820798005.png', '1945-01-18', 2, 3, 'K72/32 Ngọc Hân, Phường An Hải Tây, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K72/32 Ngọc Hân, Phường An Hải Tây, Quận Sơn Trà, Thành phố Đà Nẵng', '0978822321', 'tranphiphuc9311@gmail.com', '200891995', 'Đà Nẵng', '2008-05-11', 1),
(00094, 'PNS', 'NV', 'Tôn Mỹ', 'Phương', '1219820798004.png', '1980-12-02', 2, 2, '115 Trần Văn Ơn, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '115 Trần Văn Ơn, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0982113700', 'daothanhtang5731@gmail.com', '201386670', 'Đà Nẵng', '2012-10-27', 1),
(00095, 'PNS', 'NV', 'Dương Thị', 'Thảo', '1219820798004.png', '1931-07-24', 1, 3, '18 Điện Biên Phủ, Phường Chính Gián, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '18 Điện Biên Phủ, Phường Chính Gián, Quận Thanh Khê, Thành phố Đà Nẵng', '0983379481', 'lamthitai1391@gmail.com', '201999940', 'Nghệ An', '2011-07-17', 1),
(00096, 'PKT', 'NV', 'Phan Thành', 'Thanh', '1219820798001.png', '1939-10-18', 1, 4, '372/51 Phan Châu Trinh, Phường Bình Thuận, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '372/51 Phan Châu Trinh, Phường Bình Thuận, Quận Hải Châu, Thành phố Đà Nẵng', '0983341998', 'duongphucbach1871@gmail.com', '201439684', 'Nam Định', '2009-06-27', 2),
(00097, 'PNS', 'NV', 'Vương Thành', 'Thành', '1219820798009.png', '1995-03-10', 2, 4, '64 Lê Văn Hưu, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '64 Lê Văn Hưu, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0936014607', 'truongbinhmanh7761@gmail.com', '201434101', 'Đà Nẵng', '2009-08-08', 1),
(00098, 'PDT', 'NV', 'Đỗ Phi', 'Châu', '1219820798019.png', '1941-11-26', 2, 3, 'Lô số 03-A3.5 Khu công viên Bắc Tượng Đài, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô số 03-A3.5 Khu công viên Bắc Tượng Đài, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', '0962508119', 'lehungtran9091@gmail.com', '201209723', 'Đà Nẵng', '2011-06-20', 1),
(00099, 'PNS', 'NV', 'Võ Phi', 'Tuệ', '1219820798011.png', '1964-08-04', 2, 3, 'Lô A-110 KDC dọc tuyến đường Trường Sa, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô A-110 KDC dọc tuyến đường Trường Sa, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', '01648346758', 'lamvothao9011@gmail.com', '201609313', 'Đà Nẵng', '2011-04-16', 2),
(00100, 'PNS', 'NV', 'Đoàn Văn', 'Đạt', '1219820798010.png', '1970-09-20', 1, 2, 'K166/17 Nguyễn Lương Bằng, Phường Hoà Khánh Bắc, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K166/17 Nguyễn Lương Bằng, Phường Hoà Khánh Bắc, Quận Liên Chiểu, Thành phố Đà Nẵng', '01635468595', 'phungphuctuyen1241@gmail.com', '200927611', 'Đà Nẵng', '2011-05-16', 1),
(00101, 'PDA', 'PP', 'Thanh', 'Phan Văn', '1219820798017.png', '1966-05-12', 2, 3, '247 Nguyễn Sắc Kim, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '247 Nguyễn Sắc Kim, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01652574253', 'nguyenvantang7191@gmail.com', '200919737', 'Đà Nẵng', '2012-09-03', 1),
(00102, 'PNS', 'NV', 'Phan Thành', 'Linh', '1219820798015.png', '1972-02-09', 1, 1, '240 Phan Đăng Lưu, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '240 Phan Đăng Lưu, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', '0985572067', 'daothithanh841@gmail.com', '201503257', 'Đà Nẵng', '2011-02-23', 2),
(00103, 'PDT', 'NV', 'Vương Văn', 'Thanh', '1219820798019.png', '1957-02-18', 2, 2, 'K149/69 Lê Đình Lý, Phường Hoà Thuận Đông, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K149/69 Lê Đình Lý, Phường Hoà Thuận Đông, Quận Hải Châu, Thành phố Đà Nẵng', '0949953592', 'tonmyphuong8901@gmail.com', '201240487', 'Nghệ An', '2011-04-23', 1),
(00104, 'PDT', 'NV', 'Lê Vô', 'Trân', '1219820798007.png', '1940-02-22', 2, 1, 'K394/7 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K394/7 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '0946528666', 'duongthithao2051@gmail.com', '201409646', 'Đà Nẵng', '2012-10-03', 1),
(00105, 'PNS', 'NV', 'Hoàng Vô', 'Chí', '1219820798015.png', '1996-10-12', 1, 4, 'Lô 11 khu phức hợp dịch vụ thương mại, chung cư và đất ở, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 11 khu phức hợp dịch vụ thương mại, chung cư và đất ở, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', '0962925258', 'phanthanhthanh2951@gmail.com', '201386740', 'Hà Giang', '2009-07-04', 1),
(00106, 'PDA', 'NV', 'Đỗ Hạ', 'Trí', '1219820798003.png', '1971-06-16', 1, 4, '37 Cẩm Bắc 4, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '37 Cẩm Bắc 4, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01658006028', 'vuongthanhthanh2751@gmail.com', '200866912', 'Tiền Giang', '2009-05-28', 1),
(00107, 'PNS', 'NV', 'Phan Thành', 'Phúc', '1219820798001.png', '1949-09-15', 2, 4, 'Lô 6 Khu B2-2 KDC phía nam sông quá giáng, Xã Hoà Phước, Huyện Hoà Vang, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 6 Khu B2-2 KDC phía nam sông quá giáng, Xã Hoà Phước, Huyện Hoà Vang, Thành phố Đà Nẵng', '01266062579', 'dophichau7471@gmail.com', '201088957', 'Quảng Ninh', '2010-07-09', 1),
(00108, 'PDA', 'NV', 'Triệu Thành', 'Trân', '1219820798002.png', '1993-07-19', 2, 2, '20 Nguyễn Tạo, Phường Hoà Hải, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '20 Nguyễn Tạo, Phường Hoà Hải, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0944170598', 'vophitue5531@gmail.com', '201826529', 'Đà Nẵng', '2009-06-27', 2),
(00109, 'PDA', 'NV', 'Nguyễn Thành', 'Thanh', '1219820798017.png', '1982-01-11', 2, 1, 'K3/20 Hà Văn Trí, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K3/20 Hà Văn Trí, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01236861827', 'doanvandat1361@gmail.com', '201805121', 'Đà Nẵng', '2008-12-01', 2),
(00110, 'PIT', 'NV', 'Hoàng Phục', 'Châu', '1219820798022.png', '1944-11-15', 1, 3, '79 Hồ Tùng Mậu, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', '79 Hồ Tùng Mậu, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', '01266129070', 'phanvanthanh8951@gmail.com', '201250295', 'Quảng Bình', '2011-11-26', 1),
(00111, 'PDT', 'NV', 'Đỗ Phương', 'Thanh', '1219820798008.png', '1928-10-22', 2, 4, 'Lô 61-62 B2.15 An Thượng 26, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 61-62 B2.15 An Thượng 26, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0902226268', 'phanthanhlinh951@gmail.com', '201080046', 'Bến Tre', '2008-05-28', 1),
(00112, 'PKT', 'NV', 'Phùng Phục', 'Trí', '1219820798022.png', '1995-06-04', 2, 2, '23 Nại Nghĩa 3, Phường Nại Hiên Đông, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '23 Nại Nghĩa 3, Phường Nại Hiên Đông, Quận Sơn Trà, Thành phố Đà Nẵng', '0982570551', 'vuongvanthanh9171@gmail.com', '201653877', 'Đà Nẵng', '2011-03-05', 1),
(00113, 'PDT', 'NV', 'Đồng Hạ', 'Tiền', '1219820798012.png', '1925-06-11', 2, 4, '689 Nguyễn Tất Thành, Phường Xuân Hà, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '689 Nguyễn Tất Thành, Phường Xuân Hà, Quận Thanh Khê, Thành phố Đà Nẵng', '0986305162', 'levotran9161@gmail.com', '201045432', 'Sóc Trăng', '2009-04-10', 2),
(00114, 'PKT', 'NV', 'Đăng Hưng', 'Ngân', '1219820798014.png', '1996-08-27', 1, 2, 'Lô 11 khu phức hợp dịch vụ thương mại, chung cư và đất ở, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 11 khu phức hợp dịch vụ thương mại, chung cư và đất ở, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', '01213150798', 'hoangvochi1351@gmail.com', '201073591', 'Cà Mau', '2009-02-06', 1),
(00115, 'PDA', 'NV', 'Trương Thị', 'Tài', '1219820798015.png', '1982-11-10', 2, 4, 'Số 1, đường An Cư 1, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Số 1, đường An Cư 1, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', '0965028269', 'dohatri2181@gmail.com', '200919892', 'Tỉnh Bắc Kạn', '2009-03-27', 2),
(00116, 'PDA', 'NV', 'Đoàn Thị', 'Đạt', '1219820798015.png', '1968-04-19', 1, 2, 'K3/20 Hà Văn Trí, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K3/20 Hà Văn Trí, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01222285400', 'phanthanhphuc9691@gmail.com', '201633157', 'Đà Nẵng', '2008-07-21', 2),
(00117, 'PNS', 'NV', 'Đồng Văn', 'Tiền', '1219820798001.png', '1968-06-01', 2, 4, '597 Trường Chinh, Phường Hoà Phát, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '597 Trường Chinh, Phường Hoà Phát, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01677756081', 'trieuthanhtran3391@gmail.com', '201705630', 'Đà Nẵng', '2009-11-21', 2),
(00118, 'PNS', 'NV', 'Hoàng Phục', 'Ngân', '1219820798006.png', '1984-08-24', 2, 4, '99A Hà Huy Tập, Phường Chính Gián, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '99A Hà Huy Tập, Phường Chính Gián, Quận Thanh Khê, Thành phố Đà Nẵng', '01223386688', 'nguyenthanhthanh451@gmail.com', '201248273', 'Thừa Thiên Huế', '2012-02-28', 2),
(00119, 'PGD', 'PGD', 'Hoàng Hữu', 'Phước', '1219820798014.png', '1986-11-26', 2, 3, '13 An Thượng 31, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '13 An Thượng 31, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '01662710266', 'hoangphucchau1301@gmail.com', '200939511', 'Thừa Thiên Huế', '2009-12-02', 1),
(00120, 'PDT', 'NV', 'Lý Thị', 'Long', '1219820798006.png', '1955-02-01', 1, 2, '30A đường Nguyễn Tri Phương, Phường Chính Gián, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '30A đường Nguyễn Tri Phương, Phường Chính Gián, Quận Thanh Khê, Thành phố Đà Nẵng', '0914948269', 'dophuongthanh5361@gmail.com', '201416589', 'Đà Nẵng', '2012-02-28', 2),
(00121, 'PIT', 'NV', 'Lý Phi', 'Phục', '1219820798021.png', '1969-07-13', 2, 3, '108 Trần Huy Liệu, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '108 Trần Huy Liệu, Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0973150498', 'phungphuctri2901@gmail.com', '201034528', 'Đà Nẵng', '2011-06-27', 2),
(00122, 'PIT', 'NV', 'Nguyễn Phương', 'Thành', '1219820798014.png', '1971-01-25', 2, 1, 'Lô A68, Đường 30 Tháng 4, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô A68, Đường 30 Tháng 4, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', '01638300419', 'donghatien6421@gmail.com', '201903161', 'Bình Dương', '2010-07-16', 1),
(00123, 'PDT', 'NV', 'Võ Phục', 'Mạnh', '1219820798002.png', '1982-12-16', 1, 2, '09 Ngô Văn Sở, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', '09 Ngô Văn Sở, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', '0942251998', 'danghungngan4361@gmail.com', '200881147', 'Đà Nẵng', '2011-11-27', 1),
(00124, 'PNS', 'PP', 'Long', 'Lý Bình', '1219820798021.png', '1935-05-01', 2, 4, '65 Ngô Thị Liễu, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '65 Ngô Thị Liễu, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', '0904893181', 'truongthitai7821@gmail.com', '201681129', 'Đà Nẵng', '2010-04-04', 1),
(00125, 'PKT', 'NV', 'Trương Thành', 'Mạnh', '1219820798008.png', '1962-12-19', 1, 1, 'K424/H19/08 Ông Ích Khiêm, Phường Vĩnh Trung, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K424/H19/08 Ông Ích Khiêm, Phường Vĩnh Trung, Quận Thanh Khê, Thành phố Đà Nẵng', '01234555424', 'doanthidat8531@gmail.com', '201476209', 'Đà Nẵng', '2008-09-28', 1),
(00126, 'PNS', 'NV', 'Đồng Phi', 'Tuệ', '1219820798007.png', '1983-08-03', 2, 1, '388 Trần Hưng Đạo, Phường An Hải Tây, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '388 Trần Hưng Đạo, Phường An Hải Tây, Quận Sơn Trà, Thành phố Đà Nẵng', '0902319019', 'dongvantien1321@gmail.com', '200850659', 'Đà Nẵng', '2011-01-14', 2),
(00127, 'PKT', 'NV', 'Tôn Phương', 'Thanh', '1219820798012.png', '1966-02-20', 2, 3, 'K5/500 Tôn Đản, Phường Hoà Phát, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K5/500 Tôn Đản, Phường Hoà Phát, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0916183036', 'hoangphucngan4741@gmail.com', '201145118', 'Kon Tum', '2012-04-05', 2),
(00128, 'PIT', 'NV', 'Hoàng Thị', 'Phước', '1219820798009.png', '1944-04-27', 2, 2, '260 Lê Văn Hiến, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '260 Lê Văn Hiến, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0982171823', 'hoanghuuphuoc7361@gmail.com', '201694279', 'Bắc Giang', '2012-08-19', 1),
(00129, 'PKT', 'NV', 'Võ Văn', 'Trân', '1219820798018.png', '1942-04-12', 2, 1, '57/K1/4 Đường Hòa An 19, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '57/K1/4 Đường Hòa An 19, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0913347176', 'lythilong2911@gmail.com', '201548990', 'Đà Nẵng', '2009-08-18', 1),
(00130, 'PIT', 'NV', 'Lý Hữu', 'Trí', '1219820798005.png', '1988-09-18', 2, 3, '103 Vũ Quỳnh, Phường Thanh Khê Tây, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '103 Vũ Quỳnh, Phường Thanh Khê Tây, Quận Thanh Khê, Thành phố Đà Nẵng', '0995919963', 'lyphiphuc2331@gmail.com', '201225972', 'Đà Nẵng', '2009-09-22', 1),
(00131, 'PIT', 'NV', 'Phan Hưng', 'Nghĩa', '1219820798002.png', '1959-08-23', 1, 3, '35 Trần Thủ Độ , Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '35 Trần Thủ Độ , Phường Khuê Trung, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01273008666', 'nguyenphuongthanh9611@gmail.com', '201195693', 'Hồ Chí Minh', '2012-02-19', 2),
(00132, 'PIT', 'NV', 'Trần Văn', 'Lâm', '1219820798006.png', '1943-06-24', 1, 4, '43 Trần Quý Cáp, Phường Thạch Thang, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '43 Trần Quý Cáp, Phường Thạch Thang, Quận Hải Châu, Thành phố Đà Nẵng', '0932319898', 'vophucmanh3581@gmail.com', '201001812', 'Phú Yên', '2010-11-18', 1),
(00133, 'PDA', 'NV', 'Phùng Hữu', 'Quang', '1219820798009.png', '1974-08-28', 2, 1, '15 An Thượng 27, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '15 An Thượng 27, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0912184410', 'lybinhlong2441@gmail.com', '201815584', 'Đà Nẵng', '2011-11-11', 1),
(00134, 'PIT', 'NV', 'Đinh Vô', 'Châu', '1219820798015.png', '1978-06-13', 2, 4, '240 Phan Đăng Lưu, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '240 Phan Đăng Lưu, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', '0913316667', 'truongthanhmanh7201@gmail.com', '201313002', 'Đà Nẵng', '2011-08-13', 1),
(00135, 'PDA', 'NV', 'Đào Tuấn', 'Tuyền', '1219820798009.png', '1968-01-29', 2, 2, '572/92 Ông Ích Khiêm, Phường Hải Châu II, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '572/92 Ông Ích Khiêm, Phường Hải Châu II, Quận Hải Châu, Thành phố Đà Nẵng', '0983554498', 'dongphitue1541@gmail.com', '201714038', 'Kiên Giang', '2010-04-02', 2),
(00136, 'PDA', 'NV', 'Lâm Thị', 'Châu', '1219820798006.png', '1925-03-27', 1, 3, '215/52 Hà Huy Tập, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '215/52 Hà Huy Tập, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '01669445319', 'tonphuongthanh6161@gmail.com', '201638561', 'Bà Rịa - Vũng Tàu', '2008-04-19', 2),
(00137, 'PNS', 'NV', 'Lý Thành', 'Linh', '1219820798001.png', '1940-10-04', 2, 1, '103 Vũ Quỳnh, Phường Thanh Khê Tây, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '103 Vũ Quỳnh, Phường Thanh Khê Tây, Quận Thanh Khê, Thành phố Đà Nẵng', '01693039959', 'hoangthiphuoc3111@gmail.com', '200821530', 'Sóc Trăng', '2012-11-02', 2),
(00138, 'PDA', 'NV', 'Tôn Hưng', 'Phúc', '1219820798020.png', '1926-06-03', 2, 3, '76 Nguyễn Sơn, Phường Hoà Cường Nam, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '76 Nguyễn Sơn, Phường Hoà Cường Nam, Quận Hải Châu, Thành phố Đà Nẵng', '01234005598', 'vovantran8741@gmail.com', '201849815', 'Vĩnh Long', '2008-01-01', 1),
(00139, 'PDT', 'NV', 'Lai Thị', 'Chí', '1219820798007.png', '1978-09-16', 1, 2, '317/60 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '317/60 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '01214121722', 'lyhuutri3441@gmail.com', '200991234', 'Nam Định', '2009-12-14', 1),
(00140, 'PDT', 'NV', 'Tôn Hưng', 'Phương', '1219820798015.png', '1940-10-25', 2, 4, '85 Khương Hữu Dụng, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '85 Khương Hữu Dụng, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0979771674', 'phanhungnghia5231@gmail.com', '201020121', 'Quảng Ninh', '2008-10-19', 1),
(00141, 'PKT', 'NV', 'Vương Phương', 'Quang', '1219820798006.png', '1974-04-03', 2, 4, 'Lô 6 Khu B2-2 KDC phía nam sông quá giáng, Xã Hoà Phước, Huyện Hoà Vang, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 6 Khu B2-2 KDC phía nam sông quá giáng, Xã Hoà Phước, Huyện Hoà Vang, Thành phố Đà Nẵng', '0904520909', 'tranvanlam9161@gmail.com', '201221364', 'Ninh Bình', '2009-07-10', 2),
(00142, 'PIT', 'NV', 'Hoàng Văn', 'Tuệ', '1219820798021.png', '1938-10-04', 2, 3, 'K408/17/21 Tôn Đản, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K408/17/21 Tôn Đản, Phường Hoà An, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0977231998', 'phunghuuquang9221@gmail.com', '201981648', 'Long An', '2011-01-27', 1),
(00143, 'PKT', 'NV', 'Phạm Phi', 'Linh', '1219820798003.png', '1934-12-19', 2, 1, 'K36/H8/31 Nguyễn Huy Tưởng, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K36/H8/31 Nguyễn Huy Tưởng, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', '0979931405', 'dinhvochau4591@gmail.com', '201356701', 'Kiên Giang', '2008-06-15', 1),
(00144, 'PDT', 'NV', 'Lý Thành', 'Phục', '1219820798011.png', '1953-09-25', 2, 4, '260 Lê Văn Hiến, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '260 Lê Văn Hiến, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '01263100594', 'daotuantuyen8221@gmail.com', '201158119', 'Đà Nẵng', '2008-04-23', 1),
(00145, 'PIT', 'NV', 'Lê Phương', 'Phúc', '1219820798008.png', '1932-07-20', 1, 3, 'K36/H8/31 Nguyễn Huy Tưởng, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K36/H8/31 Nguyễn Huy Tưởng, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', '01636290441', 'lamthichau2971@gmail.com', '200968178', 'Kon Tum', '2008-11-16', 2),
(00146, 'PIT', 'NV', 'Lý Vô', 'Đạt', '1219820798005.png', '1950-09-10', 2, 3, '244 Nguyễn Duy Trinh, Phường Hoà Hải, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '244 Nguyễn Duy Trinh, Phường Hoà Hải, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0947305361', 'lythanhlinh6811@gmail.com', '201026844', 'Đà Nẵng', '2009-05-20', 2),
(00147, 'PNS', 'NV', 'Đăng Vô', 'Nghĩa', '1219820798015.png', '1947-01-28', 1, 4, '130/19 Điện Biên Phủ, Phường Chính Gián, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '130/19 Điện Biên Phủ, Phường Chính Gián, Quận Thanh Khê, Thành phố Đà Nẵng', '0942645560', 'tonhungphuc1741@gmail.com', '201189554', 'Đà Nẵng', '2012-05-12', 1),
(00148, 'PIT', 'NV', 'Đinh Thị', 'Tuyền', '1219820798017.png', '1944-03-23', 1, 1, 'Lô 165 Khu TĐC phía nam Hoàng Văn Thái, Phường Hoà Hiệp Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 165 Khu TĐC phía nam Hoàng Văn Thái, Phường Hoà Hiệp Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', '01662685066', 'laithichi9541@gmail.com', '201583325', 'Vĩnh Phúc', '2012-05-18', 2);
INSERT INTO `ho_so_nhan_vien` (`ma_nhan_vien`, `ma_phong_ban`, `ma_chuc_danh`, `ho_dem`, `ten`, `anh_dai_dien`, `nam_sinh`, `gioi_tinh`, `ma_tinh_trang_hon_nhan`, `que_quan`, `dan_toc`, `ma_quoc_tich`, `noi_tam_tru`, `so_dien_thoai`, `email`, `so_cmnd`, `noi_cap`, `ngay_cap`, `trang_thai`) VALUES
(00149, 'PIT', 'NV', 'Lai Thành', 'Tài', '1219820798007.png', '1990-08-29', 1, 2, 'Số 54 Nguyễn Thiếp, Phường An Hải Tây, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Số 54 Nguyễn Thiếp, Phường An Hải Tây, Quận Sơn Trà, Thành phố Đà Nẵng', '0982236673', 'tonhungphuong7591@gmail.com', '201443743', 'Nam Định', '2009-10-25', 2),
(00150, 'PIT', 'NV', 'Hoàng Thị', 'Sơn', '1219820798021.png', '1973-01-29', 1, 3, 'K31/12 Mẹ Nhu, Phường Thanh Khê Tây, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K31/12 Mẹ Nhu, Phường Thanh Khê Tây, Quận Thanh Khê, Thành phố Đà Nẵng', '0903294798', 'vuongphuongquang6411@gmail.com', '201819512', 'Đà Nẵng', '2011-12-03', 1),
(00151, 'PNS', 'NV', 'Nguyễn Thành', 'Bách', '1219820798002.png', '1939-12-05', 1, 1, '15 An Thượng 27, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '15 An Thượng 27, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '01687197564', 'hoangvantue7711@gmail.com', '201469809', 'Khánh Hòa', '2009-10-07', 2),
(00152, 'PDA', 'NV', 'Bùi Phục', 'Phúc', '1219820798017.png', '1929-12-17', 2, 4, '23 Nại Nghĩa 3, Phường Nại Hiên Đông, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '23 Nại Nghĩa 3, Phường Nại Hiên Đông, Quận Sơn Trà, Thành phố Đà Nẵng', '01655399169', 'phamphilinh8651@gmail.com', '201484685', 'Đà Nẵng', '2011-08-19', 2),
(00153, 'PKT', 'NV', 'Tôn Phương', 'Nguyệt', '1219820798002.png', '1944-05-05', 1, 4, 'Lô số 03-A3.5 Khu công viên Bắc Tượng Đài, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô số 03-A3.5 Khu công viên Bắc Tượng Đài, Phường Hoà Cường Bắc, Quận Hải Châu, Thành phố Đà Nẵng', '01645857067', 'lythanhphuc5221@gmail.com', '201588038', 'Đà Nẵng', '2009-07-04', 1),
(00154, 'PNS', 'NV', 'Đinh Phương', 'Tiền', '1219820798007.png', '1962-11-19', 2, 3, 'Lô 03 B2- 62, Khu đô thị Nam Hòa Xuân, Phường Hoà Quý, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 03 B2- 62, Khu đô thị Nam Hòa Xuân, Phường Hoà Quý, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '01685628826', 'lephuongphuc9041@gmail.com', '201688464', 'Đà Nẵng', '2011-11-17', 1),
(00155, 'PKT', 'NV', 'Mai Văn', 'Tài', '1219820798017.png', '1993-02-12', 1, 2, 'K233/27 Trưng Nữ Vương, Phường Hoà Thuận Đông, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K233/27 Trưng Nữ Vương, Phường Hoà Thuận Đông, Quận Hải Châu, Thành phố Đà Nẵng', '01649713688', 'lyvodat9271@gmail.com', '201936273', 'Đà Nẵng', '2008-12-28', 2),
(00156, 'PIT', 'NV', 'Lý Hưng', 'Long', '1219820798007.png', '1956-06-14', 2, 3, '76 Nguyễn Sơn, Phường Hoà Cường Nam, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '76 Nguyễn Sơn, Phường Hoà Cường Nam, Quận Hải Châu, Thành phố Đà Nẵng', '0977824888', 'dangvonghia5211@gmail.com', '201644735', 'Đà Nẵng', '2012-03-02', 1),
(00157, 'PDT', 'NV', 'Lâm Hưng', 'Quân', '1219820798006.png', '1960-12-05', 2, 4, '33 Ngô Quyền, Phường Thọ Quang, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '33 Ngô Quyền, Phường Thọ Quang, Quận Sơn Trà, Thành phố Đà Nẵng', '0909529939', 'dinhthituyen1321@gmail.com', '200843853', 'Đà Nẵng', '2008-03-16', 2),
(00158, 'PKT', 'NV', 'Đỗ Hạ', 'Tuyền', '1219820798020.png', '1936-04-04', 1, 1, 'Lô B2-13-30 Khu đô thị Phước Lý, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô B2-13-30 Khu đô thị Phước Lý, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', '01225241973', 'laithanhtai5891@gmail.com', '200875888', 'Đà Nẵng', '2009-01-25', 1),
(00159, 'PNS', 'NV', 'Lai Mỹ', 'Châu', '1219820798013.png', '1961-03-10', 2, 2, '281 Đoàn Khuê, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '281 Đoàn Khuê, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0902134602', 'hoangthison831@gmail.com', '201018594', 'Quảng Trị', '2009-03-25', 1),
(00160, 'PDA', 'NV', 'Trương Hạ', 'Thanh', '1219820798010.png', '1966-03-17', 1, 3, 'K19/8 Hoàng Hoa Thám, Phường Tân Chính, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K19/8 Hoàng Hoa Thám, Phường Tân Chính, Quận Thanh Khê, Thành phố Đà Nẵng', '0914751741', 'nguyenthanhbach441@gmail.com', '201124743', 'Hà Nội', '2011-01-22', 2),
(00161, 'PIT', 'NV', 'Tôn Tuấn', 'Lâm', '1219820798016.png', '1980-08-27', 1, 2, 'K424/H19/08 Ông Ích Khiêm, Phường Vĩnh Trung, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K424/H19/08 Ông Ích Khiêm, Phường Vĩnh Trung, Quận Thanh Khê, Thành phố Đà Nẵng', '0934366138', 'buiphucphuc9961@gmail.com', '201416171', 'Đà Nẵng', '2009-10-22', 1),
(00162, 'PNS', 'NV', 'Đỗ Phục', 'Tiền', '1219820798021.png', '1927-03-02', 2, 2, '288 Bế Văn Đàn, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '288 Bế Văn Đàn, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '01654780392', 'tonphuongnguyet4571@gmail.com', '201833156', 'Đà Nẵng', '2009-01-10', 2),
(00163, 'PDA', 'NV', 'Hoàng Hạ', 'Tuyền', '1219820798005.png', '1960-09-09', 2, 1, '35 Cao Thắng, Phường Thanh Bình, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '35 Cao Thắng, Phường Thanh Bình, Quận Hải Châu, Thành phố Đà Nẵng', '01699098584', 'dinhphuongtien2691@gmail.com', '201209250', 'Quảng Ngãi', '2012-12-20', 1),
(00164, 'PNS', 'NV', 'Nguyễn Vô', 'Nga', '1219820798013.png', '1928-09-16', 2, 1, '472 Ngô Quyền, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '472 Ngô Quyền, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', '01639248369', 'maivantai2371@gmail.com', '201729068', 'Bạc Liêu', '2008-07-19', 2),
(00165, 'PDT', 'NV', 'Phạm Bình', 'Thái', '1219820798014.png', '1941-03-15', 2, 3, '86/39 Phạm Nhữ Tăng, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '86/39 Phạm Nhữ Tăng, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '01626966001', 'lyhunglong6421@gmail.com', '201356401', 'Thừa Thiên Huế', '2011-06-05', 1),
(00166, 'PDA', 'NV', 'Triệu Hưng', 'Tiền', '1219820798002.png', '1945-04-04', 2, 2, '62 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '62 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '0989931173', 'lamhungquan9571@gmail.com', '200955069', 'Đà Nẵng', '2008-12-17', 2),
(00167, 'PKT', 'NV', 'Lý Bình', 'Mạnh', '1219820798021.png', '1930-05-23', 1, 4, '47 Hồ Nghinh, Phường Phước Mỹ, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '47 Hồ Nghinh, Phường Phước Mỹ, Quận Sơn Trà, Thành phố Đà Nẵng', '01694683046', 'dohatuyen4861@gmail.com', '201550162', 'Lạng Sơn', '2010-04-25', 1),
(00168, 'PNS', 'NV', 'Triệu Phi', 'Nga', '1219820798004.png', '1977-06-13', 2, 2, 'K523/45 Cách Mạng Tháng Tám, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K523/45 Cách Mạng Tháng Tám, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0983050498', 'laimychau221@gmail.com', '201772112', 'Bà Rịa - Vũng Tàu', '2012-10-17', 1),
(00169, 'PDA', 'NV', 'Lê Mỹ', 'Tăng', '1219820798009.png', '1988-03-11', 2, 4, '06 Vũ Ngọc Phan, Phường Hoà Khánh Bắc, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', '06 Vũ Ngọc Phan, Phường Hoà Khánh Bắc, Quận Liên Chiểu, Thành phố Đà Nẵng', '01658341354', 'truonghathanh6221@gmail.com', '201776676', 'Đà Nẵng', '2010-01-07', 2),
(00170, 'PKT', 'NV', 'Trần Hưng', 'Mạnh', '1219820798002.png', '1925-04-25', 2, 2, '91 Đinh Châu, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '91 Đinh Châu, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0915070429', 'tontuanlam6071@gmail.com', '200935756', 'Đà Nẵng', '2012-04-24', 1),
(00171, 'PDA', 'NV', 'Lâm Tuấn', 'Tiền', '1219820798022.png', '1952-08-20', 1, 1, '243/12 Ngõ B Tôn Đức Thắng, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', '243/12 Ngõ B Tôn Đức Thắng, Phường Hoà Minh, Quận Liên Chiểu, Thành phố Đà Nẵng', '01642471298', 'dophuctien9741@gmail.com', '201038745', 'Hà Nội', '2011-02-12', 1),
(00172, 'PDT', 'NV', 'Triệu Phương', 'Tài', '1219820798018.png', '1936-04-04', 2, 2, 'Số 54 Nguyễn Thiếp, Phường An Hải Tây, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Số 54 Nguyễn Thiếp, Phường An Hải Tây, Quận Sơn Trà, Thành phố Đà Nẵng', '0918296498', 'hoanghatuyen7511@gmail.com', '201306740', 'Đà Nẵng', '2009-08-10', 2),
(00173, 'PIT', 'NV', 'Bùi Hưng', 'Trân', '1219820798017.png', '1933-11-17', 1, 1, '144 Bùi Vịnh, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '144 Bùi Vịnh, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0936811100', 'nguyenvonga6921@gmail.com', '201248747', 'Hải Dương', '2008-10-14', 2),
(00174, 'PDA', 'NV', 'Đinh Thành', 'Châu', '1219820798012.png', '1939-06-18', 2, 4, 'Lô 18, Khu C1, Khu nhà ở Quân đội K38, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 18, Khu C1, Khu nhà ở Quân đội K38, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0962720529', 'phambinhthai461@gmail.com', '200935877', 'Cà Mau', '2012-01-12', 2),
(00175, 'PNS', 'NV', 'Trần Hạ', 'Nguyệt', '1219820798002.png', '1937-04-16', 1, 4, 'Số 25 Thế Lữ, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Số 25 Thế Lữ, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', '0988391086', 'trieuhungtien5151@gmail.com', '201255655', 'Đà Nẵng', '2011-02-19', 1),
(00176, 'PNS', 'NV', 'Triệu Vô', 'Lâm', '1219820798020.png', '1934-10-11', 2, 2, '115 Nguyễn Văn Linh, Phường Nam Dương, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '115 Nguyễn Văn Linh, Phường Nam Dương, Quận Hải Châu, Thành phố Đà Nẵng', '01646533210', 'lybinhmanh2551@gmail.com', '201387311', 'Đà Nẵng', '2009-05-17', 1),
(00177, 'PDT', 'NV', 'Bùi Hữu', 'Tuyền', '1219820798022.png', '1995-11-17', 1, 3, '01 Võ Như Hưng, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '01 Võ Như Hưng, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0988971151', 'trieuphinga3391@gmail.com', '201786204', 'Điện Biên', '2012-02-18', 1),
(00178, 'PNS', 'NV', 'Lê Bình', 'Linh', '1219820798008.png', '1983-09-06', 1, 3, '23 Trịnh Lỗi, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '23 Trịnh Lỗi, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0949537187', 'lemytang3431@gmail.com', '201174985', 'Hậu Giang', '2009-03-02', 1),
(00179, 'PNS', 'NV', 'Đồng Thành', 'Thảo', '1219820798002.png', '1926-12-09', 1, 4, '138/74/04/14/61 Hoàng Văn Thái, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', '138/74/04/14/61 Hoàng Văn Thái, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', '01235627798', 'tranhungmanh5511@gmail.com', '201866197', 'Bình Định', '2012-08-01', 1),
(00180, 'PKT', 'NV', 'Dương Hưng', 'Quân', '1219820798021.png', '1990-06-28', 1, 4, '56 Phan Văn Đạt, Phường Hoà Khánh Bắc, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', '56 Phan Văn Đạt, Phường Hoà Khánh Bắc, Quận Liên Chiểu, Thành phố Đà Nẵng', '0913314267', 'lamtuantien4881@gmail.com', '201689627', 'Đắk Lắk', '2012-05-16', 1),
(00181, 'PDA', 'NV', 'Lai Hữu', 'Nga', '1219820798013.png', '1987-08-26', 2, 3, 'Lô 03 B2- 62, Khu đô thị Nam Hòa Xuân, Phường Hoà Quý, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 03 B2- 62, Khu đô thị Nam Hòa Xuân, Phường Hoà Quý, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '01632767469', 'trieuphuongtai5491@gmail.com', '201133299', 'Bắc Giang', '2009-07-10', 1),
(00182, 'PDT', 'NV', 'Nguyễn Hữu', 'Thảo', '1219820798012.png', '1974-08-11', 1, 4, 'Lô 249, Đường Hoàng Minh Thảo, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 249, Đường Hoàng Minh Thảo, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', '01666614597', 'buihungtran6321@gmail.com', '201786724', 'Thừa Thiên Huế', '2011-11-17', 2),
(00183, 'PNS', 'NV', 'Hoàng Phi', 'Chí', '1219820798003.png', '1998-05-14', 2, 2, 'K411/25/5 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K411/25/5 Nguyễn Phước Nguyên, Phường An Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '0946733629', 'dinhthanhchau281@gmail.com', '200805379', 'Bình Dương', '2009-10-08', 2),
(00184, 'PDT', 'NV', 'Võ Thành', 'Nga', '1219820798018.png', '1977-10-11', 2, 1, '30A đường Nguyễn Tri Phương, Phường Chính Gián, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '30A đường Nguyễn Tri Phương, Phường Chính Gián, Quận Thanh Khê, Thành phố Đà Nẵng', '01205670657', 'tranhanguyet6911@gmail.com', '200973634', 'Đà Nẵng', '2009-08-11', 1),
(00185, 'PDA', 'NV', 'Đào Hưng', 'Thảo', '1219820798006.png', '1958-02-06', 1, 1, '689 Nguyễn Tất Thành, Phường Xuân Hà, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '689 Nguyễn Tất Thành, Phường Xuân Hà, Quận Thanh Khê, Thành phố Đà Nẵng', '01663418967', 'trieuvolam3811@gmail.com', '201162360', 'Đà Nẵng', '2011-06-18', 1),
(00186, 'PNS', 'NV', 'Tôn Mỹ', 'Thành', '1219820798012.png', '1967-02-08', 2, 2, '185 Trần Xuân Lê, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', 'Kinh', 'VN', '185 Trần Xuân Lê, Phường Hoà Khê, Quận Thanh Khê, Thành phố Đà Nẵng', '0987482498', 'buihuutuyen3281@gmail.com', '201461944', 'Đà Nẵng', '2008-05-23', 2),
(00187, 'PDT', 'NV', 'Đỗ Thành', 'Linh', '1219820798005.png', '1944-10-10', 2, 2, '39 Xuân Tâm, Phường Thuận Phước, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '39 Xuân Tâm, Phường Thuận Phước, Quận Hải Châu, Thành phố Đà Nẵng', '0979097898', 'lebinhlinh7091@gmail.com', '201672629', 'Lào Cai', '2011-10-02', 1),
(00188, 'PDT', 'NV', 'Trương Thị', 'Đạt', '1219820798016.png', '1952-12-20', 2, 4, '149 Hoàng Văn Thái, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', '149 Hoàng Văn Thái, Phường Hoà Khánh Nam, Quận Liên Chiểu, Thành phố Đà Nẵng', '01649826729', 'dongthanhthao791@gmail.com', '201000101', 'Tiền Giang', '2008-10-13', 1),
(00189, 'PNS', 'NV', 'Lai Văn', 'Châu', '1219820798020.png', '1934-04-17', 2, 2, '03 Trần Thanh Mại, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '03 Trần Thanh Mại, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', '0964690169', 'duonghungquan4971@gmail.com', '201542234', 'Kiên Giang', '2009-10-09', 2),
(00190, 'PDA', 'NV', 'Phùng Phục', 'Nga', '1219820798011.png', '1989-09-17', 2, 2, 'Lô 526 Đô Đốc Lân, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', 'Lô 526 Đô Đốc Lân, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', '0977565788', 'laihuunga7511@gmail.com', '201646355', 'Lạng Sơn', '2009-07-08', 1),
(00191, 'PNS', 'NV', 'Đào Vô', 'Trân', '1219820798021.png', '1930-06-14', 2, 3, '46 Nguyễn Đình Trọng, Phường Hoà Khánh Bắc, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', '46 Nguyễn Đình Trọng, Phường Hoà Khánh Bắc, Quận Liên Chiểu, Thành phố Đà Nẵng', '01699904035', 'nguyenhuuthao9241@gmail.com', '201735247', 'Đà Nẵng', '2011-09-27', 2),
(00192, 'PDA', 'NV', 'Đỗ Vô', 'Bách', '1219820798008.png', '1937-07-21', 1, 2, 'K166/17 Nguyễn Lương Bằng, Phường Hoà Khánh Bắc, Quận Liên Chiểu, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K166/17 Nguyễn Lương Bằng, Phường Hoà Khánh Bắc, Quận Liên Chiểu, Thành phố Đà Nẵng', '0974693703', 'hoangphichi6021@gmail.com', '201038102', 'Ninh Bình', '2009-11-09', 1),
(00193, 'PDA', 'NV', 'Trương Thị', 'Tiền', '1219820798018.png', '1969-06-16', 2, 1, '21/3 Yên Bái, Phường Hải Châu I, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '21/3 Yên Bái, Phường Hải Châu I, Quận Hải Châu, Thành phố Đà Nẵng', '0964118879', 'vothanhnga3721@gmail.com', '201877426', 'Bình Định', '2009-07-09', 1),
(00194, 'PIT', 'NV', 'Trương Phi', 'Mạnh', '1219820798016.png', '1984-02-18', 2, 2, '152/6 Lý Tự Trọng, Phường Thuận Phước, Quận Hải Châu, Thành phố Đà Nẵng', 'Kinh', 'VN', '152/6 Lý Tự Trọng, Phường Thuận Phước, Quận Hải Châu, Thành phố Đà Nẵng', '0979697846', 'daohungthao9641@gmail.com', '200844276', 'Điện Biên', '2012-01-19', 2),
(00195, 'PDT', 'NV', 'Bùi Văn', 'Nga', '1219820798007.png', '1974-11-01', 2, 2, '85 Khương Hữu Dụng, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', '85 Khương Hữu Dụng, Phường Hoà Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01643148498', 'tonmythanh7041@gmail.com', '201067460', 'Đà Nẵng', '2011-02-26', 2),
(00196, 'PDT', 'NV', 'Hoàng Bình', 'Tăng', '1219820798002.png', '1993-01-20', 1, 1, '303 Khúc Hạo, Phường Nại Hiên Đông, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '303 Khúc Hạo, Phường Nại Hiên Đông, Quận Sơn Trà, Thành phố Đà Nẵng', '0948123062', 'dothanhlinh7161@gmail.com', '201601257', 'Đà Nẵng', '2008-09-18', 1),
(00197, 'PDT', 'NV', 'Dương Thành', 'Mạnh', '1219820798014.png', '1953-04-08', 1, 2, '281 Đoàn Khuê, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '281 Đoàn Khuê, Phường Khuê Mỹ, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '0902271303', 'truongthidat5611@gmail.com', '201803181', 'Khánh Hòa', '2010-08-27', 2),
(00198, 'PKT', 'NV', 'Đăng Thị', 'Châu', '1219820798011.png', '1980-04-06', 2, 4, '01 Võ Như Hưng, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', 'Kinh', 'VN', '01 Võ Như Hưng, Phường Mỹ An, Quận Ngũ Hành Sơn, Thành phố Đà Nẵng', '01626590658', 'laivanchau4271@gmail.com', '201690828', 'Bà Rịa - Vũng Tàu', '2008-08-01', 2),
(00199, 'PDA', 'NV', 'Đỗ Bình', 'Linh', '1219820798003.png', '1998-03-22', 1, 4, 'K854/07 Ngô Quyền, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K854/07 Ngô Quyền, Phường An Hải Bắc, Quận Sơn Trà, Thành phố Đà Nẵng', '01273311545', 'phungphucnga31@gmail.com', '201512701', 'Đà Nẵng', '2011-08-06', 2),
(00200, 'PDA', 'NV', 'Vương Mỹ', 'Phúc', '1219820798020.png', '1960-05-23', 2, 2, 'K523/45 Cách Mạng Tháng Tám, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', 'Kinh', 'VN', 'K523/45 Cách Mạng Tháng Tám, Phường Hoà Thọ Đông, Quận Cẩm Lệ, Thành phố Đà Nẵng', '01628151156', 'daovotran6941@gmail.com', '200916550', 'Yên Bái', '2010-09-26', 2),
(00201, 'PNS', 'NV', 'Dương Hưng', 'Chí', '1219820798017.png', '1939-01-05', 2, 1, '303 Khúc Hạo, Phường Nại Hiên Đông, Quận Sơn Trà, Thành phố Đà Nẵng', 'Kinh', 'VN', '303 Khúc Hạo, Phường Nại Hiên Đông, Quận Sơn Trà, Thành phố Đà Nẵng', '0982735661', 'dovobach9031@gmail.com', '201476741', 'Quảng Nam', '2008-07-24', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phong_ban`
--

CREATE TABLE IF NOT EXISTS `phong_ban` (
  `ma_phong_ban` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ten_phong_ban` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phong_ban`
--

INSERT INTO `phong_ban` (`ma_phong_ban`, `ten_phong_ban`) VALUES
('PDA1', 'Phòng Dự Án #1'),
('PDA2', 'Phòng Dự Án #2'),
('PDA3', 'Phòng Dự Án #3'),
('PDA4', 'Phòng Dự Án #4'),
('PDT', 'Phòng Đào Tạo'),
('PGD', 'Phòng Giám Đốc'),
('PIT', 'Phòng Kỹ Thuật'),
('PKT', 'Phòng Kế Toán'),
('PHC', 'Phòng Hành Chính'),
('PNS', 'Phòng Nhân Sự');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `ma_role` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`ma_role`, `name`) VALUES
(1, 'ROLE_PNS'),
(2, 'ROLE_PGD'),
(3, 'ROLE_TPPDA'),
(4, 'ROLE_TPPDT'),
(5, 'ROLE_TPPIT'),
(6, 'ROLE_TPPKT'),
(7, 'ROLE_TPPNS'),
(8, 'ROLE_NV');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `ma_tai_khoan` int(11) NOT NULL,
  `username` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ma_nhan_vien` int(11) NOT NULL,
  `enabled` int(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ma_tai_khoan`, `username`, `password`, `ma_nhan_vien`, `enabled`) VALUES
(1, 'giamdoc', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 1, 1),
(2, 'truongphongduan', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 7, 1),
(3, 'truongphongdaotao', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 56, 1),
(4, 'truongphongit', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 16, 1),
(5, 'truongphongketoan', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 57, 1),
(6, 'truongphongnhansu', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 42, 1),
(7, 'phophongduan', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 101, 1),
(8, 'phophongdaotao', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 35, 1),
(9, 'phophongit', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 28, 1),
(10, 'phophongketoan', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 86, 1),
(11, 'phophongnhansu', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 124, 1),
(12, 'phogiamdoc', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 60, 1),
(13, 'nhanvienphongduan', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 66, 1),
(14, 'nhanvienphongdaotao', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 69, 1),
(15, 'nhanvienphongit', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 65, 1),
(16, 'nhanvienphongketoan', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 74, 1),
(17, 'nhanvienphongnhansu', '$2a$10$LOqePml/koRGsk2YAIOFI.1YNKZg7EsQ5BAIuYP1nWOyYRl21dlne', 15, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE IF NOT EXISTS `users_roles` (
  `ma_tai_khoan` int(11) NOT NULL DEFAULT '0',
  `ma_role` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`ma_tai_khoan`, `ma_role`) VALUES
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 6),
(6, 1),
(6, 7),
(7, 3),
(8, 4),
(9, 5),
(10, 6),
(11, 1),
(11, 7),
(12, 2),
(13, 8),
(14, 8),
(15, 8),
(16, 8),
(17, 1),
(17, 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chuc_danh`
--
ALTER TABLE `chuc_danh`
  ADD PRIMARY KEY (`ma_chuc_danh`);

--
-- Indexes for table `ho_so_nhan_vien`
--
ALTER TABLE `ho_so_nhan_vien`
  ADD PRIMARY KEY (`ma_nhan_vien`);

--
-- Indexes for table `phong_ban`
--
ALTER TABLE `phong_ban`
  ADD PRIMARY KEY (`ma_phong_ban`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ma_tai_khoan`),
  ADD UNIQUE KEY `ma_nhan_vien` (`ma_nhan_vien`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ho_so_nhan_vien`
--
ALTER TABLE `ho_so_nhan_vien`
  MODIFY `ma_nhan_vien` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=202;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ma_tai_khoan` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
