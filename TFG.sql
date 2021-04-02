drop table muchos_Asignatura_origen_tiene_muchos_Alumno;
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
	Codigo integer NOT NULL, --HACER VARCHAR
	Creditos smallint,
	Nombre varchar,
	Guia_docente varchar,
	Codigo_Asignatura_origen integer,
	Estado varchar,
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
INSERT INTO Asignatura_origen VALUES (2,6,'Programacion','https://www.tutorialesprogramacionya.com/javaya/detalleconcepto.php?codigo=139&punto=&inicio=');
INSERT INTO Asignatura_origen VALUES (3,6,'Matematicas','https://www.tutorialesprogramacionya.com/javaya/detalleconcepto.php?codigo=139&punto=&inicio=');
INSERT INTO Asignatura_origen VALUES (4,6,'IA','https://www.IA.com');
INSERT INTO Asignatura_origen VALUES (123456789,6,'redes2','https://www.redes2.com');
INSERT INTO muchos_Asignatura_origen_tiene_muchos_Alumno VALUES(1,47231972);
INSERT INTO muchos_Asignatura_origen_tiene_muchos_Alumno VALUES(2,47231972);
INSERT INTO muchos_Asignatura_origen_tiene_muchos_Alumno VALUES(3,47231972);
INSERT INTO muchos_Asignatura_origen_tiene_muchos_Alumno VALUES(4,47231972);
INSERT INTO muchos_Asignatura_origen_tiene_muchos_Alumno VALUES(123456789,47231972);


delete from Asignatura_origen where Codigo = '5';
delete from muchos_Asignatura_origen_tiene_muchos_Alumno where Codigo_Asignatura_origen = '5';
delete from Asignatura_destino where Codigo = '9';
INSERT INTO Asignatura_destino VALUES (1,3,'Database','www.cccccc.com',1,'Pendiente');
INSERT INTO Asignatura_destino VALUES (2,3,'Database2','www.ddddddd.com',1,'Pendiente');
INSERT INTO Asignatura_destino VALUES (3,6,'Programme','www.ppppppppppp.com',2,'Pendiente');
INSERT INTO Asignatura_destino VALUES (4,6,'Maths','www.ppppppppppp.com',3,'Aceptada');
INSERT INTO Asignatura_destino VALUES (5,6,'AI','www.AI.com',4,'Pendiente');
INSERT INTO Asignatura_destino VALUES (11223344,6,'Networks2','www.nw2.com',123456789,'Pendiente');

UPDATE Asignatura_destino SET Estado = 'Pendiente' from Asignatura_destino ad inner join Asignatura_origen on 
Asignatura_origen.codigo=ad.Codigo_Asignatura_origen inner join
muchos_Asignatura_origen_tiene_muchos_Alumno on 
Asignatura_origen.codigo=muchos_Asignatura_origen_tiene_muchos_Alumno.Codigo_Asignatura_origen
where ad.Codigo = 1  and muchos_Asignatura_origen_tiene_muchos_Alumno.DNI_Alumno='47231972';

UPDATE Asignatura_destino SET Estado = 'Pendiente';

select Asignatura_origen.* from Asignatura_origen inner join Asignatura_destino on Asignatura_origen.codigo=Asignatura_destino.Codigo_Asignatura_origen
where Asignatura_origen.codigo = '1' and estado = 'Aceptada' ;

select Asignatura_destino.* from Asignatura_origen inner join Asignatura_destino on Asignatura_origen.codigo=Asignatura_destino.Codigo_Asignatura_origen
where Asignatura_origen.codigo = '1' and estado = 'Aceptada' ;

select ad.Codigo from Asignatura_destino ad inner join Asignatura_origen on 
Asignatura_origen.codigo=ad.Codigo_Asignatura_origen inner join
muchos_Asignatura_origen_tiene_muchos_Alumno on 
Asignatura_origen.codigo=muchos_Asignatura_origen_tiene_muchos_Alumno.Codigo_Asignatura_origen
where muchos_Asignatura_origen_tiene_muchos_Alumno.DNI_Alumno='47231972';

select * from Alumno;

delete from ALumno where dni='insertarAlumno';

select * from Profesor;

select passw from Profesor where Nombre_usuario_Usuario='javi040898';
select passw from Profesor where Nombre_usuario_Usuario = 'javi040898';

select Asignatura_origen.* from Asignatura_origen inner join muchos_Asignatura_origen_tiene_muchos_Alumno on 
Asignatura_origen.codigo=muchos_Asignatura_origen_tiene_muchos_Alumno.Codigo_Asignatura_origen
inner join Alumno on Alumno.DNI=muchos_Asignatura_origen_tiene_muchos_Alumno.DNI_Alumno inner join Asignatura_destino
on Asignatura_destino.Codigo_Asignatura_origen=Asignatura_origen.Codigo
where DNI='47231972';

select * from Asignatura_destino;
select * from Asignatura_origen;
select *  from muchos_Asignatura_origen_tiene_muchos_Alumno;

select Asignatura_origen.* from Asignatura_origen inner join muchos_Asignatura_origen_tiene_muchos_Alumno on 
                     Asignatura_origen.codigo=muchos_Asignatura_origen_tiene_muchos_Alumno.Codigo_Asignatura_origen
                     inner join Alumno on Alumno.DNI=muchos_Asignatura_origen_tiene_muchos_Alumno.DNI_Alumno where DNI='47231972';

select * from Asignatura_destino where Asignatura_destino.Codigo = 1 ;

select * from Asignatura_destino ad inner join Asignatura_origen on 
Asignatura_origen.codigo=ad.Codigo_Asignatura_origen inner join
muchos_Asignatura_origen_tiene_muchos_Alumno on 
Asignatura_origen.codigo=muchos_Asignatura_origen_tiene_muchos_Alumno.Codigo_Asignatura_origen
where ad.Codigo = 1  and muchos_Asignatura_origen_tiene_muchos_Alumno.DNI_Alumno='47231972';

select * from Usuario;

select * from Asignatura_origen inner join Asignatura_destino
on Asignatura_origen.codigo=codigo_Asignatura_origen;


select DNI from Profesor inner join Usuario on Nombre_usuario_Usuario=Nombre_usuario where Usuario.nombre_usuario='javi040898';

select * from Profesor where usuario='javi040898'
select * from Alumno where usuario='javimart' and passw='12345'; 


