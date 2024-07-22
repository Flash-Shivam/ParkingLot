//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(2, 6);

        parkingLot.displayFreeCount(VehicleType.CAR);
        parkingLot.displayFreeCount(VehicleType.BIKE);
        parkingLot.displayFreeCount(VehicleType.TRUCK);

        parkingLot.displayFreeSlots(VehicleType.CAR);
        parkingLot.displayFreeSlots(VehicleType.BIKE);
        parkingLot.displayFreeSlots(VehicleType.TRUCK);

        parkingLot.displayOccupiedSlots(VehicleType.CAR);
        parkingLot.displayOccupiedSlots(VehicleType.BIKE);
        parkingLot.displayOccupiedSlots(VehicleType.TRUCK);

        parkingLot.parkVehicle("KA-01-DB-1234", "black", VehicleType.CAR);
        parkingLot.parkVehicle("KA-02-CB-1334", "red", VehicleType.CAR);
        parkingLot.parkVehicle("KA-01-DB-1133", "black", VehicleType.CAR);
        parkingLot.parkVehicle("KA-05-HJ-8432", "white", VehicleType.CAR);
        parkingLot.parkVehicle("WB-45-HO-9032", "white", VehicleType.CAR);
        parkingLot.parkVehicle("KA-01-DF-8230", "black", VehicleType.CAR);
        parkingLot.parkVehicle("KA-21-HS-2347", "red", VehicleType.CAR);

        parkingLot.displayFreeCount(VehicleType.CAR);
        parkingLot.displayFreeCount(VehicleType.BIKE);
        parkingLot.displayFreeCount(VehicleType.TRUCK);

        parkingLot.unParkVehicle("PR1234_2_5");
        parkingLot.unParkVehicle("PR1234_2_5");
        parkingLot.unParkVehicle("PR1234_2_7");

        parkingLot.displayFreeCount(VehicleType.CAR);
        parkingLot.displayFreeCount(VehicleType.BIKE);
        parkingLot.displayFreeCount(VehicleType.TRUCK);

        parkingLot.displayFreeSlots(VehicleType.CAR);
        parkingLot.displayFreeSlots(VehicleType.BIKE);
        parkingLot.displayFreeSlots(VehicleType.TRUCK);

        parkingLot.displayOccupiedSlots(VehicleType.CAR);
        parkingLot.displayOccupiedSlots(VehicleType.BIKE);
        parkingLot.displayOccupiedSlots(VehicleType.TRUCK);

        parkingLot.parkVehicle("KA-01-DB-1541", "black", VehicleType.BIKE);
        parkingLot.parkVehicle("KA-32-SJ-5389", "orange", VehicleType.TRUCK);
        parkingLot.parkVehicle("KL-54-DN-4582", "green", VehicleType.TRUCK);
        parkingLot.parkVehicle("KL-12-HF-4542", "green", VehicleType.TRUCK);

        parkingLot.displayFreeCount(VehicleType.CAR);
        parkingLot.displayFreeCount(VehicleType.BIKE);
        parkingLot.displayFreeCount(VehicleType.TRUCK);

        parkingLot.displayFreeSlots(VehicleType.CAR);
        parkingLot.displayFreeSlots(VehicleType.BIKE);
        parkingLot.displayFreeSlots(VehicleType.TRUCK);

        parkingLot.displayOccupiedSlots(VehicleType.CAR);
        parkingLot.displayOccupiedSlots(VehicleType.BIKE);
        parkingLot.displayOccupiedSlots(VehicleType.TRUCK);

    }
}