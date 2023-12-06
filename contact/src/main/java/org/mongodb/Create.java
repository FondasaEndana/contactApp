package org.mongodb;

import org.bson.Document;
import java.util.Scanner;
import org.mongodb.Main;

import static java.lang.Integer.parseInt;

public class Create {
    public static void main(String[] args) {
        Main crud = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Pilih operasi CRUD:");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Keluar");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create
                    System.out.println("Masukkan data baru:");
                    System.out.print("Nama: ");
                    String nama = scanner.next();
                    System.out.print("Usia: ");
                    int usia = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("NoTelp: ");
                    String notelp = scanner.nextLine();
                    Document newDocument = new Document("nama", nama)
                            .append("usia", usia)
                            .append("email", email)
                            .append("notelp", notelp);
                    crud.createDocument(newDocument);
                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case 2:
                    // Read
                    System.out.println("Masukkan kriteria Read Kontak:");
                    System.out.print("Key: ");
                    String key = scanner.next();
                    System.out.print("Value: ");
                    Object value = scanner.next();
                    Document result = crud.readDocument(key, value);
                    System.out.println("Hasil Read: " + result);
                    break;

                case 3:
                    // Update
                    System.out.println("Masukkan kriteria Update Kontak:");
                    System.out.print("Key: ");
                    String updateKey = scanner.next();
                    System.out.print("Value: ");
                    Object updateValue = scanner.next();

                    scanner.nextLine();

                    System.out.println("Masukkan data yang diperbarui:");
                    System.out.print("NoTelp: ");
                    String updatedNotelp = scanner.nextLine();
                    Document updatedDocument = new Document("notelp", updatedNotelp);
                    crud.updateDocument(updateKey, updateValue, updatedDocument);
                    System.out.println("Data berhasil diperbarui!");
                    break;

                case 4:
                    // Delete
                    System.out.println("Masukkan kriteria Kontak yang ingin Dihapus:");
                    System.out.print("Key: ");
                    String deleteKey = scanner.next();
                    System.out.print("Value: ");
                    Object deleteValue = scanner.next();
                    crud.deleteDocument(deleteKey, deleteValue);
                    System.out.println("Data berhasil dihapus!");
                    break;

                case 0:
                    // Keluar dari program
                    System.exit(0);

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }
}
