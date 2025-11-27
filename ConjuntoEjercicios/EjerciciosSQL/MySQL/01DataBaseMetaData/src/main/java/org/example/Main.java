package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emple_datos", "root", "");
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.printf("Nombre del producto de la BBDD: %s\n", metaData.getDatabaseProductName());
            System.out.printf("Nombre del driver: %s, version: %s\n", metaData.getDriverName(), metaData.getDriverVersion());
            System.out.printf("¿El SGBD soporta transacciones?: %b\n", metaData.supportsTransactions());

            ResultSet tablas = metaData.getTables("emple_datos", null, null, new String[]{"TABLE"});
            while (tablas.next()) {
                System.out.println("--------------------------------------------------------------------------");
                String tabla = tablas.getString("TABLE_NAME");
                System.out.printf("Nombre de la tabla: %s\n", tabla);
                System.out.printf("Datos de las columnas de la tabla %s:\n", tabla);
                ResultSet columnas = metaData.getColumns("emple_datos", null, tabla, null);
                while (columnas.next()) {
                    System.out.printf("Columna: %-5s de tipo %-5s, ¿autoincrementable?: %b\n",
                            columnas.getString("COLUMN_NAME"), columnas.getString("TYPE_NAME"),
                            columnas.getBoolean("IS_AUTOINCREMENT"));
                    System.out.println("--------------------------------------------------------------------------");
                }

                System.out.println("Columnas con 'sal' en el nombre: ");
                columnas = metaData.getColumns("emple_datos", null, null, "%sal%");
                while (columnas.next()) {
                    System.out.printf("Columna: %s\n", columnas.getString("COLUMN_NAME"));
                }

                ResultSet pks = metaData.getPrimaryKeys("emple_datos", null, tabla);
                while (pks.next()) {
                    System.out.printf("Columna PK: %-5s\n", pks.getString("COLUMN_NAME"));
                }
                ResultSet fks = metaData.getImportedKeys("emple_datos", null, tabla);
                while (fks.next()) {
                    System.out.printf("Columna FK: %-5s, Referencia a: %-5s\n",
                            fks.getString("FKCOLUMN_NAME"), fks.getString("PKTABLE_NAME"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}