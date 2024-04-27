SELECT
    UGU.USER_ID,
    UGU.NICKNAME,
    SUM(UGB.PRICE)
FROM USED_GOODS_BOARD UGB, USED_GOODS_USER UGU
WHERE UGB.WRITER_ID = UGU.USER_ID AND UGB.STATUS = 'DONE'
GROUP BY UGU.USER_ID, UGU.NICKNAME
HAVING SUM(UGB.PRICE) >= 700000
ORDER BY SUM(UGB.PRICE);