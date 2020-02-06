--------------------------------------------------------
-- Archivo creado  - jueves-febrero-06-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence CICLO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "CICLO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 23 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence MODULO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "MODULO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 98 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table ALUMNO
--------------------------------------------------------

  CREATE TABLE "ALUMNO" 
   (	"DNI" VARCHAR2(9), 
	"NOMBRE" VARCHAR2(20), 
	"APELLIDO1" VARCHAR2(20), 
	"APELLIDO2" VARCHAR2(20), 
	"TELEFONO" VARCHAR2(9), 
	"NACIMIENTO" DATE
   ) ;
--------------------------------------------------------
--  DDL for Table CICLO
--------------------------------------------------------

  CREATE TABLE "CICLO" 
   (	"ID" NUMBER, 
	"NOMBRE" VARCHAR2(50), 
	"NIVEL" VARCHAR2(10), 
	"CURSO" NUMBER(1,0)
   ) ;
--------------------------------------------------------
--  DDL for Table CURSA
--------------------------------------------------------

  CREATE TABLE "CURSA" 
   (	"ANHO" VARCHAR2(4), 
	"ID_MODULO" NUMBER, 
	"DNI" VARCHAR2(9), 
	"NOTA" NUMBER(4,2)
   ) ;
--------------------------------------------------------
--  DDL for Table MODULO
--------------------------------------------------------

  CREATE TABLE "MODULO" 
   (	"ID" NUMBER, 
	"HORAS" NUMBER(3,0), 
	"NOMBRE" VARCHAR2(60), 
	"CURSO" NUMBER(1,0), 
	"ID_CICLO" NUMBER(1,0)
   ) ;
--------------------------------------------------------
--  DDL for Index ALUMNO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ALUMNO_PK" ON "ALUMNO" ("DNI") 
  ;
--------------------------------------------------------
--  DDL for Index CICLOS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CICLOS_PK" ON "CICLO" ("ID") 
  ;
--------------------------------------------------------
--  DDL for Index CURSA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "CURSA_PK" ON "CURSA" ("ID_MODULO", "DNI") 
  ;
--------------------------------------------------------
--  DDL for Index MODULO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MODULO_PK" ON "MODULO" ("ID") 
  ;
