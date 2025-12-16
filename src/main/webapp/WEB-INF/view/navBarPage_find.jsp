<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<div class="container mt-4">



    <!-- ================= SEARCH FORM ================= -->
    <form method="get"
          action="${pageContext.request.contextPath}/student/find"
          onsubmit="return redirectToStudent();">

        <div class="row align-items-end">
            <div class="col-md-4">
                <label class="form-label">Student ID</label>
                <input type="number"
                       id="studentId"
                       class="form-control"
                       placeholder="Enter Student ID"
                       required />
            </div>

            <div class="col-md-2">
                <button type="submit"
                        class="btn btn-primary mt-4">
                    Find
                </button>
            </div>
        </div>

    </form>

    <!-- ================= ERROR MESSAGE ================= -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger mt-4">
            ${errorMessage}
        </div>
    </c:if>

</div>

<script>
    function redirectToStudent() {
        const id = document.getElementById("studentId").value;
        if (!id) return false;

        const base = "${pageContext.request.contextPath}";
        window.location.href = base + "/student/find/" + id;
        return false;
    }
</script>