package ru.barmatin.homework15.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import ru.barmatin.homework15.service.MilitaryOfficeService;

@Configuration
public class IntegrationConfig {
    private static final int QUEUE_CAPACITY = 10;

    @Bean
    public QueueChannel peopleChannel() {
        return MessageChannels.queue(QUEUE_CAPACITY).get();
    }

    @Bean
    public PublishSubscribeChannel soldiersChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedRate(1000).maxMessagesPerPoll(2).get();
    }

    @Bean
    public IntegrationFlow militaryOfficeFlow(MilitaryOfficeService militaryOfficeService) {
        return IntegrationFlows.from(peopleChannel())
                .handle(militaryOfficeService, "draft")
                .channel(soldiersChannel())
                .get();
    }

}