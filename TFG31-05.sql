-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.9.1
-- PostgreSQL version: 10.0
-- Project Site: pgmodeler.io
-- Model Author: ---


-- Database creation must be done outside a multicommand file.
-- These commands were put in this file only as a convenience.
-- -- object: new_database | type: DATABASE --
-- -- DROP DATABASE IF EXISTS new_database;
-- CREATE DATABASE new_database;
-- -- ddl-end --
-- 

-- object: public."Coordinador" | type: TABLE --
-- DROP TABLE IF EXISTS public."Coordinador" CASCADE;
CREATE TABLE public."Coordinador"(
	"DNI" varchar NOT NULL,
	"Passw" varchar,
	"Nombre" varchar,
	"Apellidos" varchar,
	"Nombre_usuario_Usuario" varchar,
	"Departamento" varchar,
	CONSTRAINT "Profesor_pk" PRIMARY KEY ("DNI")

);
-- ddl-end --
ALTER TABLE public."Coordinador" OWNER TO postgres;
-- ddl-end --

-- object: public."Alumno" | type: TABLE --
-- DROP TABLE IF EXISTS public."Alumno" CASCADE;
CREATE TABLE public."Alumno"(
	"DNI" varchar NOT NULL,
	"Passw" varchar,
	"Nombre" varchar,
	"Apellidos" varchar,
	"Nombre_usuario_Usuario" varchar,
	"Codigo_Grado" varchar,
	CONSTRAINT "Alumno_pk" PRIMARY KEY ("DNI")

);
-- ddl-end --
ALTER TABLE public."Alumno" OWNER TO postgres;
-- ddl-end --

-- object: public."Asignatura_origen" | type: TABLE --
-- DROP TABLE IF EXISTS public."Asignatura_origen" CASCADE;
CREATE TABLE public."Asignatura_origen"(
	"Codigo" varchar NOT NULL,
	"Creditos" smallint,
	"Nombre" varchar,
	"Informacion" varchar,
	"Tipo" varchar,
	CONSTRAINT "Asignatura_origen_pk" PRIMARY KEY ("Codigo")

);
-- ddl-end --
ALTER TABLE public."Asignatura_origen" OWNER TO postgres;
-- ddl-end --

-- object: public."Usuario" | type: TABLE --
-- DROP TABLE IF EXISTS public."Usuario" CASCADE;
CREATE TABLE public."Usuario"(
	"Nombre_usuario" varchar NOT NULL,
	CONSTRAINT "Usuario_pk" PRIMARY KEY ("Nombre_usuario")

);
-- ddl-end --
ALTER TABLE public."Usuario" OWNER TO postgres;
-- ddl-end --

-- object: "Usuario_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Coordinador" DROP CONSTRAINT IF EXISTS "Usuario_fk" CASCADE;
ALTER TABLE public."Coordinador" ADD CONSTRAINT "Usuario_fk" FOREIGN KEY ("Nombre_usuario_Usuario")
REFERENCES public."Usuario" ("Nombre_usuario") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Usuario_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Alumno" DROP CONSTRAINT IF EXISTS "Usuario_fk" CASCADE;
ALTER TABLE public."Alumno" ADD CONSTRAINT "Usuario_fk" FOREIGN KEY ("Nombre_usuario_Usuario")
REFERENCES public."Usuario" ("Nombre_usuario") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public."Asignatura_destino" | type: TABLE --
-- DROP TABLE IF EXISTS public."Asignatura_destino" CASCADE;
CREATE TABLE public."Asignatura_destino"(
	"Codigo" varchar NOT NULL,
	"Creditos" smallint,
	"Nombre" varchar,
	"Informacion" varchar,
	"Codigo_erasmus_Universidad_destino" varchar,
	CONSTRAINT "Asignatura_destino_pk" PRIMARY KEY ("Codigo")

);
-- ddl-end --
ALTER TABLE public."Asignatura_destino" OWNER TO postgres;
-- ddl-end --

-- object: public."Grado" | type: TABLE --
-- DROP TABLE IF EXISTS public."Grado" CASCADE;
CREATE TABLE public."Grado"(
	"Codigo" varchar NOT NULL,
	"Nombre" varchar,
	"Facultad" varchar,
	CONSTRAINT "Grado_pk" PRIMARY KEY ("Codigo")

);
-- ddl-end --
ALTER TABLE public."Grado" OWNER TO postgres;
-- ddl-end --

-- object: "Grado_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Alumno" DROP CONSTRAINT IF EXISTS "Grado_fk" CASCADE;
ALTER TABLE public."Alumno" ADD CONSTRAINT "Grado_fk" FOREIGN KEY ("Codigo_Grado")
REFERENCES public."Grado" ("Codigo") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public."Universidad_destino" | type: TABLE --
-- DROP TABLE IF EXISTS public."Universidad_destino" CASCADE;
CREATE TABLE public."Universidad_destino"(
	"Codigo_erasmus" varchar NOT NULL,
	"Nombre" varchar,
	"Pais" varchar,
	"Ciudad" varchar,
	CONSTRAINT "Universidad_destino_pk" PRIMARY KEY ("Codigo_erasmus")

);
-- ddl-end --
ALTER TABLE public."Universidad_destino" OWNER TO postgres;
-- ddl-end --

-- object: "Universidad_destino_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Asignatura_destino" DROP CONSTRAINT IF EXISTS "Universidad_destino_fk" CASCADE;
ALTER TABLE public."Asignatura_destino" ADD CONSTRAINT "Universidad_destino_fk" FOREIGN KEY ("Codigo_erasmus_Universidad_destino")
REFERENCES public."Universidad_destino" ("Codigo_erasmus") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public."Convalidacion" | type: TABLE --
-- DROP TABLE IF EXISTS public."Convalidacion" CASCADE;
CREATE TABLE public."Convalidacion"(
	id_convalidacion integer NOT NULL,
	"Estado" varchar,
	"Comentarios" varchar,
	fecha_convalidacion date,
	"Codigo_Asignatura_destino" varchar,
	"Codigo_Asignatura_origen" varchar,
	"id_estancia_Estancia" integer,
	CONSTRAINT "Convalidacion_pk" PRIMARY KEY (id_convalidacion)

);
-- ddl-end --
ALTER TABLE public."Convalidacion" OWNER TO postgres;
-- ddl-end --

-- object: "Asignatura_destino_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Convalidacion" DROP CONSTRAINT IF EXISTS "Asignatura_destino_fk" CASCADE;
ALTER TABLE public."Convalidacion" ADD CONSTRAINT "Asignatura_destino_fk" FOREIGN KEY ("Codigo_Asignatura_destino")
REFERENCES public."Asignatura_destino" ("Codigo") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Asignatura_origen_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Convalidacion" DROP CONSTRAINT IF EXISTS "Asignatura_origen_fk" CASCADE;
ALTER TABLE public."Convalidacion" ADD CONSTRAINT "Asignatura_origen_fk" FOREIGN KEY ("Codigo_Asignatura_origen")
REFERENCES public."Asignatura_origen" ("Codigo") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public."Estancia" | type: TABLE --
-- DROP TABLE IF EXISTS public."Estancia" CASCADE;
CREATE TABLE public."Estancia"(
	id_estancia integer NOT NULL,
	"Tipo" varchar,
	"Curso_academico" varchar,
	"Duracion" varchar,
	"Renuncia" boolean,
	"Cerrada" boolean,
	"Codigo_erasmus_Universidad_destino" varchar,
	"DNI_Coordinador" varchar,
	"DNI_Alumno" varchar,
	CONSTRAINT "Estancia_pk" PRIMARY KEY (id_estancia)

);
-- ddl-end --
ALTER TABLE public."Estancia" OWNER TO postgres;
-- ddl-end --

-- object: "Estancia_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Convalidacion" DROP CONSTRAINT IF EXISTS "Estancia_fk" CASCADE;
ALTER TABLE public."Convalidacion" ADD CONSTRAINT "Estancia_fk" FOREIGN KEY ("id_estancia_Estancia")
REFERENCES public."Estancia" (id_estancia) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Universidad_destino_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Estancia" DROP CONSTRAINT IF EXISTS "Universidad_destino_fk" CASCADE;
ALTER TABLE public."Estancia" ADD CONSTRAINT "Universidad_destino_fk" FOREIGN KEY ("Codigo_erasmus_Universidad_destino")
REFERENCES public."Universidad_destino" ("Codigo_erasmus") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Coordinador_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Estancia" DROP CONSTRAINT IF EXISTS "Coordinador_fk" CASCADE;
ALTER TABLE public."Estancia" ADD CONSTRAINT "Coordinador_fk" FOREIGN KEY ("DNI_Coordinador")
REFERENCES public."Coordinador" ("DNI") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Alumno_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Estancia" DROP CONSTRAINT IF EXISTS "Alumno_fk" CASCADE;
ALTER TABLE public."Estancia" ADD CONSTRAINT "Alumno_fk" FOREIGN KEY ("DNI_Alumno")
REFERENCES public."Alumno" ("DNI") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Estancia_uq" | type: CONSTRAINT --
-- ALTER TABLE public."Estancia" DROP CONSTRAINT IF EXISTS "Estancia_uq" CASCADE;
ALTER TABLE public."Estancia" ADD CONSTRAINT "Estancia_uq" UNIQUE ("DNI_Alumno");
-- ddl-end --


