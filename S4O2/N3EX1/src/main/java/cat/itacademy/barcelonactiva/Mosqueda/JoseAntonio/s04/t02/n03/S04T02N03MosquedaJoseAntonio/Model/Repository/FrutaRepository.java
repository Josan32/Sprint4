package cat.itacademy.barcelonactiva.Mosqueda.JoseAntonio.s04.t02.n03.S04T02N03MosquedaJoseAntonio.Model.Repository;


import cat.itacademy.barcelonactiva.Mosqueda.JoseAntonio.s04.t02.n03.S04T02N03MosquedaJoseAntonio.Model.Domain.Fruta;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FrutaRepository extends MongoRepository<Fruta, ObjectId> {

}
