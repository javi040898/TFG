drop table muchos_Alumno_tiene_muchos_Asignatura_origen;
drop table Alumno;

drop table Profesor;
drop table Asignatura_destino;
drop table Asignatura_origen;
drop table Usuario;

CREATE TABLE public.Profesor(
	Passw varchar,
	Nombre varchar,
	Apellidos varchar,
	Nombre_usuario_Usuario varchar,
	DNI varchar NOT NULL,
	CONSTRAINT Profesor_pk PRIMARY KEY (DNI)

);
ALTER TABLE public.Profesor OWNER TO postgres;

CREATE TABLE public.Alumno(
	Passw varchar,
	Nombre varchar,
	Apellidos varchar,
	Nombre_usuario_Usuario varchar,
	DNI varchar NOT NULL,
	DNI_Profesor varchar,
	CONSTRAINT Alumno_pk PRIMARY KEY (DNI)

);
ALTER TABLE public.Alumno OWNER TO postgres;

CREATE TABLE public.Asignatura_origen(
	Codigo integer NOT NULL,
	Creditos smallint,
	Nombre varchar,
	Guia_docente varchar,
	CONSTRAINT Asignatura_origen_pk PRIMARY KEY (Codigo)

);

ALTER TABLE public.Asignatura_origen OWNER TO postgres;

CREATE TABLE public.Asignatura_destino(
	Codigo integer NOT NULL,
	Creditos smallint,
	Nombre varchar,
	Guia_docente varchar,
	Codigo_Asignatura_origen integer,
	CONSTRAINT Asignatura_destino_pk PRIMARY KEY (Codigo)

);
ALTER TABLE public.Asignatura_destino OWNER TO postgres;

CREATE TABLE public.Usuario(
	Nombre_usuario varchar NOT NULL,
	CONSTRAINT Usuario_pk PRIMARY KEY (Nombre_usuario)

);
ALTER TABLE public.Usuario OWNER TO postgres;

ALTER TABLE public.Profesor ADD CONSTRAINT Usuario_fk FOREIGN KEY (Nombre_usuario_Usuario)
REFERENCES public.Usuario (Nombre_usuario) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.Alumno ADD CONSTRAINT Usuario_fk FOREIGN KEY (Nombre_usuario_Usuario)
REFERENCES public.Usuario (Nombre_usuario) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.Alumno ADD CONSTRAINT Profesor_fk FOREIGN KEY (DNI_Profesor)
REFERENCES public.Profesor (DNI) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.Asignatura_destino ADD CONSTRAINT Asignatura_origen_fk FOREIGN KEY (Codigo_Asignatura_origen)
REFERENCES public.Asignatura_origen (Codigo) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.muchos_Asignatura_origen_tiene_muchos_Alumno(
	Codigo_Asignatura_origen integer NOT NULL,
	DNI_Alumno varchar NOT NULL,
	CONSTRAINT muchos_Asignatura_origen_tiene_muchos_Alumno_pk PRIMARY KEY (Codigo_Asignatura_origen,DNI_Alumno)

);

ALTER TABLE public.muchos_Asignatura_origen_tiene_muchos_Alumno ADD CONSTRAINT Asignatura_origen_fk FOREIGN KEY (Codigo_Asignatura_origen)
REFERENCES public.Asignatura_origen (Codigo) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE public.muchos_Asignatura_origen_tiene_muchos_Alumno ADD CONSTRAINT Alumno_fk FOREIGN KEY (DNI_Alumno)
REFERENCES public.Alumno (DNI) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

INSERT INTO Usuario VALUES ('javi040898'); --Profesor
INSERT INTO Usuario VALUES ('rob040898'); --Profesor
INSERT INTO Usuario VALUES ('javimart'); --Alumno
INSERT INTO Usuario VALUES ('ramong'); --Alumno
INSERT INTO Usuario VALUES ('antoni'); --Alumno

INSERT INTO Profesor VALUES ('12345','Javier', 'Martin Gomez','javi040898','47231977M');
INSERT INTO Profesor VALUES ('12345','Roberto', 'Gomez','rob040898','47231972');

INSERT INTO Alumno VALUES ('12345','Javier', 'Martin Gonzalez','javimart','47231972','47231977M');
INSERT INTO Alumno VALUES ('12345','Ramon', 'Gonzalez','ramong','1234567','47231972');
INSERT INTO Alumno VALUES ('12345','Antonio', 'Matamoros','antoni','57898755L','47231977M');


INSERT INTO Asignatura_origen VALUES (1,6,'Base de datos','https://www.tutorialesprogramacionya.com/javaya/detalleconcepto.php?codigo=139&punto=&inicio=');
INSERT INTO muchos_Asignatura_origen_tiene_muchos_Alumno VALUES(1,47231972);

delete from Asignatura_origen;
delete from muchos_Asignatura_origen_tiene_muchos_Alumno;
delete from Asignatura_destino;
INSERT INTO Asignatura_destino VALUES (1,6,'Database','www.cccccc.com',1);



select * from Alumno;

select * from Profesor;

select passw from Profesor where Nombre_usuario_Usuario='javi040898';
select passw from Profesor where Nombre_usuario_Usuario = 'javi040898';

select Asignatura_destino.* from Asignatura_origen inner join muchos_Asignatura_origen_tiene_muchos_Alumno on 
Asignatura_origen.codigo=muchos_Asignatura_origen_tiene_muchos_Alumno.Codigo_Asignatura_origen
inner join Alumno on Alumno.DNI=muchos_Asignatura_origen_tiene_muchos_Alumno.DNI_Alumno inner join Asignatura_destino
on Asignatura_destino.Codigo_Asignatura_origen=Asignatura_origen.Codigo
where DNI='47231972';

select * from Asignatura_destino;

select * from Usuario;

select * from Asignatura_origen inner join Asignatura_destino
on Asignatura_origen.codigo=codigo_Asignatura_origen;




select * from Profesor where usuario='javi040898'
select * from Alumno where usuario='javimart' and passw='12345'; 


