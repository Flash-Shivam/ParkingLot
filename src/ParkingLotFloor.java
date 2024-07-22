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

    public List<Integer> getOccupiedBikeSlots(){
        return this.occupiedBikeSlots;
    }

    public List<Integer> getOccupiedCarSlots(){
        return this.occupiedCarSlots;
    }

    public List<Integer> getOccupiedTruckSlots(){
        return this.occupiedTruckSlots;
    }

    public List<Integer> getUnOccupiedBikeSlots(){
        return this.unOccupiedBikeSlots;
    }

    public List<Integer> getUnOccupiedCarSlots(){
        return this.unOccupiedCarSlots;
    }

    public List<Integer> getUnOccupiedTruckSlots(){
        return this.unOccupiedTruckSlots;
    }

    public boolean isVehicleParked(Vehicle vehicle, int slotNumber) {
        if(this.parkedSlots.containsKey(slotNumber)){
            return this.parkedSlots.get(slotNumber).equals(vehicle);
        }
        return false;

    }


    public void addParkedSlot(Vehicle vehicle, Integer slotNumber){
        this.parkedSlots.put(slotNumber, vehicle);
        if(vehicle.vehicleType == VehicleType.BIKE) {
            this.occupiedBikeSlots.add(slotNumber);
            this.unOccupiedBikeSlots.removeFirst();
        } else if(vehicle.vehicleType == VehicleType.TRUCK) {
            this.occupiedTruckSlots.add(slotNumber);
            this.unOccupiedTruckSlots.removeFirst();
        } else{
            this.occupiedCarSlots.add(slotNumber);
            this.unOccupiedCarSlots.removeFirst();
        }
    }

    public void removeParkedSlot(Vehicle vehicle, Integer slotNumber) {
        this.parkedSlots.remove(slotNumber, vehicle);
        if(vehicle.vehicleType == VehicleType.BIKE) {
            this.occupiedBikeSlots.remove(slotNumber);
            this.unOccupiedBikeSlots.add(slotNumber);
        } else if(vehicle.vehicleType == VehicleType.TRUCK) {
            this.occupiedTruckSlots.remove(slotNumber);
            this.unOccupiedTruckSlots.add(slotNumber);
        } else{
            this.occupiedCarSlots.remove(slotNumber);
            this.unOccupiedCarSlots.add(slotNumber);
        }
    }






}
