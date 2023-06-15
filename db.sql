CREATE DATABASE medical;

CREATE SEQUENCE usuarios_id_seq;
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

CREATE SEQUENCE especialidades_id_seq;
CREATE TABLE IF NOT EXISTS especialidades
(
    id integer NOT NULL DEFAULT nextval('especialidades_id_seq'::regclass),
    descricao text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT especialidades_pkey PRIMARY KEY (id)
)

INSERT INTO usuarios (id, nome, email, login, senha, ativo) VALUES (1, 'admin', 'admin@medical.com.br', 'admin', '$2a$10$4r2otWRd.CwAGpGFenxxc.fpy5UMf1g/lYfbZQLEyhdDhG14qqDUy', true);

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
