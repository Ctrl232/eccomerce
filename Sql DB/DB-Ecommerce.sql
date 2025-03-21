PGDMP                          }            ecommercedb    14.17    14.17                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16453    ecommercedb    DATABASE     Z   CREATE DATABASE ecommercedb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'es-CO';
    DROP DATABASE ecommercedb;
                postgres    false            �            1259    16454    orderproducts    TABLE     :  CREATE TABLE public.orderproducts (
    quantity integer,
    product_entity_id integer NOT NULL,
    order_entity_id integer NOT NULL,
    created_by character varying(255),
    date_created timestamp(6) without time zone,
    date_updated timestamp(6) without time zone,
    updated_by character varying(255)
);
 !   DROP TABLE public.orderproducts;
       public         heap    postgres    false            �            1259    16460    orders    TABLE     �   CREATE TABLE public.orders (
    id integer NOT NULL,
    date_created timestamp(6) without time zone,
    user_id integer,
    created_by character varying(255),
    date_updated timestamp(6) without time zone,
    updated_by character varying(255)
);
    DROP TABLE public.orders;
       public         heap    postgres    false            �            1259    16459    orders_id_seq    SEQUENCE     �   ALTER TABLE public.orders ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    211            �            1259    16466    products    TABLE     �  CREATE TABLE public.products (
    id integer NOT NULL,
    code character varying(255),
    date_created timestamp(6) without time zone,
    date_updated timestamp(6) without time zone,
    description character varying(255),
    image character varying(255),
    name character varying(255),
    price numeric(38,2),
    user_entity_id integer,
    created_by character varying(255),
    updated_by character varying(255)
);
    DROP TABLE public.products;
       public         heap    postgres    false            �            1259    16465    products_id_seq    SEQUENCE     �   ALTER TABLE public.products ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    213            �            1259    16474    stock    TABLE     n  CREATE TABLE public.stock (
    id integer NOT NULL,
    balance integer,
    date_created timestamp(6) without time zone,
    description character varying(255),
    unit_in integer,
    unit_out integer,
    product_entity_id integer,
    created_by character varying(255),
    date_updated timestamp(6) without time zone,
    updated_by character varying(255)
);
    DROP TABLE public.stock;
       public         heap    postgres    false            �            1259    16473    stock_id_seq    SEQUENCE     �   ALTER TABLE public.stock ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.stock_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �            1259    16499    users    TABLE     �  CREATE TABLE public.users (
    id integer NOT NULL,
    address character varying(255),
    cellphone character varying(255),
    date_created timestamp(6) without time zone,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    user_type character varying(255),
    username character varying(255),
    created_by character varying(255),
    date_updated timestamp(6) without time zone,
    updated_by character varying(255),
    CONSTRAINT users_user_type_check CHECK (((user_type)::text = ANY ((ARRAY['ADMIN'::character varying, 'USER'::character varying, 'USER_TYPE'::character varying])::text[])))
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16498    users_id_seq    SEQUENCE     �   ALTER TABLE public.users ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217            
          0    16454    orderproducts 
   TABLE DATA           �   COPY public.orderproducts (quantity, product_entity_id, order_entity_id, created_by, date_created, date_updated, updated_by) FROM stdin;
    public          postgres    false    209   �*                 0    16460    orders 
   TABLE DATA           a   COPY public.orders (id, date_created, user_id, created_by, date_updated, updated_by) FROM stdin;
    public          postgres    false    211   �*                 0    16466    products 
   TABLE DATA           �   COPY public.products (id, code, date_created, date_updated, description, image, name, price, user_entity_id, created_by, updated_by) FROM stdin;
    public          postgres    false    213   T+                 0    16474    stock 
   TABLE DATA           �   COPY public.stock (id, balance, date_created, description, unit_in, unit_out, product_entity_id, created_by, date_updated, updated_by) FROM stdin;
    public          postgres    false    215   �/                 0    16499    users 
   TABLE DATA           �   COPY public.users (id, address, cellphone, date_created, email, first_name, last_name, password, user_type, username, created_by, date_updated, updated_by) FROM stdin;
    public          postgres    false    217   p0                  0    0    orders_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.orders_id_seq', 5, true);
          public          postgres    false    210                       0    0    products_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.products_id_seq', 16, true);
          public          postgres    false    212                       0    0    stock_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.stock_id_seq', 14, true);
          public          postgres    false    214                       0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 8, true);
          public          postgres    false    216            q           2606    16458     orderproducts orderproducts_pkey 
   CONSTRAINT     ~   ALTER TABLE ONLY public.orderproducts
    ADD CONSTRAINT orderproducts_pkey PRIMARY KEY (order_entity_id, product_entity_id);
 J   ALTER TABLE ONLY public.orderproducts DROP CONSTRAINT orderproducts_pkey;
       public            postgres    false    209    209            s           2606    16464    orders orders_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public            postgres    false    211            u           2606    16472    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            postgres    false    213            w           2606    16478    stock stock_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.stock
    ADD CONSTRAINT stock_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.stock DROP CONSTRAINT stock_pkey;
       public            postgres    false    215            y           2606    16506    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    217            |           2606    16507 "   orders fk32ql8ubntj5uh44ph9659tiih    FK CONSTRAINT     �   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk32ql8ubntj5uh44ph9659tiih FOREIGN KEY (user_id) REFERENCES public.users(id);
 L   ALTER TABLE ONLY public.orders DROP CONSTRAINT fk32ql8ubntj5uh44ph9659tiih;
       public          postgres    false    3193    217    211            }           2606    16512 $   products fk8so90o4249ddoho1u5jo40a1s    FK CONSTRAINT     �   ALTER TABLE ONLY public.products
    ADD CONSTRAINT fk8so90o4249ddoho1u5jo40a1s FOREIGN KEY (user_entity_id) REFERENCES public.users(id);
 N   ALTER TABLE ONLY public.products DROP CONSTRAINT fk8so90o4249ddoho1u5jo40a1s;
       public          postgres    false    213    3193    217            ~           2606    16493 !   stock fki7p396hv9dc10y8wch5ybyd0g    FK CONSTRAINT     �   ALTER TABLE ONLY public.stock
    ADD CONSTRAINT fki7p396hv9dc10y8wch5ybyd0g FOREIGN KEY (product_entity_id) REFERENCES public.products(id) ON DELETE CASCADE;
 K   ALTER TABLE ONLY public.stock DROP CONSTRAINT fki7p396hv9dc10y8wch5ybyd0g;
       public          postgres    false    3189    215    213            z           2606    16483 )   orderproducts fkkb5t5ru14ovo0tec990ul3seb    FK CONSTRAINT     �   ALTER TABLE ONLY public.orderproducts
    ADD CONSTRAINT fkkb5t5ru14ovo0tec990ul3seb FOREIGN KEY (product_entity_id) REFERENCES public.products(id);
 S   ALTER TABLE ONLY public.orderproducts DROP CONSTRAINT fkkb5t5ru14ovo0tec990ul3seb;
       public          postgres    false    209    3189    213            {           2606    16488 )   orderproducts fkkubrso069k5wh7cq9q1kok09a    FK CONSTRAINT     �   ALTER TABLE ONLY public.orderproducts
    ADD CONSTRAINT fkkubrso069k5wh7cq9q1kok09a FOREIGN KEY (order_entity_id) REFERENCES public.orders(id);
 S   ALTER TABLE ONLY public.orderproducts DROP CONSTRAINT fkkubrso069k5wh7cq9q1kok09a;
       public          postgres    false    209    3187    211            
   R   x�}���0Dk{�,��Ύd$
ؿAG��}(�T����`��ِ�{L,��[*�M�a:����2B�h-�z���         Q   x�3�4202�50�52P02�25�20�364421�4�LL���ç�����P���� ��H�����Ќ��L%Sb���� ~�@         I  x�}UKr�F]�Sdx��>4]ŮգOX=V�1m��h�.@#�6:����}1'�j�4� � ���%4�Z�P$E�4NB��8�J�Dfr���yHxH%0��EJeĥ s�!8j�֪�>U���EW����[SwJ���r��J�.�ܚ��Ӥ���5u�<l�6���SӺ��/�	!yc���mlg�5��D7�&X��5��j:;HdDmp�	�JZȜ�L��Jn�$T�(�8ג/r%h�ߢ�<�s��oCp��Nݘ(%�C��Rۿ�p����T)p?��{7a<Gz����d��)���Q������M��r�p�jS��r|9��(K�fqBt�����=����~������������.�ͬ4QP��v��xǰQ��p����7p|�r�o!+{�F:`����X$$��E�D,��P.�@I�e�HB��	�PB�7�S�Q��V�W!X[��_W�!��K�����d����b�l����vô�͢��a��|n�ů'e���kg����j7��8ܳ�n+ێ1SÝ�s3�s�Ë+�|v�y�������i�h�q<~T���q��/�j��.x0��y����շ0�lDy=�<D����+x��:�.P�s>�X𰠙�JSŲx�2#�h:�)�ܜ�D�_�x�W�"�|0�cbtC}��U"��7�x��X�CŭM�Up�\� ����C��t�ۧ�j�eӔ�D�r������Z~n1�O��e
��,�U3�yB�����Yp��l�_la�a��ι�z�7���εC)�_�.%k�=pt�o\��U�й[8��06����~K�3*W���� 2�#���C��~�,�q�������N啭з�:\!��Ra���c&T�XP9WRK�"BR�8����Ǒ �q���X5�X��
�8X{���،�]�6ۿ�@��OOѧ��k�Y�/�߅xx&w�l�\�Pm��m5nG9�kw����\�|7h۠v;�]�c�c���3׃���Y�j�S��)5�Q���oP�eg���2E@8�T��;W�-sF��s�.�.�C���U�is�F�Z�         �   x�}�M
�0����@��d�39�'覠�.� ��m��V!$��=I@��ȾG�3vDه,dc���y��}���pZ��.�(��d�<Fm�VL����٪
clu��͠�jvE�u��Z���4�K��!����P&�¢��#|��ջ]6�kl��6������Z:Xc��.ds         �  x�}�]s�0������2'	�����Z+���ӛ(Ȇ��`���Gm�vf3�ə9o��$�T�vQ�0�4D����k;q0�m��
D&��G�
����Υ��"�D�P��&�f��̭�8-���[�x�=��{��ȫ�e1���A���^�@ng�}��yt���Z*D	6��1�OT[�P� �)��8ڈ"Q�]N�R@�2��:����M��buw���D~Ɠ���v��E��/�:��M��>Z̺��D�#�y"��8���Ĵ$�TfvK�F�y�6c%p?�S�f�%�Z��N�����K"Rh(�����ME�e c�N�{�<�����d_��t���({_�c3�?��e������r��>2��0怡ۢ6}��ha��QL���م5 �X���&?u�N�=E&������<�����P{����O�Pp�}��]t8�UP��J��̇�*�j|��B���Ƴ�h4��"��     