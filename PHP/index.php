<?php
require_once('car.php');
require_once('uberX.php');
require_once('uberPool.php');
require_once('account.php');

$uberX = new UberX("ASD123", new Account(
    "Andres",
    "12345678",
), "Chevrolet", "Spark");

$uberX->printDataCar();

$uberPool = new UberPool("ASD456", new Account(
    "Bradon",
    "12345678",
), "Dodge", "Spark");

$uberPool->printDataCar();
