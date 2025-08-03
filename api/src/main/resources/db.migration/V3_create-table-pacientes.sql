CREATE TABLE pacientes (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone varchar(20) not null,
    

    -- Campos do objeto Endereco (embeddable)
    logradouro VARCHAR(100) NOT NULL,
    num VARCHAR(20) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL
);