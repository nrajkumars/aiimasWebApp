SELECT * FROM pg_catalog.pg_tables where schemaname='public'


CREATE TABLE public.tomcat_users
(
    user_name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    password character varying(250) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tomcat_users_pkey PRIMARY KEY (user_name)
)
WITH (
	OIDS = FALSE
)
TABLESPACE pg_default;

CREATE TABLE public.tomcat_roles
(
    user_name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    role_name character varying(32) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tomcat_roles_pkey PRIMARY KEY (user_name, role_name)
)
WITH (
	OIDS = FALSE
)
TABLESPACE pg_default;

INSERT into tomcat_users(user_name,password)
	VALUES ('raj',md5('some password'))

    
INSERT into tomcat_roles(user_name, role_name) 
	VALUES ('raj', 'admin')	

select * from tomcat_users
	