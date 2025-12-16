<form action="${pageContext.request.contextPath}/student/edit/load" method="get">
    <div class="mb-3">
        <label>Student ID</label>
        <input type="number" name="id" class="form-control" required/>
    </div>

    <button class="btn btn-primary">Load Student</button>
</form>