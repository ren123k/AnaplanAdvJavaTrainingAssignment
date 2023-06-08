package com.anaplan.employee.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class EmployeeSystem {
    public static void main(String[] args) throws CustomException {
        Scanner input = new Scanner(System.in);

        int option = 0;
        List<Employee> employeeList = new ArrayList<>();

        // Do - While loop
        do {
            System.out.println("MENU");
            System.out.println("1: Add Employee");
            System.out.println("2: Delete Employee");
            System.out.println("3: Update Employee");
            System.out.println("4: Display Employee");
            System.out.println("5: Exit program");
            System.out.print("Enter your selection : ");
            option = input.nextInt();

            // Switch case
            switch (option) {

                // Case 1
                case 1:

                    System.out.print(
                            "What is the employee id Number ? ");

                    int employeeid = input.nextInt();
                    input.nextLine();

                    System.out.print(
                            "What is the employee name ? ");
                    String name = input.nextLine();
                  System.out.print(
                            "What is the employee designation ? ");
                    String designation = input.nextLine();
                    System.out.print(
                            "What is the employee salary ? ");
                    double salary = input.nextDouble();

                    // Display message
                    System.out.print(
                            " Employee details ? ");



                    Employee record = new Employee(employeeid, name,
                            designation, salary);
                    employeeList.add(record);
                    System.out.println(employeeList.toString());


                    break;

                // Case 2
                case 2:

                    Employee e = null;
                    boolean found=false;
                    System.out.print(
                            "What is the employee id  ? ");
                    int empId = input.nextInt();

                    // Invoke remove/delete record
                    for (Employee em : employeeList) {
                        if (em.getEmployeeId() == empId) {
                            found=true;
                            e = em;
                        }
                    }
                    if(!found)
                    {
                        throw new CustomException("Employee id is not present");
                    }
                    else {
                        employeeList.remove(e);
                    }
                    System.out.print(
                            " Employee details ? ");
                    System.out.println(employeeList.toString());
                    break;

                // Case 3
                case 3:
                    System.out.println("Enter the id for which you want to change the data");
                    int emId = input.nextInt();
                    boolean founded=false;

                    for (Employee em : employeeList) {

                        if (em.getEmployeeId() == emId) {

                            // Display message only
                            founded=true;
                            System.out.print(
                                    "What is the new employee id  ? ");
                            int id = input.nextInt();

                            // Display message only
                            input.nextLine();
                            System.out.print(
                                    "What is the new employee name  ");
                            String empname = input.nextLine();

                            // Display message only
                            System.out.print(
                                    "What is the new employee designation ? ");
                            String empdesignation = input.nextLine();
                            System.out.print(
                                    "What is the new employee salary  ");
                            double empsalary = input.nextDouble();

                            em.setEmployeeId(id);
                            em.setName(empname);
                            em.setDesignation(empdesignation);
                            em.setSalary(empsalary);
                            System.out.println(
                                    "Record Updated Successfully");
                        }
                    }
                    if(!founded)
                    {
                        throw new CustomException("Employee id is not present");
                    }

                    System.out.println(employeeList.toString());

                    break;


                case 4:
                    System.out.println(employeeList.toString());
                    break;

                case 5:

                    // Display message
                    System.out.println(
                            "\nThank you for using the program. Goodbye!\n");
                    System.exit(0);

                    break;

                // If none above case executes
                default:

                    // Print statement
                    System.out.println("\nInvalid input\n");
                    break;
            }

        }
        while (option != 9) ;

    }
}



