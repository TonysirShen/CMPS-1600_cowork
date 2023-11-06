import com.storygraph.*;

public class MainClass {
	public static void main(String[] args) throws Exception {
		try {
		System.out.println("Hello");
		var story = new ShortStory_main();
		var graph = new Graph();
		var currentNode = story.getRoot();
		var map = story.getMap();
		while(true) {
			currentNode = graph.traverse(currentNode, map);
			if(currentNode==null)
				break;
		}
		System.out.println("Bye");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
