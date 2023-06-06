import lombok.Getter;
import java.util.Objects;

@Getter
public class Laptop {
    Brand brand;
    String model;
    Integer serialNumber;
    Processor processor;
    HardDrive hardDrivel;
    Integer diagonal;
    Color color;
    public Laptop(Brand brand, String model, Integer serialNumber, Processor processor,
                  HardDrive hardDrivel, Integer diagonal, Color color) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.processor = processor;
        this.hardDrivel = hardDrivel;
        this.diagonal = diagonal;
        this.color = color;
    }
    @Override
    public String toString() {
        return "Laptop{" +
                "brand=" + brand +
                ", model=" + model +
                ", serial number=" + serialNumber +
                ", processor=" + processor +
                ", hard drive=" + hardDrivel +
                ", diagonal=" + diagonal +
                ", color=" + color +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return brand == laptop.brand && Objects.equals(model, laptop.model) && Objects.equals(serialNumber, laptop.serialNumber) &&
               processor == laptop.processor && hardDrivel == laptop.hardDrivel && Objects.equals(diagonal, laptop.diagonal) &&
               color == laptop.color;
    }
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, serialNumber, processor, hardDrivel, diagonal, color);
    }
}
