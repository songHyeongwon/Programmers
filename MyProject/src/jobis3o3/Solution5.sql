-- �ڵ带 �Է��ϼ���
SELECT CART_ID, NAME, COUNT(*) AS QUANTITY
FROM CART_PRODUCTS
group BY CART_ID, NAME
order by CART_ID , NAME;