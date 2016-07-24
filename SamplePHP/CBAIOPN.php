<?php

include ('config.php');

//logs the request message.
requestlog();

$cba = new CBAIOPNProcessor();

// send the response with 200 OK status
$cba->GenerateResponse();

?>