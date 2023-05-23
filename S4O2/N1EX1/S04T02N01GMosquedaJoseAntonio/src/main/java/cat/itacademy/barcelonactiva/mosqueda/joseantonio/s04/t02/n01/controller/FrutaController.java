package cat.itacademy.barcelonactiva.mosqueda.joseantonio.s04.t02.n01.controller;


import cat.itacademy.barcelonactiva.mosqueda.joseantonio.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.mosqueda.joseantonio.s04.t02.n01.model.repository.FrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/fruita")

public class FrutaController {

    @Autowired
    FrutaRepository frutaRepo;

    @PostMapping("/add")
    public ResponseEntity<Fruta> add(@RequestBody Fruta fruta) {
        try {
            Fruta myFruta = frutaRepo
                    .save(new Fruta(fruta.getId(),fruta.getNombre(), fruta.getCantidadQuilos()));
            return new ResponseEntity<>(myFruta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruta> update(@PathVariable("id") int id, @RequestBody Fruta fruta) {
        Optional<Fruta> frutaData = frutaRepo.findById(id);

        if (frutaData.isPresent()) {
            Fruta myFruta = frutaData.get();
            myFruta.setNombre(fruta.getNombre());
            myFruta.setCantidadQuilos(fruta.getCantidadQuilos());
            return new ResponseEntity<>(frutaRepo.save(myFruta), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fruta> delete(@PathVariable("id") int id) {
        try {
            Fruta fruitdelete = frutaRepo.findById(id).get();
            frutaRepo.delete(fruitdelete);
            return new ResponseEntity<>(fruitdelete,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruta> getOne(@PathVariable("id") int id) {
        Optional<Fruta> frutaData = frutaRepo.findById(id);

        if (frutaData.isPresent()) {
            return new ResponseEntity<>(frutaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruta>> getAll(@RequestParam(required = false) String title) {
        List<Fruta> frutaLista = new ArrayList<Fruta>();
        try {
            frutaLista.addAll(frutaRepo.findAll());

            if (frutaLista.isEmpty()){
                frutaRepo.findAll().forEach(frutaLista::add);
        }
            return new ResponseEntity<>(frutaLista, HttpStatus.OK);

        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
