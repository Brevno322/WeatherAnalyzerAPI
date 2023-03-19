CREATE TABLE current_weather(id integer NOT NULL AUTO_INCREMENT,
temperature double(5,5),
speed double(5,5),
pressure double(5,5),
humidity integer,
conditions varchar(20),
location varchar (20),
primary key(id));