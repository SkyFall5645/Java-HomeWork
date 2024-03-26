import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Item> queue = new PriorityQueue<>();
        String input;
        while (!(input = scanner.nextLine()).equals("end")) {
            String[] data = input.split(" ");
            queue.add(new Item(data[0], data[1], Integer.parseInt(data[2])));
        }
        try {
            FileWriter writer = new FileWriter("output.txt", true);
            for (int i = 0; i < 10; i++) {
                writer.write(queue.poll().toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Item implements Comparable<Item> {
    private String id;
    private String name;
    private int weight;

    public Item(String id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Weight: " + weight;
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(o.weight, weight);
    }
}
