package core;

public class DeleteTestCommand extends Command{
	
	private TestVect vect;
	
	public DeleteTestCommand(TestVect vect){
		this.vect = vect;
	}

	@Override
	public void execute() {
		DeleteTestCommandEmpfaenger.renderVector(vect);
	}

	@Override
	public void undo() {
		TestVect var = new TestVect(vect.x*(-1),vect.y*(-1));
		DeleteTestCommandEmpfaenger.renderVector(var);
	}

}
