drop table Convalidacion;
drop table Asignatura_destino;
drop table Asignatura_origen;
drop table Estancia;
drop table Universidad_destino;
drop table Coordinador;
drop table Alumno;
drop table Usuario;
drop table Grado;






CREATE TABLE public.Coordinador(
	DNI varchar NOT NULL,
	Passw varchar,
	Nombre varchar,
	Apellidos varchar,
	Nombre_usuario_Usuario varchar,
	Departamento varchar,
	CONSTRAINT Profesor_pk PRIMARY KEY (DNI)

);

ALTER TABLE public.Coordinador OWNER TO postgres;


CREATE TABLE public.Alumno(
	DNI varchar NOT NULL,
	Passw varchar,
	Nombre varchar,
	Apellidos varchar,
	Nombre_usuario_Usuario varchar,
	Codigo_Grado varchar,
	CONSTRAINT Alumno_pk PRIMARY KEY (DNI)

);
ALTER TABLE public.Alumno OWNER TO postgres;



CREATE TABLE public.Asignatura_origen(
	Codigo varchar NOT NULL,
	Creditos smallint,
	Nombre varchar,
	Informacion varchar,
	Tipo varchar,
	CONSTRAINT Asignatura_origen_pk PRIMARY KEY (Codigo)

);
ALTER TABLE public.Asignatura_origen OWNER TO postgres;




CREATE TABLE public.Usuario(
	Nombre_usuario varchar NOT NULL,
	CONSTRAINT Usuario_pk PRIMARY KEY (Nombre_usuario)

);
ALTER TABLE public.Usuario OWNER TO postgres;

ALTER TABLE public.Coordinador ADD CONSTRAINT Usuario_fk FOREIGN KEY (Nombre_usuario_Usuario)
REFERENCES public.Usuario (Nombre_usuario) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.Alumno ADD CONSTRAINT Usuario_fk FOREIGN KEY (Nombre_usuario_Usuario)
REFERENCES public.Usuario (Nombre_usuario) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.Asignatura_destino(
	Codigo varchar NOT NULL,
	Creditos smallint,
	Nombre varchar,
	Informacion varchar,
	Codigo_erasmus_Universidad_destino varchar,
	CONSTRAINT Asignatura_destino_pk PRIMARY KEY (Codigo)

);
ALTER TABLE public.Asignatura_destino OWNER TO postgres;



CREATE TABLE public.Grado(
	Codigo varchar NOT NULL,
	Nombre varchar,
	Facultad varchar,
	CONSTRAINT Grado_pk PRIMARY KEY (Codigo)

);
ALTER TABLE public.Grado OWNER TO postgres;

ALTER TABLE public.Alumno ADD CONSTRAINT Grado_fk FOREIGN KEY (Codigo_Grado)
REFERENCES public.Grado (Codigo) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.Universidad_destino(
	Codigo_erasmus varchar NOT NULL,
	Nombre varchar,
	Pais varchar,
	Ciudad varchar,
	CONSTRAINT Universidad_destino_pk PRIMARY KEY (Codigo_erasmus)

);
ALTER TABLE public.Universidad_destino OWNER TO postgres;



CREATE TABLE public.Estancia(
	id_estancia integer NOT NULL,
	Tipo varchar,
	Curso_academico varchar,
	Duracion varchar,
	Renuncia boolean,
	DNI_Alumno varchar,
	DNI_Coordinador varchar,
	Codigo_erasmus_Universidad_destino varchar,
	CONSTRAINT Beca_pk PRIMARY KEY (id_estancia)

);




ALTER TABLE public.Estancia OWNER TO postgres;

ALTER TABLE public.Asignatura_destino ADD CONSTRAINT Universidad_destino_fk FOREIGN KEY (Codigo_erasmus_Universidad_destino)
REFERENCES public.Universidad_destino (Codigo_erasmus) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;


CREATE TABLE public.Convalidacion(
	id_convalidacion integer NOT NULL,
	Estado varchar,
	Comentarios varchar,
	fecha_convalidacion date,
	id_estancia_Estancia integer,
	Codigo_Asignatura_destino varchar,
	Codigo_Asignatura_origen varchar,
	CONSTRAINT Convalidacion_pk PRIMARY KEY (id_convalidacion)

);
ALTER TABLE public.Convalidacion OWNER TO postgres;






ALTER TABLE public.Convalidacion ADD CONSTRAINT Estancia_fk FOREIGN KEY (id_estancia_Estancia)
REFERENCES public.Estancia (id_estancia) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.Estancia ADD CONSTRAINT Alumno_fk FOREIGN KEY (DNI_Alumno)
REFERENCES public.Alumno (DNI) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.Estancia ADD CONSTRAINT Estancia_uq UNIQUE (DNI_Alumno);

ALTER TABLE public.Convalidacion ADD CONSTRAINT Asignatura_destino_fk FOREIGN KEY (Codigo_Asignatura_destino)
REFERENCES public.Asignatura_destino (Codigo) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.Estancia ADD CONSTRAINT Coordinador_fk FOREIGN KEY (DNI_Coordinador)
REFERENCES public.Coordinador (DNI) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.Estancia ADD CONSTRAINT Universidad_destino_fk FOREIGN KEY (Codigo_erasmus_Universidad_destino)
REFERENCES public.Universidad_destino (Codigo_erasmus) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.Convalidacion ADD CONSTRAINT Asignatura_origen_fk FOREIGN KEY (Codigo_Asignatura_origen)
REFERENCES public.Asignatura_origen (Codigo) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;


INSERT INTO Usuario values('javi040898');
INSERT INTO Usuario values('javimart');
select * from usuario;
INSERT INTO Grado values(1,'GII','EPS');

INSERT INTO Coordinador values('47231977M','12345','Javier','Martin Gomez','javi040898','Computacion');

INSERT INTO Alumno values('47231972T','12345','Javier','Martin Gonzalez','javimart','1');
DELETE FROM Alumno WHERE nombre='b';
DELETE FROM Usuario WHERE nombre_usuario='b';
INSERT INTO Estancia VALUES('1','Erasmus','20-21','Un cuatrimestre',false,'47231972T','47231977M','K07');
DELETE FROM Estancia WHERE id_estancia>2;


INSERT INTO Asignatura_origen VALUES('1',6,'Bases de datos','www.bd.com','basica');
INSERT INTO Asignatura_destino VALUES('111',6,'Database','www.db.com','K07');
INSERT INTO Convalidacion VALUES('1','Pendiente',' ',CURRENT_DATE,'1','111','1');
DELETE FROM Convalidacion WHERE id_convalidacion>1;

INSERT INTO Asignatura_origen VALUES('2',6,'Programacion','www.programacion.com','basica');
INSERT INTO Asignatura_origen VALUES('3',6,'Matematicas','www.matematicas.com','obligatoria');
INSERT INTO Asignatura_destino VALUES('154',3,'Programme 1','www.p1.com','K07');
INSERT INTO Asignatura_destino VALUES('155',3,'Programme 2','www.p2.com','K07');
INSERT INTO Convalidacion VALUES('2','Pendiente',' ',CURRENT_DATE,'1','154','2');
INSERT INTO Convalidacion VALUES('3','Pendiente',' ',CURRENT_DATE,'1','155','2');

INSERT INTO Asignatura_origen VALUES('3',6,'Matematicas','www.matematicas.com','obligatoria');
INSERT INTO Asignatura_destino VALUES('268',4,'Maths 1','www.m1.com','K07');
INSERT INTO Asignatura_destino VALUES('269',4,'Maths 2','www.m2.com','K07');
INSERT INTO Convalidacion VALUES('4','Pendiente',' ',CURRENT_DATE,'1','268','3');
INSERT INTO Convalidacion VALUES('5','Pendiente',' ',CURRENT_DATE,'1','269','3');


DELETE FROM Asignatura_origen WHERE Codigo='2907';






INSERT INTO Universidad_destino VALUES('K07','Universidad de Touluse','Francia','Touluse');

UPDATE Convalidacion SET Estado = 'Pendiente' where Codigo_Asignatura_destino = '111';
UPDATE Convalidacion SET Comentarios = '' where Codigo_Asignatura_destino = '111';

UPDATE Asignatura_destino SET Informacion = 'http://www.forosdelweb.com/f53/cambiar-ancho-input-file-943503/#:~:text=Respuesta%3A%20Cambiar%20el%20ancho%20de,de%20la%20propia%20etiqueta%20input.' 
where Codigo = '111';

select Codigo_Asignatura_origen,Asignatura_origen.nombre,Asignatura_origen.tipo,Asignatura_origen.creditos,Asignatura_origen.informacion,
Codigo_Asignatura_destino,Asignatura_destino.nombre as nombre_destino,Asignatura_destino.creditos as creditos_destino,
Asignatura_destino.informacion as informacion_destino, Universidad_destino.Nombre as nombre_universidad,
fecha_convalidacion,curso_academico,
estado,comentarios
from Convalidacion inner join Estancia on id_estancia_Estancia=id_estancia
inner join Asignatura_origen on Asignatura_origen.Codigo = Codigo_Asignatura_origen
inner join Asignatura_destino on Codigo_Asignatura_destino=Asignatura_destino.Codigo inner join Universidad_destino on
Estancia.Codigo_erasmus_Universidad_destino = Codigo_erasmus where DNI_Alumno='47231972T';



select sum(creditos) as suma_creditos from (select distinct Asignatura_origen.*
from Convalidacion inner join Estancia on id_estancia_Estancia=id_estancia
inner join Asignatura_origen on Asignatura_origen.Codigo = Codigo_Asignatura_origen 
inner join Asignatura_destino on Codigo_Asignatura_destino=Asignatura_destino.Codigo where DNI_Alumno='47231972T') as asignaturas_distintas;

SELECT Alumno.* from Alumno inner join Estancia on DNI_Alumno=Alumno.DNI 
inner join Coordinador on DNI_Coordinador=Coordinador.DNI where Coordinador.DNI='47231977M';

SELECT Nombre, Apellidos from Alumno;

select Passw from Coordinador where Nombre_usuario_Usuario='javi040898';

select passw from Alumno where Nombre_usuario_Usuario='javimart';

select * from Estancia;

select * from Alumno;
SELECT Alumno.* from Alumno inner join Estancia on DNI_Alumno=Alumno.DNI 
                    inner join Coordinador on DNI_Coordinador=Coordinador.DNI where Coordinador.DNI='47231977M';
select * from usuario;


select max(id_estancia) from Estancia;

select * from Convalidacion;

select * from Grado;

select * from Universidad_destino;

select codigo_erasmus from Universidad_destino where nombre = 'Universidad de Touluse';

select Codigo_erasmus_Universidad_destino from estancia where DNI_Alumno='47231972T'

select passw from Alumno;

delete from Asignatura_origen where codigo='470';
select * from Asignatura_origen;

select id_estancia from estancia where DNI_Alumno='47231972T';
select * from Asignatura_destino;
delete from Asignatura_destino where codigo='930';

select Codigo_Asignatura_origen,Asignatura_origen.nombre,Asignatura_origen.tipo,Asignatura_origen.creditos,Asignatura_origen.informacion,
Codigo_Asignatura_destino,Asignatura_destino.nombre as nombre_destino,Asignatura_destino.creditos as creditos_destino,
Asignatura_destino.informacion as informacion_destino, Universidad_destino.Nombre as nombre_universidad,
fecha_convalidacion,curso_academico,
estado,comentarios
from Convalidacion inner join Estancia on id_estancia_Estancia=id_estancia
inner join Asignatura_origen on Asignatura_origen.Codigo = Codigo_Asignatura_origen
inner join Asignatura_destino on Codigo_Asignatura_destino=Asignatura_destino.Codigo inner join Universidad_destino on
Estancia.Codigo_erasmus_Universidad_destino = Codigo_erasmus where Asignatura_origen.Codigo = '234';

select min_val, max_val from pg_settings where name='max_connections';

select Grado.* from Grado inner join Alumno on Codigo_Grado = Codigo where DNI = '47231972T';




















