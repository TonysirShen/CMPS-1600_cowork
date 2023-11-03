import com.storygraph.ActionMap;

import com.storygraph.INode;
import com.storygraph.Node;

//import ShortStory_main.NodeLabels;

import java.util.Hashtable;

import com.actions.*;
import com.entities.*;
import com.entities.Character;
import com.entities.Character.Clothing;
import com.entities.IThing.ThingNames;
import com.entities.Item.Items;
import com.entities.Place.Places;
import com.playerInput.ActionChoice;
import com.playerInput.ActionChoice.Icons;
import com.playerInput.PositionChoice;
import com.playerInput.PositionChoice.Condition;
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
		GameOVER, GreatHall, JailGameOver, StartJailQuest, ClothGameOverLeave, ClothGameOverSteal, MerchantTalk, ClothPort, ReturnToCity,
		cityarrest, peasantclothing
	}
	
	public void ShortStory_main() {
		getThings();
	}

	@Override
	public ActionMap getMap() {
		// TODO Auto-generated method stub
		var map=new ActionMap();
		map.add(NodeLabels.Init.toString(), getInitSQ());
		map.add(NodeLabels.Start.toString(), getStartSQ());
		map.add(NodeLabels.Cottage.toString(), getCottageSQ());
		map.add(NodeLabels.City.toString(), getCitySQ());
		
		map.add(NodeLabels.CastleCrossRoad.toString(), getCastleCrossRoadSQ());
		map.add(NodeLabels.Getsword.toString(), getGetswordSQ());
		map.add(NodeLabels.Sword_city.toString(), getSword_citySQ());
		map.add(NodeLabels.swordBlackSmith.toString(), getswordBlackSmithSQ());
		
		map.add(NodeLabels.TalktoBlacksmith2.toString(), getTalktoBlacksmith2SQ());
		map.add(NodeLabels.gethelmet2.toString(), getgethelmet2SQ());
		map.add(NodeLabels.successSpookyRoad.toString(), getsuccessSpookyRoadSQ());
		map.add(NodeLabels.BanditSubmit.toString(), getBanditSubmitSQ());
		
		map.add(NodeLabels.Dungeon.toString(), getDungeonSQ());
		map.add(NodeLabels.FightWithWarlock.toString(), getFightWithWarlockSQ());
		map.add(NodeLabels.Blacksmith.toString(), getBlacksmithSQ());
		map.add(NodeLabels.getHelmet.toString(), getgetHelmetSQ());
		
		map.add(NodeLabels.helmetCity.toString(), gethelmetCitySQ());
		map.add(NodeLabels.helmetCrossroad.toString(), gethelmetCrossroadSQ());
		map.add(NodeLabels.helmetGreatHall.toString(), gethelmetGreatHallSQ());
		map.add(NodeLabels.helmetGetSword.toString(), gethelmetGetSwordSQ());
		
		map.add(NodeLabels.failSpookyRoad.toString(), getfailSpookyRoadSQ());
		map.add(NodeLabels.BanditWin.toString(), getBanditWinSeQ());
		map.add(NodeLabels.GuardCamp.toString(), getGuardCampSQ());
		map.add(NodeLabels.GetSwordHelmet.toString(), getGetSwordHelmetSQ());
		
		map.add(NodeLabels.GameOVER.toString(), getGameOVERSQ());
		map.add(NodeLabels.GreatHall.toString(), getGreatHallSQ());
		map.add(NodeLabels.JailGameOver.toString(), getJailGameOverSQ());
		map.add(NodeLabels.StartJailQuest.toString(), getStartJailQuestSQ());
		
		map.add(NodeLabels.ClothGameOverLeave.toString(), getClothGameOverLeaveSQ());
		map.add(NodeLabels.ClothGameOverSteal.toString(), getClothGameOverStealSQ());
		map.add(NodeLabels.MerchantTalk.toString(), getMerchantTalkSQ());
		map.add(NodeLabels.ClothPort.toString(), getClothPortSQ());
		
		map.add(NodeLabels.ReturnToCity.toString(), getReturnToCitySQ());
		map.add(NodeLabels.cityarrest.toString(), getcityarrestSQ());
		map.add(NodeLabels.peasantclothing.toString(), getpeasantclothingSQ());
		
		
		
		return map;
		
		
	}

	@Override
	public INode getRoot() {
		var cityarrest = new Node(NodeLabels.cityarrest.toString());
		var jailgameover = new Node(NodeLabels.JailGameOver.toString());
		var startjailquest = new Node(NodeLabels.StartJailQuest.toString());
		var clothgameoverleave = new Node(NodeLabels.ClothGameOverLeave.toString());
		var clothgameoversteal = new Node(NodeLabels.ClothGameOverSteal.toString());
		var merchanttalk = new Node(NodeLabels.MerchantTalk.toString());
		var clothport = new Node(NodeLabels.ClothPort.toString());
		var returntocity = new Node(NodeLabels.ReturnToCity.toString());
		var city = new Node(NodeLabels.City.toString());
		var castlecrossroad = new Node(NodeLabels.CastleCrossRoad.toString());
		var greathall = new Node(NodeLabels.GreatHall.toString());
		var getsword = new Node(NodeLabels.Getsword.toString());
		var swordcity = new Node(NodeLabels.Sword_city.toString());
		var swordblacksmith = new Node(NodeLabels.swordBlackSmith.toString());
		var talktoblacksmith2 = new Node(NodeLabels.TalktoBlacksmith2.toString());
		var gethelmet2 = new Node(NodeLabels.gethelmet2.toString());
		var successspookyroad = new Node(NodeLabels.successSpookyRoad.toString());
		var banditsubmit = new Node(NodeLabels.BanditSubmit.toString());
		var dungeon = new Node(NodeLabels.Dungeon.toString());
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

		
		
		//child
		cityarrest.addChild(new ActionChoice("Guard",
				characterList.get(ThingNames.guard),
				Icons.draw,
				"Fight with Guard",
				true), jailgameover);
		cityarrest.addChild(new ActionChoice("Guard",
				characterList.get(ThingNames.guard),
				Icons.talk,
				"Talk to Guard",
				true), startjailquest);

		
		startjailquest.addChild(new ActionChoice("Cloth",
				itemList.get(ThingNames.Bluecloth),
				Icons.hand,
				"Steal the cloth",
				true), clothgameoversteal);
		startjailquest.addChild(new ActionChoice("Merchant",
				characterList.get(ThingNames.merchant),
				Icons.talk,
				"Talk to the merchant",
				true), clothport);
		
		clothport.addChild(new PositionChoice(
				characterList.get(ThingNames.jojo),
				"Port.Exit", Condition.arrived), clothgameoverleave);
		
		
		clothport.addChild(new ActionChoice("Beggar",
				characterList.get(ThingNames.guard),
				Icons.talk,
				"Give to beggar",
				true), returntocity);
		returntocity.addChild(new ActionChoice("Exit",
				placeList.get(ThingNames.Port).getFurniture("Exit"),
				Icons.exit,
				"Return to the city",
				true), city);
		
		//right side
		blacksmith.addChild(new ActionChoice("Blacksmith",
				characterList.get(ThingNames.blacksmith),
				Icons.talk,
				"Talk to blacksmith",
				true), gethelmet);
		
		gethelmet.addChild(new PositionChoice(
				characterList.get(ThingNames.jojo),
				"Blacksmith.Door", Condition.arrived), helmetcity);
		helmetcity.addChild(new PositionChoice(
				characterList.get(ThingNames.jojo),
				"City.WestEnd", Condition.arrived), failspookyroad);
		helmetcity.addChild(new PositionChoice(
				characterList.get(ThingNames.jojo),
				"City.EastEnd", Condition.arrived), helmetcrossroad);
		
		helmetcrossroad.addChild(new PositionChoice(
				characterList.get(ThingNames.jojo),
				"CastleCrossroad.Gate", Condition.arrived), helmetgreathall);
		helmetgetsword.addChild(new PositionChoice(
				characterList.get(ThingNames.jojo),
				"GreatHall.Gate", Condition.arrived), successspookyroad);
		
		
		
		
		return new Node("root");
		
		

		
		
		
		
	}

	@Override
	public void getThings() {
		
		//GUARD 2
		characterList.put(ThingNames.guard,new Character(ThingNames.guard2));
		
		
		
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
	
	
	//GET CITY ADD GUARD2
	
	private ActionSequence getCitySQ() {
		var SQ = new ActionSequence();
		SQ.add(new FadeOut(true));
		SQ.combineWith(new CharacterCreation(characterList.get(ThingNames.guard2)));
		SQ.add(new Create<Place>(placeList.get(ThingNames.city)));
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.city)));
		SQ.add(new FadeOut(false));
		SQ.add(new SetCameraFocus(characterList.get(ThingNames.guard)));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Did you hear what happened? The warlock is running rampant at the ruins. The king wants him to be stopped."));
		SQ.add(new ShowDialog(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Wow that sounds bad. If someone is able to stop him, he will become famous forever."));
		SQ.add(new ShowDialog(false));
		SQ.add(new SetCameraFocus(characterList.get(ThingNames.jojo)));
		SQ.add(new EnableInput(true));
		return SQ;
	}
	
	//Action Sequence
	//Right Side
	
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
		SQ.add(new Position(characterList.get(ThingNames.jojo),placeList.get(ThingNames.castlecrossroad)));
		SQ.add(new FadeOut(false));
		SQ.add(new ShowDialog(true));
		SQ.add(new SetDialog("Lets go meet the King and grab the sword. Then we can fight the warlock."));
		SQ.add(new ShowDialog(false));
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

	

	
		
