BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO brewery
VALUES(1,1,'name','823498237948','beer.com','2384 main st','beertown','Ohio','history','9-5', 'beer.img', 'brewery');

INSERT INTO brewery (brewery_id, brewer_id, name, phone_number, url, street, city, state, history, open_hours, image, brewery_type)
						  VALUES('2',1, 'Morbin Brewin Memphis','554-564-8978','mobrewmemph.com','312 N. High Street','Memphis','Tennessee','We all knew what time it was.','3-10p','image.png','large');

INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('2', 'Java Sippin', 'A coffee cream ale, delicious with brunch', 'beer.png','6.0','Coffee Cream Ale');

INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('2', 'Guarnera Guava', 'Guava flavored IPA', 'img.png','5.5','IPA');

INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('2', 'Passion Fruit Pilsner', 'Bursting with Passion fruit Flavor', 'image.jpg','10.0','Pilsner');

INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('2', 'Memphis Ale', 'Classic, easy-drinking, Elvis favorite beer', 'elvis.jpg','4.2','Light Ale');

INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('2', 'Tiger IPA', 'Memphis University signature IPA', 'tiger.jpg','8.2','IPA');



INSERT INTO brewery (brewery_id, brewer_id, name, phone_number, url, street, city, state, history, open_hours, image, brewery_type)
						  VALUES('3',1, 'Casio Creations','704-564-8978','casiocreations.com','12 N. Lie Street','Salt Lake City','Utah','Cheap Watches, Cheap Beer','3-10p','img.png','micro');

INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('3', 'Casio Cream Ale', 'Our Signature Cream Ale', 'image.png','5.6','Cream Ale');

INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('3', 'What Time is It?', 'Morbin time', 'morb.img','10','Stout');

INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('3', 'SLC Slammer', 'Full-bodied beer Salty like our Lake', 'salt.png','4.5','American Light');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('3', 'Bood Ligh', 'Like your favorite cheap beer but different', 'beer.png','4.2','Lager');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('3', 'Nait Lait', 'Like your favorite cheap beer in college', 'beer.jpg','5.1','Lager');

INSERT INTO brewery (brewery_id, brewer_id, name, phone_number, url, street, city, state, history, open_hours, image, brewery_type)
						  VALUES('4',1, 'Wasting Time Brewery','314-564-8978','WTinWA.com','3428 N. Shy Street','Walla Walla','Washington','Come kill time','3p-2a 7 days a week','image.png','micro');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('4', 'Foors Light', 'Cold as the Frokies', 'foors.png','4.2','Amber Ale');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('4', 'Pilsner Pause', 'Flavorful Beer that stays on your tongue', 'tongue.jpg','7.8','Juicy Pilsner');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('4', 'Timeout Stout', 'For when you need a TO', 'timeout.jpg','4.2','Stout');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('4', 'Ale Mary', 'For when you do not know what else to drink', 'ale.jpg','7.5','DIPA');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('4', 'Justin Time', 'Justin case you are Justin Time', 'time.img','4.3','Stout');

INSERT INTO brewery (brewery_id, brewer_id, name, phone_number, url, street, city, state, history, open_hours, image, brewery_type)
						  VALUES('5',1, 'Inconspicuous Outfit','894-564-8978','InconOutfit.com','1 N. Fly Street','Columbus','Georgia','Inspired by Jared Leto at the Morbius Premier','F-Sun 10p-11p','image.png','micro');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('5', 'I dont know her', 'Whatever your bartender feels like pouring', 'idkher.img','5.0','Random');

INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('5', 'Incognito', 'Low key I promise', 'incog.img','12','Session Lager');

INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('5', 'Late Night Coding Session', 'For when you really need it', 'java.img','4.0','Session Ale');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('5', 'Post Codelone', 'How did I get these face tats kinda beer', 'posty.img','6.8','Farmhouse Ale');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('5', 'Tapped Out', 'Uncreative but still tasty', 'tapped.jpg','5.5','Pale Ale');
INSERT INTO brewery (brewery_id,brewer_id, name, phone_number, url, street, city, state, history, open_hours, image, brewery_type)
						  VALUES('6',1, 'Citrus Sippin Columbus','614-564-8978','cscolumbusbeer.com','1515 Sly Street','Columbus','Ohio','A brewery for Coffee and Oranges.','12a-10p','image.png','brewpub');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('6', 'Fruity Pebs', 'Tastes like the milk after you eat the cereal', 'pebs.jpg','2.8','Milk Stout');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('6', 'Columbus Creamsickle', 'Orange Vanilla Lager that will chill you out', 'cc.jpg','4.5','CBD IPA');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('6', 'The Big Sip', 'The Main Attraction', 'big.jpg','5.9','Porter');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('6', 'OH', 'IO', 'bucks.jpg','10.0','Peanut Butter Stout');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('6', 'Orange Blossom Hefe', 'Sweet orange aftertaste', 'sweet.jpg','8.0','Hefeweizen');



SELECT *
FROM brewery;

COMMIT TRANSACTION;
