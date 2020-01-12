import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int n = Integer.parseInt(rd.readLine());

        HashMap<String, Department> departments = new HashMap<>();

        while(n-- > 0){
            String[] tokens = rd.readLine().split("\\s+");
            String departmentName = tokens[3];

            Employee emp = new Employee(
                    tokens[0],
                    Double.parseDouble(tokens[1]),
                    tokens[2]
            );

            if (tokens.length == 5){
                if (Character.isDigit(tokens[4].charAt(0))){
                    emp.setAge(Integer.parseInt(tokens[4]));
                }else{
                    emp.setEmail(tokens[4]);
                }
            }else if (tokens.length == 6){
                emp.setEmail(tokens[4]);
                emp.setAge(Integer.parseInt(tokens[5]));
            }

            if (!departments.containsKey(departmentName)){
                departments.put(departmentName, new Department());
                departments.get(departmentName).addEmployee(emp);
            }else{
                departments.get(departmentName).addEmployee(emp);
            }

        }

        Map.Entry<String, Department> highestAvgSalary = departments.entrySet().stream()
                .sorted((f, s) -> {
                    int result = 0;
                    if(s.getValue().getAverageSalary() > f.getValue().getAverageSalary()){
                        result = 1;
                    }else if (s.getValue().getAverageSalary() < f.getValue().getAverageSalary()){
                        result = -1;
                    }
                        return result;

                }).findFirst()
                .get();

        System.out.println(String.format("Highest Average Salary: %s", highestAvgSalary.getKey()));
        highestAvgSalary.getValue().getEmployees()
                .stream()
                .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(emp -> {
                    System.out.println(String.format("%s %.2f %s %d",
                            emp.getName(),
                            emp.getSalary(),
                            emp.getEmail(),
                            emp.getAge()
                    ));
                });

        }
    }

