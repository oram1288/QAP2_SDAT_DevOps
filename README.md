Golf Club Tournament and Membership Management API
This project API is for managing golf club members and tournaments. It provides endpoints for adding and retrieving members and tournaments, adding members to tournaments, and performing advanced searches. The application is built using Spring Boot and integrates with a MySQL. Docker support is included for easy setup and deployment.

Features:

Member Management
- Add a new member
- Retrieve all member details
- Delete a member
Search members by:
- Id
- Name
- Membership type
- Phone number

Tournament Management
- Add a new tournament
- Retrieve all tournament details
- Delete a tournament
Search tournaments by:
- Id
- Start date
- Location
- List all members in a tournament


Running the Project with Docker:
- Docker installed on your machine
- MySQL configured

Set up Enivornment
- Create your DockerFile
- Create your docker-compose.yml file and configure the image name for your api, your MySQL database name, and your password.

Build and Run Docker Containers
Step 1: Build the Docker Images:
- docker build -t golf-club-api .
Step 2: Run the Docker Containers:
- docker compose up
