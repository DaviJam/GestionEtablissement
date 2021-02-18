-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  mar. 26 jan. 2021 à 13:32
-- Version du serveur :  8.0.22-0ubuntu0.20.04.2
-- Version de PHP :  7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `GestionEtablissement`
--

-- --------------------------------------------------------

--
-- Structure de la table `Course`
--

CREATE TABLE `Course` (
  `id` int NOT NULL,
  `coursesubject` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nbhours` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `Course`
--

INSERT INTO `Course` (`id`, `coursesubject`, `nbhours`) VALUES
(79, 'Français', 2),
(80, 'Enseignement moral et civique', 3),
(81, 'EPS', 4),
(82, 'Anglais', 1),
(83, 'Espagnol', 2),
(85, 'Physique chimie', 2),
(86, 'SVT', 2),
(87, 'Mathématiques', 4),
(88, 'Java', 9);

-- --------------------------------------------------------

--
-- Structure de la table `Course_Person`
--

CREATE TABLE `Course_Person` (
  `idPerson` int NOT NULL,
  `idCourse` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `Course_Person`
--

INSERT INTO `Course_Person` (`idPerson`, `idCourse`) VALUES
(117, 79),
(118, 80),
(119, 81),
(120, 82),
(121, 83),
(118, 87);

-- --------------------------------------------------------

--
-- Structure de la table `Person`
--

CREATE TABLE `Person` (
  `id` int NOT NULL,
  `firstname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `role` int NOT NULL DEFAULT '4',
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dateofbirth` date DEFAULT NULL,
  `subjecttaught` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `Person`
--

INSERT INTO `Person` (`id`, `firstname`, `lastname`, `email`, `address`, `phone`, `role`, `password`, `dateofbirth`, `subjecttaught`) VALUES
(6, 'Chaumont', 'Eric', 'e.chaumont@ensup.eu', '34 rue du général De Gaule 75001', '0641458596', 1, 'e.chaumont', NULL, NULL),
(7, 'Demaison', 'Magalie', 'm.demaison@ensup.eu', '124 avenue de Paris 75016', '0685749685', 2, 'm.demaison', NULL, NULL),
(117, 'Parker', 'John', 'j.parker@ensup.eu', '25 rue des fleurs 54100', '0641458596', 4, 'j.parker', '2001-03-08', NULL),
(118, 'Mark', 'Ruben', 'm.ruben@ensup.eu', '10 bis avenue du bois 41000', '0685984552', 4, 'm.ruben', '2020-10-01', NULL),
(119, 'Chaumez', 'Bernard', 'b.chaumez@ensup.eu', '53 rue de Saint Germain 95550', '0612539874', 4, 'b.chaumez', '2000-08-11', NULL),
(120, 'Gigon', 'Bernadette', 'b.gigon@ensup.eu', '36 quai des orfévres 78100', '0605248587', 4, 'b.gigon', '1995-06-22', NULL),
(121, 'Moulin', 'Pierre', 'p.moulin@ensup.eu', '10 rue Jean Moulin 95630', '0601854596', 4, 'p.moulin', '1997-02-11', NULL),
(127, 'Dupont', 'Pierre', 'pdp@mail.gc', '5 rue des prés', '0823654819', 4, '123456', '1999-06-06', NULL),
(134, 'a', 'a', 'a', 'a', '12345678', 4, 'a', '1993-03-06', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `School`
--

CREATE TABLE `School` (
  `id` int NOT NULL,
  `surname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `director` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `School`
--

INSERT INTO `School` (`id`, `surname`, `email`, `address`, `phone`, `director`) VALUES
(4, 'Ensup', 'ensup@gmail.com', '1 bis Avenue du 8 mai 1945', '0161380575', 6);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Course`
--
ALTER TABLE `Course`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Course_Person`
--
ALTER TABLE `Course_Person`
  ADD PRIMARY KEY (`idPerson`,`idCourse`),
  ADD KEY `fk_person_course` (`idCourse`);

--
-- Index pour la table `Person`
--
ALTER TABLE `Person`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `School`
--
ALTER TABLE `School`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_person_school` (`director`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Course`
--
ALTER TABLE `Course`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89;

--
-- AUTO_INCREMENT pour la table `Person`
--
ALTER TABLE `Person`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=135;

--
-- AUTO_INCREMENT pour la table `School`
--
ALTER TABLE `School`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Course_Person`
--
ALTER TABLE `Course_Person`
  ADD CONSTRAINT `fk_course_person` FOREIGN KEY (`idPerson`) REFERENCES `Person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_person_course` FOREIGN KEY (`idCourse`) REFERENCES `Course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `School`
--
ALTER TABLE `School`
  ADD CONSTRAINT `fk_person_school` FOREIGN KEY (`director`) REFERENCES `Person` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
