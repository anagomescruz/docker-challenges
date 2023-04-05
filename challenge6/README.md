# Challenge 6

### Run REST and DB services which communicate with each other

In this challenge we'll learn how to

- Run several services which communicate with each other
- Alternative to docker build
- Override entrypoint of an image
- Handle several Dockerfiles in a single location

Notes: The provided maven projects are only illustrative of what is present in the `.jar` files, there is no need to know how to compile/package/run them

How the services interact:

- `rest_config` is a REST Service
  - Holds a `Config` resource in a database with a single field `active`
  - has 2 endpoints
    - `POST /configs` which expects a json object with a `boolean` value for the field `active`
    - `GET /configs/{id}` which return the `Config` object with the `id` and `active` fields
- `rest_main` is a REST Service
  - communicates with `rest_config`
  - has 1 endpoint, `GET /configs/check/{id}`, which returns a different response according to the `active` field from the `rest_config` service
- database is postgresql

### Create containers for the services and database that communicate with each other

- `rest_config` communicates with the database
- `rest_main` communicates with `rest_config`
- `rest_config` and `rest_main` need to be exposed to interact with
- Test your configuration

  - `POST localhost:<config_port>/configs` to create the config
  - `GET localhost:<main_port>/configs/check/{config_id}` to obtain the conditional response

### Don't use `docker build` in the configuration process of the previous step

- Run the containers of the previous step without creating the image with `docker build`

### Extra challenges

- Give the database a container name different from the service name
  - **Solution**
    - add `container_name:NAME_WE_WANT`
- Give the database an alias and use it exclusively for communication
  - **Solution**
    - add on the restConfig service: 
    `links: - "database:hello" `
    - change the env var `QUARKUS_DATASOURCE_JDBC_URL` to use the alias `hello` instead of the service name
    - [Docker link](https://docs.docker.com/compose/compose-file/compose-file-v3/#links)
- Guarantee that no service is blocked by another
  - **Solution**
    - Use `depends_on`
- Change the service entrypoint of the `rest_main`
  - **Solution**
    -  add `entrypoint: entrypoint ` on the restMain service
