CREATE TABLE produto(
    id TEXT PRIMARY KEY NOT NULL,
    id_categoria BIGINT NOT NULL,
    nome TEXT NOT NULL,
    descricao TEXT NOT NULL,
    valor DECIMAL(15,2),
    status BOOLEAN,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id)
);