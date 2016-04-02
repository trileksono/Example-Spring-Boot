CREATE TABLE s_users
(
  id character varying(36) NOT NULL,
  username character varying(30) NOT NULL,
  password character varying(100) NOT NULL,
  active boolean,
  CONSTRAINT s_users_pkey PRIMARY KEY (id)
);
