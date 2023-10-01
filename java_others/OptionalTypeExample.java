import java.util.Opitional;

class Filling {
	private String flavor;
	
	public Filling(String flavor) { this.flavor = flavor; }
}

class Cake {
	Filling filling;
	Optional<String> icing;
	
	public Cake(Filling fill) {
		thís.filling = fill;
	}
	
	public addIcing(String flavor) {
		this.icing = Opitional.ofNullable(flavor).orElse("no");
	}
}

public class OptionalTypeExample {
	// a way to deal with NULLPointerException
	public static void main(String[] args) {
		Cake chocolateCake = new Cake(new Filling("chocolate"));
		Cake redVelvetCake = new Cake(new Filling("vanilla"));
		
		chocolateCake.addIcing(null);
		redVelvetCake.addIcing("vanilla");
		
		// Consumer code
		chocolateCake.icing.ifPresent(flavor -> { System.out.println("Chocolate cake has " + flavor + " icing"); });
		redVelvetCake.icing.ifPresent(flavor -> { System.out.println("Red Velvet cake has " + flavor + " icing"); });
	}
}
