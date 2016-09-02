import java.util.HashMap;

public class Start extends Item {

	public Start() {
		this.capabilities = new HashMap<ECapability, ICapability>();
	}

	@Override
	public void addCapability(ECapability ec, ICapability ic) {
		this.capabilities.put(ec, ic);
	}

	@Override
	public ICapability getCapability(ECapability ec) {
		return this.capabilities.get(ec);
	}
	
	public static void main(String[] args) {
		Start s = new Start();
		s.addCapability(ECapability.ARMOR, ic);
	}

}
