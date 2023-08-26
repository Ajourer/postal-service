-- sudo --user=postgres psql
DROP DATABASE IF EXISTS mail_service;
DROP USER IF EXISTS mail_service;

-- Just for example. You shouldn't save password to git.
CREATE USER mail_service
    PASSWORD 'a2{O)9U%V+Lt~dnMykSPG1?sF8Wf:p0H';
CREATE DATABASE mail_service WITH
    OWNER mail_service
    ENCODING 'UTF8';
