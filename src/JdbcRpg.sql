
CREATE DATABASE JdbcRpg;

USE JdbcRpg;

CREATE TABLE RpgEntry (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  description VARCHAR(2000),
  optionsId INT,
  level INT,
  chosenOption INT
);

CREATE TABLE Options_RpgEntry(
  optionsId INT,
  RpgEntryId INT
);

CREATE TABLE Options (
  id INT PRIMARY KEY AUTO_INCREMENT,
  description VARCHAR(2000)
);

DELETE Options, Options_RpgEntry, RpgEntry FROM Options, Options_RpgEntry, RpgEntry;

INSERT INTO RpgEntry (description, level) VALUES
  ('Você entra em uma caverna escura e na sua frente voce percebe uma lanterna e uma tocha:', 1);
INSERT INTO Options (description) VALUES
  ('Pegar lanterna');
INSERT INTO Options (description) VALUES
  ('Pegar tocha');
INSERT INTO Options_RpgEntry VALUES (1, 1);
INSERT INTO Options_RpgEntry VALUES (2, 1);

INSERT INTO RpgEntry (description, level, chosenOption) VALUES
  ('A sua direita voce avista o que aparenta ser uma entrada e a na esquerda apenas uma clarão de luz', 2, 1);

INSERT INTO Options (description) VALUES
  ('Andar até o clarão');
INSERT INTO Options (description) VALUES
  ('Andar até a entrada');

INSERT INTO Options_RpgEntry VALUES (3, 2);
INSERT INTO Options_RpgEntry VALUES (4, 2);

INSERT INTO RpgEntry (description, level, chosenOption) VALUES
  ('Voce avista um clarão de luz', 2, 2);
INSERT INTO Options (description) VALUES
  ('Andar até o clarão');
INSERT INTO Options (description) VALUES
  ('Continuar andando');

INSERT INTO Options_RpgEntry VALUES (5, 3);
INSERT INTO Options_RpgEntry VALUES (6, 3);

INSERT INTO RpgEntry (description, level, chosenOption) VALUES
  ('Voce achou a saida!', 3, 1);

INSERT INTO RpgEntry (description, level, chosenOption) VALUES
  ('Voce achou a saida!', 3, 2);

