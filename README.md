<h1 align="center"> API Médico e Paciente </h1>

<h4 align="center"> 🚧 Under construction... </h4>



# Simple CRUD
This repository contains a simple CRUD project built using Java Spring.

This project was built during an Alura course as part of my studies.

## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [API Endpoints](#api-endpoints)
- [Database](#database)

## Installation

1. Clone the repository:

```bash
$ git clone https://github.com/SEU_USUARIO/API_Medico_Paciente.git
```

2. Install dependencies with Maven

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080


## API Endpoints
The API provides the following endpoints:

```markdown
GET /medicos - Retrieve a list of all data.

POST /medicos - Register a new data.

PUT /medicos - Alter data.

DELETE /medicos/{id} - Inactivate data.
```

```markdown
GET /pacientes - Retrieve a list of all data.

POST /pacientes - Register a new data.

PUT /pacientes - Alter data.

DELETE /pacientes/{id} - Inactivate data.
```

## Database
The project uses MySql as the database. The necessary database migrations are managed using Flyway.

To install MySql locally you can [click here](https://dev.mysql.com/downloads/installer/).
