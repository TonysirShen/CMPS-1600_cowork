import com.storygraph.ActionMap;
import com.storygraph.INode;
import com.storygraph.Node;
import com.actions.ActionSequence;
import com.entities.*;
import com.entities.Character;
import com.entities.Things.ThingNames;

public class ShortStory implements IStory{

	@Override
	public ActionMap getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public INode getRoot() {
		
		return new Node("root");
	}

	@Override
	public void getThings() {
		var john = new Character("John");
		// TODO Auto-generated method stub
	}

	//Action Sequence
	private ActionSequence getInitSQ(){
		return null;
	}
}
