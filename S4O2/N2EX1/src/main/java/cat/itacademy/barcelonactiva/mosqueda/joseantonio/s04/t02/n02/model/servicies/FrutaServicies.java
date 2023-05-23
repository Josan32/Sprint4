package cat.itacademy.barcelonactiva.mosqueda.joseantonio.s04.t02.n02.model.servicies;

import cat.itacademy.barcelonactiva.mosqueda.joseantonio.s04.t02.n02.model.domain.Fruta;
import cat.itacademy.barcelonactiva.mosqueda.joseantonio.s04.t02.n02.model.repository.FrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FrutaServicies implements FrutaServiciesInter{

    @Autowired
    FrutaRepository frutaRepo;

    @Override
    public Fruta add(Fruta fruta) {
        Fruta myFruta = frutaRepo
                .save(new Fruta(fruta.getId(),fruta.getNombre(), fruta.getCantidadQuilos()));
        return myFruta;
    }

    @Override
    public Fruta update(int id, Fruta fruta) {
        Optional<Fruta> frutaData = frutaRepo.findById(id);
        Fruta myFruta = null;
        if (frutaData.isPresent()) {
            myFruta = frutaData.get();
            myFruta.setNombre(fruta.getNombre());
            myFruta.setCantidadQuilos(fruta.getCantidadQuilos());
        }
        return myFruta;
    }

    @Override
    public Fruta delete(int id) {
            Fruta fruitdelete = frutaRepo.findById(id).get();
            frutaRepo.delete(fruitdelete);
        return fruitdelete;
    }

    @Override
    public Fruta getOne(int id) {
        Optional<Fruta> frutaData = frutaRepo.findById(id);
        Fruta myFruta;
        myFruta = frutaData.orElse(null);
        return myFruta;
    }

    @Override
    public List<Fruta> getAll() {
        List<Fruta> frutaLista = new ArrayList<Fruta>();
        frutaLista.addAll(frutaRepo.findAll());
        return frutaLista;
    }
}
