<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<h1>Ubera Cabs</h1>
<hr>

<form action="listRides.do" method="get">
Location :- <input type="text" name="location"/>
<input type="submit">
</form>

<c:if test="${ not empty cabs}">
<h2> List of cabs </h2>
	<c:forEach  items="${cabs}" var="cab">
		Num - ${cab.cabNo } <br>
		Type - ${cab.type } <br>
		<br>
		<hr>
	</c:forEach>
</c:if>