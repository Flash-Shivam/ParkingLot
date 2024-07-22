public class Ticket {
    private final String ticketId;
    private final String floor;
    private final String slot;
    private boolean isValid;
    Ticket(String floor, String slot){
        this.ticketId = "PR1234_"  + floor +  "_" + slot;
        this.floor = floor;
        this.slot = slot;
        this.isValid = true;
    }


    public void invalidateTicket(){
        this.isValid = false;
    }

    public String getTicketId(){
        return this.ticketId;
    }

}
