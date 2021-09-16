package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente,String>{
Cliente findByName(String nome);

@Query("{'idade': { $gt: ?0, $lt: ?1 } }")

List<Cliente> findByIdadeBetween(int idadeInicial, int idadeFinal);
}
