from account import Account
from car import Car
from account import Account

if __name__ == '__main__':
    print("Hello World!")
    car = Car("585FBJ", Account("Andres Herrera", "Hola"))
    print(vars(car))
    print(vars(car.driver))