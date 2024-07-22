import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLotFloor {
    int floorNumber;
    int totalSlots;
    private final List<Integer> occupiedBikeSlots = new ArrayList<>();
    private final List<Integer> unOccupiedBikeSlots = new ArrayList<>(List.of(2,3));
    private final List<Integer> occupiedCarSlots = new ArrayList<>();
    private final List<Integer> unOccupiedCarSlots = new ArrayList<>();
    private final List<Integer> occupiedTruckSlots = new ArrayList<>();
    private final List<Integer> unOccupiedTruckSlots = new ArrayList<>(List.of(1));
    HashMap<Integer, Vehicle> parkedSlots = new HashMap<>();

    ParkingLotFloor(int floorNumber, int totalSlots){
        this.floorNumber = floorNumber;
        this.totalSlots = totalSlots;
        for(int i = 4;i<=totalSlots;i++) {
            this.unOccupiedCarSlots.add(i);
        }
    }

    public boolean isVehicleParked(Vehicle vehicle, int slotNumber) {
        if(this.parkedSlots.containsKey(slotNumber)){
            return this.parkedSlots.get(slotNumber).equals(vehicle);
        }
        return false;
    }

    public List<Integer> getUnOccupiedSlotsForVehicleType(VehicleType vehicleType) {
        if(vehicleType.equals(VehicleType.BIKE)){
            return this.unOccupiedBikeSlots;
        } else if(vehicleType.equals(VehicleType.TRUCK)){
            return this.unOccupiedTruckSlots;
        } else{
            return this.unOccupiedCarSlots;
        }
    }

    public List<Integer> getOccupiedSlotsForVehicleType(VehicleType vehicleType) {
        if(vehicleType.equals(VehicleType.BIKE)){
            return this.occupiedBikeSlots;
        } else if(vehicleType.equals(VehicleType.TRUCK)){
            return this.occupiedTruckSlots;
        } else{
            return this.occupiedCarSlots;
        }
    }

    public void addParkedSlot(Vehicle vehicle, Integer slotNumber){
        this.parkedSlots.put(slotNumber, vehicle);
        this.getOccupiedSlotsForVehicleType(vehicle.vehicleType).add(slotNumber);
        this.getUnOccupiedSlotsForVehicleType(vehicle.vehicleType).removeFirst();
    }

    public void removeParkedSlot(Vehicle vehicle, Integer slotNumber) {
        this.parkedSlots.remove(slotNumber, vehicle);
        this.getOccupiedSlotsForVehicleType(vehicle.vehicleType).remove(slotNumber);
        this.getUnOccupiedSlotsForVehicleType(vehicle.vehicleType).add(slotNumber);
    }

}
