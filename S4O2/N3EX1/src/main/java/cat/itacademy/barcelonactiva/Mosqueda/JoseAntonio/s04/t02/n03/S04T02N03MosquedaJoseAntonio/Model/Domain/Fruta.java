package cat.itacademy.barcelonactiva.Mosqueda.JoseAntonio.s04.t02.n03.S04T02N03MosquedaJoseAntonio.Model.Domain;

import jakarta.persistence.*;
import org.bson.types.ObjectId;

@Entity
@Table(name = "Frutas")
public class Fruta {

    @Id
    @GeneratedValue
    private ObjectId id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidadQuilos")
    private int cantidadQuilos;

    public Fruta() {

    }

    public Fruta(ObjectId  id, String nombre, int cantidadQuilos) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadQuilos = cantidadQuilos;
    }

    public ObjectId  getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadQuilos() {
        return cantidadQuilos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadQuilos(int cantidadQuilos) {
        this.cantidadQuilos = cantidadQuilos;
    }

    @Override
    public String toString() {
        return "Fruta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidadQuilos=" + cantidadQuilos +
                '}';
    }

}
