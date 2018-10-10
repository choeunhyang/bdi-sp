package com.bdi.sp.vo;

import org.apache.ibatis.type.Alias;

@Alias("Board")
public class Board {
	private Integer binum;
	private String bititle;
	private String bitext;
	private String bifile;
	private String bicredate;
	private String bimoddat;
	private Integer bicnt;
	private Integer biactive;
	private Integer uinum;
	
	public Board() {
		
	}
	@Override
	public String toString() {
		return "Board [binum=" + binum + ", bititle=" + bititle + ", bitext=" + bitext + ", bifile=" + bifile
				+ ", bicredate=" + bicredate + ", bimoddat=" + bimoddat + ", bicnt=" + bicnt + ", biactive=" + biactive
				+ ", uinum=" + uinum + "]";
	}
	public Integer getBinum() {
		return binum;
	}
	public void setBinum(Integer binum) {
		this.binum = binum;
	}
	public String getBititle() {
		return bititle;
	}
	public void setBititle(String bititle) {
		this.bititle = bititle;
	}
	public String getBitext() {
		return bitext;
	}
	public void setBitext(String bitext) {
		this.bitext = bitext;
	}
	public String getBifile() {
		return bifile;
	}
	public void setBifile(String bifile) {
		this.bifile = bifile;
	}
	public String getBicredate() {
		return bicredate;
	}
	public void setBicredate(String bicredate) {
		this.bicredate = bicredate;
	}
	public String getBimoddat() {
		return bimoddat;
	}
	public void setBimoddat(String bimoddat) {
		this.bimoddat = bimoddat;
	}
	public Integer getBicnt() {
		return bicnt;
	}
	public void setBicnt(Integer bicnt) {
		this.bicnt = bicnt;
	}
	public Integer getBiactive() {
		return biactive;
	}
	public void setBiactive(Integer biactive) {
		this.biactive = biactive;
	}
	public Integer getUinum() {
		return uinum;
	}
	public void setUinum(Integer uinum) {
		this.uinum = uinum;
	}
	public Board(Integer binum, String bititle, String bitext, String bifile, String bicredate, String bimoddat,
			Integer bicnt, Integer biactive, Integer uinum) {
		super();
		this.binum = binum;
		this.bititle = bititle;
		this.bitext = bitext;
		this.bifile = bifile;
		this.bicredate = bicredate;
		this.bimoddat = bimoddat;
		this.bicnt = bicnt;
		this.biactive = biactive;
		this.uinum = uinum;
	}
}
