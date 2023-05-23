package cat.itacademy.barcelonactiva.mosqueda.joseantonio.s04.t02.n02.model.servicies;

import cat.itacademy.barcelonactiva.mosqueda.joseantonio.s04.t02.n02.model.domain.Fruta;

import java.util.List;
import java.util.Optional;

public interface FrutaServiciesInter {

         Fruta add(Fruta fruta);

         Fruta update (int id, Fruta fruta);

         Fruta delete (int id);

         Fruta getOne (int id);

         List<Fruta> getAll ();

}
