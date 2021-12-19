var car = new Car("AW456", new Account("Andres Herrera", "QWE234"));
car.passenger = 4;
car.printDataCar();

var uberX = new UberX(
  "ASD123",
  new Account("Andres Herrera 2", "QWE234"),
  "Chevrolet",
  "Spark"
);
uberX.passenger = 4;
uberX.printDataCar();