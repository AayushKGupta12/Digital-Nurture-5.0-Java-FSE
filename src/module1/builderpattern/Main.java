package module1.builderpattern;

class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String GraphicCard;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.GraphicCard = builder.GraphicCard;
    }

    @Override
    public String toString() {
        return "Computer [CPU =" + cpu + ", RAM = " + ram + ",Storage=" + storage + ",Graphic Card =" + GraphicCard + "]";
    }

    static class Builder {
        private String cpu;
        private String ram;
        private String storage;

        private String GraphicCard;

        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicCard(String graphicCard){
            this.GraphicCard = GraphicCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
public class Main {
    public static void main(String[] args) {

        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32 GB")
                .setStorage("1 TB SSD")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16 GB")
                .setStorage("512 GB SSD")
                .build();

        Computer AayushPC = new Computer.Builder()
                .setCPU("Intel i7 1700U")
                .setRAM("16 GB DDRX5")
                .setStorage("512 GB SSD")
                .setGraphicCard("128Mb")
                .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
        System.out.println(AayushPC);
    }
}
