package enums;

public class Test {
	 /*
	  * If we look at the above example, we have two risks with using constants that are solved by the enum.

	We can pass any int constant to the constantMethod method but 
	we can pass only fixed values to enumMethod, so it provides type safety.
	We can change the int constants value in TransactionTypeConstant class 
	but the above program will not throw any exception. Our program might not work as expected 
	but if we change the enum constants, we will get compile time error 
	that removes any possibility of runtime issues.
	  */
	
	public static void main(String[] args) {
		benefitsOfEnumOverConstant();
	}
	
	
	private static void benefitsOfEnumOverConstant() {
		
		enumMethod(TransactionType.DEPOSIT);
		enumMethod(TransactionType.WITHDRAW);
		enumMethod(TransactionType.TRANSFER);
		enumMethod(TransactionType.PAYMENT);
		enumMethod(TransactionType.OTHER);
		
		System.out.println("-------------------------------");
		
		//use values() method to get all values in the Enum Type
		for (TransactionType tt : TransactionType.values()) {
			System.out.println(tt.name().toString());
		}
		
		//ordinal gives the position in the enum declaration
		System.out.println("Position:"+TransactionType.DEPOSIT.ordinal());
		
		System.out.println("Transaction Code for DEPOSIT:"+TransactionType.DEPOSIT.getTransactionCode());
		
		
		System.out.println("-------------------------------");
		
		constantMethod(1);
		constantMethod(2);
		constantMethod(3);
		constantMethod(4);
		constantMethod(5);
		
	}
	
	
  private static void enumMethod(TransactionType tt) {
	  
//	  if(tt==TransactionType.DEPOSIT) {
//		  System.out.println("Money is depositing");
//	  } else if(tt==TransactionType.WITHDRAW) {
//		  System.out.println("Money is witdrawing");
//	  } else if(tt==TransactionType.TRANSFER) {
//		  System.out.println("Money is transfering");
//	  }else if(tt==TransactionType.PAYMENT) {
//		  System.out.println("Money is using for payment");
//	  }else {
//		  System.out.println("Other transaction");
//	  }
	  
	  
	switch (tt) {
	case DEPOSIT:
		System.out.println("Money is depositing");
		break;
	case WITHDRAW:
		 System.out.println("Money is witdrawing");
		break;
	case TRANSFER:
		System.out.println("Money is transfering");
		break;
		
	case PAYMENT:
		 System.out.println("Money is using for payment");
		break;
		
	default:
		System.out.println("Other transaction");
		break;
	}
	  
	  
  }
  
  private static void constantMethod(int i) {
	  if(i==TransactionTypeConstant.DEPOSIT) {
		  System.out.println("Money is depositing");
	  } else  if(i==TransactionTypeConstant.WITHDRAW) {
		  System.out.println("Money is witdrawing");
	  }else  if(i==TransactionTypeConstant.TRANSFER) {
		  System.out.println("Money is transfering");
	  }else  if(i==TransactionTypeConstant.PAYMENT) {
		  System.out.println("Money is using for payment");
	  }else {
		  System.out.println("Other transaction");
	  }
	  
	  
  }

}
