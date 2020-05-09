-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2020 at 03:18 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `workflowsuite`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_core`
--

CREATE TABLE `user_core` (
  `_email` varchar(64) NOT NULL,
  `_password` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_core`
--

INSERT INTO `user_core` (`_email`, `_password`) VALUES
('asdasd', 'postman');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `_email` varchar(64) DEFAULT NULL,
  `_firstName` varchar(64) DEFAULT NULL,
  `_lastName` varchar(64) DEFAULT NULL,
  `_address` varchar(64) DEFAULT NULL,
  `_city` varchar(32) DEFAULT NULL,
  `userType` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`_email`, `_firstName`, `_lastName`, `_address`, `_city`, `userType`) VALUES
('postman@teFs2t.com', 'post', 'man', 'desktop', 'none', 'employee');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_core`
--
ALTER TABLE `user_core`
  ADD PRIMARY KEY (`_email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
