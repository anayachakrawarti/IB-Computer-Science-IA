-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2020 at 11:26 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `number` int(11) NOT NULL,
  `item_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `last_stocked` date NOT NULL,
  `expiry_date` date NOT NULL,
  `stock_amount` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `inventory` (demo values)
--

INSERT INTO `inventory` (`number`, `item_name`, `last_stocked`, `expiry_date`, `stock_amount`) VALUES
(1, 'Apple', '2020-09-05', '2020-09-08', 100),
(2, 'Strawberry', '2020-09-04', '2020-09-07', 50),
(3, 'Banana', '2020-09-04', '2020-09-09', 125),
(4, 'Cabbage', '2020-09-03', '2020-09-10', 70),
(5, 'Garlic', '2020-09-06', '2020-09-12', 100),
(6, 'Tomato', '2020-09-05', '2020-09-08', 50),
(7, 'Orange', '2020-09-05', '2020-09-09', 75),
(8, 'Papaya', '2020-09-03', '2020-09-10', 25),
(9, 'Spinach', '2020-09-02', '2020-09-08', 75),
(10, 'Watermelon', '2020-09-04', '2020-09-09', 100),
(11, 'Potato', '2020-09-06', '2020-09-11', 150),
(12, 'Lemon', '2020-09-03', '2020-09-12', 75),
(13, 'Onion', '2020-09-02', '2020-09-09', 125),
(14, 'Musk Melon', '2020-09-09', '2020-09-13', 25),
(15, 'Grape', '2020-09-05', '2020-09-10', 175),
(16, 'Corriander', '2020-09-07', '2020-09-11', 50);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
