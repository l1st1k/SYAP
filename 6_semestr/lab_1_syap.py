# Лабораторная работа №1 - Листванович Александр
import enum

def prim_1():
    number = int(input('Введите натуральное число: '))
    s = 1
    x = 1
    for n in range(1, number + 1):
        x = ((-1) ** n) / (2 ** n)
        s = x + s
    print('Член ряда ', x, 'сумма ряда ', s)

def prim_2():
    title = 'Python In Easy Steps'
    try:
        print(titel)
    except (NameError, IndexError) as msg:
        print(msg)
    day = 32
    try:
        if day > 31:
            raise ValueError('Invalid Day Number')
    except ValueError as msg:
        print('The Program found An', msg)
    finally:
        print('But Today Is Beautiful Anyway.')


def calculator() -> None:
    """
    Задание №1 - Калькулятор комплексных выражений через функцию eval()
    :return: None
    """
    try:
        input_str = input("Введите выражение:")
        result: complex = complex(eval(input_str))
        print('Результат: ' + str(result))
    except Exception as msg:
        print(msg)


def if_statements() -> None:
    """
    Задание №2 - Вывод строк в зависимости от введенного значения
    Реализовано через граф(все зависимости хранятся в словаре)
    Текстовые сообщения организованы в Enum для исключения повторений
    :return: None
    """
    class Answer(enum.Enum):
        first = 'Ты попал в бассейн'
        second = 'Тебя съел тиранозавр'
        third = 'Улетел в космос'
        fourth = 'Улетел на бали'
        fifth = 'Улетел на луну'
        sixth = 'Ты попал в лужу'

    graph_visual = {
        1: [11, 12],
        2: [21, 22],
        3: [31, 32],
        4: Answer.second,
        11: Answer.first,
        12: Answer.second,
        21: Answer.second,
        22: [221, 222],
        31: [222, 311],
        32: [321, 322],
        33: [1, ],
        221: Answer.third,
        222: Answer.fourth,
        311: Answer.fifth,
        321: Answer.sixth,
        322: Answer.fifth
    }
    try:
        temp_variable = int(input("Введите первоначальное значение: "))

        # Итерируемся, пока зависимый объект не будет сообщением
        while not isinstance(graph_visual[temp_variable], Answer):
            # Сохраняем зависимый объект
            potentials = graph_visual[temp_variable]
            # Спрашиваем новое значение
            print("Выберите следующее значение из следующих: ", graph_visual[temp_variable])
            temp_variable = int(input())
            # Валидируем новое значение
            if isinstance(potentials, list) and temp_variable not in potentials:
                raise KeyError

        print(graph_visual[temp_variable].value, end='')
    except KeyError:
        print("Вы ввели некорректное значение!")


if __name__ == '__main__':
    prim_2()
