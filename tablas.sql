CREATE TABLE Usuario (
id INT not null primary key
GENERATED ALWAYS AS IDENTITY
(START WITH 1, INCREMENT BY 1),
nombre VARCHAR(40) not null unique,
contrasena VARCHAR(40) not null unique

);

CREATE TABLE Cuenta (
id INT not null primary key
GENERATED ALWAYS AS IDENTITY
(START WITH 1, INCREMENT BY 1),
id_user INT not null,
contrasena VARCHAR(60) not null,
nombre VARCHAR(60) not null,

CONSTRAINT userAjena1 FOREIGN KEY (id_user) REFERENCES Usuario (id) on delete cascade
);


INSERT INTO Usuario(nombre,contrasena)
VALUES ('admin','admin');
