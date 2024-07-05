<?php declare(strict_types=1);
// UTF-8 marker äöüÄÖÜß€
require_once './Page.php';

class GenerateLink extends Page
{
    protected function __construct()
    {
        parent::__construct();
    }

    public function __destruct()
    {
        parent::__destruct();
    }

    protected function getViewData():array
    {
        return [];
    }

    protected function generateView():void
    {
        $this->generatePageHeader('HDA-LINK SCHORTNER!');
        echo <<< HTML
       <header>
        <nav>
                    <a href="#">Home</a>| <a href="#">product</a>| <a href="#">company</a>| <a href="#">Blog</a>
        </nav>
            <h1>LINK SCHORTNER !</h1>
       </header>
            <hr>
           
            <form action="GenerateLink.php.php" method="get" accepted-charset="utf-8">
                <input type="text" name="newURL" value="" placeholder="URL" required>
                <input type="submit" value="Send">
                <h1>SEND URL AND WE SCHORTER IT FOR YOU!</h1>
                <output type="text" name="Hash" value="" placeholder="Hash" required>
            </form>
            <footer> H-DA EWA 2021 </footer>
 HTML;
        $this->generatePageFooter();
    }

    protected function processReceivedData():void
    {
        if(isset($_GET['newURL']) ) {
            $url = $this->_database->real_escape_string($_GET['newURL']);


            $SQLabfrage = "INSERT INTO hash2URL SET " . "url = \"$url\", hash = \"$url\"";

            $this->_database->query($SQLabfrage);

            // PRG PATTERN
            header('Location: GenerateLink.php');
            exit();
        }
    }

    public static function main():void
    {
        try {
            $page = new GenerateLink();
            $page->processReceivedData();
            $page->generateView();
        } catch (Exception $e) {
            header("Content-type: text/plain; charset=UTF-8");
            echo $e->getMessage();
        }
    }
}

GenerateLink::main();
