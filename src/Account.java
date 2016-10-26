
public class Account {
	
	String namn;
	double Saldo;
	
	
	public Account(String namn, double Saldo){
		this.namn = namn;
		this.Saldo = Saldo;
		
		
		
	}
	@Override
	public String toString(){
		return namn;
	}
	
	public void getPoints(){
		System.out.println(Saldo);
	}
	
	public void setname(String name){
		namn = name; 
	}
	public void setPoints( double Saldo ){
		this.Saldo = Saldo; 
		
	}
	
	public void print(){
		
		
	} 
}
