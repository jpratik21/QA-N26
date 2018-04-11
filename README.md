Task 1
============
`Task 1` folder contains test suite for Monefy Android application.

Task 2
============
`Task 2` folder contains test suite in Microsoft Excel format. Summary:

* Test cases are prioritized as per business impact and they should be automated based on their priority.
* Test cases are automated considering following levels:
	
	- Functional Level: Improves feature stability but may not reflect end-user experience with the app
	- User Interface Level: Improves user experience but requires frequent update as api(s)/libraries change often
	
Task 3 
=============
Using Rest-Assured library, I've written automated test cases for REST API endpoints. These test cases primarily focusses on correct functionality of endpoints.


Setup Instructions
----------------------

1. Download and install [Eclipse IDE for Java](https://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/indigo)
2. Make sure the Bestbuy API playground server is running
3. Clone this repo:
```
git clone https://github.com/jpratik21/QA-N26.git
```
4. Import cloned repo in step 3 as Java project in Eclipse:
	- File->Import->Existing Projects into Workspace 
	- Choose `QA-N26` folder
5. Download Rest-Assured Jars `rest-assured-3.0.6-dist.zip` from [here](https://github.com/rest-assured/rest-assured/wiki/Downloads)
6. Unzip the file downloaded in step. Further, unzip `*-deps.zip` file inside it.
7. Add above jars into your project's build path: 
	Right click on Project -> Properties->Java Build Path->Add External Jars
	Choose `rest-assured-*.jar` and all the jars inside `*-deps` folder.
	
Run Automated Tests from Eclipse
----------------------
Right click on the project folder -> Run As -> JUnit Test