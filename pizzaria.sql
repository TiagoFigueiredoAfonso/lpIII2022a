PGDMP     9            	        z         
   lpIII2022a     13.7 (Ubuntu 13.7-1.pgdg20.04+1)     14.3 (Ubuntu 14.3-1.pgdg20.04+1) '    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    18805 
   lpIII2022a    DATABASE     a   CREATE DATABASE "lpIII2022a" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';
    DROP DATABASE "lpIII2022a";
                postgres    false            �            1259    19142 	   categoria    TABLE     \   CREATE TABLE public.categoria (
    id integer NOT NULL,
    nome character varying(100)
);
    DROP TABLE public.categoria;
       public         heap    postgres    false            �            1259    18930    cidade    TABLE     }   CREATE TABLE public.cidade (
    id integer NOT NULL,
    descricao character varying(100),
    uf character varying(100)
);
    DROP TABLE public.cidade;
       public         heap    postgres    false            �            1259    18928    cidade_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cidade_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.cidade_id_seq;
       public          postgres    false    203            �           0    0    cidade_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.cidade_id_seq OWNED BY public.cidade.id;
          public          postgres    false    202            �            1259    18808    cliente    TABLE     �   CREATE TABLE public.cliente (
    id integer NOT NULL,
    nome character varying(100),
    email character varying(100),
    fone character varying(100),
    endereco character varying(100),
    cidade_id integer,
    data_nascimento date
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    18806    cliente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cliente_id_seq;
       public          postgres    false    201            �           0    0    cliente_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;
          public          postgres    false    200            �            1259    18938    pizza    TABLE     �   CREATE TABLE public.pizza (
    id integer NOT NULL,
    nome character varying(100),
    categoria_id integer,
    data date
);
    DROP TABLE public.pizza;
       public         heap    postgres    false            �            1259    18936    pizza_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pizza_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.pizza_id_seq;
       public          postgres    false    205            �           0    0    pizza_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.pizza_id_seq OWNED BY public.pizza.id;
          public          postgres    false    204            �            1259    19140    sabor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.sabor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.sabor_id_seq;
       public          postgres    false    207            �           0    0    sabor_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.sabor_id_seq OWNED BY public.categoria.id;
          public          postgres    false    206            �            1259    19150    usuario    TABLE     �   CREATE TABLE public.usuario (
    id integer NOT NULL,
    nome character varying(100),
    email character varying(100),
    password character varying(50)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    19148    usuario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public          postgres    false    209            �           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    208            F           2604    19145    categoria id    DEFAULT     h   ALTER TABLE ONLY public.categoria ALTER COLUMN id SET DEFAULT nextval('public.sabor_id_seq'::regclass);
 ;   ALTER TABLE public.categoria ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            D           2604    18933 	   cidade id    DEFAULT     f   ALTER TABLE ONLY public.cidade ALTER COLUMN id SET DEFAULT nextval('public.cidade_id_seq'::regclass);
 8   ALTER TABLE public.cidade ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            C           2604    18811 
   cliente id    DEFAULT     h   ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);
 9   ALTER TABLE public.cliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    200    201            E           2604    18941    pizza id    DEFAULT     d   ALTER TABLE ONLY public.pizza ALTER COLUMN id SET DEFAULT nextval('public.pizza_id_seq'::regclass);
 7   ALTER TABLE public.pizza ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            G           2604    19153 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    208    209    209            �          0    19142 	   categoria 
   TABLE DATA           -   COPY public.categoria (id, nome) FROM stdin;
    public          postgres    false    207   �'       �          0    18930    cidade 
   TABLE DATA           3   COPY public.cidade (id, descricao, uf) FROM stdin;
    public          postgres    false    203   �'       �          0    18808    cliente 
   TABLE DATA           ^   COPY public.cliente (id, nome, email, fone, endereco, cidade_id, data_nascimento) FROM stdin;
    public          postgres    false    201   (       �          0    18938    pizza 
   TABLE DATA           =   COPY public.pizza (id, nome, categoria_id, data) FROM stdin;
    public          postgres    false    205   �(       �          0    19150    usuario 
   TABLE DATA           <   COPY public.usuario (id, nome, email, password) FROM stdin;
    public          postgres    false    209   H)       �           0    0    cidade_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.cidade_id_seq', 14, true);
          public          postgres    false    202            �           0    0    cliente_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.cliente_id_seq', 35, true);
          public          postgres    false    200            �           0    0    pizza_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.pizza_id_seq', 19, true);
          public          postgres    false    204            �           0    0    sabor_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.sabor_id_seq', 4, true);
          public          postgres    false    206            �           0    0    usuario_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.usuario_id_seq', 1, true);
          public          postgres    false    208            K           2606    18935    cidade cidade_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cidade DROP CONSTRAINT cidade_pkey;
       public            postgres    false    203            I           2606    18813    cliente cliente_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    201            M           2606    19147    categoria sabor_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT sabor_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.categoria DROP CONSTRAINT sabor_pkey;
       public            postgres    false    207            O           2606    19157    usuario usuario_email 
   CONSTRAINT     Q   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_email UNIQUE (email);
 ?   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_email;
       public            postgres    false    209            Q           2606    19155    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    209            �   &   x�3�(J-.�+��2�)JL�L���K������ ���      �   1   x�3�tN�-�Wp/J�KI���24�,N�)K��->�|h9s��qqq ���      �   �   x�3�I-.I�K��,2R�s3s���s9����4Q�85W!/?7�ӈ����@�����M9C<��������<�C]=�\]�9K2���2�KS3�RS�����M6ANsC� �������-��L�`d�k`�!F��� k�/`      �   }   x�3�,I-.I�K��4���2C㛣�-��������A�i��9�P�gHQb��cJY~rbr&Lؒ3����_����/�_���=��3��şӘ����H��L�����T�.#�H4F��� �=5      �   A   x�3�LL��̃�鹉�9z�������)�Ɩ&�I����II��f���iFiƩ\1z\\\ i��     