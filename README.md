### [ Software Requirements ]
- MongoDB Server
- Java 17
- Maven 3+


### [ MongoDB Setup ]
#### Note: If you already installed mongoDB, you can skip this step
1. Install mongodb server and start the server
    - `sudo apt-get install -y mongodb-org`
    - `sudo systemctl start mongod`
2. Note: By default, a MongoDB instance stores:
    - its data files in `/var/lib/mongodb`
    - its log files in `/var/log/mongodb`
3. install monogodb client - mongo compass
    - [mongoDB-compass](https://www.mongodb.com/try/download/compass)

### [ Running Application]
1. Download this project.
2. Run the application using this command line `mvn clean install && mvn spring-boot:run`