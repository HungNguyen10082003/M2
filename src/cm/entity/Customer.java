package cm.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String address;
    private LocalDateTime createdAt;

    public Customer() {}

    public Customer(int id, String name, String email, String address, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name == null ? "" : name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email == null ? "" : email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address == null ? "" : address; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String[] toColumns() {
        return new String[]{
            String.valueOf(id),
            name == null ? "" : name,
            email == null ? "" : email,
            address == null ? "" : address,
            createdAt == null ? "" : createdAt.toString()
        };
    }

    public static Customer fromColumns(String[] cols) {
        if (cols == null || cols.length < 5) return null;
        Customer c = new Customer();
        try { c.setId(Integer.parseInt(cols[0].trim())); } catch (Exception e) { return null; }
        c.setName(cols[1]);
        c.setEmail(cols[2]);
        c.setAddress(cols[3]);
        try { c.setCreatedAt(LocalDateTime.parse(cols[4])); } catch (Exception e) { c.setCreatedAt(LocalDateTime.now()); }
        return c;
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("ID: %d | Name: %s | Email: %s | Address: %s | Created: %s",
            id, name, email, address, createdAt == null ? "" : createdAt.format(f));
    }
}
