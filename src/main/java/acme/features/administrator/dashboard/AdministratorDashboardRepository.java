
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("SELECT count(*) FROM Announcement")
	Integer getTotalAnnouncements();

	@Query("SELECT count(*) FROM CompanyRecord")
	Integer getTotalCompanyRecords();

	@Query("SELECT count(*) FROM InvestorRecord")
	Integer getTotalInvestorRecords();

	@Query("SELECT count(*) FROM Requesta WHERE deadline>= CURRENT_DATE")
	Integer getActiveRequests();

	@Query("SELECT min(reward.amount) FROM Requesta WHERE deadline>= CURRENT_DATE")
	Double getMinRewardRequesta();

	@Query("SELECT max(reward.amount) FROM Requesta WHERE deadline>= CURRENT_DATE")
	Double getMaxRewardRequesta();

	@Query("SELECT avg(reward.amount) FROM Requesta WHERE deadline>= CURRENT_DATE")
	Double getAvgRewardRequesta();

	@Query("SELECT stddev(reward.amount) FROM Requesta WHERE deadline>= CURRENT_DATE")
	Double getStandardRewardRequesta();

	@Query("SELECT count(*) FROM Offer WHERE deadline>= CURRENT_DATE")
	Integer getActiveOfferts();

	@Query("SELECT min(minReward.amount) FROM Offer WHERE deadline>= CURRENT_DATE")
	Double getMinRewardOffer();

	@Query("SELECT max(maxReward.amount) FROM Offer WHERE deadline>= CURRENT_DATE")
	Double getMaxRewardOffer();

	@Query("SELECT avg(minReward.amount) FROM Offer WHERE deadline>= CURRENT_DATE")
	Double getAvgMinRewardOffer();

	@Query("SELECT avg(maxReward.amount) FROM Offer WHERE deadline>= CURRENT_DATE")
	Double getAvgMaxRewardOffer();

	@Query("SELECT stddev(minReward.amount) FROM Offer WHERE deadline>= CURRENT_DATE")
	Double getStandardMinRewardOffer();

	@Query("SELECT stddev(maxReward.amount) FROM Offer WHERE deadline>= CURRENT_DATE")
	Double getStandardMaxRewardOffer();
}
