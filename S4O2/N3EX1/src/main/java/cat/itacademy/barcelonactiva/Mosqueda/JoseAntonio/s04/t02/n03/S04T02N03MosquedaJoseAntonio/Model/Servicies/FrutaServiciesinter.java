package cat.itacademy.barcelonactiva.Mosqueda.JoseAntonio.s04.t02.n03.S04T02N03MosquedaJoseAntonio.Model.Servicies;


import cat.itacademy.barcelonactiva.Mosqueda.JoseAntonio.s04.t02.n03.S04T02N03MosquedaJoseAntonio.Model.Domain.Fruta;
import org.bson.types.ObjectId;

import java.util.List;

public interface FrutaServiciesinter {

    Fruta add(Fruta fruta);

    Fruta update (ObjectId  id, Fruta fruta);

    Fruta delete (ObjectId id);

    Fruta getOne (ObjectId  id);

    List<Fruta> getAll ();
}
