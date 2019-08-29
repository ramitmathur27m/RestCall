package com.spring.java.restCall.utility;

public class Employee {

    public int emp_id;
    public String emp_firtsName;
    public String emp_lastName;
    public String emp_emailAddress;
    public String emp_zipCode;
    public String error;

    public Employee() {
    }

    public Employee(int id, String fName, String lstName, String eAddress, String zip){
        this.emp_id = id;
        this.emp_firtsName = fName;
        this.emp_lastName = lstName;
        this.emp_emailAddress = eAddress;
        this.emp_zipCode = zip;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_firtsName() {
        return emp_firtsName;
    }

    public void setEmp_firtsName(String emp_firtsName) {
        this.emp_firtsName = emp_firtsName;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getEmp_lastName() {
        return emp_lastName;
    }

    public void setEmp_lastName(String emp_lastName) {
        this.emp_lastName = emp_lastName;
    }

    public String getEmp_emailAddress() {
        return emp_emailAddress;
    }

    public void setEmp_emailAddress(String emp_emailAddress) {
        this.emp_emailAddress = emp_emailAddress;
    }

    public String getEmp_zipCode() {
        return emp_zipCode;
    }

    public void setEmp_zipCode(String emp_zipCode) {
        this.emp_zipCode = emp_zipCode;
    }


}
