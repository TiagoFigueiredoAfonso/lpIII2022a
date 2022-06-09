PGDMP         +        	        z         
   lpIII2022a     13.7 (Ubuntu 13.7-1.pgdg20.04+1)     14.3 (Ubuntu 14.3-1.pgdg20.04+1)     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
       public         heap    postgres    false            �            1259    18938    pizza    TABLE     �   CREATE TABLE public.pizza (
    id integer NOT NULL,
    nome character varying(100),
    categoria_id integer,
    data date,
    foto character varying(50)
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
       public          postgres    false    201            �           0    0    pizza_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.pizza_id_seq OWNED BY public.pizza.id;
          public          postgres    false    200            �            1259    19140    sabor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.sabor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.sabor_id_seq;
       public          postgres    false    203            �           0    0    sabor_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.sabor_id_seq OWNED BY public.categoria.id;
          public          postgres    false    202            �            1259    19150    usuario    TABLE     �   CREATE TABLE public.usuario (
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
       public          postgres    false    205            �           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    204            8           2604    19145    categoria id    DEFAULT     h   ALTER TABLE ONLY public.categoria ALTER COLUMN id SET DEFAULT nextval('public.sabor_id_seq'::regclass);
 ;   ALTER TABLE public.categoria ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            7           2604    18941    pizza id    DEFAULT     d   ALTER TABLE ONLY public.pizza ALTER COLUMN id SET DEFAULT nextval('public.pizza_id_seq'::regclass);
 7   ALTER TABLE public.pizza ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    200    201    201            9           2604    19153 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    204    205    205            �          0    19142 	   categoria 
   TABLE DATA           -   COPY public.categoria (id, nome) FROM stdin;
    public          postgres    false    203   �       �          0    18938    pizza 
   TABLE DATA           C   COPY public.pizza (id, nome, categoria_id, data, foto) FROM stdin;
    public          postgres    false    201   3       �          0    19150    usuario 
   TABLE DATA           <   COPY public.usuario (id, nome, email, password) FROM stdin;
    public          postgres    false    205   �       �           0    0    pizza_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.pizza_id_seq', 24, true);
          public          postgres    false    200            �           0    0    sabor_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.sabor_id_seq', 8, true);
          public          postgres    false    202            �           0    0    usuario_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.usuario_id_seq', 1, true);
          public          postgres    false    204            ;           2606    19147    categoria sabor_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT sabor_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.categoria DROP CONSTRAINT sabor_pkey;
       public            postgres    false    203            =           2606    19157    usuario usuario_email 
   CONSTRAINT     Q   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_email UNIQUE (email);
 ?   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_email;
       public            postgres    false    205            ?           2606    19155    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    205            �   4   x�3�)JL�L���K��2�t-.HM�2�9]�S�,8�R���b���� O�*      �   �   x�M�;�0 �99E/��q��+�V]��gc������X����e��c9�K3��5ϧ|(�3�D�0M�;���;H�1xF��Tl_������~�ń��U];�"�e�WAdwk�����Z��\%s      �   A   x�3�LL��̃�鹉�9z�������)�Ɩ&�I����II��f���iFiƩ\1z\\\ i��     