package serialization_deserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Serialization_Deserialization {

	/*
	 * SerialVersionUID , her sınıf için benzersiz bir tanımlayıcıdır, 
	 * JVM , aynı sınıfın Serileştirme sırasında kullanıldığından emin olarak sınıfın 
	 * sürümlerini karşılaştırmak için kullanır. Birini
	 */
	
//	Serialization is a mechanism of converting the 
//	state of an object into a byte stream 
	
//	Deserialization is the reverse process 
//	where the byte stream is used to recreate 
//	the actual Java object in memory. 
//	This mechanism is used to persist the object.
	
	
//	ObjectOutputStream. Java.io paketinin ObjectOutputStream sinifi,
//	ObjectInputStream tarafindan okunabilen nesneleri yazmak icin kullanilabilir.
//	OutputStream soyut sinifini genisletir. Temel olarak ObjectOutputStream,
//	sinif adini ve nesne degerlerini kullanarak
//	Java nesnelerini kodlar ve karsilik gelen ak��lar� olusturur.
	public static void main(String[] args) throws IOException {
		
//		User user1=new User(1L, "John Coffee", "456-34-3434");
//		User user2=new User(2L, "Tony Stark", "654-34-3434");
//		User user3=new User(3L, "James Bond", "567-34-3434");
//		
//		
//		try (FileOutputStream fos=new FileOutputStream("user.ser")){
//			try (ObjectOutputStream oos=new ObjectOutputStream(fos)){
//				
//				oos.writeObject(user1);
//				oos.writeObject(user2);
//				oos.writeObject(user3);
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		readObject();

	}
	
	
	static void readObject() {
		try(FileInputStream fis=new FileInputStream("user.ser")){
			
			try(ObjectInputStream ois=new ObjectInputStream(fis)){
				
				try {
					User user1=(User) ois.readObject();
					User user2=(User) ois.readObject();
					User user3=(User) ois.readObject();
					
					System.out.println(user1.toString());
					System.out.println(user2.toString());
					System.out.println(user3.toString());
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}


class User implements Serializable{
	
	/**
	 * 
	 */
	//serialVersionUID is used to ensure that during deserialization  the same class is loaded
	//private static final long serialVersionUID = 2L;
	
	
	private Long id;
	private String name;
	private String ssn;
	
	

	public User(Long id, String name, String ssn) {
		this.id = id;
		this.name = name;
		this.ssn = ssn;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSsn() {
		return ssn;
	}



	public void setSsn(String ssn) {
		this.ssn = ssn;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", ssn=" + ssn + "]";
	}
	
	
	
}