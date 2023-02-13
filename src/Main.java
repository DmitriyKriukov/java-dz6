import java.util.*;

public class Main {
    public static void main(String[] args) {
    /*
    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    Создать множество ноутбуков.
    Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
    отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру,
    соответствующую необходимому критерию:
    1 - ОЗУ
    2 - Объем ЖД
    3 - Операционная система
    4 - Цвет …
    Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации
    можно также в Map.
    Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
    */
        Scanner scanner = new Scanner(System.in);
        printFilterLaptop(listLaptops(), requestFilters(scanner));
        scanner.close();
    }


    static HashMap<Integer, String> requestFilters(Scanner scanner) {
        HashMap<Integer, String> filters = new HashMap<>();
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    Введите цифру,соответствующую необходимому критерию:
                    1 - ОЗУ
                    2 - Объем ЖД
                    3 - Операционная система
                    4 - Цвет
                    0 - Показать результат""");
            int number = scanner.nextInt();
            switch (number) {
                case 1 -> {
                    System.out.println("Введите размер оперативной памяти в Гб: ");
                    filters.put(1, scanner.next());
                }
                case 2 -> {
                    System.out.println("Введите объем жесткого диска в Гб: ");
                    filters.put(2, scanner.next());
                }
                case 3 -> {
                    System.out.println("Введите операционную систему: ");
                    filters.put(3, scanner.next().toLowerCase());
                }
                case 4 -> {
                    System.out.println("Введите цвет: ");
                    filters.put(4, scanner.next().toLowerCase());
                }
                case 0 -> flag = false;
                default -> System.out.println("Неверный ввод");
            }
        }
        return filters;
    }

    static void printFilterLaptop(Set<Laptop> laptops, HashMap<Integer, String> filters) {
        Set<Laptop> filterLaptops = new HashSet<>(laptops);
        for (int item : filters.keySet()) {
            for (Laptop laptop : laptops) {
                if (item == 1) {
                    int ram = laptop.getRam();
                    if (ram < Integer.parseInt(filters.get(1))) {
                        filterLaptops.remove(laptop);
                    }
                }
                if (item == 2) {
                    int hdd = laptop.getHdd();
                    if (hdd < Integer.parseInt(filters.get(2))) {
                        filterLaptops.remove(laptop);
                    }
                }
                if (item == 3) {
                    String operatingSystem = laptop.getOperatingSystem().toLowerCase();
                    if (!operatingSystem.equals(filters.get(3))) {
                        filterLaptops.remove(laptop);
                    }
                }
                if (item == 4) {
                    String color = laptop.getColor().toLowerCase();
                    if (!color.equals(filters.get(4))) {
                        filterLaptops.remove(laptop);
                    }
                }
            }
        }
        if (filters.isEmpty() || filterLaptops.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            StringBuilder result = new StringBuilder();
            for (Laptop laptop : filterLaptops) {
                result.append(laptop.toString()).append("\n");
            }
            System.out.println("Ноутбуки:\n" + result);
        }
    }

    static Set<Laptop> listLaptops() {
        Laptop laptop1 = new Laptop(4, 512, "Windows", "white");
        Laptop laptop2 = new Laptop(8, 1024, "Linux", "black");
        Laptop laptop3 = new Laptop(16, 256, "Windows", "red");
        Laptop laptop4 = new Laptop(8, 512, "MacOS", "gray");
        Laptop laptop5 = new Laptop(4, 256, "Linux", "white");
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);
        return laptops;
    }
}