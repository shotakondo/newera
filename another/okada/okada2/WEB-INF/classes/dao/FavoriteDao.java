package dao;

import java.util.List;

public interface FavoriteDao{
	
	public List getFavorites(String id);
	public void setFavorite(String id, String pid);
	public void deleteFavorite(String id, String pid);
	public void alterFavorite(String id, String pid);
	
}