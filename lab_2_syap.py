# import pandas as pd
# import numpy as np


def math_operations() -> None:
    """
    5.	Напишите программу с классом Math. Создайте два атрибута — a и b.
    Напишите методы addition — сложение, multiplication — умножение, division — деление, subtraction — вычитание.
    При передаче в методы параметров a и b с ними нужно производить соответствующие действия и печатать ответ.
    :return: None
    """
    class Math:
        a: float
        b: float

        def addition(self) -> float:
            return self.a + self.b

        def subtraction(self) -> float:
            return self.a - self.b

        def multiplication(self) -> float:
            return self.a * self.b

        def division(self) -> float:
            return self.a / self.b

    obj = Math()
    dict_of_operations = {
        '+': obj.addition,
        '-': obj.subtraction,
        '*': obj.multiplication,
        '/': obj.division
    }

    input_str = ''
    while input_str != 'q':
        input_str = input('Выберите операцию: "+" "-" "*" "/" "q". Введите "q", если хотите выйти:\n').lower().strip()
        if input_str == 'q':
            print("Работа с программой завершена!")
            break
        if input_str not in dict_of_operations.keys():
            print('Ошибка!\nВыберите корректную операцию.')
            continue
        nums = 0
        while nums != 2:
            num_str = input("Введите два числа через пробел:\n")
            nums = len(num_str.split())
            if nums != 2:
                print('Должно быть введено два числа!')
                continue
            obj.a, obj.b = [float(n) for n in num_str.split()]
        try:
            print("Результат: ", dict_of_operations[input_str]())
        except ZeroDivisionError:
            print('Не смогу я на нолик поделить, извини...')


def pandas_practice() -> None:
    pass


if __name__ == '__main__':
    math_operations()
