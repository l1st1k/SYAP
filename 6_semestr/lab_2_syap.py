def score(dice: list) -> int:
    result = 0
    d = {
        '111': 1000,
        '222': 200,
        '333': 300,
        '444': 400,
        '555': 500,
        '666': 600,
    }
    all_strings = list(map(str, sorted(dice)))
    string = ''.join(all_strings)
    for k, v in d.items():
        if k in string:
            result += v
            string = string.replace(k, '')

    for i in range(2):
        if '1' in string:
            result += 100
            string = string.replace('1', '', 1)
        if '5' in string:
            result += 50
            string = string.replace('5', '', 1)

    return result

