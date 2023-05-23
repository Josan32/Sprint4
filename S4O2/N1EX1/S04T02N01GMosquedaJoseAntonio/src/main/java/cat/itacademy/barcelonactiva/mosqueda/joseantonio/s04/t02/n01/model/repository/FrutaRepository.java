package cat.itacademy.barcelonactiva.mosqueda.joseantonio.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.mosqueda.joseantonio.s04.t02.n01.model.domain.Fruta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrutaRepository extends JpaRepository<Fruta, Integer> {
}
