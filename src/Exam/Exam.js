// request als globale Variable anlegen (haesslich, aber bequem)
var request = new XMLHttpRequest();

function requestData() { // fordert die Daten asynchron an
    let $suche = document.getElementById('suche');

    if($suche.value) {
        request.open("GET", "ExamAPI.php?artikelnummer=" + $suche.value); // URL für HTTP-GET
        request.onreadystatechange = processData; //Callback-Handler zuordnen
        request.send(null); // Request abschicken
        $suche.value = '';
    }
}

function processData() {
    if(request.readyState == 4) { // Uebertragung = DONE
        if (request.status == 200) {   // HTTP-Status = OK
            if(request.responseText != null)
                process(request.responseText);// Daten verarbeiten
            else console.error ("Dokument ist leer");
        }
        else console.error ("Uebertragung fehlgeschlagen");
    } else ;          // Uebertragung laeuft noch
}

function process(data) {
    let dataDecoded = JSON.parse(data);



    let text = 'Tut mir leid, auf diese Artikel habe ich keine Antwort.';

    if(dataDecoded.length) {
        text = dataDecoded[0].answer;
    }

    let suchErgebnis = document.getElementById('suchErgebnis');
    let answer = document.createElement('p');

    answer.innerText = ' Folgende Artikel wurden gefunden: ' + text;
    suchErgebnis.appendChild(answer);
}