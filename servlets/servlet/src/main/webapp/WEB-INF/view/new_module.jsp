<jsp:include page="header.jsp"/>
     <div class="container mt-4">
            <div class="card ">
                <div class="card-header">

                </div>
                <div class="card-body">
                        <div style="display: space-between;">
                         <a href="${pageContext.request.contextPath}/module?action=new_project&id=${id_training}">
                          
                            <button type="button" class="btn btn-outline-primary">+Ajouter un projet</button>
                         </a>
                         <a href="${pageContext.request.contextPath}/module?action=new_tutorial&id=${id_training}">
                          
                            <button type="button" class="btn btn-outline-primary">+Ajouter un tutoriel</button>
                         </a>
                         <a href="${pageContext.request.contextPath}/module?action=new_course&id=${id_training}">
                          
                            <button type="button" class="btn btn-outline-primary">+Ajouter un cours</button>
                         </a>
                        </div>
                        
                </div>
            </div>
        </div>
<jsp:include page="body.jsp"></jsp:include>