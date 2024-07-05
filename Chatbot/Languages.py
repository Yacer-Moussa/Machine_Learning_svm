# -*- coding: utf-8 -*-
"""
Languages Module

This module manages supported languages for the speech-to-text functionality.
It provides lists of display names and their corresponding language codes.
Additionally, it determines the default language based on the system settings.

Documentation: https://cloud.google.com/speech-to-text/docs/speech-to-text-supported-languages

"""

__author__ = "Pascal Clement, Dang Minh Nguyen, Yacer Moussa , Slim Ben Hamouda"
__date__ = "19.05.2024"
__status__ = "Production"
__version__ = "1.0.0"

import ctypes
import locale

# List of languages display names
languages_display = ["english_US", "english_GB", "deutsch", "spanisch", "chinesisch",
                     "japanisch", "französisch", "vietnamesisch"]
# Corresponding language codes
languages_codes = ["en-US", "en-GB", "de-DE", "es-ES", "zh-yue", "ja-JA", "fr-FR", "vi-VN"]

# Get the system's default UI language
windll = ctypes.windll.kernel32
windll.GetUserDefaultUILanguage()
windowll = locale.windows_locale[windll.GetUserDefaultUILanguage()]
selected_language = windowll


def set_language_by_display_name(display_name):
    """
    Set the language code based on the display name.

    Args:
        display_name (str): The display name of the language.

    Returns:
        str: The corresponding language code.
    """
    global selected_language
    index = languages_display.index(display_name)
    selected_language = languages_codes[index]
    return selected_language
