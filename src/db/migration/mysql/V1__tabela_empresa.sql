CREATE TABLE 'empresa'(
    'id' int(20) NOT NULL,
    'cnpj' varchar (255) NOT NULL,
    'data_atualizacao' datetime_interval_code NOT NULL,
    'data_criacao' datetime_interval_code NOT NULL,
    'razao_social' varchar (255) NOT NULL ,
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE  'empresa'
ADD PRIMARY KEY ('id');

ALTER TABLE 'empresa'
MODIFIES 'id ' int (20) NOT NULL AUTO_INCREMENT;