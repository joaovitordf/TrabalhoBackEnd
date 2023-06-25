INSERT INTO categoria (nome) VALUES ('Crédito');
INSERT INTO categoria (nome) VALUES ('Débito');
INSERT INTO categoria (nome) VALUES ('Dinheiro');

insert into meta_categoria (categoria_id, limite, controle) values (1, 10.0, 2);
insert into meta_categoria (categoria_id, limite, controle) values (2, 15.0, 1);

INSERT INTO fatura (valor_total, parcelas, faturado, categoria_id) VALUES (27.90, 3, 1, 1);
INSERT INTO fatura (valor_total, parcelas, faturado, categoria_id) VALUES (58.90, 1, 0, 3);
INSERT INTO fatura (valor_total, parcelas, faturado, categoria_id) VALUES (24.25, 2, 1, 2);
INSERT INTO fatura (valor_total, parcelas, faturado, categoria_id) VALUES (52.10, 4, 2, 3);

insert into transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id) values (27.90, '2029-07-30', 2, '2029-07-30', '2029-07-30', 1);
