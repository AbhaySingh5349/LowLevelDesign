package Questions.KafkaQueue;

import Questions.KafkaQueue.enums.TopicName;
import Questions.KafkaQueue.model.Topic;
import Questions.KafkaQueue.repository.ConsumerRepository;
import Questions.KafkaQueue.repository.ProducerRepository;
import Questions.KafkaQueue.repository.TopicRepository;
import Questions.KafkaQueue.service.ConsumerService;
import Questions.KafkaQueue.service.ProducerService;
import Questions.KafkaQueue.service.TopicService;
import Questions.KafkaQueue.strategy.PlainTextMessageContent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TopicRepository topicRepository = new TopicRepository();
        TopicService topicService = new TopicService(topicRepository);
        topicService.createTopic(TopicName.TOPIC_1);
        topicService.createTopic(TopicName.TOPIC_2);

        ProducerRepository producerRepository = new ProducerRepository();
        ProducerService producerService = new ProducerService(producerRepository, topicService);
        producerService.createProducer("producer1");
        producerService.createProducer("producer2");

        producerService.publish("producer1",new PlainTextMessageContent("message1"),TopicName.TOPIC_1);
        producerService.publish("producer1",new PlainTextMessageContent("message2"),TopicName.TOPIC_1);
        producerService.publish("producer1",new PlainTextMessageContent("message4"),TopicName.TOPIC_2);
        producerService.publish("producer2",new PlainTextMessageContent("message3"),TopicName.TOPIC_1);
        producerService.publish("producer2",new PlainTextMessageContent("message5"),TopicName.TOPIC_2);

        ConsumerRepository consumerRepository = new ConsumerRepository();
        ConsumerService consumerService = new ConsumerService(consumerRepository, topicService);
        for (int i = 1; i <= 5; i++) {
            consumerService.createConsumer("consumer" + i);
        }

        consumerService.subscribeToTopic("consumer1",TopicName.TOPIC_1);
        consumerService.subscribeToTopic("consumer2",TopicName.TOPIC_1);
        consumerService.subscribeToTopic("consumer3",TopicName.TOPIC_1);
        consumerService.subscribeToTopic("consumer4",TopicName.TOPIC_1);
        consumerService.subscribeToTopic("consumer5",TopicName.TOPIC_1);

        consumerService.subscribeToTopic("consumer1",TopicName.TOPIC_2);
        consumerService.subscribeToTopic("consumer3",TopicName.TOPIC_2);
        consumerService.subscribeToTopic("consumer4",TopicName.TOPIC_2);

        Runnable job = ()->{
            consumerService.pullMessages();
        };

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule the job to run at a fixed interval of 5 seconds
        scheduler.scheduleAtFixedRate(job, 0, 5, TimeUnit.SECONDS);

        ScheduledExecutorService shutdownScheduler = Executors.newSingleThreadScheduledExecutor();
        shutdownScheduler.schedule(() -> {
            System.out.println("Shutting down the scheduler...");
            scheduler.shutdown();
            shutdownScheduler.shutdown(); // Also shut down the shutdownScheduler itself
        }, 15, TimeUnit.SECONDS);

        producerService.publish("producer2",new PlainTextMessageContent("new_message1"),TopicName.TOPIC_2);
        producerService.publish("producer2",new PlainTextMessageContent("new_message2"),TopicName.TOPIC_2);
    }
}
