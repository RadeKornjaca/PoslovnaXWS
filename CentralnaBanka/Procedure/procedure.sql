CREATE DEFINER=`Poslovnaxws`@`localhost` PROCEDURE `getForClearing`(/*IN i int*/)
BEGIN
	select * /*into tabela*/ from nalog where nalog.hitno = 0 and nalog.iznos<250000 and nalog.status = 1;
    UPDATE `poslovnaxws`.`nalog` SET `status`='0' WHERE nalog.status = 1 and nalog.iznos <250000 and nalog.hitno = 0;
    /*return tabela;*/
END