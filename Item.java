package midterm.model;

public class Item implements Comparable<Item> {

	String name;
	
	String  store;
	
	final int   id;
	
	public Item() {
		
		name = "";
		
		store = "";
		
		id = 0;
	}
	
	public Item(String name, String store, int itemID) {
		
		this.name = name;
		
		this.store = store;
		
		this.id = itemID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public int getId() {
		return id;
	}
	
	@Override
    public int compareTo(Item compareItem) {
		
		String store = compareItem.getStore();
		
		return 0 - store.compareTo(this.store);
	}
	
	
}
