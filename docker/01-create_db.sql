CREATE TABLE IF NOT EXISTS produto(
    id INT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL,
    descricao VARCHAR(100) NOT NULL,
    categoria VARCHAR(30) NOT NULL,
    status VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pedido(
    id INT NOT NULL,
    cliente_id INT NOT NULL,
    status VARCHAR(15) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS pedido_produto(
    pedido_id INT NOT NULL,
    produto_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS cliente(
    cpf INT NOT NULL,
    email VARCHAR(50) NOT NULL
);