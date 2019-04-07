<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<h1>Ubera Cabs</h1>
<hr>



<form:form commandName="cab" action="register.do">r
Number : <form:input path="cabNo"/> <form:errors path="cabNo" class="error"/> <br>
Type : <form:input path="type"/> <form:errors path="type" class="error"/> <br>
Location : <form:input path="location"/> <form:errors path="location" class="error"/> <br>
Cab Pricing : <form:input path="pricingPerHour"/> <form:errors path="pricingPerHour" class="error"/> <br>
<input type="submit" value="register"/>
<input type="reset" value="cancel"/>
</form:form>

<c:if test="${ not empty cabs}"> 
<h2> List of cabs </h2>
	<c:forEach  items="${cabs}" var="cab">
		Num - ${cab.cabNo } <br>
		Type - ${cab.type } <br>
		<br>
		<hr>
	</c:forEach>
</c:if>