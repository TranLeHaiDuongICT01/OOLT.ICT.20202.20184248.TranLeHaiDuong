-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2021 at 04:00 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `productdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `billing`
--

CREATE TABLE `billing` (
  `id` int(11) NOT NULL,
  `BillID` int(30) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `cost` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `billing`
--

INSERT INTO `billing` (`id`, `BillID`, `name`, `price`, `quantity`, `cost`) VALUES
(1, 11, 'dawdaw', 453, 0, 0),
(2, 17, 'Smart Watch', 29, 0, 0),
(3, 17, 'Digital Camera', 69, 0, 0),
(4, 18, 'Smart Watch', 29, 0, 0),
(5, 18, 'Digital Camera', 69, 0, 0),
(6, 19, 'Smart Watch', 29, 0, 0),
(7, 19, 'Digital Camera', 69, 0, 0),
(8, 20, 'Smart Watch', 29, 0, 0),
(9, 20, 'Digital Camera', 69, 0, 0),
(10, 21, 'Smart Watch', 29.99, 0, 0),
(11, 21, 'Digital Camera', 69.99, 0, 0),
(12, 22, 'Smart Watch', 29.99, 0, 0),
(13, 22, 'Digital Camera', 69.99, 0, 0),
(14, 23, 'Smart Watch', 29.99, 0, 0),
(15, 23, 'Digital Camera', 69.99, 0, 0),
(16, 24, 'Smart Watch', 29.99, 0, 0),
(17, 24, 'Digital Camera', 69.99, 0, 0),
(18, 999, 'Smart Watch', 29.99, 0, 0),
(19, 999, 'Digital Camera', 69.99, 0, 0),
(20, 26, 'Smart Watch', 29.99, 2, 0),
(21, 26, 'Digital Camera', 69.99, 1, 0),
(22, 30, 'Smart Watch', 29.99, 2, 59),
(23, 30, 'Digital Camera', 69.99, 1, 69),
(24, 31, 'Smart Watch', 29.99, 2, 59.98),
(25, 31, 'Digital Camera', 69.99, 1, 69.99);

-- --------------------------------------------------------

--
-- Table structure for table `brands`
--

CREATE TABLE `brands` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `brands`
--

INSERT INTO `brands` (`id`, `name`) VALUES
(2, 'chanel'),
(1, 'gucci'),
(3, 'versace');

-- --------------------------------------------------------

--
-- Table structure for table `categorys`
--

CREATE TABLE `categorys` (
  `id` int(11) NOT NULL,
  `main_category` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categorys`
--

INSERT INTO `categorys` (`id`, `main_category`, `name`) VALUES
(1, 1, 'ANIME'),
(2, 1, 'CARTOON'),
(3, 1, 'K-POP'),
(4, 1, 'DOG'),
(5, 1, 'CAT'),
(7, 2, 'GAME'),
(8, 2, 'MANGA - ANIME'),
(9, 2, 'LEGO'),
(11, 3, 'MEN\'S FASHION'),
(12, 3, 'WOMEN\'S FASHION'),
(13, 3, 'GIRLS\'S FASHION'),
(14, 3, 'BOYS\'S FASHION'),
(15, 4, 'MOBILE CASES'),
(16, 4, 'PHONE ACCESSORIES '),
(17, 4, 'LAPTOP ACCESSORIES '),
(18, 4, 'HANDHELD ELECTRONIC GAME'),
(19, 4, 'HEADPHONES'),
(20, 4, 'SPEAKERS'),
(21, 5, 'BACKPACK'),
(22, 5, 'CROSS BAG'),
(23, 5, 'PEN'),
(24, 5, 'NOTEBOOK'),
(25, 5, 'RULER'),
(26, 5, 'PEN BOX'),
(27, 5, 'POSTCARD - POSTER'),
(28, 5, 'STICKER'),
(29, 5, 'KEYCHAINS');

-- --------------------------------------------------------

--
-- Table structure for table `invoices`
--

CREATE TABLE `invoices` (
  `billingID` int(30) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` text NOT NULL,
  `address` varchar(100) NOT NULL,
  `TotalCost` double NOT NULL,
  `CreateDate` varchar(30) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `invoices`
--

INSERT INTO `invoices` (`billingID`, `name`, `phone`, `address`, `TotalCost`, `CreateDate`, `status`) VALUES
(1, 'hien', '3253141341', 'dhwahh  jdiawj oi adaw da wfdafd a', 0, '2021-03-31', 'pending'),
(2, 'dwadaw', '4324', 'dawdwad', 0, '2021-03-31', 'pending'),
(3, 'dwadaw', '4324', 'dawdwad', 129.97, '2021-03-31', 'pending'),
(4, 'dawdaw', '4242', 'dawdawd', 129.97, '2021-03-31', 'pending'),
(5, 'dawdaw', '4242', 'dawdawd', 129.97, '2021-03-31', 'pending'),
(6, 'dawdaw', '4242', 'dawdawd', 129.97, '2021-03-31', 'pending'),
(7, 'dawdaw', '4242', 'dawdawd', 129.97, '2021-03-31', 'pending'),
(8, 'dawdaw', '4242', 'dawdawd', 129.97, '2021-03-31', 'pending'),
(9, 'dawdaw', '4242', 'dawdawd', 129.97, '2021-03-31', 'pending'),
(10, 'dawdaw', '4242', 'dawdawd', 129.97, '2021-03-31', 'pending'),
(11, 'dwadawdawd', '53411345135', 'dawdawd', 129.97, '2021-03-31', 'pending'),
(12, 'dwadawdawd', '53411345135', 'dawdawd', 129.97, '2021-03-31', 'pending'),
(13, 'dwadawdawd', '53411345135', 'dawdawd', 129.97, '2021-03-31', 'pending'),
(14, 'dwadawdawd', '53411345135', 'dawdawd', 129.97, '2021-03-31', 'pending'),
(15, 'dwadawdawd', '53411345135', 'dawdawd', 129.97, '2021-03-31', 'pending'),
(16, 'dawdaw', '432423', 'dwadaw', 129.97, '2021-03-31', 'pending'),
(17, 'dawdaw', '432423', 'dwadaw', 259.94, '2021-03-31', 'pending'),
(18, 'dawdaw', '432423', 'dawdaw', 259.94, '2021-03-31', 'pending'),
(19, 'dawdaw', '432423', 'dawdaw', 259.94, '2021-03-31', 'pending'),
(20, 'dawdaw', '432423', 'dawdaw', 259.94, '2021-03-31', 'pending'),
(21, 'dawdaw', '432423', 'dawdaw', 259.94, '2021-03-31', 'pending'),
(22, 'dawdaw', '42423', 'dawdaw', 259.94, '1617184783000', 'pending'),
(23, 'dawdaw', '42423', 'dawdaw', 259.94, '1617184826', 'pending'),
(24, 'dawdaw', '42423', 'dawdaw', 259.94, '2021-03-31 12:00:45pm', 'pending'),
(26, 'dwadw', '423423', 'dawdaw', 259.94, '2021-03-31 05:08:02pm', 'pending'),
(27, 'dhadaw', '31431', 'dwdawddw', 259.94, '2021-03-31 05:11:09pm', 'pending'),
(28, 'dhadaw', '31431', 'dwdawddw', 259.94, '2021-03-31 05:11:23pm', 'pending'),
(29, 'dnkawdaw', '11111', 'dwadaw', 259.94, '2021-03-31 05:11:32pm', 'pending'),
(30, 'dnkawdaw', '11111', 'dwadaw', 259.94, '2021-03-31 05:12:07pm', 'pending'),
(31, 'dawdaw', '32312', 'dwadawa', 259.94, '2021-03-31 05:12:41pm', 'pending'),
(999, 'dawdwa', '432432', 'dawdaw', 259.94, '2021-03-31 05:02:47pm', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `main_categorys`
--

CREATE TABLE `main_categorys` (
  `ID` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `main_categorys`
--

INSERT INTO `main_categorys` (`ID`, `name`) VALUES
(1, 'STUFFED ANIMALS'),
(2, 'TOY MODELS'),
(3, 'FASHION'),
(4, 'ELECTRONICS'),
(5, 'STATIONERY');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `desci` text NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `rrp` decimal(7,2) NOT NULL DEFAULT 0.00,
  `quantity` int(11) NOT NULL,
  `img` text NOT NULL,
  `date_added` datetime NOT NULL DEFAULT current_timestamp(),
  `category` varchar(100) NOT NULL,
  `brand` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `desci`, `price`, `rrp`, `quantity`, `img`, `date_added`, `category`, `brand`) VALUES
(1, 'Smart Watch', '<p>Unique watch made with stainless steel, ideal for those that prefer interative watches.</p>\r\n<h3>Features</h3>\r\n<ul>\r\n<li>Powered by Android with built-in apps.</li>\r\n<li>Adjustable to fit most.</li>\r\n<li>Long battery life, continuous wear for up to 2 days.</li>\r\n<li>Lightweight design, comfort on your wrist.</li>\r\n</ul>', '29.99', '0.00', 10, 'watch.jpg', '2019-03-13 17:55:22', 'anime', 'gucci'),
(2, 'Wallet', '', '14.99', '19.99', 34, 'wallet.jpg', '2019-03-13 18:52:49', 'anime', 'versace'),
(3, 'Headphones', '', '19.99', '0.00', 23, 'headphones.jpg', '2019-03-13 18:47:56', 'anime', 'gucci'),
(4, 'Digital Camera', '', '69.99', '0.00', 7, 'camera.jpg', '2019-03-13 17:42:04', 'dog', 'chanel');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billing`
--
ALTER TABLE `billing`
  ADD PRIMARY KEY (`id`),
  ADD KEY `BillID` (`BillID`);

--
-- Indexes for table `brands`
--
ALTER TABLE `brands`
  ADD PRIMARY KEY (`id`),
  ADD KEY `name` (`name`);

--
-- Indexes for table `categorys`
--
ALTER TABLE `categorys`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `main_category` (`main_category`),
  ADD KEY `name` (`name`);

--
-- Indexes for table `invoices`
--
ALTER TABLE `invoices`
  ADD PRIMARY KEY (`billingID`);

--
-- Indexes for table `main_categorys`
--
ALTER TABLE `main_categorys`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `brand` (`brand`),
  ADD KEY `category` (`category`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `billing`
--
ALTER TABLE `billing`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `brands`
--
ALTER TABLE `brands`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `categorys`
--
ALTER TABLE `categorys`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `invoices`
--
ALTER TABLE `invoices`
  MODIFY `billingID` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1001;

--
-- AUTO_INCREMENT for table `main_categorys`
--
ALTER TABLE `main_categorys`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `billing`
--
ALTER TABLE `billing`
  ADD CONSTRAINT `billing_ibfk_1` FOREIGN KEY (`BillID`) REFERENCES `invoices` (`billingID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `categorys`
--
ALTER TABLE `categorys`
  ADD CONSTRAINT `categorys_ibfk_1` FOREIGN KEY (`main_category`) REFERENCES `main_categorys` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
