# -*- coding: utf-8 -*-
"""
User Interface for Text To File Converter

Create a graphical user interface (GUI) for converting spoken language to text and saving it to a file.
It utilizes the customtkinter library for an enhanced appearance and integrates speech-to-text functionality.

Key Features:
- Start recording spoken language and display the transcribed text in a text box.
- Save the transcribed text to a file with a timestamp.
- Select the language for speech recognition from a dropdown menu.
- End the application with a button click.

"""

__author__ = "Pascal Clement, Dang Minh Nguyen, Yacer Moussa , Slim Ben Hamouda"
__date__ = "18.05.2024"
__status__ = "Production"
__version__ = "1.0.0"

from tkinter import *
import customtkinter as ctk
from TextToFiles import *
from SpeechText import speak_to_text
from UIHistoryWindow import HistoryWindow
import Languages
from googletrans import Translator
import threading

# Set the appearance mode and color theme for the application
ctk.set_appearance_mode("System")  # Modes: "System" (standard), "Dark", "Light")
ctk.set_default_color_theme("blue")  # Themes: "blue" (standard), "green", "dark-blue")

# Set the default language to English
selected_language = 'en-EN'


class App(ctk.CTk):
    def __init__(self):
        super().__init__()

        # Configure the main window
        self.history_window = None
        self.title("Audio Translator")
        self.geometry(f"{1100}x{580}")

        # Configure the grid layout for the window (4x4 grid)
        self.grid_columnconfigure(1, weight=1)
        self.grid_columnconfigure((2, 3), weight=0)
        self.grid_rowconfigure((0, 1, 2, 3), weight=1)
        self.grid_rowconfigure(4, weight=0)

        # Create and configure the sidebar frame with widgets
        self.sidebar_frame = ctk.CTkFrame(self, width=140, corner_radius=10)
        self.sidebar_frame.grid(row=0, column=0, rowspan=7, padx=(20, 20), pady=(20, 20), sticky="nsew")
        self.sidebar_frame.grid_rowconfigure(7, weight=1)

        # Add a logo label to the sidebar
        self.logo_label = ctk.CTkLabel(self.sidebar_frame, text="Menu", font=ctk.CTkFont(size=24, weight="bold"))
        self.logo_label.grid(row=0, column=0, padx=10, pady=(20, 5))

        # Add buttons to the sidebar
        self.sidebar_button_1 = ctk.CTkButton(self.sidebar_frame, text="Start Recording",
                                              command=self.start_recording)
        self.sidebar_button_1.grid(row=1, column=0, padx=10, pady=5)

        self.sidebar_button_4 = ctk.CTkButton(self.sidebar_frame, text="Stop Recording",
                                              command=self.stop_recording)
        self.sidebar_button_4.grid(row=2, column=0, padx=10, pady=5)

        self.sidebar_button_2 = ctk.CTkButton(self.sidebar_frame, text="Save Text",
                                              command=self.save_recording)
        self.sidebar_button_2.grid(row=3, column=0, padx=10, pady=5)

        self.sidebar_button_3 = ctk.CTkButton(self.sidebar_frame, text="Exit Application",
                                              command=self.stop_application)
        self.sidebar_button_3.grid(row=4, column=0, padx=10, pady=5)

        # Add a "History" button to the sidebar
        self.history_button = ctk.CTkButton(self.sidebar_frame, text="History", command=self.show_history)
        self.history_button.grid(row=8, column=0, padx=10, pady=5)

        # Add a label and dropdown menu for language selection
        self.appearance_mode_label = ctk.CTkLabel(self.sidebar_frame, text="Language:")
        self.appearance_mode_label.grid(row=5, column=0, padx=10, pady=(5, 0))

        self.appearance_mode_optionmenu = ctk.CTkOptionMenu(self.sidebar_frame, values=Languages.languages_display,
                                                            command=self.choose_language)
        self.appearance_mode_optionmenu.grid(row=6, column=0, padx=10, pady=(5, 0))

        # Create and configure the main frame for the text box
        self.optionmenu_frame = ctk.CTkFrame(self, corner_radius=10)
        self.optionmenu_frame.grid(row=0, column=1, rowspan=4, padx=(20, 20), pady=(20, 20), sticky="nsew")

        # Create a text box within the main frame
        self.textbox = ctk.CTkTextbox(self.optionmenu_frame, width=780, corner_radius=10)
        self.textbox.grid(row=0, column=1, padx=(40, 40), pady=(20, 40), sticky="nsew")

        # Create a frame for the status box
        self.status_frame = ctk.CTkFrame(self, height=20, corner_radius=10)
        self.status_frame.grid(row=4, column=1, columnspan=3, padx=(20, 20), pady=(10, 20), sticky="nsew")

        # Create a text box for the status display
        self.status_textbox = ctk.CTkTextbox(self.status_frame, height=20, corner_radius=10, state="disabled")
        self.status_textbox.pack(fill="both", expand=True, padx=10, pady=10)

        # Store history messages
        self.history_messages = []
        self.is_recording = False  # Initialize is_recording to False

    def update_status(self, message):
        """
        Update the status display with a given message and add it to history.

        Parameters:
        message (str): The message to be displayed and added to history.
        """
        self.status_textbox.configure(state="normal")
        self.status_textbox.delete(1.0, "end")
        self.status_textbox.insert("end", message)
        self.status_textbox.configure(state="disabled")
        self.status_textbox.see("end")

        # Append message to history
        self.history_messages.append(message)

    def show_history(self):
        """
        Display the history window with historical messages.
        """
        self.history_window = HistoryWindow(self.history_messages)
        self.history_window.mainloop()  # Open the History window

    def start_recording(self):
        """
        Start recording spoken language.
        """
        self.is_recording = True  # Set is_recording to True
        self.update_status("Recording started...")
        recording_thread = threading.Thread(target=self.perform_record)
        recording_thread.start()

    def perform_record(self):
        """
        Perform the recording and display the transcribed and translated text.
        """
        original_text = speak_to_text(selected_language, self)  # Get the original text
        if self.is_recording:
            translator = Translator()
            # Translate the original text to English
            translated_text = translator.translate(original_text, dest='en').text
            self.textbox.delete("1.0", END)  # Clear the textbox
            # Display both the original and translated text
            self.textbox.insert(END, f"Original ({selected_language}): "
                                     f"{original_text}\nTranslated (English): {translated_text}\n")
            self.update_status("Recording stopped.")

    def stop_recording(self):
        """
        Stop the recording process.
        """
        self.is_recording = False  # Set is_recording to False
        self.update_status("Recording stopped.")

    def save_recording(self):
        """
        Save the recorded text to a file with a timestamp.
        """
        self.update_status("Saving recording...")
        text = self.textbox.get("1.0", "end")  # Get the text from the text box
        file_path = open_file_path()  # Open a file dialog to select the file path
        if file_path:
            file_path = add_timestamp(file_path)  # Add a timestamp to the file path
            save_text(text, file_path)  # Save the recorded text to the selected file
            self.update_status(f"Recording saved: {file_path}")
        else:
            self.update_status("Save canceled.")

    def stop_application(self):
        """
        Stop the application.
        """
        self.update_status("Exiting application...")
        self.destroy()  # Close the application window

    def choose_language(self, display_language):
        """
        Choose the language for speech recognition.

        Parameters:
        display_language (str): The display name of the selected language.
        """
        global selected_language
        selected_language = Languages.set_language_by_display_name(display_language)  # Set the selected language
        self.textbox.delete("1.0", END)  # Clear the text box
        self.appearance_mode_optionmenu.set(display_language)  # Update the dropdown menu selection
        # Display the selected language
        self.update_status(f"Language changed to: {display_language} ({selected_language})")


if __name__ == "__main__":
    app = App()
    app.mainloop()
