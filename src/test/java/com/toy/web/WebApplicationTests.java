package com.toy.web;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.HashMap;
import java.util.Objects;

@SpringBootTest
class WebApplicationTests {

	@Autowired
	private MongoTemplate mongo;

	@Test
	void contextLoads() {
		MongoCollection<Document> test = mongo.getCollection("test");

		HashMap<String, Object> map = new HashMap<>();
		map.put("page", 1);
		map.put("perPage", 10);

		test.insertOne(new Document(map));


	}

}
