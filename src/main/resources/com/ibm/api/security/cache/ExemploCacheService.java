package cache;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExemploCacheService {
private static final Logger log = LoggerFactory.getILoggerFactory(ExemploCacheService.class);


@Cacheable("exemploCache")
public String exemploCache() {
	log.info("### Executando o serviço...");
	return "Teste de exemplo de cache";
}
}
