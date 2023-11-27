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
import com.playerInput.PositionChoice.Condition;
import com.sequences.CharacterCreation;
 	
public class ShortStory_main implements IStory{
	private Hashtable<ThingNames,Character> characterList = new Hashtable<ThingNames,Character>();
	private Hashtable<ThingNames,Place> placeList = new Hashtable<ThingNames,Place>();
	private Hashtable<ThingNames,Item> itemList = new Hashtable<ThingNames,Item>();
	
	private enum ActionNames{};
	private enum NodeLabels{
		Start, Init, PeasantClothing, City, CastleCrossRoad, Getsword, Sword_city, swordBlackSmith, TalktoBlacksmith2,
		gethelmet2, successSpookyRoad, BanditSubmit, Ruins, FightWithWarlock,GreatHallreward, Blacksmith, getHelmet, helmetCity, 
		helmetCrossroad, helmetGreatHall, helmetGetSword, failSpookyRoad, BanditWin,  BanditGameOver,GuardCamp, FindCoin,GetSwordHelmet, 
		campGameOVER, GreatHall, CityArrest,JailGameOver, StartJailQuest, ClothGameOverLeave, ClothGameOverSteal, MerchantTalk, ClothPort,
		ReturnToCity,Restart	
	}
	public ShortStory_main() {
		getThings();
	}

	@Override
	public ActionMap getMap() {
		// TODO Auto-generated method stub
		var map=new ActionMap();
		//Initial
		map.add(NodeLabels.Init.toString(), getInitSQ());
		map.add(NodeLabels.Start.toString(), getStartSQ());
		//sweethome
		map.add(NodeLabels.PeasantClothing.toString(), getPeasantClothingSQ());
		//Main Ruin Quest
		map.add(NodeLabels.City.toString(), getquickCitySQ());
		//1 castle 2 helmet
		map.add(NodeLabels.CastleCrossRoad.toString(), getCastleCrossRoadSQ());
		map.add(NodeLabels.Getsword.toString(), getquickSwordSQ());
		map.add(NodeLabels.Sword_city.toString(), getSword_CitySQ());
		map.add(NodeLabels.swordBlackSmith.toString(), getSwordBlackSmithSQ());
		
		map.add(NodeLabels.TalktoBlacksmith2.toString(), getTalktoBlacksmithSQ2());
		map.add(NodeLabels.gethelmet2.toString(), getGetHelmet2SQ());
		//Good end
		map.add(NodeLabels.successSpookyRoad.toString(), getSuccessSpookyRoadSQ());
		map.add(NodeLabels.BanditSubmit.toString(), getBanditSubmitSQ());
		map.add(NodeLabels.Ruins.toString(), getRuinsSQ());
		map.add(NodeLabels.FightWithWarlock.toString(), getFightWithWarlockSQ());
		map.add(NodeLabels.GreatHallreward.toString(), getGreatHallRewardSQ());
		//1 helmet 2 castle
		map.add(NodeLabels.Blacksmith.toString(), getBlacksmithSQ());
		map.add(NodeLabels.getHelmet.toString(), getGetHelmetSQ());
		
		map.add(NodeLabels.helmetCity.toString(), getHelmetCitySQ());
		map.add(NodeLabels.helmetCrossroad.toString(), getHelmetCrossroadSQ());
		map.add(NodeLabels.helmetGreatHall.toString(), getHelmetGreatHallSQ());
		map.add(NodeLabels.helmetGetSword.toString(), getHelmetGetSwordSQ());
		//Camp quest
		map.add(NodeLabels.failSpookyRoad.toString(), getFailSpookyRoadSQ());
		map.add(NodeLabels.BanditWin.toString(), getBanditWinSQ());
		map.add(NodeLabels.GuardCamp.toString(), getGuardCampSQ());
		map.add(NodeLabels.GetSwordHelmet.toString(), getGetSwordHelmetSQ());
		
		map.add(NodeLabels.campGameOVER.toString(), getCampGameOverSQ());
		map.add(NodeLabels.BanditGameOver.toString(), getBanditGameOverSQ());
		
		//Side quest
		map.add(NodeLabels.CityArrest.toString(), getCityArrestSQ());
		map.add(NodeLabels.JailGameOver.toString(), getJailGameOverSQ());
		map.add(NodeLabels.StartJailQuest.toString(), getStartJailQuestSQ());
		
		map.add(NodeLabels.ClothGameOverLeave.toString(), getClothGameOverLeaveSQ());
		map.add(NodeLabels.ClothGameOverSteal.toString(), getClothGameOverStealSQ());
		map.add(NodeLabels.MerchantTalk.toString(), getMerchantTalkSQ());
		map.add(NodeLabels.ClothPort.toString(), getClothPortSQ());
		
		map.add(NodeLabels.ReturnToCity.toString(), getReturnToCitySQ());
		map.add(NodeLabels.Restart.toString(), getRestartSQ());
	
		
		
		
		return map;
		
		
	}

	public INode getRoot() {
		var init = new Node(NodeLabels.Init.toString());
		var start = new Node(NodeLabels.Start.toString());
		var peasantClothing = new Node(NodeLabels.PeasantClothing.toString());
		var city = new Node(NodeLabels.City.toString());
		var cityarrest = new Node(NodeLabels.CityArrest.toString());
		var jailgameover = new Node(NodeLabels.JailGameOver.toString());
		var startjailquest = new Node(NodeLabels.StartJailQuest.toString());
		var clothgameoverleave = new Node(NodeLabels.ClothGameOverLeave.toString());
		var clothgameoversteal = new Node(NodeLabels.ClothGameOverSteal.toString());
		var merchanttalk = new Node(NodeLabels.MerchantTalk.toString());
		var clothport = new Node(NodeLabels.ClothPort.toString());
		var returntocity = new Node(NodeLabels.ReturnToCity.toString());
		var castlecrossroad = new Node(NodeLabels.CastleCrossRoad.toString());
		var getsword = new Node(NodeLabels.Getsword.toString());
		var swordcity = new Node(NodeLabels.Sword_city.toString());
		var swordblacksmith = new Node(NodeLabels.swordBlackSmith.toString());
		var talktoblacksmith2 = new Node(NodeLabels.TalktoBlacksmith2.toString());
		var gethelmet2 = new Node(NodeLabels.gethelmet2.toString());
		var successspookyroad = new Node(NodeLabels.successSpookyRoad.toString());
		var banditsubmit = new Node(NodeLabels.BanditSubmit.toString());
		var ruins = new Node(NodeLabels.Ruins.toString());
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
		var banditGameOver = new Node(NodeLabels.BanditGameOver.toString());
		var findCoin = new Node(NodeLabels.FindCoin.toString());
		var getswordhelmet = new Node(NodeLabels.GetSwordHelmet.toString());
		var campGameOver = new Node(NodeLabels.campGameOVER.toString());
		var greatHallreward = new Node(NodeLabels.GreatHallreward.toString());
		var restart = new Node(NodeLabels.Restart.toString());
		init.addChild(new SelectionChoice("Start"), start);
		start.addChild(new ActionChoice("Open",
				placeList.get(ThingNames.home).getFurniture("Door"),
				Icons.unlock,
				"Open the door",
				true), cityarrest);
		start.addChild(new ActionChoice("Open",
				placeList.get(ThingNames.home).getFurniture("Chest"),
				Icons.unlock,
				"Put on Cloth",
				true), peasantClothing);
		peasantClothing.addChild(new ActionChoice("Leave",
				placeList.get(ThingNames.home).getFurniture("Door"),
				Icons.door,
				"Leave the house",
				true),city);
		city.addChild(new PositionChoice(characterList.get(ThingNames.jojo),
				"city.WestEnd",
				Condition.arrived),
				castlecrossroad);
		city.addChild(new ActionChoice("Open",
				placeList.get(ThingNames.city).getFurniture("BrownHouseDoor"),
				Icons.unlock,
				"Open the door",
				true),
				blacksmith);
		// 1 castle 2 blacksmith
		castlecrossroad.addChild(new ActionChoice("Open",
				placeList.get(ThingNames.castlecrossroad).getFurniture("Gate"),
				Icons.unlock,
				"Open the Gate",
				true),
				getsword);
		getsword.addChild(new ActionChoice("Open",
				placeList.get(ThingNames.GreatHall).getFurniture("Gate"),
				Icons.unlock,
				"Open the Gate",
				true), swordcity);
		swordcity.addChild(new ActionChoice("Open",
				placeList.get(ThingNames.city).getFurniture("BrownHouseDoor"),
				Icons.unlock,
				"Open the door",
				true), swordblacksmith);
		swordcity.addChild(new PositionChoice(characterList.get(ThingNames.jojo),
				"city.EastEnd",
				Condition.arrived),
				failspookyroad);
		swordblacksmith.addChild(new ActionChoice("Talk",
				characterList.get(ThingNames.blacksmith),
				Icons.talk,
				"Talk to the blacksmith",
				true), talktoblacksmith2);
		talktoblacksmith2.addChild(new SelectionChoice("Helmet"),
				gethelmet2);
		gethelmet2.addChild(new ActionChoice("Leave",
				placeList.get(ThingNames.BShouse).getFurniture("Door"),
				Icons.unlock,
				"Talk to the blacksmith",
				true),
				successspookyroad);
		// 1 helmet 2 sword
		blacksmith.addChild(new ActionChoice("Blacksmith",
				characterList.get(ThingNames.blacksmith),
				Icons.talk,
				"Talk to blacksmith",
				true), gethelmet);
		
		gethelmet.addChild(new ActionChoice("Leave",
				placeList.get(ThingNames.BShouse).getFurniture("Door"),
				Icons.unlock,
				"Leave to city",
				true), helmetcity);
		helmetcity.addChild(new PositionChoice(
				characterList.get(ThingNames.jojo),
				"city.EastEnd", Condition.arrived), failspookyroad);
		helmetcity.addChild(new PositionChoice(
				characterList.get(ThingNames.jojo),
				"city.WestEnd", Condition.arrived), helmetcrossroad);
		
		helmetcrossroad.addChild(new ActionChoice("Open",
				placeList.get(ThingNames.castlecrossroad).getFurniture("Gate"),
				Icons.unlock,
				"Go inside castle",
				true), helmetgreathall);
		helmetgetsword.addChild(new ActionChoice("Leave",
				placeList.get(ThingNames.GreatHall).getFurniture("Gate"),
				Icons.unlock,
				"Leave to city",
				true), successspookyroad);
		
		// camp route
		failspookyroad.addChild(new ActionChoice("Attack 1",
				characterList.get(ThingNames.bandit1),
				Icons.swords,
				"Attack the bandit",
				true),banditwin);
		failspookyroad.addChild(new ActionChoice("Attack 2",
				characterList.get(ThingNames.bandit2),
				Icons.swords,
				"Attack the bandit",
				true),banditwin);
		failspookyroad.addChild(new ActionChoice("Attack 3",
				characterList.get(ThingNames.bandit3),
				Icons.swords,
				"Attack the bandit",
				true),banditwin);
		banditwin.addChild(new SelectionChoice("Revive"), 
				guardcamp);
		banditwin.addChild(new SelectionChoice("Die"), 
				banditGameOver);
		guardcamp.addChild(new ActionChoice("Take",
				itemList.get(ThingNames.Greenpotion),
				Icons.drink,
				"Take the potion",
				true), campGameOver);
		guardcamp.addChild(new ActionChoice("Open",
				placeList.get(ThingNames.camp).getFurniture("Chest"),
				Icons.unlock,
				"Open the chest",
				true), findCoin);
		findCoin.addChild(new ActionChoice("Take",
				itemList.get(ThingNames.Greenpotion),
				Icons.drink,
				"Take the potion",
				true), campGameOver);
		findCoin.addChild(new ActionChoice("Talk",
				characterList.get(ThingNames.merchant),
				Icons.talk,
				"Talk to the blacksmith",
				true),getswordhelmet);
		getswordhelmet.addChild(new PositionChoice(
				characterList.get(ThingNames.jojo),
				"Camp.Exit", Condition.arrived), successspookyroad);
		// success ending
		successspookyroad.addChild(new PositionChoice(characterList.get(ThingNames.jojo),
				"SpookyPath.EastEnd",
				Condition.arrived),
				ruins);
		ruins.addChild(new ActionChoice("Take",
				characterList.get(ThingNames.blacksmith),
				Icons.research,
				"Take a look if the book",
				true),
				fightwithwarlock);
		fightwithwarlock.addChild(new PositionChoice(characterList.get(ThingNames.jojo),
				"Ruins.Exit",
				Condition.arrived), greatHallreward);
		greatHallreward.addChild(new PositionChoice(characterList.get(ThingNames.jojo),
				"Camp.Exit",
				Condition.arrived),
				successspookyroad);
		//side quest
		cityarrest.addChild(new ActionChoice("Fight",
				characterList.get(ThingNames.guard),
				Icons.draw,
				"Fight with Guard",
				true), jailgameover);
		cityarrest.addChild(new ActionChoice("Talk",
				characterList.get(ThingNames.guard),
				Icons.talk,
				"Talk to Guard",
				false), startjailquest);
		jailgameover.addChild(new SelectionChoice("Restart"),restart);
		startjailquest.addChild(new ActionChoice("Cloth",
				itemList.get(ThingNames.Bluecloth),
				Icons.snake,
				"Steal the cloth",
				true), clothgameoversteal);
		startjailquest.addChild(new ActionChoice("Merchant",
				characterList.get(ThingNames.merchant),
				Icons.talk,
				"Talk to the merchant",
				true), merchanttalk);
		
		merchanttalk.addChild(new SelectionChoice("Buy"),clothport);
				
				
		clothport.addChild(new PositionChoice(
				characterList.get(ThingNames.jojo),
				"Port.Exit", Condition.arrived), clothgameoverleave);
		
		
		clothport.addChild(new ActionChoice("Beggar",
				characterList.get(ThingNames.beggar),
				Icons.talk,
				"Give to beggar",
				true), returntocity);
		returntocity.addChild(new PositionChoice(
				characterList.get(ThingNames.jojo),
				"Port.Exit",
				Condition.arrived), city);
		//restart node
		restart.addChild(new SelectionChoice("Resume"), start);
		return init;
	}


	@Override
	public void getThings() {
		characterList.put(ThingNames.jojo,new Character(ThingNames.jojo.toString(),BodyTypes.F,Clothing.Naked, HairStyle.Spiky));
		characterList.put(ThingNames.blacksmith,new Character(ThingNames.blacksmith.toString(),BodyTypes.D,Clothing.LightArmour, HairStyle.Short_Full));
		characterList.put(ThingNames.king,new Character(ThingNames.king.toString(),BodyTypes.H,Clothing.King));
		characterList.put(ThingNames.bandit1,new Character(ThingNames.bandit1.toString(),BodyTypes.B,Clothing.Bandit));
		characterList.put(ThingNames.guard,new Character(ThingNames.guard.toString(),BodyTypes.A,Clothing.HeavyArmour));
		characterList.put(ThingNames.guard2,new Character(ThingNames.guard2.toString(),BodyTypes.C,Clothing.HeavyArmour));
		characterList.put(ThingNames.warlock,new Character(ThingNames.warlock.toString(),BodyTypes.H,Clothing.Warlock));
		characterList.put(ThingNames.bandit2,new Character(ThingNames.bandit2.toString(),BodyTypes.B,Clothing.Bandit));
		characterList.put(ThingNames.bandit3,new Character(ThingNames.bandit3.toString(),BodyTypes.A,Clothing.Bandit));
		characterList.put(ThingNames.merchant, new Character(ThingNames.merchant.toString(), BodyTypes.B,Clothing.Merchant));
		characterList.put(ThingNames.beggar, new Character(ThingNames.beggar.toString(), BodyTypes.D,Clothing.Beggar, HairStyle.Mage));
		itemList.put(ThingNames.sword,new Item(ThingNames.sword,Items.Sword));
		itemList.put(ThingNames.helmet,new Item(ThingNames.helmet,Items.Helmet));
		itemList.put(ThingNames.Greenpotion,new Item(ThingNames.Greenpotion,Items.GreenPotion));
		itemList.put(ThingNames.Bluecloth, new Item(ThingNames.Bluecloth,Items.BlueCloth));
		itemList.put(ThingNames.Hammer1,new Item(ThingNames.Hammer1,Items.Hammer));
		itemList.put(ThingNames.Hammer2,new Item(ThingNames.Hammer2,Items.Hammer));
		itemList.put(ThingNames.Hammer3,new Item(ThingNames.Hammer3,Items.Hammer));
		itemList.put(ThingNames.EvilBook, new Item(ThingNames.EvilBook,Items.EvilBook));
		placeList.put(ThingNames.home, new Place(ThingNames.home,Places.Cottage));
		placeList.put(ThingNames.city, new Place(ThingNames.city,Places.City));
		placeList.put(ThingNames.camp, new Place(ThingNames.camp,Places.Camp));
		placeList.put(ThingNames.castlecrossroad, new Place(ThingNames.castlecrossroad,Places.CastleCrossroads));
		placeList.put(ThingNames.Spookypath, new Place(ThingNames.Spookypath,Places.SpookyPath));
		placeList.put(ThingNames.GreatHall, new Place(ThingNames.GreatHall,Places.GreatHall));
		placeList.put(ThingNames.jail, new Place(ThingNames.jail,Places.Dungeon));
		placeList.put(ThingNames.BShouse, new Place(ThingNames.BShouse,Places.Blacksmith));
		placeList.put(ThingNames.Port, new Place(ThingNames.Port,Places.Port));
		placeList.put(ThingNames.Ruins, new Place(ThingNames.Ruins,Places.Ruins));
		
	}

	//Action Sequence
	//quick method for test
	private ActionSequence getquickCitySQ() {
		var SQ = new ActionSequence();
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.city),"Fountain"));
		SQ.add(new FadeOut(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getquickSwordSQ() {
		var SQ = new ActionSequence();
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.GreatHall),"Gate"));
		SQ.add(new FadeOut(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	//Initialize
	private ActionSequence getInitSQ(){
		var SQ = new ActionSequence();
		//Character Creation
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.guard)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.guard2)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.blacksmith)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.bandit1)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.warlock)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.king)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.merchant)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.beggar)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.jojo)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.bandit1)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.bandit2)));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.bandit3)));
		
		
		//Place Creation
		SQ.add(new Create<Place>(placeList.get(ThingNames.castlecrossroad)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.BShouse)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.Spookypath)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.jail)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.GreatHall)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.camp)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.Port)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.Ruins)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.city)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.home)));
		
		//Items Creation
		SQ.add(new Create<Item>(itemList.get(ThingNames.sword)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.helmet)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.Greenpotion)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.Bluecloth)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.Hammer1)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.Hammer2)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.Hammer3)));
		SQ.add(new Create<Item>(itemList.get(ThingNames.EvilBook)));		
		
		//Original
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.home)));
		SQ.add(new Sleep(characterList.get(ThingNames.jojo),placeList.get(ThingNames.home).getFurniture("Bed")));
		SQ.add(new SetCameraFocus(characterList.get(ThingNames.jojo)));
		SQ.add(new FadeOut(true));
		SQ.add(new ShowMenu(true));
		
		return SQ;
	}
	private ActionSequence getStartSQ() {
		var SQ = new ActionSequence();
		
		SQ.add(new ShowMenu(false));
		SQ.add(new FadeOut(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("It is morning,time to wake up!"));
		SQ.add(new Wait(2));
		SQ.add(new SetClothing(characterList.get(ThingNames.jojo),Clothing.Naked));
		SQ.add(new ShowDialog(false));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.home),"Bed"));
		SQ.add(new Wait(3));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Let's try not to go out naked"));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(false));
		SQ.add(new EnableInput(true));
	
		return SQ;
		}
	
	//sweet home
	private ActionSequence getPeasantClothingSQ() {
		var SQ = new ActionSequence();
		SQ.add(new SetClothing(characterList.get(ThingNames.jojo),Clothing.Peasant));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Time to go outside."));
		SQ.add(new Wait(3));
		SQ.add(new ShowDialog(false));
		return SQ;
	}
	private ActionSequence getCitySQ() {
		var SQ = new ActionSequence();
		SQ.add(new FadeOut(true));
		SQ.add(new EnableInput(false));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.city),"GreenHouseDoor"));
		SQ.add(new Position(characterList.get(ThingNames.guard),placeList.get(ThingNames.city),"Fountain"));
		SQ.add(new Position(characterList.get(ThingNames.guard2),placeList.get(ThingNames.city),"BrownHouseDoor"));
		SQ.add(new SetCameraFocus(characterList.get(ThingNames.guard2)));
		SQ.add(new FadeOut(false));
		SQ.add(new WalkTo(characterList.get(ThingNames.guard2),characterList.get(ThingNames.guard)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Have your herd about the bandit in the Forest?"));
		SQ.add(new Wait(1));
		SQ.add(new SetDialog("The King is calling some bravery to help"));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(false));
		SQ.add(new SetCameraFocus(characterList.get(ThingNames.jojo)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Looks like there is a chance for me to become famous."));
		SQ.add(new Wait(1));
		SQ.add(new ShowDialog(false));
		SQ.add(new WalkTo(characterList.get(ThingNames.jojo),characterList.get(ThingNames.guard)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Where can I find the bandit?"));
		SQ.add(new Wait(1));
		SQ.add(new SetDialog("I think you can just walk through the EastEnd to meet them, Be careful"));
		SQ.add(new Wait(3));
		SQ.add(new ShowDialog(false));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Here can I find some gears before I go?"));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(false));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("The king will offer you the sword in the castle located on WestEnd."));
		SQ.add(new Wait(2));
		SQ.add(new SetDialog("Or you can ask the blacksmith in the brown house."));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	
	//Dungeon main quest
	//1 sword 2 helmet
	private ActionSequence getCastleCrossRoadSQ() {
		var SQ = new ActionSequence();
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.castlecrossroad)));
		SQ.add(new FadeOut(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Lets go to meet the King"));
		SQ.add(new Wait(1));
		SQ.add(new ShowDialog(false));
		return SQ;
	}
	private ActionSequence getGetSwordSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.king),placeList.get(ThingNames.GreatHall),"Throne"));
		SQ.add(new Sit(characterList.get(ThingNames.king),placeList.get(ThingNames.GreatHall).getFurniture("Throne")));
		SQ.add(new Position(itemList.get(ThingNames.sword),placeList.get(ThingNames.GreatHall),"Table"));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.GreatHall),"Gate"));	
		SQ.add(new FadeOut(false));
		SQ.add(new WalkTo(characterList.get(ThingNames.jojo),characterList.get(ThingNames.king)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Nice to meet you my kingI have heard you are looking for someone to kill the banfits?"));
		SQ.add(new Wait(2));
		SQ.add(new SetDialog("I have heard you are looking for someone to kill the banfits?"));
		SQ.add(new Wait(2));
		SQ.add(new SetDialog("I am willing to help"));
		SQ.add(new Wait(3));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Good, you are my warrioir now! You can take the sword."));
		SQ.add(new SetDialog("You can take the sword."));
		SQ.add(new Wait(3));
		SQ.add(new ShowDialog(false));
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
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Ok now I think I can go to fight with the warlock"));
		SQ.add(new Wait(1));
		SQ.add(new SetDialog("Or maybe get more prepared?"));
		SQ.add(new Wait(3));
		SQ.add(new ShowDialog(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getSwordBlackSmithSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.BShouse),"Door"));
		SQ.add(new Position(characterList.get(ThingNames.blacksmith),placeList.get(ThingNames.BShouse),"Anvil"));
		SQ.add(new Position(itemList.get(ThingNames.helmet),placeList.get(ThingNames.BShouse),"Anvil"));
		SQ.add(new FadeOut(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getTalktoBlacksmithSQ2() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Hi,I need some armor,can I get one here?"));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(false));
		SQ.add(new Wait(1));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Looks like you already had the weapon."));
		SQ.add(new SetDialog("So,what armor whould you like?"));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(false));
		SQ.add(new Wait(1));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("[Helmet|I would like to have the helmet]"));
		return SQ;
	}
	private ActionSequence getGetHelmet2SQ() {
		var SQ = new ActionSequence();
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Take good care of yourself. Good Luck"));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(false));
		SQ.add(new Take(characterList.get(ThingNames.blacksmith),itemList.get(ThingNames.helmet)));
		SQ.add(new Give(characterList.get(ThingNames.blacksmith),itemList.get(ThingNames.helmet),characterList.get(ThingNames.jojo)));
		SQ.add(new SetClothing(characterList.get(ThingNames.jojo),Clothing.HeavyArmour));
		SQ.add(new Wait(1));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Time to start my quest!!!"));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(false));
		SQ.add(new EnableInput(true));;
		return SQ;
	}
	
	//1 helmet 2 sword
	private ActionSequence getBlacksmithSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.BShouse),"Door"));
		SQ.add(new Position(characterList.get(ThingNames.blacksmith),placeList.get(ThingNames.BShouse),"Anvil"));
		SQ.add(new Position(itemList.get(ThingNames.helmet),placeList.get(ThingNames.BShouse),"Anvil"));
		SQ.add(new FadeOut(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("You are looking pretty unprepared. I think I can help you out. \n Here take my helmet, so you can defeat the warlock."));
		SQ.add(new ShowDialog(false));
		SQ.add(new Take(characterList.get(ThingNames.blacksmith),itemList.get(ThingNames.helmet) ));
		SQ.add(new Give(characterList.get(ThingNames.blacksmith), itemList.get(ThingNames.helmet),characterList.get(ThingNames.jojo)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Now go. Defeat the warlock."));
		SQ.add(new ShowDialog(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getGetHelmetSQ() {
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
		SQ.add(new SetClothing(characterList.get(ThingNames.jojo),Clothing.HeavyArmour));
		SQ.add(new EnableInput(true));;
		return SQ;
	}
	private ActionSequence getHelmetCitySQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.city)));
		SQ.add(new FadeOut(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}	
	private ActionSequence getHelmetCrossroadSQ() {
		var SQ = new ActionSequence();
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.castlecrossroad)));
		SQ.add(new FadeOut(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Lets go meet the King and grab the sword. Then we can fight the warlock."));
		SQ.add(new ShowDialog(false));
		return SQ;
	}
	private ActionSequence getHelmetGreatHallSQ() {
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
	private ActionSequence getHelmetGetSwordSQ() {
		var SQ = new ActionSequence();
		SQ.add(new WalkTo(characterList.get(ThingNames.jojo),characterList.get(ThingNames.king)));
		SQ.add(new SetDialog("Here is my sword warrior. Use it to defeat the evil warlock. You are ready."));
		SQ.add(new Take(characterList.get(ThingNames.jojo),itemList.get(ThingNames.sword)));
		SQ.add(new Pocket(characterList.get(ThingNames.jojo),itemList.get(ThingNames.sword)));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	
	// success bandit fight 
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
	
	// warlock fight & wonderful ending
	private ActionSequence getRuinsSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.Ruins),"Exit"));
		SQ.add(new Position(characterList.get(ThingNames.warlock),placeList.get(ThingNames.Ruins),"Throne"));
		SQ.add(new Position(itemList.get(ThingNames.EvilBook),placeList.get(ThingNames.Ruins),"Altar"));
		SQ.add(new Sit(characterList.get(ThingNames.warlock),placeList.get(ThingNames.Ruins).getFurniture("Throne")));
		SQ.add(new FadeOut(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("A sense of evil surrending you"));
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
		SQ.add(new Kneel(characterList.get(ThingNames.warlock)));
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
	
	// failed bandit fight
	private ActionSequence getFailSpookyRoadSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.Spookypath),"WestEnd"));
		SQ.add(new Position(characterList.get(ThingNames.bandit1),placeList.get(ThingNames.Spookypath),"PathBlock"));
		SQ.add(new Position(characterList.get(ThingNames.bandit2),placeList.get(ThingNames.Spookypath),"Well"));
		SQ.add(new Position(characterList.get(ThingNames.bandit3),placeList.get(ThingNames.Spookypath),"EastEnd"));
		SQ.add(new Position(itemList.get(ThingNames.Hammer1),characterList.get(ThingNames.bandit1)));
		SQ.add(new Position(itemList.get(ThingNames.Hammer2),characterList.get(ThingNames.bandit2)));
		SQ.add(new Position(itemList.get(ThingNames.Hammer3),characterList.get(ThingNames.bandit3)));
		SQ.add(new FadeOut(false));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Looks there are some bandit blocking my way"));
		SQ.add(new Wait(1));
		SQ.add(new SetDialog("Time To test my gear"));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(false));;
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getBanditWinSQ() {
		var SQ = new ActionSequence();
		SQ.add(new Attack(characterList.get(ThingNames.jojo),characterList.get(ThingNames.bandit2),false));
		SQ.add(new EnableInput(false));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Bro you are too weak!"));
		SQ.add(new Wait(1));
		SQ.add(new SetDialog("You think you are as strong as a guard?"));
		SQ.add(new Wait(3));
		SQ.add(new ShowDialog(false));
		SQ.add(new Attack(characterList.get(ThingNames.bandit2),characterList.get(ThingNames.jojo),true));
		SQ.add(new Kneel(characterList.get(ThingNames.jojo)));
		SQ.add(new FadeOut(true));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Things gone black on your eyes.\n"));
		SQ.add(new Wait(3));
		SQ.add(new EnableInput(true));
		SQ.add(new SetDialog("[Die|I fell too tired     ][Revive|I DO NOT want to submit!]"));
		return SQ;
	}
	
	//Bandit submit end
	private ActionSequence getBanditGameOverSQ() {
		var SQ = new ActionSequence();
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("I feel so tried, I want nothing but sleep"));
		SQ.add(new Wait(1));
		SQ.add(new ShowDialog(false));
		SQ.add(new Wait(1));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("YOU DIED"));
		SQ.add(new ShowDialog(false));
		return SQ;
	}
		
	// camp revive
	private ActionSequence getGuardCampSQ() {
		var SQ = new ActionSequence();
		SQ.add(new ShowDialog(false));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.camp),"Plant"));
		SQ.add(new Position(characterList.get(ThingNames.merchant),placeList.get(ThingNames.camp),"Barrel"));
		SQ.add(new Position(characterList.get(ThingNames.guard),placeList.get(ThingNames.camp)));
		SQ.add(new Kneel(characterList.get(ThingNames.jojo)));
		SQ.add(new FadeOut(false));
		SQ.add(new WalkTo(characterList.get(ThingNames.guard),characterList.get(ThingNames.jojo)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Hey my friend, I find you on the Spooky path, Don't you know how danger there is? "));
		SQ.add(new Wait(2));
		SQ.add(new SetDialog("You chould be killed by the bandits \n Its Lucky you still alive"));
		SQ.add(new Wait(2));
		SQ.add(new SetDialog("Its Lucky you still alive"));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(false));
		SQ.add(new Wait(1));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("I know, but it is my mission to defeat the warlock \n but these bastards are stoping me!"));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(false));
		SQ.add(new Wait(1));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Then you have to refresh your state and wake up"));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("You quicky stand up and try to find if there is anything to help"));
		SQ.add(new Wait(2));
		SQ.add(new ShowDialog(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.camp)));
		SQ.add(new FadeOut(false));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getFindCoinSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new OpenFurniture(characterList.get(ThingNames.jojo),placeList.get(ThingNames.camp).getFurniture("Chest")));
		SQ.add(new Position(itemList.get(ThingNames.Coin),characterList.get(ThingNames.jojo)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Maybe the merchant had something I can get"));
		SQ.add(new Position(itemList.get(ThingNames.Greenpotion),placeList.get(ThingNames.camp),"Stall"));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getGetSwordHelmetSQ() {
		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new Give(characterList.get(ThingNames.jojo),itemList.get(ThingNames.Coin),characterList.get(ThingNames.merchant)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Thanks for your payments, now you can get this Health Potion"));
		SQ.add(new ShowDialog(false));
		SQ.add(new Give(characterList.get(ThingNames.merchant),itemList.get(ThingNames.Greenpotion),characterList.get(ThingNames.jojo)));
		SQ.add(new Pocket(characterList.get(ThingNames.merchant),itemList.get(ThingNames.Greenpotion)));
		SQ.add(new WalkTo(characterList.get(ThingNames.guard),characterList.get(ThingNames.jojo)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("You look much better now. \n You can take my gears. \n Good fight!"));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Thanks so much"));
		SQ.add(new ShowDialog(false));
		SQ.add(new Give(characterList.get(ThingNames.guard),itemList.get(ThingNames.helmet),characterList.get(ThingNames.jojo)));
		SQ.add(new Give(characterList.get(ThingNames.guard),itemList.get(ThingNames.sword),characterList.get(ThingNames.jojo)));
		SQ.add(new SetClothing(characterList.get(ThingNames.jojo),Clothing.HeavyArmour));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Time to regain my honor!"));
		SQ.add(new ShowDialog(false));
		return SQ;
	}
	
	// new AS template
	/*
	private ActionSequence getGreatHallSQ() {
		var SQ = new ActionSequence();
		return SQ;
	}
	*/
	
	// Camp steal end
	private ActionSequence getCampGameOverSQ() {
		var SQ = new ActionSequence();
		SQ.add(new Take(characterList.get(ThingNames.jojo),itemList.get(ThingNames.Greenpotion)));
		SQ.add(new Pocket(characterList.get(ThingNames.jojo),itemList.get(ThingNames.Greenpotion)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Lets find a place to drink the potion"));
		SQ.add(new ShowDialog(false));
		SQ.add(new WalkTo(characterList.get(ThingNames.guard),characterList.get(ThingNames.jojo)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("You think I am blind?"));
		SQ.add(new Attack(characterList.get(ThingNames.guard),characterList.get(ThingNames.jojo),true));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("\n YOU DIED \n"));
		SQ.add(new ShowDialog(false));;
		return SQ;
	}
	
	// SIDE_QUEST
	private ActionSequence getCityArrestSQ() {


		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.city),"GreenHouseDoor"));
		SQ.add(new Position(characterList.get(ThingNames.guard),placeList.get(ThingNames.city),"Fountain"));
		SQ.add(new FadeOut(false));
		SQ.add(new WalkTo(characterList.get(ThingNames.guard),characterList.get(ThingNames.jojo)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("You can't walk around here naked. You are going to jail."));
		SQ.add(new Wait(3));
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
		SQ.add(new SetDialog("That was a mistake. You should have been respectful."
				+ "You are going to be stuck in here for a long time."));
		SQ.add(new Wait(4));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("GAME OVER"));
		SQ.add(new Wait(3));
		SQ.add(new FadeOut(true));
		SQ.add(new Wait(1));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Restart?"));
		SQ.add(new SetDialog("[Restart|Yes    ][No|No]"));
		return SQ;
	}
	private ActionSequence getStartJailQuestSQ() {

		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("I will give you the opportunity to leave jail if you do something good."
				+ " I want you to give back to the homeless."));
		SQ.add(new Wait(4));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Some ships just came into the port this morning. You can find what "
				+ "you need there. This is your only chance."));
		SQ.add(new Wait(4));
		SQ.add(new ShowDialog(false));
		SQ.add(new FadeOut(true));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.Port),"Exit"));
		SQ.add(new Position(characterList.get(ThingNames.merchant),placeList.get(ThingNames.Port),"BigStall"));
		SQ.add(new Position(characterList.get(ThingNames.beggar),placeList.get(ThingNames.Port),"Barrel"));
		SQ.add(new Position(characterList.get(ThingNames.guard),placeList.get(ThingNames.Port),"Exit"));
		SQ.add(new Position(itemList.get(ThingNames.Bluecloth),placeList.get(ThingNames.Port),"BigStall"));
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
		SQ.add(new Wait(10));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("GAME OVER"));
		SQ.add(new Wait(3));
		SQ.add(new ShowDialog(false));
		SQ.add(new FadeOut(true));
		
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
		SQ.add(new Wait(4));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Can I buy one blue cloth?"));
		SQ.add(new Wait(4));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Certainly. That will be one gold coin."));
		SQ.add(new SetDialog("[Buy| Ok I will buy it.]"));
		
		return SQ;
	}
	private ActionSequence getClothPortSQ() {

		var SQ = new ActionSequence();
		SQ.add(new ShowDialog(false));
		//SQ.add(new Give(characterList.get(ThingNames.jojo),itemList.get(ThingNames.Coin),characterList.get(ThingNames.merchant)));
		SQ.add(new Take(characterList.get(ThingNames.merchant),itemList.get(ThingNames.Bluecloth)));
		SQ.add(new Give(characterList.get(ThingNames.merchant),itemList.get(ThingNames.Bluecloth),characterList.get(ThingNames.jojo)));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	private ActionSequence getReturnToCitySQ() {


		var SQ = new ActionSequence();
		SQ.add(new EnableInput(false));
		SQ.add(new WalkTo(characterList.get(ThingNames.jojo),characterList.get(ThingNames.beggar)));
		SQ.add(new WalkTo(characterList.get(ThingNames.guard),characterList.get(ThingNames.beggar)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Here you go. Enjoy."));
		SQ.add(new Wait(5));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Thank you so much."));//beggar
		SQ.add(new Wait(5));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("You did a good thing. You are free to go."));//guard
		SQ.add(new Wait(7));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Don't screw up again. I won't be as nice next time."));//guard
		SQ.add(new Wait(9));
		SQ.add(new ShowDialog(false));
		SQ.add(new EnableInput(true));
		
		return SQ;
	}
	// restart
	private ActionSequence getRestartSQ() {
		var SQ = new ActionSequence();
		SQ.add(new ShowDialog(false));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.home)));
		SQ.add(new Sleep(characterList.get(ThingNames.jojo),placeList.get(ThingNames.home).getFurniture("Bed")));
		SQ.add(new SetCameraFocus(characterList.get(ThingNames.jojo)));
		SQ.add(new SetClothing(characterList.get(ThingNames.jojo),Clothing.Naked));
		SQ.add(new ShowMenu(true));
		return SQ;
	}
}

	
	

