<?php declare(strict_types=1);
require_once './Page.php';

class Lecture extends Page
{
    /**
     * @throws Exception
     */
    protected function __construct()
    {
        parent::__construct();
    }

    public function __destruct()
    {
        parent::__destruct();
    }

    /**
     * @return array
     */
    protected function getViewData():array
    {
        $sql = "SELECT * FROM article";

        $recordset = $this->_database->query($sql);
        if (!$recordset) {
            throw new Exception("Abfrage fehlgeschlagen: " . $this->_database->error);
        }

        $result = array();
        $record = $recordset->fetch_assoc();
        while ($record) {
            $result[] = $record;
            $record = $recordset->fetch_assoc();
        }

        $recordset->free();
        return $result;
    }

    /**
     * @return void
     */
    protected function generateView():void
    {
        $data = $this->getViewData();
        $this->generatePageHeader('electronic');
echo<<< HTML
<head>
<link rel="stylesheet" type="text/css" href="Exam.css">

    <title>HDA-Electronics</title>
</head>
<body>
    <header>
        <h1>HDA-Electronics</h1>
    </header>

    <div id="artikelListe">
    <h2 id="name">Artikelliste</h2>
        <!-- Hier sollten Sie Ihre Artikel hinzufügen -->
        <!-- Beispiel für einen Artikel -->
        <div class="artikel">
            <h3 id="name" class="name">Artikelname</h3>
            <p id="nummer" class="nummer">Artikelnummer</p>
            <p id="preis" class="preis">Preis</p>
            <div id="beschreibung" class="beschreibung">Beschreibung </div>
            <button id="favorit" class="favorit">Zu Favoriten hinzufügen</button>
        </div>
HTML;
        foreach ($data as $item) {
            echo '<div class="artikel">';
            foreach ($item as $key => $value) {
                echo '<div>' . $key . ':</div> ' . $value . '<br>';
            }
            echo '</div>';
        }
        echo <<< HTML
    </div>

    <div>
        <h2>Suche Anhand der Artikelnummer</h2>
        <input type="text" id="suche" placeholder="Artikelnummer eingeben" oninput="requestData()">
    </div>

    <div id="suchErgebnis" class="suchErgebnis">
        <!-- Hier wird das Suchergebnis angezeigt -->
    </div>
</body>


HTML;
        $this->generatePageFooter();
    }

    /**
     * @return void
     */
    protected function processReceivedData():void
    {
        parent::processReceivedData();
    }

    /**
     * @return void
     */
    public static function main():void
    {
        try {
            $page = new Lecture();
            $page->processReceivedData();
            $page->generateView();
        } catch (Exception $e) {
            header("Content-type: text/html; charset=UTF-8");
            echo $e->getMessage();
        }
    }
}

Lecture::main();