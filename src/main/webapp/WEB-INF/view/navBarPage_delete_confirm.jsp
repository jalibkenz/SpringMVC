<h5 class="text-danger">Confirm Delete</h5>

<p>
    Are you sure you want to delete the following student?
</p>

<ul>
    <li><strong>ID:</strong> ${student.id}</li>
    <li><strong>Name:</strong> ${student.studentName}</li>
    <li><strong>Mobile:</strong> ${student.mobileNumber}</li>
</ul>

<form method="post"
      action="${pageContext.request.contextPath}/student/delete/${student.id}">
    <button type="submit" class="btn btn-danger">
        Confirm Delete
    </button>
    <a href="${pageContext.request.contextPath}/student/find"
       class="btn btn-secondary">
        Cancel
    </a>
</form>