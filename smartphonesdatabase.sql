-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2025 at 03:53 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smartphonesdatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `operatingsystem`
--

CREATE TABLE `operatingsystem` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `operatingsystem`
--

INSERT INTO `operatingsystem` (`id`, `name`) VALUES
(0, 'android'),
(1, 'iOS');

-- --------------------------------------------------------

--
-- Table structure for table `smartphones`
--

CREATE TABLE `smartphones` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ram` int(11) DEFAULT NULL,
  `batterysize` int(11) DEFAULT NULL,
  `processorspeed` double DEFAULT NULL,
  `screensize` double DEFAULT NULL,
  `storage` int(11) DEFAULT NULL,
  `os_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `smartphones`
--

INSERT INTO `smartphones` (`id`, `name`, `ram`, `batterysize`, `processorspeed`, `screensize`, `storage`, `os_id`) VALUES
(269, 'iphone19', 10, 4650, 2.7, 6.3, 128, 1),
(270, 'pixel12', 9, 5400, 1.5, 6.5, 512, 0),
(271, 'iphone17', 7, 3950, 2.4, 6.2, 128, 1),
(272, 'pixel11', 5, 5100, 1.3, 6.4, 256, 0),
(273, 'oneplus13', 100, 6300, 2.2, 6.6, 256, 0),
(274, 'pixel 13', 8, 5200, 1.4, 6.2, 128, 0),
(275, 'iphone16', 11, 4750, 2.6, 6.1, 256, 1),
(276, 'testphone3', 3, 300, 1.5, 3.7, 64, 0),
(277, 'WSB3330', 1, 140, 0.4, 2.3, 3, 0),
(278, '12345', 323, 433, 415, 4340, 256, 1),
(279, '3', 3, 3, 3, 3, 3, 1),
(280, 'testui3', 4, 3625, 7.1, 3.7, 256, 0),
(281, 'redd3', 24, 7, 12.5, 4.2, 35, 0),
(282, 'iphone21', 9, 4850, 2.8, 6.3, 512, 1),
(283, 'pixel14', 6, 5300, 1.5, 6.5, 128, 0),
(284, 'iphone14max', 8, 4100, 2.5, 6.5, 256, 1),
(285, 'pixel15', 7, 5500, 1.6, 6.6, 128, 0),
(286, 'oneplus 14', 150, 6500, 2.3, 6.7, 512, 0),
(287, 'pixel16', 10, 5400, 1.5, 6.3, 128, 0),
(288, 'iphone22', 13, 4950, 2.7, 6.4, 256, 1),
(289, 'testphone4', 5, 350, 1.6, 3.8, 64, 0),
(290, 'WSB3340', 1, 150, 0.5, 2.4, 4, 0),
(291, 'The Strokes', 12, 2001, 4.2, 6.6, 512, 0),
(292, 'newhtml', 56, 1256, 2.5, 6.2, 512, 0),
(293, 'coffee', 1, 3, 2, 4, 5, 0),
(296, 'eclipse', 4, 12, 8, 16, 20, 1),
(297, 'intellij', 6, 18, 12, 24, 30, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `smartphones`
--
ALTER TABLE `smartphones`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `smartphones`
--
ALTER TABLE `smartphones`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=298;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
