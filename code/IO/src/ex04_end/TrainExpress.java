package ex04_end;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class TrainExpress extends Train {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public byte[] toByteArray() throws IOException {
		// Here trains build a byte-oriented representation of themselves
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(byteArray);

		out.write(super.toByteArray());
		out.writeInt(getRestaurantPlaces());
		return byteArray.toByteArray();
	}

}
