INSERT INTO categoria (nome) VALUES ('Lazer');
INSERT INTO categoria (nome) VALUES ('Saúde');
INSERT INTO categoria (nome) VALUES ('Educação');
INSERT INTO categoria (nome) VALUES ('Alimentação');

INSERT INTO fatura (valor_total, parcelas, faturado, categoria_id) VALUES (270.00, 3, 2, 1);
INSERT INTO fatura (valor_total, parcelas, faturado, categoria_id) VALUES (580.00, 2, 1, 3);
INSERT INTO fatura (valor_total, parcelas, faturado, categoria_id) VALUES (120.00, 4, 3, 2);
INSERT INTO fatura (valor_total, parcelas, faturado, categoria_id) VALUES (210.00, 2, 1, 4);

INSERT INTO transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id) VALUES (100.00, CURRENT_TIMESTAMP, 3, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 1);
INSERT INTO transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id) VALUES (120.00, CURRENT_TIMESTAMP, 2, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 2);
INSERT INTO transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id) VALUES (50.00, CURRENT_TIMESTAMP, 1, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 3);
INSERT INTO transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id) VALUES (100.00, CURRENT_TIMESTAMP, 1, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 4);

INSERT INTO transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id) VALUES (999.00, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 20 DAY), 1, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 1);
INSERT INTO transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id) VALUES (500.00, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 33 DAY), 1, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 2);
INSERT INTO transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id) VALUES (200.00, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 100 DAY), 1, DATE_ADD(CURDATE(), INTERVAL 30 DAY), DATE_ADD(CURDATE(), INTERVAL 60 DAY), 3);

INSERT INTO meta_categoria (categoria_id, limite, controle) VALUES (1, 10.0, 2);
INSERT INTO meta_categoria (categoria_id, limite, controle) VALUES (2, 15.0, 1);
INSERT INTO meta_categoria (categoria_id, limite, controle) VALUES (1, 10.0, 2);
INSERT INTO meta_categoria (categoria_id, limite, controle) VALUES (2, 15.0, 1);
