# running-information-analysis-service
Project Title

Running Information Analysis Service:
Part of Nike Running Tracking System.

Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

Prerequisites

docker
Postman: A google chrome App


Installing

1. Download the entire project.
2. Open a terminal, navigate to project folder. 
3. Start docker
4. Run docker image: run "docker-compose up" from terminal
5. Open anther terminal
6. Build project if "target" folder to do exist in the current project.
   run "mvn clean install" from terminal -- project build successfully
7. Run project
   "cd target" folder
   "java -jar [project name]"
   Application starts succefully
   
Running the tests
1. Open Postman, Copy test.json file to the body of postman as raw and Json.
2. Send POST command to http://localhost:8080/analysis
   Postman should show: Status 201 Created
   Data uploaded to mySQL database
   
3. To list entries:
Send GET command to http://localhost:8080/analysis/result?page=0
(page should be a user defined integer number: above example show the first page content)

4. Delete an entry by runningId
Send DELETE command to http://localhost:8080/purge/{runningId}


Built With

Maven - Dependency Management
