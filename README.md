#### Multiple Datasources

One project, two distinct databases   
That's the scenario   
You can check out the more detailed explanation on my blog and other channels

#### Before we start
You'll need
- Docker
- Java 17
- Access to a terminal, at minimum

#### Spin Up a container
First things first, please, execute the docker-compose.yaml file   
located at root dir:

```bash
docker compose up -d
```

Also, you'll need to guarantee the following port's availability:
- 8080 -> for the application
- 3309 -> Fish db
- 3307 -> Shipping db

#### How to build?
After the cloning process, at the project's root dir   
Execute the following on your terminal:

@ Windows

``` bash
 .\mvnw.cmd clean package
```

@ Linux-like
``` bash
 ./mvnw clean package
```

#### Endpoints

> http://localhost:8080/shipping
```json
[
    {
      "id": 1,
      "name": "Naersk"
    }
]
```
> http://localhost:8080/fish
```json
[
    {
      "id": 1,
      "name": "peppermint angelfish"
    }
]
```