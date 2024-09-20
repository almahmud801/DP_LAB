public class Admin {
    private int id;
    private String name;
    private String role;

    public Admin(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public void manageDriver(Driver driver) {
        // Manage driver (e.g., deactivate, update info)
        System.out.println("Managing driver: " + driver.name);
    }

    public void manageRider(Rider rider) {
        // Manage rider (e.g., ban, update info)
        System.out.println("Managing rider: " + rider.name);
    }

    public void viewTripHistory() {
        // View trip history (simplified)
        System.out.println("Viewing trip history...");
    }

    public void handleDispute() {
        // Handle disputes (simplified)
        System.out.println("Handling dispute...");
    }
}
