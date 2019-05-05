-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-05-2019 a las 05:35:33
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `uaifus`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `episodes`
--

CREATE TABLE `episodes` (
  `id_episode` int(11) NOT NULL,
  `name_episode` varchar(45) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `url_video` varchar(145) DEFAULT NULL,
  `id_season` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `episodes`
--

INSERT INTO `episodes` (`id_episode`, `name_episode`, `duration`, `url_video`, `id_season`) VALUES
(8, 'Pol', 24, 'C:\\Users\\Samue\\Documents\\Facultad\\8vo Semestre\\Desarrollo Nube\\Proyecto\\RecursosUAIFUS\\videos\\isaac_2.mp4', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favourites`
--

CREATE TABLE `favourites` (
  `id_usuario` int(11) NOT NULL,
  `id_serie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seasons`
--

CREATE TABLE `seasons` (
  `id_season` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `id_Serie` int(11) DEFAULT NULL,
  `num_votes` int(11) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `seasons`
--

INSERT INTO `seasons` (`id_season`, `name`, `rate`, `id_Serie`, `num_votes`) VALUES
(6, 'No lo se', 8.2, 4, 10),
(7, 'Aun no lo sé', 10, 4, 1),
(8, 'uwu', 10, 4, 1),
(9, 'Arco de la vida', 10, 5, 1),
(10, 'Arco de la escuelo', 10, 5, 1),
(11, 'Arco de laholyshit', 10, 5, 1),
(12, 'Arco de varia', 10, 5, 1),
(13, 'Arco de Aincrad', 10, 9, 1),
(14, 'Arco de Gun gale', 10, 9, 1),
(15, 'Arco de Alfheim', 10, 9, 1),
(16, 'Arco de Allumn', 10, 9, 1),
(17, 'Arco de Alpostol', 10, 9, 1),
(18, 'Arco de Alpostol', 10, 9, 1),
(19, 'Arco de paco', 10, 9, 1),
(20, 'Arco de paco', 10, 9, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `series`
--

CREATE TABLE `series` (
  `id` int(11) NOT NULL,
  `name_serie` varchar(45) DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `description` varchar(450) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `series`
--

INSERT INTO `series` (`id`, `name_serie`, `genre`, `rate`, `description`) VALUES
(4, 'Gintama', 'Comedia', 7, 'Anime favorito del chino'),
(5, 'KHR', 'Shonen', 10, 'Anime favorito de Sharlie'),
(6, 'One Piece', 'Shonen', 10, 'Anime favorito de Miguel'),
(7, 'Jo-Jo', 'Shonen', 10, 'Anime favorito de Sharlie'),
(8, 'Berserk', 'Shonen', 10, 'muy sad man'),
(9, 'SAO', 'Shonen', 10, 'Anime favorito de uchiha');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `token` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `password`, `token`) VALUES
(7, 'Charlie76', '12345678', '7e24321b-74bd-4e5b-8d61-fafbe1212208'),
(11, 'Charlie77', '12345678', NULL),
(12, 'Charlie78', '12345678', NULL),
(13, 'Charlie79', '12345678', NULL),
(14, 'Charlie80', '12345678', NULL),
(15, 'Charlie81', '12345678', NULL),
(16, 'Charlie74', '12345678', NULL),
(17, 'Charlie72', '12345678', '25d3361f-b5e2-4346-8e4c-05c9fe49c63a'),
(18, 'SamuelAke', '12345678', '003f9875-c9f0-43f2-8041-180f71596955'),
(19, 'SamuelAkeTello', '12345678', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `episodes`
--
ALTER TABLE `episodes`
  ADD PRIMARY KEY (`id_episode`),
  ADD KEY `idSeason` (`id_season`);

--
-- Indices de la tabla `favourites`
--
ALTER TABLE `favourites`
  ADD PRIMARY KEY (`id_usuario`,`id_serie`);

--
-- Indices de la tabla `seasons`
--
ALTER TABLE `seasons`
  ADD PRIMARY KEY (`id_season`),
  ADD KEY `idSerie` (`id_Serie`);

--
-- Indices de la tabla `series`
--
ALTER TABLE `series`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `episodes`
--
ALTER TABLE `episodes`
  MODIFY `id_episode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `seasons`
--
ALTER TABLE `seasons`
  MODIFY `id_season` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `series`
--
ALTER TABLE `series`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `episodes`
--
ALTER TABLE `episodes`
  ADD CONSTRAINT `idSeason` FOREIGN KEY (`id_season`) REFERENCES `seasons` (`id_season`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `favourites`
--
ALTER TABLE `favourites`
  ADD CONSTRAINT `idUsuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `seasons`
--
ALTER TABLE `seasons`
  ADD CONSTRAINT `idSerie` FOREIGN KEY (`id_Serie`) REFERENCES `series` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
