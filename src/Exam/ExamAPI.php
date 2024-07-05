<?php declare(strict_types=1);

require_once './Page.php';

class Lecture extends Page
{
    protected $artikelnummer = '';

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
        if($this->artikelnummer) {
            $artikelnummer = $this->_database->real_escape_string($this->artikelnummer);
            $sql = "SELECT * FROM article WHERE artikelnummer LIKE '" . $artikelnummer . "'";
        }

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

        $jsonData = json_encode($data);

        header('Content-Type: application/json');
        echo $jsonData;
    }

    /**
     * @return void
     */
    protected function processReceivedData():void
    {
        parent::processReceivedData();

        if(isset($_GET['Artikelnummer'])) {
            $this->artikelnummer = $_GET['Artikelnummer'];
        }
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