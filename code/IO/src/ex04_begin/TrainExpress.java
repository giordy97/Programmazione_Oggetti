package ex04_begin;

public class TrainExpress extends Train {
	protected int restaurantPlaces;
	
	public TrainExpress(Station start, Station end, String starttime, String endtime, int km, int places) {
		super(start, end, starttime, endtime, km, places);
		this.restaurantPlaces = 50;
	}
	
	public int getRestaurantPlaces() {
		return restaurantPlaces;
	}

	public void setRestaurantPlaces(int restaurantPlaces) {
		this.restaurantPlaces = restaurantPlaces;
	}
	
	public float getMaxMoney() {
		return (places * priceKmExpress + restaurantPlaces * priceKmRestaurant) * km;
	}
	
	public String toString() {
		StringBuffer out = new StringBuffer(super.toString());
		out.append(Integer.toString(this.getRestaurantPlaces()) + ",");
		return out.toString();
	}

}
