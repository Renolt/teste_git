package course;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class ProgramComposition1 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name:");
		String nameDepartment = sc.nextLine();
		Department department = new Department(nameDepartment);
		System.out.println("Enter worker data:");
		System.out.print("Nome:");
		String name = sc.nextLine();
		System.out.print("Level:");
		String level = sc.nextLine();
		System.out.print("Base salary:");
		double baseSalaray = sc.nextDouble();
		Worker worker = new Worker(name, WorkerLevel.valueOf(level) , baseSalaray, department);
		System.out.print("How many contracts to this worker?");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next()); 
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Entser month and year to calculate income (MM/YYYY):");
		String monthYear = sc.next();
		int month = Integer.parseInt(monthYear.substring(0, 2));
		int year = Integer.parseInt(monthYear.substring(3)); 
		System.out.println(worker.getName());
		System.out.println(worker.getDepartment().getName());
		System.out.println("Income for " + monthYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}
	
	

}
