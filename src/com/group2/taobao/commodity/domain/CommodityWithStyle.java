package com.group2.taobao.commodity.domain;

public class CommodityWithStyle {
	private String commodity_with_style_id;
	private Commodity commodity;
	private CommodityStyle commodity_style;
	private int commodity_with_sum;
	public String getCommodity_with_style_id() {
		return commodity_with_style_id;
	}
	public void setCommodity_with_style_id(String commodity_with_style_id) {
		this.commodity_with_style_id = commodity_with_style_id;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public CommodityStyle getCommodity_style() {
		return commodity_style;
	}
	public void setCommodity_style(CommodityStyle commodity_style) {
		this.commodity_style = commodity_style;
	}
	public int getCommodity_with_sum() {
		return commodity_with_sum;
	}
	public void setCommodity_with_sum(int commodity_with_sum) {
		this.commodity_with_sum = commodity_with_sum;
	}
	public CommodityWithStyle() {
		super();
	}
	public CommodityWithStyle(String commodity_with_style_id, Commodity commodity, CommodityStyle commodity_style,
			int commodity_with_sum) {
		super();
		this.commodity_with_style_id = commodity_with_style_id;
		this.commodity = commodity;
		this.commodity_style = commodity_style;
		this.commodity_with_sum = commodity_with_sum;
	}
	@Override
	public String toString() {
		return "CommodityWithStyle [commodity_with_style_id=" + commodity_with_style_id + ", commodity=" + commodity
				+ ", commodity_style=" + commodity_style + ", commodity_with_sum=" + commodity_with_sum + "]";
	}
	
}
