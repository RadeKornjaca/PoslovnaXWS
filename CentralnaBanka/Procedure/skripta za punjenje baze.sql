INSERT INTO `poslovnaxws`.`drzava` (`id_drzave`, `naziv_drzave`, `sifra_drzave`) VALUES ('1', 'Srbija', 'SRB');
INSERT INTO `poslovnaxws`.`naseljenomesto` (`id_mesta`, `naziv_mesta`, `sifra_mesta`, `id_drzave`) VALUES ('1', 'Neko mesto', '1', '1');
INSERT INTO `poslovnaxws`.`banka` (`banka_id`, `naziv`, `sifra`, `swift_kod`) VALUES ('1', 'BankaDuznik', '123', 'BANKAS12');
INSERT INTO `poslovnaxws`.`banka` (`banka_id`, `naziv`, `sifra`, `swift_kod`) VALUES ('2', 'BankaPoverilac', '124', 'BANKAS34');
INSERT INTO `poslovnaxws`.`racunbanke` (`id_racuna`, `aktivan`, `broj_racuna`, `datum_otvaranja`, `likvidan`, `stanje_racuna`, `banka_id`) VALUES ('1', 1, '111-1111111111111-11', '2015-06-17', 1, '1000000', '1');
INSERT INTO `poslovnaxws`.`racunbanke` (`id_racuna`, `aktivan`, `broj_racuna`, `datum_otvaranja`, `likvidan`, `stanje_racuna`, `banka_id`) VALUES ('2', 1, '222-2222222222222-22', '2015-06-17', 1, '0', '2');