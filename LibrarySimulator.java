package projectCSC111;
import java.util.Scanner;

public class LibrarySimulator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		Member user1 = new Member(1, "ALZUBAYR", 0);
		Member user2 = new Member(2, "ABDULELAH", 0);
		Member user3 = new Member(3, "ABDULRAHMAN", 0);
		
        int mainMenuChoice, userMenuChoice, adminMenuChoice;
        
        System.out.println("Welcome to the program!");
        
        
        
        do{
            System.out.printf("[1] Login as Account 1 (Username: %s, ID: %d)\n", user1.getName(), user1.getId());
            System.out.printf("[2] Login as Account 2 (Username: %s, ID: %d)\n", user2.getName(), user2.getId());
            System.out.printf("[3] Login as Account 3 (Username: %s, ID: %d)\n", user3.getName(), user3.getId());
            System.out.println("[4] Login as Administrator");
            System.out.println("[5] Exit the Program");
            System.out.print("\nPlease select an option: ");
            mainMenuChoice = input.nextInt();
            Member currentUser;

            if (mainMenuChoice==1)
            	currentUser = user1;
            else if (mainMenuChoice==2)
            	currentUser = user2;
            else
            	currentUser = user3;
            	
            
            
            switch(mainMenuChoice){
                case 1:
                case 2:
                case 3:
                    // Resetting parameters for each session
                    // Do this loop while the user hasn't chosen to exit to main menu (5)
                    // When the user exits the program, Check which account they chose and assign 
                    // the session parameter values to the specific account parameter values, then
                    // exit to the main menu.
                    do{
                        System.out.println("\n\n[1] Show Currently Borrowed Books");
                        System.out.println("[2] Borrow Book");
                        System.out.println("[3] Return Book");
                        System.out.println("[4] View Session Statistics");
                        System.out.println("[5] Exit to main menu");
                        System.out.print("\nPlease select an option: ");
                        userMenuChoice = input.nextInt();
                        
                        switch(userMenuChoice)
                        {
                            
                        	case 1: 
                        		currentUser.viewBorrowedCount();
                        		break;
                                
                            case 2: 
                            	currentUser.borrowOne();
                                break;
                                
                            case 3:
                            	currentUser.returnOne();
                                break;
                                
                            case 4:
                            	currentUser.displayStatistics();
                            	break;
                            
                            case 5: 
                                currentUser.reset();
                                break;
                              
                            default:
                            	System.out.println("ERROR: Please input a choice between 1 and 5!");
                        }
                    }while(userMenuChoice != 5);
                    break;
                
                    
                    
                    
                case 4:
                    // Do this loop while the user hasn't chosen to exit to main menu (3)
                    do{
                        System.out.println("\n\n[1] View Total Revenue");
                        System.out.println("[2] View Most Common Operation");
                        System.out.println("[3] Exit to main menu");
                        System.out.print("\nPlease select an option: ");
                        adminMenuChoice = input.nextInt();
                        
                        switch(adminMenuChoice){
                        
                            case 1:
                                System.out.printf("Total Revenue: %.2f\n", Member.TotalRevenue );
                                break;
                                
                                
                            case 2:
                                
                            	if(Member.TotalBorrows > Member.TotalReturns)
                                {
                                    System.out.println("Most Common Operation: Borrowing");
                                }
                                
                                else if(Member.TotalReturns > Member.TotalBorrows)
                                {
                                    System.out.println("Most Common Operation: Returning");
                                }
                                
                                else if( Member.TotalBorrows == 0 && Member.TotalReturns == 0)
                                {
                                    System.out.println("Most Common Operation: None");
                                }
                                
                                else 
                                {
                                    System.out.println("Most Common Operation: Borrowing and Returning");
                                }
                            	
                                break;
                                
                                
                            case 3:
                                break;
                                
                            default:
                            	System.out.println("ERROR: Please input a choice between 1 and 3!");
                        }
                    }while(adminMenuChoice != 3);
                    break;
                    
                case 5:
                    break;
                    
                default: System.out.println("ERROR: Please input a choice between 1 and 5!");
            }
        }while(mainMenuChoice != 5);


		
    	input.close();
	}
	

}
