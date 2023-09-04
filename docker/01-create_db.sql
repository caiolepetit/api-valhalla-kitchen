CREATE TABLE IF NOT EXISTS produto(
    id SERIAL NOT NULL,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL,
    descricao VARCHAR(100) NOT NULL,
    categoria VARCHAR(30) NOT NULL,
    status VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cliente(
    id UUID PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS pedido(
    id SERIAL NOT NULL,
    cliente_id INTEGER NOT NULL,
    status VARCHAR(15) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pedido_produto(
    pedido_id INTEGER NOT NULL,
    FOREIGN KEY (pedido_id)
        REFERENCES "pedido" (id),
    produto_id INTEGER NOT NULL,
    FOREIGN KEY (produto_id)
        REFERENCES "produto" (id)
);