# 

## Model
www.msaez.io/#/189596125/storming/93e55621aef16e5cfc7076f172bcdb3a

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- signup
- writemanage
- ai
- point
- libraryplatform
- subscribemanage
- authormanage
- outside


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- signup
```
 http :8088/users userId="userId"loginId="loginId"loginPassword="loginPassword"
```
- writemanage
```
 http :8088/writes writeId="writeId"userId="userId"authorStatus="authorStatus"title="title"content="content"
 http :8088/books bookId="bookId"originWriteId="originWriteId"userId="userId"title="title"content="content"
 http :8088/authorInfos userId="userId"authorStatus="authorStatus"name="name"
```
- ai
```
 http :8088/coverDesigns bookId="bookId"userId="userId"updatedAt="updatedAt"title="title"imageUrl="imageUrl"generatedBy="generatedBy"createdAt="createdAt"
 http :8088/contentAnalyzers bookId="bookId"userId="userId"content="content"language="Language"maxLength="maxLength"classificationType="classificationType"requestedBy="requestedBy"
```
- point
```
 http :8088/points userId="userId"point="point"isKt="isKT"
```
- libraryplatform
```
 http :8088/libraries bookId="bookId"userId="userId"bookTitle="bookTitle"author="author"summary="summary"imageUrl="imageUrl"publishDate="publishDate"viewCount="viewCount"rank="rank"bestseller="bestseller"category="category"tags="tags"
 http :8088/myLibraries userId="userId"point="point"isSubscribe="isSubscribe"bookId="bookId"isBuy="isBuy"
```
- subscribemanage
```
 http :8088/subscribers userId="userId"point="point"isSubscribe="isSubscribe"
```
- authormanage
```
 http :8088/authors userId="userId"authorStatus="authorStatus"name="name"portfolioUrl="portfolioUrl"
```
- outside
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
