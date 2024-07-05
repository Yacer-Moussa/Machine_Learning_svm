<?php declare(strict_types=1);
// UTF-8 marker äöüÄÖÜß€
require_once './Page.php';

class Forward extends Page
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
        $this->generatePageHeader('to do: change headline');

        $this->generatePageFooter();
    }


    protected function processReceivedData():void
    {
        parent::processReceivedData();
    }

    public static function main():void
    {
        try {
            $page = new Forward();
            $page->processReceivedData();
            $page->generateView();
        } catch (Exception $e) {
            header("Content-type: text/plain; charset=UTF-8");
            echo $e->getMessage();
        }
    }
}

Forward::main();
