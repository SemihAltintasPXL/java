package be.pxl.hotel.api.response;

public class BuildingPlotDTO {
	private long id;
	private double price;
	private int maxBuildings;
	private boolean sold;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMaxBuildings() {
		return maxBuildings;
	}

	public void setMaxBuildings(int maxBuildings) {
		this.maxBuildings = maxBuildings;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}
}
