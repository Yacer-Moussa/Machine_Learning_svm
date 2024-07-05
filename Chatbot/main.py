# -*- coding: utf-8 -*-
"""
Main Application Entry Point

This script serves as the entry point for the Text To File Converter application.
It initializes and runs the graphical user interface (GUI) defined in the UI module.

"""

__author__ = "Pascal Clement, Dang Minh Nguyen, Yacer Moussa , Slim Ben Hamouda"
__date__ = "13.05.2024"
__status__ = "Production"
__version__ = "1.0.0"

from UIMainWindow import App  # Import the App class from the UI module


def main():
    """
    Initialize and start the main application.
    """
    app = App()  # Create an instance of the App class
    app.mainloop()  # Start the main loop of the application


# Execution of the main function
if __name__ == "__main__":
    main()
