<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<form:form method="post"
           action="${pageContext.request.contextPath}/student/edit/save/${studentFormDTO.id}"
           modelAttribute="studentFormDTO">

    <!-- ================= GLOBAL ERRORS ================= -->
    <form:errors cssClass="alert alert-danger" element="div"/>

    <!-- ================= STUDENT ================= -->
    <h5>Student Details</h5>

    <div class="mb-3">
        <label>Student Name</label>
        <form:input path="studentName" class="form-control"/>
        <form:errors path="studentName" cssClass="text-danger"/>
    </div>

    <div class="mb-3">
        <label>Mobile Number</label>
        <form:input path="mobileNumber" type="number" class="form-control"/>
        <form:errors path="mobileNumber" cssClass="text-danger"/>
    </div>

    <!-- ================= CLUB ================= -->
    <h5 class="mt-4">Club</h5>
    <div class="mb-3">
        <label>Club Name</label>
        <form:input path="clubName" class="form-control"/>
        <form:errors path="clubName" cssClass="text-danger"/>
    </div>

    <!-- ================= SYLLABUS YEAR ================= -->
    <h5 class="mt-4">Syllabus Year</h5>
    <div class="mb-3">
        <label>Syllabus Year</label>
        <form:input path="syllabusYear" type="number" class="form-control"/>
        <form:errors path="syllabusYear" cssClass="text-danger"/>
    </div>

    <!-- ================= UNIVERSITY REGISTRATION ================= -->
    <h5 class="mt-4">University Registration</h5>
    <div class="mb-3">
        <label>University Registration Number</label>
        <form:input path="uniRegNumber" class="form-control"/>
        <form:errors path="uniRegNumber" cssClass="text-danger"/>
    </div>

    <!-- ================= AADHAAR ================= -->
    <h5 class="mt-4">Aadhaar</h5>
    <div class="mb-3">
        <label>Aadhaar Number</label>
        <form:input path="aadhaarNumber" type="number" class="form-control"/>
        <form:errors path="aadhaarNumber" cssClass="text-danger"/>
    </div>

    <!-- ================= ADDRESS ================= -->
    <h5 class="mt-4">Address</h5>
    <div class="mb-3">
        <label>Building Name</label>
        <form:input path="buildingName" class="form-control"/>
    </div>

    <!-- ================= CARE TAKER ================= -->
    <h5 class="mt-4">Care Taker</h5>
    <div class="mb-3">
        <label>Care Taker Person Name</label>
        <form:input path="careTakerPersonName" class="form-control"/>
    </div>

    <!-- ================= COURSES ================= -->
    <h5 class="mt-4">Courses</h5>
    <form:errors path="courseIds" cssClass="text-danger"/>
    <c:forEach items="${courses}" var="course">
        <div class="form-check">
            <form:checkbox path="courseIds"
                           value="${course.id}"
                           cssClass="form-check-input"/>
            <label class="form-check-label">
                ${course.courseName}
            </label>
        </div>
    </c:forEach>

    <!-- ================= SKILL DEVELOPMENT COURSES ================= -->
    <h5 class="mt-4">Skill Development Courses</h5>
    <c:forEach items="${skillDevelopmentCourses}" var="sdc">
        <div class="form-check">
            <form:checkbox path="skillDevelopmentCourseIds"
                           value="${sdc.id}"
                           cssClass="form-check-input"/>
            <label class="form-check-label">
                ${sdc.skillDevelopmentCourseName}
            </label>
        </div>
    </c:forEach>

    <!-- ================= SUBMIT ================= -->
    <div class="text-center mt-4">
        <button type="submit" class="btn btn-success px-5">
            Update Student
        </button>
    </div>

</form:form>