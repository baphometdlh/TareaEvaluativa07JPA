insert into bands.estilo (id, nombre, pais_creacion) values (1,'death metal','suecia');
insert into bands.estilo (id, nombre, pais_creacion) values (2,'doom','inglaterra');
insert into bands.estilo (id, nombre, pais_creacion) values (3,'brutal death','estados unidos');
insert into bands.estilo (id, nombre, pais_creacion) values (4,'death progresivo','suecia');

insert into bands.grupo (id, nombre, pais, ano_creacion) values (1,'katatonia', 'suecia', '1991');
insert into bands.grupo (id, nombre, pais, ano_creacion) values  (2,'opeth', 'suecia', '1990');
insert into bands.grupo (id, nombre, pais, ano_creacion) values (3,'deicide', 'estados unidos', '1987');

insert into bands.disco (id, nombre, ano_publicacion, id_grupo, id_estilo, duracion) values (1, 'morningrise', '1996', 2, 1, 56);
insert into bands.disco (id, nombre, ano_publicacion, id_grupo, id_estilo, duracion) values (2, 'orchid', '1996', 2, 1, 45);
insert into bands.disco (id, nombre, ano_publicacion, id_grupo, id_estilo, duracion) values (3, 'brave murder day', '1996', 1, 2, 42);
insert into bands.disco (id, nombre, ano_publicacion, id_grupo, id_estilo, duracion) values (4, 'viva emptiness', '2003', 2, 1, 67);
insert into bands.disco (id, nombre, ano_publicacion, id_grupo, id_estilo, duracion) values (5, 'decide', '1990', 3, 3, 33);
insert into bands.disco (id, nombre, ano_publicacion, id_grupo, id_estilo, duracion) values (6, 'once upon the cross', '1995', 3, 3, 28);