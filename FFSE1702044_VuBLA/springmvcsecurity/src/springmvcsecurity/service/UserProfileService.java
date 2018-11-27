package springmvcsecurity.service;

import java.util.List;

import springmvcsecurity.model.UserProfile;

public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);

	List<UserProfile> findAll();
}