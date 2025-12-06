package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/emple_datos", "root", "");
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            System.out.printf("Soporta la BBDD transacciones?: %b\n", databaseMetaData.supportsTransactions());
            System.out.println("=========Palabras clave SQL NO estándar:===================");
            System.out.println(databaseMetaData.getSQLKeywords());
            ResultSet rs = databaseMetaData.getTables(null, null, null, new String[]{"SYSTEM TABLE"});
            System.out.println("==============TABLAS DEL SISTEMA==============");
            boolean tablasSistema = false;
            while (rs.next()) {
                tablasSistema = true;
                System.out.println(rs.getString("TABLE_NAME") + " " + rs.getString("TABLE_TYPE"));
            }
            if (!tablasSistema) {
                System.out.println("No se encontraron tablas del sistema");
            }

            System.out.println("==============TABLAS DEL DEPARTAMENTO==============");
            rs = databaseMetaData.getColumns(null, null, "departamentos", "d%");
            while (rs.next()) {
                String nombre = rs.getString("COLUMN_NAME");
                String posicion = rs.getString("ORDINAL_POSITION");
                String valordef = rs.getString("COLUMN_DEF");
                System.out.printf("%s -> %s -> %s\n", nombre, posicion, valordef);
            }

            rs = databaseMetaData.getExportedKeys(null, null, "empleados");
            boolean exportadas = false;
            while (rs.next()) {
                exportadas = true;
                System.out.printf("Tabla referenciada %s desde la columna %s\n",
                        rs.getString("FKTABLE_NAME"), rs.getString("FKCOLUMN_NAME"));
            }
            if (!exportadas) {
                System.out.println("No existen referencias desde la tabla empleados");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}