package org.life.dao;

import java.util.List;

import org.life.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{
	
	User save(User user);
	User getById(Long id);
	void delete(Long id);
	List<User> findAll();
	User findByUserId(String userId); 
	
	/*UserSearchResult getUserAssoc(long id, long domainId);

	List<UserSearchResult> search(UserSearchCriteria criteria);
	
	int count(UserSearchCriteria criteria);
	
	public List<UserSearchResult> findRange(UserSearchCriteria criteria,int[] range);
	
	List<MentorUpdates> getDailyUpdates(long userId, long domainId);

	List<MentorUpdates> getLastUpdate(long userId, long domainId);

	List<MentorUpdates> viewUpdateHistory(long userId, long domainId,
			Date startDate, Date endDate, String keyWord);*/
	/*List<Customer> findByEmail(String email);

    List<Customer> findByDate(Date date);

	// custom query example and return a stream
    @Query("select c from Customer c where c.email = :email")
    Stream<Customer> findByEmailReturnStream(@Param("email") String email);
	*/
};


