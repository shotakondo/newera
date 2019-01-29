package dao;

import java.util.List;

public interface FavoriteDao{
	
	public List getFavorites(String email);
	public void setFavorite(String pid, String email);
	
}