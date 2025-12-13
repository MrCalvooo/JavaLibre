package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emple_datos", "root", "");
            Statement statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);

            System.out.println("ID empleado: ");
            int emp_no = Integer.parseInt(scanner.nextLine());

            String apellido = "";
            do {
                System.out.println("Apellido: ");
                apellido = scanner.nextLine();
                if (apellido.isBlank()) {
                    System.out.println("El apellido no puede estar vacio");
                }
            } while (apellido.isBlank());

            String oficio = "";
            do {
                System.out.println("Oficio: ");
                oficio = scanner.nextLine();
                if (oficio.isBlank()) {
                    System.out.println("El oficio no puede estar vacio");
                }
            } while (oficio.isBlank());

            int dir = 0;
            do {
                System.out.println("Direccion: ");
                dir = Integer.parseInt(scanner.nextLine());
                if (dir <= 0) {
                    System.out.println("La direccion no puede estar vacia");
                }
            } while (dir <= 0);

            double salario = 0.;
            do {
                System.out.println("Salario: ");
                salario = Double.parseDouble(scanner.nextLine());
                if (salario <= 0) {
                    System.out.println("INTRODUZCA SALARIO CORRECTO POR FAVOR");
                }
            } while (salario <= 0);

            double comision = 0.;
            do {
                System.out.println("Comision: ");
                comision = Double.parseDouble(scanner.nextLine());
                if (comision <= 0) {
                    System.out.println("INTRODUZCA COMISION CORRECTA POR FAVOR");
                }
            } while (comision <= 0);

            int anyo = 0, mes = 0, dia = 0;
            do {
                System.out.println("Año de contratacion: ");
                anyo = Integer.parseInt(scanner.nextLine());

                System.out.println("Mes de contratacion: ");
                mes = Integer.parseInt(scanner.nextLine());

                System.out.println("Dia de contratacion: ");
                dia = Integer.parseInt(scanner.nextLine());
            } while (anyo == 0 || mes == 0 || dia == 0);
            String fecha = String.format("%d-%02d-%02d", anyo, mes, dia);
            LocalDate localDate = LocalDate.parse(fecha);

            System.out.println("Ingrese numero de departamento: ");
            int dept_no = Integer.parseInt(scanner.nextLine());

            ResultSet emple_exist = statement.executeQuery("SELECT emp_no FROM empleados WHERE emp_no = " + emp_no);
            if (emple_exist.next()) {
                System.out.println("No se pudo insertar el nuevo empleado al ser existente en la BBDD");
            } else {
                ResultSet dept_exist = statement.executeQuery("SELECT DEPT_NO FROM departamentos WHERE DEPT_NO = " + dept_no);
                if (!dept_exist.next()) {
                    System.out.println("Departamento no existente");
                } else {
                    String insert_emp = "INSERT INTO empleados() VALUES (?, ? , ?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(insert_emp);
                    preparedStatement.setInt(1, emp_no);
                    preparedStatement.setString(2, apellido);
                    preparedStatement.setString(3, oficio);
                    preparedStatement.setInt(4, dir);
                    preparedStatement.setDate(5, Date.valueOf(localDate));
                    preparedStatement.setDouble(6, salario);
                    preparedStatement.setDouble(7, comision);
                    preparedStatement.setInt(8, dept_no);
                    int filas = preparedStatement.executeUpdate();

                    if (filas >= 0) {
                        System.out.println("Empleado insertado correctamente");
                    } else {
                        System.out.println("Error al insertar el empleado");
                    }
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}