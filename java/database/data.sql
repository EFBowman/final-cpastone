BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO brewery
VALUES(1,1,'name','823498237948','beer.com','2384 main st','beertown','Ohio','history','9-5', 'beer.img', 'brewery');

INSERT INTO brewery (brewery_id, brewer_id, name, phone_number, url, street, city, state, history, open_hours, image, brewery_type)
						  VALUES('2',1, 'Morbin'' Brewin'' Memphis','554-564-8978','mobrewmemph.com','312 N. High Street','Memphis','Tennessee','We all knew what time it was.','3-10p','image.png','large');

INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('2', 'Java Sippin''', 'A coffee cream ale, delicious with brunch', 'beer.png','6.0','Coffee Cream Ale');

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
                  values ('3', 'What Time Is It?', 'Morbin'' time', 'morb.img','10','Stout');

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
                  values ('5', 'I don''t know her', 'Whatever your bartender feels like pouring', 'idkher.img','5.0','Random');

INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('5', 'Incognito', 'Low key I promise', 'incog.img','12','Session Lager');

INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('5', 'Late Night Coding Session', 'For when you really need it', 'java.img','4.0','Session Ale');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('5', 'Post Codelone', 'How did I get these face tats kinda beer', 'posty.img','6.8','Farmhouse Ale');
INSERT INTO beer (brewery_id, beer_name, beer_description, image, abv, beer_type)
                  values ('5', 'Tapped Out', 'Uncreative but still tasty', 'tapped.jpg','5.5','Pale Ale');
INSERT INTO brewery (brewery_id,brewer_id, name, phone_number, url, street, city, state, history, open_hours, image, brewery_type)
						  VALUES('6',1, 'Citrus Sippin'' Columbus','614-564-8978','cscolumbusbeer.com','1515 Sly Street','Columbus','Ohio','A brewery for Coffee and Oranges.','12a-10p','image.png','brewpub');
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



INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES ( 1, 1,'Java Sippin''', 'Morbin'' Brewin'' Memphis','I thought coffee beer sounded gross. What is next - eggs? Turns out it was pretty good', '4');

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES ( 1, 2,'Guarnera Guava', 'Morbin'' Brewin'' Memphis','This beer had me thinking morbius was a good movie? Like it was obsessed with it. Calm Down', '2');

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES ( 2, 2,'Guarnera Guava', 'Morbin'' Brewin'' Memphis','Beer was good but the brewery was having their grass cut the whole time I was there. This was a Thursday.', '4');

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES ( 1, 3,'Passion Fruit Pils', 'Morbin'' Brewin'' Memphis','Drinking this beer gave me the passion for passin''', '1');

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES ( 1, 4,'Memphis Ale', 'Morbin'' Brewin'' Memphis','Not good not great. Would drink again.', '3');

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES ( 1, 5,'Tiger IPA', 'Morbin'' Brewin'' Memphis','Big and hoppy. Aggressively tasty. Did the trick.', '4');

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES ( 1 , 6 , 'Casio Cream Ale', 'Casio Creations','Disappointing flavor profile. I recommend the What Time Is It? instead.', 2);

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES ( 1 , 7 , 'What Time Is It?', 'Casio Creations','What time is it? Time for you to try this beer. As amazing as Morbius himself.' ,5);

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES ( 1 , 8 , 'SLC Slammer', 'Casio Creations','Who in their right mind thought a salty beer was a good idea? This belongs in the lake not a mug.', 1);

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES ( 1 , 9 , 'Bood Ligh', 'Casio Creations','Surprisingly refreshing just ignore the spelling.' ,4);

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES ( 1 , 10 , 'Najt Lait', 'Casio Creations','Just buy Natty Light if you are that hung up on your glory days. Bad beer. Plain and simple.' ,1);

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES ( 2 , 10 , 'Najt Lait', 'Casio Creations','Bro. This took me back to the good ole days. For sure about this beer and about this life' ,5);

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES (1, 16, 'I don''t know her', 'Inconspicuous Outfit', 'Had a great time ordering the I don''t know her beer. It is a random drink, but so exciting!', 5);

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES (2, 16, 'I don''t know her', 'Inconspicuous Outfit', 'Cute concept, but I hated the experience. Didn''t know what to expect and was still disappointed.', 2);

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES (1, 17, 'Incognito', 'Inconspicuous Outfit', 'I wasn''t expecting this beer to be so good, but also so potent! Would recommend.', 4);

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES (1, 18, 'Late Night Coding Session', 'Inconspicuous Outfit', 'A great Session Ale to sip while doing your best late night work.', 4);

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES (1, 19, 'Post Codelone', 'Inconspicuous Outfit', 'Interesting Farmhouse Ale with a good flavor, but slightly unpleasant aroma.', 3);

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
    VALUES (1, 20, 'Tapped Out', 'Inconspicuous Outfit', 'A Pale Ale. Not much else to say, it''s just a beer.', 2);

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
VALUES (1,21,'Fruity Pebs', 'Citrus Sippin'' Columbus','Reminds me of the last drink of milk from a bowl of fruity pebbles.', 4 );

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
VALUES (1,22,'Columbus Creamsickle', 'Citrus Sippin'' Columbus','Sweet and Creamy', 5 );

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
VALUES (1,23,'The Big Sip', 'Citrus Sippin'' Columbus','It was okay , I prefer the Fruity Pebs', 4 );

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
VALUES (1,24,'OH', 'Citrus Sippin'' Columbus','Great beer, perfect aroma and taste.', 5 );

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
VALUES (1,25,'Orange Blossom Hefe', 'Citrus Sippin'' Columbus','Amazing flavour, with a orangey aftertaste, helps the vomit not taste so bad after a long night out.', 5 );

INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating)
VALUES (2,25,'Orange Blossom Hefe', 'Citrus Sippin'' Columbus','Terrible! Tastes like I gargled orange scented toilet bowl cleaner. And some drunk guy kept trying to show me his lame casio watch the whole time.', 2 );





SELECT *
FROM brewery;

COMMIT TRANSACTION;
