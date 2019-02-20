package dao;

import java.util.List;

public interface FavoriteDao{
	
	public List getFavorites(String uid);
	public void setFavorite(String uid, String pid);
	public void deleteFavorite(String uid, String pid);
	public void alterFavorite(String uid, String pid, String comment);
	
}