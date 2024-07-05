import os

def read_csv(file_path: str, delimiter: str) -> list[list]:
    '''Read csv to two dimensional list.'''

    data = []

    with open(file=file_path, mode='r') as file:
        for line in file:
            data.append(line.rstrip().split(delimiter))

    return data

def write_csv(file_path: str, delimiter: str, data: list[list]) -> None:
    '''Write two dimensional list to file.
    If file is already present, old file gets removed.'''

    if os.path.exists(path = file_path):
        os.remove(path = file_path)

    with open(file = file_path, mode = 'w') as file:
        for line in data:
            length = len(line)

            for i, field in enumerate(line):
                file.write(field)

                if i < length-1:
                    file.write(delimiter)

            file.write("\n")
