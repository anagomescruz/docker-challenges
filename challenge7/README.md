# Challenge 7
### Debug running services

In this challenge we'll learn how to
- Run only the specific containers you require for a given goal in docker-compose 
- How to debug running services

Notes: The provided maven projects are only illustrative of what is present in the `.jar` files, there is no need to know how to compile/package/run them

How the services interact:
- `rest_config` is a REST Service 
  - Holds a `Config` resource in a database with a single field `active` 
  - has 2 endpoints 
    - `POST /configs` which expects a json object with a `boolean` value for the field `active` 
      - The env var `org.example.configs-creation-enabled` needs to be set to `true` in order allow the creation of new Configs
    - `GET /configs/{id}` which return the `Config` object with the `id` and `active` fields 
- `rest_main` is a REST Service
  - communicates with `rest_config` 
  - has 1 endpoint, `GET /configs/check/{id}`, which returns a different response according to the `active` field from the `rest_config` service

### End goal
- Test the flow successfully
  - `POST localhost:<config_port>/configs` to create the config
  - `GET localhost:<main_port>/configs/check/{config_id}` to obtain the conditional response

### Challenge - Bring up only the required services
- Identify where the bug is located 
- Using `docker-compose up` start only the required services

### Challenge - Remote debug the problematic service
- Connect through your IDE to the service through remote debug 
- Live debug the problematic endpoint with debug breakpoints in the service
- [Remote debugging hint](https://www.baeldung.com/java-application-remote-debugging)
- **Solution**
  - on docker compose file add the **entrypoint** command and assign it the jar to run in a debug mode:
    - `entrypoint: "java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar rest_config.jar"`
    - run the docker compose for the specific container: `docker compose up config` 
    - we should see a message informing that it's listening in the debug port `Listening for transport dt_socket at address: 5005`
  - on Intellij:
    - open the `rest_config` project -> select `edit configuration` -> new `Remote JVM Debug` and give it a name -> `Apply` and `Ok`. 
    - Then, select the debug button and we should see a message that it's connected to the debug port as well `Connected to the target VM, address: 'localhost:5005', transport: 'socket'`
    - add some breakpoints in the code in order to identify the issue, for example, in `ConfigsResource` class in the `if` condition and check that the env var is always false.
  - using Postam:
    - call the POST `http://0.0.0.0:8080/configs` with the field `active` filled in the body
  - After identified that the problem is regarding with the env var, fix it.
    - we should see this env var `ORG_EXAMPLE_CONFIG_CREATION_ENABLED` and set it to `true`, but we also see that this env has a typo, if we go to the code we saw that the variavel is not `configs` but `config`, so we also need to change it.
  - With all fixed, we can execute the docker compose as usual as test the flow with success.