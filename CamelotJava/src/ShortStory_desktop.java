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
import com.playerInput.*;
import com.playerInput.ActionChoice.Icons;
import com.playerInput.PositionChoice;
import com.playerInput.PositionChoice.Condition;
import com.sequences.CharacterCreation;

public class ShortStory_desktop implements IStory{
	private Hashtable<ThingNames,Character> characterList = new Hashtable();
	private Hashtable<ThingNames,Place> placeList = new Hashtable();
	private Hashtable<ThingNames,Item> itemList = new Hashtable();
	
	private enum ActionNames{};
	private enum NodeLabels{
		Start, Init, Cottage, City, CastleCrossRoad, Getsword, Sword_city, swordBlackSmith, TalktoBlacksmith2,
		gethelmet2, successSpookyRoad, BanditSubmit, Ruin, FightWithWarlock,GreatHallreward, Blacksmith, getHelmet, helmetCity, 
		helmetCrossroad, helmetGreatHall, helmetGetSword, failSpookyRoad, BanditWin, GuardCamp,GetSwordHelmet, 
		GameOVER, GreatHall, JailGameOver, StartJailQuest, ClothGameOverLeave, ClothGameOverSteal, MerchantTalk, ClothPort, ReturnToCity	
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
		var init = new Node(NodeLabels.Init.toString())
		var city = new Node(NodeLabels.City.toString());
		var jailgameover = new Node(NodeLabels.JailGameOver.toString());
		var startjailquest = new Node(NodeLabels.StartJailQuest.toString());
		var clothgameoverleave = new Node(NodeLabels.ClothGameOverLeave.toString());
		var clothgameoversteal = new Node(NodeLabels.ClothGameOverSteal.toString());
		var merchanttalk = new Node(NodeLabels.MerchantTalk.toString());
		var clothport = new Node(NodeLabels.ClothPort.toString());
		var returntocity = new Node(NodeLabels.ReturnToCity.toString());
		var castlecrossroad = new Node(NodeLabels.CastleCrossRoad.toString());
		var greathall = new Node(NodeLabels.GreatHall.toString());
		var getsword = new Node(NodeLabels.Getsword.toString());
		var swordcity = new Node(NodeLabels.Sword_city.toString());
		var swordblacksmith = new Node(NodeLabels.swordBlackSmith.toString());
		var talktoblacksmith2 = new Node(NodeLabels.TalktoBlacksmith2.toString());
		var gethelmet2 = new Node(NodeLabels.gethelmet2.toString());
		var successspookyroad = new Node(NodeLabels.successSpookyRoad.toString());
		var banditsubmit = new Node(NodeLabels.BanditSubmit.toString());
		var dungeon = new Node(NodeLabels.Ruin.toString());
		var fightwithwarlock = new Node(NodeLabels.FightWithWarlock.toString());
		var blacksmith = new Node(NodeLabels.Blacksmith.toString());
		var gethelmet = new Node(NodeLabels.getHelmet.toString());
		var helmetcity = new Node(NodeLabels.helmetCity.toString());
		var helmetcrossroad = new Node(NodeLabels.helmetCrossroad.toString());
		var helmetgreathall = new Node(NodeLabels.helmetGreatHall.toString());
		var helmetgetsword = new Node(NodeLabels.helmetGetSword.toString());
		var failspookyroad = new Node(NodeLabels.failSpookyRoad.toString());
		var banditwin = new Node(NodeLabels.BanditWin.toString());
		var guardcamp = new Node(NodeLabels.GuardCamp.toString());
		var getswordhelmet = new Node(NodeLabels.GetSwordHelmet.toString());
		var gameover = new Node(NodeLabels.GameOVER.toString());
		city.addChild(new PositionChoice(characterList.get(ThingNames.jojo),
				"City.WestEnd",
				Condition.arrived),
				castlecrossroad);
		city.addChild(new ActionChoice("Open",
				placeList.get(ThingNames.city).getFurniture("BrownHouseDoor"),
				Icons.unlock,
				"Open the door",
				true),
				blacksmith);
		castlecrossroad.addChild(new ActionChoice("Open",
				placeList.get(ThingNames.castlecrossroad).getFurniture("Gate"),
				Icons.unlock,
				"Open the Gate",
				true),
				getsword);
		getsword.addChild(new ActionChoice("Open",
				placeList.get(ThingNames.castlecrossroad).getFurniture("Gate"),
				Icons.unlock,
				"Open the Gate",
				true), swordcity);
		swordcity.addChild(new ActionChoice("Open",
				placeList.get(ThingNames.city).getFurniture("BrownHouseDoor"),
				Icons.unlock,
				"Open the door",
				true), swordblacksmith);
		swordcity.addChild(new PositionChoice(characterList.get(ThingNames.jojo),
				"City.EastEnd",
				Condition.arrived),
				failspookyroad);
		swordblacksmith.addChild(new ActionChoice("Talk",
				characterList.get(ThingNames.blacksmith),
				Icons.talk,
				"Talk to the blacksmith",
				true), talktoblacksmith2);
		talktoblacksmith2.addChild(new SelectionChoice("Helmet"),
				gethelmet2);
		return init;
	}

	@Override
	public void getThings() {
		
		characterList.put(ThingNames.jojo,new Character(ThingNames.jojo.toString(),BodyTypes.H));
		characterList.put(ThingNames.blacksmith,new Character(ThingNames.blacksmith));
		characterList.put(ThingNames.king,new Character(ThingNames.king.toString(),BodyTypes.H,Clothing.King));
		characterList.put(ThingNames.bandit1,new Character(ThingNames.bandit1));
		characterList.put(ThingNames.guard,new Character(ThingNames.guard));
		characterList.put(ThingNames.warlock,new Character(ThingNames.warlock));
		itemList.put(ThingNames.sword,new Item(ThingNames.sword,Items.Sword));
		itemList.put(ThingNames.helmet,new Item(ThingNames.helmet,Items.Helmet));
		itemList.put(ThingNames.Greenpotion,new Item(ThingNames.Greenpotion,Items.GreenPotion));
		itemList.put(ThingNames.Hammer1,new Item(ThingNames.Hammer1,Items.Hammer));
		itemList.put(ThingNames.Hammer2,new Item(ThingNames.Hammer2,Items.Hammer));
		itemList.put(ThingNames.Hammer3,new Item(ThingNames.Hammer3,Items.Hammer));
		placeList.put(ThingNames.home, new Place(ThingNames.home,Places.Cottage));
		placeList.put(ThingNames.city, new Place(ThingNames.city,Places.City));
		placeList.put(ThingNames.camp, new Place(ThingNames.camp,Places.Camp));
		placeList.put(ThingNames.castlecrossroad, new Place(ThingNames.castlecrossroad,Places.CastleCrossroads));
		placeList.put(ThingNames.Spookypath, new Place(ThingNames.Spookypath,Places.SpookyPath));
		placeList.put(ThingNames.GreatHall, new Place(ThingNames.GreatHall,Places.GreatHall));
		placeList.put(ThingNames.jail, new Place(ThingNames.jail,Places.Dungeon));
		//fixer//
		placeList.put(ThingNames.BShouse, new Place(ThingNames.BShouse,Places.Blacksmith));
		characterList.put(ThingNames.bandit2,new Character(ThingNames.bandit2));
		characterList.put(ThingNames.bandit3,new Character(ThingNames.bandit3));
		itemList.put(ThingNames.EvilBook, new Item(ThingNames.EvilBook,Items.EvilBook));
		//
		
		// TODO Auto-generated method stub
	}

	//Action Sequence
	private ActionSequence getInitSQ(){
		var SQ = new ActionSequence();
		//fixer
		SQ.add(new Create<Place>(placeList.get(ThingNames.BShouse)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.bandit1)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.bandit2)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.bandit3)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.Hammer1)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.Hammer2)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.Hammer3)));
		//
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
		SQ.add(new SetDialog("Lets put the clothes on"));
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
		SQ.add(new SetDialog("My warrior you are here, you can take the sword."));
		SQ.add(new Take(characterList.get(ThingNames.jojo),itemList.get(ThingNames.sword)));
		SQ.add(new Pocket(characterList.get(ThingNames.jojo),itemList.get(ThingNames.sword)));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getSword_CitySQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.city)));
		SQ.add(new FadeOut(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getSwordBlackSmithSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.blacksmith),"Door"));
		SQ.add(new Position(itemList.get(ThingNames.helmet),placeList.get(ThingNames.blacksmith),"Anvii"));
		SQ.add(new FadeOut(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getTalktoBlacksmithSQ2() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Looks like you get the sword from the king, now take the helmet, you can be the hero to defeat the warlock!"));
		SQ.add(new ShowDialog(false));
		SQ.add(new Take(characterList.get(ThingNames.blacksmith),itemList.get(ThingNames.helmet) ));
		SQ.add(new Give(characterList.get(ThingNames.blacksmith), itemList.get(ThingNames.helmet),characterList.get(ThingNames.jojo)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Now Warrior, Take you way to success!!!"));
		SQ.add(new ShowDialog(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getGetHelmet2SQ() {
		var SQ = new ActionSequence();
		SQ.add(new ShowDialog(true));
		SQ.add(new EnableInput(false));
		SQ.add(new ShowDialog(false));
		SQ.add(new SetDialog("My warrior you are here, you can take the helmet."));
		SQ.add(new Take(characterList.get(ThingNames.blacksmith),itemList.get(ThingNames.helmet)));
		SQ.add(new Give(characterList.get(ThingNames.blacksmith),itemList.get(ThingNames.helmet),characterList.get(ThingNames.jojo)));
		SQ.add(new SetClothing(characterList.get(ThingNames.jojo),Clothing.HeavyArmor));
		SQ.add(new EnableInput(true));;
		return SQ;
	}
	private ActionSequence getSuccessSpookyRoadSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.Spookypath),"WestEnd"));
		SQ.add(new Position(characterList.get(ThingNames.bandit1),placeList.get(ThingNames.Spookypath),"WestEnd"));
		SQ.add(new Position(characterList.get(ThingNames.bandit2),placeList.get(ThingNames.Spookypath),"WestEnd"));
		SQ.add(new Position(characterList.get(ThingNames.bandit3),placeList.get(ThingNames.Spookypath),"WestEnd"));
		SQ.add(new Position(itemList.get(ThingNames.Hammer1),characterList.get(ThingNames.bandit1)));
		SQ.add(new Position(itemList.get(ThingNames.Hammer2),characterList.get(ThingNames.bandit2)));
		SQ.add(new Position(itemList.get(ThingNames.Hammer3),characterList.get(ThingNames.bandit3)));
		SQ.add(new FadeOut(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Looks there are some bandit blocking my way"));
		SQ.add(new SetDialog("Time To test my gears"));
		SQ.add(new ShowDialog(false));;
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getBanditSubmitSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("What? why the superme guard can found us?"));
		SQ.add(new SetDialog("Retreat! We need to tell the warlock about this!"));
		SQ.add(new ShowDialog(false));
		SQ.add(new Pocket(characterList.get(ThingNames.bandit1),itemList.get(ThingNames.Hammer1)));
		SQ.add(new WalkTo(characterList.get(ThingNames.bandit1),placeList.get(ThingNames.Spookypath).getFurniture("EastEnd")));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getRuinSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.Ruins),"Exit"));
		SQ.add(new Position(characterList.get(ThingNames.warlock),placeList.get(ThingNames.Ruins),"Throne"));
		SQ.add(new Position(itemList.get(ThingNames.EvilBook),placeList.get(ThingNames.Ruins),"Altar"));
		SQ.add(new Sit(characterList.get(ThingNames.warlock),placeList.get(ThingNames.Ruins).getFurniture("Throne")));
		SQ.add(new FadeOut(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("A sense of evil surrending you /n It looks like the feeling comes from the book on the desk."));
		SQ.add(new ShowDialog(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getFightWithWarlockSQ() {
		var SQ = new ActionSequence();
		SQ.add(new Position(itemList.get(ThingNames.Hammer1),characterList.get(ThingNames.warlock)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("You think you can steal my magic from me?"));
		SQ.add(new ShowDialog(false));
		SQ.add(new WalkTo(characterList.get(ThingNames.warlock),placeList.get(ThingNames.Ruins).getFurniture("Altar")));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Now take this!"));
		SQ.add(new ShowDialog(false));
		SQ.add(new Cast(characterList.get(ThingNames.warlock),characterList.get(ThingNames.jojo)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("I need to fight back"));
		SQ.add(new ShowDialog(false));
		SQ.add(new Attack(characterList.get(ThingNames.jojo),characterList.get(ThingNames.warlock),false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("You are too weak to defeat me!!!"));
		SQ.add(new ShowDialog(false));
		SQ.add(new Cast(characterList.get(ThingNames.warlock),characterList.get(ThingNames.jojo)));
		SQ.add(new Attack(characterList.get(ThingNames.jojo),characterList.get(ThingNames.warlock),true));
		SQ.add(new Die(characterList.get(ThingNames.warlock)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("I defeat Him!\n Lets go back to the castle to get our reward"));
		SQ.add(new ShowDialog(false));
		return SQ;
	}
	private ActionSequence getGreatHallRewardSQ() {
		var SQ = new ActionSequence();
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.GreatHall)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("My Worrior, you finish my ultimate quest. This proves you are a great one, take this 100 coins as you reward!"));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("I sacriface my life for coins?"));
		SQ.add(new ShowDialog(false));
		SQ.add(new Attack(characterList.get(ThingNames.jojo),characterList.get(ThingNames.king),true));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Now I will be the King!"));
		SQ.add(new ShowDialog(false));
		SQ.add(new SetClothing(characterList.get(ThingNames.jojo),Clothing.King));
		SQ.add(new Sit(characterList.get(ThingNames.king),placeList.get(ThingNames.GreatHall).getFurniture("Throne")));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("So you become a powerful ruler of the kingdom. /n Wonderful Ending .....?"));
		SQ.add(new ShowDialog(false));
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
