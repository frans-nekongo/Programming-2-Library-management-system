package com.company;

import java.util.Objects;

public class BorrowProcess {
    private String Customer,Employees,Book;

    public BorrowProcess(String customer, String employees, String book) {
        Customer = customer;
        Employees = employees;
        Book = book;
    }

    public String getCustomer() {
        return Customer;
    }

    public String getEmployees() {
        return Employees;
    }

    public String getBook() {
        return Book;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public void setEmployees(String employees) {
        Employees = employees;
    }

    public void setBook(String book) {
        Book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BorrowProcess)) return false;
        BorrowProcess that = (BorrowProcess) o;
        return getCustomer().equals(that.getCustomer()) && getEmployees().equals(that.getEmployees()) && getBook().equals(that.getBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(), getEmployees(), getBook());
    }

    @Override
    public String toString() {
        return "BorrowProcess{" +
                "Customer='" + Customer + '\'' +
                ", Employees='" + Employees + '\'' +
                ", Book='" + Book + '\'' +
                '}';
    }

    public BorrowProcess() {
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
     
}
