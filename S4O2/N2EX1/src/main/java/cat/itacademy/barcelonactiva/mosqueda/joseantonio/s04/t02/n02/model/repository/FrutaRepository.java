package cat.itacademy.barcelonactiva.mosqueda.joseantonio.s04.t02.n02.model.repository;

import cat.itacademy.barcelonactiva.mosqueda.joseantonio.s04.t02.n02.model.domain.Fruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrutaRepository extends JpaRepository<Fruta, Integer> {
}
