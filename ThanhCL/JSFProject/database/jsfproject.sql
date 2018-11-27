-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2018 at 08:20 AM
-- Server version: 5.6.37
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jsfproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL,
  `first_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `first_name`, `last_name`, `email`) VALUES
(1, 'Nguyễn Văn', '001', 'ffse001@st.fasttrack.edu.vn'),
(2, 'Nguyễn Văn', '002', 'ffse002@st.fasttrack.edu.vn'),
(3, 'Nguyễn Văn', '003', 'ffse003@st.fasttrack.edu.vn'),
(4, 'Nguyễn Văn', '004', 'ffse004@st.fasttrack.edu.vn'),
(5, 'Nguyễn Văn', '005', 'ffse005@st.fasttrack.edu.vn'),
(6, 'Nguyễn Văn', '006', 'ffse006@st.fasttrack.edu.vn'),
(7, 'Nguyễn Văn', '007', 'ffse007@st.fasttrack.edu.vn'),
(8, 'Nguyễn Văn', '008', 'ffse008@st.fasttrack.edu.vn'),
(9, 'Nguyễn Văn', '009', 'ffse009@st.fasttrack.edu.vn'),
(10, 'Nguyễn Văn', '010', 'ffse010@st.fasttrack.edu.vn'),
(11, 'Nguyễn Văn', '011', 'ffse011@st.fasttrack.edu.vn'),
(12, 'Nguyễn Văn', '012', 'ffse012@st.fasttrack.edu.vn'),
(13, 'Nguyễn Văn', '013', 'ffse013@st.fasttrack.edu.vn'),
(14, 'Nguyễn Văn', '014', 'ffse014@st.fasttrack.edu.vn'),
(15, 'Nguyễn Văn', '015', 'ffse015@st.fasttrack.edu.vn'),
(16, 'Nguyễn Văn', '016', 'ffse016@st.fasttrack.edu.vn'),
(17, 'Nguyễn Văn', '017', 'ffse017@st.fasttrack.edu.vn'),
(18, 'Nguyễn Văn', '018', 'ffse018@st.fasttrack.edu.vn'),
(19, 'Nguyễn Văn', '019', 'ffse019@st.fasttrack.edu.vn'),
(20, 'Nguyễn Văn', '020', 'ffse020@st.fasttrack.edu.vn'),
(21, 'Nguyễn Văn', '021', 'ffse021@st.fasttrack.edu.vn'),
(22, 'Nguyễn Văn', '022', 'ffse022@st.fasttrack.edu.vn'),
(23, 'Nguyễn Văn', '023', 'ffse023@st.fasttrack.edu.vn'),
(24, 'Nguyễn Văn', '024', 'ffse024@st.fasttrack.edu.vn'),
(25, 'Nguyễn Văn', '025', 'ffse025@st.fasttrack.edu.vn'),
(26, 'Nguyễn Văn', '026', 'ffse026@st.fasttrack.edu.vn'),
(27, 'Nguyễn Văn', '027', 'ffse027@st.fasttrack.edu.vn'),
(28, 'Nguyễn Văn', '028', 'ffse028@st.fasttrack.edu.vn'),
(29, 'Nguyễn Văn', '029', 'ffse029@st.fasttrack.edu.vn'),
(30, 'Nguyễn Văn', '030', 'ffse030@st.fasttrack.edu.vn'),
(31, 'Nguyễn Văn', '031', 'ffse031@st.fasttrack.edu.vn'),
(32, 'Nguyễn Văn', '032', 'ffse032@st.fasttrack.edu.vn'),
(33, 'Nguyễn Văn', '033', 'ffse033@st.fasttrack.edu.vn'),
(34, 'Nguyễn Văn', '034', 'ffse034@st.fasttrack.edu.vn'),
(35, 'Nguyễn Văn', '035', 'ffse035@st.fasttrack.edu.vn'),
(36, 'Nguyễn Văn', '036', 'ffse036@st.fasttrack.edu.vn'),
(37, 'Nguyễn Văn', '037', 'ffse037@st.fasttrack.edu.vn'),
(38, 'Nguyễn Văn', '038', 'ffse038@st.fasttrack.edu.vn'),
(39, 'Nguyễn Văn', '039', 'ffse039@st.fasttrack.edu.vn'),
(40, 'Nguyễn Văn', '040', 'ffse040@st.fasttrack.edu.vn'),
(41, 'Nguyễn Văn', '041', 'ffse041@st.fasttrack.edu.vn'),
(42, 'Nguyễn Văn', '042', 'ffse042@st.fasttrack.edu.vn'),
(43, 'Nguyễn Văn', '043', 'ffse043@st.fasttrack.edu.vn'),
(44, 'Nguyễn Văn', '044', 'ffse044@st.fasttrack.edu.vn'),
(45, 'Nguyễn Văn', '045', 'ffse045@st.fasttrack.edu.vn'),
(46, 'Nguyễn Văn', '046', 'ffse046@st.fasttrack.edu.vn'),
(47, 'Nguyễn Văn', '047', 'ffse047@st.fasttrack.edu.vn'),
(48, 'Nguyễn Văn', '048', 'ffse048@st.fasttrack.edu.vn'),
(49, 'Nguyễn Văn', '049', 'ffse049@st.fasttrack.edu.vn'),
(50, 'Nguyễn Văn', '050', 'ffse050@st.fasttrack.edu.vn'),
(51, 'Nguyễn Văn', '051', 'ffse051@st.fasttrack.edu.vn'),
(52, 'Nguyễn Văn', '052', 'ffse052@st.fasttrack.edu.vn'),
(53, 'Nguyễn Văn', '053', 'ffse053@st.fasttrack.edu.vn'),
(54, 'Nguyễn Văn', '054', 'ffse054@st.fasttrack.edu.vn'),
(55, 'Nguyễn Văn', '055', 'ffse055@st.fasttrack.edu.vn'),
(56, 'Nguyễn Văn', '056', 'ffse056@st.fasttrack.edu.vn'),
(57, 'Nguyễn Văn', '057', 'ffse057@st.fasttrack.edu.vn'),
(58, 'Nguyễn Văn', '058', 'ffse058@st.fasttrack.edu.vn'),
(59, 'Nguyễn Văn', '059', 'ffse059@st.fasttrack.edu.vn'),
(60, 'Nguyễn Văn', '060', 'ffse060@st.fasttrack.edu.vn'),
(61, 'Nguyễn Văn', '061', 'ffse061@st.fasttrack.edu.vn'),
(62, 'Nguyễn Văn', '062', 'ffse062@st.fasttrack.edu.vn'),
(63, 'Nguyễn Văn', '063', 'ffse063@st.fasttrack.edu.vn'),
(64, 'Nguyễn Văn', '064', 'ffse064@st.fasttrack.edu.vn'),
(65, 'Nguyễn Văn', '065', 'ffse065@st.fasttrack.edu.vn'),
(66, 'Nguyễn Văn', '066', 'ffse066@st.fasttrack.edu.vn'),
(67, 'Nguyễn Văn', '067', 'ffse067@st.fasttrack.edu.vn'),
(68, 'Nguyễn Văn', '068', 'ffse068@st.fasttrack.edu.vn'),
(69, 'Nguyễn Văn', '069', 'ffse069@st.fasttrack.edu.vn'),
(70, 'Nguyễn Văn', '070', 'ffse070@st.fasttrack.edu.vn'),
(71, 'Nguyễn Văn', '071', 'ffse071@st.fasttrack.edu.vn'),
(72, 'Nguyễn Văn', '072', 'ffse072@st.fasttrack.edu.vn'),
(73, 'Nguyễn Văn', '073', 'ffse073@st.fasttrack.edu.vn'),
(74, 'Nguyễn Văn', '074', 'ffse074@st.fasttrack.edu.vn'),
(75, 'Nguyễn Văn', '075', 'ffse075@st.fasttrack.edu.vn'),
(76, 'Nguyễn Văn', '076', 'ffse076@st.fasttrack.edu.vn'),
(77, 'Nguyễn Văn', '077', 'ffse077@st.fasttrack.edu.vn'),
(78, 'Nguyễn Văn', '078', 'ffse078@st.fasttrack.edu.vn'),
(79, 'Nguyễn Văn', '079', 'ffse079@st.fasttrack.edu.vn'),
(80, 'Nguyễn Văn', '080', 'ffse080@st.fasttrack.edu.vn'),
(81, 'Nguyễn Văn', '081', 'ffse081@st.fasttrack.edu.vn'),
(82, 'Nguyễn Văn', '082', 'ffse082@st.fasttrack.edu.vn'),
(83, 'Nguyễn Văn', '083', 'ffse083@st.fasttrack.edu.vn'),
(84, 'Nguyễn Văn', '084', 'ffse084@st.fasttrack.edu.vn'),
(85, 'Nguyễn Văn', '085', 'ffse085@st.fasttrack.edu.vn'),
(86, 'Nguyễn Văn', '086', 'ffse086@st.fasttrack.edu.vn'),
(87, 'Nguyễn Văn', '087', 'ffse087@st.fasttrack.edu.vn'),
(88, 'Nguyễn Văn', '088', 'ffse088@st.fasttrack.edu.vn'),
(89, 'Nguyễn Văn', '089', 'ffse089@st.fasttrack.edu.vn'),
(90, 'Nguyễn Văn', '090', 'ffse090@st.fasttrack.edu.vn'),
(91, 'Nguyễn Văn', '091', 'ffse091@st.fasttrack.edu.vn'),
(92, 'Nguyễn Văn', '092', 'ffse092@st.fasttrack.edu.vn'),
(93, 'Nguyễn Văn', '093', 'ffse093@st.fasttrack.edu.vn'),
(94, 'Nguyễn Văn', '094', 'ffse094@st.fasttrack.edu.vn'),
(95, 'Nguyễn Văn', '095', 'ffse095@st.fasttrack.edu.vn'),
(96, 'Nguyễn Văn', '096', 'ffse096@st.fasttrack.edu.vn'),
(97, 'Nguyễn Văn', '097', 'ffse097@st.fasttrack.edu.vn'),
(98, 'Nguyễn Văn', '098', 'ffse098@st.fasttrack.edu.vn'),
(99, 'Nguyễn Văn', '099', 'ffse099@st.fasttrack.edu.vn'),

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=100;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
