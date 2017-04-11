package com.fixit.core.data.sql;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fixit.core.data.sql.Review.ReviewPK;

@Entity
@Table(name = "Review")
@IdClass(ReviewPK.class)
public class Review implements SqlModelObject<ReviewPK> {
	
	@Id
	private String userId;
	
	@Id
	private String tradesmanId;
	
	private String title;
	
	private String content;
	
	private Float rating;
	
	private Boolean isOnDisplay;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	public Review() { }

	public Review(String userId, String tradesmanId, String title, String content, Float rating, Boolean isOnDisplay) {
		this.userId = userId;
		this.tradesmanId = tradesmanId;
		this.title = title;
		this.content = content;
		this.rating = rating;
		this.isOnDisplay = isOnDisplay;
		this.createdAt = new Date();
	}

	@Override
	public ReviewPK getId() {
		return new ReviewPK(userId, tradesmanId);
	}

	@Override
	public void setId(ReviewPK id) {
		this.userId = id.userId;
		this.tradesmanId = id.tradesmanId;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTradesmanId() {
		return tradesmanId;
	}

	public void setTradesmanId(String tradesmanId) {
		this.tradesmanId = tradesmanId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Boolean getIsOnDisplay() {
		return isOnDisplay;
	}

	public void setIsOnDisplay(Boolean isOnDisplay) {
		this.isOnDisplay = isOnDisplay;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Review [userId=" + userId + ", tradesmanId=" + tradesmanId + ", title=" + title + ", content=" + content
				+ ", rating=" + rating + ", isOnDisplay=" + isOnDisplay + ", createdAt=" + createdAt + "]";
	}

	public static class ReviewPK implements Serializable {
		private static final long serialVersionUID = 9145627955297133232L;
		
		protected String userId;
		protected String tradesmanId;
		
		public ReviewPK() { }
		
		public ReviewPK(String userId, String tradesmanId) {
			this.userId = userId;
			this.tradesmanId = tradesmanId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((tradesmanId == null) ? 0 : tradesmanId.hashCode());
			result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
			ReviewPK other = (ReviewPK) obj;
			if (tradesmanId == null) {
				if (other.tradesmanId != null)
					return false;
			} else if (!tradesmanId.equals(other.tradesmanId))
				return false;
			if (userId == null) {
				if (other.userId != null)
					return false;
			} else if (!userId.equals(other.userId))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "ReviewPK [userId=" + userId + ", tradesmanId=" + tradesmanId + "]";
		}
		
	}

}
