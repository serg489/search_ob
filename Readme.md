# Demo test
ALMA Technical Assessment TheALMA Archive Query interface (ASAX), hosted at https://almascience.eso.org/asax, isa public web application for searching and downloading observation data

Test Scenario: We want to automate the webbrowser interaction to (1.) searchfor anexistingObservation Unit Set (OUS) and (2.) verify that it returns at least 1 observing target for this observation

### Additional Information
Using default Page object pattern for pages, with custom web elements for better DOM elements interaction control. Driver invocation is done via fabric that can be updated to use remote driver creation.

Stack is Java as one of the most popular language for Automation testers and Selemium, as most commonly used open spirce  Ui automation tool with great community support

### Build:

1. Git clone repo 
2. Launch mvn test

## Report test

Report test can be found under /taget/surefire-reports/index.html
