package com.blog.bean;

public class Collect {
	private int collectionid;         //收藏ID
	private int userid;             //用户收藏id
	private int blogid;                //收藏博客ID
	private String collectiondate;    //收藏日期
	
	@Override
	public String toString() {
		return "Collect [collectionid=" + collectionid + ", userid=" + userid + ", blogid=" + blogid
				+ ", collectiondate=" + collectiondate + "]";
	}

	public int getCollectionid() {
		return collectionid;
	}

	public void setCollectionid(int collectionid) {
		this.collectionid = collectionid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	public String getcollectiondate() {
		return collectiondate;
	}

	public void setcollectiondate(String stringcollectiondate) {
		collectiondate = stringcollectiondate;
	}

	public Collect(int collectionid, int userid, int blogid, String stringcollectiondate) {
		super();
		this.collectionid = collectionid;
		this.userid = userid;
		this.blogid = blogid;
		collectiondate = stringcollectiondate;
	}

	public Collect() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collect(String valueOf, Object object) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collectiondate == null) ? 0 : collectiondate.hashCode());
		result = prime * result + blogid;
		result = prime * result + collectionid;
		result = prime * result + userid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Collect other = (Collect) obj;
		if (collectiondate == null) {
			if (other.collectiondate != null)
				return false;
		} else if (!collectiondate.equals(other.collectiondate))
			return false;
		if (blogid != other.blogid)
			return false;
		if (collectionid != other.collectionid)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	
}
