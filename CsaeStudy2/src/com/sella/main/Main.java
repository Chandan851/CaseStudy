package com.sella.main;
import com.sella.dao.Diagnostic;
import com.sella.dao.Login;
//import com.sella.dao.Login;
import com.sella.dao.Patient;
import com.sella.dao.Referral;
import com.sella.dao.SurgWaitList;
import com.sella.dao.Surgeon;
import com.sella.main.*;

import java.util.Scanner;
public class Main {
	public static void main(String[] args)throws Exception  {
		Scanner s = new Scanner(System.in);
		Login l=new Login();
		int flag=0,ch1,ch2,priority;
		String name,dob,gender,spclty;
		String pname,opType,sname,opDate,disDate;
		String test,result,orDate,resDate;
		String rDate,appDate;
		
		System.out.print(" _________________________________________________________________ \n");
		System.out.print("\n\n \t E-HEALTH CARE MANAGEMENT SYSTEM \n\n");        
		
		System.out.print(" _________________________________________________________________ \n");
		System.out.println("\t\t\tLOGIN");
		System.out.println("                                    ");
		System.out.println("Enter the password to login");
		String pass=s.next();
		l.login(pass);
		l.AnyKeyToContinue();
		
	
		while(flag==0) {
			System.out.print("\n\nPlease, Choose from the following Options: \n\n");
			System.out.print(" _________________________________________________________________ \n");
			System.out.print("|                                                                 |\n");
			System.out.print("|             1  >> Patient                                       |\n");
			System.out.print("|             2  >> Surgeon                                       |\n");
			System.out.print("|             3  >> Waiting List                                  |\n");
			System.out.print("|             4  >> Diagnostic List                               |\n");
			System.out.print("|             5  >> Referral                                      |\n");
			System.out.print("|             6  >> Exit                                          |\n");
			System.out.print("|_________________________________________________________________|\n\n");

			//System.out.println("Work On Table: \n1. Patient\n2. Surgeon\n3. Waiting List\n4. Diagnostic List\n5. Referral\n6. Exit");
			System.out.println("Enter your choice: ");
			ch1 = s.nextInt();
			switch(ch1) {
			case 1:
				Patient p = new Patient();
				flag = 1;
				while(flag==1) {
					System.out.println("------------------------------------------------------------------");
					System.out.print(" _________________________________________________________________ \n");
					System.out.print("|                                                                 |\n");
					System.out.print("|             1  >> Add Patient                                   |\n");
					System.out.print("|             2  >> Display Patient                               |\n");
					System.out.print("|             3  >> Remove Patient                                |\n");
					System.out.print("|             4  >> Select Diffrent Table                         |\n");
					System.out.print("|_________________________________________________________________|\n\n");

					//System.out.println("1. Add Patient\n2. Display table\n3. Remove Patient\n4. Select Different Table");
					System.out.println("Enter your choice: ");
					ch2 = s.nextInt();s.nextLine();
					switch(ch2) {
					case 1:
						System.out.println("Enter Name: ");
						name = s.next();
						System.out.println("Enter DOB: ");
						dob = s.next();
						System.out.println("Enter Gender: ");
						gender = s.next();
						p.addPatient(name,dob,gender);
						break;
					case 2:
						p.display();
						break;
					case 3:
						System.out.println("Enter Patient name to remove: ");
						name = s.nextLine();
						p.removePatient(name);
						break;
					case 4:
						flag = 0;
						System.out.println("------------------------------------------------------------");
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
				break;
				
			
			case 2:
				Surgeon sc = new Surgeon();
				flag = 1;
				while(flag==1) {
					System.out.println("--------------------------------------------------------------------");
					System.out.print(" _________________________________________________________________ \n");
					System.out.print("|                                                                 |\n");
					System.out.print("|             1  >> Add Surgeon                                   |\n");
					System.out.print("|             2  >> Display Details of Surgeon                    |\n");
					System.out.print("|             3  >> Remove Surgeon                                |\n");
					System.out.print("|             4  >> Select Diffrent Table                         |\n");
					System.out.print("|_________________________________________________________________|\n\n");

					//System.out.println("1. Add Surgeon\n2. Display table\n3. Remove Surgeon\n4. Select Different Table");
					System.out.println("Enter your choice: ");
					ch2 = s.nextInt();
					s.nextLine();
					switch(ch2) {
					case 1:
						System.out.println("Enter Name: ");
						name = s.nextLine();
						System.out.println("Enter Specialty: ");
						spclty = s.nextLine();
						sc.addSurgeon(name, spclty);
						break;
					case 2:
						sc.display();
						break;
					case 3:
						System.out.println("Enter Surgeon name to remove: ");
						name = s.nextLine();
						sc.removeSurgeon(name);
						break;
					case 4:
						flag = 0;
						System.out.println("----------------------------------------------------------------");
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
				break;
				
		
			case 3:
				SurgWaitList sw = new SurgWaitList();
				flag = 1;
				while(flag==1) {
					System.out.println("---------------------------------------------------------------------");
					System.out.print(" _________________________________________________________________ \n");
					System.out.print("|                                                                 |\n");
					System.out.print("|             1  >> Add Patient To WaitList                       |\n");
					System.out.print("|             2  >> Display WaitList                              |\n");
					System.out.print("|             3  >> Remove Patient from WaitList                  |\n");
					System.out.print("|             4  >> Select Diffrent Table                         |\n");
					System.out.print("|_________________________________________________________________|\n\n");

					//System.out.println("1. Add Patient to Waitlist\n2. Display Waitlist\n3. Remove Patient from Waitlist\n4. Select Different Table");
					System.out.println("Enter your choice: ");
					ch2 = s.nextInt();
					s.nextLine();
					switch(ch2) {
					case 1:
						System.out.println("Enter Patient name: ");
						pname = s.nextLine();
						System.out.println("Enter Type of Operation: ");
						opType = s.nextLine();
						System.out.println("Enter Priority: ");
						priority = s.nextInt();
						s.nextLine();
						System.out.println("Enter Surgeon name: ");
						sname = s.nextLine();
						System.out.println("Enter Operation date: ");
						opDate = s.nextLine();
						System.out.println("Enter Discharge date: ");
						disDate = s.nextLine();
						sw.addPatient(pname, opType, priority, sname, opDate, disDate);
						break;
					case 2:
						sw.display();
						break;
					case 3:
						System.out.println("Enter Patient name to remove: ");
						pname = s.nextLine();
						sw.removePatient(pname);
						break;
					case 4:
						flag = 0;
						System.out.println("--------------------------------------------------------------");
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
				break;
				
			
			case 4:
				Diagnostic d = new Diagnostic();
				flag = 1;
				while(flag==1) {
					System.out.println("------------------------------------------------------------------");
					System.out.print(" _________________________________________________________________ \n");
					System.out.print("|                                                                 |\n");
					System.out.print("|             1  >> Add Order                                     |\n");
					System.out.print("|             2  >> Display Order                                 |\n");
					System.out.print("|             3  >> Update Result                                 |\n");
					System.out.print("|             4  >> Select Diffrent Table                         |\n");
					System.out.print("|_________________________________________________________________|\n\n");

					//System.out.println("1. Add Order\n2. Display Orders\n3. Update result\n4. Select Different Table");
					System.out.println("Enter your choice: ");
					ch2 = s.nextInt();s.nextLine();
					switch(ch2) {
					case 1:
						System.out.println("Enter Test name: ");
						test = s.nextLine();
						System.out.println("Enter Patient name: ");
						pname = s.nextLine();
						System.out.println("Enter Surgeon name: ");
						sname = s.nextLine();
						System.out.println("Enter Order date: ");
						orDate = s.nextLine();
						System.out.println("Enter Result date: ");
						resDate = s.nextLine();
						d.addOrder(test, pname, sname, orDate, resDate);
						break;
					case 2:
						d.display();
						break;
					case 3:
						System.out.println("Enter Patient name: ");
						pname = s.nextLine();
						System.out.println("Enter Result: ");
						result = s.nextLine();
						d.updateResult(pname, result);
						break;
					case 4:
						flag = 0;
						System.out.println("---------------------------------------------------------------");
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
				break;
				
			case 5:
				Referral r = new Referral();
				flag = 1;
				while(flag==1) {
					System.out.println("-------------------------------------------------------------------");
					System.out.print(" _________________________________________________________________ \n");
					System.out.print("|                                                                 |\n");
					System.out.print("|             1  >> Add Referal                                   |\n");
					System.out.print("|             2  >> Display Referal list                          |\n");
					System.out.print("|             3  >> Remove Referal                                |\n");
					System.out.print("|             4  >> Change Appointment Date                       |\n");
					System.out.print("|             5  >> Select Diffrent Table                         |\n");
					System.out.print("|_________________________________________________________________|\n\n");

					//System.out.println("1. Add Referral\n2. Display Referral list\n3. Remove Referral\n4. Change Appointment date\n5. Select Different Table");
					System.out.println("Enter your choice: ");
					ch2 = s.nextInt();s.nextLine();
					switch(ch2) {
					case 1:
						System.out.println("Enter Patient name: ");
						pname = s.nextLine();
						System.out.println("Enter Referral date: ");
						rDate = s.nextLine();
						System.out.println("Enter Priority: ");
						priority = s.nextInt();s.nextLine();
						System.out.println("Enter Surgeon name: ");
						sname = s.nextLine();
						System.out.println("Enter Appointment date: ");
						appDate = s.nextLine();
						r.addRef(pname, rDate, priority, sname, appDate);
						break;
					case 2:
						r.display();
						break;
					case 3:
						System.out.println("Enter Patient name to remove referral: ");
						pname = s.nextLine();
						r.removeRef(pname);
						break;
					case 4:
						System.out.println("Enter Patient name: ");
						pname = s.nextLine();
						System.out.println("Enter new Appointment date: ");
						appDate = s.nextLine();
						r.updateAppDate(pname, appDate);
						break;
					case 5:
						flag = 0;
						System.out.println("--------------------------------------------------------");
						break;
					default:
						System.out.println("Invalid Choice");
					}
				}
				break;
				
			case 6:
				flag = 1;
	
				System.out.println("-------------------------Thank You----------------------------");

				break;
			default:
			}
		}
	}
}
