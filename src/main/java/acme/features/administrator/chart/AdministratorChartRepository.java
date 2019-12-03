
package acme.features.administrator.chart;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorChartRepository extends AbstractRepository {

	@Query("select c.sector,count(c) FROM CompanyRecord c group by c.sector order by c.sector")
	Object[] findCompanySector();

	@Query("select c.sector,count(c) FROM InvestorRecord c group by c.sector order by c.sector")
	Object[] findInvestorSector();
}
