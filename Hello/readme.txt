CHECKOUT BY AMAZON MERCHANT CALLBACK SAMPLE SERVLET
Copyright: 2007-2008 Amazon Technologies, Inc
*-*-**-***-*****-********-*************
 
*-*-**-***-*****-********-*************
CONTENT SECTIONS (in order of appearance)
*-*-**-***-*****-********-*************
	INTRODUCTION
	PREREQUISITES
	RELEASE NOTES
	SUPPORT & PROJECT HOME
	LINKS
*-*-**-***-*****-********-*************
INTRODUCTION
*-*-**-***-*****-********-*************

Please understand that by installing Checkout by Amazon Callback
sample servlet code, you are agreeing to understand and abide by the
terms of the license, as written in LICENSE.txt.  Important links are
grouped together in a separate section for your convenience.  The most
current documentation on Checkout by Amazon can be found on its
website.

*-*-**-***-*****-********-*************
INCLUDED FILES
*-*-**-***-*****-********-*************

* MerchantEndPoint/    - Directory to copy to your tomcat server.
  * index.jsp	       - Cart example and callback test page.
  * castor/	       - Castor files for callback server.
  * MockCart/	       - Sample Carts for the test page.
  * prop/              - Property files for the callback server.
    * log4j.properties - Callback server logging settings.
    * merchant.properties.blank - Template for merchant.properties.
  * WEB-INF/lib/       - Callback server jars; third-party libraries.
* MockCart/            - Sample Carts.
* MockResponse/        - Sample Responses, used with tests.
* MockRequest/         - Sample Requests your server will recieve from Amazon (for testing).
* test/                - Code for testing the callback server.
* src/                 - Source for the callback server.
* INSTALLATION_GUIDE.txt - Installation and Usage guide.
* LICENSE.txt          - Apache License this code is licensed under.
* README.txt           - This file.
* castor/              - Castor files for the callback server.
* lib/                 - Third party libraries and licensing information.

*-*-**-***-*****-********-*************
PREREQUISITES
*-*-**-***-*****-********-*************
Please have the following software packages available on your systems
before running the demo.

1. Java 1.5 or greater
2. IE 7+ or Firefox 2+. 

*-*-**-***-*****-********-*************
Third Party Libaries
*-*-**-***-*****-********-*************
The following third party libararies are 
used in this sample code. Licenses for each 
package can be find in NOTICE.txt and for
each package separately in lib/.

* Apache lg4j 1.2
* Castor 1.2
* Sun j2ee 5.0
* Jakarta Commons Codec 1.3
* Jakarta Commons Httpclient 3.1
* Jakarta Commons Logging 1.1
* JUnit 3.8.2
* Xerces 2.9.1

*-*-**-***-*****-********-*************
RELEASE NOTES 
*-*-**-***-*****-********-*************
(1) Carefully follow all instructions in INSTALLATION_GUIDE.txt 
(2) You must have set up an Amazon Seller account & have your merchantID
(3) You must have set up an AWS account, and have your AWS keys ready to use in
    the demo. To read more about an AWS account, please view Seller Central help: 
    https://sellercentral.amazon.com/gp/help/

*-*-**-***-*****-********-*************
SUPPORT & PROJECT HOME
*-*-**-***-*****-********-*************
	The latest documentation on Checkout by Amazon can be found at in the LINKS section below.
*-*-**-***-*****-********-*************
LINKS
*-*-**-***-*****-********-*************
	Checkout by Amazon Documentation & Seller Central
		https://sellercentral.amazon.com/gp/help/ 
