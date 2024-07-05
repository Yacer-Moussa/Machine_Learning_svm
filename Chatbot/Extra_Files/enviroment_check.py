# -*- coding: utf-8 -*-
"""
Check Virtual Environment

This script checks if the current Python interpreter is running inside a virtual environment.
It uses various methods to determine the environment status, supporting both new and older versions of Python.

"""

__author__ = "Pascal Clement"
__date__ = "29.06.2024"
__status__ = "Production"
__version__ = "1.0.0"

import sys
import os


def is_virtual_environment():
    """
    Checks if the current Python interpreter is running inside a virtual environment.

    Returns:
    bool: True if inside a virtual environment, False otherwise.
    """
    # Check if base_prefix and prefix are different (for newer Python versions)
    if hasattr(sys, 'base_prefix') and sys.base_prefix != sys.prefix:
        return True
    # Alternative check for older Python versions using real_prefix
    elif hasattr(sys, 'real_prefix'):
        return True
    # Check for VIRTUAL_ENV environment variable set by virtualenv
    return (
            os.environ.get('VIRTUAL_ENV') is not None or
            sys.prefix != sys.base_prefix
    )


if __name__ == "__main__":
    if is_virtual_environment():
        print("The project is running in a virtual environment.")
    else:
        print("The project is not running in a virtual environment.")
