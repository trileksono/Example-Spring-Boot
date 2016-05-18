CREATE TABLE hakakses
(
  id character varying(36) NOT NULL,
  kodeAkses character varying(255) NOT NULL,
  namaAkses character varying(255) NOT NULL,
  CONSTRAINT hakakses PRIMARY KEY (id)
);


insert into hak_akses values (1,'AKSES_USER','User');
insert into hak_akses values (2,'AKSES_ADMIN','Admin');
insert into hak_akses values (3,'AKSES_SYSADMIN','System Admin');