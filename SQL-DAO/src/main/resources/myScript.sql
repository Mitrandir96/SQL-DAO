SELECT ORDERS.product_name
FROM CUSTOMERS
JOIN ORDERS ON ORDERS.customer_id = CUSTOMERS.id
WHERE lower(CUSTOMERS.name) = lower (:name);