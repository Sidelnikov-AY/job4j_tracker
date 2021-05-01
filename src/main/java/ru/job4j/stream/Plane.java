package ru.job4j.stream;

public class Plane {
    private String type;
    private String company;
    private String model;
    private Integer firstFlight;
    private Integer weight;
    private Integer modifications;

    @Override
    public String toString() {
        return "Plane{"
                + "type='" + type + '\''
                + ", company='" + company + '\''
                + ", model='" + model + '\''
                + ", firstFlight=" + firstFlight
                + ", weight=" + weight
                + ", modifications=" + modifications
                + '}';
    }

    static class Builder {
        private String type;
        private String company;
        private String model;
        private Integer firstFlight;
        private Integer weight;
        private Integer modifications;

        Builder buildType(String type) {
            this.type = type;
            return this;
        }

        Builder buildCompany(String company) {
            this.company = company;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildFirstFlight(Integer firstFlight) {
            this.firstFlight = firstFlight;
            return this;
        }

        Builder buildWeight(Integer weight) {
            this.weight = weight;
            return this;
        }

        Builder buildModifications(Integer modifications) {
            this.modifications = modifications;
            return this;
        }

        Plane build() {
            Plane plane = new Plane();
            plane.type = type;
            plane.company = company;
            plane.model = model;
            plane.firstFlight = firstFlight;
            plane.weight = weight;
            plane.modifications = modifications;
            return plane;
    }
   }

    public static void main(String[] args) {
        Plane plane = new Builder().buildType("passenger")
                .buildCompany("Boeing")
                .buildModel("B747")
                .buildFirstFlight(1969)
                .buildWeight(442)
                .buildModifications(8)
                .build();
        System.out.println(plane);
    }
}
