import java.util.HashMap;

public abstract class Item {
	HashMap<ECapability,ICapability> capabilities;
	
	public abstract void addCapability(ECapability ec, ICapability ic);
	
	public abstract ICapability getCapability(ECapability ec);
}
