delimiter //
create procedure
getTotalAmountInYear(
	in yearNo int,
    out totalAmt int
)
begin
	set @yn = concat(yearNo, "%");
	select sum(order_amount) from orders o, payment p where order_date like @yn and payment_status = "SUCCESS" and o.order_id = p.order_id;
end //
delimiter ;

call getTotalAmountInYear(2019, @totAmt);
call getTotalAmountInYear(2018, @totAmt);
