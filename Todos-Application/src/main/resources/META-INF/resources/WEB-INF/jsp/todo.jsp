
	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
	<%@ include file="common/footer.jspf" %>

	
	<div class="container">
		<h1>Welcome ${name}!</h1>
		<hr>	
		<form:form method="post" modelAttribute="todo">
			
			<fieldset class="mb-3">
				<form:label path="description">Description </form:label>
				<form:input type="text" path="description" required="required" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="target">Target Date</form:label>
				<form:input type="text" path="target" required="required" />
			</fieldset>


			<form:input type="hidden" path="done" value="false" />
			<form:input type="hidden" path="id" value="0" />
			<input class="btn btn-success" type="submit">
		</form:form>
	</div>
<script type="text/javascript">
		$('#target').datepicker({
		    format: 'yyyy/mm/dd'
		});
	</script>