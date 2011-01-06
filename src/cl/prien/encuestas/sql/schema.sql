DROP TABLE IF EXISTS `acondicionamiento_termico`;
CREATE TABLE `acondicionamiento_termico` (
  `cliente` int(11) NOT NULL default '0',
  `calor` int(11) default '0',
  `calor_todo_0` varchar(50) default NULL,
  `calor_todo_1` int(11) default '0',
  `habit_0` int(11) default '0',
  `habit_1` int(11) default '0',
  `habit_2` int(11) default '0',
  `habit_otro_calor` varchar(50) default NULL,
  `usan_habit_calor` int(11) default '0',
  `XqCalor` int(11) default '0',
  `XqCalor_otro` varchar(50) default NULL,
  `frio` int(11) default '0',
  `frio_todo_0` int(11) default '0',
  `frio_todo_1` int(11) default '0',
  `habit_3` int(11) default '0',
  `habit_4` int(11) default '0',
  `habit_5` int(11) default '0',
  `habit_otro_frio` varchar(50) default NULL,
  `usan_habit_frio` int(11) default '0',
  `XqFrio` int(11) default '0',
  `XqFrio_otro` varchar(50) default NULL,
  `humedad` int(11) default '0',
  `temperatura` int(11) default '0',
  `Salud` int(11) default '0',
  `Confort` int(11) default '0',
  `Presupuesto` int(11) default '0',
  `aire_acondicionado` int(11) default '0',
  `sistema_aire` int(11) default '0',
  `Ctos_sistema_aire1` int(11) default '0',
  `Ctos_meses` int(11) default '0',
  `Dormitorio` int(11) default '0',
  `Living` int(11) default '0',
  `Sala_estar` int(11) default '0',
  `Cocina` int(11) default '0',
  `Otro` int(11) default '0',
  `Ctos` int(11) default '0',
  `Calefacciona_todo` int(11) default '0',
  `Dormitorio_ppal` int(11) default '0',
  `Otro_dormitorio` int(11) default '0',
  `Living_comedor` int(11) default '0',
  `Sala_de_estar` int(11) default '0',
  `Cocina_` int(11) default '0',
  `Otro_` int(11) default '0',
  `Cual_otro` varchar(50) default NULL,
  `Central_termica` int(11) default '0',
  `Calderas_murales` int(11) default '0',
  `Estufas` int(11) default '0',
  `EUCT` int(11) default '0',
  `Loza_CT` int(11) default '0',
  `Radiadores_CT` int(11) default '0',
  `Techo_suelo_CT` int(11) default '0',
  `Ctos_radiadores_CT` int(11) default '0',
  `Termostatos_CT` int(11) default '0',
  `Ctos_termostatos_CT` int(11) default '0',
  `InfoComp_AT` int(11) default NULL,
  `alicuota_AT` double default '0',
  `fondo` int(11) default '0',
  `FCF_AT_0` double default '0',
  `FCF_AT_1` double default '0',
  `FCF_CTE_AT` double default '0',
  `ns_AT_0` int(11) default '0',
  `Precio_cte` int(11) default '0',
  `tipo_medidor_AT` int(11) default '0',
  `meses_AT` int(11) default '0',
  `C1` double default '0',
  `C2` int(11) default '0',
  `C3` double default '0',
  `C4` double default '0',
  `GF_prorrateo` double default '0',
  `EUCC` int(11) default '0',
  `Loza_CC` int(11) default '0',
  `Radiadores_CC` int(11) default '0',
  `Techo_suelo_CC` int(11) default '0',
  `Ctos_radiadores_CC` int(11) default '0',
  `Termostato_CC` int(11) default '0',
  `Ctos_termostatos_CC` int(11) default '0',
  `estufas_selected` int(11) default '0',
  `estufas_GL` int(11) default '0',
  `estufas_GL_0` int(11) default '0',
  `estufas_GL_0_cantidad` int(11) default '0',
  `tama�o_GL_0` int(11) default '0',
  `estufas_GL_1` int(11) default '0',
  `estufas_GL_1_cantidad` int(11) default '0',
  `tama�o_GL_1` int(11) default '0',
  `estufas_GL_2` int(11) default '0',
  `estufas_GL_2_cantidad` int(11) default '0',
  `termostato_GL_2` int(11) default '0',
  `estufas_GL_3` int(11) default '0',
  `estufas_GL_3_cantidad` int(11) default '0',
  `termostato_GL_3` int(11) default '0',
  `estufas_kerosene` int(11) default '0',
  `estufas_kerosene_0` int(11) default '0',
  `estufas_kerosene_0_cantidad` int(11) default '0',
  `tama�o_kerosene_0` int(11) default '0',
  `estufas_kerosene_1` int(11) default '0',
  `estufas_kerosene_1_cantidad` int(11) default '0',
  `estufas_GN` int(11) default '0',
  `estufas_GN_0` int(11) default '0',
  `estufas_GN_0_cantidad` int(11) default '0',
  `estufas_GN_1` int(11) default '0',
  `estufas_GN_1_cantidad` int(11) default '0',
  `termostato_GN_1` int(11) default '0',
  `estufas_GN_2` int(11) default '0',
  `estufas_GN_2_cantidad` int(11) default '0',
  `estufas_GN_3` int(11) default '0',
  `estufas_GN_3_cantidad` int(11) default '0',
  `estufas_electricas` int(11) default '0',
  `estufas_electricas_0` int(11) default '0',
  `estufas_electricas_0_cantidad` int(11) default '0',
  `termostato_electricas_0` int(11) default '0',
  `estufas_electricas_1` int(11) default '0',
  `estufas_electricas_1_cantidad` int(11) default '0',
  `termostato_electricas_1` int(11) default '0',
  `estufas_electricas_2` int(11) default '0',
  `estufas_electricas_2_cantidad` int(11) default '0',
  `termostato_electricas_2` int(11) default '0',
  `R1` int(11) default '0',
  `recinto_R1` varchar(50) default NULL,
  `sup00_R1` int(11) default '0',
  `sup01_R1` int(11) default '0',
  `%sup_R1` int(11) default '0',
  `Inf00_R1` int(11) default '0',
  `Inf01_R1` int(11) default '0',
  `%Inf_R1` varchar(50) default NULL,
  `Der00_R1` int(11) default '0',
  `Der01_R1` int(11) default '0',
  `%Der_R1` int(11) default '0',
  `Izq00_R1` int(11) default '0',
  `Izq01_R1` int(11) default '0',
  `%Izq_R1` int(11) default '0',
  `largo_R1` int(11) default '0',
  `Ancho_R1` int(11) default '0',
  `P1de_R1` int(11) default '0',
  `P1a_R1` int(11) default '0',
  `P2de_R1` int(11) default '0',
  `P2a_R1` varchar(50) default NULL,
  `tipo_estufa_R1` int(11) default '0',
  `tipo_estufa_selected_R1` int(11) default '0',
  `CC_R1` int(11) default '0',
  `CC_selected_R1` int(11) default '0',
  `n_radiadores_R1` int(11) default '0',
  `vidrios_R1` int(11) default '0',
  `marcos_R1` int(11) default '0',
  `R2` int(11) default '0',
  `recinto_R2` varchar(50) default NULL,
  `sup00_R2` int(11) default '0',
  `sup01_R2` int(11) default '0',
  `%sup_R2` int(11) default '0',
  `Inf00_R2` int(11) default '0',
  `Inf01_R2` int(11) default '0',
  `%Inf_R2` varchar(50) default NULL,
  `Der00_R2` int(11) default '0',
  `Der01_R2` int(11) default '0',
  `%Der_R2` int(11) default '0',
  `Izq00_R2` int(11) default '0',
  `Izq01_R2` int(11) default '0',
  `%Izq_R2` int(11) default '0',
  `largo_R2` int(11) default '0',
  `Ancho_R2` int(11) default '0',
  `P1de_R2` int(11) default '0',
  `P1a_R2` int(11) default '0',
  `P2de_R2` int(11) default '0',
  `P2a_R2` int(11) default '0',
  `tipo_estufa_R2` int(11) default '0',
  `tipo_estufa_selected_R2` int(11) default '0',
  `CC_R2` int(11) default '0',
  `CC_selected_R2` int(11) default '0',
  `n_radiadores_R2` int(11) default '0',
  `vidrios_R2` int(11) default '0',
  `marcos_R2` int(11) default '0',
  `R3` int(11) default '0',
  `recinto_R3` varchar(50) default NULL,
  `sup00_R3` int(11) default '0',
  `sup01_R3` int(11) default '0',
  `%sup_R3` int(11) default '0',
  `Inf00_R3` int(11) default '0',
  `Inf01_R3` int(11) default '0',
  `%Inf_R3` varchar(50) default NULL,
  `Der00_R3` int(11) default '0',
  `Der01_R3` int(11) default '0',
  `%Der_R3` int(11) default '0',
  `Izq00_R3` int(11) default '0',
  `Izq01_R3` int(11) default '0',
  `%Izq_R3` int(11) default '0',
  `largo_R3` int(11) default '0',
  `Ancho_R3` int(11) default '0',
  `P1de_R3` int(11) default '0',
  `P1a_R3` int(11) default '0',
  `P2de_R3` int(11) default '0',
  `P2a_R3` int(11) default '0',
  `tipo_estufa_R3` int(11) default '0',
  `tipo_estufa_selected_R3` int(11) default '0',
  `CC_R3` int(11) default '0',
  `CC_selected_R3` int(11) default '0',
  `n_radiadores_R3` int(11) default '0',
  `vidrios_R3` int(11) default '0',
  `marcos_R3` int(11) default '0',
  `cortinas_velos` int(11) default '0',
  `cierre_ventanas` int(11) default '0',
  `P1ventanas_de` int(11) default '0',
  `P1ventanas_a` int(11) default '0',
  `P2ventanas_de` int(11) default '0',
  `P2ventanas_a` int(11) default '0',
  `cierre_cortinas` int(11) default '0',
  `P1cortinas_de` int(11) default '0',
  `P1cortinas_a` int(11) default '0',
  `P2cortinas_de` int(11) default '0',
  `P2cortinas_a` int(11) default '0',
  `sombras` int(11) default '0',
  `cantidad_sombras` int(11) default '0',
  `sellado_rendijas` int(11) default '0',
  serial int null default null,
  id int not null auto_increment,
primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `aguacaliente_y_coccion`
--

DROP TABLE IF EXISTS `aguacaliente_y_coccion`;
CREATE TABLE `aguacaliente_y_coccion` (
  `cliente` int(11) NOT NULL default '0',
  `sistema` int(11) default '0',
  `InfoComp_ACS` int(11) default NULL,
  `alicuota` double default '0',
  `FCF_0` int(11) default '0',
  `FCF_1` int(11) default '0',
  `FCF_ACS` double default '0',
  `Precio_CTE_ACS` int(11) default '0',
  `ns_0` int(11) default '0',
  `tipo_medidor` int(11) default '0',
  `mes` int(11) default '0',
  `ConsumoACS_dpto_m3` double default '0',
  `ConsumoACS_dpto_pesos` int(11) default '0',
  `ConsumoACS_edificio_m3` int(11) default '0',
  `ConsumoACS_edificio_pesos` int(11) default '0',
  `GF_prorrateo` double default '0',
  `piloto` int(11) default '0',
  `loApaga` int(11) default '0',
  `ECA` int(11) default '0',
  `optAC_0` int(11) default '0',
  `optAC_1` int(11) default '0',
  `optAC_2` int(11) default '0',
  `habs_0` int(11) default '0',
  `habs_1` int(11) default '0',
  `habs_2` int(11) default '0',
  `habs_3` int(11) default '0',
  `habs_4` int(11) default '0',
  `daprox_0` int(11) default '0',
  `daprox_1` int(11) default '0',
  `daprox_2` int(11) default '0',
  `daprox_3` int(11) default '0',
  `daprox_4` int(11) default '0',
  `nsnc_0` int(11) default '0',
  `nsnc_1` int(11) default '0',
  `nsnc_2` int(11) default '0',
  `nsnc_3` int(11) default '0',
  `nsnc_4` int(11) default '0',
  `lavadora` int(11) default '0',
  `ciclo` int(11) default '0',
  `regula` int(11) default '0',
  `aireador` int(11) default '0',
  `EUC` int(11) default '0',
  `EUH` int(11) default '0',
  `tapa` int(11) default '0',
  serial int null default null,
   id int not null auto_increment,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `aparatos`
--

DROP TABLE IF EXISTS `aparatos`;
CREATE TABLE `aparatos` (
  `cliente` int(11) NOT NULL default '0',
  `refrigerador` int(11) default '0',
  `tipo_refrigerador` int(11) default '0',
  `antiguedad` int(11) default '0',
  `congelador` int(11) default '0',
  `lavavajillas` int(11) default '0',
  `lavadora` int(11) default '0',
  `tipo_lavadora` int(11) default '0',
  `cargas` int(11) default '0',
  `secadora` int(11) default '0',
  `QEU` int(11) default '0',
  `cargas_secadora` int(11) default '0',
  `centrifuga` int(11) default '0',
  `microondas` int(11) default '0',
  `televisor` int(11) default '0',
  `teles` int(11) default '0',
  serial int null default null,
   id int not null auto_increment,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `clientes1`
--

DROP TABLE IF EXISTS `clientes1`;
CREATE TABLE `clientes1` (
  `bosca` varchar(255) default NULL,
  `cal central` varchar(255) default NULL,
  `cal cocina` varchar(255) default NULL,
  `cal dorm princ` varchar(255) default NULL,
  `cal living` varchar(255) default NULL,
  `cal otro` varchar(255) default NULL,
  `cal otro t` varchar(255) default NULL,
  `cal otros dorms` varchar(255) default NULL,
  `cal sala` varchar(255) default NULL,
  `cal toda casa` varchar(255) default NULL,
  `est elec` varchar(255) default NULL,
  `est gas cat` varchar(255) default NULL,
  `est gas cat opt` varchar(255) default NULL,
  `est gas l` varchar(255) default NULL,
  `est gas l opt` varchar(255) default NULL,
  `est gas nat` varchar(255) default NULL,
  `est kero` varchar(255) default NULL,
  `est kero opt` varchar(255) default NULL,
  `est tiro bal` varchar(255) default NULL,
  `est tiro bal term` varchar(255) default NULL,
  `est tiro nat` varchar(255) default NULL,
  `est tiro nat term` varchar(255) default NULL,
  `estufas` varchar(255) default NULL,
  `le�os` varchar(255) default NULL,
  `meses` varchar(255) default NULL,
  `oleo elec` varchar(255) default NULL,
  `oleoelec term` varchar(255) default NULL,
  `radiante` varchar(255) default NULL,
  `radiante term` varchar(255) default NULL,
  `rads0` varchar(255) default NULL,
  `sistema` varchar(255) default NULL,
  `term prog` varchar(255) default NULL,
  `termovent` varchar(255) default NULL,
  `termovent term` varchar(255) default NULL,
  `terms` varchar(255) default NULL,
  `cliente` varchar(50) default NULL,
  `nombre` varchar(50) default NULL,
  `calle` varchar(50) default NULL,
  `num` varchar(50) default NULL,
  `dpto` varchar(50) default NULL,
  `comuna` varchar(50) default NULL,
  `superficie` varchar(50) default NULL,
  `ns/nc` varchar(50) default NULL,
  `dorms` varchar(50) default NULL,
  `pareada` varchar(50) default NULL,
  `ba�os` varchar(50) default NULL,
  `tama�o` varchar(50) default NULL,
  `estar` varchar(50) default NULL,
  `com diario` varchar(50) default NULL,
  `habs` varchar(50) default NULL,
  `pisos` varchar(50) default NULL,
  `a�o constr` varchar(50) default NULL,
  `propietario` varchar(50) default NULL,
  `constructiva` varchar(50) default NULL,
  `frio dentro` varchar(50) default NULL,
  `por que frio` varchar(50) default NULL,
  `frio otro` varchar(50) default NULL,
  `toda casa` varchar(50) default NULL,
  `frias dorms` varchar(50) default NULL,
  `frias estar` varchar(50) default NULL,
  `frias otro` varchar(50) default NULL,
  `frias otro t` varchar(50) default NULL,
  `se usan` varchar(50) default NULL,
  `temp amb` varchar(50) default NULL,
  `exceso hum` varchar(50) default NULL,
  `exc donde` varchar(50) default NULL,
  `rincones` varchar(50) default NULL,
  `muros` varchar(50) default NULL,
  `oriente` varchar(50) default NULL,
  `poniente` varchar(50) default NULL,
  `norte` varchar(50) default NULL,
  `sur` varchar(50) default NULL,
  `origen` varchar(50) default NULL,
  `salud` varchar(50) default NULL,
  `confort` varchar(50) default NULL,
  `recinto1` varchar(50) default NULL,
  `option170` varchar(50) default NULL,
  `inicio1_1` varchar(50) default NULL,
  `inicio2_1` varchar(50) default NULL,
  `fin1_1` varchar(50) default NULL,
  `fin2_1` varchar(50) default NULL,
  `estufa1` varchar(50) default NULL,
  `calef1` varchar(50) default NULL,
  `estuf1` varchar(50) default NULL,
  `sistema1` varchar(50) default NULL,
  `rads1` varchar(50) default NULL,
  `n0` varchar(50) default NULL,
  `n1` varchar(50) default NULL,
  `e0` varchar(50) default NULL,
  `e1` varchar(50) default NULL,
  `o0` varchar(50) default NULL,
  `o1` varchar(50) default NULL,
  `s0` varchar(50) default NULL,
  `s1` varchar(50) default NULL,
  `s5` varchar(50) default NULL,
  `recinto2` varchar(50) default NULL,
  `option171` varchar(50) default NULL,
  `inicio1_2` varchar(50) default NULL,
  `inicio2_2` varchar(50) default NULL,
  `fin1_2` varchar(50) default NULL,
  `fin2_2` varchar(50) default NULL,
  `estufa2` varchar(50) default NULL,
  `calef2` varchar(50) default NULL,
  `estuf2` varchar(50) default NULL,
  `sistema2` varchar(50) default NULL,
  `rads2` varchar(50) default NULL,
  `n2` varchar(50) default NULL,
  `n3` varchar(50) default NULL,
  `e2` varchar(50) default NULL,
  `e3` varchar(50) default NULL,
  `o2` varchar(50) default NULL,
  `o3` varchar(50) default NULL,
  `s2` varchar(50) default NULL,
  `s3` varchar(50) default NULL,
  `recinto3` varchar(50) default NULL,
  `option172` varchar(50) default NULL,
  `inicio1_3` varchar(50) default NULL,
  `inicio2_3` varchar(50) default NULL,
  `fin1_3` varchar(50) default NULL,
  `fin2_3` varchar(50) default NULL,
  `estufa3` varchar(50) default NULL,
  `calef3` varchar(50) default NULL,
  `estuf3` varchar(50) default NULL,
  `sistema3` varchar(50) default NULL,
  `rads3` varchar(50) default NULL,
  `n4` varchar(50) default NULL,
  `n5` varchar(50) default NULL,
  `e4` varchar(50) default NULL,
  `e5` varchar(50) default NULL,
  `o4` varchar(50) default NULL,
  `o5` varchar(50) default NULL,
  `s4` varchar(50) default NULL,
  `presupuesto` varchar(50) default NULL,
  serial int null default null,
   id int not null auto_increment,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `clientes2`
--

DROP TABLE IF EXISTS `clientes2`;
CREATE TABLE `clientes2` (
  `Cliente` varchar(50) default NULL,
  `ventanas` varchar(50) default NULL,
  `cortinas` varchar(50) default NULL,
  `cost cortinas` int(11) default NULL,
  `cortinas ini1` varchar(50) default NULL,
  `cortinas ini2` varchar(50) default NULL,
  `cortinas fin1` varchar(50) default NULL,
  `cortinas fin2` varchar(50) default NULL,
  `rendijas` varchar(50) default NULL,
  `aislante murallas` varchar(50) default NULL,
  `aislante piso` varchar(50) default NULL,
  `aislante cielo` varchar(50) default NULL,
  `doble vidrio` varchar(50) default NULL,
  `tele cuantas` int(11) default NULL,
  `energ agua` int(11) default NULL,
  `ducharse` int(11) default NULL,
  `0a5` int(11) default NULL,
  `0a5 dur` int(11) default NULL,
  `6a13` int(11) default NULL,
  `6a13 dur` int(11) default NULL,
  `14a25` int(11) default NULL,
  `14a25 dur` int(11) default NULL,
  `26a65` int(11) default NULL,
  `26a65 dur` int(11) default NULL,
  `65+` int(11) default NULL,
  `65+ dur` int(11) default NULL,
  `loza` int(11) default NULL,
  `ropa` int(11) default NULL,
  `lavad` int(11) default NULL,
  `cargas` int(11) default NULL,
  `ciclos` int(11) default NULL,
  `energ cocina` int(11) default NULL,
  `energ horno` int(11) default NULL,
  `tapa ollas` int(11) default NULL,
  `aireador` int(11) default NULL,
  `percepcion` int(11) default NULL,
  `ilum ext` int(11) default NULL,
  `ilum ext tipo` int(11) default NULL,
  `alta efic` int(11) default NULL,
  `alta efic cuantas` int(11) default NULL,
  `halogenas` int(11) default NULL,
  `fluor` int(11) default NULL,
  `fluor cocina` int(11) default NULL,
  `fluor ba�os` int(11) default NULL,
  `fluor otro` int(11) default NULL,
  `fluor otro t` varchar(50) default NULL,
  `refri` int(11) default NULL,
  `refri tipo` int(11) default NULL,
  `refri hace` int(11) default NULL,
  `cong` int(11) default NULL,
  `cong tipo` int(11) default NULL,
  `lavavajillas` int(11) default NULL,
  `lavadora` int(11) default NULL,
  `lavadora tipo` int(11) default NULL,
  `secadora` int(11) default NULL,
  `secadora energ` int(11) default NULL,
  `centrifuga` int(11) default NULL,
  `microondas` int(11) default NULL,
  `tele` int(11) default NULL,
  `apaga` varchar(50) default NULL,
  `energ calef` varchar(50) default NULL,
  `hace calef` varchar(50) default NULL,
  `regula temp` varchar(50) default NULL,
  `adentro` varchar(50) default NULL,
  `ca�erias` varchar(50) default NULL,
  `piloto` varchar(50) default NULL,
  `cargas secadora` varchar(50) default NULL,
  `bosca le�a` int(11) default NULL,
  `gl tn` int(11) default NULL,
  `gl tb` int(11) default NULL,
  `est kero` int(11) default NULL,
  `kero tb` int(11) default NULL,
  `est gas lic` int(11) default NULL,
  `gl tn term` int(11) default NULL,
  `gl tb term` int(11) default NULL,
  `text9 0` varchar(50) default NULL,
  `text9 1` varchar(50) default NULL,
  `text9 2` varchar(50) default NULL,
  `hventana` int(11) default NULL,
  `email` varchar(50) default NULL,
  `fecha` datetime default NULL,
  `marco` varchar(50) default NULL,
  serial int null default null,
   id int not null auto_increment,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `clientes3`
--

DROP TABLE IF EXISTS `clientes3`;
CREATE TABLE `clientes3` (
  `cliente` varchar(50) NOT NULL,
  `aire acondicionado` varchar(50) default NULL,
  `meses aire` varchar(50) default NULL,
  `dorm principal` varchar(50) default NULL,
  `otros dorms` varchar(50) default NULL,
  `cuantos dorms` varchar(50) default NULL,
  `living/comedor` varchar(50) default NULL,
  `sala estar` varchar(50) default NULL,
  `cocina` varchar(50) default NULL,
  `piscina` varchar(50) default NULL,
  `largo` varchar(50) default NULL,
  `ancho` varchar(50) default NULL,
  `profundidad` varchar(50) default NULL,
  `meses piscina` varchar(50) default NULL,
  `iluminacion` varchar(50) default NULL,
  `horas ilum` varchar(50) default NULL,
  `calefaccion piscina` varchar(50) default NULL,
  `acuario` varchar(50) default NULL,
  `tama�o acuario` varchar(50) default NULL,
  serial int null default null,
   id int not null auto_increment,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `iluminaciondpto`
--

DROP TABLE IF EXISTS `iluminaciondpto`;
CREATE TABLE `iluminaciondpto` (
  `cliente` int(11) default '0',
  `CantLux` int(11) default '0',
  `UsoAmpolletasEficientes` int(11) default '0',
  `CtasAmpolletas` int(11) default '0',
  `UsaLamparaHalogena` int(11) default '0',
  `UsaFluorescente` int(11) default '0',
  `enCocina` int(11) default '0',
  `enBa�o` int(11) default '0',
  `otro` int(11) default '0',
  `Cualotro` varchar(50) default NULL,
  serial int null default null,
   id int not null auto_increment,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Table structure for table `informacion_general_dpto`
--

DROP TABLE IF EXISTS `informacion_general_dpto`;
CREATE TABLE `informacion_general_dpto` (
  `cliente` int(11) NOT NULL default '0',
  `nombre` varchar(50) default NULL,
  `fecha` datetime default NULL,
  `Direccion` varchar(50) default NULL,
  `num` int(11) default '0',
  `dpto` varchar(50) default NULL,
  `Comuna` varchar(50) default NULL,
  `Email` varchar(50) default NULL,
  `Superficie` int(11) default '0',
  `Ns/Nc` int(11) default '0',
  `Color` int(11) default '0',
  `ubicacion` int(11) default '0',
  `Tama�o` int(11) default '0',
  `dorms` int(11) default '0',
  `ba�os` int(11) default '0',
  `n_habs` int(11) default '0',
  `SE` int(11) default '0',
  `CD` int(11) default '0',
  `Ser` int(11) default '0',
  `Esc` int(11) default '0',
  serial int null default null,
   id int not null auto_increment,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `tablaresumen`
--

DROP TABLE IF EXISTS `tablaresumen`;
CREATE TABLE `tablaresumen` (
  `Cliente` varchar(50) NOT NULL,
  `Gas natural` varchar(50) default NULL,
  `Gas licuado` varchar(50) default NULL,
  `Kerosene` varchar(50) default NULL,
  `Electricidad` varchar(50) default NULL,
  `Le�a` varchar(50) default NULL,
  `ACS` varchar(50) default NULL,
  `Calefaccion` varchar(50) default NULL,
  `Agua Caliente` varchar(50) default NULL,
  `Coccion` varchar(50) default NULL,
  `Iluminacion` varchar(50) default NULL,
  `Refrigeracion` varchar(50) default NULL,
  `Artefactos principales` varchar(50) default NULL,
  `Artefactos menores` varchar(50) default NULL,
  `Total KWH` varchar(50) default NULL,
  `Ahorro calefaccion` varchar(50) default NULL,
  `Ahorro agua caliente` varchar(50) default NULL,
  `Ahorro iluminacion` varchar(50) default NULL,
  `Ahorro total` varchar(50) default NULL,
  eficiencia char(1) default null,
  serial int null default null,
   id int not null auto_increment,
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS informacion_general;
CREATE TABLE informacion_general (
  cliente varchar(50) NOT NULL,
  nombre varchar(50) NOT NULL,
  fecha varchar(50) NOT NULL,
  calle varchar(50) not NULL,
  num varchar(50) not NULL,
  dpto varchar(50) not NULL,
  comuna varchar(50) not NULL,
  tipo_vivienda varchar(50) not null,
  serial int not null auto_increment, 
  PRIMARY KEY (serial)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `acondicionamiento_termico2`;
DROP TABLE IF EXISTS `aguacaliente_y_coccion2`;
DROP TABLE IF EXISTS `aparatos2`;
DROP TABLE IF EXISTS `clientes12`;
DROP TABLE IF EXISTS `clientes22`;
DROP TABLE IF EXISTS `clientes32`;
DROP TABLE IF EXISTS `configuracion2`;
DROP TABLE IF EXISTS `iluminaciondpto2`;
DROP TABLE IF EXISTS `informacion_general2`;
DROP TABLE IF EXISTS `informacion_general_dpto2`;
DROP TABLE IF EXISTS `tablaresumen2`;