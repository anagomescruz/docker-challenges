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



