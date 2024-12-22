import java.util.Scanner;

public class Main {
    interface Vehicle {
        String getMake();

        String getModel();

        int getYearOfManufacture();
    }

    interface CarVehicle {
        void setNumberOfDoors(int doors);

        int getNumberOfDoors();

        void setFuelType(String fuelType); // Valid options: petrol, diesel, electric

        String getFuelType();
    }

    interface MotorVehicle {
        void setNumberOfWheels(int wheels);

        int getNumberOfWheels();

        void setMotorcycleType(String type); // Valid options: sport, cruiser, off-road

        String getMotorcycleType();
    }

    interface TruckVehicle {
        void setCargoCapacity(double tons);

        double getCargoCapacity();

        void setTransmissionType(String type); // Valid options: manual, automatic

        String getTransmissionType();
    }

    static class Car implements Vehicle, CarVehicle {
        private String make;
        private String model;
        private int yearOfManufacture;
        private int numberOfDoors;
        private String fuelType;

        public Car(String make, String model, int yearOfManufacture) {
            this.make = make;
            this.model = model;
            this.yearOfManufacture = yearOfManufacture;
        }

        @Override
        public String getMake() {
            return make;
        }

        @Override
        public String getModel() {
            return model;
        }

        @Override
        public int getYearOfManufacture() {
            return yearOfManufacture;
        }

        @Override
        public void setNumberOfDoors(int doors) {
            this.numberOfDoors = doors;
        }

        @Override
        public int getNumberOfDoors() {
            return numberOfDoors;
        }

        @Override
        public void setFuelType(String fuelType) {
            this.fuelType = fuelType;
        }

        @Override
        public String getFuelType() {
            return fuelType;
        }
    }

    static class Motorcycle implements Vehicle, MotorVehicle {
        private String make;
        private String model;
        private int yearOfManufacture;
        private int numberOfWheels;
        private String motorcycleType;

        public Motorcycle(String make, String model, int yearOfManufacture) {
            this.make = make;
            this.model = model;
            this.yearOfManufacture = yearOfManufacture;
        }

        @Override
        public String getMake() {
            return make;
        }

        @Override
        public String getModel() {
            return model;
        }

        @Override
        public int getYearOfManufacture() {
            return yearOfManufacture;
        }

        @Override
        public void setNumberOfWheels(int wheels) {
            this.numberOfWheels = wheels;
        }

        @Override
        public int getNumberOfWheels() {
            return numberOfWheels;
        }

        @Override
        public void setMotorcycleType(String type) {
            this.motorcycleType = type;
        }

        @Override
        public String getMotorcycleType() {
            return motorcycleType;
        }
    }

    static class Truck implements Vehicle, TruckVehicle {
        private String make;
        private String model;
        private int yearOfManufacture;
        private double cargoCapacity;
        private String transmissionType;

        public Truck(String make, String model, int yearOfManufacture) {
            this.make = make;
            this.model = model;
            this.yearOfManufacture = yearOfManufacture;
        }

        @Override
        public String getMake() {
            return make;
        }

        @Override
        public String getModel() {
            return model;
        }

        @Override
        public int getYearOfManufacture() {
            return yearOfManufacture;
        }

        @Override
        public void setCargoCapacity(double tons) {
            this.cargoCapacity = tons;
        }

        @Override
        public double getCargoCapacity() {
            return cargoCapacity;
        }

        @Override
        public void setTransmissionType(String type) {
            this.transmissionType = type;
        }

        @Override
        public String getTransmissionType() {
            return transmissionType;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentYear = java.time.Year.now().getValue();

        while (true) {
            System.out.println("Choose a vehicle type to create: 1. Car, 2. Motorcycle, 3. Truck, 4. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                continue;
            }

            if (choice == 4) {
                System.out.println("Exiting the program.");
                break;
            }

            System.out.print("Enter make: ");
            String make = scanner.nextLine();

            System.out.print("Enter model: ");
            String model = scanner.nextLine();

            System.out.print("Enter year of manufacture (1800 to " + currentYear + "): ");
            int year;
            while (true) {
                try {
                    year = Integer.parseInt(scanner.nextLine());
                    if (year < 1800 || year > currentYear) {
                        throw new IllegalArgumentException("Invalid year. Please enter a valid year.");
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid year. Try again: ");
                }
            }

            switch (choice) {
                case 1: {
                    Car car = new Car(make, model, year);

                    System.out.print("Enter number of doors (1 to 12): ");
                    int doors;
                    while (true) {
                        try {
                            doors = Integer.parseInt(scanner.nextLine());
                            if (doors < 1 || doors > 12) {
                                throw new IllegalArgumentException("Invalid number of doors. Please enter a valid number.");
                            }
                            break;
                        } catch (Exception e) {
                            System.out.print("Invalid input. Try again: ");
                        }
                    }
                    car.setNumberOfDoors(doors);

                    System.out.print("Enter fuel type (petrol, diesel, electric): ");
                    String fuelType;
                    while (true) {
                        fuelType = scanner.nextLine().toLowerCase();
                        if (!fuelType.equals("petrol") && !fuelType.equals("diesel") && !fuelType.equals("electric")) {
                            System.out.print("Invalid fuel type. Try again (petrol, diesel, electric): ");
                        } else {
                            break;
                        }
                    }
                    car.setFuelType(fuelType);

                    System.out.println("Car Details: " + car.getMake() + " " + car.getModel() + ", Year: " + car.getYearOfManufacture() + ", Doors: " + car.getNumberOfDoors() + ", Fuel: " + car.getFuelType());
                    break;
                }
                case 2: {
                    Motorcycle motorcycle = new Motorcycle(make, model, year);

                    System.out.print("Enter number of wheels: ");
                    int wheels;
                    while (true) {
                        try {
                            wheels = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.print("Invalid input. Try again: ");
                        }
                    }
                    motorcycle.setNumberOfWheels(wheels);

                    System.out.print("Enter motorcycle type (sport, cruiser, off-road): ");
                    String type;
                    while (true) {
                        type = scanner.nextLine().toLowerCase();
                        if (!type.equals("sport") && !type.equals("cruiser") && !type.equals("off-road")) {
                            System.out.print("Invalid motorcycle type. Try again (sport, cruiser, off-road): ");
                        } else {
                            break;
                        }
                    }
                    motorcycle.setMotorcycleType(type);

                    System.out.println("Motorcycle Details: " + motorcycle.getMake() + " " + motorcycle.getModel() + ", Year: " + motorcycle.getYearOfManufacture() + ", Wheels: " + motorcycle.getNumberOfWheels() + ", Type: " + motorcycle.getMotorcycleType());
                    break;
                }
                case 3: {
                    Truck truck = new Truck(make, model, year);

                    System.out.print("Enter cargo capacity (in tons): ");
                    double capacity;
                    while (true) {
                        try {
                            capacity = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.print("Invalid input. Try again: ");
                        }
                    }
                    truck.setCargoCapacity(capacity);

                    System.out.print("Enter transmission type (manual, automatic): ");
                    String transmission;
                    while (true) {
                        transmission = scanner.nextLine().toLowerCase();
                        if (!transmission.equals("manual") && !transmission.equals("automatic")) {
                            System.out.print("Invalid transmission type. Try again (manual, automatic): ");
                        } else {
                            break;
                        }
                    }
                    truck.setTransmissionType(transmission);

                    System.out.println("Truck Details: " + truck.getMake() + " " + truck.getModel() + ", Year: " + truck.getYearOfManufacture() + ", Cargo: " + truck.getCargoCapacity() + " tons, Transmission: " + truck.getTransmissionType());
                    break;
                }
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
