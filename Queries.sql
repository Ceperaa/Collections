--Написать запрос для поиска товара с названием начинающимся на “А”
select *
from cash_register.public.product
where "like"(name, 'A%');

-- Написать запросы с JOIN
select p.name, p.price,pi.total_price_with_discount,pi.total_price,pi.price_with_discount,pi.discount_percent
from public."check"
join cash_register.public.product_information pi on "check".id = pi.check_id
join product p on pi.product_id = p.id
where check_id = 1;

-- Написать запрос с группировкой данных и последующей фильтрацией
select name,p.price, count(check_Id) count,sum(c.total_price) price
from cash_register.public."check" c
join product_information pi on c.id = pi.check_id
join product p on pi.product_id = p.id
group by name,p.price;

-- Написать запрос с группировкой данных и последующей фильтрацией
select product_id, count(check_Id) amount_of_deals,sum(total_price) total_price
from product_information
group by product_id
order by product_id;

-- Написать запрос с вложенным запросом
select *
from cash_register.public."check"
where id = (select max(check_id) last_check_id from cash_register.public.product_information);

