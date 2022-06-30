package ru.barmatin.homework14.config;


import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.data.builder.MongoItemReaderBuilder;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.barmatin.homework14.domain.h2.BookH2;
import ru.barmatin.homework14.domain.mongo.BookMongo;
import ru.barmatin.homework14.service.MappingService;
import javax.persistence.EntityManagerFactory;
import java.util.HashMap;

@Configuration
@EnableBatchProcessing
public class JobConfig {
    private static final int CHUNK_SIZE = 5;
    public static final String IMPORT_BOOK_JOB_NAME = "importBookJob";

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @StepScope
    @Bean
    public MongoItemReader<BookMongo> bookReader(MongoTemplate mongoTemplate) {
        return new MongoItemReaderBuilder<BookMongo>()
                .name("bookItemReader")
                .template(mongoTemplate)
                .collection("books")
                .jsonQuery("{}")
                .targetType(BookMongo.class)
                .sorts(new HashMap<>())
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<BookMongo, BookH2> bookProcessor(MappingService mappingService) {
        return mappingService::bookMongoToH2;
    }

    @StepScope
    @Bean
    public JpaItemWriter<BookH2> bookWriter(EntityManagerFactory entityManagerFactory) {
        return new JpaItemWriterBuilder<BookH2>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }

    @Bean
    public Step addBooksStep(MongoItemReader<BookMongo> bookReader, JpaItemWriter<BookH2> bookWriter,
                              ItemProcessor<BookMongo, BookH2> bookProcessor) {
        return stepBuilderFactory.get("step1")
                .<BookMongo, BookH2>chunk(CHUNK_SIZE)
                .reader(bookReader)
                .processor(bookProcessor)
                .writer(bookWriter)
                .build();
    }

    @Bean
    public Job importBookJob(Step addBooksStep) {
        return jobBuilderFactory.get(IMPORT_BOOK_JOB_NAME)
                .incrementer(new RunIdIncrementer())
                .flow(addBooksStep)
                .end()
                .build();
    }

}