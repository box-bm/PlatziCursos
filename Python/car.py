from account import Account

class Car:
    id          = int
    license     = str
    driver      = Account("", "")
    passenger   = str

    def __init__(self, license, driver):
        self.license    = license
        self.driver     = driver

    def printDataCar(self):
        print("License: ", self.license)
        print("Driver: ", self.driver.name)
        print("Passenger: ", self.passenger)