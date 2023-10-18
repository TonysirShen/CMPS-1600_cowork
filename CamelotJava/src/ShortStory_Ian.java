import com.storygraph.ActionMap;
import com.storygraph.INode;
import com.storygraph.Node;
import com.actions.*;
import com.entities.*;
import com.entities.Character;
import com.entities.Things.ThingNames;
import com.sequences.CharacterCreation;

public class ShortStory_Ian implements IStory{
	private Character jojo;
	private Place home;
	
	private enum ActionNames{};
	
	
	private enum NodeLabels{
		Start, Init
	}
	
	public ShortStory_Ian() {
		getThings();
	}

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
		var jojo = new Character("Jojo");
		// TODO Auto-generated method stub
	}

	//Action Sequence
	private ActionSequence getInitSQ(){
		var SQ = new ActionSequence();
		SQ.combineWith(new CharacterCreation(jojo));
		SQ.add(new Create<Place>(home));
		SQ.add(new Position(jojo, home));
		SQ.add(SetCamera);
		
		return null;
	}
	
}
