PGDMP                  
    |            BD_RED_BIBLIOTECA    17.0    17.0 �    T           0    0    ENCODING    ENCODING     #   SET client_encoding = 'SQL_ASCII';
                           false            U           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            V           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            W           1262    25400    BD_RED_BIBLIOTECA    DATABASE     �   CREATE DATABASE "BD_RED_BIBLIOTECA" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Venezuela.1252';
 #   DROP DATABASE "BD_RED_BIBLIOTECA";
                     postgres    false            �            1259    25401 
   Biblioteca    TABLE     �   CREATE TABLE public."Biblioteca" (
    "idBiblioteca" integer NOT NULL,
    "nomBiblioteca" character varying(50) NOT NULL,
    direccion character varying(50) NOT NULL
);
     DROP TABLE public."Biblioteca";
       public         heap r       postgres    false            �            1259    25404    BibliotecaLibro    TABLE     �   CREATE TABLE public."BibliotecaLibro" (
    "idBibliotecaLibro" integer NOT NULL,
    "idBiblioteca" integer NOT NULL,
    "idLibro" integer NOT NULL,
    "cantEjemplares" integer NOT NULL
);
 %   DROP TABLE public."BibliotecaLibro";
       public         heap r       postgres    false            �            1259    25407    Carrera    TABLE     u   CREATE TABLE public."Carrera" (
    "idCarrera" integer NOT NULL,
    "nomCarrera" character varying(30) NOT NULL
);
    DROP TABLE public."Carrera";
       public         heap r       postgres    false            �            1259    25410 	   Categoria    TABLE     {   CREATE TABLE public."Categoria" (
    "idCategoria" integer NOT NULL,
    "nomCategoria" character varying(50) NOT NULL
);
    DROP TABLE public."Categoria";
       public         heap r       postgres    false            �            1259    25413    Departamento    TABLE     �   CREATE TABLE public."Departamento" (
    "idDepartamento" integer NOT NULL,
    "nomDepartamento" character varying(30) NOT NULL
);
 "   DROP TABLE public."Departamento";
       public         heap r       postgres    false            �            1259    25416    Ejemplar    TABLE     �   CREATE TABLE public."Ejemplar" (
    "idEjemplar" integer NOT NULL,
    "idLibro" integer NOT NULL,
    "idEstadoEj" integer NOT NULL,
    ubicacion character varying(80) NOT NULL
);
    DROP TABLE public."Ejemplar";
       public         heap r       postgres    false            �            1259    25419    EstadoEjemplar    TABLE     u   CREATE TABLE public."EstadoEjemplar" (
    "idEstadoEj" integer NOT NULL,
    "nomEstadoEj" character varying(20)
);
 $   DROP TABLE public."EstadoEjemplar";
       public         heap r       postgres    false            �            1259    25422    EstadoPrestamo    TABLE     �   CREATE TABLE public."EstadoPrestamo" (
    "idEstadoPre" integer NOT NULL,
    "nomEstadoPre" character varying(20) NOT NULL
);
 $   DROP TABLE public."EstadoPrestamo";
       public         heap r       postgres    false            �            1259    25425    EstadoRenovacion    TABLE     �   CREATE TABLE public."EstadoRenovacion" (
    "idEstadoRen" integer NOT NULL,
    "nomEstadoRen" character varying(20) NOT NULL
);
 &   DROP TABLE public."EstadoRenovacion";
       public         heap r       postgres    false            �            1259    25428    Libro    TABLE     �   CREATE TABLE public."Libro" (
    "idLibro" integer NOT NULL,
    titulo character varying(80),
    autor character varying(50),
    "año" integer,
    "idCategoria" integer
);
    DROP TABLE public."Libro";
       public         heap r       postgres    false            �            1259    25431    Multa    TABLE     �   CREATE TABLE public."Multa" (
    "idMulta" integer NOT NULL,
    "idPrestamo" integer NOT NULL,
    "fechaInicio" date NOT NULL,
    "fechaFin" date NOT NULL
);
    DROP TABLE public."Multa";
       public         heap r       postgres    false            �            1259    25434    Prestamo    TABLE       CREATE TABLE public."Prestamo" (
    "idPrestamo" integer NOT NULL,
    cedula integer NOT NULL,
    "idEjemplar" integer NOT NULL,
    "fechaSalida" date NOT NULL,
    "fechaVence" date NOT NULL,
    "fechaEntrega" date NOT NULL,
    "idEstadoPre" integer NOT NULL
);
    DROP TABLE public."Prestamo";
       public         heap r       postgres    false            �            1259    25437    PrestamoEjemplar    TABLE     �   CREATE TABLE public."PrestamoEjemplar" (
    "idPrestamoEj" integer NOT NULL,
    "idPrestamo" integer NOT NULL,
    "idEjemplar" integer NOT NULL
);
 &   DROP TABLE public."PrestamoEjemplar";
       public         heap r       postgres    false            �            1259    25440 
   Renovacion    TABLE     �   CREATE TABLE public."Renovacion" (
    "idRenovacion" integer NOT NULL,
    "idPrestamo" integer NOT NULL,
    "fechaSalida" date NOT NULL,
    "fechaVence" date NOT NULL,
    "idEstadoRen" integer NOT NULL
);
     DROP TABLE public."Renovacion";
       public         heap r       postgres    false            �            1259    25443    TipoUsuario    TABLE     y   CREATE TABLE public."TipoUsuario" (
    tipo integer NOT NULL,
    "nombreTipoUsuario" character varying(20) NOT NULL
);
 !   DROP TABLE public."TipoUsuario";
       public         heap r       postgres    false            �            1259    25446    TituloAcademico    TABLE     �   CREATE TABLE public."TituloAcademico" (
    "idTituloAcad" integer NOT NULL,
    "nomTituloAcad" character varying(30) NOT NULL
);
 %   DROP TABLE public."TituloAcademico";
       public         heap r       postgres    false            �            1259    25449    Usuario    TABLE     �  CREATE TABLE public."Usuario" (
    cedula integer NOT NULL,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    tipo integer NOT NULL,
    contacto character varying(50) NOT NULL,
    "contraseña" character varying(50) NOT NULL,
    "idBiblioteca" integer,
    "idCarrera" integer,
    "idTituloAcad" integer,
    "idDepartamento" integer,
    direccion character varying(80)
);
    DROP TABLE public."Usuario";
       public         heap r       postgres    false            �            1259    25452    biblioteca_idbiblioteca_seq    SEQUENCE     �   CREATE SEQUENCE public.biblioteca_idbiblioteca_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.biblioteca_idbiblioteca_seq;
       public               postgres    false    217            X           0    0    biblioteca_idbiblioteca_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.biblioteca_idbiblioteca_seq OWNED BY public."Biblioteca"."idBiblioteca";
          public               postgres    false    234            �            1259    25453 %   bibliotecalibro_idbibliotecalibro_seq    SEQUENCE     �   CREATE SEQUENCE public.bibliotecalibro_idbibliotecalibro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public.bibliotecalibro_idbibliotecalibro_seq;
       public               postgres    false    218            Y           0    0 %   bibliotecalibro_idbibliotecalibro_seq    SEQUENCE OWNED BY     s   ALTER SEQUENCE public.bibliotecalibro_idbibliotecalibro_seq OWNED BY public."BibliotecaLibro"."idBibliotecaLibro";
          public               postgres    false    235            �            1259    25454    carrera_idcarrera_seq    SEQUENCE     �   CREATE SEQUENCE public.carrera_idcarrera_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.carrera_idcarrera_seq;
       public               postgres    false    219            Z           0    0    carrera_idcarrera_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.carrera_idcarrera_seq OWNED BY public."Carrera"."idCarrera";
          public               postgres    false    236            �            1259    25455    categoria_idcategoria_seq    SEQUENCE     �   CREATE SEQUENCE public.categoria_idcategoria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.categoria_idcategoria_seq;
       public               postgres    false    220            [           0    0    categoria_idcategoria_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.categoria_idcategoria_seq OWNED BY public."Categoria"."idCategoria";
          public               postgres    false    237            �            1259    25456    departamento_iddepartamento_seq    SEQUENCE     �   CREATE SEQUENCE public.departamento_iddepartamento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.departamento_iddepartamento_seq;
       public               postgres    false    221            \           0    0    departamento_iddepartamento_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.departamento_iddepartamento_seq OWNED BY public."Departamento"."idDepartamento";
          public               postgres    false    238            �            1259    25457    ejemplar_idejemplar_seq    SEQUENCE     �   CREATE SEQUENCE public.ejemplar_idejemplar_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.ejemplar_idejemplar_seq;
       public               postgres    false    222            ]           0    0    ejemplar_idejemplar_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.ejemplar_idejemplar_seq OWNED BY public."Ejemplar"."idEjemplar";
          public               postgres    false    239            �            1259    25458    estadoejemplar_idestadoej_seq    SEQUENCE     �   CREATE SEQUENCE public.estadoejemplar_idestadoej_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.estadoejemplar_idestadoej_seq;
       public               postgres    false    223            ^           0    0    estadoejemplar_idestadoej_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.estadoejemplar_idestadoej_seq OWNED BY public."EstadoEjemplar"."idEstadoEj";
          public               postgres    false    240            �            1259    25459    estadoprestamo_idestadopre_seq    SEQUENCE     �   CREATE SEQUENCE public.estadoprestamo_idestadopre_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.estadoprestamo_idestadopre_seq;
       public               postgres    false    224            _           0    0    estadoprestamo_idestadopre_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.estadoprestamo_idestadopre_seq OWNED BY public."EstadoPrestamo"."idEstadoPre";
          public               postgres    false    241            �            1259    25460     estadorenovacion_idestadoren_seq    SEQUENCE     �   CREATE SEQUENCE public.estadorenovacion_idestadoren_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.estadorenovacion_idestadoren_seq;
       public               postgres    false    225            `           0    0     estadorenovacion_idestadoren_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.estadorenovacion_idestadoren_seq OWNED BY public."EstadoRenovacion"."idEstadoRen";
          public               postgres    false    242            �            1259    25461    libro_idlibro_seq    SEQUENCE     �   CREATE SEQUENCE public.libro_idlibro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.libro_idlibro_seq;
       public               postgres    false    226            a           0    0    libro_idlibro_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.libro_idlibro_seq OWNED BY public."Libro"."idLibro";
          public               postgres    false    243            �            1259    25462    multa_idmulta_seq    SEQUENCE     �   CREATE SEQUENCE public.multa_idmulta_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.multa_idmulta_seq;
       public               postgres    false    227            b           0    0    multa_idmulta_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.multa_idmulta_seq OWNED BY public."Multa"."idMulta";
          public               postgres    false    244            �            1259    25463    prestamo_idprestamo_seq    SEQUENCE     �   CREATE SEQUENCE public.prestamo_idprestamo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.prestamo_idprestamo_seq;
       public               postgres    false    228            c           0    0    prestamo_idprestamo_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.prestamo_idprestamo_seq OWNED BY public."Prestamo"."idPrestamo";
          public               postgres    false    245            �            1259    25464 !   prestamoejemplar_idprestamoej_seq    SEQUENCE     �   CREATE SEQUENCE public.prestamoejemplar_idprestamoej_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.prestamoejemplar_idprestamoej_seq;
       public               postgres    false    229            d           0    0 !   prestamoejemplar_idprestamoej_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public.prestamoejemplar_idprestamoej_seq OWNED BY public."PrestamoEjemplar"."idPrestamoEj";
          public               postgres    false    246            �            1259    25465    renovacion_idrenovacion_seq    SEQUENCE     �   CREATE SEQUENCE public.renovacion_idrenovacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.renovacion_idrenovacion_seq;
       public               postgres    false    230            e           0    0    renovacion_idrenovacion_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.renovacion_idrenovacion_seq OWNED BY public."Renovacion"."idRenovacion";
          public               postgres    false    247            �            1259    25466     tituloacademico_idtituloacad_seq    SEQUENCE     �   CREATE SEQUENCE public.tituloacademico_idtituloacad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.tituloacademico_idtituloacad_seq;
       public               postgres    false    232            f           0    0     tituloacademico_idtituloacad_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.tituloacademico_idtituloacad_seq OWNED BY public."TituloAcademico"."idTituloAcad";
          public               postgres    false    248            ^           2604    25467    Biblioteca idBiblioteca    DEFAULT     �   ALTER TABLE ONLY public."Biblioteca" ALTER COLUMN "idBiblioteca" SET DEFAULT nextval('public.biblioteca_idbiblioteca_seq'::regclass);
 J   ALTER TABLE public."Biblioteca" ALTER COLUMN "idBiblioteca" DROP DEFAULT;
       public               postgres    false    234    217            _           2604    25468 !   BibliotecaLibro idBibliotecaLibro    DEFAULT     �   ALTER TABLE ONLY public."BibliotecaLibro" ALTER COLUMN "idBibliotecaLibro" SET DEFAULT nextval('public.bibliotecalibro_idbibliotecalibro_seq'::regclass);
 T   ALTER TABLE public."BibliotecaLibro" ALTER COLUMN "idBibliotecaLibro" DROP DEFAULT;
       public               postgres    false    235    218            `           2604    25469    Carrera idCarrera    DEFAULT     z   ALTER TABLE ONLY public."Carrera" ALTER COLUMN "idCarrera" SET DEFAULT nextval('public.carrera_idcarrera_seq'::regclass);
 D   ALTER TABLE public."Carrera" ALTER COLUMN "idCarrera" DROP DEFAULT;
       public               postgres    false    236    219            a           2604    25470    Categoria idCategoria    DEFAULT     �   ALTER TABLE ONLY public."Categoria" ALTER COLUMN "idCategoria" SET DEFAULT nextval('public.categoria_idcategoria_seq'::regclass);
 H   ALTER TABLE public."Categoria" ALTER COLUMN "idCategoria" DROP DEFAULT;
       public               postgres    false    237    220            b           2604    25471    Departamento idDepartamento    DEFAULT     �   ALTER TABLE ONLY public."Departamento" ALTER COLUMN "idDepartamento" SET DEFAULT nextval('public.departamento_iddepartamento_seq'::regclass);
 N   ALTER TABLE public."Departamento" ALTER COLUMN "idDepartamento" DROP DEFAULT;
       public               postgres    false    238    221            c           2604    25472    Ejemplar idEjemplar    DEFAULT     ~   ALTER TABLE ONLY public."Ejemplar" ALTER COLUMN "idEjemplar" SET DEFAULT nextval('public.ejemplar_idejemplar_seq'::regclass);
 F   ALTER TABLE public."Ejemplar" ALTER COLUMN "idEjemplar" DROP DEFAULT;
       public               postgres    false    239    222            d           2604    25473    EstadoEjemplar idEstadoEj    DEFAULT     �   ALTER TABLE ONLY public."EstadoEjemplar" ALTER COLUMN "idEstadoEj" SET DEFAULT nextval('public.estadoejemplar_idestadoej_seq'::regclass);
 L   ALTER TABLE public."EstadoEjemplar" ALTER COLUMN "idEstadoEj" DROP DEFAULT;
       public               postgres    false    240    223            e           2604    25474    EstadoPrestamo idEstadoPre    DEFAULT     �   ALTER TABLE ONLY public."EstadoPrestamo" ALTER COLUMN "idEstadoPre" SET DEFAULT nextval('public.estadoprestamo_idestadopre_seq'::regclass);
 M   ALTER TABLE public."EstadoPrestamo" ALTER COLUMN "idEstadoPre" DROP DEFAULT;
       public               postgres    false    241    224            f           2604    25475    EstadoRenovacion idEstadoRen    DEFAULT     �   ALTER TABLE ONLY public."EstadoRenovacion" ALTER COLUMN "idEstadoRen" SET DEFAULT nextval('public.estadorenovacion_idestadoren_seq'::regclass);
 O   ALTER TABLE public."EstadoRenovacion" ALTER COLUMN "idEstadoRen" DROP DEFAULT;
       public               postgres    false    242    225            g           2604    25476    Libro idLibro    DEFAULT     r   ALTER TABLE ONLY public."Libro" ALTER COLUMN "idLibro" SET DEFAULT nextval('public.libro_idlibro_seq'::regclass);
 @   ALTER TABLE public."Libro" ALTER COLUMN "idLibro" DROP DEFAULT;
       public               postgres    false    243    226            h           2604    25477    Multa idMulta    DEFAULT     r   ALTER TABLE ONLY public."Multa" ALTER COLUMN "idMulta" SET DEFAULT nextval('public.multa_idmulta_seq'::regclass);
 @   ALTER TABLE public."Multa" ALTER COLUMN "idMulta" DROP DEFAULT;
       public               postgres    false    244    227            i           2604    25478    Prestamo idPrestamo    DEFAULT     ~   ALTER TABLE ONLY public."Prestamo" ALTER COLUMN "idPrestamo" SET DEFAULT nextval('public.prestamo_idprestamo_seq'::regclass);
 F   ALTER TABLE public."Prestamo" ALTER COLUMN "idPrestamo" DROP DEFAULT;
       public               postgres    false    245    228            j           2604    25479    PrestamoEjemplar idPrestamoEj    DEFAULT     �   ALTER TABLE ONLY public."PrestamoEjemplar" ALTER COLUMN "idPrestamoEj" SET DEFAULT nextval('public.prestamoejemplar_idprestamoej_seq'::regclass);
 P   ALTER TABLE public."PrestamoEjemplar" ALTER COLUMN "idPrestamoEj" DROP DEFAULT;
       public               postgres    false    246    229            k           2604    25480    Renovacion idRenovacion    DEFAULT     �   ALTER TABLE ONLY public."Renovacion" ALTER COLUMN "idRenovacion" SET DEFAULT nextval('public.renovacion_idrenovacion_seq'::regclass);
 J   ALTER TABLE public."Renovacion" ALTER COLUMN "idRenovacion" DROP DEFAULT;
       public               postgres    false    247    230            l           2604    25481    TituloAcademico idTituloAcad    DEFAULT     �   ALTER TABLE ONLY public."TituloAcademico" ALTER COLUMN "idTituloAcad" SET DEFAULT nextval('public.tituloacademico_idtituloacad_seq'::regclass);
 O   ALTER TABLE public."TituloAcademico" ALTER COLUMN "idTituloAcad" DROP DEFAULT;
       public               postgres    false    248    232            2          0    25401 
   Biblioteca 
   TABLE DATA           R   COPY public."Biblioteca" ("idBiblioteca", "nomBiblioteca", direccion) FROM stdin;
    public               postgres    false    217   D�       3          0    25404    BibliotecaLibro 
   TABLE DATA           m   COPY public."BibliotecaLibro" ("idBibliotecaLibro", "idBiblioteca", "idLibro", "cantEjemplares") FROM stdin;
    public               postgres    false    218   L�       4          0    25407    Carrera 
   TABLE DATA           >   COPY public."Carrera" ("idCarrera", "nomCarrera") FROM stdin;
    public               postgres    false    219   ��       5          0    25410 	   Categoria 
   TABLE DATA           D   COPY public."Categoria" ("idCategoria", "nomCategoria") FROM stdin;
    public               postgres    false    220   e�       6          0    25413    Departamento 
   TABLE DATA           M   COPY public."Departamento" ("idDepartamento", "nomDepartamento") FROM stdin;
    public               postgres    false    221   �       7          0    25416    Ejemplar 
   TABLE DATA           V   COPY public."Ejemplar" ("idEjemplar", "idLibro", "idEstadoEj", ubicacion) FROM stdin;
    public               postgres    false    222   j�       8          0    25419    EstadoEjemplar 
   TABLE DATA           G   COPY public."EstadoEjemplar" ("idEstadoEj", "nomEstadoEj") FROM stdin;
    public               postgres    false    223   ��       9          0    25422    EstadoPrestamo 
   TABLE DATA           I   COPY public."EstadoPrestamo" ("idEstadoPre", "nomEstadoPre") FROM stdin;
    public               postgres    false    224   �       :          0    25425    EstadoRenovacion 
   TABLE DATA           K   COPY public."EstadoRenovacion" ("idEstadoRen", "nomEstadoRen") FROM stdin;
    public               postgres    false    225   H�       ;          0    25428    Libro 
   TABLE DATA           R   COPY public."Libro" ("idLibro", titulo, autor, "año", "idCategoria") FROM stdin;
    public               postgres    false    226   ��       <          0    25431    Multa 
   TABLE DATA           U   COPY public."Multa" ("idMulta", "idPrestamo", "fechaInicio", "fechaFin") FROM stdin;
    public               postgres    false    227   ��       =          0    25434    Prestamo 
   TABLE DATA           �   COPY public."Prestamo" ("idPrestamo", cedula, "idEjemplar", "fechaSalida", "fechaVence", "fechaEntrega", "idEstadoPre") FROM stdin;
    public               postgres    false    228   ֬       >          0    25437    PrestamoEjemplar 
   TABLE DATA           X   COPY public."PrestamoEjemplar" ("idPrestamoEj", "idPrestamo", "idEjemplar") FROM stdin;
    public               postgres    false    229   /�       ?          0    25440 
   Renovacion 
   TABLE DATA           p   COPY public."Renovacion" ("idRenovacion", "idPrestamo", "fechaSalida", "fechaVence", "idEstadoRen") FROM stdin;
    public               postgres    false    230   R�       @          0    25443    TipoUsuario 
   TABLE DATA           B   COPY public."TipoUsuario" (tipo, "nombreTipoUsuario") FROM stdin;
    public               postgres    false    231   ��       A          0    25446    TituloAcademico 
   TABLE DATA           L   COPY public."TituloAcademico" ("idTituloAcad", "nomTituloAcad") FROM stdin;
    public               postgres    false    232   Э       B          0    25449    Usuario 
   TABLE DATA           �   COPY public."Usuario" (cedula, nombre, apellido, tipo, contacto, "contraseña", "idBiblioteca", "idCarrera", "idTituloAcad", "idDepartamento", direccion) FROM stdin;
    public               postgres    false    233   &�       g           0    0    biblioteca_idbiblioteca_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.biblioteca_idbiblioteca_seq', 9, true);
          public               postgres    false    234            h           0    0 %   bibliotecalibro_idbibliotecalibro_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.bibliotecalibro_idbibliotecalibro_seq', 4, true);
          public               postgres    false    235            i           0    0    carrera_idcarrera_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.carrera_idcarrera_seq', 15, true);
          public               postgres    false    236            j           0    0    categoria_idcategoria_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.categoria_idcategoria_seq', 10, true);
          public               postgres    false    237            k           0    0    departamento_iddepartamento_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.departamento_iddepartamento_seq', 10, true);
          public               postgres    false    238            l           0    0    ejemplar_idejemplar_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.ejemplar_idejemplar_seq', 4, true);
          public               postgres    false    239            m           0    0    estadoejemplar_idestadoej_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.estadoejemplar_idestadoej_seq', 3, true);
          public               postgres    false    240            n           0    0    estadoprestamo_idestadopre_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.estadoprestamo_idestadopre_seq', 3, true);
          public               postgres    false    241            o           0    0     estadorenovacion_idestadoren_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.estadorenovacion_idestadoren_seq', 3, true);
          public               postgres    false    242            p           0    0    libro_idlibro_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.libro_idlibro_seq', 8, true);
          public               postgres    false    243            q           0    0    multa_idmulta_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.multa_idmulta_seq', 1, true);
          public               postgres    false    244            r           0    0    prestamo_idprestamo_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.prestamo_idprestamo_seq', 3, true);
          public               postgres    false    245            s           0    0 !   prestamoejemplar_idprestamoej_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.prestamoejemplar_idprestamoej_seq', 1, true);
          public               postgres    false    246            t           0    0    renovacion_idrenovacion_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.renovacion_idrenovacion_seq', 1, true);
          public               postgres    false    247            u           0    0     tituloacademico_idtituloacad_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.tituloacademico_idtituloacad_seq', 3, true);
          public               postgres    false    248            n           2606    25483    Biblioteca biblioteca_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public."Biblioteca"
    ADD CONSTRAINT biblioteca_pkey PRIMARY KEY ("idBiblioteca");
 F   ALTER TABLE ONLY public."Biblioteca" DROP CONSTRAINT biblioteca_pkey;
       public                 postgres    false    217            p           2606    25485 $   BibliotecaLibro bibliotecalibro_pkey 
   CONSTRAINT     u   ALTER TABLE ONLY public."BibliotecaLibro"
    ADD CONSTRAINT bibliotecalibro_pkey PRIMARY KEY ("idBibliotecaLibro");
 P   ALTER TABLE ONLY public."BibliotecaLibro" DROP CONSTRAINT bibliotecalibro_pkey;
       public                 postgres    false    218            r           2606    25487    Carrera carrera_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public."Carrera"
    ADD CONSTRAINT carrera_pkey PRIMARY KEY ("idCarrera");
 @   ALTER TABLE ONLY public."Carrera" DROP CONSTRAINT carrera_pkey;
       public                 postgres    false    219            t           2606    25489    Categoria categoria_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public."Categoria"
    ADD CONSTRAINT categoria_pkey PRIMARY KEY ("idCategoria");
 D   ALTER TABLE ONLY public."Categoria" DROP CONSTRAINT categoria_pkey;
       public                 postgres    false    220            v           2606    25491    Departamento departamento_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public."Departamento"
    ADD CONSTRAINT departamento_pkey PRIMARY KEY ("idDepartamento");
 J   ALTER TABLE ONLY public."Departamento" DROP CONSTRAINT departamento_pkey;
       public                 postgres    false    221            x           2606    25493    Ejemplar ejemplar_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public."Ejemplar"
    ADD CONSTRAINT ejemplar_pkey PRIMARY KEY ("idEjemplar");
 B   ALTER TABLE ONLY public."Ejemplar" DROP CONSTRAINT ejemplar_pkey;
       public                 postgres    false    222            z           2606    25495 "   EstadoEjemplar estadoejemplar_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public."EstadoEjemplar"
    ADD CONSTRAINT estadoejemplar_pkey PRIMARY KEY ("idEstadoEj");
 N   ALTER TABLE ONLY public."EstadoEjemplar" DROP CONSTRAINT estadoejemplar_pkey;
       public                 postgres    false    223            |           2606    25497 "   EstadoPrestamo estadoprestamo_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY public."EstadoPrestamo"
    ADD CONSTRAINT estadoprestamo_pkey PRIMARY KEY ("idEstadoPre");
 N   ALTER TABLE ONLY public."EstadoPrestamo" DROP CONSTRAINT estadoprestamo_pkey;
       public                 postgres    false    224            ~           2606    25499 &   EstadoRenovacion estadorenovacion_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public."EstadoRenovacion"
    ADD CONSTRAINT estadorenovacion_pkey PRIMARY KEY ("idEstadoRen");
 R   ALTER TABLE ONLY public."EstadoRenovacion" DROP CONSTRAINT estadorenovacion_pkey;
       public                 postgres    false    225            �           2606    25501    Libro libro_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public."Libro"
    ADD CONSTRAINT libro_pkey PRIMARY KEY ("idLibro");
 <   ALTER TABLE ONLY public."Libro" DROP CONSTRAINT libro_pkey;
       public                 postgres    false    226            �           2606    25503    Multa multa_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public."Multa"
    ADD CONSTRAINT multa_pkey PRIMARY KEY ("idMulta");
 <   ALTER TABLE ONLY public."Multa" DROP CONSTRAINT multa_pkey;
       public                 postgres    false    227            �           2606    25505    Prestamo prestamo_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public."Prestamo"
    ADD CONSTRAINT prestamo_pkey PRIMARY KEY ("idPrestamo");
 B   ALTER TABLE ONLY public."Prestamo" DROP CONSTRAINT prestamo_pkey;
       public                 postgres    false    228            �           2606    25507 &   PrestamoEjemplar prestamoejemplar_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public."PrestamoEjemplar"
    ADD CONSTRAINT prestamoejemplar_pkey PRIMARY KEY ("idPrestamoEj");
 R   ALTER TABLE ONLY public."PrestamoEjemplar" DROP CONSTRAINT prestamoejemplar_pkey;
       public                 postgres    false    229            �           2606    25509    Renovacion renovacion_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public."Renovacion"
    ADD CONSTRAINT renovacion_pkey PRIMARY KEY ("idRenovacion");
 F   ALTER TABLE ONLY public."Renovacion" DROP CONSTRAINT renovacion_pkey;
       public                 postgres    false    230            �           2606    25511    TipoUsuario tipousuario_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."TipoUsuario"
    ADD CONSTRAINT tipousuario_pkey PRIMARY KEY (tipo);
 H   ALTER TABLE ONLY public."TipoUsuario" DROP CONSTRAINT tipousuario_pkey;
       public                 postgres    false    231            �           2606    25513 $   TituloAcademico tituloacademico_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public."TituloAcademico"
    ADD CONSTRAINT tituloacademico_pkey PRIMARY KEY ("idTituloAcad");
 P   ALTER TABLE ONLY public."TituloAcademico" DROP CONSTRAINT tituloacademico_pkey;
       public                 postgres    false    232            �           2606    25515    Usuario usuario_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (cedula);
 @   ALTER TABLE ONLY public."Usuario" DROP CONSTRAINT usuario_pkey;
       public                 postgres    false    233            �           2606    25516 1   BibliotecaLibro bibliotecalibro_idbiblioteca_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."BibliotecaLibro"
    ADD CONSTRAINT bibliotecalibro_idbiblioteca_fkey FOREIGN KEY ("idBiblioteca") REFERENCES public."Biblioteca"("idBiblioteca");
 ]   ALTER TABLE ONLY public."BibliotecaLibro" DROP CONSTRAINT bibliotecalibro_idbiblioteca_fkey;
       public               postgres    false    218    4718    217            �           2606    25521 ,   BibliotecaLibro bibliotecalibro_idlibro_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."BibliotecaLibro"
    ADD CONSTRAINT bibliotecalibro_idlibro_fkey FOREIGN KEY ("idLibro") REFERENCES public."Libro"("idLibro");
 X   ALTER TABLE ONLY public."BibliotecaLibro" DROP CONSTRAINT bibliotecalibro_idlibro_fkey;
       public               postgres    false    4736    226    218            �           2606    25526 !   Ejemplar ejemplar_idestadoej_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Ejemplar"
    ADD CONSTRAINT ejemplar_idestadoej_fkey FOREIGN KEY ("idEstadoEj") REFERENCES public."EstadoEjemplar"("idEstadoEj");
 M   ALTER TABLE ONLY public."Ejemplar" DROP CONSTRAINT ejemplar_idestadoej_fkey;
       public               postgres    false    4730    222    223            �           2606    25531    Ejemplar ejemplar_idlibro_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Ejemplar"
    ADD CONSTRAINT ejemplar_idlibro_fkey FOREIGN KEY ("idLibro") REFERENCES public."Libro"("idLibro");
 J   ALTER TABLE ONLY public."Ejemplar" DROP CONSTRAINT ejemplar_idlibro_fkey;
       public               postgres    false    222    4736    226            �           2606    25536    Libro libro_idcategoria_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Libro"
    ADD CONSTRAINT libro_idcategoria_fkey FOREIGN KEY ("idCategoria") REFERENCES public."Categoria"("idCategoria");
 H   ALTER TABLE ONLY public."Libro" DROP CONSTRAINT libro_idcategoria_fkey;
       public               postgres    false    226    220    4724            �           2606    25541    Multa multa_idprestamo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Multa"
    ADD CONSTRAINT multa_idprestamo_fkey FOREIGN KEY ("idPrestamo") REFERENCES public."Prestamo"("idPrestamo");
 G   ALTER TABLE ONLY public."Multa" DROP CONSTRAINT multa_idprestamo_fkey;
       public               postgres    false    228    4740    227            �           2606    25546    Prestamo prestamo_cedula_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Prestamo"
    ADD CONSTRAINT prestamo_cedula_fkey FOREIGN KEY (cedula) REFERENCES public."Usuario"(cedula);
 I   ALTER TABLE ONLY public."Prestamo" DROP CONSTRAINT prestamo_cedula_fkey;
       public               postgres    false    228    233    4750            �           2606    25551 !   Prestamo prestamo_idejemplar_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Prestamo"
    ADD CONSTRAINT prestamo_idejemplar_fkey FOREIGN KEY ("idEjemplar") REFERENCES public."Ejemplar"("idEjemplar");
 M   ALTER TABLE ONLY public."Prestamo" DROP CONSTRAINT prestamo_idejemplar_fkey;
       public               postgres    false    222    228    4728            �           2606    25556 "   Prestamo prestamo_idestadopre_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Prestamo"
    ADD CONSTRAINT prestamo_idestadopre_fkey FOREIGN KEY ("idEstadoPre") REFERENCES public."EstadoPrestamo"("idEstadoPre");
 N   ALTER TABLE ONLY public."Prestamo" DROP CONSTRAINT prestamo_idestadopre_fkey;
       public               postgres    false    228    224    4732            �           2606    25561 1   PrestamoEjemplar prestamoejemplar_idejemplar_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."PrestamoEjemplar"
    ADD CONSTRAINT prestamoejemplar_idejemplar_fkey FOREIGN KEY ("idEjemplar") REFERENCES public."Ejemplar"("idEjemplar");
 ]   ALTER TABLE ONLY public."PrestamoEjemplar" DROP CONSTRAINT prestamoejemplar_idejemplar_fkey;
       public               postgres    false    229    222    4728            �           2606    25566 1   PrestamoEjemplar prestamoejemplar_idprestamo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."PrestamoEjemplar"
    ADD CONSTRAINT prestamoejemplar_idprestamo_fkey FOREIGN KEY ("idPrestamo") REFERENCES public."Prestamo"("idPrestamo");
 ]   ALTER TABLE ONLY public."PrestamoEjemplar" DROP CONSTRAINT prestamoejemplar_idprestamo_fkey;
       public               postgres    false    229    228    4740            �           2606    25571 &   Renovacion renovacion_idestadoren_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Renovacion"
    ADD CONSTRAINT renovacion_idestadoren_fkey FOREIGN KEY ("idEstadoRen") REFERENCES public."EstadoRenovacion"("idEstadoRen");
 R   ALTER TABLE ONLY public."Renovacion" DROP CONSTRAINT renovacion_idestadoren_fkey;
       public               postgres    false    225    230    4734            �           2606    25576 %   Renovacion renovacion_idprestamo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Renovacion"
    ADD CONSTRAINT renovacion_idprestamo_fkey FOREIGN KEY ("idPrestamo") REFERENCES public."Prestamo"("idPrestamo");
 Q   ALTER TABLE ONLY public."Renovacion" DROP CONSTRAINT renovacion_idprestamo_fkey;
       public               postgres    false    228    4740    230            �           2606    25581 !   Usuario usuario_idbiblioteca_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT usuario_idbiblioteca_fkey FOREIGN KEY ("idBiblioteca") REFERENCES public."Biblioteca"("idBiblioteca");
 M   ALTER TABLE ONLY public."Usuario" DROP CONSTRAINT usuario_idbiblioteca_fkey;
       public               postgres    false    233    4718    217            �           2606    25586    Usuario usuario_idcarrera_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT usuario_idcarrera_fkey FOREIGN KEY ("idCarrera") REFERENCES public."Carrera"("idCarrera");
 J   ALTER TABLE ONLY public."Usuario" DROP CONSTRAINT usuario_idcarrera_fkey;
       public               postgres    false    233    219    4722            �           2606    25591 #   Usuario usuario_iddepartamento_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT usuario_iddepartamento_fkey FOREIGN KEY ("idDepartamento") REFERENCES public."Departamento"("idDepartamento");
 O   ALTER TABLE ONLY public."Usuario" DROP CONSTRAINT usuario_iddepartamento_fkey;
       public               postgres    false    233    221    4726            �           2606    25596 !   Usuario usuario_idtituloacad_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT usuario_idtituloacad_fkey FOREIGN KEY ("idTituloAcad") REFERENCES public."TituloAcademico"("idTituloAcad");
 M   ALTER TABLE ONLY public."Usuario" DROP CONSTRAINT usuario_idtituloacad_fkey;
       public               postgres    false    4748    233    232            �           2606    25601    Usuario usuario_tipo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT usuario_tipo_fkey FOREIGN KEY (tipo) REFERENCES public."TipoUsuario"(tipo);
 E   ALTER TABLE ONLY public."Usuario" DROP CONSTRAINT usuario_tipo_fkey;
       public               postgres    false    4746    231    233            2   �   x����J1��7O1OPp��^ֵ`�BA�ʛ�̰d'�d����]�
.ބ0�s�SW����=�%14���x��6���T�br���ች�;�ImÝҐK�ww9��Qc/U�!0���`J���]�)7]���l��n9��ӎU�P�(�:$c���o#�=�[��}{5u�Z0���C�*����^�������xQ�g.檘~�XWg)�k��]��9�:d�_�gC ��^ι@R��      3   (   x�3�4BS.# i�i�e��9��L����	W� Y��      4   �   x�M��n�0Dk�+�A�G��0�X �Q���\��D���p�Ἑ�pօU����rIT%��T��B��������/Ҍ�?E���QZ1<n3F���[iXJ֜z�#JQḺ�W�ʉ���7����^$���
u�7.�����d뾘�~y�4���P*��"Y�1�{x/WR����~��#�Y+ͭ7O�{��"� �f�      5   q   x�-��
�@D��ǔ��V?��A赗��K`u���cZ�͛yLEö`_�h��(%�p�Ί�j�i2�H*����.?� �h��.`��sCc,�O���f�Օ�����f> ��(�      6   t   x�-�K
A��a���Rtf'��<�F�����w��W�)#L���}aKc������K�i�)��4��>�-�$o�#]4[�E��>ќ����4#|�W�aMj���c��`�*�      7   C   x�3�4��̜�|#��ļ�Tc�̜D#.#N#Nc�C��C.c���
b���� �h�      8   8   x�3�t�,.���L�I�2�(J-.IL��2�t�S�M�+I����L�+������ z��      9   3   x�3�t�,.���L�I�2�JM�H�JL��2�t�S((�ON-������ ,B�      :   -   x�3�t,(�OJL��2�JM�H���9]��ɩ��\1z\\\ ��      ;     x�=�Aj�@EךSh�U)��&dY�.���"P�Q<j"�ȟHo�#�!��BW⣧��إx�����O�'/���`O���q��5q�rZ�0s%��!D\�;'�V(��U%㫄`�t�������1Q@X�td|!���UP)G�]�Ɲ��۷�.%�J�%O�uY@�`ǚ)a�}v��v�s��:T8��N�g��W�������2|��HgN�W#X{>�b�(�Y��G� ��m�_6��_��F�%��S�X�X��P,���|�w�� p{p�      <      x�3�4�4202�54�52E0͹b���� RT      =   I   x�U���0�ΰK*�$����HN��,�2H3=,�@*�24
WG�Қ!n7��Av���p�n{��߿3o1      >      x�3�4�4����� �X      ?   !   x�3�4�4202�54�5��3�8�b���� \�=      @   =   x�3�t-.)M�L�+I�2�(�OK-�/�2�tL����,.)JL�M8]+JR���b���� �y[      A   F   x�3���KO-��WH�S��K�/�M,�LN�2���LN�K�LL��&��B��Ѥ�3��s��3�b���� �i�      B   �   x�m�1
�0Eg�0Œe's��RJ�,&1�`p���Wu�$H��D"��\S�W,iʥlo@��$ґH�u�0ގ6β�b�ƽ�)o��暗=}Kz�m�x�v�[v��%x�W����>�?�qjÐ��zT��{�)�x�ɶ�>�=Q�c�E4�     