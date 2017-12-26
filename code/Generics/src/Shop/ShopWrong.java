package Shop;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ShopWrong<T> implements Iterable<T> {
	private LinkedList<T> l;
	
	public ShopWrong() {
		l = new LinkedList<T>();
	}
	
	T sell() {
		return l.removeLast();
	}
	
	void buy(T item) {
		l.addFirst(item);
	}
	
	void sell(List<T> items, int nItems) {
		for (int i = 0; i < nItems; i++) {
			items.add(l.removeLast());
		}
	}
	
	void buy(List<T> items) {
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
		ShopWrong<Fruit> fruitShop = new ShopWrong<Fruit>();
		fruitShop.buy(new Fruit());
		System.out.println(fruitShop.sell());
		
		ShopWrong<Vegetable> veggieShop = new ShopWrong<Vegetable>();
		veggieShop.buy(new Vegetable());
		System.out.println(veggieShop.sell());
		
		// CASE2: Simple sub-typing working!
		ShopWrong<Product> shop = new ShopWrong<Product>();
		shop.buy(new Vegetable());
		
		veggieShop.buy(new Vegetable());
		Product product = veggieShop.sell();
		
		// CASE3: Collection sub-typing NOT working!
		List<Fruit> lmp = new ArrayList<Fruit>();
		lmp.add(new Fruit());
		lmp.add(new Fruit());
		lmp.add(new Fruit());
		
		// compile error if uncommented
		// shop.buy(lmp);
		
		for (Product p : shop) {
			System.out.println(p);
		}
		
		fruitShop.buy(new Fruit());
		fruitShop.buy(new Fruit());
		fruitShop.buy(new Fruit());
		List<Product> lm = new ArrayList<Product>();
		// compile error if uncommented
		// fruitShop.sell(lm, 3);
		
		for (Product p : lm) {
			System.out.println(p);
		}
	}
}
