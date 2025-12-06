package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/emple_datos", "root", "");
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            System.out.printf("Driver %s version %s\n", databaseMetaData.getDriverName(), databaseMetaData.getDriverVersion());
            System.out.printf("Maximo de conexiones permitidas: %d\n", databaseMetaData.getMaxConnections());
            System.out.println("Tablas: ");
            ResultSet rs = databaseMetaData.getTables(null, null, null, new String[]{"TABLE", "VIEW"});
            while (rs.next()) {
                String tabla = rs.getString("TABLE_NAME");
                String tipo = rs.getString("TABLE_TYPE");
                System.out.printf("Tabla %s de tipo %s\n", tabla, tipo);
            }

            rs = databaseMetaData.getColumns(null, null, "empleados", "%no");
            System.out.println("================DATOS DE LA TABLA EMPLEADOS================");
            while (rs.next()) {
                String columna = rs.getString("COLUMN_NAME");
                String tipo = rs.getString("TYPE_NAME");
                boolean autoincrementable = rs.getBoolean("IS_AUTOINCREMENT");
                System.out.printf("Columna %s de tipo %s, ¿autoincrementable?: %b\n", columna, tipo, autoincrementable);
            }

            System.out.println("================CLAVES DE LA TABLA EMPLEADOS================");
            rs = databaseMetaData.getExportedKeys(null, null, "empleados");
            boolean tieneExportadas = false;
            while (rs.next()) {
                tieneExportadas = true;
                System.out.printf("Tabla que referencia a empleados: %s | Columna FK: %s\n",
                        rs.getString("FKTABLE_NAME"),
                        rs.getString("FKCOLUMN_NAME"));
            }
            if (!tieneExportadas) {
                System.out.println("La tabla empleados NO es referenciada por ninguna tabla.");
            }

            rs = databaseMetaData.getImportedKeys(null, null, "empleados");
            boolean tieneImportadas = false;
            while (rs.next()) {
                tieneImportadas = true;
                System.out.printf("Tabla referenciada: %s | PK columna: %s | FK en empleados: %s\n",
                        rs.getString("PKTABLE_NAME"),
                        rs.getString("PKCOLUMN_NAME"),
                        rs.getString("FKCOLUMN_NAME"));
            }
            if (!tieneImportadas) {
                System.out.println("La tabla empleados NO referencia a ninguna otra tabla.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}