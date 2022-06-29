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
import ru.barmatin.homework14.domain.h2.AuthorH2;
import ru.barmatin.homework14.domain.h2.BookH2;
import ru.barmatin.homework14.domain.h2.GenreH2;
import ru.barmatin.homework14.domain.mongo.AuthorMongo;
import ru.barmatin.homework14.domain.mongo.BookMongo;
import ru.barmatin.homework14.domain.mongo.GenreMongo;
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
    public MongoItemReader<AuthorMongo> authorReader(MongoTemplate mongoTemplate) {
        return new MongoItemReaderBuilder<AuthorMongo>()
                .name("authorItemReader")
                .template(mongoTemplate)
                .collection("authors")
                .jsonQuery("{}")
                .targetType(AuthorMongo.class)
                .sorts(new HashMap<>())
                .build();
    }

    @StepScope
    @Bean
    public MongoItemReader<GenreMongo> genreReader(MongoTemplate mongoTemplate) {
        return new MongoItemReaderBuilder<GenreMongo>()
                .name("genreItemReader")
                .template(mongoTemplate)
                .collection("genres")
                .jsonQuery("{}")
                .targetType(GenreMongo.class)
                .sorts(new HashMap<>())
                .build();
    }

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
    public ItemProcessor<AuthorMongo, AuthorH2> authorProcessor(MappingService mappingService) {
        return mappingService::authorMongoToH2;
    }

    @StepScope
    @Bean
    public ItemProcessor<GenreMongo, GenreH2> genreProcessor(MappingService mappingService) {
        return mappingService::genreMongoToH2;
    }

    @StepScope
    @Bean
    public ItemProcessor<BookMongo, BookH2> bookProcessor(MappingService mappingService) {
        return mappingService::bookMongoToH2;
    }

    @StepScope
    @Bean
    public JpaItemWriter<AuthorH2> authorWriter(EntityManagerFactory entityManagerFactory) {
        return new JpaItemWriterBuilder<AuthorH2>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }

    @StepScope
    @Bean
    public JpaItemWriter<GenreH2> genreWriter(EntityManagerFactory entityManagerFactory) {
        return new JpaItemWriterBuilder<GenreH2>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }

    @StepScope
    @Bean
    public JpaItemWriter<BookH2> bookWriter(EntityManagerFactory entityManagerFactory) {
        return new JpaItemWriterBuilder<BookH2>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }

    @Bean
    public Step addAuthorsStep(MongoItemReader<AuthorMongo> authorReader, JpaItemWriter<AuthorH2> authorWriter,
                                     ItemProcessor<AuthorMongo, AuthorH2> authorProcessor) {
        return stepBuilderFactory.get("step1")
                .<AuthorMongo, AuthorH2>chunk(CHUNK_SIZE)
                .reader(authorReader)
                .processor(authorProcessor)
                .writer(authorWriter)
                .build();
    }

    @Bean
    public Step addGenresStep(MongoItemReader<GenreMongo> genreReader, JpaItemWriter<GenreH2> genreWriter,
                               ItemProcessor<GenreMongo, GenreH2> genreProcessor) {
        return stepBuilderFactory.get("step2")
                .<GenreMongo, GenreH2>chunk(CHUNK_SIZE)
                .reader(genreReader)
                .processor(genreProcessor)
                .writer(genreWriter)
                .build();
    }

    @Bean
    public Step addBooksStep(MongoItemReader<BookMongo> bookReader, JpaItemWriter<BookH2> bookWriter,
                              ItemProcessor<BookMongo, BookH2> bookProcessor) {
        return stepBuilderFactory.get("step3")
                .<BookMongo, BookH2>chunk(CHUNK_SIZE)
                .reader(bookReader)
                .processor(bookProcessor)
                .writer(bookWriter)
                .build();
    }


    @Bean
    public Job importBookJob(Step addAuthorsStep, Step addGenresStep, Step addBooksStep) {
        return jobBuilderFactory.get(IMPORT_BOOK_JOB_NAME)
                .incrementer(new RunIdIncrementer())
                .flow(addAuthorsStep)
                .next(addGenresStep)
                .next(addBooksStep)
                .end()
                .build();
    }

}