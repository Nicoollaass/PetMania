-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.12-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para pet_mania
CREATE DATABASE IF NOT EXISTS `pet_mania` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pet_mania`;


-- Copiando estrutura para tabela pet_mania.animal
CREATE TABLE IF NOT EXISTS `animal` (
  `ID_ANIMAL` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE` int(11) NOT NULL,
  `NOME` varchar(255) NOT NULL,
  `COR` varchar(45) NOT NULL,
  `IDADE` int(11) NOT NULL,
  `ID_TIPO_ANIMAL` int(11) NOT NULL,
  `DATA_INCLUSAO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ID_PORTE` int(11) NOT NULL,
  `ID_RACA` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID_ANIMAL`),
  KEY `ID_CLIENTE_idx` (`ID_CLIENTE`),
  KEY `ID_TIPO_ANIMAL_idx` (`ID_TIPO_ANIMAL`),
  KEY `ID_RACA_idx` (`ID_RACA`),
  KEY `ID_PORTE_idx` (`ID_PORTE`),
  CONSTRAINT `ID_CLIENTE` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_PORTE` FOREIGN KEY (`ID_PORTE`) REFERENCES `porte` (`ID_PORTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_RACA` FOREIGN KEY (`ID_RACA`) REFERENCES `raca` (`ID_RACA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_TIPO_ANIMAL` FOREIGN KEY (`ID_TIPO_ANIMAL`) REFERENCES `tipo_animal` (`ID_TIPO_ANIMAL`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.animal: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` (`ID_ANIMAL`, `ID_CLIENTE`, `NOME`, `COR`, `IDADE`, `ID_TIPO_ANIMAL`, `DATA_INCLUSAO`, `ID_PORTE`, `ID_RACA`, `STATUS`) VALUES
	(1, 11, 'Tody', 'Preto', 2, 1, '2015-11-09 22:14:16', 1, 2, 1),
	(2, 12, 'Pericles', 'Branco', 12, 2, '2015-11-12 03:33:17', 1, 4, 1),
	(3, 11, 'Fiel', 'preto', 13, 3, '2015-11-12 03:44:10', 1, 2, 1);
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `ID_CATEGORIA` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(75) NOT NULL,
  PRIMARY KEY (`ID_CATEGORIA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.categoria: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`ID_CATEGORIA`, `DESCRICAO`) VALUES
	(1, 'Ração'),
	(2, 'Brinquedos'),
	(3, 'Higiene');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.categoria_servico
CREATE TABLE IF NOT EXISTS `categoria_servico` (
  `ID_CATEGORIA_SERVICO` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_CATEGORIA_SERVICO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.categoria_servico: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria_servico` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) NOT NULL,
  `IDADE` int(11) NOT NULL,
  `DATA_NASCIMENTO` date NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `CPF` varchar(45) NOT NULL,
  `SEXO` char(1) NOT NULL,
  `TELEFONE` varchar(45) NOT NULL,
  `DATA_INCLUSAO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.cliente: ~13 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`ID_CLIENTE`, `NOME`, `IDADE`, `DATA_NASCIMENTO`, `EMAIL`, `CPF`, `SEXO`, `TELEFONE`, `DATA_INCLUSAO`, `status`) VALUES
	(1, 'nicolas silva dos santos', 20, '1995-11-05', 'nicolas@vitrio.com.br', '428.731.418-24', 'M', '56227332', '2015-11-05 20:42:24', 0),
	(2, 'Herick mello teste', 20, '1980-07-11', 'herick_mello@hotmail.com', '123456789', 'M', '12345678', '2015-11-06 00:26:56', 0),
	(3, 'Nicolas Silva dos santos', 20, '1995-06-13', 'nicolas@vitrio.com.br', '428.731.418.24', 'M', '56227332', '2015-11-06 20:21:59', 0),
	(4, 'Felipe magalhÃ£es', 20, '1995-05-11', 'email@email.com', '56227332', 'F', '56227332', '2015-11-06 00:49:38', 0),
	(5, 'Herick mello', 20, '1980-07-11', 'herick_mello@hotmail.com', '123456789', 'M', '12345678', '2015-11-06 20:21:54', 0),
	(6, 'Herick mello', 20, '1980-07-11', 'herick_mello@hotmail.com', '123456789', 'M', '12345678', '2015-11-06 00:29:33', 0),
	(7, 'Pedro moreir', 20, '1994-11-05', 'email@email.com', '123456789', 'M', '123456789', '2015-11-06 20:22:01', 0),
	(8, 'Jonatas', 20, '2001-11-05', 'email@email.com', '123456789', 'M', '2345678', '2015-11-06 20:21:57', 0),
	(9, 'Herick', 20, '1980-11-05', 'email@email.com', '23456789', 'M', '12345678', '2015-11-06 00:29:38', 0),
	(10, 'JoÃ£o paulo', 20, '1995-11-05', 'email@email.com', '23456789', 'M', '123456789', '2015-11-06 00:12:34', 0),
	(11, 'Herick mello', 20, '1981-02-05', 'email@email.com', '37037035820', 'M', '123456789', '2015-11-09 22:12:45', 1),
	(12, 'Nicolas Silva', 20, '2015-11-18', 'dsadas@dhasuhduas.com', '23456789', 'M', '1223333', '2015-11-09 22:12:59', 1),
	(13, 'asdfasdf', 20, '2015-11-17', 'email@email.com', '2341231234123', 'M', '12341231234', '2015-11-12 21:12:33', 1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.estoque_produto
CREATE TABLE IF NOT EXISTS `estoque_produto` (
  `ID_ESTOQUE_PROD` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PRODUTO_ESTOQUE` int(11) NOT NULL,
  `QUANTIDADE` int(11) NOT NULL,
  PRIMARY KEY (`ID_ESTOQUE_PROD`),
  KEY `ID_PRODUTO_idx` (`ID_PRODUTO_ESTOQUE`),
  CONSTRAINT `ID_PRODUTO_ESTOQUE` FOREIGN KEY (`ID_PRODUTO_ESTOQUE`) REFERENCES `produto` (`ID_PRODUTO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.estoque_produto: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `estoque_produto` DISABLE KEYS */;
INSERT INTO `estoque_produto` (`ID_ESTOQUE_PROD`, `ID_PRODUTO_ESTOQUE`, `QUANTIDADE`) VALUES
	(1, 1, 8),
	(2, 2, 4);
/*!40000 ALTER TABLE `estoque_produto` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `ID_FUNCIONARIO` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) NOT NULL,
  `ID_TIPO_FUNIONARIO` int(11) NOT NULL,
  `DATA_NASCIMENTO` date NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `CPF` varchar(45) NOT NULL,
  `DATA_INCLUSAO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_FUNCIONARIO`),
  KEY `ID_TIPO_FUNCIONARIO_idx` (`ID_TIPO_FUNIONARIO`),
  CONSTRAINT `ID_TIPO_FUNCIONARIO` FOREIGN KEY (`ID_TIPO_FUNIONARIO`) REFERENCES `tipo_funcionario` (`ID_TIPO_FUNCIONARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.funcionario: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`ID_FUNCIONARIO`, `NOME`, `ID_TIPO_FUNIONARIO`, `DATA_NASCIMENTO`, `EMAIL`, `CPF`, `DATA_INCLUSAO`) VALUES
	(1, 'Caio Stalberge', 3, '1990-12-13', 'email@email.com', '435.731.418-24', '2015-11-21 10:30:17');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.item_venda_produto
CREATE TABLE IF NOT EXISTS `item_venda_produto` (
  `ID_ITEM_PRODUTO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PRODUTO` int(11) NOT NULL,
  `QUANTIDADE` int(11) NOT NULL,
  `ID_VENDA_PROD` int(11) NOT NULL,
  PRIMARY KEY (`ID_ITEM_PRODUTO`),
  KEY `ID_PRODUTO_idx` (`ID_PRODUTO`),
  KEY `ID_VENDA_PRODUTO_idx` (`ID_VENDA_PROD`),
  CONSTRAINT `ID_VENDA_PRODUTO` FOREIGN KEY (`ID_VENDA_PROD`) REFERENCES `venda_produto` (`ID_VENDA_PRODUTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_PRODUTO` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produto` (`ID_PRODUTO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.item_venda_produto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `item_venda_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_venda_produto` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.item_venda_servico
CREATE TABLE IF NOT EXISTS `item_venda_servico` (
  `ID_ITEM_SERVICO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_VENDA_SERVICO` int(11) NOT NULL,
  `ID_SERVICO` int(11) NOT NULL,
  `QUANTIDADE` int(11) NOT NULL,
  `PRECO_TOTAL` decimal(11,2) NOT NULL,
  PRIMARY KEY (`ID_ITEM_SERVICO`),
  KEY `ID_VENDA_SERVICO_idx` (`ID_VENDA_SERVICO`),
  KEY `ID_SERVICO_idx` (`ID_SERVICO`),
  CONSTRAINT `ID_SERVICO` FOREIGN KEY (`ID_SERVICO`) REFERENCES `servico` (`ID_SERVICO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_VENDA_SERVICO` FOREIGN KEY (`ID_VENDA_SERVICO`) REFERENCES `venda_servico` (`ID_VENDA_SERVICO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.item_venda_servico: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `item_venda_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_venda_servico` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.log_siada_produto
CREATE TABLE IF NOT EXISTS `log_siada_produto` (
  `ID_LOG_SAIDA_PRODUTO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_VENDA_PRODUTO` int(11) NOT NULL,
  `DATA_ALTERACAO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_LOG_SAIDA_PRODUTO`),
  KEY `ID_VENDA_PRODUTO_LOG_idx` (`ID_VENDA_PRODUTO`),
  CONSTRAINT `ID_VENDA_PRODUTO_LOG` FOREIGN KEY (`ID_VENDA_PRODUTO`) REFERENCES `venda_produto` (`ID_VENDA_PRODUTO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.log_siada_produto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `log_siada_produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_siada_produto` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.marca
CREATE TABLE IF NOT EXISTS `marca` (
  `ID_MARCA` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(75) NOT NULL,
  PRIMARY KEY (`ID_MARCA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.marca: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` (`ID_MARCA`, `DESCRICAO`) VALUES
	(1, 'Baw Waw'),
	(2, 'Champ'),
	(3, 'Dog Chow ');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.porte
CREATE TABLE IF NOT EXISTS `porte` (
  `ID_PORTE` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(75) NOT NULL,
  PRIMARY KEY (`ID_PORTE`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.porte: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `porte` DISABLE KEYS */;
INSERT INTO `porte` (`ID_PORTE`, `DESCRICAO`) VALUES
	(1, 'Pequeno'),
	(2, 'Médio'),
	(3, 'Grande');
/*!40000 ALTER TABLE `porte` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.produto
CREATE TABLE IF NOT EXISTS `produto` (
  `ID_PRODUTO` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  `DESCRICAO` varchar(255) NOT NULL,
  `DATA_ENTRADA` datetime NOT NULL,
  `DATA_INCLUSAO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `PRECO` decimal(11,2) NOT NULL,
  `ID_CATEGORIA` int(11) NOT NULL,
  `ID_MARCA` int(11) NOT NULL,
  PRIMARY KEY (`ID_PRODUTO`),
  KEY `ID_MARCA_idx` (`ID_MARCA`),
  KEY `ID_CATEGORIA_idx` (`ID_CATEGORIA`),
  CONSTRAINT `ID_CATEGORIA` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria` (`ID_CATEGORIA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_MARCA` FOREIGN KEY (`ID_MARCA`) REFERENCES `marca` (`ID_MARCA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.produto: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` (`ID_PRODUTO`, `NOME`, `DESCRICAO`, `DATA_ENTRADA`, `DATA_INCLUSAO`, `PRECO`, `ID_CATEGORIA`, `ID_MARCA`) VALUES
	(1, 'Ração', 'Ração Golden Mega Cães Adultos Frango Premier', '2015-11-19 01:08:03', '2015-11-19 04:09:08', 113.90, 1, 1),
	(2, 'Rcção', 'Ração para bebes ', '2015-11-19 01:08:03', '2015-11-19 01:08:03', 90.00, 1, 1);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.produto_pertencente
CREATE TABLE IF NOT EXISTS `produto_pertencente` (
  `ID_PROD_PERTENCENTE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_TIPO_ANIMAL` int(11) NOT NULL,
  `ID_PRODUTO` int(11) NOT NULL,
  PRIMARY KEY (`ID_PROD_PERTENCENTE`),
  KEY `ID_TIPO_ANIMAL_idx` (`ID_TIPO_ANIMAL`),
  KEY `ID_PRODUTO_idx` (`ID_PRODUTO`),
  CONSTRAINT `ID_PRODUTO2` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produto` (`ID_PRODUTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_TIPO_ANIMAL2` FOREIGN KEY (`ID_TIPO_ANIMAL`) REFERENCES `tipo_animal` (`ID_TIPO_ANIMAL`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.produto_pertencente: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `produto_pertencente` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto_pertencente` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.raca
CREATE TABLE IF NOT EXISTS `raca` (
  `ID_RACA` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(75) NOT NULL,
  `ID_TIPO_ANIMAL` int(11) NOT NULL,
  PRIMARY KEY (`ID_RACA`),
  KEY `ID_TIPO_idx` (`ID_TIPO_ANIMAL`),
  CONSTRAINT `ID_TIPO` FOREIGN KEY (`ID_TIPO_ANIMAL`) REFERENCES `tipo_animal` (`ID_TIPO_ANIMAL`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.raca: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `raca` DISABLE KEYS */;
INSERT INTO `raca` (`ID_RACA`, `DESCRICAO`, `ID_TIPO_ANIMAL`) VALUES
	(1, 'Budog', 1),
	(2, 'Pastor Alemão', 2),
	(3, 'Akita', 3),
	(4, 'Afegão Hound', 1),
	(5, 'Beagle', 2);
/*!40000 ALTER TABLE `raca` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.servico
CREATE TABLE IF NOT EXISTS `servico` (
  `ID_SERVICO` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(45) NOT NULL,
  `DATA_ENTRADA` datetime NOT NULL,
  `DATA_INCLUSAO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `PRECO` decimal(11,2) NOT NULL,
  `ID_CATEGORIA_SERVICO` int(11) NOT NULL,
  PRIMARY KEY (`ID_SERVICO`),
  KEY `ID_CATEGORIA_SERVICO_idx` (`ID_CATEGORIA_SERVICO`),
  CONSTRAINT `ID_CATEGORIA_SERVICO` FOREIGN KEY (`ID_CATEGORIA_SERVICO`) REFERENCES `categoria_servico` (`ID_CATEGORIA_SERVICO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.servico: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.tipo_animal
CREATE TABLE IF NOT EXISTS `tipo_animal` (
  `ID_TIPO_ANIMAL` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(75) NOT NULL,
  PRIMARY KEY (`ID_TIPO_ANIMAL`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.tipo_animal: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_animal` DISABLE KEYS */;
INSERT INTO `tipo_animal` (`ID_TIPO_ANIMAL`, `DESCRICAO`) VALUES
	(1, 'Cachorro'),
	(2, 'Gato'),
	(3, 'Passáro');
/*!40000 ALTER TABLE `tipo_animal` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.tipo_funcionario
CREATE TABLE IF NOT EXISTS `tipo_funcionario` (
  `ID_TIPO_FUNCIONARIO` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_TIPO_FUNCIONARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.tipo_funcionario: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_funcionario` DISABLE KEYS */;
INSERT INTO `tipo_funcionario` (`ID_TIPO_FUNCIONARIO`, `DESCRICAO`) VALUES
	(1, 'Gerente'),
	(2, 'Funcionario da retaguarda'),
	(3, 'Vendedor');
/*!40000 ALTER TABLE `tipo_funcionario` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `USUARIO` varchar(100) NOT NULL,
  `SENHA` varchar(255) NOT NULL,
  `ACESSO` int(11) NOT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.usuario: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`ID_USUARIO`, `USUARIO`, `SENHA`, `ACESSO`, `NOME`) VALUES
	(1, 'Nicolas', '123456', 1, 'Nicolas Silva');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.venda_produto
CREATE TABLE IF NOT EXISTS `venda_produto` (
  `ID_VENDA_PRODUTO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE_PROD` int(11) NOT NULL,
  `ID_FUNCIONARIO_PROD` int(11) NOT NULL,
  `DATA_VENDA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `TOTAL_VENDA` double NOT NULL,
  PRIMARY KEY (`ID_VENDA_PRODUTO`),
  KEY `ID_CLIENTE_idx` (`ID_CLIENTE_PROD`),
  KEY `ID_VENDEDOR_idx` (`ID_FUNCIONARIO_PROD`),
  CONSTRAINT `ID_VENDEDOR` FOREIGN KEY (`ID_FUNCIONARIO_PROD`) REFERENCES `funcionario` (`ID_FUNCIONARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_CLIENTE_PROD` FOREIGN KEY (`ID_CLIENTE_PROD`) REFERENCES `cliente` (`ID_CLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.venda_produto: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `venda_produto` DISABLE KEYS */;
INSERT INTO `venda_produto` (`ID_VENDA_PRODUTO`, `ID_CLIENTE_PROD`, `ID_FUNCIONARIO_PROD`, `DATA_VENDA`, `TOTAL_VENDA`) VALUES
	(1, 1, 1, '2015-11-21 10:51:07', 200);
/*!40000 ALTER TABLE `venda_produto` ENABLE KEYS */;


-- Copiando estrutura para tabela pet_mania.venda_servico
CREATE TABLE IF NOT EXISTS `venda_servico` (
  `ID_VENDA_SERVICO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE_SERVICO` int(11) NOT NULL,
  `ID_FUNCIONARIO_SERVICO` int(11) NOT NULL,
  `DATA_VENDA` datetime NOT NULL,
  PRIMARY KEY (`ID_VENDA_SERVICO`),
  KEY `ID_CLIENTE_SERVICO_idx` (`ID_CLIENTE_SERVICO`),
  KEY `ID_FUNCIONARIO_idx` (`ID_FUNCIONARIO_SERVICO`),
  CONSTRAINT `ID_CLIENTE_SERVICO` FOREIGN KEY (`ID_CLIENTE_SERVICO`) REFERENCES `cliente` (`ID_CLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_FUNCIONARIO_SERVICO` FOREIGN KEY (`ID_FUNCIONARIO_SERVICO`) REFERENCES `tipo_funcionario` (`ID_TIPO_FUNCIONARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela pet_mania.venda_servico: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `venda_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda_servico` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
