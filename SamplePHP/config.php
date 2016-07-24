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
* @brief Configuration File
* @catagory Checkout By Amazon  - Configuration 
* @author Bhushan Mani
* @version $Id: $
*
*/
define("LIB",'lib/');

// libraries required to communicate in SOAP
ini_set('include_path','.:' .
                       LIB . ':' .
                       LIB . 'XML_Serializer-0.19.0:' .
                       LIB . 'XML_Util-1.2.1:' .
                       LIB . 'PEAR-1.7.2/PEAR:' .
                       ini_get('include_path'));


define('DEBUG',false);

/*
 *  Please edit these settings
 */ 

//AWS Secret Key, 
define('AWS_ACCESS_KEY',''); // you can get this from http://sellercentral.amazon.com > Integration > Access Key */
define('AWS_SECRET_KEY',''); // you can get this from http://sellercentral.amazon.com > Integration > Access Key */

/*
 *  Please *do not* edit the following settings
 */

define("XMLNS_VERSION_TAG", 'http://payments.amazon.com/checkout/2008-11-30/');

/* POST form keys sent from Checkout by Amazon. */
define("REQUEST_KEY","order-calculations-request");
define("REQUEST_UUID_KEY","UUID");
define("REQUEST_TIMESTAMP_KEY","Timestamp");
define("REQUEST_SIGNATURE_KEY","Signature");

/* Signature Algorithm used. */
define("HMAC_SHA1_ALGORITHM","sha1");

/* Schema Files */
define('EVENT_NOTIFICATION_SCHEMA_FILE','schema/eventNotification.xsd');


//Path setting
define("LOG_DIR",'log/');
define('LOG_FILE', LOG_DIR . 'cbaiopn.log');

$payment_url_array = array(
                           'SANDBOX' => 'https://payments-sandbox.amazon.com/checkout/',
                           'PROD' => 'https://payments.amazon.com/checkout/',
                           );


//including the required files
require_once (LIB . 'Crypt_HMAC-1.0.1/HMAC.php');
require_once (LIB . 'PEAR-1.7.2/PEAR/PEAR.php');
require_once (LIB . 'XML_Serializer-0.19.0/XML/Serializer.php');
require_once ('CBAUtils.php');

if(!DEBUG){
  error_reporting(1);
}
require_once(LIB . 'CBAIOPNProcessor.php');
?>