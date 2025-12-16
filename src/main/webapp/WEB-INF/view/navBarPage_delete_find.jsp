<form method="get"
      onsubmit="location.href='${pageContext.request.contextPath}/student/delete/confirm/' + document.getElementById('sid').value; return false;">
    <label>Student ID</label>
    <input id="sid" type="number" class="form-control" required />
    <button class="btn btn-danger">Load Student</button>
</form>