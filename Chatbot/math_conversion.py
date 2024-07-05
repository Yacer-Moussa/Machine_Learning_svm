# -*- coding: utf-8 -*-
""" Math Expression Conversion

This Module provides functions for converting spoken math expressions into symbolic text.

"""

__author__ = "Pascal Clement, Dang Minh Nguyen, Yacer Moussa , Slim Ben Hamouda"
__date__ = "10.06.2024"
__status__ = "Production"
__version__ = "1.0.0"

import re  # Import the regular expressions module

# Dictionary mapping spoken math expressions to their symbolic counterparts
math_mappings = {
    "quadrat": "²",
    "hoch zwei": "²",
    "hoch drei": "³",
    "wurzel von": "√",
    "plus": "+",
    "minus": "-",
    "mal": "*",
    "geteilt durch": "/",
    "gleich": "=",
    "größer als": ">",
    "kleiner als": "<",
    "hoch vier": "⁴",
    "hoch fünf": "⁵",
    "hoch sechs": "⁶",
    "hoch sieben": "⁷",
    "hoch acht": "⁸",
    "hoch neun": "⁹",
    "hoch zehn": "¹⁰",
    "pi": "π",
    "euler": "e",
    "sinus": "sin",
    "cosinus": "cos",
    "tangens": "tan",
    "logarithmus": "log",
    "natürlicher logarithmus": "ln",
    "fakultät": "!",
    "prozent": "%",
    "modulo": "%",
    "hoch": "^",
    "integral von": "∫",
    "ableitung von": "d/dx",
    "summe von": "∑",
    "produkt von": "∏",
    "alpha": "α",
    "beta": "β",
    "gamma": "γ",
    "delta": "δ",
    "epsilon": "ε",
    "theta": "θ",
    "lambda": "λ",
    "mu": "μ",
    "rho": "ρ",
    "sigma": "σ",
    "phi": "φ",
    "omega": "ω"
}


def convert_math_expression(text):
    """
    Converts spoken math expressions in the given text to symbolic text.

    Parameters:
    text (str): The input text containing spoken math expressions.

    Returns:
    str: The text with spoken math expressions converted to symbols.
    :type text: object
    """
    for word, symbol in math_mappings.items():
        # Use regular expressions to replace spoken expressions with symbols
        text = re.sub(rf'\b{word}\b', symbol, text, flags=re.IGNORECASE)
    return text


if __name__ == "__main__":
    sample_text = "a quadratzahl plus b hoch drei minus wurzel von neun"
    converted_text = convert_math_expression(sample_text)
    print(f"Converted Text: {converted_text}")
