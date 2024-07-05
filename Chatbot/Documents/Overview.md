# Project: Chatbot

## Einführung

### Projektübersicht
Dieses Projekt besteht aus mehreren Modulen, die verschiedene Funktionen bereitstellen. 
Die wichtigsten Funktionen sind derzeit "Sprache zu Text", die "Speicherung der generierten texte" und 
die "Sprachauswahl der erkennbaren Sprachen". Diese Funktionen werden von einem grafisches Benutzerinterface (GUI)
umschlossen. Obige Funktionen ermöglichen das Konvertieren des erzeugten
Textes in verschiedene Datenformate, das Erfassen und Erkennen von Sprachen,
die Verwaltung unterstützter Sprachen sowie eine benutzerfreundliche Schnittstelle zur Bedienung dieser Funktionen.

### Ziel des Projekts
Das Ziel des Projekts ist es, eine benutzerfreundliche Lösung zu bieten, um Textdaten in verschiedenen Formaten 
zu speichern, Sprachdaten zu erfassen und in Text umzuwandeln, die unterstützten Sprachen effektiv zu verwalten 
und eine intuitive Benutzeroberfläche bereitzustellen.

### Hauptfunktionen
- **Text zu Datei**: Konvertiert Text in TXT-, CSV-, JSON- und PDF-Dateiformate.
- **Sprache zu Text**: Erfasst Audioeingaben und konvertiert sie mithilfe von Googles Sprach-API in Text.
- **Sprache zu mathematischen Formeln**: Erfasst Audioeingaben und konvertiert sie mithilfe von Googles Sprach-API in  
                                         Text und anschließend zu mathematischen Formeln.
- **Sprachmodul**: Verwalten der unterstützten Sprachen für die Sprach-zu-Text-Funktionalität.
- **Benutzerinterface**: Startet und stoppt die Sprachaufzeichnung, zeigt den transkribierten Text an und ermöglicht das 
                         Speichern des Textes in einer Datei.

  
## Installation

### Systemvoraussetzungen
- Python 3.6 oder höher
- pip (Python Package Installer)
- Internetverbindung (für die Google-Spracherkennung API)
- tkinter und customtkinter Bibliotheken
- alle Packages aus der [requirements.txt](../../requirements.txt)

### Installationsanweisungen
1. Klonen Sie das Repository:
    git clone <repository_url>

2. Navigieren Sie in das Projektverzeichnis:
    cd <repository_directory>

3. Installieren Sie die erforderlichen Python-Pakete:
    pip install -r requirements.txt

   
## Verwendung

### Grundlegende Nutzung
1. **Text zu Datei**: Verwenden Sie die Funktion `save_file(text)`, um Text in einem gewünschten Format zu speichern.
2. **Sprache zu Text**: Verwenden Sie die Funktion `speak_to_text(language_code)`, um Sprache in Text umzuwandeln.
3. **Sprache zu mathematischer Formel**: Verwenden Sie die Funktion `convert_math_expression(recognized_text)`, 
                        um Sprache in Text umzuwandeln.
3. **Sprachmodul**: Verwenden Sie die Funktion `set_language_by_display_name(display_name)`, um die Sprache für die 
                      Sprach-zu-Text-Funktionalität festzulegen.
4. **Benutzerinterface**: Starten Sie die Anwendung `App` und verwenden Sie die bereitgestellten Schaltflächen, 
                          um Sprachaufzeichnungen zu starten, zu speichern und das Programm zu beenden.

### Beispiele und Anwendungsfälle
- **Text zu Datei**:
    ```python
    text = "Dies ist ein Beispieltext."
    save_file(text)
    ```
  
- **Sprache zu Text**:
    ```python
    recognized_text = speak_to_text("de-DE")
    print(recognized_text)
    ```
  
- **Sprache zu Text mit mathematischen Formeln**:
    ```python
    recognized_text = speak_to_text("de-DE")
    math_text = convert_math_expression(recognized_text)
    print(math_text)
    ```

- **Sprachmodul**:
    ```python
    selected_language_code = set_language_by_display_name("deutsch")
    print(selected_language_code)
    ```

- **Benutzerinterface**:
    ```python
    if __name__ == "__main__":
        app = App()
        app.mainloop()
    ```
  

## API-Dokumentation

### Beschreibung der Module, Klassen und Funktionen

#### Modul: Text zu Datei

- **open_file_path()**
    - **Beschreibung**: Zeigt einen Dateidialog an, um den Speicherort auszuwählen.
    - **Rückgabewerte**: `str` - der ausgewählte Dateipfad.

- **add_timestamp(file_path)**
    - **Beschreibung**: Fügt einen Zeitstempel zum Dateinamen hinzu.
    - **Parameter**: `file_path (str)` - der ursprüngliche Dateipfad.
    - **Rückgabewerte**: `str` - der Dateipfad mit Zeitstempel.

- **save_file(text)**
    - **Beschreibung**: Speichert den gegebenen Text in einer Datei im ausgewählten Format.
    - **Parameter**: `text (str)` - der zu speichernde Text.

- **save_text(text, file_path)**
    - **Beschreibung**: Speichert den Text in einer TXT-Datei.
    - **Parameter**: 
        - `text (str)` - er zu speichernde Text.
        - `file_path (str)` - Der Dateipfad, an dem der Text gespeichert wird.

- **save_csv(data, file_path)**
    - **Beschreibung**: Speichert die gegebenen Daten in einer CSV-Datei.
    - **Parameter**:
        - `data (list)` - Die zu speichernden Daten.
        - `file_path (str)` - Der Dateipfad, an dem die Daten gespeichert werden.

- **save_json(data, file_path)**
    - **Beschreibung**: Speichert die gegebenen Daten in einer JSON-Datei.
    - **Parameter**:
        - `data (dict)` - Die zu speichernden Daten.
        - `file_path (str)` - Der Dateipfad, an dem die Daten gespeichert werden.

- **save_text_as_pdf(text, file_path)**
    - **Beschreibung**: Speichert den Text in einer PDF-Datei.
    - **Parameter**:
        - `text (str)` - Der zu speichernde Text.
        - `file_path (str)` - Der Dateipfad, an dem der Text gespeichert wird.

#### Modul: Sprache zu Text

- **get_audio_input()**
    - **Beschreibung**: Erfasst Audioeingaben vom Mikrofon und passt die Umgebungsgeräusche an.
    - **Rückgabewerte**: `sr.AudioData` - die erfassten Audiodaten.

- **recognize_speech(audio, language_code)**
    - **Beschreibung**: Konvertiert die erfassten Audiodaten mithilfe der Google-Spracherkennungs-API in Text.
    - **Parameter**:
        - `audio (sr.AudioData)` - Die erfassten Audiodaten.
        - `language_code (str)` - Der Sprachcode für die Spracherkennung.
    - **Rückgabewerte**: `str` - der erkannte Text oder `None` bei Fehlern.

- **speak_to_text(language_code="en-EN")**
    - **Beschreibung**: Erfasst Audio vom Mikrofon und konvertiert es in Text.
    - **Parameter**: `language_code (str)` - der Sprachcode für die Spracherkennung (Standard ist 'en-EN').
    - **Rückgabewerte**: `str` - der erkannte Text oder eine Fehlermeldung.

#### Modul: Mathematik

- **convert_math_expression(text)**
    - **Beschreibung**: Konvertiert gesprochene mathematische Ausdrücke im Text zu korrekten Formelzeichen
    - **Parameter**: `text (str)` - Input Text zum Konvertieren.
    - **Rückgabewerte**: `str` - Text mit richtiger Symbolik

#### Modul: Sprachen

- **set_language_by_display_name(display_name)**
    - **Beschreibung**: Setzt den Sprachcode basierend auf dem Anzeigenamen.
    - **Parameter**: `display_name (str)` - der Anzeigename der Sprache.
    - **Rückgabewerte**: `str` - der entsprechende Sprachcode.

#### Modul: Benutzerinterface

- **App**
    - **Beschreibung**: Klasse für die grafische Benutzeroberfläche der Anwendung.
    - **Methoden**:
        - **__init__()**
            - Initialisiert die GUI-Komponenten und konfiguriert das Hauptfenster.
        - **start_recording()**
            - Startet die Sprachaufzeichnung und zeigt den transkribierten Text in der Textbox an.
        - **save_recording()**
            - Speichert den transkribierten Text in einer Datei.
        - **stop_application()**
            - Beendet die Anwendung.
        - **choose_language(display_language)**
            - Wählt die Sprache für die Sprach-zu-Text-Konvertierung basierend auf dem Anzeigenamen aus und zeigt sie in der Textbox an.
