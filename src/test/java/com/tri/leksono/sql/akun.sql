CREATE TABLE akun
(
  id_akun character varying(36) NOT NULL,
  namaAkun character varying(30) NOT NULL,
  password character varying(100) NOT NULL,
  aktif boolean,
  terkunci boolean,
  kadaluarsa boolean,
  hakAksesKadaluarsa boolean,
  CONSTRAINT akun PRIMARY KEY (id_akun)
);

insert into akun (id_akun,nama_akun,password,aktif,terkunci,kadaluarsa,hak_akses_kadaluarsa)
values ('001','tri','123',true,false,false,false),
('002','leksono','123',true,false,false,false);
