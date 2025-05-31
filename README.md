# MicroService-Log-Practice
마이크로 서비스 환경, 즉 분산 환경에서 로그를 추적하는 연습 프로젝트 입니다.

## 커밋 규칙
| init | 프로젝트 생성 |
| --- | --- |
| feat | 새로운 기능에 대한 커밋 |
| build | 빌드 관련 파일 수정 / 모듈 설치 또는 삭제에 대한 커밋 |
| chore | 그 외 자잘한 수정에 대한 커밋 |
| docs | 문서 수정에 대한 커밋 |
| style | 코드 스타일 혹은 포맷 등에 관한 커밋 |
| refactor | 코드 리팩토링에 대한 커밋 |
| test | 테스트 코드 수정에 대한 커밋 |
| perf | 성능 개선에 대한 커밋 |

## Centralized Logging with ELK Stack

This project is configured to send application logs from the microservices and API gateway to a centralized ELK (Elasticsearch, Logstash, Kibana) stack via Kafka.

### Prerequisites

*   Docker and Docker Compose installed.
*   A running Kafka instance (the current Logstash configuration expects it at `host.docker.internal:9092`).

### How it Works

1.  **Spring Boot Applications**: Each microservice and the API gateway are configured using `logback-spring.xml` with `logstash-logback-encoder` and `logback-kafka-appender`.
2.  **Log Format**: Logs are formatted as JSON.
3.  **Kafka**: Logs are sent to the `service-logs` topic in Kafka.
4.  **Logstash**:
    *   The Logstash instance (running via Docker Compose) consumes messages from the `service-logs` Kafka topic.
    *   It parses these messages and sends them to Elasticsearch.
    *   Configuration is in `elk-config/logstash/pipeline/logstash.conf`.
5.  **Elasticsearch**: Stores the logs. Data is persisted in a Docker volume (`elasticsearch_data`).
6.  **Kibana**: Provides a UI to explore, visualize, and dashboard the logs.

### Running the ELK Stack

1.  Navigate to the root directory of this project.
2.  Run the command:
    ```bash
    docker-compose up -d
    ```
    This will start Elasticsearch, Logstash, and Kibana in detached mode.
3.  To stop the ELK stack:
    ```bash
    docker-compose down
    ```

### Viewing Logs in Kibana

1.  Access Kibana at [http://localhost:5601](http://localhost:5601).
2.  Follow the instructions in `elk-config/KIBANA_SETUP.md` to create the `service-logs-*` index pattern and start exploring your logs.
