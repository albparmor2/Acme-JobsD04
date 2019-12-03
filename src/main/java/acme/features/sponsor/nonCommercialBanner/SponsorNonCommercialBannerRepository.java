
package acme.features.sponsor.nonCommercialBanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.banners.NonCommercialBanner;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SponsorNonCommercialBannerRepository extends AbstractRepository {

	@Query("select a from NonCommercialBanner a where a.id = ?1")
	NonCommercialBanner findOneById(int id);

	@Query("select a from NonCommercialBanner a")
	Collection<NonCommercialBanner> findManyAll();
}
