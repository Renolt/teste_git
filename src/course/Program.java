package course;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import entities.Room;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Room> rooms = new ArrayList<>();
		for (int i = 0; i<10; i++) {
			Room room = new Room();
			rooms.add(room);
		}
		
		System.out.println("How many rooms will be rnted? (máx 10):");
		Integer numberRooms = sc.nextInt();
		sc.nextLine();
		
		
		
		for (int i = 0; i<numberRooms; i++) {
			System.out.println("Rent #"+(i+1)+":");			
			System.out.print("Name:");
			String name = sc.nextLine();
			System.out.print("Email:");
			String email = sc.nextLine();
			System.out.print("Room: (0 a 9)");
			Integer room = sc.nextInt();
			sc.nextLine();
			while (rooms.get(room).getRoom() != null) {
				System.out.println("Room rented. try another room:");
				System.out.print("Room: (0 a 9):");
				room = sc.nextInt();
				sc.nextLine();				
			}
			Room roomObject = rooms.get(room);
			roomObject.setName(name);
			roomObject.setEmail(email);
			roomObject.setRoom(room);		
			
		}
		
		for(Room room : rooms) {
			if(room.getRoom() != null) {
				System.out.println(room.toString());
			}			
		}
		
		sc.close();
		

	}

}
