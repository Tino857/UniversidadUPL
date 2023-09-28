-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-09-2023 a las 22:09:59
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 7.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `universidad`
--
CREATE DATABASE IF NOT EXISTS `universidad` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `universidad`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL,
  `dni` int(11) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) VALUES
(1, 37892972, 'Perez', 'Juan Carlos', '1994-04-15', 1),
(2, 32567890, 'Lopez', 'Maria', '1996-09-22', 1),
(3, 38945678, 'Garcia', 'Luis', '1998-05-10', 1),
(4, 36321458, 'Rodriguez', 'Ana', '1995-07-31', 1),
(5, 39874632, 'Martinez', 'Carlos', '1997-12-18', 1),
(6, 35478632, 'Sanchez', 'Laura', '1993-03-27', 1),
(7, 39876543, 'Fernandez', 'Carlos', '1992-08-05', 1),
(8, 36781245, 'Gomez', 'Ana Maria', '1999-01-12', 1),
(9, 38567432, 'Diaz', 'Luis Alberto', '1991-11-28', 1),
(10, 37214569, 'Pereira', 'Lucia', '1990-06-14', 1),
(11, 39456721, 'Alvarez', 'Pedro', '1998-02-03', 1),
(12, 39672306, 'Cabral', 'Rodrigo', '1997-01-12', 1),
(13, 41235687, 'Gonzalez', 'María Elena', '1999-03-18', 1),
(14, 39871254, 'Fernández', 'Andrés', '1997-09-10', 1),
(15, 38124567, 'Silva', 'Luisa', '1995-05-22', 1),
(16, 37781234, 'Martínez', 'Santiago', '1998-12-07', 1),
(17, 39567812, 'Pérez', 'Luciana', '1994-07-29', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `idInscripto` int(11) NOT NULL,
  `nota` double DEFAULT NULL,
  `idAlumno` int(11) DEFAULT NULL,
  `idMateria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`idInscripto`, `nota`, `idAlumno`, `idMateria`) VALUES
(1, 9, 1, 1),
(2, 8, 1, 2),
(3, 9, 1, 3),
(4, 6, 1, 10),
(5, 8, 2, 8),
(6, 9, 2, 11),
(7, 10, 2, 12),
(8, 7, 2, 7),
(9, 8.5, 1, 8),
(11, 7.2, 3, 12),
(12, 9.4, 6, 15),
(13, 6.9, 8, 7),
(14, 8, 10, 2),
(16, 8, 3, 7),
(17, 7, 4, 11),
(18, 8, 4, 5),
(19, 10, 4, 15),
(20, 9, 5, 10),
(21, 8, 5, 9),
(22, 10, 5, 4),
(23, 2, 5, 12),
(24, 7, 6, 13),
(25, 4, 6, 8),
(26, 2, 6, 7),
(27, 9, 6, 9),
(28, 10, 7, 12),
(29, 9, 7, 8),
(30, 7, 7, 4),
(31, 9, 8, 14),
(32, 10, 8, 13),
(33, 7, 8, 6),
(34, 3, 8, 15),
(35, 5, 3, 8),
(36, 9, 3, 9),
(37, 7, 4, 3),
(38, 8, 4, 6),
(39, 2, 7, 2),
(40, 7, 7, 13),
(41, 7, 9, 2),
(42, 8, 9, 9),
(43, 3, 9, 11),
(44, 7, 9, 14),
(45, 7, 10, 4),
(46, 8, 10, 10),
(47, 5, 10, 12),
(48, 9, 11, 13),
(49, 7, 11, 14),
(50, 7, 11, 8),
(51, 10, 11, 3),
(52, 5, 11, 5),
(53, 3, 13, 2),
(54, 8, 13, 8),
(55, 7, 13, 3),
(56, 9, 13, 13),
(57, 7, 13, 14),
(58, 10, 14, 4),
(59, 9, 14, 6),
(60, 7, 14, 9),
(61, 3, 14, 11),
(62, 7, 14, 13),
(63, 8, 14, 14),
(64, 10, 15, 3),
(65, 9, 15, 8),
(66, 9, 15, 13),
(67, 9, 15, 14),
(68, 10, 15, 9),
(69, 8, 16, 12),
(70, 2, 16, 10),
(71, 8, 16, 15),
(72, 7, 16, 7),
(73, 7, 16, 4),
(74, 8, 16, 1),
(75, 10, 17, 9),
(76, 8, 17, 13),
(77, 3, 17, 14),
(78, 9, 17, 15),
(79, 5, 17, 7),
(80, 7, 12, 8),
(81, 8, 12, 4),
(82, 9, 12, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `idMateria` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `año` int(11) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`idMateria`, `nombre`, `año`, `estado`) VALUES
(1, 'Analisis Matematico I', 1, 1),
(2, 'Analisis Matematico II', 2, 1),
(3, 'Analisis Matematico III', 3, 1),
(4, 'Algebra I', 1, 1),
(5, 'Historia II', 2, 1),
(6, 'Algebra II', 2, 1),
(7, 'Física I', 1, 1),
(8, 'Química Orgánica', 3, 1),
(9, 'Historia del Arte', 2, 1),
(10, 'Programación', 1, 1),
(11, 'Literatura', 2, 1),
(12, 'Biología I', 1, 1),
(13, 'Derecho Internacional', 3, 1),
(14, 'Economía', 3, 1),
(15, 'Geografía', 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idAlumno`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`idInscripto`),
  ADD UNIQUE KEY `idAlumno` (`idAlumno`,`idMateria`),
  ADD KEY `idMateria` (`idMateria`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idMateria`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `idInscripto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`),
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
