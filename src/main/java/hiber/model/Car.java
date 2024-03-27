package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "series")
    private int series;
    @Column(name = "model")
    private String model;
    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {

    }

    public void setSeries(int series) {
        this.series = series;
    }

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return series == car.series && Objects.equals(id, car.id) && Objects.equals(model, car.model) && Objects.equals(user, car.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, series, model, user);
    }

}
