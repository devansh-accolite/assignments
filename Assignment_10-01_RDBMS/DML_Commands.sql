insert into location values 
(1, "Street #1", "Bangalore"),
(2, "Street #2", "Bangalore"),
(3, "Street #3", "Mysore"),
(4, "Street #4", "Mysore"),
(5, "Street #5", "Bangalore"),
(6, "Street #6", "Hubli"),
(7, "Street #7", "Mangalore"),
(8, "Street #8", "Bangalore"),
(9, "Street #9", "Mysore"),
(10, "Street #10", "Bangalore");

insert into taxi values 
("KA12AB7868", "Model #1", "Sedan"),
("KA15AA6232", "Model #4", "XUV"),
("KA22GS4523", "Model #3", "Hatchback"),
("KA62EG5621", "Model #1", "Sedan"),
("KA15VF6712", "Model #5", "XUV");

insert into driver values 
(1, "Driver 1", 6, 9273874839, 8, 4, "KA12AB7868"),
(2, "Driver 2", 2, 8345675442, 1, 8, "KA15AA6232"),
(3, "Driver 3", 3, 9645467678, 9, 1, "KA22GS4523"),
(4, "Driver 4", 6, 9544567876, 2, 1, "KA62EG5621"),
(5, "Driver 5", 1, 7345678765, 7, 2, "KA15VF6712");

insert into customer values 
(1, "Customer 1", 2, 7345678976, 3),
(2, "Customer 2", 6, 8879213482, 1),
(3, "Customer 3", 7, 8894274928, 7),
(4, "Customer 4", 3, 9094827163, 4),
(5, "Customer 5", 8, 7000234039, 8);

insert into orders values 
(1, 1, 5, "2019-01-02 12:50:57", 150, 3, 8),
(2, 4, 1, "2018-12-27 09:00:34", 285, 5, 3),
(3, 5, 2, "2018-11-12 06:47:00", 670, 8, 9),
(4, 5, 3, "2019-01-10 14:12:20", 1280, 8, 1),
(5, 2, 3, "2018-12-10 19:03:42", 365, 1, 2);

insert into payment values 
(1, 5, 3, "SUCCESS", "Cash", "2018-11-12 12:48:32"),
(2, 2, 5, "FAILED", "Credit", "2018-12-10 20:50:30"),
(3, 4, 2, "SUCCESS", "Credit", "2018-12-27 12:03:41"),
(4, 1, 1, "SUCCESS", "Cash", "2019-01-02 15:12:01"),
(5, 5, 4, "FAILED", "Cash", "2019-01-10 22:44:14");

--
--

select driver_name from driver where driver_rating > 5;

select t.taxi_no, driver_name from taxi t, driver d where t.taxi_no = d.taxi_no and t.taxi_type = "Sedan";

update driver set driver_rating = 4 where driver_id = 2;
