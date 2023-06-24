insert into categoria (nome) values ('Credito');
insert into categoria (nome) values ('Debito');
insert into categoria (nome) values ('Dinheiro');

insert into meta_categoria (categoria_id, limite, controle) values (1, 10.0, 2);
insert into meta_categoria (categoria_id, limite, controle) values (2, 15.0, 1);

insert into fatura (valor_total, parcelas, faturado, categoria_id) values (27.90, 3, 1, 1);
insert into fatura (valor_total, parcelas, faturado, categoria_id) values (58.90, 1, 0, 3);

insert into transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id)
values (27.90, utc_timestamp, 2, utc_timestamp, "30-07-29", 1);
insert into transacao (valor, data, parcela, data_pagamento, data_vencimento, fatura_id)
values (25.90, utc_timestamp, 1, utc_timestamp, "30-07-29", 2);