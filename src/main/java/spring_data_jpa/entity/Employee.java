package spring_data_jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "supplier_id")
    private int supplier_id;

    @Column(name = "account")
    private String account;

    @Column(name = "amount")
    private double amount;

    @Column(name = "command")
    private String command;

    @Column(name = "date")
    private String date;

    public Employee() {
    }

    public Employee(int id, int supplier_id, String account, double amount, String command, String date) {
        this.id = id;
        this.supplier_id = supplier_id;
        this.account = account;
        this.amount = amount;
        this.command = command;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}