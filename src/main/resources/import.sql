INSERT INTO categoria (nome) VALUES ('Lazer');
INSERT INTO categoria (nome) VALUES ('Saúde');
INSERT INTO categoria (nome) VALUES ('Educação');
INSERT INTO categoria (nome) VALUES ('Alimentação');

INSERT INTO fatura (valor_total, parcelas, faturado, categoria_id) VALUES (2700.00, 3, 2, 1);
INSERT INTO fatura (valor_total, parcelas, faturado, categoria_id) VALUES (1000.00, 3, 2, 1);

INSERT INTO fatura (valor_total, parcelas, faturado, categoria_id) VALUES (580.00, 2, 1, 3);
INSERT INTO fatura (valor_total, parcelas, faturado, categoria_id) VALUES (120.00, 4, 3, 2);
INSERT INTO fatura (valor_total, parcelas, faturado, categoria_id) VALUES (210.00, 2, 1, 4);

INSERT INTO transacao (valor, data, parcela, datapagamento, datavencimento, fatura_id) VALUES (100.00, CURRENT_TIMESTAMP, 3, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 1);
INSERT INTO transacao (valor, data, parcela, datapagamento, datavencimento, fatura_id) VALUES (120.00, CURRENT_TIMESTAMP, 2, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 2);
INSERT INTO transacao (valor, data, parcela, datapagamento, datavencimento, fatura_id) VALUES (50.00, CURRENT_TIMESTAMP, 1, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 3);
INSERT INTO transacao (valor, data, parcela, datapagamento, datavencimento, fatura_id) VALUES (100.00, CURRENT_TIMESTAMP, 1, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 4);

INSERT INTO transacao (valor, data, parcela, datapagamento, datavencimento, fatura_id) VALUES (40.00, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 20 DAY), 1, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 1);
INSERT INTO transacao (valor, data, parcela, datapagamento, datavencimento, fatura_id) VALUES (20.00, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 33 DAY), 1, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 2);
INSERT INTO transacao (valor, data, parcela, datapagamento, datavencimento, fatura_id) VALUES (10.00, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 100 DAY), 1, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 3);

INSERT INTO transacao (valor, data, parcela, datapagamento, datavencimento, fatura_id) VALUES (10.00, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 100 DAY), 1, DATE_ADD(CURDATE(), INTERVAL 800 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 3);

INSERT INTO transacao (valor, data, parcela, datapagamento, datavencimento, fatura_id) VALUES (40.00, CURRENT_TIMESTAMP, 1, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 450 DAY), 1);

INSERT INTO transacao (valor, data, parcela, datapagamento, datavencimento, fatura_id) VALUES (40.00, CURRENT_TIMESTAMP, 1, DATE_SUB(CURDATE(), INTERVAL 300 DAY), DATE_SUB(CURDATE(), INTERVAL 200 DAY), 1);

INSERT INTO meta_categoria (categoria_id, limite, controle) VALUES (1, 1000.0, 2);
INSERT INTO meta_categoria (categoria_id, limite, controle) VALUES (2, 500.0, 2);
