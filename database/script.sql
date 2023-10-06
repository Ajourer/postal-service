-- sudo --user=postgres psql
DROP DATABASE IF EXISTS postal_service;
DROP USER IF EXISTS postal_service;

-- Just for example. You should not save password to git.
CREATE USER postal_service WITH
    ENCRYPTED PASSWORD 'a2{O)9U%V+Lt~dnMykSPG1?sF8Wf:p0H';
CREATE DATABASE postal_service WITH
    OWNER postal_service
    ENCODING 'UTF8';
