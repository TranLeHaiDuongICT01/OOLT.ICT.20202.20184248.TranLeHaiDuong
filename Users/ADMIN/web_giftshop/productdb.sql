-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2021 at 02:04 AM
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
(1, 'gucci'),
(2, 'chanel'),
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
(8, 2, 'MANGE & ANIME'),
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
  `category` int(11) NOT NULL,
  `brand` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `desci`, `price`, `rrp`, `quantity`, `img`, `date_added`, `category`, `brand`) VALUES
(1, 'Smart Watch', '<p>Unique watch made with stainless steel, ideal for those that prefer interative watches.</p>\r\n<h3>Features</h3>\r\n<ul>\r\n<li>Powered by Android with built-in apps.</li>\r\n<li>Adjustable to fit most.</li>\r\n<li>Long battery life, continuous wear for up to 2 days.</li>\r\n<li>Lightweight design, comfort on your wrist.</li>\r\n</ul>', '29.99', '0.00', 10, 'watch.jpg', '2019-03-13 17:55:22', 1, 'Gucci'),
(2, 'Wallet', '', '14.99', '19.99', 34, 'wallet.jpg', '2019-03-13 18:52:49', 1, 'Versace'),
(3, 'Headphones', '', '19.99', '0.00', 23, 'headphones.jpg', '2019-03-13 18:47:56', 1, 'Gucci'),
(4, 'Digital Camera', '', '69.99', '0.00', 7, 'camera.jpg', '2019-03-13 17:42:04', 4, 'chanel');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brands`
--
ALTER TABLE `brands`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `categorys`
--
ALTER TABLE `categorys`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `main_category` (`main_category`);

--
-- Indexes for table `main_categorys`
--
ALTER TABLE `main_categorys`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

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
-- AUTO_INCREMENT for table `main_categorys`
--
ALTER TABLE `main_categorys`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
