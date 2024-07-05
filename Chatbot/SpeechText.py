# -*- coding: utf-8 -*-
"""
Speech to Text

This module provides functions for converting speech to text.
It adjusts ambient noise to achieve better recording quality for
clearer speech recognition.

Key Features:
- Capture audio input from the microphone.
- Adjust for ambient noise to improve recording quality.
- Convert captured audio to text using Google's speech recognition API.
- Handle errors and provide user feedback if speech is not recognized.

"""

__author__ = "Pascal Clement, Dang Minh Nguyen, Yacer Moussa , Slim Ben Hamouda"
__date__ = "07.05.2024"
__status__ = "Production"
__version__ = "1.0.1"

import speech_recognition as sr
from math_conversion import convert_math_expression


def get_audio_input(window):
    """
    Capture audio input from the microphone and adjust for ambient noise.

    Returns:
        sr.AudioData: The captured audio data.
    """
    recognizer = sr.Recognizer()
    with sr.Microphone() as source:
        window.update_status("Bitte fangen Sie an zu sprechen...bitte sprechen Sie deutlich und laut...")
        # Adjust for ambient noise
        recognizer.adjust_for_ambient_noise(source)
        # Listen to audio input
        audio = recognizer.listen(source)
    return audio


def recognize_speech(audio, language_code, window):
    """
    Convert the captured audio to text using Google's speech recognition API.

    Args:
        audio (sr.AudioData): The captured audio data.
        language_code (str): The language code for speech recognition (e.g., 'en-EN').

    Returns:
        str: The recognized text, or None if recognition fails.
        :param audio:
        :param language_code:
        :param window:
    """
    recognizer = sr.Recognizer()
    try:
        window.update_status("Erkennen...")
        # Convert audio to text
        text = recognizer.recognize_google(audio, language=language_code)
        return text
    except sr.UnknownValueError:
        window.update_status("Tut mir Leid, ich konnte dich nicht verstehen.")
    except sr.RequestError as e:
        window.update_status("Es konnten keine Ergebnisse vom Google-Spracherkennungsdienst angefordert werden:",
                             e)
    return None


def speak_to_text(language_code, window):
    """
    Capture audio from the microphone and convert it to text.

    Args:
        language_code (str): The language code for speech recognition (default is 'en-EN').

    Returns:
        str: The recognized text or an error message.
        :param language_code:
        :param window:
    """
    audio = get_audio_input(window)
    if audio:
        text = recognize_speech(audio, language_code, window)
        if text:
            print("Du hast gesagt:", text)
            text = convert_math_expression(text)
        else:
            return "Audio kann nicht erkannt werden"
    else:
        return "Kein Audio, Fehler"

    return text
