package springmvcsecurity.dao;

import java.util.List;

import springmvcsecurity.model.UserProfile;
 
 
public interface UserProfileDao {
 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}
