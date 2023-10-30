import com.storygraph.ActionMap;

import com.storygraph.INode;
import com.storygraph.Node;

import java.util.Hashtable;

import com.actions.*;
import com.entities.*;
import com.entities.Character;
import com.entities.Character.Clothing;
import com.entities.IThing.ThingNames;
import com.entities.Item.Items;
import com.entities.Place.Places;
import com.sequences.CharacterCreation;

public class ShortStory_Ian implements IStory{
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
	
	public void ShortStory_main() {
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
		characterList.put(ThingNames.king,new Character(ThingNames.king));
		characterList.put(ThingNames.bandit1,new Character(ThingNames.bandit1));
		characterList.put(ThingNames.guard,new Character(ThingNames.guard));
		characterList.put(ThingNames.warlock,new Character(ThingNames.warlock));
		itemList.put(ThingNames.sword,new Item(ThingNames.sword,Items.Sword));
		itemList.put(ThingNames.helmet,new Item(ThingNames.helmet,Items.Helmet));
		itemList.put(ThingNames.Greenpotion,new Item(ThingNames.Greenpotion,Items.GreenPotion));
		itemList.put(ThingNames.Bluecloth,new Item(ThingNames.Bluecloth,Items.BlueCloth));
		itemList.put(ThingNames.Coin,new Item(ThingNames.Coin,Items.Coin));
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
	//Right Side
	private ActionSequence getBlacksmithSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("You are looking pretty unprepared. I think I can help you out. Here take my helmet, so you can defeat the warlock."));
		SQ.add(new ShowDialog(false));
		SQ.add(new Take(characterList.get(ThingNames.blacksmith),itemList.get(ThingNames.helmet) ));
		SQ.add(new Give(characterList.get(ThingNames.blacksmith), itemList.get(ThingNames.helmet),characterList.get(ThingNames.jojo)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Now go. Defeat the warlock."));
		SQ.add(new ShowDialog(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	
	private ActionSequence getgetHelmetSQ() {
		var SQ = new ActionSequence();
		SQ.add(new ShowDialog(true));
		SQ.add(new EnableInput(false));
		SQ.add(new SetDialog("My warrior, you can take the helmet."));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("You are almost ready. All you need is a proper weapon."));
		SQ.add(new ShowDialog(false));
		SQ.add(new Take(characterList.get(ThingNames.blacksmith),itemList.get(ThingNames.helmet)));
		SQ.add(new Give(characterList.get(ThingNames.blacksmith),itemList.get(ThingNames.helmet),characterList.get(ThingNames.jojo)));
		SQ.add(new SetClothing(characterList.get(ThingNames.jojo),Clothing.HeavyArmor));
		SQ.add(new EnableInput(true));;
		return SQ;
	}
	private ActionSequence gethelmetCitySQ() {
		var SQ = new ActionSequence();
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.city)));
		SQ.add(new FadeOut(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence gethelmetCrossroadSQ() {
		var SQ = new ActionSequence();
		SQ.add(new FadeOut(true));
		SQ.add(new Create<Place>(placeList.get(ThingNames.castlecrossroad)));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.castlecrossroad)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.guard)));
		SQ.add(new FadeOut(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Lets go meet the King and grab the sword. Then we can fight the warlock."));
		SQ.add(new ShowDialog(false));
		return SQ;
		return SQ;
	}
	private ActionSequence gethelmetGreatHallSQ() {
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
		return SQ;
	}
	private ActionSequence gethelmetGetSwordSQ() {
		var SQ = new ActionSequence();
		SQ.add(new WalkTo(characterList.get(ThingNames.jojo),characterList.get(ThingNames.king)));
		SQ.add(new SetDialog("Here is my sword warrior. Use it to defeat the evil warlock. You are ready."));
		SQ.add(new Take(characterList.get(ThingNames.jojo),itemList.get(ThingNames.sword)));
		SQ.add(new Pocket(characterList.get(ThingNames.jojo),itemList.get(ThingNames.sword)));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	
	
	//SIDE QUEST
	
	
	private ActionSequence getCityArresttSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.city),"GreenHouseDoor"));
		SQ.add(new Position(characterList.get(ThingNames.guard),placeList.get(ThingNames.city),"Fountain"));
		SQ.add(new FadeOut(false));
		SQ.add(new WalkTo(characterList.get(ThingNames.guard),characterList.get(ThingNames.jojo)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("You can't walk around here naked. You are going to jail."));
		SQ.add(new ShowDialog(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.jail),"DirtPile"));
		SQ.add(new Position(characterList.get(ThingNames.guard),placeList.get(ThingNames.jail),"CellDoor"));
		SQ.add(new FadeOut(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getJailGameOverSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("You are going to be stuck in here for a long time."));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("GAME OVER"));
		SQ.add(new ShowDialog(false));
		return SQ;
	}
	private ActionSequence getStartJailQuestSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("I will give you the opportunity to leave jail if you do something good."
				+ " I want you to give back to the homeless."));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Some ships just came into the port this morning. You can find what "
				+ "you need there. This is your only chance."));
		SQ.add(new ShowDialog(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.Port),"Exit"));
		SQ.add(new Position(characterList.get(ThingNames.merchant),placeList.get(ThingNames.Port),"BigStall"));
		SQ.add(new Position(characterList.get(ThingNames.beggar),placeList.get(ThingNames.Port),"Barrel"));
		SQ.add(new Position(characterList.get(ThingNames.guard),placeList.get(ThingNames.Port),"Exit"));
		SQ.add(new FadeOut(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getClothGameOverStealSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new Take(characterList.get(ThingNames.jojo),itemList.get(ThingNames.Bluecloth)));
		SQ.add(new WalkTo(characterList.get(ThingNames.jojo),characterList.get(ThingNames.beggar)));
		SQ.add(new WalkTo(characterList.get(ThingNames.guard),characterList.get(ThingNames.beggar)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Did you pay for those clothes? I don't think so."
				+ "You are going back to jail for a long time."));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("GAME OVER"));
		SQ.add(new ShowDialog(false));
		return SQ;
	}
	private ActionSequence getClothGameOverLeaveSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new Take(characterList.get(ThingNames.jojo),itemList.get(ThingNames.Bluecloth)));
		SQ.add(new WalkTo(characterList.get(ThingNames.jojo),characterList.get(ThingNames.guard)));//might need to change walk
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Where do you think you are going. Are you trying to escape."
				+ "You are going back to jail for a long time."));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("GAME OVER"));
		SQ.add(new ShowDialog(false));
		return SQ;
	}
	private ActionSequence getMerchantTalkSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("What can I help you with today?"));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Can I buy one blue cloth?"));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Certainly. That will be one gold coin."));
		SQ.add(new ShowDialog(false));
		SQ.add(new Give(characterList.get(ThingNames.jojo),itemList.get(ThingNames.Coin),characterList.get(ThingNames.merchant)));
		SQ.add(new Give(characterList.get(ThingNames.merchant),itemList.get(ThingNames.Bluecloth),characterList.get(ThingNames.jojo)));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getClothPortSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new WalkTo(characterList.get(ThingNames.jojo),characterList.get(ThingNames.beggar)));
		SQ.add(new WalkTo(characterList.get(ThingNames.guard),characterList.get(ThingNames.beggar)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Here you go. Enjoy."));//Jojo
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Thank you so much."));//beggar
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("You did a good thing. You are free to go."));//guard
		SQ.add(new ShowDialog(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getReturnToCitySQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.city),"EastEnd"));
		SQ.add(new Position(characterList.get(ThingNames.guard),placeList.get(ThingNames.city),"EastEnd"));
		SQ.add(new FadeOut(true));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Don't screw up again. I won't be as nice next time."));//guard
		SQ.add(new ShowDialog(false));
		SQ.add(new EnableInput(false));
		
		return SQ;
	}
}

	

	
		
