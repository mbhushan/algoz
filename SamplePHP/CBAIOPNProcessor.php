<?php
/**
* Copyright 2008 Amazon.com, Inc., or its affiliates. All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License").
* You may not use this file except in compliance with the License.
* A copy of the License is located at
*
*    http://aws.amazon.com/apache2.0/
*
* or in the "license" file accompanying this file.
* This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
* either express or implied. See the License for the specific language governing permissions
* and limitations under the License.
*
*
* @brief Class for processing Checkout By Amazon Request 
* @catagory Checkout By Amazon Callback API Sample Code
* @author Bhushan Mani
* @copyright Portions copyright 2007-2008 Amazon Technologies, Inc
* @license Apache License v2.0, please see LICENSE.txt
* @access public
* @version $Id: $
*
*/
class CBAIOPNProcessor{

  var $RequestXML;
  var $Error = '';
  var $ValidateXML = false;
  var $SignedOrder = false;
  var $UUID;
  var $TimeStamp;
  var $NotificationData;
  var $NotificationType;

  function CBAIOPNProcessor(){
  	// Authenticates the request.  	
    
    //Process the request
    $this->ProcessHTTPRequest();
    
    $xml = $this->NotificationData;   

    if(!$this->IsValidXML($xml) or empty($xml)){
      $this->Error = 'INTERNAL_SERVER_ERROR';
      $this->ErrorMessage = INTERNAL_SERVER_ERROR;
    }
    
    $this->RequestXML = simplexml_load_string($xml);
    
	$this->ProcessRequestXML();    
  }

  function GenerateResponse() {
  	header("HTTP/1.0 200 OK");  	
  }
  
  /* Process the POST request and set appropriate flag */
  function ProcessHTTPRequest(){  	    
    if($_GET){    	
    	requestlog();
    	
     if($_GET['Signature']){
        $this->SignedOrder = true;
        $this->Signature = $_GET['Signature'];
      }

     if($_GET['Timestamp']){
        $this->Timestamp = $_GET['Timestamp'];
      }
      
     if($_GET['UUID']){
        $this->UUID = $_GET['UUID'];
      }
      
     if($this->SignedOrder){
      if(!$this->IsValidRequest()){
        $this->Error = 'INTERNAL_SERVER_ERROR';
        $this->ErrorMessage = INTERNAL_SERVER_ERROR;
       }
     }      
     if($_GET['NotificationData']){
        $this->NotificationData = stripslashes($_GET['NotificationData']);
        $this->NotificationType =  $_GET['NotificationType'];
      }else{
        $this->Error = 'INTERNAL_SERVER_ERROR';
        $this->ErrorMessage = INTERNAL_SERVER_ERROR;
      }      
    }
  }
  
  /* validates the xml using the schema file */
  function IsValidXML($xml){
    if($xml){
      $doc = new DOMDocument();
      $doc->loadXML($xml);
      if($doc->schemaValidate(CALLBACK_SCHEMA_FILE)){
        return true;
      }else{
        return false;
      }
    }
  }

  /* checks whether request is valid via signature cmp */
  function IsValidRequest(){    
    $data = $this->UUID . $this->Timestamp;
    $signature = $this->GenerateSignature($data);
    if($signature != $this->Signature){
      $this->Error = 'INTERNAL_SERVER_ERROR';
      $this->ErrorMessage = INTERNAL_SERVER_ERROR;
      return false;
    }else{
      return true;
    }
  }

 /**
  * @brief returns the encrypted order signature
  * @return a based64 encoded encrypted order signature
  * @see HMAC.php
  */
  function GenerateSignature($data){
    $signature_calculator = new Crypt_HMAC(AWS_SECRET_KEY, HMAC_SHA1_ALGORITHM);
    $signature = $signature_calculator->hash($data);
    $binary_signature = pack('H*', $signature);
    return base64_encode($binary_signature);    
  } 
  
  function ProcessRequestXML(){
  	//TODO Merchant fetches the required fields from requestXML.
  }
}
?>
