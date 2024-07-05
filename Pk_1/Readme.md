# Caesar-Verschlüsselung mit Wortüberprüfung

Dieses Python-Skript verwendet die Caesar-Verschlüsselung, um einen Text zu verschlüsseln, und bietet eine Methode zur Entschlüsselung, die versucht, den ursprünglichen Text anhand einer vordefinierten Wortliste zu rekonstruieren.

## Features

- **Verschlüsselung**: Caesar-Verschlüsselung eines gegebenen Textes mit einem festgelegten Verschiebungswert oder einer zufälligen Verschiebung.
  
- **Entschlüsselung**: Ausprobieren aller möglichen Caesar-Verschiebungen, um den ursprünglichen Text zu rekonstruieren.

- **Wortüberprüfung**: Überprüft den entschlüsselten Text auf das Vorhandensein bestimmter Schlüsselwörter aus einer vordefinierten Wortliste.

Wortliste: Du kannst die Wortliste in der Datei Caesar.py anpassen, um die Schlüsselwörter zu ändern.

## Installiere die erforderlichen Abhängigkeiten:

    ```
    pip install -r requirements.txt

```python
if random.random() < 0.02:  
    newStr += chr((ord(i) + random.randint(1, 26) - 65) % 26 + 65)
else:
    newStr += chr((ord(i) + shift - 65) % 26 + 65)
```

0.02 -> 2% chance that a random shift is chosen / 65 and 97 represent the ascii values for A and a
