package cat.itacademy.barcelonactiva.Mosqueda.JoseAntonio.s04.t02.n03.S04T02N03MosquedaJoseAntonio.Controller;


import cat.itacademy.barcelonactiva.Mosqueda.JoseAntonio.s04.t02.n03.S04T02N03MosquedaJoseAntonio.Model.Domain.Fruta;
import cat.itacademy.barcelonactiva.Mosqueda.JoseAntonio.s04.t02.n03.S04T02N03MosquedaJoseAntonio.Model.Servicies.FrutaServicies;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruita")
public class FrutaController {

    @Autowired
    FrutaServicies frutaServ;

    ResponseEntity<Fruta> myResponseEntity;
    ResponseEntity<List<Fruta>> myResponseListEntity;

    @PostMapping("/add")
    public ResponseEntity<Fruta> add(@RequestBody Fruta fruta) {
        try {
            Fruta myFruta = frutaServ.add(fruta);
            myResponseEntity = new ResponseEntity<>(myFruta, HttpStatus.OK);
        } catch (Exception e) {
            myResponseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return myResponseEntity;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruta> update(@PathVariable("id") ObjectId id, @RequestBody Fruta fruta) {
        Fruta frutaData = frutaServ.update(id , fruta);

        if (frutaData != null) {
            return new ResponseEntity<>(frutaData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fruta> delete(@PathVariable("id") ObjectId  id) {
        try {
            Fruta fruitdelete = frutaServ.delete(id);
            return new ResponseEntity<>(fruitdelete,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruta> getOne(@PathVariable("id") ObjectId  id) {
        Fruta frutaData = frutaServ.getOne(id);

        if (frutaData!= null) {
            return new ResponseEntity<>(frutaData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruta>> getAll() {

        try {
            List<Fruta> frutaLista = frutaServ.getAll();
            if (frutaLista.isEmpty()){
                myResponseListEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else{
                myResponseListEntity = new ResponseEntity<>(frutaLista,HttpStatus.OK);
            }

        }
        catch (Exception e) {
            myResponseListEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return myResponseListEntity;
    }
}

