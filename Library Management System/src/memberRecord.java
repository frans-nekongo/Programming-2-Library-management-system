package com.company;
import java.util.Scanner;

public class memberRecord {

    private String name;
    private int memberID;
    private int noBooksIssued;
    private int dateOfMembership;
    private int phoneNumber;
    private static int count = 0;

   // public memberRecord() {
       // count++;
   // }
    public memberRecord(String name,int memberID,int dateOfMembership, int noBooksIssued, int phoneNumber) {
        this.name = name;
        this.memberID = memberID;
        this.dateOfMembership=dateOfMembership;
        this.noBooksIssued = noBooksIssued;
        this.phoneNumber = phoneNumber;
        //count++;
        //this.phoneNumber = count;
    }
    public String toString() {
        return "Full name : " + this.name + " \nMember ID : " + this.memberID + "\nDate of membership : " + this.dateOfMembership +"\nNumber of books issued : "
                + this.noBooksIssued + "\nPhone number : " + String.format("22201%03d", this.phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getDateOfMembership() {
        return dateOfMembership;
    }

    public void setDateOfMembership(int dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public void setNoBooksIssued(int noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


