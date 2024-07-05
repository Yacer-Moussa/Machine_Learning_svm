# -*- coding: utf-8 -*-
"""
Text To File

This module provides functions for converting text lists to various file formats.
The resulting text files can be stored in different formats, including TXT, CSV, JSON, and PDF.
Additionally, users can choose a name for the output text file.
Every file will receive a timestamp for better organization.

Key Features:
- Convert text to TXT, CSV, JSON, and PDF formats.
- Allow users to choose the file name and format via a file dialog.
- Automatically add a date stamp to the file name for easier tracking.

"""

__author__ = "Pascal Clement, Dang Minh Nguyen, Yacer Moussa , Slim Ben Hamouda"
__date__ = "10.05.2024"
__status__ = "Production"
__version__ = "1.0.0"

from tkinter import filedialog
import csv
import json
from reportlab.lib.pagesizes import letter
from reportlab.pdfgen import canvas
from datetime import datetime

# Standard file formats
# If more formats are wanted, add them here and write a save function
DEFAULT_FILETYPES = [
    ("Text files", "*.txt"),
    ("CSV files", "*.csv"),
    ("JSON files", "*.json"),
    ("PDF files", "*.pdf")
]


def open_file_path():
    """
    Display a file dialog to choose the save location.

    Returns:
        str: The selected file path with the appropriate extension.
    """
    file_path = filedialog.asksaveasfilename(filetypes=DEFAULT_FILETYPES, defaultextension=".txt")
    return file_path


def add_timestamp(file_path):
    """
    Add a timestamp to the file name before the extension.

    Args:
        file_path (str): The original file path.

    Returns:
        str: The file path with the added timestamp.
    """
    base, ext = file_path.rsplit('.', 1)
    timestamp = datetime.now().strftime("%d.%m.%Y")
    return f"{base}_{timestamp}.{ext}"


def save_file(text):
    """
    Save the given text to a file in the selected format.

    Args:
        text (str): The text to save.
    """
    file_path = open_file_path()
    if file_path:
        # Add timestamp to the file path
        file_path = add_timestamp(file_path)

        # Perform the save operation based on file extension
        if file_path.endswith(".txt"):
            save_text(text, file_path)
        elif file_path.endswith(".csv"):
            save_csv(text, file_path)
        elif file_path.endswith(".json"):
            save_json(text, file_path)
        elif file_path.endswith(".pdf"):
            save_text_as_pdf(text, file_path)
        else:
            print("Unrecognized file extension. Saving as .txt by default.")
            save_text(text, file_path)  # Default to txt if extension not found


def save_text(text, file_path):
    """
    Save the given text to a TXT file.

    Args:
        text (str): The text to save.
        file_path (str): The file path where the text will be saved.
    """
    with open(file_path, mode='w') as text_file:
        text_file.write(text)
    print("Die Textdatei wurde erfolgreich erstellt.")


def save_csv(data, file_path):
    """
    Save the given data to a CSV file.

    Args:
        data (str): The data to save.
        file_path (str): The file path where the data will be saved.
    """
    with open(file_path, mode='w', newline='') as csv_file:
        writer = csv.writer(csv_file)
        for row in data:
            writer.writerow(row)
    print("Die CSV-Datei wurde erfolgreich erstellt.")


def save_json(data, file_path):
    """
    Save the given data to a JSON file.

    Args:
        data (str): The data to save.
        file_path (str): The file path where the data will be saved.
    """
    with open(file_path, mode='w') as json_file:
        json.dump(data, json_file, indent=4)
    print("Die JSON-Datei wurde erfolgreich erstellt.")


def save_text_as_pdf(text, file_path):
    """
    Save the given text to a PDF file.

    Args:
        text (str): The text to save.
        file_path (str): The file path where the text will be saved.
    """
    c = canvas.Canvas(file_path, pagesize=letter)
    lines = text.splitlines()
    y = 750  # Initial position on the page
    for line in lines:
        c.drawString(30, y, line)
        y -= 15  # Line spacing
    c.save()
    print("Die PDF-Datei wurde erfolgreich erstellt.")
