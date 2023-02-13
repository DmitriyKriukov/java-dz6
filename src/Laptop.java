public class Laptop {
    int ram;
    int hdd;
    String operatingSystem;
    String color;

    public Laptop(int ram, int hdd, String operatingSystem, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    int getRam() {
        return ram;
    }

    int getHdd() {
        return hdd;
    }

    String getOperatingSystem() {
        return operatingSystem;
    }

    String getColor() {
        return color;
    }

    public String toString() {
        return "ОЗУ: " + ram + "; Объем ЖД: " + hdd + "; Операционная система: " + operatingSystem + "; Цвет: " + color;
    }
}

