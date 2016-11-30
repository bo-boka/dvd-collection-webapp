DROP DATABASE IF EXISTS DVDCollection;
CREATE DATABASE DVDCollection;

USE DVDCollection;

CREATE TABLE DVDs(
	`id` INT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(50) NOT NULL,
	`releaseDate` VARCHAR(50),
	`mpaaRating` VARCHAR(50),
	`director` VARCHAR(50),
	`studio` VARCHAR(50),
	`userNote` VARCHAR(250),
	PRIMARY KEY(`id`)
);

INSERT INTO `DVDs` (`id`, `title`, `releaseDate`, `mpaaRating`, `director`, `studio`, `userNote`)
			VALUES (1, "Army of Darkness", "10/20/1995", "R", "Guy Something", "Dark Arts", "This is my boomstick"),
					(2, "How Stella Got Her Groove Back", "07/03/1991", "R", "Pete Peterson", "Groovy Studios", "Pretty groovy"),
					(3, "Tank Girl", "07/03/1993", "R", "Gnome Beet", "Gnoll Studios", "Pretty crazy stuff"),
					(4, "Earthlings", "07/03/2001", "R", "Randolf Gupson", "Change Studios", "Thought provoking"),
					(5, "Zootopia", "07/03/2012", "PG", "Christy Christianson", "Pixar", "Gotta love these movies"),
					(6, "Shawn of the Dead", "08/11/2001", "R", "Pete Peterson", "Studio Studios", "Funny if you're into that kind of thing");
