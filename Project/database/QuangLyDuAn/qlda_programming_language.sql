-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2018 at 09:04 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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
-- Table structure for table `programming_language`
--

CREATE TABLE `programming_language` (
  `id` int(11) NOT NULL,
  `ma_programming_language` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ten_programming_language` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ghi_chu` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `programming_language`
--

INSERT INTO `programming_language` (`id`, `ma_programming_language`, `ten_programming_language`, `ghi_chu`) VALUES
(1, '1', 'Ruby', 'Riby là ngôn ngữ lập trình năng động, mã nguồn mở tập trung vào sự đơn giản. Nó được dùng để xây dựng một số ứng dụng mà chúng ta dùng mỗi ngày. Khung ứng dụng web phổ biến Ruby on Rails được triển khai bằng Ruby. Các ứng dụng như Twitch, SoundCloud, Hulu, Zendesk, Square và GitHub được xây dựng với Ruby on Rails.'),
(2, '2', 'C', 'C là ngôn ngữ cũ, nhưng tốt. Đây là một trong nhựng lựa chọn lâu đời nhất, được phát minh vào thập niên 1970. Thậm chí ngày nay, C vẫn là một trong các ngôn ngữ lập trình được dùng rộng rãi nhất mọi thời đại.'),
(3, '3', 'Shell', 'Hệ thống Shell là chương trình máy tính được thiết kế để hướng dẫn hệ điều hành chạy các lệnh nhất định. Nó có thể thao tác các tập tin, thực thi chương trình và nhiều hơn nữa. Ngôn ngữ này đặc biệt phổ biến với các quản trị viên hệ thống.'),
(4, '4', 'TypeScript', 'TypeScript được mô tả như JavaScript được thêm sức mạnh. Với cú pháp và ngữ nghĩa tương tự, nó liên quan chặt chẽ đến JavaScript, có thể hỗ trợ nhiều ứng dụng quy mô lớn. Ngôn ngữ này do Microsoft tạo ra và đang dần phổ biến, tăng hạng từ vị trí thứ 11 hồi năm ngoái lên vị trí thứ 7 năm nay.'),
(5, '5', 'C#', 'C# phát âm là C Sharp, cũng được Microsoft phát triển và dùng để xây dựng ứng dụng, phần mềm doanh nghiệp cho khách hàng doanh nghiệp. Ngôn ngữ lập trình hướng đối tượng này tương tự như Java.'),
(6, '6', 'C++', 'C++ xuất phát từ thập niên 1970, thường được dạy trong các khóa học khoa học máy tính mới bắt đầu. C++ giờ vẫn là một trong các ngôn ngữ được sử dụng rộng rãi nhất, vì nó là ngôn ngữ cốt lõi trong nhiều hệ điều hành, trình duyệt và trò chơi.'),
(7, '7', 'PHP', 'PHP được dùng để tạo các trang web năng động, có khả năng tương tác. Nhiều web lớn như Facebook và Yahoo xây dựng bằng PHP, song nhà phát triển từ lâu chế nhạo đây là ngôn ngữ lập trình tệ nhất thế giới.'),
(8, '8', 'Python', 'Python là ngôn ngữ lập trình bậc cao và một trong những ngôn ngữ phát triển nhanh nhất thế giới. Dễ dàng để bắt đầu với Python, song nó thường được dùng cho trình độ lập trình cấp cao hơn như học máy hoặc phân tích dữ liệu. Nhiều người cho rằng Python là ngôn ngữ cực kỳ linh hoạt.'),
(9, '9', 'Java', 'Java là ngôn ngữ hướng đến đối tượng, do Sun Microsystems (hãng thuộc sở hữu của Oracle) tạo ra. Java được dùng cho các cơ sở dữ liệu, phát triển ứng dụng Android. Nó là ngôn ngữ lập trình “phụ trợ” cho web, ứng dụng desktop và nhiều thứ khác. Java vô cùng phổ biến, được xem là một trong những cách ổn định và đáng tin cậy nhất để xây dựng hệ thống lớn.'),
(10, '10', 'JavaScript', 'JavaScript là ngôn ngữ được dùng nhiều nhất trên GitHuv, với thành viên đóng góp trong cả các kho công cộng lẫn riêng tư, trong tổ chức với mọi quy mô từ khắp nơi trên thế giới. Đây là ngôn ngữ lập trình đứng sau nhiều web, được dùng để xây dựng các plugin và website tương tác. Dù có chữ “Java” trong tên gọi nhưng thực tế, nó ít liên quan đến Java.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `programming_language`
--
ALTER TABLE `programming_language`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `programming_language`
--
ALTER TABLE `programming_language`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
