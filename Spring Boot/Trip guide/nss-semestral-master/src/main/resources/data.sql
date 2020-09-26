-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO PUBLIC.USER(ID, USERNAME, EMAIL, PASSWORD,FULL_NAME, ACTIVE) VALUES
(1, 'axelrbob', 'axelrbob@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Bobby Axelrod',  true),
(2, 'rhoadchu', 'rhoadchu@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Chuck Rhoades',  true),
(3, 'delegate' , 'delegate@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','delegate delegate', true),
(4, 'admin', 'admin@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','admin admin', true),
(5, 'utemiadi', 'utemiadi@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Adilbek Utemissov',  true),
(6, 'ismukmak', 'ismukmak@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Makhambet Ismukhambetov',  true),
(7, 'gritsdmi', 'gritsdmi@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Dmitrii Gritsai',  true),
(8, 'reiberob', 'reiberob@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Robert Reiberger',  true),
(9, 'hricidan', 'hricidan@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Daniel Hricisak',  true),
(10, 'boroddan', 'boroddan@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Daniel Borodac',  true),
(11, 'adilkdil', 'adilkdil@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Dilyara Adilkhan',  true),
(12, 'smikoane', 'smikoane@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Anett Smikova',  true),
(13, 'korsmich', 'korsmich@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Michael Kors',  true),
(14, 'varlaart', 'varlaart@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Artyom Varlamov',  true),
(15, 'kimroman', 'kimroman@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Roman Kim',  true),
(16, 'varlaily', 'varlaily@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Ilya Varlamov',  true),
(17, 'panarart', 'panarart@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Artemii Panarin',  true),
(18, 'davydand', 'davydand@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Andrey Davydov',  true),
(19, 'jobsstev', 'jobsstev@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Steve Jobs',  true),
(20, 'johnsbor', 'putinvla@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Boris Johnson',  true),
(21, 'zemanmil', 'zemanmil@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Milos Zeman',  true),
(22, 'trumpdon', 'trumpdon@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Donald Trump',  true),
(23, 'merkeang', 'merkeang@test.com' , '$2a$10$uILDk1sh5OFpXJRA6QhAkeWikwdtUomkBP1Zs4TDlZQE8Ft9qabLK','Angela Merkel',  true);


INSERT INTO PUBLIC.USERS_ROLES(USERID, ROLES) VALUES
(1, 'TOURIST'),
(2, 'TOURIST'),
(5, 'TOURIST'),
(6, 'TOURIST'),
(7, 'TOURIST'),
(8, 'TOURIST'),
(9, 'TOURIST'),
(10, 'TOURIST'),
(11, 'TOURIST'),
(12, 'TOURIST'),
(13, 'TOURIST'),
(14, 'TOURIST'),
(15, 'TOURIST'),
(16, 'TOURIST'),
(17, 'TOURIST'),
(18, 'TOURIST'),
(19, 'TOURIST'),
(20, 'TOURIST'),
(21, 'TOURIST'),
(22, 'TOURIST'),
(23, 'TOURIST'),
(3, 'DELEGATE'),
(4, 'ADMIN');
--
INSERT INTO DESTINATION(ID, COUNTRY, "NAME") VALUES
(1, 'Indonesia', 'Bali'),
(2, 'Spain', 'Marbella'),
(3, 'Turkey', 'Belek'),
(4, 'Egypt', 'Hurghada'),
(5, 'Germany', 'Berlin'),
(6, 'Greece', 'Kos'),
(7, 'Turkey', 'Alanya'),
(8, 'Spain', 'Ibiza');

INSERT INTO LOCAL_ATTRACTION(ID, NAME, DESCRIPTION, ADDRESS, PHOTO_URL, PRICE, URL, DESTINATION_ID) VALUES
(1, 'Pura Tanah Lot', 'About 20 kilometers northwest of Kuta, Pura Tanah Lot ("Pura" means temple in Balinese) is one of Bali''s most iconic temples. Its spectacular seaside setting, on a rocky islet surrounded by crashing waves wows all who visit.', 'Beraban, Kediri, Tabanan Regency, Bali', 'https://www.planetware.com/photos-large/INA/bali-pura-tanah-lot-tourists.jpg', 'Free', null, 1),
(2, 'Ubud Monkey Forest', 'Only 10 minutes'' walk south of the town center in Ubud, Bali, the Monkey Forest, also known as the Sacred Monkey Forest Sanctuary, is one of the top things to do in Ubud.', 'Jalan Monkey Forest, Padangtegal, Ubud, Gianyar, Bali', 'https://www.planetware.com/photos-large/INA/bali-ubud-monkey-forest.jpg', 'Adult IDR 80,000; Child IDR 60,000', null, 1),
(3, 'Plaza de los Naranjos', 'In Marbella''s charming Old Town (Casco Antiguo), the Plaza de los Naranjos was built after the Christian Reconquest in the area that was a center of urban life.', 'Plaza de los Naranjos, Marbella,', 'https://thumbnails.trvl-media.com/--PBEBeyiCDyxC9QJ792t5EsdTQ=/773x530/smart/filters:quality(60)/images.trvl-media.com/hotels/31000000/30380000/30376900/30376889/9e15cfcd_z.jpg', 'Free', null, 2),
(4, 'Avenida del Mar and the Dali Statues', 'Art-lovers will want to make time for a stroll down the Avenida del Mar, a lovely pedestrian way that stretches from the Paseo Maritimo to Parque Alameda.', 'Av. del Mar, Avenida, 16, Marbella', 'https://www.planetware.com/photos-large/E/spain-marbella-avenue-del-mar.jpg', 'Free', null, 2),
(5, 'The Land of Legends Theme Park', 'Excitement and adventure awaits you at The Land of Legends Theme Park, a theme park packed with thrilling rides, roller coasters, animal encounters, and spectacular shows.', 'Kadriye Mahallesi Atatürk Caddesi No:1, D:No 515, Serik/Antalya', 'https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/06/67/bd/f8.jpg', 'From 60$', 'https://www.landoflegendsticket.com/en/', 3),
(6, 'Giftun Islands', 'The Giftun Islands are one of Hurghada''s most popular boat excursions, with prime swaths of white sand to soak up the rays, and snorkeling opportunities galore on offer.', 'Giftun Islands, Hurghada', 'https://www.planetware.com/photos-large/EGY/egypt-hurghada-giftun-island.jpg', 'Free', null, 4),
(7, 'Hurghada Marina', 'Hurghada Marina is a rather swish and modern addition to the central district of Sigala and the town''s major dining destination.', 'Hurghada Marina Promenade, Sigala, Hurghada', 'https://www.planetware.com/photos-large/EGY/egypt-hurghada-marina.jpg', 'Free', null, 4),
(8, 'The Brandenburg Gate', 'Berlin''s most famous historic landmark is the Brandenburg Gate (Brandenburger Tor), once a symbol of a divided nation and now a symbol of unity and peace.', 'Pariser Platz, 10117, Berlin', 'https://www.planetware.com/photos-large/D/east-berlin-former-0.jpg', 'Free', null, 5),
(9, 'Berlin Wall Memorial', 'The Berlin Wall originated in 1961 when East Germany sealed off that half of the city to prevent citizens from fleeing to West Germany.', 'Bernauer Straße 111, 13355 Berlin', 'https://www.planetware.com/photos-large/D/berlin-wall.jpg', 'Free', null, 5),
(10, 'German Historical Museum', 'Established to mark Berlin''s 750th anniversary in 1987, the German Historical Museum is a must-visit for those interested in learning more about the city''s remarkably rich history.', 'Unter den Linden 2, 10117 Berlin', 'https://www.planetware.com/wpimages/2019/12/germany-berlin-top-attractions-german-historical-museum.jpg', 'Regular € 8, free up to 18 years', 'https://www.dhm.de/en/ausstellungen/hannah-arendt-and-the-twentieth-century/ticket.html#/', 5),
(11, 'The Rebuilt Reichstag', 'The Reichstag (Reichstagsgebäude) was originally completed in 1894 where the Neo-Renaissance palace served as the home of the German Empire''s Imperial Diet until it burned in 1933.', 'Platz der Republik 1, 11011, Berlin', 'https://www.planetware.com/photos-large/D/reichstag-building.jpg', 'Free with registration', 'https://visite.bundestag.de/BAPWeb/pages/createBookingRequest/viewBasicInformation.jsf?lang=en', 5),
(12, 'Jewish Museum Berlin', 'Designed by architect Daniel Libeskind, the Jewish Museum Berlin''s (Jüdisches Museum Berlin''s) distinctive zinc-paneled exterior makes it one of Berlin''s most striking landmarks.', 'Lindenstraße 9-14, 10969 Berlin', 'https://www.planetware.com/photos-large/D/germany-berlin-jewish-museum-berlin.jpg', 'Regular 8€', 'https://shop.jmberlin.de/#/tickets', 5),
(13, 'German Museum of Technology', 'The must-see German Museum of Technology (Deutsches Technikmuseum Berlin) was established in 1983 to showcase and celebrate Germany''s industrial and technological prowess.', 'Trebbiner Straße 9, D-10963 Berlin-Kreuzberg', 'https://www.planetware.com/wpimages/2019/12/germany-berlin-top-attractions-german-museum-technology.jpg', 'Regular 8€', null, 5);

INSERT INTO HOTEL(ID, ADDRESS, EMAIL, NAME, PHONE_NUMBER, STARS, WEB, DESTINATION_ID, MEAL_SERVICE_INFO) VALUES
(1, 'Jl. Munduk Catu No.8, 80361 Canggu', 'email@gmail.com', 'Eastin Ashta Resort Canggu', '111 111 111', 5, 'https://www.eastinhotelsresidences.com/eastincanggu/', 1, 'No'),
(2, 'Jl. Pemutih Bali , 80364 Uluwatu', 'email@gmail.com', 'Radisson Blu Bali Uluwatu', '111 111 111', 5, 'https://www.radissonballi.com/blubaliuluwatu/', 1, 'Breakfast 7:00-9:00'),
(3, 'Alexanderplatz 7, Mitte', 'email1@gmail.com', 'Hotel Park Inn by Radisson Berlin Alexanderplatz ', '222 222 222', 4, 'www.hotel2.com', 5,'Breakfast 7:00-9:00'),
(4, 'Stresemannstr. 49, Friedrichshain-Kreuzberg', 'email2@gmail.com', 'Holiday Inn Express Berlin City Centre', '333 333 333', 4, 'www.hotel3.com', 5,'Breakfast 7:00-9:00'),
(5, 'Karl-Liebknecht-Strasse 32, Mitte', 'email2@gmail.com', 'H4 Hotel Berlin Alexanderplatz', '333 333 333', 4, 'www.hotel3.com', 5,'Breakfast: 7:00-9:00'),
(6, 'Sahil Yolu No:155, 07400 Mahmutlar/Alanya/Antalya', 'email3@gmail.com', 'Sunfire Beach', '444 444 444', 4, 'www.hotel4.com', 7,'AI [Breakfast: 7:00-9:00, Lunch: 12:00-14:00, Dinner: 18:00-20:00]'),
(7, 'Payallar, Caddesi, 07475 Alanya', 'email3@gmail.com', 'The Garden Beach', '444 444 444', 5, 'www.hotel4.com', 7,'AI [Breakfast: 7:00-9:00, Lunch: 12:00-14:00, Dinner: 18:00-20:00, Free snacks, drinks and local alcoholic drinks all day]'),
(8, 'Seraphan Mevkii, Konaklı Mah. Alanya', 'email3@gmail.com', 'Hedef Resort', '444 444 444', 5, 'www.hotel4.com', 3, 'UAI [Breakfast: 7:00-9:00, Lunch: 12:00-14:00, Dinner: 18:00-20:00, Free mini-bar, all snacks and drinks all day]'),
(9, 'Bogazkent, 07506 Serik/Antalya', 'email3@gmail.com', 'Crystal Waterworld', '444 444 444', 5, 'www.hotel4.com', 3,'UAI [Breakfast: 7:00-9:00, Lunch: 12:00-14:00, Dinner: 18:00-20:00, Free mini-bar, all snacks and drinks all day]'),
(10, 'Iskele mevkii, 07506 Serik/Antalya', 'email3@gmail.com', 'Belconti Resort', '+90 242 212 15 84', 5, 'www.hotel4.com', 3,'UAI [Breakfast: 7:00-9:00, Lunch: 12:00-14:00, Dinner: 18:00-20:00, Free mini-bar, all snacks and drinks all day]'),
(11, 'Bogazkent, 07506 Serik/Antalya', 'email3@gmail.com', 'Sherwood Dreams', '+90 242 731 09 99', 5, 'www.hotel4.com', 3,'UAI [Breakfast: 7:00-9:00, Lunch: 12:00-14:00, Dinner: 18:00-20:00, Free mini-bar, all snacks and drinks all day]'),
(12, 'Belek Turizm Merkezi, 07506', 'email3@gmail.com', 'Aquaworld Belek by MP', '+90 242 725 42 10', 5, 'www.hotel4.com', 7,'AI [Breakfast: 7:00-9:00, Lunch: 12:00-14:00, Dinner: 18:00-20:00, Free snacks, drinks and local alcoholic drinks all day]'),
(13, 'Sheraton Road, Sakkala Area، Red Sea Governorate 84511', 'email3@gmail.com', 'Minamark Beach Resort', '+20 122 327 7496', 4, 'www.hotel4.com', 4,'HB [Breakfast: 7:00-9:00, Dinner: 18:00-20:00]'),
(14, 'Unnamed Road,, Hurghada, Red Sea Governorate', 'email3@gmail.com', 'Golden 5 Emerald', '+974 5566 9479', 5, 'www.hotel4.com', 4,'AI [Breakfast: 7:00-9:00, Lunch: 12:00-14:00, Dinner: 18:00-20:00, Free snacks, drinks and local alcoholic drinks all day]'),
(15, 'Papaioannou 1, Ierapetra 722 00', 'email3@gmail.com', 'Astron Hotel', '+30 2842 025114', 4, 'www.hotel4.com', 6,'Breakfast 7:00-9:00'),
(16, 'Km 189, Carretera Nacional 340, 29604 Marbella, Málaga', 'email3@gmail.com', 'Marbella Playa', '+34 952 83 13 45', 4, 'www.hotel4.com', 2,'Breakfast 7:00-9:00'),
(17, 'Urbanización Coral Beach Nacional 340 Km.176, 29602 Marbella, Málaga', 'email3@gmail.com', 'Occidental Coral Beach', '+34 952 82 45 00', 4, 'www.hotel4.com', 2,'No'),
(18, 'Via Hotel Don Pepe s/n, Calle José Meliá, 29602 Marbella, Málaga', 'email3@gmail.com', 'Gran Melia Don Pepe', '+34 911 36 76 04', 4, 'www.hotel4.com', 2,'Paid restaurant, bar and room mini-bar');


INSERT INTO TOUR(ID, START, END,  TITLE,  DELEGATE_ID, HOTEL_ID, BACK_TRANSFER_INFO) VALUES
(1,  '2020-05-1', '2020-05-7',  'Tour in Bali with ideally located Canggu Beach accommodation', 3, 1, '19:00 taxi to airport'),
(2,  '2020-05-8', '2020-05-15',  'Tour in Bali with ideally located Canggu Beach accommodation', 3, 1, '19:00 taxi to airport'),
(3,  '2020-05-16', '2020-05-23',  'Tour in Bali with ideally located Canggu Beach accommodation', 3, 1, '19:00 taxi to airport'),
(4,  '2020-04-6', '2020-04-13',  'Tour in Uluwatu, Bali with accommodation in seaside resort hotel Radisson', 3, 2, '19:00 bus to airport'),
(5,  '2020-04-14', '2020-04-21',  'Tour in Uluwatu, Bali with accommodation in seaside resort hotel Radisson', 3, 2, '19:00 taxi to airport'),
(6,  '2020-04-27', '2020-05-5',  'Tour in Uluwatu, Bali with accommodation in seaside resort hotel Radisson', 3, 2, '19:00 taxi to airport'),
(7,  '2020-05-22', '2020-05-25', '3-day tour to Berlin with accommodation near Alexanderplatz', 3, 3, '19:00 bus to airport'),
(8,  '2020-05-26', '2020-05-29', '3-day tour to Berlin with accommodation near Alexanderplatz', 3, 3, '19:00 bus to airport'),
(9,  '2020-05-26', '2020-05-29', '3-day tour to Berlin with accommodation in city centre', 3, 4, '19:00 bus to airport'),
(10, '2020-05-15', '2020-06-22',  'One week tour to Belek in hotel with water big aquapark ',3, 12, '19:00 bus to airport'),
(11, '2020-05-26', '2020-06-3',  'One week tour to Belek in hotel with water big aquapark ',3, 12, '19:00 bus to airport'),
(12, '2020-05-26', '2020-06-3',  'Tour in Belek',3, 11, '19:00 taxi'),
(13, '2020-05-26', '2020-06-3',  'Tour in Belek',3, 10, '19:00 taxi'),
(14, '2020-04-15', '2020-04-23',  'Tour in Belek',3, 11, '19:00 bus');

INSERT INTO TOUR_USERS VALUES
(1,1), (1,2), (1,21), (7,22), (7,5), (7,6), (11, 7), (11, 9), (11, 10), (11, 11), (11, 12), (11, 13), (11, 14), (2, 15), (2, 16), (2, 17), (8, 18), (9, 19), (8, 20), (8,23), (5, 6), (5, 22);

INSERT INTO EXCURSION (ID, START, END, DESCRIPTION, TITLE, PRICE, MEETING_LOCATION, TOUR_ID) VALUES
(1,'2020-05-4T13:30:00','2020-05-4T20:30:00','Get the best views in Bali with an early-morning hike up Mount Batur volcano with breakfast included. An unforgettable sunrise awaits you at the top.','Sunrise Mount Batur Hike with Breakfast', 100, 'Hotel pickup', 1),
(2, '2020-05-5T13:30:00','2020-05-5T20:30:00','Home to the colorfull a part of Bali most travelers never see.','Exploring The Most Scenic Spots', 200, 'Hotel pickup', 1),
(3, '2020-05-6T13:30:00','2020-05-7T20:30:00','Take a day tour around the Ubud area to check out some of Bali''s most popular attractions. Stop at Tegalalang Rice Terrace, Tegenungan Waterfall, Sacred Monkey Forest Sanctuar.','Ubud Private Tour - Best of Ubud', 40, 'Hotel pickup', 1),

(4,'2020-05-10T13:30:00','2020-05-10T20:30:00','Get the best views in Bali with an early-morning hike up Mount Batur volcano with breakfast included. An unforgettable sunrise awaits you at the top.','Sunrise Mount Batur Hike with Breakfast', 100, 'Hotel pickup', 2),
(5, '2020-05-11T13:30:00','2020-05-11T20:30:00','Home to the colorfull a part of Bali most travelers never see.','Exploring The Most Scenic Spots', 200, 'Hotel pickup', 2),
(6, '2020-05-12T13:30:00','2020-05-12T20:30:00','Take a day tour around the Ubud area to check out some of Bali''s most popular attractions. Stop at Tegalalang Rice Terrace, Tegenungan Waterfall, Sacred Monkey Forest Sanctuar.','Ubud Private Tour - Best of Ubud', 40, 'Hotel pickup', 2),

(7,'2020-05-18T13:30:00','2020-05-18T20:30:00','Get the best views in Bali with an early-morning hike up Mount Batur volcano with breakfast included. An unforgettable sunrise awaits you at the top.','Sunrise Mount Batur Hike with Breakfast', 100, 'Hotel pickup', 3),
(8, '2020-05-19T13:30:00','2020-05-19T20:30:00','Home to the colorfull a part of Bali most travelers never see.','Exploring The Most Scenic Spots', 200, 'Hotel pickup', 3),
(9, '2020-05-18T13:30:00','2020-05-20T20:30:00','Take a day tour around the Ubud area to check out some of Bali''s most popular attractions. Stop at Tegalalang Rice Terrace, Tegenungan Waterfall, Sacred Monkey Forest Sanctuar.','Ubud Private Tour - Best of Ubud', 40, 'Hotel pickup', 3),

(10,'2020-04-8T13:30:00','2020-04-8T20:30:00','Get the best views in Bali with an early-morning hike up Mount Batur volcano with breakfast included. An unforgettable sunrise awaits you at the top.','Sunrise Mount Batur Hike with Breakfast', 100, 'Hotel pickup', 4),
(11, '2020-04-9T13:30:00','2020-04-9T20:30:00','Home to the colorfull a part of Bali most travelers never see.','Exploring The Most Scenic Spots', 200, 'Hotel pickup', 4),
(12, '2020-04-10T13:30:00','2020-04-10T20:30:00','Take a day tour around the Ubud area to check out some of Bali''s most popular attractions. Stop at Tegalalang Rice Terrace, Tegenungan Waterfall, Sacred Monkey Forest Sanctuar.','Ubud Private Tour - Best of Ubud', 40, 'Hotel pickup', 4),

(13,'2020-04-17T13:30:00','2020-04-17T20:30:00','Get the best views in Bali with an early-morning hike up Mount Batur volcano with breakfast included. An unforgettable sunrise awaits you at the top.','Sunrise Mount Batur Hike with Breakfast', 100, 'Hotel pickup', 5),
(14, '2020-04-15T13:30:00','2020-04-15T20:30:00','Home to the colorfull a part of Bali most travelers never see.','Exploring The Most Scenic Spots', 200, 'Hotel pickup', 5),
(15, '2020-04-16T13:30:00','2020-04-16T20:30:00','Take a day tour around the Ubud area to check out some of Bali''s most popular attractions. Stop at Tegalalang Rice Terrace, Tegenungan Waterfall, Sacred Monkey Forest Sanctuar.','Ubud Private Tour - Best of Ubud', 40, 'Hotel pickup', 5),

(16,'2020-04-28T13:30:00','2020-04-28T20:30:00','Get the best views in Bali with an early-morning hike up Mount Batur volcano with breakfast included. An unforgettable sunrise awaits you at the top.','Sunrise Mount Batur Hike with Breakfast', 100, 'Hotel pickup', 6),
(17, '2020-04-29T13:30:00','2020-04-29T20:30:00','Home to the colorfull a part of Bali most travelers never see.','Exploring The Most Scenic Spots', 200, 'Hotel pickup', 6),
(18, '2020-04-30T13:30:00','2020-04-30T20:30:00','Take a day tour around the Ubud area to check out some of Bali''s most popular attractions. Stop at Tegalalang Rice Terrace, Tegenungan Waterfall, Sacred Monkey Forest Sanctuar.','Ubud Private Tour - Best of Ubud', 40, 'Hotel pickup', 6),

(19, '2020-05-23T13:30:00','2020-05-23T14:30:00','Get an overview of Berlin and its history on this river cruise through the city.','Berlin 1-Hour City Cruise: History and Main Attractions', 20, 'Karl-Liebknecht-Str. 1a, Berlin', 7),
(20, '2020-05-23T16:30:00','2020-05-23T17:30:00','Get an insider’s look at Berlin, the capital and cultural centerpiece of Germany, on this guided walking tour.','Explore Berlin: Top Attractions Walking Tour', 17, 'Hardenbergplatz, Berlin', 7),
(21, '2020-05-24T13:30:00','2020-05-24T20:30:00','Head to Germany’s capital and visit some of its key landmarks such as Charlottenburg Palace, the Brandenburg Gate, the Berlin Wall, Checkpoint Charlie and more.','All-in-One Berlin Shore Excursion from Warnemünde and Rostock Port', 120, 'Traveler pickup', 7),

(22, '2020-05-27T13:30:00','2020-05-27T14:30:00','Get an overview of Berlin and its history on this river cruise through the city.','Berlin 1-Hour City Cruise: History and Main Attractions', 20, 'Karl-Liebknecht-Str. 1a, Berlin', 8),
(23, '2020-05-27T16:30:00','2020-05-27T17:30:00','Get an insider’s look at Berlin, the capital and cultural centerpiece of Germany, on this guided walking tour.','Explore Berlin: Top Attractions Walking Tour', 17, 'Hardenbergplatz, Berlin', 8),
(24, '2020-05-28T13:30:00','2020-05-28T20:30:00','Head to Germany’s capital and visit some of its key landmarks such as Charlottenburg Palace, the Brandenburg Gate, the Berlin Wall, Checkpoint Charlie and more.','All-in-One Berlin Shore Excursion from Warnemünde and Rostock Port', 120, 'Traveler pickup', 8),

(25, '2020-05-27T13:30:00','2020-05-27T14:30:00','Get an overview of Berlin and its history on this river cruise through the city.','Berlin 1-Hour City Cruise: History and Main Attractions', 20, 'Karl-Liebknecht-Str. 1a, Berlin', 9),
(26, '2020-05-27T16:30:00','2020-05-27T17:30:00','Get an insider’s look at Berlin, the capital and cultural centerpiece of Germany, on this guided walking tour.','Explore Berlin: Top Attractions Walking Tour', 17, 'Hardenbergplatz, Berlin', 9),
(27, '2020-05-28T13:30:00','2020-05-28T20:30:00','Head to Germany’s capital and visit some of its key landmarks such as Charlottenburg Palace, the Brandenburg Gate, the Berlin Wall, Checkpoint Charlie and more.','All-in-One Berlin Shore Excursion from Warnemünde and Rostock Port', 120, 'Traveler pickup', 9);

