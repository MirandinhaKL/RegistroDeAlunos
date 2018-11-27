CREATE DATABASE registro;

USE registro;

CREATE TABLE alunos(
	id INT(11) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO `alunos` VALUES (1,'Amerigo','Calveley'),(2,'Deni','Greatbanks'),(3,'Dell','Coslitt'),(4,'Raina','Blader'),(5,'Cosetta','Kiddy'),(6,'Sharleen','Twyning'),(7,'Remy','Rattray'),(8,'Kendrick','Jubb'),(9,'Cathi','Conisbee'),(10,'Dayna','Harbar');

