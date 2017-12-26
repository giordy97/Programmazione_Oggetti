package Shop;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Shop<T> implements Iterable<T> {
	private LinkedList<T> l;
	
	public Shop() {
		l = new LinkedList<T>();
	}
	
	T sell() {
		return l.removeLast();
	}
	
	void buy(T item) {
		l.addFirst(item);
	}
	
	void sell(List<? super T> items, int nItems) {
		for (int i = 0; i < nItems; i++) {
			items.add(l.removeLast());
		}
	}
	
	void buy(List<? extends T> items) {
		for (T item : items) {
			l.add(item);
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return l.iterator();
	}
	
	public static void main(String[] args) {
		
		// CASE1: Simple operations working!
		Shop<Fruit> fruitShop = new Shop<Fruit>();
		fruitShop.buy(new Fruit());
		System.out.println(fruitShop.sell());
		
		Shop<Vegetable> veggieShop = new Shop<Vegetable>();
		veggieShop.buy(new Vegetable());
		System.out.println(veggieShop.sell());
		
		// CASE2: Simple sub-typing working!
		Shop<Product> shop = new Shop<Product>();
		shop.buy(new Vegetable());
		
		veggieShop.buy(new Vegetable());
		Product product = veggieShop.sell();
		
		// CASE3: Collection sub-typing working!
		List<Fruit> lmp = new ArrayList<Fruit>();
		lmp.add(new Fruit());
		lmp.add(new Fruit());
		lmp.add(new Fruit());
		shop.buy(lmp);
		
		for (Product p : shop) {
			System.out.println(p);
		}
		
		fruitShop.buy(new Fruit());
		fruitShop.buy(new Fruit());
		fruitShop.buy(new Fruit());
		List<Product> lm = new ArrayList<Product>();
		fruitShop.sell(lm, 3);
		
		for (Product p : lm) {
			System.out.println(p);
		}
	}
}
