<?php declare(strict_types=1);
// UTF-8 marker äöüÄÖÜß€
require_once './Page.php';

class CalculateHash extends Page
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
    }

    protected function generateView():void
    {
       echo '<p>' . hash('crc32','heallo'). '</p>';
        echo <<< HTML
       <header>
        <nav>
                    <a href="#">Home</a>| <a href="#">product</a>| <a href="#">company</a>| <a href="#">Blog</a>
        </nav>
            <h1>LINK SCHORTNER !</h1>
       </header>
            <hr>
           
            <form action="CalculateHash.php" method="get" accepted-charset="utf-8">
                <input type="text" name="newURL" value="" placeholder="URL" required>
                <input type="submit" value="Send">
                <h1>SEND URL AND WE SCHORTER IT FOR YOU!</h1>
                <output type="text" name="Hash" value="" placeholder="Hash" required>
            </form>
            <footer> H-DA EWA 2021 </footer>
 HTML;
    }

    protected function processReceivedData():void
    {
        parent::processReceivedData();
    }

    public static function main():void
    {
        try {
            $page = new CalculateHash();
            $page->processReceivedData();
            $page->generateView();
        } catch (Exception $e) {
            header("Content-type: text/plain; charset=UTF-8");
            echo $e->getMessage();
        }
    }
}

CalculateHash::main();
