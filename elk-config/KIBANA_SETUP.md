# Kibana Setup Instructions

Once the ELK stack is running via `docker-compose up -d`, you can access Kibana and configure it to view your logs.

## 1. Access Kibana

Open your web browser and navigate to [http://localhost:5601](http://localhost:5601).

## 2. Connect to Elasticsearch

Kibana should automatically connect to the Elasticsearch instance defined in `docker-compose.yml` (`http://elasticsearch:9200`). If it prompts, ensure this is the case.

## 3. Create an Index Pattern

To explore your log data, you need to create an index pattern that tells Kibana which Elasticsearch indices to look at.

1.  Once Kibana loads, click on the **menu icon** (hamburger icon) in the top-left corner.
2.  Navigate to **Stack Management** (under Management).
3.  In the Stack Management page, click on **Index Patterns** (under Kibana).
4.  Click on **Create index pattern**.
5.  In the "Index pattern name" field, type `service-logs-*`. This pattern will match the daily indices created by Logstash (e.g., `service-logs-2023.10.27`).
6.  Kibana should indicate that this pattern matches one or more sources. Click **Next step**.
7.  From the "Time field" dropdown, select `@timestamp`. This field is automatically added by Logstash and contains the timestamp of the log entry.
8.  Click **Create index pattern**.

## 4. Explore Your Logs in Discover

Once the index pattern is created, you can explore your logs:

1.  Click on the **menu icon** (hamburger icon) in the top-left corner.
2.  Navigate to **Discover** (under Analytics).
3.  You should see your logs appearing here as they are sent from your microservices through Kafka and Logstash to Elasticsearch.
4.  You can use the search bar to filter logs (e.g., `kubernetes.pod.name: "my-service"`, `level: "ERROR"`) and the time picker to select a time range.

## 5. Example Visualizations (Optional)

You can create visualizations and dashboards to get more insights from your logs.

### Example: Log Counts by Service

1.  Go to **Visualize Library** (under Analytics) from the main menu.
2.  Click **Create visualization**.
3.  Choose a visualization type, e.g., **Lens** or **Pie chart**.
4.  Select your `service-logs-*` index pattern.
5.  **For a Pie Chart:**
    *   Under "Buckets", click "Add" and choose "Terms" aggregation.
    *   For "Field", select `springAppName.keyword` (or the field that contains your service name, check the Discover view for exact field names).
    *   This will show a pie chart with log counts distributed by service name.

### Example: Errors Over Time

1.  Go to **Visualize Library**.
2.  Click **Create visualization**.
3.  Choose **Lens** or **Area/Line chart**.
4.  Select your `service-logs-*` index pattern.
5.  For the X-axis, use a "Date histogram" aggregation on the `@timestamp` field.
6.  For the Y-axis, use a "Count" aggregation.
7.  To filter for errors, add a filter (top of the page or within Lens): `level.keyword : "ERROR"` (adjust field name and value if your log structure differs).

These are basic examples. Kibana is a powerful tool; explore its features to create dashboards tailored to your needs.
