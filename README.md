# `Spring Boot` + `React` + `Typescript` + `Hibernate` Boilerplate

![springBoot-logo](utils/images/springBootLogo.png)

![react-logo](utils/images/reactLogo.png)

![typescript-logo](utils/images/typescriptLogo.png)

![hibernate-logo](utils/images/hibernateLogo.png)

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/mr-ufukgurbuz/spring-boot-react-typescript-full-stack-app-demo/tree/main.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/mr-ufukgurbuz/spring-boot-react-typescript-full-stack-app-demo/tree/main)
[![Code Climate](https://codeclimate.com/github/mr-ufukgurbuz/spring-boot-react-typescript-full-stack-app-demo/badges/gpa.svg)](https://codeclimate.com/github/mr-ufukgurbuz/spring-boot-react-typescript-full-stack-app-demo)
[![Issue Count](https://codeclimate.com/github/mr-ufukgurbuz/spring-boot-react-typescript-full-stack-app-demo/badges/issue_count.svg)](https://codeclimate.com/github/mr-ufukgurbuz/spring-boot-react-typescript-full-stack-app-demo)

A boilerplate for `Spring Boot` + `React` + `Typescript` projects with `Hibernate` (`H2` and `MongoDB`)

## Includes:

Front-end:

- `React` and `Typescript` boilerplate files
- `AntD` (Ant Design) React UI library
- `Axios` promise-based HTTP Client

Back-end:

- `SpringBoot` boilerplate files
- `Maven` build project structure
- `Hibernate` Object Oriented Database Management 
- `H2` embedded database integration
- `MongoDB` NoSQL database integration
- `log4j2` new generation logging
- `JUnit` unit tests

## Setup

You should install above technologies and tools to your computer. You can search these instructions in Google.

## Build and Run

First of all you need to configure the database. Properties are located in `./backend/src/main/resources/application.properties` file.

> By default application is using H2 and MongoDB databases.
> 
> `H2` in-memory database (name: `testdb`).
> 
> `MongoDB` database (name: `demo-app-db`, user: `user`, password: `password`).


1. Run `npm clean install --prefix frontend` to install front-end dependencies.
2. Run `npm run build:prod --prefix frontend` to build React/Typescript application.
3. Run `./init_db` to create database, dbuser and dump default schema.
4. Run `mvn clean compile -f backend` to compile a spring boot application.
5. Run `mvn install -f backend` to start spring boot application on embedded server.

> By default `backend server` will be running on port `8080`.

## Development

- `npm start --prefix frontend` to start front-end server for development.
- `npm run start:prod --prefix frontend` to start front-end server with service-workers.
- `mvn install -f backend` to start spring boot application on embedded server.

> By default `frontend server` will be running on port `3000`

## Testing

- `npm test --prefix frontend` - to run front-end unit tests.
- `mvn test -f backend` - to run backend server tests.

## Technologies used

Back-end:
- [spring-boot-starter-web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
- [spring-boot-starter-security](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security)
- [spring-boot-starter-data-jpa](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
- [spring-boot-starter-data-mongodb](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb)
- [spring-boot-starter-hateoas](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-hateoas)
- [h2](https://mvnrepository.com/artifact/com.h2database/h2)
- [spring-kafka](https://mvnrepository.com/artifact/org.springframework.kafka/spring-kafka)
- [spring-boot-starter-log4j2](https://www.postgresql.org/)
- [lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
- [junit](https://mvnrepository.com/artifact/junit/junit)
- [maven](https://maven.apache.org/)

Front-end:
- [react](https://www.npmjs.com/package/react)
- [react-dom](https://www.npmjs.com/package/react-dom)
- [react-redux](https://www.npmjs.com/package/react-redux)
- [react-router-dom](https://www.npmjs.com/package/react-router-dom)
- [react-scripts](https://www.npmjs.com/package/react-scripts)
- [redux](https://www.npmjs.com/package/redux)
- [typescript](https://www.npmjs.com/package/typescript)
- [antd](https://www.npmjs.com/package/antd)
- [axios](https://www.npmjs.com/package/axios)
- [i18next](https://www.npmjs.com/package/i18next)

## License
`springBoot-react-typescript-boilerplate` is released under the [MIT License](https://opensource.org/licenses/MIT).
