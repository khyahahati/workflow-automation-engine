# Workflow Automation Engine

A lightweight backend system that demonstrates how to build a workflow automation engine using **Spring Boot**, **PostgreSQL**, Docker, and clean layered architecture.

This repository walks through setting up Workflows and Tasks, exposing REST APIs, persisting records to a relational database, and testing everything using `curl`.

---

## Project Overview

This backend service provides the ability to:

* Create new workflows
* Add tasks to workflows
* Update workflow and task statuses
* Create standalone tasks
* Fetch workflows and tasks through REST APIs
* Persist all data inside PostgreSQL via Spring Data JPA

The project is intentionally simple and designed to be extended with additional capabilities.

---

## Technologies & Tools Used

| Tool                                                                                                        | Description                             |
| ----------------------------------------------------------------------------------------------------------- | --------------------------------------- |
| ![](https://img.shields.io/badge/-Java%2021-007396?logo=openjdk\&logoColor=white\&style=flat-square)        | Language used to build the application  |
| ![](https://img.shields.io/badge/-Spring%20Boot-6DB33F?logo=springboot\&logoColor=white\&style=flat-square) | Backend framework                       |
| ![](https://img.shields.io/badge/-PostgreSQL-4169E1?logo=postgresql\&logoColor=white\&style=flat-square)    | Relational database                     |
| ![](https://img.shields.io/badge/-Docker-2496ED?logo=docker\&logoColor=white\&style=flat-square)            | Running PostgreSQL using Docker Compose |
| ![](https://img.shields.io/badge/-YAML-000080?logo=yaml\&logoColor=white\&style=flat-square)                | Configuration for Docker/Postgres       |
| ![](https://img.shields.io/badge/-cURL-073551?logo=curl\&logoColor=white\&style=flat-square)                | Testing REST APIs                       |

---

## How the Engine Works

### Domain Layer

* Defines `Workflow` and `Task` entities
* One-to-many relationship between Workflow → Tasks

### Repository Layer

* JPA repositories handling CRUD operations

### Service Layer

* Contains business logic for managing workflows and tasks

### Controller Layer

* REST endpoints exposing API operations

---

## Setup & Usage

### 1. Clone the Repository

```bash
git clone https://github.com/<your-username>/workflow-automation-engine.git
cd workflow-automation-engine
```

### 2. Start PostgreSQL (via Docker Compose)

```bash
docker-compose up -d
```

### 3. Run the Spring Boot App

```bash
mvn spring-boot:run
```

Server runs at:

```
http://localhost:8080
```

---

## Testing the API (using cURL)

### Create a Workflow

```bash
curl -X POST "http://localhost:8080/api/workflows" \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"My First Workflow\", \"status\":\"PENDING\"}"
```

### Get Workflow by ID

```bash
curl "http://localhost:8080/api/workflows/1"
```

### List All Workflows

```bash
curl "http://localhost:8080/api/workflows"
```

### Add Task to Workflow

```bash
curl -X POST "http://localhost:8080/api/workflows/1/tasks" \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"Task A\", \"status\":\"PENDING\"}"
```

### Update Workflow Status

```bash
curl -X PUT "http://localhost:8080/api/workflows/1/status?status=COMPLETED"
```

### Create a Standalone Task

```bash
curl -X POST "http://localhost:8080/api/tasks" \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"Loose Task\", \"status\":\"PENDING\"}"
```

### Get Task by ID

```bash
curl "http://localhost:8080/api/tasks/1"
```

### Update Task Status

```bash
curl -X PUT "http://localhost:8080/api/tasks/1/status?status=IN_PROGRESS"
```

---
