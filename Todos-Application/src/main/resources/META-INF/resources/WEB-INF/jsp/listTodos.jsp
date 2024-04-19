
	
	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
	<%@ include file="common/footer.jspf" %>
	
	<div class="container">
		<h1>Welcome ${name}!</h1>
		<hr>	
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>	
		<tbody>
			<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.description}</td>
				<td>${todo.target}</td>
				<td>${todo.done}</td>
				<td><a href="deleteTodo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
				<td><a href="editTodo?id=${todo.id}" class="btn btn-success">Update</a></td>
			</tr>
			</c:forEach>
		
		</tbody>
		</table>
		<a href="addTodo" class="btn btn-success">Add</a>
	</div>
