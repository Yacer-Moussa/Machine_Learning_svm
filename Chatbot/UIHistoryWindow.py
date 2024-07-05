# -*- coding: utf-8 -*-
"""
This module provides a history window to display historical messages.

"""

__author__ = "Pascal Clement, Dang Minh Nguyen, Yacer Moussa , Slim Ben Hamouda"
__date__ = "10.05.2024"
__status__ = "Production"
__version__ = "1.0.0"

from tkinter import *
import customtkinter as ctk

class HistoryWindow(ctk.CTk):
    def __init__(self, history_messages):
        """
        Initializes the history window with the given historical messages.

        Parameters:
        history_messages (list): List of historical messages to be displayed in the window.
        """
        super().__init__()

        self.title("History")  # Sets the title of the window
        self.geometry("400x300")  # Sets the size of the window

        # Create a textbox for the historical messages
        self.history_textbox = ctk.CTkTextbox(self, height=20, corner_radius=10, state="normal")
        self.history_textbox.pack(fill="both", expand=True, padx=10, pady=10)

        # Display the historical messages in the textbox
        self.history_textbox.insert(END, "\n".join(history_messages))
        self.history_textbox.configure(state="disabled")  # Set the textbox to 'disabled' to prevent editing

        # Bind the closing of the window to a method
        self.protocol("WM_DELETE_WINDOW", self.on_close)

    def on_close(self):
        """
        Method that is called when the window is closed.
        """
        self.destroy()  # Close the window
