CREATE DATABASE medical;

CREATE TABLE IF NOT EXISTS usuarios
(
    id integer NOT NULL DEFAULT nextval('usuarios_id_seq'::regclass),
    nome text COLLATE pg_catalog."default" NOT NULL,
    email text COLLATE pg_catalog."default" NOT NULL,
    login text COLLATE pg_catalog."default" NOT NULL,
    senha text COLLATE pg_catalog."default" NOT NULL,
    ativo boolean NOT NULL,
    CONSTRAINT usuarios_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS especialidades
(
    id integer NOT NULL DEFAULT nextval('especialidades_id_seq'::regclass),
    descricao text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT especialidades_pkey PRIMARY KEY (id)
)

INSERT INTO usuarios (id, nome, email, login, senha, ativo) VALUES (1, 'admin', 'admin@medical.com.br', 'admin', '$2a$10$4r2otWRd.CwAGpGFenxxc.fpy5UMf1g/lYfbZQLEyhdDhG14qqDUy', true);
);

CREATE SEQUENCE pacientes_id_seq;
CREATE TABLE IF NOT EXISTS pacientes
(
    id integer NOT NULL DEFAULT nextval('pacientes_id_seq'),
    nome text COLLATE pg_catalog."default" NOT NULL,
    data_nascimento date NOT NULL,
    cpf text COLLATE pg_catalog."default" NOT NULL,
    telefone text COLLATE pg_catalog."default" NOT NULL,
    genero text COLLATE pg_catalog."default" NOT NULL,
	ativo boolean NOT NULL,
    CONSTRAINT pacientes_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE doctors_id_seq;

CREATE TABLE IF NOT EXISTS doctors
(
    id integer NOT NULL DEFAULT nextval('doctors_id_seq'),
    nome text COLLATE pg_catalog."default" NOT NULL, 
    crm text COLLATE pg_catalog."default" NOT NULL, 
    ativo boolean NOT NULL,
    especialidades_id integer, -- Foreign key column
    CONSTRAINT doctors_pkey PRIMARY KEY (id),
    CONSTRAINT fk_especialidades FOREIGN KEY (especialidades_id) REFERENCES especialidades (id)
);

CREATE SEQUENCE consultas_id_seq;

CREATE TABLE IF NOT EXISTS consultas
(
    id integer NOT NULL DEFAULT nextval('consultas_id_seq'),
    dth_consulta timestamp NOT NULL,
	id_paciente integer NOT NULL,
	id_doctor integer NOT NULL,
	CONSTRAINT paciente_fkey FOREIGN KEY (id_paciente) REFERENCES pacientes(id),
	CONSTRAINT doctor_fkey FOREIGN KEY (id_doctor) REFERENCES doctors(id),
    CONSTRAINT consultas_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE CONSULTAS_OBS_ID_SEQ;

CREATE TABLE CONSULTAS_OBS(

	ID INTEGER NOT NULL DEFAULT nextval('CONSULTAS_OBS_ID_SEQ'),
	DES_SINTOMAS TEXT COLLATE pg_catalog."default",
	DES_TRATAMENTO TEXT COLLATE pg_catalog."default",
	DES_OBSERVACOES TEXT COLLATE pg_catalog."default",
	ID_CONSULTA INTEGER NOT NULL,
	
	CONSTRAINT CONSULTAS_OBS_PKEY PRIMARY KEY (ID),
	CONSTRAINT CONSULTA_FKEY FOREIGN KEY (ID_CONSULTA) REFERENCES CONSULTAS(ID)

);