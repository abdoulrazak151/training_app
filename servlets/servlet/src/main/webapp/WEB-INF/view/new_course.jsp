<jsp:include page="header.jsp"/>
     <div class="container mt-4">
            <div class="card ">
                <div class="card-header">
                <c:if test="${! empty errorMessage}"><p style="color: red;">les infromations ne sont pas correctes</p></c:if>
                </div>
                <div class="card-body">
                <form action="${pageContext.request.contextPath}/module?action=create_course" method="post">

                    <input type="hidden" name="id" value="${id_training}">
            <div class="input-group mb-3">
                      <span class="input-group-text" id="basic-addon1">Training Name</span>
                      <input type="text" class="form-control" placeholder="name" name="name_course" aria-label="name" aria-describedby="basic-addon1">
                </div>_
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">description</span>
                    <input type="text" class="form-control" placeholder="description" name="description_course" aria-label="name" aria-describedby="basic-addon1">
              </div>
              <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">number of student</span>
                <input type="number" class="form-control" placeholder="name" name="number_student_course" aria-label="name" aria-describedby="basic-addon1" min 0>
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">duration</span>
            <input type="text" class="form-control" placeholder="name" name="duration_course" aria-label="name" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">number of group</span>
                <input type="number" class="form-control" placeholder="name" name="classroom" aria-label="name" aria-describedby="basic-addon1" min 0>
          </div>

                <div class="col-12">
                <button class="btn btn-primary" type="submit">enregistrer</button>
                </div>
            </div>
        </div>
<jsp:include page="body.jsp"></jsp:include>