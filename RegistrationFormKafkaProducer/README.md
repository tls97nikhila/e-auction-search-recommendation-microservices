# Kafka Producer with Registration

- quickstart
1. start zookeper 
```
> bin/zookeeper-server-start.sh config/zookeeper.properties
```
2. start kakfa in another terminal
```
> bin/kafka-server-start.sh config/server.properties
```
3. start neo4j for recommendations microservice to consume
```
 sudo service neo4j start
```
4. Start registration microservice in intellij

5. Start recommendation microservice in intellij

6. To check producer data in terminal check with..
```
 bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic kakfaExample4 --from-beginning
```


