
public class toto {
	
	private int bob;

	public toto(){
		this.pd();
	}
	public int getBob() {
		return bob;
	}

	public void setBob(int bob) {
		this.bob = bob;
	}

	@Override
	public String toString() {
		return "toto [bob=" + bob + "]";
	}
	
	
	public String getJoe() {
		return joe;
	}

	public void setJoe(String joe) {
		this.joe = joe;
	}


	private String joe; 

	public void pd(){
		String xavier;
		xavier ="pd";
		while (xavier == "pd"){
			System.out.println("caca");
		}
	}
	
}

