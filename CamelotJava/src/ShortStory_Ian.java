import com.storygraph.ActionMap;
import com.storygraph.INode;
import com.storygraph.Node;
import com.actions.*;
import com.entities.*;
import com.entities.Character;
import com.entities.Things.ThingNames;
import com.sequences.CharacterCreation;
import java.util.Hashtable;

public class ShortStory_Ian implements IStory{
	private Hashtable<ThingNames,Character> characterList;
	private Hashtable<>
	
	private enum ActionNames{};
	
	
	private enum NodeLabels{
		Start, Init, Cottage, City, CastleCrossRoad, Getsword, Sword_city, SwordBlackSmith, TalktoBlacksmith2,
		GetHelmet2, SuccessSpookyRoad, BanditSubmit, Dungeon, FightWithWarlock, Blacksmith, GetHelmet, HelmetCity, 
		HelmetCrossroad, HelmetGreatHall, HelmetGetSword, FailSpookyRoad, BanditWin, GuardCamp,GetSwordHelmet, 
		GameOVER, GreatHall	
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
		SQ.add(new SetCameraFocus(jojo));
		
		return null;
	}
	private ActionSequence getStartSQ() {return null;}
	private ActionSequence getCitySQ() {return null;}
	private ActionSequence getCottageSQ() {return null;}
	private ActionSequence getCastleCrossRoadSQ() {return null;}
	private ActionSequence getGetSwordSQ() {return null;}
	private ActionSequence getSword_CitySQ() {return null;}
	private ActionSequence getSwordBlackSmithSQ() {return null;}
	private ActionSequence getTalktoBlacksmithSQ() {return null;}
	private ActionSequence getGetHelmet2SQ() {return null;}
	private ActionSequence getSuccessSpookyRoadSQ() {return null;}
	private ActionSequence getBanditSubmitSQ() {return null;}
	private ActionSequence getDungeonSQ() {return null;}
	private ActionSequence getFightWithWarlockSQ() {return null;}
	private ActionSequence getBlacksmithSQ() {return null;}
	private ActionSequence getGetHelmetSQ() {return null;}
	private ActionSequence getHelmetCitySQ() {return null;}
	private ActionSequence getHelmetCrossroadSQ() {return null;}
	private ActionSequence getHelmetGreatHallSQ() {return null;}
	private ActionSequence getHelmetGetSwordSQ() {return null;}
	private ActionSequence getFailSpookyRoadSQ() {return null;}
	private ActionSequence getBanditWinSQ() {return null;}
	private ActionSequence getGuardCampSQ() {return null;}
	private ActionSequence getGetSwordHelmetSQ() {return null;}
	private ActionSequence getGameOVERSQ() {return null;}
	private ActionSequence getGreatHallSQ() {return null;}
	
		
}
