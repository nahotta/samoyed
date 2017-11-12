use samoyed;
create table `case` (
  `case_id` int(10) NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `expected` text NOT NULL,
  `method` text NOT NULL,
  `condition` text NOT NULL,
  primary key(`case_id`)
);
