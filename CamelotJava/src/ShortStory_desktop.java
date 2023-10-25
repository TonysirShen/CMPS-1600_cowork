import com.storygraph.ActionMap;

import com.storygraph.INode;
import com.storygraph.Node;

import java.util.Hashtable;

import com.actions.*;
import com.entities.*;
import com.entities.Character;
import com.entities.Character.BodyTypes;
import com.entities.Character.Clothing;
import com.entities.Character.HairStyle;
import com.entities.IThing.ThingNames;
import com.entities.Item.Items;
import com.entities.Place.Places;
import com.sequences.CharacterCreation;

public class ShortStory_desktop implements IStory{
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
	
	public ShortStory_desktop() {
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
		
		characterList.put(ThingNames.jojo,new Character(ThingNames.jojo));
		characterList.put(ThingNames.blacksmith,new Character(ThingNames.blacksmith));
		characterList.put(ThingNames.king,new Character(ThingNames.king.toString(),BodyTypes.H,Clothing.King));
		characterList.put(ThingNames.bandit,new Character(ThingNames.bandit));
		characterList.put(ThingNames.guard,new Character(ThingNames.guard));
		characterList.put(ThingNames.warlock,new Character(ThingNames.warlock));
		itemList.put(ThingNames.sword,new Item(ThingNames.sword,Items.Sword));
		itemList.put(ThingNames.helmet,new Item(ThingNames.helmet,Items.Helmet));
		itemList.put(ThingNames.Greenpotion,new Item(ThingNames.Greenpotion,Items.GreenPotion));
		placeList.put(ThingNames.home, new Place(ThingNames.home,Places.cottage));
		placeList.put(ThingNames.city, new Place(ThingNames.city,Places.city));
		placeList.put(ThingNames.camp, new Place(ThingNames.camp,Places.camp));
		placeList.put(ThingNames.castlecrossroad, new Place(ThingNames.castlecrossroad,Places.castlecrossroad));
		placeList.put(ThingNames.Spookypath, new Place(ThingNames.Spookypath,Places.Spookypath));
		placeList.put(ThingNames.GreatHall, new Place(ThingNames.GreatHall,Places.GreatHall));
		placeList.put(ThingNames.Dungeon, new Place(ThingNames.Dungeon,Places.Dungeon));
		
		
		// TODO Auto-generated method stub
	}

	//Action Sequence
	private ActionSequence getInitSQ(){
		var SQ = new ActionSequence();
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.jojo)));
		SQ.add(new SetHairStyle(characterList.get(ThingNames.jojo),HairStyle.Long));
		SQ.add(new Create<Place>(placeList.get(ThingNames.home)));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.home),"Bed"));
		SQ.add(new Sleep(characterList.get(ThingNames.jojo),placeList.get(ThingNames.home).getFurniture("Bed")));
		SQ.add(new SetCameraFocus(characterList.get(ThingNames.jojo)));
		SQ.add(new ShowMenu(true));
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
		SQ.add(new EnableInput(false));
		SQ.add(new SetClothing(characterList.get(ThingNames.jojo),Clothing.Peasant));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Lets go to the City"));
		SQ.add(new ShowDialog(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	//Gungeon main quest
	private ActionSequence getCitySQ() {
		var SQ = new ActionSequence();
		SQ.add(new FadeOut(true));
		SQ.add(new Create<Place>(placeList.get(ThingNames.city)));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.city)));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	
	private ActionSequence getCastleCrossRoadSQ() {
		var SQ = new ActionSequence();
		SQ.add(new FadeOut(true));
		SQ.add(new Create<Place>(placeList.get(ThingNames.castlecrossroad)));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.castlecrossroad)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.guard)));
		SQ.add(new FadeOut(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Lets go to meet the King"));
		SQ.add(new ShowDialog(false));
		return SQ;
	}
	private ActionSequence getGetSwordSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.king)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.sword)));
		SQ.add(new Position(characterList.get(ThingNames.king),placeList.get(ThingNames.GreatHall),"Throne"));
		SQ.add(new Sit(characterList.get(ThingNames.king),placeList.get(ThingNames.GreatHall).getFurniture("Throne")));
		SQ.add(new Position(itemList.get(ThingNames.sword),placeList.get(ThingNames.GreatHall),"Table"));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.GreatHall),"Gate"));	
		SQ.add(new FadeOut(false));
		SQ.add(new WalkTo(characterList.get(ThingNames.jojo),characterList.get(ThingNames.king)));
		SQ.add(new SetDialog("My worrier you are here, you can take the sword."));
		SQ.add(new Take(characterList.get(ThingNames.jojo),itemList.get(ThingNames.sword)));
		SQ.add(new Pocket(characterList.get(ThingNames.jojo),itemList.get(ThingNames.sword)));
		SQ.add(new EnableInput(true));
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
