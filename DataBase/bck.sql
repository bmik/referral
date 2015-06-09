--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.1
-- Dumped by pg_dump version 9.4.1
-- Started on 2015-06-09 22:17:02

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 2007 (class 0 OID 32826)
-- Dependencies: 175
-- Data for Name: examination; Type: TABLE DATA; Schema: public; Owner: referral
--

COPY examination (id, code, name) FROM stdin;
1	100	Morfologia krwi
2	102	Posiew
3	110	Wymaz z ucha
4	200	Wymaz z gardła
5	280	Sód
6	282	Potas
7	301	Kreatynina
8	302	Glukoza
\.


--
-- TOC entry 2013 (class 0 OID 0)
-- Dependencies: 174
-- Name: examination_id_seq; Type: SEQUENCE SET; Schema: public; Owner: referral
--

SELECT pg_catalog.setval('examination_id_seq', 8, true);


-- Completed on 2015-06-09 22:17:03

--
-- PostgreSQL database dump complete
--

