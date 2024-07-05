# -*- coding: utf-8 -*-
"""
Text to Speech Conversion

This script converts given text in various languages to speech using Google Text-to-Speech (gTTS).
It demonstrates the conversion of texts in English, French, Spanish, German, Chinese, Japanese, and Vietnamese.

"""

__authors__ = "Pascal Clement"
__date__ = "13.05.2024"
__status__ = "Production"
__version__ = "1.0.0"


from gtts import gTTS  # Import Google Text-to-Speech module

# Texts to be converted to speech in various languages
text_en = ("Now I'm falling asleep, and she's calling a cab While he's having a smoke, "
           "and she's taking a drag Now they're going to bed, and my stomach is sick "
           "And it's all in my head, but she's touching his Chest now, he takes off her dress now Let me go")

text_fr = ("Quand il me prend dans ses bras Il me parle tout bas Je vois "
           "la vie en rose Il me dit des mots d'amour Des mots "
           "de tous les jours Et ça m'fait quelque chose Il est entré dans "
           "mon cœur Une part de bonheur Dont je connais la cause")

text_es = ("Yo puedo escalar los Andes solo Por ir a contar tus lunares "
           "Contigo celebro y sufro todo Mis alegrías y mis males")

text_de = ("Wie kannst du dir das leisten, wenn ich fragen darf? Ja, ich reselle eben halt. "
           "Und deine Mutter oder so? Ja, Eltern auch.")

text_zh = "让我再看你一遍 从南到北 像是被五环路 蒙住的双眼 请你再讲一遍 关于那天 抱着盒子的姑娘 和擦汗的男人"

text_ja = "いろはにほへと　ちりぬるを わかよたれそ　つねならむ うゐのおくやま　けふこえて あさきゆめみし　ゑひもせす"

text_vi = ("Nắng sớm mưa chiều Muốn nói bao điều Người người còn nhắc "
           "đến mai sau Sài Gòn cafe sữa đá Vẫn sẽ như thế khi đón khi đưa")

# Choose the text and language for conversion
# Here, mistakenly converting German text using the French language code
tts = gTTS(text_de, lang='fr')

# Define the output file path
audio_file = "C:/Users/Admin/OneDrive/0-Studium/hda/wrong_de_fr.mp3"

# Save the speech to the specified file
tts.save(audio_file)
