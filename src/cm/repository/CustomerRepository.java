package cm.repository;

import cm.entity.Customer;
import cm.util.ReadAndWrite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final List<Customer> customers = new ArrayList<>();
    private final String filePath;
    private static final String HEADER = "id,name,email,address,created_at";

    public CustomerRepository(String filePath) {
        if (filePath == null || filePath.isBlank()) {
            filePath = Paths.get("data", "customers.csv").toAbsolutePath().toString();
        }
        this.filePath = filePath;
        ensureHeader();
        loadData();
    }

    private void ensureHeader() {
        try {
            File f = new File(filePath);
            File p = f.getParentFile();
            if (p != null && !p.exists()) p.mkdirs();
            List<String> lines = ReadAndWrite.readAllLines(filePath);
            if (lines.isEmpty()) {
                lines = new ArrayList<>();
                lines.add(HEADER);
                ReadAndWrite.writeAllLinesAtomic(filePath, lines);
            } else if (!lines.get(0).toLowerCase().startsWith("id,")) {
                lines.add(0, HEADER);
                ReadAndWrite.writeAllLinesAtomic(filePath, lines);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot initialize CSV at " + filePath, e);
        }
    }

    private void loadData() {
        try {
            List<String> lines = ReadAndWrite.readAllLines(filePath);
            customers.clear();
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (i == 0 && line.toLowerCase().startsWith("id,")) continue; // header
                if (line.trim().isEmpty()) continue;
                String[] cols = ReadAndWrite.parseCsvLine(line);
                Customer c = Customer.fromColumns(cols);
                if (c != null) customers.add(c);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV: " + filePath, e);
        }
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    @Override
    public Customer findById(int id) {
        for (Customer c : customers) if (c.getId() == id) return c;
        return null;
    }

    @Override
    public void add(Customer c) {
        customers.add(c);
        saveFile();
    }

    @Override
    public boolean update(Customer updated) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == updated.getId()) {
                customers.set(i, updated);
                saveFile();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        boolean ok = customers.removeIf(c -> c.getId() == id);
        if (ok) saveFile();
        return ok;
    }

    @Override
    public List<Customer> findByName(String keyword) {
        String k = keyword == null ? "" : keyword.toLowerCase();
        List<Customer> res = new ArrayList<>();
        for (Customer c : customers) {
            String n = c.getName() == null ? "" : c.getName();
            if (n.toLowerCase().contains(k)) res.add(c);
        }
        return res;
    }

    @Override
    public boolean existsEmail(String email, Integer excludeId) {
        if (email == null) return false;
        String t = email.trim().toLowerCase();
        for (Customer c : customers) {
            String e = c.getEmail();
            if (e != null && e.trim().toLowerCase().equals(t)) {
                if (excludeId == null || c.getId() != excludeId) return true;
            }
        }
        return false;
    }

    @Override
    public int getNextId() {
        int max = 0;
        for (Customer c : customers) if (c.getId() > max) max = c.getId();
        return max + 1;
    }

    @Override
    public void saveFile() {
        List<String> lines = new ArrayList<>();
        lines.add(HEADER);
        for (Customer c : customers) {
            lines.add(ReadAndWrite.toCsvLine(c.toColumns()));
        }
        try {
            ReadAndWrite.writeAllLinesAtomic(filePath, lines);
        } catch (IOException e) {
            throw new RuntimeException("Error writing CSV: " + filePath, e);
        }
    }
}
