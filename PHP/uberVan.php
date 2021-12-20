<?php
require_once('car.php');
class uberVan extends Car
{
    public $typeCarAccepted;
    public $seatsMaterial;

    public function __construct($license, $driver, $typeCarAccepted, $seatsMaterial)
    {
        parent::__construct($license, $driver);
        $this->typeCarAccepted = $typeCarAccepted;
        $this->seatsMaterial = $seatsMaterial;
    }

    public function setPassenger($passenger)
    {
        if ($passenger == 6) {
            $this->passenger = $passenger;
        } else {
            echo 'The car can take only 6 passengers';
        }
    }
}
