import requests
from bs4 import BeautifulSoup
import pandas as pd
import matplotlib.pyplot as plt
import PySimpleGUI as sg
import math


class QuadraticEquationSolver:
    def __init__(self):
        self.layout = [
            [sg.Text('Quadratic Equation Solver')],
            [sg.Text('Enter the values of a, b, and c:')],
            [sg.Text('a:'), sg.InputText()],
            [sg.Text('b:'), sg.InputText()],
            [sg.Text('c:'), sg.InputText()],
            [sg.Button('Solve'), sg.Button('Clear'), sg.Button('Exit')],
            [sg.Text('', size=(40, 1), key='output')]
        ]
        self.window = sg.Window('Quadratic Equation Solver', self.layout)

    def solve(self, a, b, c):
        try:
            a = float(a)
            b = float(b)
            c = float(c)
            discriminant = b**2 - 4*a*c
            if discriminant < 0:
                return 'No real roots'
            elif discriminant == 0:
                root = -b / (2*a)
                return f'One real root: {root}'
            else:
                root1 = (-b + math.sqrt(discriminant)) / (2*a)
                root2 = (-b - math.sqrt(discriminant)) / (2*a)
                return f'Two real roots: {root1}, {root2}'
        except ValueError:
            return 'Invalid input'

    def run(self):
        while True:
            event, values = self.window.read()
            if event == sg.WINDOW_CLOSED or event == 'Exit':
                break
            elif event == 'Clear':
                self.window['output'].update('')
            elif event == 'Solve':
                a, b, c = values[0], values[1], values[2]
                output = self.solve(a, b, c)
                self.window['output'].update(output)

        self.window.close()


def pillow_practice() -> None:
    solver = QuadraticEquationSolver()
    solver.run()


def bs4_practice() -> None:
    # Define a list of URLs to scrape
    urls = ['https://www.w3schools.com/css/css3_borders.asp',
            'https://www.w3schools.com/python/default.asp',
            'https://www.w3schools.com/cpp/default.asp',
            'https://www.w3schools.com/sql/default.asp',
            'https://www.w3schools.com/js/default.asp'
            ]

    # Initialize an empty DataFrame to store the results
    data = pd.DataFrame(columns=['url', 'link_count', 'word_count'])

    # Loop through each URL
    for url in urls:
        # Send a GET request to the URL
        response = requests.get(url)
        # Parse the HTML content using BeautifulSoup
        soup = BeautifulSoup(response.content, 'html.parser')

        # Get the number of links on the page
        link_count = len(soup.find_all('a'))

        # Get the number of words on the page
        words = soup.get_text().split()
        word_count = len(words)

        # Append the results to the DataFrame
        new_data = pd.DataFrame({
            'url': [url],
            'link_count': [link_count],
            'word_count': [word_count]
        })

        data = pd.concat([data, new_data], ignore_index=True)

    # Print the results
    print(data)
    make_histograms(urls[0])


def make_histograms(url: str) -> None:
    import matplotlib
    matplotlib.use('TkAgg')
    response = requests.get(url)
    soup = BeautifulSoup(response.content, 'html.parser')
    text = soup.get_text()
    words = text.split()

    # count frequency of each character
    char_counts = {}
    for char in text:
        if char in char_counts:
            char_counts[char] += 1
        else:
            char_counts[char] = 1

    # plot histogram of character frequency
    plt.bar(char_counts.keys(), char_counts.values())
    plt.show()

    # count frequency of word lengths
    word_lengths = [len(word) for word in words]
    max_length = 7
    length_counts = {}
    for i in range(max_length, max(word_lengths) + 1):
        length_counts[i] = word_lengths.count(i)

    # plot histogram of word length frequency
    plt.bar(length_counts.keys(), length_counts.values())
    plt.show()


if __name__ == '__main__':
    pillow_practice()
    # bs4_practice()
