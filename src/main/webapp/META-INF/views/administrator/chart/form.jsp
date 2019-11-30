<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<div>
	<canvas id="canvas"></canvas>
</div>

<script type ="text/javascript">
 $(document).ready(function()){
	 var CanvasCompany = document.getElementById("numberOfCompaniesGroupedBySector");
	 Chart.defaults.global.defaultFontFamily = "Lato";
	 Chart.defaults.global.defaultFontSize = 18;
	 
	 var DataCompany = {
			 labels : [
				 <jstl:forEach items = "${numberOfCompaniesGroupedBySector}" var="items">
				 "<jstl:out value= "${item[0]}" />" ,
				 </jstl:forEach>
			 ],
			 datasets:[
				 {
					 data: [
						 <jstl:forEach items= "${numberOfCompaniesGroupedBySector}" var="items">
						 "<jstl:out value = "${item[1]}" />"
						 </jstl:forEach>
					 ],
					 backgroundColor :["red", "green", "blue", "purple", "magenta"]
				 }
			 ]
	 };
	 var pieChartCompany = new Chart(CanvasCompany, {
		 type: 'pie',
		 data: DataCompany
	 });
	 
	 var CanvasInvestor = document.getElementById("numberOfInvestorGroupedBySector");
	 Chart.defaults.global.defaultFontFamily = "Lato";
	 Chart.defaults.global.defaultFontSize = 18;
	 
	 var DataInvestor = {
		 labels : [
			 <jstl:forEach items = "${numberOfInvestorGroupedBySector}" var="items">
			 "<jstl:out value= "${item[0]}" />" ,
			 </jstl:forEach>
		 ],
		 datasets:[
			 {
				 data: [
					 <jstl:forEach items= "${numberOfInvestorGroupedBySector}" var="items">
					 "<jstl:out value = "${item[1]}" />"
					 </jstl:forEach>
				 ],
				 backgroundColor :["red", "green", "blue", "purple", "magenta"]
			 }
		 ]
 };
	 var pieChartInvestor = new Chart(CanvasInvestor, {
		 type: 'pie',
		 data: DataInvestor
	 });
 };
</script>