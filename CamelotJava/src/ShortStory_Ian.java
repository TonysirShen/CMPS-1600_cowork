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
		GameOVER, GreatHall, CityArrest, JailGameOver, StartJailQuest, ClothGameover, MerchantTalk, ClothPort,
		ReturnToCity, PeasantClothing
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
	private ActionSequence getStartSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getCitySQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getCottageSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getCastleCrossRoadSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getGetSwordSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getSword_CitySQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getSwordBlackSmithSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getTalktoBlacksmithSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getGetHelmet2SQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getSuccessSpookyRoadSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getBanditSubmitSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getDungeonSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getFightWithWarlockSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getBlacksmithSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getGetHelmetSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getHelmetCitySQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getHelmetCrossroadSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getHelmetGreatHallSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getHelmetGetSwordSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getFailSpookyRoadSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getBanditWinSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getGuardCampSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getGetSwordHelmetSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getGameOVERSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getGreatHallSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence geCityArresttSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getJailGameOverSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getStartJailQuestSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getClothGameOverSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getMerchantTalkSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getClothPortSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getReturnToCitySQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	private ActionSequence getPeasantClothingSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	
		
}
