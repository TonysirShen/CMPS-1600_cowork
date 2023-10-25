import com.storygraph.ActionMap;

import com.storygraph.INode;
import com.storygraph.Node;

import java.util.Hashtable;

import com.actions.*;
import com.entities.*;
import com.entities.Character;
import com.entities.Character.Clothing;
import com.entities.Character.HairStyle;
import com.entities.IThing.ThingNames;
import com.entities.Item.Items;
import com.entities.Place.Places;
import com.playerInput.*;
import com.sequences.CharacterCreation;

public class ShortStory_main implements IStory{
	private Hashtable<ThingNames,Character> characterList = new Hashtable();
	private Hashtable<ThingNames,Place> placeList = new Hashtable();
	private Hashtable<ThingNames,Item> itemList = new Hashtable();
	
	private enum ActionNames{};
	private enum NodeLabels{
		Start, Init, Cottage, City, CastleCrossRoad, Getsword, Sword_city, swordBlackSmith, TalktoBlacksmith2,
		gethelmet2, successSpookyRoad, BanditSubmit, Dungeon, FightWithWarlock, Blacksmith, getHelmet, helmetCity, 
		helmetCrossroad, helmetGreatHall, helmetGetSword, failSpookyRoad, BanditWin, GuardCamp,GetSwordHelmet, 
		GameOVER, GreatHall	
	}
	
	public ShortStory_main() {
		getThings();
	}

	@Override
	public ActionMap getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public INode getRoot() {
		var root = new Node("Init");
		root.addChild(new SelectionChoice("Start"), getRoot());
		
		return new Node("root");
	}

	@Override
	public void getThings() {
		
		characterList.put(ThingNames.jojo,new Character(ThingNames.jojo));
		characterList.put(ThingNames.blacksmith,new Character(ThingNames.blacksmith));
		characterList.put(ThingNames.king,new Character(ThingNames.king));
		characterList.put(ThingNames.bandit,new Character(ThingNames.bandit));
		characterList.put(ThingNames.guard,new Character(ThingNames.guard));
		characterList.put(ThingNames.warlock,new Character(ThingNames.warlock));
		itemList.put(ThingNames.sword,new Item(ThingNames.sword,Items.Sword));
		itemList.put(ThingNames.helmet,new Item(ThingNames.helmet,Items.Helmet));
		itemList.put(ThingNames.Greenpotion,new Item(ThingNames.Greenpotion,Items.GreenPotion));
		itemList.put(ThingNames.Bluecloth, new Item(ThingNames.Bluecloth,Items.BlueCloth));
		placeList.put(ThingNames.home, new Place(ThingNames.home,Places.Cottage));
		placeList.put(ThingNames.city, new Place(ThingNames.city,Places.City));
		placeList.put(ThingNames.camp, new Place(ThingNames.camp,Places.Camp));
		placeList.put(ThingNames.castlecrossroad, new Place(ThingNames.castlecrossroad,Places.CastleCrossroads));
		placeList.put(ThingNames.Spookypath, new Place(ThingNames.Spookypath,Places.SpookyPath));
		placeList.put(ThingNames.GreatHall, new Place(ThingNames.GreatHall,Places.GreatHall));
		placeList.put(ThingNames.jail, new Place(ThingNames.jail,Places.Dungeon));
		
		
		// TODO Auto-generated method stub
	}

	//Action Sequence
	private ActionSequence getInitSQ(){
		var SQ = new ActionSequence();
		//Character Creation
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.guard)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.blacksmith)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.bandit)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.warlock)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.king)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.merchant)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.beggar)));
		
		//Place Creation
		SQ.add(new Create<Place>(placeList.get(ThingNames.castlecrossroad)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.blacksmith)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.Spookypath)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.jail)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.GreatHall)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.camp)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.Port)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.Ruins)));
		
		
		//Items Creation
		SQ.add(new Create<Item>(itemList.get(ThingNames.sword)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.helmet)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.Greenpotion)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.Bluecloth)));
		
		
		
		//Original
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.jojo)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.home)));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.home)));
		SQ.add(new SetCameraFocus(characterList.get(ThingNames.jojo)));
		
		return SQ;
	}
	private ActionSequence getStartSQ() {
		var SQ = new ActionSequence();
		SQ.add(new ShowMenu(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("It is morning, time to wake up!"));
		SQ.add(new SetDialog("Lets put the cloth on"));
		SQ.add(new SetClothing(characterList.get(ThingNames.jojo),Clothing.Naked));
		SQ.add(new ShowDialog(false));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.home),"Bed"));
		SQ.add(new EnableInput(true));
		return SQ;
		}
	private ActionSequence getPeasantClothingSQ() {
		var SQ = new ActionSequence();
		SQ.add(new SetClothing(characterList.get(ThingNames.jojo),Clothing.Peasant));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Lets go to the City"));
		SQ.add(new ShowDialog(false));
		return SQ;
	}
	//Gungeon main quest
	private ActionSequence getCitySQ() {
		var SQ = new ActionSequence();
		SQ.add(new Create<Place>(placeList.get(ThingNames.city)));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.city)));
		SQ.add(new EnableInput(true));
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
	
	
}
