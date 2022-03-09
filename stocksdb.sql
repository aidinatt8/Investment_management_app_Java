-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Мар 05 2022 г., 14:15
-- Версия сервера: 10.4.22-MariaDB
-- Версия PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `stocksdb`
--

-- --------------------------------------------------------

--
-- Структура таблицы `portfolios`
--

CREATE TABLE `portfolios` (
  `stockID` int(11) NOT NULL,
  `ticker` varchar(50) NOT NULL,
  `purchased price` float NOT NULL,
  `userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `portfolios`
--

INSERT INTO `portfolios` (`stockID`, `ticker`, `purchased price`, `userID`) VALUES
(4, 'AMD', 108.41, 1),
(5, 'F', 16.85, 1),
(6, 'AAL', 14.59, 1),
(8, 'SOFI', 10, 1),
(9, 'OXY', 56.15, 1),
(11, 'CLF', 25.95, 1),
(12, 'NIO', 18.63, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `userdb`
--

CREATE TABLE `userdb` (
  `ID` int(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `userdb`
--

INSERT INTO `userdb` (`ID`, `username`, `password`) VALUES
(1, 'username1', 'password1');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `portfolios`
--
ALTER TABLE `portfolios`
  ADD PRIMARY KEY (`stockID`);

--
-- Индексы таблицы `userdb`
--
ALTER TABLE `userdb`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `portfolios`
--
ALTER TABLE `portfolios`
  MODIFY `stockID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT для таблицы `userdb`
--
ALTER TABLE `userdb`
  MODIFY `ID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
