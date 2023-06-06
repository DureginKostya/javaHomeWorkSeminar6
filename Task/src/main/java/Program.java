import java.util.*;

public class Program {
    public Scanner sc = new Scanner(System.in);
    public void run() {
        int num;
        String value;
        Set<Laptop> laptops = fillWarehouseLaptop();
        Map<Integer, Set<String>> listFilter = getFilterCriteria(laptops);
        System.out.println("<<< Фильтр данных >>>");
        while (true) {
            num = validationInput();
            switch (num) {
                case 0 -> System.exit(0);
                case 1 -> {
                    System.out.println("Бренд: " + listFilter.get(1));
                    System.out.print("Введите бренд: ");
                    value = sc.next().trim().toUpperCase();
                    if (listFilter.get(1).contains(value)) {
                        for (Laptop item : laptops) {
                            if (Objects.equals(item.getBrand().toString(), value)) System.out.println(item);
                        }
                    } else System.out.printf("Ноутбуки %s отсутствуют\n", value);
                }
                case 2 -> {
                    System.out.println("Модель: " + listFilter.get(2));
                    System.out.print("Введите модель: ");
                    value = sc.next().trim().toUpperCase();
                    if (listFilter.get(2).contains(value)) {
                        for (Laptop item : laptops) {
                            if (Objects.equals(item.getModel(), value)) System.out.println(item);
                        }
                    } else System.out.printf("Модель ноутбуков %s отсутствует\n", value);
                }
                case 3 -> {
                    System.out.println("Процессор: " + listFilter.get(3));
                    System.out.print("Введите процессор: ");
                    value = sc.next().trim().toUpperCase();
                    if (listFilter.get(3).contains(value)) {
                        for (Laptop item : laptops) {
                            if (Objects.equals(item.getProcessor().toString(), value)) System.out.println(item);
                        }
                    } else System.out.printf("Ноутбуки с процессором %s отсутствуют\n", value);
                }
                case 4 -> {
                    System.out.println("Жесткий диск: " + listFilter.get(4));
                    System.out.print("Введите жесткий диск: ");
                    value = sc.next().trim().toUpperCase();
                    if (listFilter.get(4).contains(value)) {
                        for (Laptop item : laptops) {
                            if (Objects.equals(item.getHardDrivel().toString(), value)) System.out.println(item);
                        }
                    } else System.out.printf("Ноутбуки с жестким диском %s отсутствуют\n", value);
                }
                case 5 -> {
                    System.out.println("Диагональ: " + listFilter.get(5));
                    System.out.print("Введите диагональ: ");
                    value = sc.next().trim().toUpperCase();
                    if (listFilter.get(5).contains(value)) {
                        for (Laptop item : laptops) {
                            if (Objects.equals(item.getDiagonal().toString(), value)) System.out.println(item);
                        }
                    } else System.out.printf("Ноутбуки с диагональю %s отсутствуют\n", value);
                }
                case 6 -> {
                    System.out.println("Цвет: " + listFilter.get(6));
                    System.out.print("Введите цвет: ");
                    value = sc.next().trim().toUpperCase();
                    if (listFilter.get(6).contains(value)) {
                        for (Laptop item : laptops) {
                            if (Objects.equals(item.getColor().toString(), value)) System.out.println(item);
                        }
                    } else System.out.printf("Ноутбуки с цветом %s отсутствуют\n", value);
                }
                default ->
                        System.out.println("Введено неправильное значение, повторите ввод (допустимые значения от 0 до 6)");
            }
        }
    }
    private Set<Laptop> fillWarehouseLaptop() {
        Set<Laptop> laptopsOnWarehouse = new HashSet<>();
        Laptop laptop = new Laptop(Brand.ACER, "XXX", 123,
                Processor.INTEL, HardDrive.HDD, 17, Color.BLACK);
        laptopsOnWarehouse.add(laptop);
        Laptop laptop1 =  new Laptop(Brand.ASUS, "ZZZ", 218,
                Processor.AMD, HardDrive.SSD, 15, Color.BLUE);
        laptopsOnWarehouse.add(laptop1);
        Laptop laptop2 = new Laptop(Brand.ACER, "XXX", 123,
                Processor.INTEL, HardDrive.HDD, 17, Color.BLACK);
        laptopsOnWarehouse.add(laptop2);
        Laptop laptop3 = new Laptop(Brand.APPLE, "MAC", 541,
                Processor.INTEL, HardDrive.SSD, 16, Color.WHITE);
        laptopsOnWarehouse.add(laptop3);
        Laptop laptop4 = new Laptop(Brand.HP, "CCC", 985,
                Processor.INTEL, HardDrive.HDD, 17, Color.BLACK);
        laptopsOnWarehouse.add(laptop4);
        Laptop laptop5 =  new Laptop(Brand.ASUS, "ZZZ", 458,
                Processor.AMD, HardDrive.HDD, 16, Color.BLACK);
        laptopsOnWarehouse.add(laptop5);
        Laptop laptop6 = new Laptop(Brand.ACER, "XXX", 847,
                Processor.AMD, HardDrive.SSD, 17, Color.RED);
        laptopsOnWarehouse.add(laptop6);
        Laptop laptop7 = new Laptop(Brand.LENOVO, "AAA", 223,
                Processor.AMD, HardDrive.SSD, 15, Color.WHITE);
        laptopsOnWarehouse.add(laptop7);
        return laptopsOnWarehouse;
    }
    private void printHint() {
        String msg = new StringBuilder()
                .append("Критерий фильтрации ноутбуков:\n")
                .append("* Брэнд - << 1 >>\n")
                .append("* Модель  - << 2 >>\n")
                .append("* Процессор - << 3 >>\n")
                .append("* Жесткий диск  - << 4 >>\n")
                .append("* Диагональ - << 5 >>\n")
                .append("* Цвет корпуса - << 6 >>\n")
                .append("* Выйти - << 0 >>")
                .toString();
        System.out.println(msg);
    }
    private Map<Integer, Set<String>> getFilterCriteria(Set<Laptop> laptopSet) {
        Map<Integer, Set<String>> listProduct = new HashMap<>();
        Set<String> listBrand = new HashSet<>();
        Set<String> listModel = new HashSet<>();
        Set<String> listProcessor = new HashSet<>();
        Set<String> listHardDrive = new HashSet<>();
        Set<String> listDiagonal = new HashSet<>();
        Set<String> listColor = new HashSet<>();
        for (Laptop item : laptopSet) {
            listBrand.add(item.getBrand().toString());
            listModel.add(item.getModel());
            listProcessor.add(item.getProcessor().toString());
            listHardDrive.add(item.getHardDrivel().toString());
            listDiagonal.add(item.getDiagonal().toString());
            listColor.add(item.getColor().toString());
        }
        listProduct.put(1, listBrand);
        listProduct.put(2, listModel);
        listProduct.put(3, listProcessor);
        listProduct.put(4, listHardDrive);
        listProduct.put(5, listDiagonal);
        listProduct.put(6, listColor);
        return listProduct;
    }
    private int validationInput() {
        String line;
        System.out.println();
        printHint();
        System.out.print("Введите критерий: ");
        try {
            line = sc.next();
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Введено неправильное значение, повторите ввод");
            return validationInput();
        }
    }
}
