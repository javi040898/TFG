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



CREATE TABLE public.Convalidacion(
	id_convalidacion integer NOT NULL,
	Estado varchar,
	Comentarios varchar,
	fecha_convalidacion date,
	Codigo_Asignatura_destino varchar,
	Codigo_Asignatura_origen varchar,
	id_estancia_Estancia integer,
	CONSTRAINT Convalidacion_pk PRIMARY KEY (id_convalidacion)

);


ALTER TABLE public.Convalidacion OWNER TO postgres;

ALTER TABLE public.Convalidacion ADD CONSTRAINT Asignatura_destino_fk FOREIGN KEY (Codigo_Asignatura_destino)
REFERENCES public.Asignatura_destino (Codigo) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.Convalidacion ADD CONSTRAINT Asignatura_origen_fk FOREIGN KEY (Codigo_Asignatura_origen)
REFERENCES public.Asignatura_origen (Codigo) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

CREATE TABLE public.Estancia(
	id_estancia integer NOT NULL,
	Tipo varchar,
	Curso_academico varchar,
	Duracion varchar,
	Renuncia boolean,
	Cerrada boolean,
	Codigo_erasmus_Universidad_destino varchar,
	DNI_Coordinador varchar,
	DNI_Alumno varchar,
	CONSTRAINT Estancia_pk PRIMARY KEY (id_estancia)

);
ALTER TABLE public.Estancia OWNER TO postgres;

ALTER TABLE public.Convalidacion ADD CONSTRAINT Estancia_fk FOREIGN KEY (id_estancia_Estancia)
REFERENCES public.Estancia (id_estancia) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.Estancia ADD CONSTRAINT Universidad_destino_fk FOREIGN KEY (Codigo_erasmus_Universidad_destino)
REFERENCES public.Universidad_destino (Codigo_erasmus) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.Estancia ADD CONSTRAINT Coordinador_fk FOREIGN KEY (DNI_Coordinador)
REFERENCES public.Coordinador (DNI) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE public.Estancia ADD CONSTRAINT Alumno_fk FOREIGN KEY (DNI_Alumno)
REFERENCES public.Alumno (DNI) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;




INSERT INTO Usuario values('ivan.gonzalez');
INSERT INTO Coordinador values('11111111M','12345','Ivan','Gonzalez','ivan.gonzalez','Ciencias de la computacion');


