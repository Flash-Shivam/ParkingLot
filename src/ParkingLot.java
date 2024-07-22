import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {

    int floors;
    int slotsPerFloor;
    String parkingLotId;
    List<ParkingLotFloor> parkingLotFloors = new ArrayList<>();
    List<Vehicle> vehicles = new ArrayList<>();
    HashMap<String, Vehicle> tickets = new HashMap<>();
    List<String> ticketIds = new ArrayList<>();

    ParkingLot(int floors, int slotsPerFloor){
        this.parkingLotId = "PR_1234";
        this.floors = floors;
        this.slotsPerFloor = slotsPerFloor;
        for(int i=1;i<=this.floors;i++){
            parkingLotFloors.add(new ParkingLotFloor(i, slotsPerFloor));
        }
        System.out.println("Created parking lot with " + floors + " floors and " + slotsPerFloor + " slots per floor");
    }

    public void displayFreeCount(VehicleType vehicleType){
        if(vehicleType == VehicleType.BIKE){
            for(ParkingLotFloor parkingLotFloor : this.parkingLotFloors){
                System.out.println("No. of free slots for " + vehicleType +" on Floor " + parkingLotFloor.floorNumber + ": " + parkingLotFloor.getUnOccupiedBikeSlots().size());
            }
        } else if(vehicleType == VehicleType.TRUCK) {
            for(ParkingLotFloor parkingLotFloor : this.parkingLotFloors){
                System.out.println("No. of free slots for " + vehicleType +" on Floor " + parkingLotFloor.floorNumber + ": " + parkingLotFloor.getUnOccupiedTruckSlots().size());
            }
        } else{
            for(ParkingLotFloor parkingLotFloor : this.parkingLotFloors){
                System.out.println("No. of free slots for " + vehicleType +" on Floor " + parkingLotFloor.floorNumber + ": " + parkingLotFloor.getUnOccupiedCarSlots().size());
            }
        }
    }

    public void displayFreeSlots(VehicleType vehicleType){
        if(vehicleType == VehicleType.BIKE){
            for(ParkingLotFloor parkingLotFloor : this.parkingLotFloors){
                System.out.print("Free slots for "+ vehicleType + " on Floor " + parkingLotFloor.floorNumber + ": ");
                for(Integer freeSlot : parkingLotFloor.getUnOccupiedBikeSlots()){
                    System.out.print(freeSlot + ",");
                }
                System.out.println();
            }
        } else if(vehicleType == VehicleType.TRUCK) {
            for(ParkingLotFloor parkingLotFloor : this.parkingLotFloors){
                System.out.print("Free slots for "+ vehicleType + " on Floor " + parkingLotFloor.floorNumber + ": ");
                for(Integer freeSlot : parkingLotFloor.getUnOccupiedTruckSlots()){
                    System.out.print(freeSlot + ",");
                }
                System.out.println();
            }
        } else{
            for(ParkingLotFloor parkingLotFloor : this.parkingLotFloors){
                System.out.print("Free slots for "+ vehicleType + " on Floor " + parkingLotFloor.floorNumber + ": ");
                for(Integer freeSlot : parkingLotFloor.getUnOccupiedCarSlots()){
                    System.out.print(freeSlot + ",");
                }
                System.out.println();
            }
        }
    }

    public void displayOccupiedSlots(VehicleType vehicleType){
        if(vehicleType == VehicleType.BIKE){
            for(ParkingLotFloor parkingLotFloor : this.parkingLotFloors){
                System.out.print("Occupied slots for "+ vehicleType + " on Floor " + parkingLotFloor.floorNumber + ": ");
                for(Integer freeSlot : parkingLotFloor.getOccupiedBikeSlots()){
                    System.out.print(freeSlot + ",");
                }
                System.out.println();
            }
        } else if(vehicleType == VehicleType.TRUCK) {
            for(ParkingLotFloor parkingLotFloor : this.parkingLotFloors){
                System.out.print("Occupied slots for "+ vehicleType + " on Floor " + parkingLotFloor.floorNumber + ": ");
                for(Integer freeSlot : parkingLotFloor.getOccupiedTruckSlots()){
                    System.out.print(freeSlot + ",");
                }
                System.out.println();
            }
        } else{
            for(ParkingLotFloor parkingLotFloor : this.parkingLotFloors){
                System.out.print("Occupied slots for "+ vehicleType + " on Floor " + parkingLotFloor.floorNumber + ": ");
                for(Integer freeSlot : parkingLotFloor.getOccupiedCarSlots()){
                    System.out.print(freeSlot + ",");
                }
                System.out.println();
            }
        }
    }


    public void parkVehicle(String registrationNumber, String color, VehicleType vehicleType){
        Vehicle vehicle = new Vehicle(vehicleType,registrationNumber, color);
        if(!vehicles.contains(vehicle)){
            vehicles.add(vehicle);
            if(vehicleType == VehicleType.BIKE){
                boolean flag = false;
                for(ParkingLotFloor parkingLotFloor : this.parkingLotFloors){
                    if(!parkingLotFloor.getUnOccupiedBikeSlots().isEmpty()){
                        int slotNumber = parkingLotFloor.getUnOccupiedBikeSlots().getFirst();
                        parkingLotFloor.addParkedSlot(vehicle, slotNumber);
                        Ticket ticket = new Ticket(String.valueOf(parkingLotFloor.floorNumber), String.valueOf(slotNumber));
                        System.out.println("Parked vehicle. Ticket ID: " + ticket.getTicketId());
                        tickets.put(ticket.getTicketId(), vehicle);
                        ticketIds.add(ticket.getTicketId());
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    System.out.println("Parking Lot Full");
                }
            } else if(vehicleType == VehicleType.TRUCK){
                boolean flag = false;
                for(ParkingLotFloor parkingLotFloor : this.parkingLotFloors){
                    if(!parkingLotFloor.getUnOccupiedTruckSlots().isEmpty()){
                        int slotNumber = parkingLotFloor.getUnOccupiedTruckSlots().getFirst();
                        parkingLotFloor.addParkedSlot(vehicle, slotNumber);
                        Ticket ticket = new Ticket(String.valueOf(parkingLotFloor.floorNumber), String.valueOf(slotNumber));
                        System.out.println("Parked vehicle. Ticket ID: " + ticket.getTicketId());
                        tickets.put(ticket.getTicketId(), vehicle);
                        ticketIds.add(ticket.getTicketId());
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    System.out.println("Parking Lot Full");
                }
            } else {
                boolean flag = false;
                for(ParkingLotFloor parkingLotFloor : this.parkingLotFloors){
                    if(!parkingLotFloor.getUnOccupiedCarSlots().isEmpty()){
                        int slotNumber = parkingLotFloor.getUnOccupiedCarSlots().getFirst();
                        parkingLotFloor.addParkedSlot(vehicle, slotNumber);
                        Ticket ticket = new Ticket(String.valueOf(parkingLotFloor.floorNumber), String.valueOf(slotNumber));
                        System.out.println("Parked vehicle. Ticket ID: " + ticket.getTicketId());
                        tickets.put(ticket.getTicketId(), vehicle);
                        ticketIds.add(ticket.getTicketId());
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    System.out.println("Parking Lot Full");
                }
            }


        } else{
            System.out.println("Vehicle Already Parked");
        }

    }

    public void unParkVehicle(String ticketId){
        if(!ticketIds.contains(ticketId)){
            System.out.println("Invalid Ticket");
        } else{
            int floorNumber = ticketId.charAt(7)-48;
            int slotNumber = ticketId.charAt(9)-48;
            boolean isVehicleParked = parkingLotFloors.get(floorNumber-1).isVehicleParked(tickets.get(ticketId), slotNumber);
            if(isVehicleParked) {
                Vehicle vehicle = tickets.get(ticketId);
                tickets.remove(ticketId);
                parkingLotFloors.get(floorNumber-1).removeParkedSlot(vehicle, slotNumber);
                System.out.println("Unparked vehicle with Registration Number: " + vehicle.registrationNumber + " and Color: " + vehicle.color);

            } else{
                System.out.println("Invalid Ticket");
            }
        }
    }





}
