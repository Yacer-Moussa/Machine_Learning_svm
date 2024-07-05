import random

wortliste = ["aus", "besteht", "erkannt", "Fehler", "funktioniert", "Hardware", "macht", "nicht", "Problem", "Programm", "programmieren", "Python", "Software", "Spaß", "Zeilen"]
def encrypt_(str_: str, shift: int) -> str:
    newStr = ""
    for i in str_:
        if i.isalpha():
            if i.isupper():
                if random.random() < 0.02: #2% chance
                    newStr += chr((ord(i) + random.randint(1, 26) - 65) % 26 + 65)
                else:
                    newStr += chr((ord(i) + shift - 65) % 26 + 65)
            else:
                if random.random() < 0.02:
                    newStr += chr((ord(i) + random.randint(1, 26) - 97) % 26 + 97)
                else:
                    newStr += chr((ord(i) + shift - 97) % 26 + 97)
        else:
            newStr += i
    return newStr

def caesar_decrypt(encrypted_text):
    for shift in range(26):
        decrypted_text = ""
        for char in encrypted_text:
            if char.isalpha():
                ascii_offset = ord('a') if char.islower() else ord('A')
                decrypted_text += chr((ord(char) - ascii_offset - shift) % 26 + ascii_offset)
            else:
                decrypted_text += char
        if any(word in decrypted_text.lower().split() for word in wortliste):
            return decrypted_text
    return "Keine Übereinstimmung gefunden"

encrypted_text = encrypt_("Python Programm Funktionniert Nicht", 5)
print(f"Verschlüsselter Text: {encrypted_text}")
decrypted_text = caesar_decrypt(encrypted_text)
print(f"Entschlüsselter Text: {decrypted_text}")
