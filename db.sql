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