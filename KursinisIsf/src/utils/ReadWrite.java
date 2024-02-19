package utils;

import model.Shop;

import java.io.*;

public class ReadWrite {
    public static Shop loadFromFile(String fileName) {
        Shop shop = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            shop = (Shop) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return shop;
    }

    public static void writeToFile(String fileName, Shop shop) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(shop);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
