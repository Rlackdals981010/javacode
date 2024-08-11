SELECT ugs.USER_ID , ugs.NICKNAME , sum(ugb.PRICE) as TOTAL_SALES
from USED_GOODS_BOARD ugb inner join  USED_GOODS_USER ugs
                                      on  ugb.WRITER_ID = ugs.USER_ID where  ugb.STATUS like 'DONE'
group by  ugs.USER_ID having TOTAL_SALES>=700000
order by TOTAL_SALES

