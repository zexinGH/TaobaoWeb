package com.group2.taobao.commodity.domain;

public class CommodityStyle {
	private String commodity_style_id;
	private String commodity_style_color;
	private int commodity_style_size;
	public String getCommodity_style_id() {
		return commodity_style_id;
	}
	public void setCommodity_style_id(String commodity_style_id) {
		this.commodity_style_id = commodity_style_id;
	}
	public String getCommodity_style_color() {
		return commodity_style_color;
	}
	public void setCommodity_style_color(String commodity_style_color) {
		this.commodity_style_color = commodity_style_color;
	}
	public int getCommodity_style_size() {
		return commodity_style_size;
	}
	public void setCommodity_style_size(int commodity_style_size) {
		this.commodity_style_size = commodity_style_size;
	}
	
	public CommodityStyle() {
		super();
	}
	public CommodityStyle(String commodity_style_id, String commodity_style_color, int commodity_style_size) {
		super();
		this.commodity_style_id = commodity_style_id;
		this.commodity_style_color = commodity_style_color;
		this.commodity_style_size = commodity_style_size;
	}
	@Override
	public String toString() {
		return "CommodityStyle [commodity_style_id=" + commodity_style_id + ", commodity_style_color="
				+ commodity_style_color + ", commodity_style_size=" + commodity_style_size + "]";
	}
	
}
