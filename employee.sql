-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2020 at 11:25 AM
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
-- Database: `employee`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `employee_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `employee_age` int(11) NOT NULL,
  `phone_number` int(12) NOT NULL,
  `delivery_area` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `employee_deliveries` int(11) NOT NULL,
  `employee_salary` float(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employee` (demo values)
--

INSERT INTO `employee` (`id`, `employee_name`, `employee_age`, `phone_number`, `delivery_area`, `employee_deliveries`, `employee_salary`) VALUES
(1, 'John Doe', 25, 5553476, 'King\'s Cross', 29, 340),
(2, 'Adam Smith', 22, 5559260, 'Maple Valley', 35, 400),
(3, 'Kio Michaels', 29, 5557105, 'College Road', 53, 580),
(4, 'Antonio Gomez', 26, 5550307, 'Baxter Hill', 25, 300),
(5, 'Bruce James', 35, 5558328, 'Maple Valley', 50, 550),
(6, 'Oliver Clark', 24, 5559834, 'City District', 32, 370),
(7, 'Jordan Kyle', 32, 5555293, 'Fleet Street', 29, 340),
(8, 'Mike Washington', 21, 5553849, 'King\'s Cross', 30, 350);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
