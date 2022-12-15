package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Car implements Serializable {

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
        this.id = id;

    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return model + " " + series;
    }
}
