package cat.itacademy.barcelonactiva.mosqueda.joseantonio.s04.t02.n01.model.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "Frutas")
public class Fruta {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidadQuilos")
    private int cantidadQuilos;

    public Fruta() {

    }

    public Fruta(int id, String nombre, int cantidadQuilos) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadQuilos = cantidadQuilos;
    }

    public int getId() {
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
