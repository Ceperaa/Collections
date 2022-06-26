CREATE TABLE IF NOT EXISTS public.product
(
    id SERIAL PRIMARY KEY,
    name varchar(50) NOT NULL,
    amount integer NOT NULL,
    discount_percent integer,
    price money NOT NULL
);

--DROP TABLE IF EXISTS public.discount_card;

CREATE TABLE IF NOT EXISTS public.discount_card
(
    id SERIAL PRIMARY KEY,
    discount integer NOT NULL
);

--DROP TABLE IF EXISTS public."check";

CREATE TABLE IF NOT EXISTS public."check"
(
    id SERIAL PRIMARY KEY,
    total_price_with_discount money NOT NULL,
    total_price money NOT NULL,
    discount_amount integer,
    total_percent integer
);
--DROP TABLE IF EXISTS public.product_information;

CREATE TABLE IF NOT EXISTS public.product_information
(
    id SERIAL PRIMARY KEY,
    price_with_discount money NOT NULL,
    check_id integer NOT NULL,
    product_id integer NOT NULL,
    total_price money NOT NULL,
    total_price_with_discount money NOT NULL,
    discount_percent integer NOT NULL,
    CONSTRAINT "check" FOREIGN KEY (check_id)
        REFERENCES public."check" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT product FOREIGN KEY (product_id)
        REFERENCES public.product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);