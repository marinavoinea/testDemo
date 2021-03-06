package sc.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sc.dao.StoreMongoDao;

/**
 * define mock bean to be used via ingestion
 * using annotations as opposed to XML config
 * @author marina
 *
 */
@Configuration 
public class TestRestServiceConfig {

    @Bean
    public StoreMongoDao storeMongoDaoMock() {
        return Mockito.mock(StoreMongoDao.class);
    }

   
}
